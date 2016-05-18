/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

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
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700ResultData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_01InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_01ResultData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02ResultData;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.frw.pr.UISwingUtils;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Ipo5700Input Class's Description <br>
 * Input State process of IpoTinfo Class.
 * 
 * <p>
 * Handle the "Input State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/01/20 Create New
 */
public class Ipo5700Input extends Frw00AbstractBusinessState {

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
	 * Return enabled function key. <br>
	 * 
	 * @param Nothing
	 * @return int Enabled function key
	 * @exception Frw10ClientException
	 */
	public int getEnabledFunction() throws Frw10ClientException {
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
	 * Return the list of disable components in screen. <br>
	 * 
	 * @param Nothing
	 * @return List of disable components
	 * @exception Nothing
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getUnEditComponentList() {
		getPanels();
		setEnabledTab(true);

		List lockComponents = new ArrayList();

		if (ItemValidator.isEntryMode(clientArea.cboActionMode)) {
			lockComponents.add(clientArea.txtId);
		}

		return lockComponents;
	}

	/**
	 * Return screen window state ID of this class. <br>
	 * 
	 * @param Nothing
	 * @return String Input window state(Frw00HeaderData.WNDSTAT_INPUT)
	 * @exception Nothing
	 */
	public String getWindowStatus() {

		return Frw00HeaderData.WNDSTAT_INPUT;
	}

	/**
	 * Run the first time when goto the state. <br>
	 * 
	 * @param before
	 *            String null if goto this state in the first time.
	 * @return Nothing
	 * @throws Frw10ClientException
	 * @exception Nothing
	 */
	public void initState(String before) throws Frw10ClientException {
		Ipo5700Frame frame = (Ipo5700Frame) getBaseTemplateFrame();
		this.getClientPanel();

		int modeIndex = clientArea.cboActionMode.getSelectedIndex();

		// Set init message in mode
		UISwingUtils.setInitMsg(frame, modeIndex);

		// Set change mode
		setChangeMode(false);

		// Reset Control
		if (Frw00HeaderData.WNDSTAT_RESULT.equals(before)) {
			clientArea.needToGetData = true;
			clientArea.resetControl();

			// Reset update flag in tab
			clientArea.pnlSub1.txtUpdateFlg.reset();
			clientArea.pnlSub1.txtUpdateFlg.setValue("");
			clientArea.pnlSub2.txtUpdateFlg.reset();
			clientArea.pnlSub2.txtUpdateFlg.setValue("");
		}
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
		getPanels();

		// Set need to get data to true when Key changed
		if (component.equals(clientArea.txtId)) {
			clientArea.needToGetData = true;
			panel02.setOriginList(null);
		}

		Ipo5700Frame frame = (Ipo5700Frame) getBaseTemplateFrame();

		if (component.equals(clientArea.cboActionMode)) {
			panel02.setOriginList(null);

			// Get ActionMode index
			int modeIndex = clientArea.cboActionMode.getSelectedIndex();
			UISwingUtils.setInitMsg(frame, modeIndex);

			// If mode is delete, always set needToGetData to true
			if (ItemValidator.isDeleteMode(clientArea.cboActionMode)) {
				clientArea.needToGetData = true;
			}
		}

		// If Change value in tab 1 => enable updateFalg
		if (component.equals(panel01.txtBeginPayDate)
				|| component.equals(panel01.cboPriority)
				|| component.equals(panel01.cboSecType)
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
	 * <li>Change the window state to WNDSTAT_INPUT.
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
		this.getPanels();

		// Change the window state
		if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
			// If needToGetData --> Bind data to screen and set flag to false
			if (clientArea.needToGetData) {
				setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
				clientArea.needToGetData = false;

				// Reset tab update when receive new data
				panel01.txtUpdateFlg.setValue("");
				panel02.txtUpdateFlg.setValue("");
			} else {
				// Else change to Confirm Screen and not bind data
				setBusinessState(Frw00HeaderData.WNDSTAT_CONFIRM);
				return;
			}
		} else {
			if (ItemValidator.isDeleteMode(clientArea.cboActionMode)) {
				clientArea.needToGetData = false;

				// Reset tab update when receive new data
				panel01.txtUpdateFlg.setValue("");
				panel01.txtUpdateFlg.setValue("");
			}

			setBusinessState(Frw00HeaderData.WNDSTAT_CONFIRM);
		}

		// Get the response data
		Ipo5700ResultData resultData = (Ipo5700ResultData) recvData;

		// Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);

		// Set current Updated Time
		clientArea.setTimeStamp(resultData.getTimeStamp());

		// Tab 01
		Ipo5700_01ResultData resultData01 = resultData.getResultData01();
		if (resultData01 != null) {
			Frw10ServerDataProc.setResultData(panel01, resultData01);
		}

		// Tab 02
		Ipo5700_02ResultData resultData02 = resultData.getResultData02();
		List<?> dataList02 = resultData02.getDataList();

		if (dataList02 != null) {
			panel02.setDataToGrid(dataList02, false);
			panel02.setOriginList(CommonHelper.cloneList(dataList02));
		}
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
	 * Set enable control on panel detail
	 * 
	 * @param param
	 *            : true or false
	 */
	private void setEnabledTab(boolean param) {
		// main tab
		clientArea.setEnabledControl(param);

		panel01.setEnabledControl(param);
		panel02.setEnabledControl(param);
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
