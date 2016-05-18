/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.cbo.cbo5900;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cmn.constant.BusinessRoleInfo;
import jp.co.okasan.cmn.constant.FormCodeInfo;
import jp.co.okasan.frw.pr.MUIActionModeComboBox;
import jp.co.okasan.frw.pr.MUIAmountTextField;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIRefNoTextField;
import jp.co.okasan.frw.pr.MUIShowLabel;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Cbo5900Panel Class's Description<br>
 * <P>
 * Client area class of CboTCorporate_Info screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/07 Create New
 */
public class Cbo5900Panel extends Frw00ClientPanel implements ItemListener {

	// //////// Class Variables //////////

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Flag to mark when need to get and bind data to screen
	 */
	boolean needToGetData = true;

	/** Click F2 When Result State */
	boolean F2 = false;

	/** Hidden Updated Time */
	private String timeStamp;

	/** Entry Mode ComboBox */
	MUIActionModeComboBox cboActionMode = null;

	/** Title label */
	MUILabel lblTitle = null;

	/** Entry Mode label */
	MUILabel lblEntryMode = null;

	/** VND label */
	MUILabel lblVND = null;

	/** Id label */
	MUILabel lblId = null;

	/** Short Name label */
	MUILabel lblShortName = null;

	/** Full Name label */
	MUILabel lblFullName = null;

	/** Business Type label */
	MUILabel lblBusinessType = null;

	/** Authorized Capital label */
	MUILabel lblAuthorizedCapital = null;

	/** Address label */
	MUILabel lblAddress = null;

	/** Tel label */
	MUILabel lblTel = null;

	/** Status label */
	MUILabel lblStatus = null;

	/** Remarks label */
	MUILabel lblRemarks = null;

	/** Reg Date Time label */
	MUILabel lblRegistered = null;

	/** Upd Date Time label */
	MUILabel lblUpdated = null;

	/** Id TextField */
	MUIRefNoTextField txtId = null;

	/** Short Name TextField */
	MUIHalfWidthTextField txtShortName = null;

	/** Full Name TextField */
	MUIHalfWidthTextField txtFullName = null;

	/** Business Type TextField */
	MUIHalfWidthTextField txtBusinessType = null;

	/** Authorized Capital TextField */
	MUIAmountTextField txtAuthorizedCapital = null;

	/** Address TextField */
	MUIHalfWidthTextField txtAddress = null;

	/** Tel TextField */
	MUIHalfWidthTextField txtTel = null;

	/** Remarks TextField */
	MUIHalfWidthTextField txtRemarks = null;

	/** Reg Date Time UIShowLabel */
	MUIShowLabel lblRegUserId = null;

	/** Reg User Id UIShowLabel */
	MUIShowLabel lblRegDateTime = null;

	/** Upd Date Time UIShowLabel */
	MUIShowLabel lblUpdUserId = null;

	/** Upd User Id UIShowLabel */
	MUIShowLabel lblUpdDateTime = null;

	// //////// Methods define //////////

	/**
	 * Constructor <br>
	 * Call constructor base template.
	 * 
	 * @param Nothing
	 * @exception
	 */
	public Cbo5900Panel() {
		super();

		try {

			// Check Business role
			PRHelper.checkRoleEntryFormThrowErr(BusinessRoleInfo.F5900);

			// Init control
			jbInit();
		} catch (Exception e) {

			// Show error dialog
			showErrorDialog(e, true);
		}
	}

	/**
	 * get help control for component<br>
	 * 
	 * @param component
	 *            Component
	 * @return String window help code ID
	 * @exception
	 */
	public String getHelpWindowInfo(Component component) {

		// Create help ID
		String helpId = null;

		// Get default HelpId
		String defaultHelpId = FormCodeInfo.CBOTCORPORATE_INFO_HELP;

		// if Help in keys of table
		if (component.equals(this.txtId)) {
			helpId = defaultHelpId;
		}

		return helpId;
	}

	/**
	 * Method show data<br>
	 * 
	 * @param dataList
	 *            HashMap
	 * @exception Frw10ClientException
	 */
	@SuppressWarnings("rawtypes")
	public void showData(HashMap dataList) throws Frw10ClientException {

		// Set window data
		Frw10WindowDataProc.setWindowData(this, dataList);
	}

	/**
	 * Method create instance of screen's component <br>
	 * 
	 * @param Nothing
	 * @exception Exception
	 */
	private void jbInit() throws Exception {
		// width of label
		final int lblWidthCol1 = 60;

		// Location x of editor
		int xOfEditorCol1 = lblWidthCol1 + 50;

		// Y location
		int y = 20;

		lblEntryMode = new MUILabel();
		lblEntryMode.setOpaque(false);
		lblEntryMode.setText("Ipo5700Panel_lblEntryMode");
		lblEntryMode.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblEntryMode);

		// Entry Mode combobox
		cboActionMode = new MUIActionModeComboBox();
		cboActionMode.setPartsName("actionMode");
		cboActionMode.setLocation(xOfEditorCol1, y);
		cboActionMode.addItemListener(this);
		this.add(cboActionMode);

		y += 25;

		// Id Label
		lblId = new MUILabel();
		lblId.setOpaque(false);
		lblId.setText("Cbo5900Panel_lblId");
		lblId.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblId);

		// Id TextField
		txtId = new MUIRefNoTextField();
		txtId.setBounds(new Rectangle(xOfEditorCol1, y, 55, 20));
		txtId.setMaxLength(8);
		txtId.setPartsName("id");
		this.add(txtId);

		y += 40;

		// Short Name Label
		lblShortName = new MUILabel();
		lblShortName.setOpaque(false);
		lblShortName.setText("Cbo5900Panel_lblShortName");
		lblShortName.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblShortName);

		// Short Name TextField
		txtShortName = new MUIHalfWidthTextField();
		txtShortName.setMaxLength(50);
		txtShortName.setBounds(new Rectangle(xOfEditorCol1, y, 150, 20));
		txtShortName.setAlphabetUpper(false);
		txtShortName.setPartsName("shortName");
		this.add(txtShortName);
		txtShortName.showMandatoryLabel();

		y += 25;

		// Full Name Label
		lblFullName = new MUILabel();
		lblFullName.setOpaque(false);
		lblFullName.setText("Cbo5900Panel_lblFullName");
		lblFullName.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblFullName);

		// Full Name TextField
		txtFullName = new MUIHalfWidthTextField();
		txtFullName.setMaxLength(200);
		txtFullName.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtFullName.setAlphabetUpper(false);
		txtFullName.setPartsName("fullName");
		this.add(txtFullName);

		y += 25;

		// Business Type Label
		lblBusinessType = new MUILabel();
		lblBusinessType.setOpaque(false);
		lblBusinessType.setText("Cbo5900Panel_lblBusinessType");
		lblBusinessType.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblBusinessType);

		// Business Type TextField
		txtBusinessType = new MUIHalfWidthTextField();
		txtBusinessType.setMaxLength(100);
		txtBusinessType.setBounds(new Rectangle(xOfEditorCol1, y, 300, 20));
		txtBusinessType.setAlphabetUpper(false);
		txtBusinessType.setPartsName("businessType");
		this.add(txtBusinessType);

		y += 25;

		// Tel Label
		lblTel = new MUILabel();
		lblTel.setOpaque(false);
		lblTel.setText("Cbo5900Panel_lblTel");
		lblTel.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblTel);

		// Tel TextField
		txtTel = new MUIHalfWidthTextField();
		txtTel.setMaxLength(50);
		txtTel.setBounds(new Rectangle(xOfEditorCol1, y, 150, 20));
		txtTel.setAlphabetUpper(false);
		txtTel.setPartsName("tel");
		this.add(txtTel);

		y += 25;

		// Address Label
		lblAddress = new MUILabel();
		lblAddress.setOpaque(false);
		lblAddress.setText("Cbo5900Panel_lblAddress");
		lblAddress.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblAddress);

		// Address TextField
		txtAddress = new MUIHalfWidthTextField();
		txtAddress.setMaxLength(500);
		txtAddress.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtAddress.setAlphabetUpper(false);
		txtAddress.setPartsName("address");
		this.add(txtAddress);

		y += 25;

		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Cbo5900Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblRemarks);

		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(200);
		txtRemarks.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtRemarks.setAlphabetUpper(false);
		txtRemarks.setPartsName("remarks");
		this.add(txtRemarks);

		// width of label
		final int lblWidthCol2 = 55;
		// Location x of editor
		final int xOfEditorCol2 = txtRemarks.getX() + txtRemarks.getWidth()
				- 130;
		final int xOfLabelCol2 = xOfEditorCol2 - 25 - lblWidthCol2;

		// Authorized Capital Label
		lblAuthorizedCapital = new MUILabel();
		lblAuthorizedCapital.setOpaque(false);
		lblAuthorizedCapital.setText("Cbo5900Panel_lblAuthorizedCapital");
		lblAuthorizedCapital.setBounds(new Rectangle(xOfLabelCol2,
				lblBusinessType.getY(), lblWidthCol2, 20));
		this.add(lblAuthorizedCapital);

		// Authorized Capital TextField
		txtAuthorizedCapital = new MUIAmountTextField();
		txtAuthorizedCapital.setBounds(new Rectangle(xOfEditorCol2,
				lblAuthorizedCapital.getY(), 100, 20));
		txtAuthorizedCapital.setMaxLength(18);
		txtAuthorizedCapital.setPartsName("authorizedCapital");
		this.add(txtAuthorizedCapital);

		// VND label
		MUILabel lblVND = new MUILabel();
		lblVND.setOpaque(false);
		lblVND.setText("VND");
		lblVND.setBounds(new Rectangle(txtAuthorizedCapital.getX()
				+ txtAuthorizedCapital.getWidth() + 5, txtAuthorizedCapital
				.getY(), 25, 20));
		this.add(lblVND);

		// Register and update time info
		int yOfRegister = txtRemarks.getY() + txtRemarks.getHeight() + 10;

		// Registed Label
		lblRegistered = new MUILabel();
		lblRegistered.setOpaque(false);
		lblRegistered.setText("Ipo5700Panel_lblRegistered");
		lblRegistered
				.setBounds(new Rectangle(25, yOfRegister, lblWidthCol1, 20));
		this.add(lblRegistered);

		// Registed user Label
		lblRegDateTime = new MUIShowLabel();
		lblRegDateTime.setPartsName("RegDateTime");
		lblRegDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfRegister, 100,
				20));
		this.add(lblRegDateTime);

		// Registed user Label
		lblRegUserId = new MUIShowLabel();
		lblRegUserId.setPartsName("RegUserId");
		lblRegUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblRegDateTime.getWidth(), yOfRegister, 200, 20));
		this.add(lblRegUserId);

		// Updated Label
		lblUpdated = new MUILabel();
		lblUpdated.setOpaque(false);
		lblUpdated.setText("Ipo5700Panel_lblUpdated");
		lblUpdated.setBounds(new Rectangle(25, yOfRegister + 25, lblWidthCol1,
				20));
		this.add(lblUpdated);

		// Updated user show label
		lblUpdDateTime = new MUIShowLabel();
		lblUpdDateTime.setPartsName("UpdDateTime");
		lblUpdDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfRegister + 25,
				100, 20));
		this.add(lblUpdDateTime);

		// Updated user show label
		lblUpdUserId = new MUIShowLabel();
		lblUpdUserId.setPartsName("UpdUserId");
		lblUpdUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblUpdDateTime.getWidth(), yOfRegister + 25, 200, 20));
		this.add(lblUpdUserId);
	}

	/**
	 * Get Hidden Updated Time<br>
	 * 
	 * @param
	 * @return String
	 * @exception
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Set Hidden Updated Time<br>
	 * 
	 * @param
	 * @return String
	 * @exception
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(this.cboActionMode)
				&& e.getStateChange() == ItemEvent.SELECTED) {

			// If is entry mode
			if (ItemValidator.isEntryMode(cboActionMode)) {
				this.txtId.setEnabled(false);
				this.txtId.reset();
				this.txtId.hiddenMandatoryLabel();
				this.txtId.hiddenHelpLabel();
			} else {
				this.txtId.setEnabled(true);
				this.txtId.showMandatoryLabel();
				this.txtId.showHelpLabel();
			}
		}
	}
}
