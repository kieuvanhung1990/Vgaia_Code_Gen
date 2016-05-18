/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.nec.frw1000.pr.component.InputComponentIF;
import jp.co.nec.inf3000.pr.Inf30S108101Frame;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700ResultData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_01InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_01ResultData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02ResultData;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Ipo5700Confirm Class's Description <br>
 * Confirm State process of ComTNorm Class.
 * 
 * <p>
 * Handle the "Confirm State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/01/20 Create New
 */
public class Ipo5700Confirm extends Frw00AbstractBusinessState {

	// //////// Class Variables //////////

	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.ipo.ipo5700.Ipo5700Control";
	/** Process method name of AP side */
	private static final String PROCESS_METHOD_NAME = "doTask";

	/** panel in main frame */
	private Ipo5700Panel clientArea;

	/** Panel 1 */
	private Ipo5700_01Panel panel01;

	/** Panel 2 */
	private Ipo5700_02Panel panel02;

	// //////// Methods define //////////

	/**
	 * Return control class name to AP side. <br>
	 * 
	 * @param Nothing
	 * @return String Control class name
	 * @exception nothing
	 */
	public String getBusinessClassName() {

		return BUSINESS_CLASS_NAME;
	}

	/**
	 * Return process method name of the AP side. <br>
	 * 
	 * @param Nothing
	 * @return String
	 * @exception Nothing
	 */
	public String getProcessMethodName() {

		return PROCESS_METHOD_NAME;
	}

	/**
	 * Return the default focus component. <br>
	 * <p>
	 * Set the first component want to focus when display screen.
	 * </p>
	 * 
	 * @param Nothing
	 * @return default focus component
	 * @exception Nothing
	 */
	public Component getDefaultFocusComponent() {
		// Get client Area
		Ipo5700Panel clientArea = (Ipo5700Panel) getClientPanel();

		// Return control default
		return clientArea.txtId;
	}

	/**
	 * Return enabled function key. <br>
	 * 
	 * @param Nothing
	 * @return int Enabled function key
	 * @exception Frw10ClientException
	 */
	public int getEnabledFunction() throws Frw10ClientException {
		// Return default function key
		return Frw00FunctionKey.FUNCTION_DEFAULT;
	}

	/**
	 * Render the input data and send to AP side. <br>
	 * <p>
	 * Set value for input data class.
	 * </p>
	 * 
	 * @param Nothing
	 * @return Frw00InputData The input data class
	 * @exception Frw10ClientException
	 *                throw when have a exception while reading client
	 *                component.
	 */
	public Frw00InputData getSendData() throws Frw10ClientException {
		// Get input data from screen to client area
		getPanels();

		// Create instance of input data class
		Ipo5700InputData inputData = new Ipo5700InputData();

		// Set the input data with the value from input component of client area
		Frw10ServerDataProc.getInputData(clientArea, inputData);

		// Set the input data with tab 1
		Ipo5700_01InputData inputData01 = new Ipo5700_01InputData();
		Frw10ServerDataProc.getInputData(clientArea.pnlSub1, inputData01);
		inputData.setInputData01(inputData01);

		// Set InputData tab 2
		List<?> dataList02 = null;
		dataList02 = clientArea.pnlSub2.tblDataList.getData();
		Ipo5700_02InputData inputData02 = new Ipo5700_02InputData();
		inputData02.setUpdateFlag02(clientArea.pnlSub2.txtUpdateFlg.getValue());
		inputData02.setDataList(dataList02);
		inputData.setInputData02(inputData02);

		// Set current updated time
		inputData.setTimeStamp(clientArea.getTimeStamp());

		// Set Base PR data
		inputData.setPrData(PRHelper.getPrData());

		return inputData;
	}

	/**
	 * Return screen window state ID of this class. <br>
	 * 
	 * @param Nothing
	 * @return String Change Input window state(Frw00HeaderData.WNDSTAT_CONFIRM)
	 * @exception Nothing
	 */
	public String getWindowStatus() {

		return Frw00HeaderData.WNDSTAT_CONFIRM;
	}

	/**
	 * Notify when have something change in window component. <br>
	 * <p>
	 * This method run when enable component value is changed.
	 * </p>
	 * 
	 * @param component
	 *            InputComponentIF the component was changed
	 * @return Nothing
	 * @exception Frw10ClientException
	 *                exception raised
	 */
	public void notifyItemChanged(InputComponentIF component)
			throws Frw10ClientException {
		// Set need to get data to true when Key changed
		if (component.equals(clientArea.txtId)) {
			clientArea.needToGetData = true;

			panel02.setOriginList(null);

			// Change window state into WNDSTAT_INPUT
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);

		} else if (component.equals(clientArea.cboActionMode)) {
			panel02.setOriginList(null);

			// Change window state into WNDSTAT_INPUT
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);

			if (!ItemValidator.isDeleteMode(clientArea.cboActionMode)) {
				clientArea.needToGetData = true;
			}

			// Change in main tab
		} else if (component.equals(clientArea.txtIpoCd)
				|| component.equals(clientArea.cboIpoType)
				|| component.equals(clientArea.txtIpoName)
				|| component.equals(clientArea.txtAddress)
				|| component.equals(clientArea.txtAuthorizedCapital)
				|| component.equals(clientArea.txtBusinessType)
				|| component.equals(clientArea.txtCashReceiveAddress)
				|| component.equals(clientArea.txtIpoAddress)
				|| component.equals(clientArea.txtTel)) {

			if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
				// Change window state into WNDSTAT_CHANGE_INPUT
				setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
			} else {
				// Change window state into WNDSTAT_INPUT
				setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
			}
			// Change in tab 1
		} else if (component.equals(panel01.txtBeginPayDate)
				|| component.equals(panel01.cboPriority)
				|| component.equals(panel01.cboSecType)
				|| component.equals(panel01.txtBeginPrice)
				|| component.equals(panel01.txtBeginRegDate)
				|| component.equals(panel01.txtDepositRate)
				|| component.equals(panel01.txtEndPayDate)
				|| component.equals(panel01.txtEndRegDate)
				|| component.equals(panel01.txtFaceValPrice)
				|| component.equals(panel01.txtIpoDate)
				|| component.equals(panel01.txtPriceStep)
				|| component.equals(panel01.txtQty)
				|| component.equals(panel01.txtQtyStep)
				|| component.equals(panel01.txtRemarks)
				|| component.equals(panel01.txtSubAccoCd)) {

			if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
				// Change window state into WNDSTAT_CHANGE_INPUT
				setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
			} else {
				// Change window state into WNDSTAT_INPUT
				setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
			}

			panel01.txtUpdateFlg.setValue(ConstantValues.TAB_UPDATE);
		}
	}

	/**
	 * Set screen component with the response data from AP if successfull. <br>
	 * <p>
	 * Set screen's comonent with the response data (from AP) and change the
	 * Window state. Process as below
	 * </p>
	 * <ol>
	 * <li>Change the window state to WNDSTAT_RESULT.
	 * <li>Set the response data to component.
	 * </ol>
	 * 
	 * @param recvData
	 *            Frw00ResultData Response data from AP side.
	 * @return Nothing
	 * @exception Frw10ClientException
	 *                if have a exception while writing to client component.
	 */
	public void setSuccessResultData(Frw00ResultData recvData)
			throws Frw10ClientException {

		getPanels();

		// Get the response data
		Ipo5700ResultData resultData = (Ipo5700ResultData) recvData;

		// Change window state to WNDSTAT_RESULT
		setBusinessState(Frw00HeaderData.WNDSTAT_RESULT);

		// Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);

		// Set the answer to show
		String[] answerIdArray = resultData.getAnswerIdArray();

		if (ItemValidator.isNotEmpty(answerIdArray)) {
			Inf30S108101Frame.showAnswer(resultData.getAnswerIdArray());
		}

		// Tab 1
		Ipo5700_01ResultData resultData01 = resultData.getResultData01();
		Frw10ServerDataProc.setResultData(panel01, resultData01);

		// Tab 02
		Ipo5700_02ResultData resultData02 = resultData.getResultData02();
		List<?> dataList02 = resultData02.getDataList();

		if (dataList02 != null) {
			panel02.setDataToGrid(dataList02, false);
		}

		// Set the current updated time
		clientArea.setTimeStamp(resultData.getTimeStamp());
	}

	/**
	 * Set fail result data
	 */
	public void setFailureResultData(Frw00ResultData recvData)
			throws Frw10ClientException {

		if (!(recvData instanceof Ipo5700ResultData)) {
			return;
		}

		this.getPanels();
		Ipo5700ResultData resultData = (Ipo5700ResultData) recvData;

		// Check result data
		if (resultData != null) {
			// Error on tab 01
			if (resultData.getResultData01() != null) {
				this.setErrorColorForTab(Ipo5700_01Panel.INDEX_ON_TAB);
			}
			// Error on tab 02
			else if (resultData.getResultData02() != null) {
				Ipo5700_02ResultData resultData02 = resultData
						.getResultData02();

				panel02.setDataToGrid(resultData02.getDataList(), true);
				this.setErrorColorForTab(Ipo5700_02Panel.INDEX_ON_TAB);
			}
		}
	}

	/**
	 * Return the list of disable components in screen. <br>
	 * 
	 * @param Nothing
	 * @return List of disable components
	 * @exception Nothing
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getUnEditComponentList() {
		// Create instance of list disable component
		List lockComponents = new ArrayList();

		getPanels();

		if (ItemValidator.isDeleteMode(clientArea.cboActionMode)) {
			// lock all control
			lockComponents.addAll(clientArea.getInputComponents());
			lockComponents.remove(clientArea.cboActionMode);
			lockComponents.remove(clientArea.txtId);

			lockComponents.add(panel01);
			lockComponents.add(panel02);

			setEnabledTab(false);
		} else if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
			// lock GroupCd
			lockComponents.add(clientArea.txtIpoCd);
		} else {
			lockComponents.add(clientArea.txtId);
		}

		return lockComponents;
	}

	/**
	 * Get panel <br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 */
	private void getPanels() {
		// Get input data from screen to client area
		clientArea = (Ipo5700Panel) getClientPanel();

		panel01 = (Ipo5700_01Panel) clientArea.pnlSub1;

		panel02 = (Ipo5700_02Panel) clientArea.pnlSub2;
	}

	/**
	 * notify when table data change
	 * */
	public void notifyUITableChanged() {
		this.getPanels();

		if (ItemValidator.isEntryMode(clientArea.cboActionMode)) {
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		} else if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
			setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
		}
	}

	/**
	 * Set enable tab
	 * */
	private void setEnabledTab(boolean param) {
		// main tab
		clientArea.setEnabledControl(param);

		// tab 1
		panel01.setEnabledControl(param);

		// tab 2
		panel02.setEnabledControl(param);
	}

	/**
	 * Set error color for tab and set selected index <br>
	 * 
	 * @param index
	 *            - index of tab
	 * @return Nothing
	 */
	private void setErrorColorForTab(int index) {
		clientArea.tabPanel.setErrorColor(index);
		clientArea.tabPanel.setSelectedIndex(index);
	}
}
