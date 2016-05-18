/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cmn.constant.BusinessRoleInfo;
import jp.co.okasan.cmn.constant.FormCodeInfo;
import jp.co.okasan.cmn.constant.InsertNullItemType;
import jp.co.okasan.cmn.constant.gui.ComboInfo;
import jp.co.okasan.frw.pr.MUIActionModeComboBox;
import jp.co.okasan.frw.pr.MUIAmountTextField;
import jp.co.okasan.frw.pr.MUIComboBox;
import jp.co.okasan.frw.pr.MUIHalfWidthANTextField;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIRefNoTextField;
import jp.co.okasan.frw.pr.MUIShowLabel;
import jp.co.okasan.frw.pr.MUITabPane;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Ipo5700Panel Class's Description<br>
 * <P>
 * Client area class of IpoTInfo screen.
 * </p>
 * 
 * @author: HungKieu 2015/01/08 Create New
 */
public class Ipo5700Panel extends Frw00ClientPanel implements ActionListener {

	// //////// Class Variables //////////

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Flag to mark when need to get and bind data to screen
	 */
	boolean needToGetData = true;

	/** Hidden Updated Time */
	private String timeStamp;

	/** Entry Mode ComboBox */
	MUIActionModeComboBox cboActionMode = null;

	/** Entry Mode label */
	MUILabel lblEntryMode = null;

	/** Id label */
	MUILabel lblId = null;

	/** Ipo Cd label */
	MUILabel lblIpoCd = null;

	/** Ipo Name label */
	MUILabel lblIpoName = null;

	/** Business Type label */
	MUILabel lblBusinessType = null;

	/** Authorized Capital label */
	MUILabel lblAuthorizedCapital = null;

	/** Ipo Type label */
	MUILabel lblIpoType = null;

	/** Address label */
	MUILabel lblAddress = null;

	/** Tel label */
	MUILabel lblTel = null;

	/** Ipo Address label */
	MUILabel lblIpoAddress = null;

	/** Cash Receive Address label */
	MUILabel lblCashReceiveAddress = null;

	/** Remarks label */
	MUILabel lblRemarks = null;

	/** Reg Date Time label */
	MUILabel lblRegistered = null;

	/** Upd Date Time label */
	MUILabel lblUpdated = null;

	/** Id TextField */
	MUIRefNoTextField txtId = null;

	/** Ipo Cd TextField */
	MUIHalfWidthANTextField txtIpoCd = null;

	/** Ipo Name TextField */
	MUIHalfWidthTextField txtIpoName = null;

	/** Business Type TextField */
	MUIHalfWidthTextField txtBusinessType = null;

	/** Authorized Capital TextField */
	MUIAmountTextField txtAuthorizedCapital = null;

	/** Ipo Type TextField */
	MUIComboBox cboIpoType = null;

	/** Address TextField */
	MUIHalfWidthTextField txtAddress = null;

	/** Tel TextField */
	MUIHalfWidthANTextField txtTel = null;

	/** Ipo Address TextField */
	MUIHalfWidthTextField txtIpoAddress = null;

	/** Cash Receive Address TextField */
	MUIHalfWidthTextField txtCashReceiveAddress = null;

	/** Reg Date Time UIShowLabel */
	MUIShowLabel lblRegUserId = null;

	/** Reg User Id UIShowLabel */
	MUIShowLabel lblRegDateTime = null;

	/** Upd Date Time UIShowLabel */
	MUIShowLabel lblUpdUserId = null;

	/** Upd User Id UIShowLabel */
	MUIShowLabel lblUpdDateTime = null;

	/** VND label */
	MUILabel lblVND = null;

	/** Tab Panel */
	MUITabPane tabPanel = null;

	/** tab1 */
	Ipo5700_01Panel pnlSub1 = null;

	/** tab 2 */
	Ipo5700_02Panel pnlSub2 = null;

	boolean isPanel01Help = false;

	// //////// Methods define //////////

	/**
	 * Constructor <br>
	 * Call constructor base template.
	 * 
	 * @param Nothing
	 * @exception
	 */
	public Ipo5700Panel() {
		super();

		try {
			// Check Business role
			PRHelper.checkRoleEntryFormThrowErr(BusinessRoleInfo.F5700);

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
		String defaultHelpId = FormCodeInfo.IPOTINFO_HELP;

		// if Help in keys of table
		if (component.equals(this.txtId)) {
			helpId = defaultHelpId;
		} else if (component.equals(pnlSub1.txtSubAccoCd)) {
			isPanel01Help = true;
			helpId = FormCodeInfo.CORTSUB_ACCOUNT_HELP;

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
		if (isPanel01Help) {
			pnlSub1.showData(dataList);
			isPanel01Help = false;
		} else {
			// Set window data
			Frw10WindowDataProc.setWindowData(this, dataList);
		}
	}

	/**
	 * Method create instance of screen's component <br>
	 * 
	 * @param Nothing
	 * @exception Exception
	 */
	private void jbInit() throws Exception {
		// width of label
		final int lblWidthCol1 = 90;

		// Location x of editor
		int xOfEditorCol1 = lblWidthCol1 + 50;

		// Y location
		int y = 20;

		lblEntryMode = new MUILabel();
		lblEntryMode.setOpaque(false);
		lblEntryMode.setText("Ipo5700Panel_lblEntryMode");
		lblEntryMode.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblEntryMode);

		// Entry Mode comboBox
		cboActionMode = new MUIActionModeComboBox();
		cboActionMode.setPartsName("actionMode");
		cboActionMode.setLocation(xOfEditorCol1, y);
		cboActionMode.addActionListener(this);
		this.add(cboActionMode);

		y = y + 25;

		// Id Label
		lblId = new MUILabel();
		lblId.setOpaque(false);
		lblId.setText("Ipo5700Panel_lblId");
		lblId.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblId);

		// Id TextField
		txtId = new MUIRefNoTextField();
		txtId.setBounds(new Rectangle(xOfEditorCol1, y, 55, 20));
		txtId.setMaxLength(8);
		txtId.setPartsName("id");
		this.add(txtId);
		txtId.showHelpLabel();
		txtId.showMandatoryLabel();

		y = y + 40;

		// IpoCd Label
		lblIpoCd = new MUILabel();
		lblIpoCd.setOpaque(false);
		lblIpoCd.setText("Ipo5700Panel_lblIpoCd");
		lblIpoCd.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblIpoCd);

		// IpoCd TextField
		txtIpoCd = new MUIHalfWidthANTextField();
		txtIpoCd.setMaxLength(50);
		txtIpoCd.setBounds(new Rectangle(xOfEditorCol1, y, 150, 20));
		txtIpoCd.setPartsName("ipoCd");
		txtIpoCd.setAlphabetUpper(false);
		this.add(txtIpoCd);
		txtIpoCd.showMandatoryLabel();

		y += 25;

		// IpoName Label
		lblIpoName = new MUILabel();
		lblIpoName.setOpaque(false);
		lblIpoName.setText("Ipo5700Panel_lblIpoName");
		lblIpoName.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblIpoName);

		// IpoName TextField
		txtIpoName = new MUIHalfWidthTextField();
		txtIpoName.setMaxLength(200);
		txtIpoName.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtIpoName.setAlphabetUpper(false);
		txtIpoName.setPartsName("ipoName");
		this.add(txtIpoName);
		txtIpoName.showMandatoryLabel();

		y += 25;

		// Business Type Label
		lblBusinessType = new MUILabel();
		lblBusinessType.setOpaque(false);
		lblBusinessType.setText("Ipo5700Panel_lblBusinessType");
		lblBusinessType.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblBusinessType);

		// Business Type TextField
		txtBusinessType = new MUIHalfWidthTextField();
		txtBusinessType.setMaxLength(500);
		txtBusinessType.setBounds(new Rectangle(xOfEditorCol1, y, 300, 20));
		txtBusinessType.setAlphabetUpper(false);
		txtBusinessType.setPartsName("businessType");
		this.add(txtBusinessType);

		y += 25;

		// Ipo Type Label
		lblIpoType = new MUILabel();
		lblIpoType.setOpaque(false);
		lblIpoType.setText("Ipo5700Panel_lblIpoType");
		lblIpoType.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblIpoType);

		// Ipo Type TextField
		cboIpoType = new MUIComboBox(ComboInfo.IPOTINFO_TYPE,
				InsertNullItemType.NONE, "", "");
		cboIpoType.setBounds(new Rectangle(xOfEditorCol1, y, 100, 20));
		cboIpoType.setPartsName("ipoType");
		this.add(cboIpoType);

		y += 25;

		// Address Label
		lblAddress = new MUILabel();
		lblAddress.setOpaque(false);
		lblAddress.setText("Ipo5700Panel_lblAddress");
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

		// Ipo Address Label
		lblIpoAddress = new MUILabel();
		lblIpoAddress.setOpaque(false);
		lblIpoAddress.setText("Ipo5700Panel_lblIpoAddress");
		lblIpoAddress.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblIpoAddress);

		// Ipo Address TextField
		txtIpoAddress = new MUIHalfWidthTextField();
		txtIpoAddress.setMaxLength(500);
		txtIpoAddress.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtIpoAddress.setAlphabetUpper(false);
		txtIpoAddress.setPartsName("ipoAddress");
		this.add(txtIpoAddress);

		y += 25;

		// Cash Receive Address Label
		lblCashReceiveAddress = new MUILabel();
		lblCashReceiveAddress.setOpaque(false);
		lblCashReceiveAddress.setText("Ipo5700Panel_lblCashReceiveAddress");
		lblCashReceiveAddress.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblCashReceiveAddress);

		// Cash Receive Address TextField
		txtCashReceiveAddress = new MUIHalfWidthTextField();
		txtCashReceiveAddress.setMaxLength(500);
		txtCashReceiveAddress
				.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtCashReceiveAddress.setAlphabetUpper(false);
		txtCashReceiveAddress.setPartsName("cashReceiveAddress");
		this.add(txtCashReceiveAddress);

		y += 25;

		// Begin define column 2
		int xOfEditorCol2 = txtCashReceiveAddress.getX()
				+ txtCashReceiveAddress.getWidth() - 150;
		int lblWidthLabelCol2 = 55;
		int xOfLblCol2 = xOfEditorCol2 - lblWidthLabelCol2 - 50;

		// Authorized Capital Label
		lblAuthorizedCapital = new MUILabel();
		lblAuthorizedCapital.setOpaque(false);
		lblAuthorizedCapital.setText("Ipo5700Panel_lblAuthorizedCapital");
		lblAuthorizedCapital.setBounds(new Rectangle(xOfLblCol2,
				lblBusinessType.getY(), lblWidthLabelCol2, 20));
		this.add(lblAuthorizedCapital);

		// Authorized Capital TextField
		txtAuthorizedCapital = new MUIAmountTextField();
		txtAuthorizedCapital.setLocation(xOfEditorCol2, lblBusinessType.getY());
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

		// Tel Label
		lblTel = new MUILabel();
		lblTel.setOpaque(false);
		lblTel.setText("Ipo5700Panel_lblTel");
		lblTel.setBounds(new Rectangle(xOfLblCol2, cboIpoType.getY(),
				lblWidthLabelCol2, 20));
		this.add(lblTel);

		// Tel TextField
		txtTel = new MUIHalfWidthANTextField();
		txtTel.setMaxLength(200);
		txtTel.setBounds(new Rectangle(xOfEditorCol2, cboIpoType.getY(), 150,
				20));
		txtTel.setAlphabetUpper(false);
		txtTel.setPartsName("tel");
		this.add(txtTel);

		// Tab panel declare here
		tabPanel = new MUITabPane();
		tabPanel.setBounds(new Rectangle(25, txtCashReceiveAddress.getY() + 30,
				750, 300));
		tabPanel.setTabLayoutPolicy(0);
		this.add(tabPanel);

		// Add panel in tab 1
		pnlSub1 = new Ipo5700_01Panel();
		pnlSub1.parentPanel = this;
		tabPanel.addTab("Ipo5700_01Panel", pnlSub1);

		// // Add panel in tab 2
		pnlSub2 = new Ipo5700_02Panel();
		pnlSub2.parentPanel = this;
		tabPanel.addTab("Ipo5700_02Panel", pnlSub2);

		// Register and update time info
		int yOfRegister = tabPanel.getY() + tabPanel.getHeight() + 10;

		// Registed Label
		lblRegistered = new MUILabel();
		lblRegistered.setOpaque(false);
		lblRegistered.setText("Ipo5700Panel_lblRegistered");
		lblRegistered
				.setBounds(new Rectangle(25, yOfRegister, lblWidthCol1, 20));
		this.add(lblRegistered);

		// Registed user Label
		lblRegUserId = new MUIShowLabel();
		lblRegUserId.setPartsName("RegUserId");
		lblRegUserId.setBounds(new Rectangle(xOfEditorCol1, yOfRegister, 200,
				20));
		this.add(lblRegUserId);

		// Updated Label
		lblUpdated = new MUILabel();
		lblUpdated.setOpaque(false);
		lblUpdated.setText("Ipo5700Panel_lblUpdated");
		lblUpdated.setBounds(new Rectangle(25, yOfRegister + 25, lblWidthCol1,
				20));
		this.add(lblUpdated);

		// Updated user show label
		lblUpdUserId = new MUIShowLabel();
		lblUpdUserId.setPartsName("UpdUserId");
		lblUpdUserId.setBounds(new Rectangle(xOfEditorCol1, yOfRegister + 25,
				200, 20));
		this.add(lblUpdUserId);

		// Init component
		setInitStatusConponent();
	}

	/**
	 * init status of controls depend on each other
	 * 
	 * @param
	 * @return nothing
	 * @exception
	 */
	private void setInitStatusConponent() {
		boolean isEntryMode = ItemValidator.isEntryMode(this.cboActionMode);
		this.txtId.setEditable(!isEntryMode);

		if (isEntryMode) {
			txtId.hiddenMandatoryLabel();
			txtId.hiddenHelpLabel();
		} else {
			txtId.showMandatoryLabel();
			txtId.showHelpLabel();
		}
	}

	protected void setEnabledControl(boolean param) {
		txtIpoCd.setEnabled(param);
		txtIpoName.setEnabled(param);
		txtBusinessType.setEnabled(param);
		cboIpoType.setEnabled(param);
		txtAddress.setEnabled(param);
		txtAuthorizedCapital.setEnabled(param);
		txtCashReceiveAddress.setEnabled(param);
		txtIpoAddress.setEnabled(param);
		txtTel.setEnabled(param);
	}

	/**
	 * Disable id text box in entry mode<br>
	 * 
	 * @param
	 * @return nothing
	 * @exception
	 */
	private void actionModeChange() {
		boolean isEntryMode = ItemValidator.isEntryMode(this.cboActionMode);
		this.txtId.setEditable(!isEntryMode);
		if (isEntryMode) {
			txtId.hiddenMandatoryLabel();
			txtId.hiddenHelpLabel();
			this.txtId.reset();
		} else {
			txtId.showMandatoryLabel();
			txtId.showHelpLabel();
		}
	}

	void resetControl() {
		// If mode is entry, clear id
		if (ItemValidator.isEntryMode(this.cboActionMode)) {
			this.txtId.reset();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.cboActionMode) {
			this.actionModeChange();
		}
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
}
