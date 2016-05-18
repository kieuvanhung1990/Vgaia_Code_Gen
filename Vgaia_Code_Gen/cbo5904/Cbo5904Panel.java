/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.cbo.cbo5904;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JComponent;

import jp.co.nec.frw0000.pr.util.Frw00TransferKeyData;
import jp.co.nec.frw0000.pr.view.Frw00BaseTemplateFrame;
import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw0000.pr.view.Frw00HelpBaseTemplateFrame;
import jp.co.nec.frw0000.pr.winctl.Frw00WindowController;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.okasan.cm.cbo.cbo5901.Cbo5901ResultData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904ResultData;
import jp.co.okasan.cm.hlp.hlp6130.Hlp6130ResultData;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cmn.constant.BusinessRoleInfo;
import jp.co.okasan.cmn.constant.BuySellInfo;
import jp.co.okasan.cmn.constant.CodeGroupNameInfo;
import jp.co.okasan.cmn.constant.FormCodeInfo;
import jp.co.okasan.cmn.constant.InsertNullItemType;
import jp.co.okasan.cmn.constant.cbo.CboTIntPaymentMethod;
import jp.co.okasan.cmn.constant.gui.ComboInfo;
import jp.co.okasan.frw.pr.MUIActionModeComboBox;
import jp.co.okasan.frw.pr.MUIAmountTextField;
import jp.co.okasan.frw.pr.MUIBankComboBox;
import jp.co.okasan.frw.pr.MUIBondInfoPanel;
import jp.co.okasan.frw.pr.MUICboTBondInfoComboBox;
import jp.co.okasan.frw.pr.MUICodeComboBox;
import jp.co.okasan.frw.pr.MUIComboBox;
import jp.co.okasan.frw.pr.MUIDecimalLabel;
import jp.co.okasan.frw.pr.MUIHalfWidthANTextField;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIQuantityTextField;
import jp.co.okasan.frw.pr.MUIRefNoTextField;
import jp.co.okasan.frw.pr.MUIShowLabel;
import jp.co.okasan.frw.pr.MUISubAccountTextField;
import jp.co.okasan.frw.pr.UIDateChooserButton;
import jp.co.okasan.frw.pr.UIDateYMDTextField2;
import jp.co.okasan.pr.cmn.CboCorporateBondHelper;
import jp.co.okasan.pr.cmn.PRHelper;

/**
 * Cbo5904Panel Class's Description<br>
 * <P>
 * Client area class of CboTBond_Contract screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/13 Create New
 */
public class Cbo5904Panel extends Frw00ClientPanel implements ItemListener,
		FocusListener {

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

	/** Hidden Updated Time of bond */
	private String paymentAccInfoTimeStamp;

	/** Entry Mode ComboBox */
	MUIActionModeComboBox cboActionMode = null;

	/** Title label */
	MUILabel lblTitle = null;

	/** Entry Mode label */
	MUILabel lblEntryMode = null;

	/** Id label */
	MUILabel lblId = null;

	/** Contract No label */
	MUILabel lblContractNo = null;

	/** Contract Type label */
	MUILabel lblContractType = null;

	/** Bond Cd label */
	MUILabel lblBondCd = null;

	/** Sub Acco Cd label */
	MUILabel lblSubAccoCd = null;

	/** Qty label */
	MUILabel lblQty = null;

	/** Amount label */
	MUILabel lblAmount = null;

	/** Tax Amt label */
	MUILabel lblTaxAmt = null;

	/** Interest Amt label */
	MUILabel lblInterestAmt = null;

	/** Payment Method label */
	MUILabel lblPaymentMethod = null;

	/** Contract Date label */
	MUILabel lblContractDate = null;

	/** Int Payment Method label */
	MUILabel lblIntPaymentMethod = null;

	/** Bank Cd label */
	MUILabel lblBankCd = null;

	/** Bank Branch Name label */
	MUILabel lblBankBranchName = null;

	/** Bank Branch Location Cd label */
	MUILabel lblBankBranchLocationCd = null;

	/** Bank Accnt Number label */
	MUILabel lblBankAccntNumber = null;

	/** Bank Accnt Name label */
	MUILabel lblBankAccntName = null;

	/** Remarks label */
	MUILabel lblRemarks = null;

	/** Reg Date Time label */
	MUILabel lblRegistered = null;

	/** Upd Date Time label */
	MUILabel lblUpdated = null;

	/** Id TextField */
	MUIRefNoTextField txtId = null;

	/** Contract No TextField */
	MUIHalfWidthTextField txtContractNo = null;

	/** Bond Cd TextField */
	MUICboTBondInfoComboBox cboBondCd = null;

	/** Sub Acco Cd TextField */
	MUISubAccountTextField txtSubAccoCd = null;

	/** SubAccName Showlabel */
	MUIShowLabel lblAccoName = null;

	/** Qty TextField */
	MUIQuantityTextField txtQty = null;

	/** Available Label */
	MUILabel lblAvailable = null;

	/** Available ShowLabel */
	MUIDecimalLabel lblAvailQty = null;

	/** Amount TextField */
	MUIAmountTextField txtAmount = null;

	/** Payment Method TextField */
	MUIComboBox cboPaymentMethod = null;

	/** Contract Date TextField */
	UIDateYMDTextField2 txtContractDate = null;

	/** Button Reissue Date */
	UIDateChooserButton btnContractDate = new UIDateChooserButton();

	/** Int Payment Method TextField */
	MUIComboBox cboIntPaymentMethod = null;

	/** Bank Cd TextField */
	MUIBankComboBox cboBankCd = null;

	/** Bank Branch Name TextField */
	MUIHalfWidthTextField txtBankBranchName = null;

	/** Bank Branch Location Cd TextField */
	MUICodeComboBox cboBankBranchLocationCd = null;

	/** Bank Accnt Number TextField */
	MUIHalfWidthANTextField txtBankAccntNumber = null;

	/** Bank Accnt Name TextField */
	MUIHalfWidthTextField txtBankAccntName = null;

	/** Payment account info panel */
	Frw00ClientPanel pnlPaymentAccoInfo = null;

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

	/** Bond info panel */
	MUIBondInfoPanel pnlBondInfo = null;

	/** Flag for help subAccoNo */
	private boolean isSubAccoHelp = false;

	// //////// Methods define //////////

	/**
	 * Constructor <br>
	 * Call constructor base template.
	 * 
	 * @param Nothing
	 * @exception
	 */
	public Cbo5904Panel() {
		super();

		try {

			// Check Business role
			PRHelper.checkRoleEntryFormThrowErr(BusinessRoleInfo.F5904);

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
		String defaultHelpId = FormCodeInfo.CBOTBOND_CONTRACT_HELP;

		// if Help in keys of table
		if (component.equals(this.txtId)) {
			openHelpWindow(defaultHelpId);
			return null;
		} else if (cboBankCd.getEditor().equals(component)) {
			helpId = FormCodeInfo.MSTTBANK_HELP;
		} else if (txtSubAccoCd.equals(component)) {
			helpId = FormCodeInfo.CORTSUB_ACCOUNT_HELP;
			this.isSubAccoHelp = true;
		}

		return helpId;
	}

	/**
	 * Open help window. <BR>
	 * 
	 * @param id
	 *            String
	 * @return Nothing
	 * @exception Nothing
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void openHelpWindow(String id) {
		try {
			Frw00BaseTemplateFrame frame = (Frw00BaseTemplateFrame) getTopLevelAncestor();
			HashMap dataList = new HashMap();
			dataList.put("contractType", BuySellInfo.BUY.toString());
			Frw00TransferKeyData data = createTransferKeyData(frame
					.getFocusOwner());
			Frw00WindowController winCtrl = Frw00WindowController.getInstance();
			Frw00HelpBaseTemplateFrame hlpFrame = winCtrl.showHelpWindow(id,
					frame);
			hlpFrame.setData(dataList);
			Frw00ClientPanel hlpPanel = hlpFrame.getClientPanel();
			hlpPanel.setTransferKeyData(data);
		} catch (Frw10ClientException ex) {
			ex.printStackTrace();
			jp.co.okasan.pr.cmn.CommonHelper.showError(this, ex.getMessage());
		}
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
		if (this.isSubAccoHelp) {
			if (dataList.containsKey("subAccoNo")) {
				this.txtSubAccoCd
						.setValue(dataList.get("subAccoNo").toString());
			}

			this.isSubAccoHelp = false;
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

		final int xOfLabelCol1 = 25;
		final int lblWidthCol1 = 105;
		int xOfEditorCol1 = lblWidthCol1 + 50;

		// y of control
		int y = 20;

		lblEntryMode = new MUILabel();
		lblEntryMode.setOpaque(false);
		lblEntryMode.setText("ACTION_MODE");
		lblEntryMode
				.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
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
		lblId.setText("Cbo5904Panel_lblId");
		lblId.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblId);

		// Id TextField
		txtId = new MUIRefNoTextField();
		txtId.setLocation(xOfEditorCol1, lblId.getY());
		txtId.setPartsName("id");
		this.add(txtId);

		y += 40;

		// Bond Cd Label
		lblBondCd = new MUILabel();
		lblBondCd.setOpaque(false);
		lblBondCd.setText("Cbo5904Panel_lblBondCd");
		lblBondCd.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblBondCd);

		// Bond Cd TextField
		cboBondCd = new MUICboTBondInfoComboBox();
		cboBondCd.setLocation(xOfEditorCol1, lblBondCd.getY());
		cboBondCd.setFormId(FormCodeInfo.CBOTBOND_CONTRACT_MASTER);
		cboBondCd.setDataSource(InsertNullItemType.FIRST, "", "");
		cboBondCd.addItemListener(this);
		cboBondCd.setPartsName("bondCd");
		this.add(cboBondCd);
		cboBondCd.showMandatoryLabel();

		y += 25;

		// Contract No Label
		lblContractNo = new MUILabel();
		lblContractNo.setOpaque(false);
		lblContractNo.setText("Cbo5904Panel_lblContractNo");
		lblContractNo
				.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractNo);

		// Contract No TextField
		txtContractNo = new MUIHalfWidthTextField();
		txtContractNo.setMaxLength(20);
		txtContractNo.setBounds(new Rectangle(xOfEditorCol1, lblContractNo
				.getY(), 100, 20));
		txtContractNo.setAlphabetUpper(false);
		txtContractNo.setPartsName("contractNo");
		this.add(txtContractNo);

		y += 25;

		// Sub Acco Cd Label
		lblSubAccoCd = new MUILabel();
		lblSubAccoCd.setOpaque(false);
		lblSubAccoCd.setText("Cbo5904Panel_lblSubAccoCd");
		lblSubAccoCd
				.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblSubAccoCd);

		// Sub Acco No TextField
		txtSubAccoCd = new MUISubAccountTextField();
		txtSubAccoCd.setFormId(FormCodeInfo.CBOTBOND_CONTRACT_MASTER);
		txtSubAccoCd.setAllowNull(false);
		txtSubAccoCd.setGetSubAccoData(true);
		txtSubAccoCd.setLocation(xOfEditorCol1, lblSubAccoCd.getY());
		txtSubAccoCd.addFocusListener(this);
		txtSubAccoCd.setPartsName("subAccoNo");
		txtSubAccoCd.setVisible(true);
		this.add(txtSubAccoCd);
		txtSubAccoCd.showHelpLabel();
		txtSubAccoCd.showMandatoryLabel();

		final int xOfCustNameLabel = txtSubAccoCd.getX()
				+ txtSubAccoCd.getWidth() + 20;

		// Account name Label
		lblAccoName = new MUIShowLabel();
		lblAccoName.setOpaque(false);
		lblAccoName.setPartsName("custName");
		lblAccoName.setBounds(new Rectangle(xOfCustNameLabel, txtSubAccoCd
				.getY(), 120, 20));
		this.add(lblAccoName);

		y += 25;

		// Qty Label
		lblQty = new MUILabel();
		lblQty.setOpaque(false);
		lblQty.setText("Cbo5904Panel_lblQtyBuy");
		lblQty.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblQty);

		// Qty TextField
		txtQty = new MUIQuantityTextField();
		txtQty.setLocation(xOfEditorCol1, lblQty.getY());
		txtQty.setPartsName("qty");
		txtQty.addFocusListener(this);
		this.add(txtQty);
		txtQty.showMandatoryLabel();

		// Available Label
		lblAvailable = new MUILabel();
		lblAvailable.setOpaque(false);
		lblAvailable.setText("Available");
		lblAvailable.setBounds(new Rectangle(txtQty.getX() + txtQty.getWidth()
				+ 5, txtQty.getY(), 50, 20));
		this.add(lblAvailable);

		// Available Qty
		lblAvailQty = new MUIDecimalLabel();
		lblAvailQty.setOpaque(false);
		lblAvailQty.setPartsName("availQty");
		lblAvailQty.setBounds(new Rectangle(lblAvailable.getX()
				+ lblAvailable.getWidth() + 5, lblAvailable.getY(), 120, 20));
		lblAvailQty.setText(BigDecimal.ZERO);
		this.add(lblAvailQty);

		y += 25;

		// Amount Label
		lblAmount = new MUILabel();
		lblAmount.setOpaque(false);
		lblAmount.setText("Cbo5904Panel_lblAmount");
		lblAmount.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblAmount);

		// Amount TextField
		txtAmount = new MUIAmountTextField();
		txtAmount.setBounds(xOfEditorCol1, lblAmount.getY(), 150, 20);
		txtAmount.setPartsName("amount");
		this.add(txtAmount);

		y += 25;

		// Contract Date Label
		lblContractDate = new MUILabel();
		lblContractDate.setOpaque(false);
		lblContractDate.setText("Cbo5904Panel_lblContractDate");
		lblContractDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1,
				20));
		this.add(lblContractDate);

		// Contract Date TextField
		txtContractDate = new UIDateYMDTextField2();
		txtContractDate.setBounds(new Rectangle(xOfEditorCol1, y, 65, 20));
		txtContractDate.setPartsName("contractDate");
		this.add(txtContractDate);
		btnContractDate.setDateComp(txtContractDate);
		this.add(btnContractDate);
		txtContractDate.showMandatoryLabel();
		txtContractDate.setValue(PRHelper.getPrData().getTransactionDate());

		y += 25;

		// Payment Method Label
		lblPaymentMethod = new MUILabel();
		lblPaymentMethod.setOpaque(false);
		lblPaymentMethod.setText("Cbo5904Panel_lblPaymentMethod");
		lblPaymentMethod.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1,
				20));
		this.add(lblPaymentMethod);

		// Payment Method TextField
		cboPaymentMethod = new MUIComboBox(
				ComboInfo.CBOTBOND_CONTRACT_PAYMENT_METHOD_BUY,
				InsertNullItemType.NONE, "", "");
		cboPaymentMethod.setBounds(new Rectangle(xOfEditorCol1,
				lblPaymentMethod.getY(), 100, 20));
		cboPaymentMethod.setPartsName("paymentMethod");
		cboPaymentMethod.setReset(false);
		cboPaymentMethod.setValue(CboTIntPaymentMethod.CASH.toString());
		this.add(cboPaymentMethod);

		y += 25;

		// Int Payment Method Label
		lblIntPaymentMethod = new MUILabel();
		lblIntPaymentMethod.setOpaque(false);
		lblIntPaymentMethod.setText("Cbo5904Panel_lblIntPaymentMethod");
		lblIntPaymentMethod.setBounds(new Rectangle(xOfLabelCol1, y,
				lblWidthCol1, 20));
		this.add(lblIntPaymentMethod);

		// Int Payment Method TextField
		cboIntPaymentMethod = new MUIComboBox(ComboInfo.CBO_INT_PAYMENT_METHOD,
				InsertNullItemType.NONE, "", "");
		cboIntPaymentMethod.setBounds(new Rectangle(xOfEditorCol1,
				lblIntPaymentMethod.getY(), 100, 20));
		cboIntPaymentMethod.setPartsName("intPaymentMethod");
		cboIntPaymentMethod.setReset(false);
		cboIntPaymentMethod.setValue(CboTIntPaymentMethod.BANK_TRANSFER
				.toString());
		cboIntPaymentMethod.addItemListener(this);
		this.add(cboIntPaymentMethod);

		y += 25;

		// Payment acco info panel
		pnlPaymentAccoInfo = new Frw00ClientPanel();
		pnlPaymentAccoInfo.setBounds(0, y, 800, 45);
		this.add(pnlPaymentAccoInfo);

		int y2 = 0;

		// Bank Cd Label
		lblBankCd = new MUILabel();
		lblBankCd.setOpaque(false);
		lblBankCd.setText("Cbo5904Panel_lblBankCd");
		lblBankCd.setBounds(new Rectangle(xOfLabelCol1, y2, lblWidthCol1, 20));
		pnlPaymentAccoInfo.add(lblBankCd);

		// Bank Code TextField
		cboBankCd = new MUIBankComboBox();
		cboBankCd.setBounds(new Rectangle(xOfEditorCol1, y2, 100, 20));
		cboBankCd.setPartsName("bankCd");
		cboBankCd.setFormId(FormCodeInfo.CBOTBOND_CONTRACT_MASTER);
		cboBankCd.setDataSource(true);
		pnlPaymentAccoInfo.add(cboBankCd);
		cboBankCd.showHelpLabel();
		cboBankCd.showMandatoryLabel();

		y2 += 25;

		// Bank Accnt Number Label
		lblBankAccntNumber = new MUILabel();
		lblBankAccntNumber.setOpaque(false);
		lblBankAccntNumber.setText("Cbo5904Panel_lblBankAccntNumber");
		lblBankAccntNumber.setBounds(new Rectangle(xOfLabelCol1, y2,
				lblWidthCol1, 20));
		pnlPaymentAccoInfo.add(lblBankAccntNumber);

		// Bank Accnt Number TextField
		txtBankAccntNumber = new MUIHalfWidthANTextField();
		txtBankAccntNumber.setMaxLength(20);
		txtBankAccntNumber.setBounds(new Rectangle(xOfEditorCol1,
				lblBankAccntNumber.getY(), 100, 20));
		txtBankAccntNumber.setAlphabetUpper(false);
		txtBankAccntNumber.setPartsName("bankAccntNumber");
		pnlPaymentAccoInfo.add(txtBankAccntNumber);
		txtBankAccntNumber.showMandatoryLabel();

		// Column 2 define
		final int xOfLabelCol2 = txtAmount.getX() + txtAmount.getWidth() + 10;
		final int lblWidthCol2 = 50;
		int xOfEditorCol2 = lblWidthCol2 + xOfLabelCol2 + 25;

		// Bank Branch Name Label
		lblBankBranchName = new MUILabel();
		lblBankBranchName.setOpaque(false);
		lblBankBranchName.setText("Cbo5904Panel_lblBankBranchName");
		lblBankBranchName.setBounds(new Rectangle(xOfLabelCol2, lblBankCd
				.getY(), lblWidthCol2, 20));
		pnlPaymentAccoInfo.add(lblBankBranchName);

		// Bank Branch Name TextField
		txtBankBranchName = new MUIHalfWidthTextField();
		txtBankBranchName.setMaxLength(100);
		txtBankBranchName.setBounds(new Rectangle(xOfEditorCol2,
				lblBankBranchName.getY(), 150, 20));
		txtBankBranchName.setAlphabetUpper(false);
		txtBankBranchName.setPartsName("bankBranchName");
		pnlPaymentAccoInfo.add(txtBankBranchName);
		txtBankBranchName.showMandatoryLabel();

		// Bank Accnt Name Label
		lblBankAccntName = new MUILabel();
		lblBankAccntName.setOpaque(false);
		lblBankAccntName.setText("Cbo5904Panel_lblBankAccntName");
		lblBankAccntName.setBounds(new Rectangle(xOfLabelCol2,
				lblBankAccntNumber.getY(), lblWidthCol2, 20));
		pnlPaymentAccoInfo.add(lblBankAccntName);

		// Bank Accnt Name TextField
		txtBankAccntName = new MUIHalfWidthTextField();
		txtBankAccntName.setMaxLength(80);
		txtBankAccntName.setBounds(new Rectangle(xOfEditorCol2,
				lblBankAccntName.getY(), 120, 20));
		txtBankAccntName.setAlphabetUpper(false);
		txtBankAccntName.setPartsName("bankAccntName");
		pnlPaymentAccoInfo.add(txtBankAccntName);
		txtBankAccntName.showMandatoryLabel();

		// Column 3 define
		final int xOfLabelCol3 = txtBankBranchName.getX()
				+ txtBankBranchName.getWidth() + 40;
		final int lblWidthCol3 = 50;
		int xOfEditorCol3 = lblWidthCol3 + xOfLabelCol3 + 25;

		// Bank Branch Location Cd Label
		lblBankBranchLocationCd = new MUILabel();
		lblBankBranchLocationCd.setOpaque(false);
		lblBankBranchLocationCd.setText("Cbo5904Panel_lblBankBranchLocationCd");
		lblBankBranchLocationCd.setBounds(new Rectangle(xOfLabelCol3, lblBankCd
				.getY(), lblWidthCol3, 20));
		pnlPaymentAccoInfo.add(lblBankBranchLocationCd);

		// Bank Branch Location Cd TextField
		cboBankBranchLocationCd = new MUICodeComboBox();
		cboBankBranchLocationCd.setLocation(xOfEditorCol3,
				lblBankBranchLocationCd.getY());
		cboBankBranchLocationCd
				.setFormId(FormCodeInfo.CBOTBOND_CONTRACT_MASTER);
		cboBankBranchLocationCd.setDataSource(CodeGroupNameInfo.PROVINCE,
				InsertNullItemType.FIRST, CommonHelper.empty,
				CommonHelper.empty);
		cboBankBranchLocationCd.setPartsName("bankBranchLocationCd");
		pnlPaymentAccoInfo.add(cboBankBranchLocationCd);
		cboBankBranchLocationCd.showMandatoryLabel();

		y += pnlPaymentAccoInfo.getHeight() + 5;

		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Cbo5904Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblRemarks);

		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(200);
		txtRemarks.setBounds(new Rectangle(xOfEditorCol1, lblRemarks.getY(),
				600, 20));
		txtRemarks.setAlphabetUpper(false);
		txtRemarks.setPartsName("remarks");
		this.add(txtRemarks);

		// Register and updated
		int yOfLabelRegister = txtRemarks.getY() + txtRemarks.getHeight() + 20;

		// Registed Label
		lblRegistered = new MUILabel();
		lblRegistered.setOpaque(false);
		lblRegistered.setText("Registered");
		lblRegistered.setBounds(new Rectangle(25, yOfLabelRegister,
				lblWidthCol1, 20));
		this.add(lblRegistered);

		// Registed time Label
		lblRegDateTime = new MUIShowLabel();
		lblRegDateTime.setPartsName("RegDateTime");
		lblRegDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfLabelRegister,
				100, 20));
		this.add(lblRegDateTime);

		// Registed user Label
		lblRegUserId = new MUIShowLabel();
		lblRegUserId.setPartsName("RegUserId");
		lblRegUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblRegDateTime.getWidth(), yOfLabelRegister, 150, 20));
		this.add(lblRegUserId);

		yOfLabelRegister += 25;

		// Updated Label
		lblUpdated = new MUILabel();
		lblUpdated.setOpaque(false);
		lblUpdated.setText("Updated");
		lblUpdated.setBounds(new Rectangle(25, yOfLabelRegister, lblWidthCol1,
				20));
		this.add(lblUpdated);

		// Updated time show Label
		lblUpdDateTime = new MUIShowLabel();
		lblUpdDateTime.setPartsName("UpdDateTime");
		lblUpdDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfLabelRegister,
				100, 20));
		this.add(lblUpdDateTime);

		// Updated user show label
		lblUpdUserId = new MUIShowLabel();
		lblUpdUserId.setPartsName("UpdUserId");
		lblUpdUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblUpdDateTime.getWidth(), yOfLabelRegister, 150, 20));
		this.add(lblUpdUserId);

		// Bond info panel
		int xOfBondInfoPanel = lblAccoName.getX() + lblAccoName.getWidth() + 20;

		pnlBondInfo = new MUIBondInfoPanel("Cbo5904Panel_lblBondInfo");
		pnlBondInfo.setBounds(new Rectangle(xOfBondInfoPanel, 20, 470, 195));
		pnlBondInfo.setVisible(true);
		this.add(pnlBondInfo);
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

	/**
	 * @return the paymentAccInfoTimeStamp
	 */
	public String getPaymentAccInfoTimeStamp() {
		return paymentAccInfoTimeStamp;
	}

	/**
	 * @param paymentAccInfoTimeStamp
	 *            the paymentAccInfoTimeStamp to set
	 */
	public void setPaymentAccInfoTimeStamp(String paymentAccInfoTimeStamp) {
		this.paymentAccInfoTimeStamp = paymentAccInfoTimeStamp;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
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
			} else if (e.getSource().equals(this.cboBondCd)
					&& e.getStateChange() == ItemEvent.SELECTED) {
				this.bindBondInfo();

				this.bindBuyAvailQty();

				this.calculateAmount();
			} else if (e.getSource().equals(this.cboIntPaymentMethod)
					&& e.getStateChange() == ItemEvent.SELECTED) {
				this.intPaymentMethodChanged();
			}
		} catch (Frw10ClientException ex) {
			ex.printStackTrace();
			jp.co.okasan.pr.cmn.CommonHelper.showError(this, ex.getMessage());
		}
	}

	/**
	 * Get default unEdit component
	 * 
	 * @return
	 */
	protected List<JComponent> getDefaultUnEditComponents() {
		List<JComponent> compList = new ArrayList<JComponent>();
		compList.add(this.txtContractNo);
		compList.add(this.txtAmount);

		return compList;
	}

	/**
	 * Set enable/disable for table and button
	 * 
	 * @param param
	 */
	protected void setEnableControl(boolean param) {
		this.btnContractDate.setEnabled(param);
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		try {
			if (e.getComponent() == this.txtSubAccoCd) {
				bindCustomerInfo();
				bindPaymentAccInfo();
			} else if (e.getComponent() == this.txtQty) {
				calculateAmount();
			}
		} catch (Frw10ClientException ex) {
			ex.printStackTrace();
			jp.co.okasan.pr.cmn.CommonHelper.showError(this, ex.getMessage());
		}
	}

	/**
	 * Bind customer Name.<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws ClassNotFoundException
	 * @throws Frw10ClientException
	 */
	public void bindCustomerInfo() {
		this.lblAccoName.setText("");

		if (this.txtSubAccoCd.isValid()
				&& this.txtSubAccoCd.getSubAccountData() != null) {
			Hlp6130ResultData subAccData = this.txtSubAccoCd
					.getSubAccountData();

			// set custName
			lblAccoName.setText(subAccData.getCustFullName());
		}
	}

	/**
	 * Bind customer Name.<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws ClassNotFoundException
	 * @throws Frw10ClientException
	 */
	public void bindBondInfo() {
		this.pnlBondInfo.reset();

		Cbo5901ResultData bondInfoData = this.cboBondCd.getBondInfoData();
		if (bondInfoData != null) {
			this.pnlBondInfo.bindData(bondInfoData);
		}
	}

	/**
	 * Bind availQty.<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws ClassNotFoundException
	 * @throws Frw10ClientException
	 */
	public void bindBuyAvailQty() throws Frw10ClientException {
		BigDecimal availQty = BigDecimal.ZERO;

		String bondCd = this.cboBondCd.getValue();

		if (ItemValidator.isNotEmpty(bondCd)) {
			Cbo5904InputData inputData = new Cbo5904InputData();
			inputData.setBondCd(bondCd);
			inputData.setId(this.txtId.getValue());

			availQty = CboCorporateBondHelper.GetAvailableQtyBondInfo(
					FormCodeInfo.CBOTBOND_CONTRACT_MASTER, inputData);
		}

		this.lblAvailQty.setText(availQty);

	}

	/**
	 * Re-calculate amount .<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws Frw10ClientException
	 */
	public void calculateAmount() throws Frw10ClientException {
		this.txtAmount.reset();

		BigDecimal buyQty = CommonHelper.getBigDecimalFromString(this.txtQty
				.getValue());

		Cbo5901ResultData bondInfoData = this.cboBondCd.getBondInfoData();
		if (bondInfoData != null && buyQty.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal price = CommonHelper
					.getBigDecimalFromString(bondInfoData.getReissuePrice());

			BigDecimal amount = price.multiply(buyQty);

			// Round amount
			amount = amount.setScale(0, BigDecimal.ROUND_DOWN);

			this.txtAmount.setValue(amount.toString());
		}
	}

	/**
	 * Re-calculate amount .<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws Frw10ClientException
	 */
	public void bindPaymentAccInfo() throws Frw10ClientException {
		String subAccoNo = this.txtSubAccoCd.getValue();

		if (ItemValidator.isNotEmpty(subAccoNo)) {
			Cbo5904InputData inputData = new Cbo5904InputData();
			inputData.setSubAccoNo(subAccoNo);

			Cbo5904ResultData resultData = CboCorporateBondHelper
					.getPaymentAccInfo(FormCodeInfo.CBOTBOND_CONTRACT_MASTER,
							inputData);

			// Only bind data if existed
			if (resultData != null) {
				cboBankCd.setValue(resultData.getBankCd());
				txtBankBranchName.setValue(resultData.getBankBranchName());
				cboBankBranchLocationCd.setValue(resultData
						.getBankBranchLocationCd());
				txtBankAccntNumber.setValue(resultData.getBankAccntNumber());
				txtBankAccntName.setValue(resultData.getBankAccntName());

				// Set timeStamp
				this.paymentAccInfoTimeStamp = resultData.getUpdDateTime();
			}
		}
	}

	/**
	 * Bind Bond info.<Br>
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @exception Nothing
	 * @throws ClassNotFoundException
	 * @throws Frw10ClientException
	 */
	public void intPaymentMethodChanged() throws Frw10ClientException {
		final int lblWidthCol = lblEntryMode.getWidth();
		final int xOfEditorCol1 = cboActionMode.getX();

		if (this.cboIntPaymentMethod.getValue().equals(
				CboTIntPaymentMethod.BANK_TRANSFER.toString())) {
			this.pnlPaymentAccoInfo.setVisible(true);

			int y = this.pnlPaymentAccoInfo.getY()
					+ this.pnlPaymentAccoInfo.getHeight() + 5;

			this.lblRemarks.setBounds(25, y, lblWidthCol, 20);
			this.txtRemarks.setBounds(xOfEditorCol1, y, 600, 20);
		} else {
			this.pnlPaymentAccoInfo.setVisible(false);

			int y = cboIntPaymentMethod.getY()
					+ cboIntPaymentMethod.getHeight() + 5;

			this.lblRemarks.setBounds(25, y, lblWidthCol, 20);
			this.txtRemarks.setBounds(xOfEditorCol1, y, 600, 20);
		}

		// Register and update time info
		int yOfRegister = txtRemarks.getY() + txtRemarks.getHeight() + 20;

		// Registed Label
		lblRegistered
				.setBounds(new Rectangle(25, yOfRegister, lblWidthCol, 20));

		// Registed user Label
		lblRegDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfRegister, 100,
				20));

		// Registed user Label
		lblRegUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblRegDateTime.getWidth(), yOfRegister, 200, 20));

		// Updated Label
		lblUpdated.setBounds(new Rectangle(25, yOfRegister + 25, lblWidthCol,
				20));

		// Updated user show label
		lblUpdDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfRegister + 25,
				100, 20));

		// Updated user show label
		lblUpdUserId.setBounds(new Rectangle(xOfEditorCol1
				+ lblUpdDateTime.getWidth(), yOfRegister + 25, 200, 20));
	}

	/**
	 * Set data to panel when successful receive data from server
	 * 
	 * @throws Frw10ClientException
	 */
	protected void bindDataToPanel() throws Frw10ClientException {
		bindCustomerInfo();

		bindBondInfo();

		bindBuyAvailQty();

		calculateAmount();

		intPaymentMethodChanged();
	}
}
