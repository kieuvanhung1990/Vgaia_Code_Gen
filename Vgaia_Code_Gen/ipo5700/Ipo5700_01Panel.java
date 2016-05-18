/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.okasan.cm.hlp.hlp6130.Hlp6130ResultData;
import jp.co.okasan.cmn.constant.FormCodeInfo;
import jp.co.okasan.cmn.constant.InsertNullItemType;
import jp.co.okasan.cmn.constant.gui.ComboInfo;
import jp.co.okasan.frw.pr.MUIAmountTextField;
import jp.co.okasan.frw.pr.MUIComboBox;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIQuantityTextField;
import jp.co.okasan.frw.pr.MUIRateTextField;
import jp.co.okasan.frw.pr.MUIShowLabel;
import jp.co.okasan.frw.pr.MUISubAccountTextField;
import jp.co.okasan.frw.pr.UIDateChooserButton;
import jp.co.okasan.frw.pr.UIDateYMDTextField2;
import jp.co.okasan.frw.pr.UIHalfWidthTextField2;

/**
 * Ipo5700_01Panel Class's Description<br>
 * <P>
 * Client area class.
 * </p>
 * 
 * @author: HungKieu 2016/03/22 Create New
 */
public class Ipo5700_01Panel extends Frw00ClientPanel implements FocusListener {

	// //////// Class Variables //////////

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Index on tab */
	public static int INDEX_ON_TAB = 0;

	/* refer to parent */
	Ipo5700Panel parentPanel;

	/** VND label */
	MUILabel lblVND = null;

	/** Sec Type label */
	MUILabel lblSecType = null;

	/** Qty label */
	MUILabel lblQty = null;

	/** Face Val Price label */
	MUILabel lblFaceValPrice = null;

	/** Begin Price label */
	MUILabel lblBeginPrice = null;

	/** Price Step label */
	MUILabel lblPriceStep = null;

	/** Qty Step label */
	MUILabel lblQtyStep = null;

	/** Deposit Rate label */
	MUILabel lblDepositRate = null;

	/** Is Period label */
	MUILabel lblIsPriority = null;

	/** Ipo Date label */
	MUILabel lblIpoDate = null;

	/** Begin Reg Date label */
	MUILabel lblBeginRegDate = null;

	/** End Reg Date label */
	MUILabel lblEndRegDate = null;

	/** Begin Pay Date label */
	MUILabel lblBeginPayDate = null;

	/** End Pay Date label */
	MUILabel lblEndPayDate = null;

	/** Sub Acco Cd label */
	MUILabel lblSubAccoCd = null;

	/** Cust Name label */
	MUIShowLabel slblCustName = null;

	/** Status label */
	MUILabel lblStatus = null;

	/** Remarks label */
	MUILabel lblRemarks = null;

	/** Reg Date Time label */
	MUILabel lblRegistered = null;

	/** Upd Date Time label */
	MUILabel lblUpdated = null;

	/** Sec Type TextField */
	MUIComboBox cboSecType = null;

	/** Qty TextField */
	MUIQuantityTextField txtQty = null;

	/** Face Val Price TextField */
	MUIAmountTextField txtFaceValPrice = null;

	/** Begin Price TextField */
	MUIAmountTextField txtBeginPrice = null;

	/** Price Step TextField */
	MUIAmountTextField txtPriceStep = null;

	/** Qty Step TextField */
	MUIQuantityTextField txtQtyStep = null;

	/** Deposit Rate TextField */
	MUIRateTextField txtDepositRate = null;

	/** Is priority TextField */
	MUIComboBox cboPriority = null;

	/** Ipo Date TextField */
	UIDateYMDTextField2 txtIpoDate = null;

	/** Button ValidDate */
	UIDateChooserButton btnIpoDate = new UIDateChooserButton();

	/** Begin Reg Date TextField */
	UIDateYMDTextField2 txtBeginRegDate = null;

	/** Button BeginRegDate */
	UIDateChooserButton btnBeginRegDate = new UIDateChooserButton();

	/** End Reg Date TextField */
	UIDateYMDTextField2 txtEndRegDate = null;

	/** ~ label */
	MUILabel lblSeperatRegDate = null;

	/** ~ label */
	MUILabel lblSeperatPayDate = null;

	/** Button EndRegDate */
	UIDateChooserButton btnEndRegDate = new UIDateChooserButton();

	/** Begin Pay Date TextField */
	UIDateYMDTextField2 txtBeginPayDate = null;

	/** Button BeginPayDate */
	UIDateChooserButton btnBeginPayDate = new UIDateChooserButton();

	/** End Pay Date TextField */
	UIDateYMDTextField2 txtEndPayDate = null;

	/** Button EndPayDate */
	UIDateChooserButton btnEndPayDate = new UIDateChooserButton();

	/** Sub Acco Cd TextField */
	MUISubAccountTextField txtSubAccoCd = null;

	/** Remarks TextField */
	MUIHalfWidthTextField txtRemarks = null;

	/** UpdateFlg */
	UIHalfWidthTextField2 txtUpdateFlg = null;

	// //////// Methods define //////////

	/**
	 * Constructor <br>
	 * Call constructor base template.
	 * 
	 * @param Nothing
	 * @exception
	 */
	public Ipo5700_01Panel() {
		super();

		try {
			// Initial control
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

		// if Help in keys of table
		if (component.equals(this.txtSubAccoCd)) {
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

		/** Update Flag */
		txtUpdateFlg = new UIHalfWidthTextField2();
		txtUpdateFlg.setBounds(new Rectangle(500, 25, 30, 20));
		txtUpdateFlg.setPartsName("updateFlag01");
		txtUpdateFlg.setVisible(false);
		this.add(txtUpdateFlg);

		/** width of label */
		final int lblWidthCol1 = 65;

		/** Location x of editor */
		int xOfEditorCol1 = lblWidthCol1 + 50;

		int y = 15;

		// Sec Type Label
		lblSecType = new MUILabel();
		lblSecType.setOpaque(false);
		lblSecType.setText("Ipo5700Panel_lblSecType");
		lblSecType.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblSecType);

		// Sec Type TextField
		cboSecType = new MUIComboBox(ComboInfo.IPOTINFO_SEC_TYPE,
				InsertNullItemType.NONE, "", "");
		cboSecType.setBounds(new Rectangle(xOfEditorCol1, y, 100, 20));
		cboSecType.setPartsName("secType");
		this.add(cboSecType);

		y += 25;

		// Face Val Price Label
		lblFaceValPrice = new MUILabel();
		lblFaceValPrice.setOpaque(false);
		lblFaceValPrice.setText("Ipo5700Panel_lblFaceValPrice");
		lblFaceValPrice.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblFaceValPrice);

		// Face Val Price TextField
		txtFaceValPrice = new MUIAmountTextField();
		txtFaceValPrice.setLocation(xOfEditorCol1, y);
		txtFaceValPrice.setPartsName("faceValPrice");
		this.add(txtFaceValPrice);

		// VND label
		MUILabel lblVND = new MUILabel();
		lblVND.setOpaque(false);
		lblVND.setText("VND");
		lblVND.setBounds(new Rectangle(txtFaceValPrice.getX()
				+ txtFaceValPrice.getWidth() + 5, txtFaceValPrice.getY(), 25,
				20));
		this.add(lblVND);

		y += 25;

		// Price Step Label
		lblPriceStep = new MUILabel();
		lblPriceStep.setOpaque(false);
		lblPriceStep.setText("Ipo5700Panel_lblPriceStep");
		lblPriceStep.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblPriceStep);

		// Price Step TextField
		txtPriceStep = new MUIAmountTextField();
		txtPriceStep.setLocation(xOfEditorCol1, y);
		txtPriceStep.setPartsName("priceStep");
		this.add(txtPriceStep);

		y += 25;

		// Deposit Rate Label
		lblDepositRate = new MUILabel();
		lblDepositRate.setOpaque(false);
		lblDepositRate.setText("Ipo5700Panel_lblDepositRate");
		lblDepositRate.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblDepositRate);

		// Deposit Rate TextField
		txtDepositRate = new MUIRateTextField();
		txtDepositRate.setLocation(xOfEditorCol1, y);
		txtDepositRate.setPartsName("depositRate");
		this.add(txtDepositRate);

		y += 25;

		// Ipo Date Label
		lblIpoDate = new MUILabel();
		lblIpoDate.setOpaque(false);
		lblIpoDate.setText("Ipo5700Panel_lblIpoDate");
		lblIpoDate.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblIpoDate);

		// Ipo Date TextField
		txtIpoDate = new UIDateYMDTextField2();
		txtIpoDate.setBounds(new Rectangle(xOfEditorCol1, y, 65, 20));
		txtIpoDate.setPartsName("ipoDate");
		this.add(txtIpoDate);
		btnIpoDate.setDateComp(txtIpoDate);
		this.add(btnIpoDate);
		txtIpoDate.showMandatoryLabel();

		y += 25;

		// BeginPayDate Label
		lblBeginPayDate = new MUILabel();
		lblBeginPayDate.setOpaque(false);
		lblBeginPayDate.setText("Ipo5700Panel_lblBeginPayDate");
		lblBeginPayDate.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblBeginPayDate);

		// BeginPay Date TextField
		txtBeginPayDate = new UIDateYMDTextField2();
		txtBeginPayDate.setBounds(new Rectangle(xOfEditorCol1, y, 65, 20));
		txtBeginPayDate.setPartsName("beginPayDate");
		this.add(txtBeginPayDate);
		btnBeginPayDate.setDateComp(txtBeginPayDate);
		this.add(btnBeginPayDate);
		txtBeginPayDate.showMandatoryLabel();

		lblSeperatPayDate = new MUILabel();
		lblSeperatPayDate.setOpaque(false);
		lblSeperatPayDate.setText("~", false);
		lblSeperatPayDate.setBounds(new Rectangle(btnBeginPayDate.getX()
				+ btnBeginPayDate.getWidth() + 20, y, 20, 20));
		this.add(lblSeperatPayDate);

		// EndPayDate Date TextField
		txtEndPayDate = new UIDateYMDTextField2();
		txtEndPayDate.setBounds(new Rectangle(lblSeperatPayDate.getX()
				+ lblSeperatPayDate.getWidth() + 10, y, 65, 20));
		txtEndPayDate.setPartsName("endPayDate");
		this.add(txtEndPayDate);
		btnEndPayDate.setDateComp(txtEndPayDate);
		this.add(btnEndPayDate);
		txtEndPayDate.showMandatoryLabel();

		y += 25;

		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Ipo5700Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblRemarks);

		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(200);
		txtRemarks.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtRemarks.setAlphabetUpper(false);
		txtRemarks.setPartsName("remarks01");
		this.add(txtRemarks);

		// Define column 2
		int xOfLabelCol2 = txtEndPayDate.getX() + txtEndPayDate.getWidth() + 50;
		int lblWidthCol2 = 70;
		int xOfEditorCol2 = xOfLabelCol2 + lblWidthCol2 + 25;

		// Qty Label
		lblQty = new MUILabel();
		lblQty.setOpaque(false);
		lblQty.setText("Ipo5700Panel_lblQty");
		lblQty.setBounds(new Rectangle(xOfLabelCol2, cboSecType.getY(),
				lblWidthCol2, 20));
		this.add(lblQty);

		// Qty TextField
		txtQty = new MUIQuantityTextField();
		txtQty.setLocation(xOfEditorCol2, lblQty.getY());
		txtQty.setPartsName("qty");
		this.add(txtQty);

		// Begin Price Label
		lblBeginPrice = new MUILabel();
		lblBeginPrice.setOpaque(false);
		lblBeginPrice.setText("Ipo5700Panel_lblBeginPrice");
		lblBeginPrice.setBounds(new Rectangle(xOfLabelCol2, lblFaceValPrice
				.getY(), lblWidthCol2, 20));
		this.add(lblBeginPrice);

		// Begin Price TextField
		txtBeginPrice = new MUIAmountTextField();
		txtBeginPrice.setLocation(xOfEditorCol2, lblBeginPrice.getY());
		txtBeginPrice.setPartsName("beginPrice");
		this.add(txtBeginPrice);

		// VND label
		MUILabel lblVND2 = new MUILabel();
		lblVND2.setOpaque(false);
		lblVND2.setText("VND");
		lblVND2.setBounds(new Rectangle(txtBeginPrice.getX()
				+ txtBeginPrice.getWidth() + 5, txtBeginPrice.getY(), 25, 20));
		this.add(lblVND2);

		// Qty Step Label
		lblQtyStep = new MUILabel();
		lblQtyStep.setOpaque(false);
		lblQtyStep.setText("Ipo5700Panel_lblQtyStep");
		lblQtyStep.setBounds(new Rectangle(xOfLabelCol2, lblPriceStep.getY(),
				lblWidthCol2, 20));
		this.add(lblQtyStep);

		// Qty Step TextField
		txtQtyStep = new MUIQuantityTextField();
		txtQtyStep.setLocation(xOfEditorCol2, lblPriceStep.getY());
		txtQtyStep.setPartsName("qtyStep");
		this.add(txtQtyStep);

		// Is Priority Label
		lblIsPriority = new MUILabel();
		lblIsPriority.setOpaque(false);
		lblIsPriority.setText("Ipo5700Panel_lblIsPriority");
		lblIsPriority.setBounds(new Rectangle(xOfLabelCol2, lblDepositRate
				.getY(), lblWidthCol2, 20));
		this.add(lblIsPriority);

		// Is Priority TextField
		cboPriority = new MUIComboBox(ComboInfo.YES_NO,
				InsertNullItemType.NONE, "", "");
		cboPriority.setBounds(new Rectangle(xOfEditorCol2, lblDepositRate
				.getY(), 100, 20));
		cboPriority.setPartsName("isPriority");
		this.add(cboPriority);

		// Begin Reg Date Label
		lblBeginRegDate = new MUILabel();
		lblBeginRegDate.setOpaque(false);
		lblBeginRegDate.setText("Ipo5700Panel_lblBeginRegDate");
		lblBeginRegDate.setBounds(new Rectangle(xOfLabelCol2,
				lblIpoDate.getY(), lblWidthCol2, 20));
		this.add(lblBeginRegDate);

		// Begin Reg Date TextField
		txtBeginRegDate = new UIDateYMDTextField2();
		txtBeginRegDate = new UIDateYMDTextField2();
		txtBeginRegDate.setBounds(new Rectangle(xOfEditorCol2, lblBeginRegDate
				.getY(), 65, 20));
		txtBeginRegDate.setPartsName("beginRegDate");
		this.add(txtBeginRegDate);
		btnBeginRegDate.setDateComp(txtBeginRegDate);
		this.add(btnBeginRegDate);
		txtBeginRegDate.showMandatoryLabel();

		lblSeperatRegDate = new MUILabel();
		lblSeperatRegDate.setOpaque(false);
		lblSeperatRegDate.setText("~", false);
		lblSeperatRegDate.setBounds(new Rectangle(btnBeginRegDate.getX()
				+ btnBeginRegDate.getWidth() + 20, lblBeginRegDate.getY(), 20,
				20));
		this.add(lblSeperatRegDate);

		// EndRegDate Date TextField
		txtEndRegDate = new UIDateYMDTextField2();
		txtEndRegDate.setBounds(new Rectangle(lblSeperatRegDate.getX()
				+ lblSeperatRegDate.getWidth() + 10, lblBeginRegDate.getY(),
				65, 20));
		txtEndRegDate.setPartsName("endRegDate");
		this.add(txtEndRegDate);
		btnEndRegDate.setDateComp(txtEndRegDate);
		this.add(btnEndRegDate);
		txtEndRegDate.showMandatoryLabel();

		// Sub Acco Cd Label
		lblSubAccoCd = new MUILabel();
		lblSubAccoCd.setOpaque(false);
		lblSubAccoCd.setText("Ipo5700Panel_lblSubAccoCd");
		lblSubAccoCd.setBounds(new Rectangle(xOfLabelCol2, lblBeginPayDate
				.getY(), lblWidthCol2, 20));
		this.add(lblSubAccoCd);

		// Sub Acco No TextField
		txtSubAccoCd = new MUISubAccountTextField();
		txtSubAccoCd.setFormId(FormCodeInfo.IPOTINFO_MASTER);
		txtSubAccoCd.setAllowNull(true);
		txtSubAccoCd.setGetSubAccoData(true);
		txtSubAccoCd.setLocation(xOfEditorCol2, txtBeginPayDate.getY());
		txtSubAccoCd.addFocusListener(this);
		txtSubAccoCd.setPartsName("subAccoNo");
		txtSubAccoCd.setVisible(true);
		this.add(txtSubAccoCd);
		txtSubAccoCd.showHelpLabel();

		final int xOfCustNameLabel = xOfEditorCol2 + txtSubAccoCd.getWidth()
				+ 20;

		// registered show label
		slblCustName = new MUIShowLabel();
		slblCustName.setPartsName("custName");
		slblCustName.setBounds(new Rectangle(xOfCustNameLabel, txtSubAccoCd
				.getY(), 150, 20));
		this.add(slblCustName);

	}

	// Set enable component in panel
	protected void setEnabledControl(boolean param) {

		this.btnBeginPayDate.setEnabled(param);
		this.btnBeginRegDate.setEnabled(param);
		this.btnEndPayDate.setEnabled(param);
		this.btnEndRegDate.setEnabled(param);
		this.btnIpoDate.setEnabled(param);
	}

	/**
	 * Focus gained handler<br>
	 * 
	 * @param e
	 *            FocusEvent
	 * @return Void
	 * @exception
	 */
	public void focusGained(FocusEvent e) {
	}

	/**
	 * Focus lost handler<br>
	 * 
	 * @param e
	 *            FocusEvent
	 * @return Void
	 * @exception
	 */
	public void focusLost(FocusEvent e) {
		// Bind customer info if txtCustNo focus lost
		if (e.getComponent() == this.txtSubAccoCd) {
			bindCustomerInfo();
		}
	}

	/**
	 * AmountAvail.<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws ClassNotFoundException
	 * @throws Frw10ClientException
	 */
	public void bindCustomerInfo() {
		this.slblCustName.setText("");

		if (this.txtSubAccoCd.isValid()
				&& this.txtSubAccoCd.getSubAccountData() != null) {
			Hlp6130ResultData subAccData = this.txtSubAccoCd
					.getSubAccountData();

			// set custName
			slblCustName.setText(subAccData.getCustFullName());
		}
	}
}
