/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.cbo.cbo5904;

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
import jp.co.okasan.cm.cbo.cbo5901.Cbo5901ResultData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;
import jp.co.okasan.cmn.constant.cbo.CboTBondContractType;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Cbo5904ChangeInput Class's Description <br>
 * Change input State process of CboTBond_Contract Class.
 * 
 * <p>
 * Handle the "Change Input State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/13 Create New
 */
public class Cbo5904ChangeInput extends Frw00AbstractBusinessState {

	// //////// Class Variables //////////

	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.cbo.cbo5904.Cbo5904Control";

	/** Process method name of AP side */
	private static final String PROCESS_METHOD_NAME = "doTask";

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
		Cbo5904Panel clientArea = (Cbo5904Panel) getClientPanel();

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

		// Create instance of input data class
		Cbo5904InputData inputData = new Cbo5904InputData();

		// Get input data from screen to client area
		Cbo5904Panel clientArea = (Cbo5904Panel) getClientPanel();

		// Set the input data with the value from input component of client area
		Frw10ServerDataProc.getInputData(clientArea, inputData);

		// Set current updated time
		inputData.setTimeStamp(clientArea.getTimeStamp());

		// Set current payment account info timeStamp
		inputData.setPaymentAccoInfoTimeStamp(clientArea
				.getPaymentAccInfoTimeStamp());

		// Set timeStamp of bond info Data
		Cbo5901ResultData bondInfoData = clientArea.cboBondCd.getBondInfoData();
		if (bondInfoData != null) {
			inputData.setBondInfoTimeStamp(bondInfoData.getUpdDateTime());
		}

		// Set contract type = buy
		inputData.setContractType(CboTBondContractType.BUY.toString());

		// Set Base PR data
		inputData.setPrData(PRHelper.getPrData());

		return inputData;
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

		Cbo5904Panel clientArea = (Cbo5904Panel) getClientPanel();

		// Lock key field
		lockComponents.addAll(clientArea.getDefaultUnEditComponents());

		return lockComponents;
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

		// Get input data from screen to client area
		Cbo5904Panel clientArea = (Cbo5904Panel) getClientPanel();

		// Set need to get data to true when Key changed
		if (component.equals(clientArea.txtId)) {
			clientArea.needToGetData = true;
		}

		if (component.equals(clientArea.cboActionMode)
				|| component.equals(clientArea.txtId)) {

			// Change state to WNDSTAT_INPUT
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
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
}
