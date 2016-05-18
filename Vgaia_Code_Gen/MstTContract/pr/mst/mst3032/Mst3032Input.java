/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.mst.mst3032;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.nec.frw1000.pr.component.InputComponentIF;

import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.frw.pr.UISwingUtils;

import jp.co.okasan.pr.cmn.PRHelper;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

/**
 * Mst3032Input Class's Description <br>
 * Input State process of MstTContract Class.
 *
 * <p>
 * Handle the "Input State" in Screen. 
 * </p>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032Input extends Frw00AbstractBusinessState {
	
	////////// Class Variables //////////
	
	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.mst.mst3032.Mst3032Control";
	
	/** Process method name of AP side */
	private static final String PROCESS_METHOD_NAME = "doTask";
	
	////////// Methods define //////////
	
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
	 * @exception Frw10ClientException throw when have a exception while reading client component.
	 */
	public Frw00InputData getSendData() throws Frw10ClientException {
		
		// Create instance of input data class
		Mst3032InputData inputData = new Mst3032InputData();      
		
		// Get input data from screen to client area
		Mst3032Panel clientArea = (Mst3032Panel) getClientPanel();
		
		// Set the input data with the value from input component of client area
		Frw10ServerDataProc.getInputData(clientArea, inputData);
		
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
	public List<?> getUnEditComponentList() {
		Mst3032Panel clientArea = (Mst3032Panel)getClientPanel();
		
		List<JComponent> lockComponents = new ArrayList<>();
		if (ItemValidator.isEntryMode(clientArea.cboActionMode)) {
			lockComponents.add(clientArea.txtId);
		}
		
		
		// Get all default lock component
		lockComponents.addAll(clientArea.getDefaultUnEditComponents());

		// Enable button or table
		clientArea.setEnableControl(true);
	
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
	 * @param before String null if goto this state in the first time.
	 * @return Nothing
	 * @exception Nothing
	 */	
	public void initState(String before) {
		Mst3032Frame frame = (Mst3032Frame) getBaseTemplateFrame();
		Mst3032Panel clientArea = (Mst3032Panel)getClientPanel();
		
        int modeIndex = clientArea.cboActionMode.getSelectedIndex();
        
    	// Set init message in mode
    	UISwingUtils.setInitMsg(frame,modeIndex);
		
		// Set change mode
		setChangeMode(false);
		
		// Reset Control
		if (Frw00HeaderData.WNDSTAT_RESULT.equals(before)) {
			if (!clientArea.F2
					|| ItemValidator.isEntryMode(clientArea.cboActionMode)) {
				clientArea.txtId.reset();
			}
			
			clientArea.F2 = false;
		}
    }
	
	/**
     * Notify when have something change in window component. <br>
     * <p>
	 * This method run when enable component value is changed.
     * </p>
     * 
     * @param component InputComponentIF the component was changed
     * @return Nothing
     * @exception Frw10ClientException exception raised 
     */	
	public void notifyItemChanged(InputComponentIF component) throws Frw10ClientException {
		Mst3032Frame frame = (Mst3032Frame) getBaseTemplateFrame();
		Mst3032Panel clientArea = (Mst3032Panel)getClientPanel();

		// Set need to get data to true when Key changed
		if (component.equals(clientArea.txtId)) {
			clientArea.needToGetData = true;
		}

		if (component.equals(clientArea.cboActionMode)) {
		
			// Get ActionMode index
			int modeIndex = clientArea.cboActionMode.getSelectedIndex();
		    UISwingUtils.setInitMsg(frame,modeIndex);
		}
	}
	
	/**
	 * Set screen component with the response data from AP if successfull. <br>
	 * <p>
	 * Set screen's comonent with the response data (from AP) and change the Window state.
	 * Process as below 
	 * </p>
	 * <ol>
	 *  <li> Change the window state to WNDSTAT_INPUT.
	 *  <li> Set the response data to component.
	 * </ol>
	 * 
	 * @param recvData Frw00ResultData Response data from AP side.
	 * @return Nothing
	 * @exception Frw10ClientException if have a exception while writing to client component.
	 */
	public void setSuccessResultData(Frw00ResultData recvData)throws Frw10ClientException {
		
		// Get the Client area
		Mst3032Panel clientArea = (Mst3032Panel) getClientPanel();

		// Change the window state
		if(ItemValidator.isUpdateMode(clientArea.cboActionMode)){
			
			// If needToGetData --> Bind data to screen and set flag to false
			if (clientArea.needToGetData) {
				setBusinessState(Frw00HeaderData.WNDSTAT_CHANGE_INPUT);
				clientArea.needToGetData = false;
			} else {

				// Else change to Confirm Screen and not bind data
				setBusinessState(Frw00HeaderData.WNDSTAT_CONFIRM);
				return;
			}			
		}else{
		
			// If is deleted mode and already get data, set needToGetData to
			// false
			if (ItemValidator.isDeleteMode(clientArea.cboActionMode)) {
				clientArea.needToGetData = false;
			}

			setBusinessState(Frw00HeaderData.WNDSTAT_CONFIRM);
		}
			
        // Get the response data	
		Mst3032ResultData resultData = (Mst3032ResultData) recvData;

        // Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);
		
		// Set current Updated Time
		clientArea.setTimeStamp(resultData.getTimeStamp());
	}
}
