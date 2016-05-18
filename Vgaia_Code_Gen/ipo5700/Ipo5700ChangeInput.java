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
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700ResultData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_01InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02InputData;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02ResultData;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.frw.pr.UISwingUtils;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Ipo5700ChangeInput Class's Description <br>
 * Change input State process of IpoTInfo Class.
 * 
 * <p>
 * Handle the "Change Input State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/01/20 Create New
 */
public class Ipo5700ChangeInput extends Frw00AbstractBusinessState {

	// //////// Class Variables //////////

	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.ipo.ipo5700.Ipo5700Control";
	/** Process method name of AP side */
	private static final String PROCESS_METHOD_NAME = "doTask";

	/** panel in main frame */
	private Ipo5700Panel clientArea;

	/** Panel 1 in tab 1 - */
	private Ipo5700_01Panel panel01;

	/** Panel 1 in tab 2 - */
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

	public void initState(String before) {
		Ipo5700Frame frame = (Ipo5700Frame) getBaseTemplateFrame();
		Ipo5700Panel clientArea = (Ipo5700Panel) getClientPanel();

		int modeIndex = clientArea.cboActionMode.getSelectedIndex();

		// Set init message in mode
		UISwingUtils.setInitMsg(frame, modeIndex);

		// Set change mode
		setChangeMode(false);
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

		// Return default key control
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
		// return function default
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
		// Create instance of list disable component
		List lockComponents = new ArrayList();

		getPanels();

		// lock Code
		lockComponents.add(clientArea.txtIpoCd);

		return lockComponents;
	}

	/**
	 * Return screen window state ID of this class. <br>
	 * 
	 * @param Nothing
	 * @return String Change Input window
	 *         state(Frw00HeaderData.WNDSTAT_CHANGE_INPUT)
	 * @exception Nothing
	 */
	public String getWindowStatus() {

		return Frw00HeaderData.WNDSTAT_CHANGE_INPUT;
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

		if (component.equals(clientArea.cboActionMode)
				|| component.equals(clientArea.txtId)) {
			panel02.setOriginList(null);

			// Change state to WNDSTAT_INPUT
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		}

		// If Change value in tab 1 => enable updateFalg
		if (component.equals(panel01.txtBeginPayDate)
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
			panel01.txtUpdateFlg.reset();
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
	 * <li>Change the window state to WNDSTAT_CONFIRM.
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

		// Change the window state
		setBusinessState(Frw00HeaderData.WNDSTAT_CONFIRM);
	}

	/**
	 * Set screen component with the response data from AP if failed. <br>
	 * <p>
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
	 * Get panel in tab 0,1,2 <br>
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
