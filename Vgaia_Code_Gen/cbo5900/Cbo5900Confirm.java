/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.cbo.cbo5900;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.nec.frw1000.pr.component.InputComponentIF;
import jp.co.nec.inf3000.pr.Inf30S108101Frame;

import jp.co.okasan.cmn.ItemValidator;

import jp.co.okasan.pr.cmn.PRHelper;
import jp.co.okasan.cm.cbo.cbo5900.Cbo5900InputData;
import jp.co.okasan.cm.cbo.cbo5900.Cbo5900ResultData;

/**
 * Cbo5900Confirm Class's Description <br>
 * Confirm State process of CboTCorporate_Info Class.
 * 
 * <p>
 * Handle the "Confirm State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/07 Create New
 */
public class Cbo5900Confirm extends Frw00AbstractBusinessState {

	// //////// Class Variables //////////

	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.cbo.cbo5900.Cbo5900Control";

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
		Cbo5900Panel clientArea = (Cbo5900Panel) getClientPanel();

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

		// Create instance of input data class
		Cbo5900InputData inputData = new Cbo5900InputData();

		// Get input data from screen to client area
		Cbo5900Panel clientArea = (Cbo5900Panel) getClientPanel();

		// Set the input data with the value from input component of client area
		Frw10ServerDataProc.getInputData(clientArea, inputData);

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

		// Get client area panel
		Cbo5900Panel clientArea = (Cbo5900Panel) getClientPanel();

		// Set need to get data to true when Key changed
		if (component.equals(clientArea.txtId)) {
			clientArea.needToGetData = true;
		}

		if (component.equals(clientArea.cboActionMode)) {

			// Change window state into WNDSTAT_INPUT
			setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		} else {
			if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
				if (component.equals(clientArea.txtId)) {

					// Change window state into WNDSTAT_INPUT
					setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
				} else {

					// Change window state into WNDSTAT_CHANGE_INPUT
					setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
				}
			} else {

				// Change window state into WNDSTAT_INPUT
				setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
			}
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

		// Get the Client area
		Cbo5900Panel clientArea = (Cbo5900Panel) getClientPanel();

		// Get the response data
		Cbo5900ResultData resultData = (Cbo5900ResultData) recvData;

		// Change window state to WNDSTAT_RESULT
		setBusinessState(Frw00HeaderData.WNDSTAT_RESULT);

		// Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);

		// Set the answer to show
		String[] answerIdArray = resultData.getAnswerIdArray();
		if (ItemValidator.isNotEmpty(answerIdArray)) {
			Inf30S108101Frame.showAnswer(resultData.getAnswerIdArray());
		}

		// Set the current updated time
		clientArea.setTimeStamp(resultData.getTimeStamp());
	}

	/**
	 * Return the list of disable components in screen. <br>
	 * 
	 * @param Nothing
	 * @return List of disable components
	 * @exception Nothing
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getUnEditComponentList() {

		// Create instence of list disable component
		List lockComponents = new ArrayList();

		// Get input data from screen to client area
		Cbo5900Panel clientArea = (Cbo5900Panel) getClientPanel();

		if (ItemValidator.isDeleteMode(clientArea.cboActionMode)) {

			// lock all control
			lockComponents.add(clientArea.txtId);
			lockComponents.add(clientArea.txtShortName);
			lockComponents.add(clientArea.txtFullName);
			lockComponents.add(clientArea.txtBusinessType);
			lockComponents.add(clientArea.txtAuthorizedCapital);
			lockComponents.add(clientArea.txtAddress);
			lockComponents.add(clientArea.txtTel);
			lockComponents.add(clientArea.txtRemarks);
		} else if (ItemValidator.isUpdateMode(clientArea.cboActionMode)) {
			// Disable shortName if update mode
			lockComponents.add(clientArea.txtShortName);
		}

		// Disable Key
		if (ItemValidator.isEntryMode(clientArea.cboActionMode)) {
			lockComponents.add(clientArea.txtId);
		}

		return lockComponents;
	}
}
