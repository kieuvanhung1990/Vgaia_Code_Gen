/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.hlp.hlp6032;

import java.awt.Dimension;
import java.util.HashMap;

import jp.co.okasan.cmn.ConstantValues;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.pr.util.Frw00BusinessState;
import jp.co.nec.frw0000.pr.util.Frw00BusinessStateManager;
import jp.co.nec.frw0000.pr.util.Frw00StateMap;
import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw0000.pr.view.Frw00HelpBaseTemplateFrame;

/**
 * Hlp6032Frame Class's Description. <br>
 * <P>
 * MstTContract class: select
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Hlp6032Frame extends Frw00HelpBaseTemplateFrame implements ConstantValues {

	////////// Class Constructor //////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructor method <br>
	 * Call Constructor base template.
     * 
     * @param Nothing
	 * @exception Nothing
     */
	public Hlp6032Frame() {
        // Call from supper method
        super();

        // Set modal to display
        setModalWindow();
    }
 	
	/**
     * Constructor method <br>
	 * Call Constructor base template.
     * 
     * @param data HashMap client area data
     * @param businessId String
     * @exception
     */
	@SuppressWarnings("rawtypes")
    public Hlp6032Frame(HashMap data, String businessId) {
        // Call from supper method
        super(data, businessId);

        // Set modal to display
        setModalWindow();
    }
	
	////////// Methods Define //////////
	
	/**
     * Initialize the size of window <br>
     * 
     * @param Nothing
     * @return Dimension the initial size of window
     * @exception Nothing
     */
    public Dimension getInitialSize() {
        // Get default dimension
        Dimension initialWindowSize = new Dimension(HLP_INI_WIDTH, HLP_INI_HEIGHT);
        return initialWindowSize;
    }
	
	/**
     * Initialize maximum dimension<br>
     * 
     * @param
     * @return Dimension
     * @exception
     */
    public Dimension getMaximumSize() {
        // Get maximum dimension
        Dimension maxWindowSize = new Dimension(HLP_MAX_WIDTH, HLP_MAX_HEIGHT);
        return maxWindowSize;
    }
	
	/**
     * The minimum size of window Size. <br>
     * 
     * @param Nothing
     * @return Dimension the minimum size of window
     * @exception Nothing
     */
    public Dimension getMinimumSize() {
        // Get minimum dimension
        Dimension minWindowSize = new Dimension(HLP_MIN_WIDTH, HLP_MIN_HEIGHT);
        return minWindowSize;
    }
	
	/**
     * Define states of the business.<br>
	 * Define: <br>
     * Input state (Hlp6032Input)
     * 
     * @param stateMap Frw00BusinessStateManager Window state management class
     * @return Frw00BusinessStateManager Window state management class
     * @exception Nothing
     */   
    protected Frw00BusinessStateManager createBusinessState(Frw00BusinessStateManager stateMap) {
    	// Add input state into state map
		stateMap.addBusinessState(new Hlp6032Input());
		return stateMap;
	}
	
	/**
     * Create default client area. <br>
     * 
     * @param Nothing
     * @return Frw00ClientPanel Created client area
     * @exception Nothing
     */
    protected Frw00ClientPanel createDefaultClientPanel() {
        // Set datetime to display
    	showDatetime();
        return new Hlp6032Panel();
    }
	
	/**
     * Return the default window state. <br>
     * 
     * @param stateMap Frw00StateMap Window state management class
     * @return Frw00BusinessStat ethe first window class that was define in Frw00StateMap
     * @exception Nothing
     */	
    protected Frw00BusinessState getDefaultBusinessState(Frw00StateMap stateMap) {
        // Return default state map
        return stateMap.getBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
    }
	
	/**
	 * Clear Frame All Item (Clear All)
	 */
	public void clearFrameAllItem() {
		// Clear all item into panel
		getClientPanel().clearAllItem();
	}
}

