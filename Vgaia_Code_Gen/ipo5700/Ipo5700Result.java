/*
 * Copyright(C) 2012 GOkasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.util.ArrayList;
import java.util.List;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.frw0000.pr.util.Frw00AbstractBusinessState;
import jp.co.nec.frw0000.pr.util.Frw00FunctionKey;
import jp.co.nec.frw0000.pr.util.Frw00UnLockWindow;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ServerDataProc;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700ResultData;

/**
 * Ipo5700Result Class's Description <br>
 * Result State process of Class.
 * 
 * <P>
 * Handle the "Result State" in Screen.
 * <P>
 * 
 * @author: HungKieu 2015/01/10 Create New
 */
public class Ipo5700Result extends Frw00AbstractBusinessState implements
		Frw00UnLockWindow {

	// //////// Methods define //////////

	/** main Panel */
	private Ipo5700Panel clientArea;

	/** Panel 01 */
	private Ipo5700_01Panel panel01;

	/** Panel 02 */
	private Ipo5700_02Panel panel02;

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
		getPanels();

		// Create instance of list disable component
		List lockComponents = new ArrayList();

		// Add client panel to lock component List
		lockComponents.add(clientArea);

		setEnabledpanel(false);

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
		// Get the Client area
		Ipo5700Panel clientArea = (Ipo5700Panel) getClientPanel();

		// Get the response data
		Ipo5700ResultData resultData = (Ipo5700ResultData) recvData;

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

		Ipo5700Panel clientArea = (Ipo5700Panel) getClientPanel();
		setBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
		clientArea.resetColor(clientArea);
	}

	/**
	 * Get panels
	 */
	private void getPanels() {
		// Get input data from screen to client area
		clientArea = (Ipo5700Panel) getClientPanel();
		panel01 = clientArea.pnlSub1;
		panel02 = clientArea.pnlSub2;
	}

	/**
	 * Set enable control on panel detail
	 * 
	 * @param param
	 *            : true or false
	 */
	private void setEnabledpanel(boolean param) {
		// main tab
		clientArea.setEnabledControl(param);

		panel01.setEnabledControl(param);
		panel02.setEnabledControl(param);
	}
}
