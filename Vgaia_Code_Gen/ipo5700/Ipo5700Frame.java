/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.awt.Dimension;
import java.util.HashMap;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.pr.util.Frw00BusinessState;
import jp.co.nec.frw0000.pr.util.Frw00BusinessStateManager;
import jp.co.nec.frw0000.pr.util.Frw00StateMap;
import jp.co.nec.frw0000.pr.view.Frw00BaseTemplateFrame;
import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.okasan.cmn.ConstantValues;

/**
 * Ipo5700Frame Class's <br>
 * <P>
 * IpoInfo class: insert, update, delete
 * </p>
 * 
 * @author: HungKieu 2016/03/22 Create New
 */
public class Ipo5700Frame extends Frw00BaseTemplateFrame implements
		ConstantValues {

	// //////// Methods define //////////

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor <br>
	 * Call Constructor base template.
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public Ipo5700Frame() {
		super();
	}

	/**
	 * Constructor <br>
	 * Call Constructor base template.
	 * 
	 * @param data
	 *            HashMap client area data
	 * @param businessId
	 *            String
	 * @exception Nothing
	 */
	@SuppressWarnings("rawtypes")
	public Ipo5700Frame(HashMap data, String businessId) {
		super(data, businessId);
	}

	/**
	 * Initialize the size of window<br>
	 * 
	 * @param Nothing
	 * @return Dimension the initial size of window
	 * @exception Nothing
	 */
	public Dimension getInitialSize() {
		Dimension initialWindowSize = new Dimension(IPO_5700_WIDTH,
				IPO_5700_HEIGHT);
		return initialWindowSize;
	}

	/**
	 * The maximum size of window Size. <br>
	 * 
	 * @param Nothing
	 * @return Dimension the maximum size of window
	 * @exception Nothing
	 */
	public Dimension getMaximumSize() {

		Dimension maxWindowSize = new Dimension(UPD_MAX_WIDTH, UPD_MAX_HEIGHT);
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

		Dimension minWindowSize = new Dimension(UPD_MIN_WIDTH, UPD_MIN_HEIGHT);
		return minWindowSize;
	}

	/**
	 * Define states of the business. <br>
	 * Define: <br>
	 * Imput state(Ipo5700Input) Change input state(Ipo5700ChangeInput) Confirm
	 * state(Ipo5700Confirm)) Result state(Ipo5700Result)
	 * 
	 * @param stateMap
	 *            Frw00BusinessStateManager Window state management class
	 * @return Frw00BusinessStateManager Window state management class
	 * @exception Nothing
	 */
	protected Frw00BusinessStateManager createBusinessState(
			Frw00BusinessStateManager stateMap) {
		stateMap.addBusinessState(new Ipo5700Input());
		stateMap.addBusinessState(new Ipo5700ChangeInput());
		stateMap.addBusinessState(new Ipo5700Confirm());
		stateMap.addBusinessState(new Ipo5700Result());

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
		showDatetime();
		return new Ipo5700Panel();
	}

	/**
	 * Return the default window state. <br>
	 * 
	 * @param stateMap
	 *            Frw00StateMap Window state management class
	 * @return Frw00BusinessState the first window class that was define in
	 *         Frw00StateMap
	 * @exception Nothing
	 */
	protected Frw00BusinessState getDefaultBusinessState(Frw00StateMap stateMap) {
		return stateMap.getBusinessState(Frw00HeaderData.WNDSTAT_INPUT);
	}
}
