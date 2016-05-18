/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.hlp.hlp8904;

import java.awt.Component;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.nec.frw1000.pr.component.UIMessagePanel;
import jp.co.okasan.cm.hlp.hlp8904.Hlp8904InputData;
import jp.co.okasan.cm.hlp.hlp8904.Hlp8904ResultData;

/**
 * Hlp8904Input Class's Description <br>
 * Input State of Select CboTBond_Contract Class.
 * <p>
 * Handle the "Input State" in Screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Hlp8904Input extends Frw00AbstractBusinessState {

	////////// Class Variables //////////
	
	/** Control class name of AP side */
	private static final String BUSINESS_CLASS_NAME = "jp.co.okasan.ap.hlp.hlp8904.Hlp8904Control";
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
	 * Run the first time when goto the state. <br>
	 *
	 * @param before String null if goto this state in the first time.
	 * @return Nothing
	 * @exception Nothing
	 */		
    public void initState(String before) {
    	Hlp8904Frame frame = (Hlp8904Frame) getBaseTemplateFrame();
    	frame.getStatusViewPanel().setStatusMessage("MSG0272I  Input items value and press F12 to confirm screen.", UIMessagePanel.MESSAGE_INFORMATION);
        if (before == null) {
            // Send request to AP side
            getBaseTemplateFrame().sendToServer();
        }
		// Disable the change mode
		setChangeMode(false);
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
		Hlp8904InputData inputData = new Hlp8904InputData();      
		// Get input data from screen to client area
		Hlp8904Panel clientArea = (Hlp8904Panel) getClientPanel();
		
		// Set the input data with the value from input component of client area
		Frw10ServerDataProc.getInputData(clientArea, inputData);
		
		return inputData;
	}
	
	/**
	 * Return screen window state ID of this class. <br>
	 * 
	 * @param Nothing
	 * @return  String Input window state(Frw00HeaderData.WNDSTAT_INPUT)
	 * @exception Nothing
	 */
	public String getWindowStatus() {
		
	    return Frw00HeaderData.WNDSTAT_INPUT;
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
		Hlp8904Panel clientArea = (Hlp8904Panel) getClientPanel();
		
        // Get the response data		
	    Hlp8904ResultData resultData = (Hlp8904ResultData) recvData;

        // Change the window state to input state
		setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		
        // Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);
		
        // Set the focus to the first row
        clientArea.tblDataList.setRowSelectionInterval(0,0);
		setChangeMode(false);
	}
	
	/**
	 * Set screen component when AP process with failure . <br>
	 * <p>
	 * Set screen's comonent with the response data (from AP) and change the Window state.
	 * Process as below 
	 * </p>
	 * <ol>
	 * <li> Clear all rows of grid data.
	 * </ol>
	 * 
	 * @param recvData Frw00ResultData Response data from AP side.
	 * @return Nothing
	 * @exception Frw10ClientException if have a exception while writing to client component.
	 */
	public void setFailureResultData(Frw00ResultData recvData) throws Frw10ClientException {
		// Get client area
		Hlp8904Panel clientArea = (Hlp8904Panel) getClientPanel();
		clientArea.clearTable();
	}
	
	/**
     * Return the default focus component. <br>
     * <p>
	 * Set the first component want to focus when display screen.
     * </p>
     * @param Nothing
     * @return default focus component
     * @exception Nothing
     */
    public Component getDefaultFocusComponent() {
        // Get client area
    	Hlp8904Panel clientArea = (Hlp8904Panel) getClientPanel();

        // return data List
        return clientArea.tblDataList;
    }
}

