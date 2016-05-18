/*
 * Copyright(C) 2012 GOkasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.mst.mst3032;

import java.util.ArrayList;
import java.util.List;

import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw0000.pr.util.Frw00UnLockWindow;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;

/**
 * Mst3032Result Class's Description <br>
 * Result State process of MstTContract Class.
 *
 * <P>
 * Handle the "Result State" in Screen. 
 * <P>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032Result extends Frw00AbstractBusinessState implements Frw00UnLockWindow {

	////////// Methods define //////////
		
	/**
	 * Return control class name to AP side. <br>
	 * 
	 * @param Nothing
	 * @return String Control class name
	 * @exception nothing
	 */
	public String getBusinessClassName() {
		
		return null;		
	}
	
	/**
	 * Return process method name of the AP side. <br>
	 * 
	 * @param Nothing
	 * @return String
	 * @exception Nothing
	 */	
	public String getProcessMethodName() {
		return null;	
	}

	/**
	 * Return enabled function key. <br>
	 * 
	 * @param Nothing
	 * @return int Enabled function key
	 * @exception Frw10ClientException
	 */
	public int getEnabledFunction() throws Frw10ClientException {
        return Frw00FunctionKey.FUNCTION_RESULT;
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
	// Get the Client area
		Mst3032Panel clientArea = (Mst3032Panel) getClientPanel();
		
		// Create instence of list disable component
        List lockComponents = new ArrayList();
        
        // Add client panel to lock component  List
        lockComponents.add(getClientPanel());
		
		// Lock button or table
		clientArea.setEnableControl(false);
        
        // Return lock component list
        return lockComponents;	
    }
	
	/**
	 * Return screen window state ID of this class. <br>
	 * 
	 * @param Nothing
	 * @return String Result window state(Frw00HeaderData.WNDSTAT_RESULT)
	 * @exception Nothing
	 */
	public String getWindowStatus() {
		return Frw00HeaderData.WNDSTAT_RESULT;	
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

		// Get the response data	
		Mst3032ResultData resultData = (Mst3032ResultData) recvData;

		// Change window state to WNDSTAT_INPUT
		setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);

		// Set the response data to screen's component
		Frw10ServerDataProc.setResultData(clientArea, resultData);
	}
	
	/**
	 * Process when continue funtion is pressed (F2 key). <br>
	 *
	 * @param Nothing
	 * @return Nothing
	 * @exception Frw10ClientException 
	 */
	public void unLockWindow() throws Frw10ClientException {
		Mst3032Panel clientArea = (Mst3032Panel)getClientPanel();
		clientArea.F2 = true;
		setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		clientArea.resetColor(clientArea);	
	}
}
