/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.cbo.cbo5904;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10ComboElement;
import jp.co.nec.frw1000.pr.clcommon.Frw10ComboInfo;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.nec.frw1000.pr.component.UIComboBox;
import jp.co.nec.frw1000.pr.component.UILabel;
import jp.co.nec.frw1000.pr.component.UIShowLabel;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.frw.pr.MUIActionModeComboBox;
import jp.co.okasan.frw.pr.UIHalfWidthANTextField2;
import jp.co.okasan.frw.pr.UIHalfWidthTextField2;
import jp.co.okasan.frw.pr.MUIHalfWidthANTextField;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIComboBox;
import jp.co.okasan.frw.pr.MUIShowLabel;


import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;

/**
 * Cbo5904Panel Class's Description<br>
 * <P>
 * Client area class of CboTBond_Contract screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Cbo5904Panel extends Frw00ClientPanel implements ItemListener {
	
	////////// Class Variables //////////
	
	/**
	 * Flag to mark when need to get and bind data to screen
	 */
	boolean needToGetData = true;
	
	/** Click F2 When Result State */
	boolean F2 = false;
	
	/** Hidden Updated Time*/
	private String timeStamp;
	
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
	
	/** Int Payment Method label */
	MUILabel lblIntPaymentMethod = null;
	
	/** Contract Date label */
	MUILabel lblContractDate = null;
	
	/** Payment Cash Date label */
	MUILabel lblPaymentCashDate = null;
	
	/** Payment Sec Date label */
	MUILabel lblPaymentSecDate = null;
	
	/** Transaction Cd label */
	MUILabel lblTransactionCd = null;
	
	/** Contract Sts label */
	MUILabel lblContractSts = null;
	
	/** Status label */
	MUILabel lblStatus = null;
	
	/** Remarks label */
	MUILabel lblRemarks = null;
	
	/** Reg Date Time label */
	MUILabel lblRegistered = null;
	
	/** Upd Date Time label */
	MUILabel lblUpdated = null;
	
	/** Id TextField */
	MUIHalfWidthTextField txtId = null;
	
	/** Contract No TextField */
	MUIHalfWidthTextField txtContractNo = null;
	
	/** Contract Type TextField */
	MUIHalfWidthTextField txtContractType = null;
	
	/** Bond Cd TextField */
	MUIHalfWidthTextField txtBondCd = null;
	
	/** Sub Acco Cd TextField */
	MUIHalfWidthTextField txtSubAccoCd = null;
	
	/** Qty TextField */
	MUIHalfWidthTextField txtQty = null;
	
	/** Amount TextField */
	MUIHalfWidthTextField txtAmount = null;
	
	/** Tax Amt TextField */
	MUIHalfWidthTextField txtTaxAmt = null;
	
	/** Interest Amt TextField */
	MUIHalfWidthTextField txtInterestAmt = null;
	
	/** Payment Method TextField */
	MUIHalfWidthTextField txtPaymentMethod = null;
	
	/** Int Payment Method TextField */
	MUIHalfWidthTextField txtIntPaymentMethod = null;
	
	/** Contract Date TextField */
	MUIHalfWidthTextField txtContractDate = null;
	
	/** Payment Cash Date TextField */
	MUIHalfWidthTextField txtPaymentCashDate = null;
	
	/** Payment Sec Date TextField */
	MUIHalfWidthTextField txtPaymentSecDate = null;
	
	/** Transaction Cd TextField */
	MUIHalfWidthTextField txtTransactionCd = null;
	
	/** Contract Sts TextField */
	MUIHalfWidthTextField txtContractSts = null;
	
	/** Status TextField */
	MUIHalfWidthTextField txtStatus = null;
	
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
	
	////////// Methods define //////////
	
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
			PRHelper.checkRoleEntryFormThrowErr(BusinessRoleInfo.F9999);
		
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
	 * @param component Component
	 * @return String window help code ID
	 * @exception
	 */
	public String getHelpWindowInfo(Component component) {

        // Create help ID
        String helpId = null;
		
        // Get default HelpId
        String defaultHelpId = "8904";

        // if Help in keys of table
        if (component.equals(this.txtId)) {
            helpId = defaultHelpId;
        } 
		
        return helpId;
    }
	
	/**
	 * Method show data<br>
	 * 
	 * @param dataList HashMap
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
	
		final int xOfLabelCol1 = 25;
		final int lblWidthCol1 = 60;
		int xOfEditorCol1 = lblWidthCol1 + 50;
		
		// y of control
		int y = 20;
	
		lblEntryMode = new MUILabel();
		lblEntryMode.setOpaque(false);
		lblEntryMode.setText("ACTION_MODE");
		lblEntryMode.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblEntryMode);
	
		//Entry Mode combobox
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
		txtId = new MUIHalfWidthTextField();
		txtId.setBounds(new Rectangle(xOfEditorCol1, lblId.getY(), 100, 20));
		txtId.setAlphabetUpper(false);
		txtId.setPartsName("id");
		this.add(txtId);
		
		y += 25;
		
		// Contract No Label
		lblContractNo = new MUILabel();
		lblContractNo.setOpaque(false);
		lblContractNo.setText("Cbo5904Panel_lblContractNo");
		lblContractNo.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractNo);
		
		// Contract No TextField
		txtContractNo = new MUIHalfWidthTextField();
		txtContractNo.setMaxLength(80);
		txtContractNo.setBounds(new Rectangle(xOfEditorCol1, lblContractNo.getY(), 100, 20));
		txtContractNo.setAlphabetUpper(false);
		txtContractNo.setPartsName("contractNo");
		this.add(txtContractNo);
		
		y += 25;
		
		// Contract Type Label
		lblContractType = new MUILabel();
		lblContractType.setOpaque(false);
		lblContractType.setText("Cbo5904Panel_lblContractType");
		lblContractType.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractType);
		
		// Contract Type TextField
		txtContractType = new MUIHalfWidthTextField();
		txtContractType.setBounds(new Rectangle(xOfEditorCol1, lblContractType.getY(), 100, 20));
		txtContractType.setAlphabetUpper(false);
		txtContractType.setPartsName("contractType");
		this.add(txtContractType);
		
		y += 25;
		
		// Bond Cd Label
		lblBondCd = new MUILabel();
		lblBondCd.setOpaque(false);
		lblBondCd.setText("Cbo5904Panel_lblBondCd");
		lblBondCd.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblBondCd);
		
		// Bond Cd TextField
		txtBondCd = new MUIHalfWidthTextField();
		txtBondCd.setMaxLength(80);
		txtBondCd.setBounds(new Rectangle(xOfEditorCol1, lblBondCd.getY(), 100, 20));
		txtBondCd.setAlphabetUpper(false);
		txtBondCd.setPartsName("bondCd");
		this.add(txtBondCd);
		
		y += 25;
		
		// Sub Acco Cd Label
		lblSubAccoCd = new MUILabel();
		lblSubAccoCd.setOpaque(false);
		lblSubAccoCd.setText("Cbo5904Panel_lblSubAccoCd");
		lblSubAccoCd.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblSubAccoCd);
		
		// Sub Acco Cd TextField
		txtSubAccoCd = new MUIHalfWidthTextField();
		txtSubAccoCd.setBounds(new Rectangle(xOfEditorCol1, lblSubAccoCd.getY(), 100, 20));
		txtSubAccoCd.setAlphabetUpper(false);
		txtSubAccoCd.setPartsName("subAccoCd");
		this.add(txtSubAccoCd);
		
		y += 25;
		
		// Qty Label
		lblQty = new MUILabel();
		lblQty.setOpaque(false);
		lblQty.setText("Cbo5904Panel_lblQty");
		lblQty.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblQty);
		
		// Qty TextField
		txtQty = new MUIHalfWidthTextField();
		txtQty.setBounds(new Rectangle(xOfEditorCol1, lblQty.getY(), 100, 20));
		txtQty.setAlphabetUpper(false);
		txtQty.setPartsName("qty");
		this.add(txtQty);
		
		y += 25;
		
		// Amount Label
		lblAmount = new MUILabel();
		lblAmount.setOpaque(false);
		lblAmount.setText("Cbo5904Panel_lblAmount");
		lblAmount.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblAmount);
		
		// Amount TextField
		txtAmount = new MUIHalfWidthTextField();
		txtAmount.setBounds(new Rectangle(xOfEditorCol1, lblAmount.getY(), 100, 20));
		txtAmount.setAlphabetUpper(false);
		txtAmount.setPartsName("amount");
		this.add(txtAmount);
		
		y += 25;
		
		// Tax Amt Label
		lblTaxAmt = new MUILabel();
		lblTaxAmt.setOpaque(false);
		lblTaxAmt.setText("Cbo5904Panel_lblTaxAmt");
		lblTaxAmt.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblTaxAmt);
		
		// Tax Amt TextField
		txtTaxAmt = new MUIHalfWidthTextField();
		txtTaxAmt.setBounds(new Rectangle(xOfEditorCol1, lblTaxAmt.getY(), 100, 20));
		txtTaxAmt.setAlphabetUpper(false);
		txtTaxAmt.setPartsName("taxAmt");
		this.add(txtTaxAmt);
		
		y += 25;
		
		// Interest Amt Label
		lblInterestAmt = new MUILabel();
		lblInterestAmt.setOpaque(false);
		lblInterestAmt.setText("Cbo5904Panel_lblInterestAmt");
		lblInterestAmt.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblInterestAmt);
		
		// Interest Amt TextField
		txtInterestAmt = new MUIHalfWidthTextField();
		txtInterestAmt.setBounds(new Rectangle(xOfEditorCol1, lblInterestAmt.getY(), 100, 20));
		txtInterestAmt.setAlphabetUpper(false);
		txtInterestAmt.setPartsName("interestAmt");
		this.add(txtInterestAmt);
		
		y += 25;
		
		// Payment Method Label
		lblPaymentMethod = new MUILabel();
		lblPaymentMethod.setOpaque(false);
		lblPaymentMethod.setText("Cbo5904Panel_lblPaymentMethod");
		lblPaymentMethod.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblPaymentMethod);
		
		// Payment Method TextField
		txtPaymentMethod = new MUIHalfWidthTextField();
		txtPaymentMethod.setBounds(new Rectangle(xOfEditorCol1, lblPaymentMethod.getY(), 100, 20));
		txtPaymentMethod.setAlphabetUpper(false);
		txtPaymentMethod.setPartsName("paymentMethod");
		this.add(txtPaymentMethod);
		
		y += 25;
		
		// Int Payment Method Label
		lblIntPaymentMethod = new MUILabel();
		lblIntPaymentMethod.setOpaque(false);
		lblIntPaymentMethod.setText("Cbo5904Panel_lblIntPaymentMethod");
		lblIntPaymentMethod.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblIntPaymentMethod);
		
		// Int Payment Method TextField
		txtIntPaymentMethod = new MUIHalfWidthTextField();
		txtIntPaymentMethod.setBounds(new Rectangle(xOfEditorCol1, lblIntPaymentMethod.getY(), 100, 20));
		txtIntPaymentMethod.setAlphabetUpper(false);
		txtIntPaymentMethod.setPartsName("intPaymentMethod");
		this.add(txtIntPaymentMethod);
		
		y += 25;
		
		// Contract Date Label
		lblContractDate = new MUILabel();
		lblContractDate.setOpaque(false);
		lblContractDate.setText("Cbo5904Panel_lblContractDate");
		lblContractDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractDate);
		
		// Contract Date TextField
		txtContractDate = new MUIHalfWidthTextField();
		txtContractDate.setBounds(new Rectangle(xOfEditorCol1, lblContractDate.getY(), 100, 20));
		txtContractDate.setAlphabetUpper(false);
		txtContractDate.setPartsName("contractDate");
		this.add(txtContractDate);
		
		y += 25;
		
		// Payment Cash Date Label
		lblPaymentCashDate = new MUILabel();
		lblPaymentCashDate.setOpaque(false);
		lblPaymentCashDate.setText("Cbo5904Panel_lblPaymentCashDate");
		lblPaymentCashDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblPaymentCashDate);
		
		// Payment Cash Date TextField
		txtPaymentCashDate = new MUIHalfWidthTextField();
		txtPaymentCashDate.setBounds(new Rectangle(xOfEditorCol1, lblPaymentCashDate.getY(), 100, 20));
		txtPaymentCashDate.setAlphabetUpper(false);
		txtPaymentCashDate.setPartsName("paymentCashDate");
		this.add(txtPaymentCashDate);
		
		y += 25;
		
		// Payment Sec Date Label
		lblPaymentSecDate = new MUILabel();
		lblPaymentSecDate.setOpaque(false);
		lblPaymentSecDate.setText("Cbo5904Panel_lblPaymentSecDate");
		lblPaymentSecDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblPaymentSecDate);
		
		// Payment Sec Date TextField
		txtPaymentSecDate = new MUIHalfWidthTextField();
		txtPaymentSecDate.setBounds(new Rectangle(xOfEditorCol1, lblPaymentSecDate.getY(), 100, 20));
		txtPaymentSecDate.setAlphabetUpper(false);
		txtPaymentSecDate.setPartsName("paymentSecDate");
		this.add(txtPaymentSecDate);
		
		y += 25;
		
		// Transaction Cd Label
		lblTransactionCd = new MUILabel();
		lblTransactionCd.setOpaque(false);
		lblTransactionCd.setText("Cbo5904Panel_lblTransactionCd");
		lblTransactionCd.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblTransactionCd);
		
		// Transaction Cd TextField
		txtTransactionCd = new MUIHalfWidthTextField();
		txtTransactionCd.setMaxLength(1);
		txtTransactionCd.setBounds(new Rectangle(xOfEditorCol1, lblTransactionCd.getY(), 100, 20));
		txtTransactionCd.setAlphabetUpper(false);
		txtTransactionCd.setPartsName("transactionCd");
		this.add(txtTransactionCd);
		
		y += 25;
		
		// Contract Sts Label
		lblContractSts = new MUILabel();
		lblContractSts.setOpaque(false);
		lblContractSts.setText("Cbo5904Panel_lblContractSts");
		lblContractSts.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractSts);
		
		// Contract Sts TextField
		txtContractSts = new MUIHalfWidthTextField();
		txtContractSts.setBounds(new Rectangle(xOfEditorCol1, lblContractSts.getY(), 100, 20));
		txtContractSts.setAlphabetUpper(false);
		txtContractSts.setPartsName("contractSts");
		this.add(txtContractSts);
		
		y += 25;
		
		// Status Label
		lblStatus = new MUILabel();
		lblStatus.setOpaque(false);
		lblStatus.setText("Cbo5904Panel_lblStatus");
		lblStatus.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblStatus);
		
		// Status TextField
		txtStatus = new MUIHalfWidthTextField();
		txtStatus.setBounds(new Rectangle(xOfEditorCol1, lblStatus.getY(), 100, 20));
		txtStatus.setAlphabetUpper(false);
		txtStatus.setPartsName("status");
		this.add(txtStatus);
		
		y += 25;
		
		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Cbo5904Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblRemarks);
		
		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(800);
		txtRemarks.setBounds(new Rectangle(xOfEditorCol1, lblRemarks.getY(), 100, 20));
		txtRemarks.setAlphabetUpper(false);
		txtRemarks.setPartsName("remarks");
		this.add(txtRemarks);
		
		y += 25;
		
		
		
		
		// Register and updated 
		int yOfLabelRegister = txtRemarks.getY() + txtRemarks.getHeight() + 20;
		
		// Registed Label
		lblRegistered = new MUILabel();
		lblRegistered.setOpaque(false);
		lblRegistered.setText("Registered");
		lblRegistered.setBounds(new Rectangle(25, yOfLabelRegister, lblWidthCol1, 20));
		this.add(lblRegistered);
		
		// Registed time Label
		lblRegDateTime = new MUIShowLabel();
		lblRegDateTime.setPartsName("RegDateTime");
		lblRegDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfLabelRegister, 100, 20));
		this.add(lblRegDateTime);
		
		// Registed user Label
		lblRegUserId = new MUIShowLabel();
		lblRegUserId.setPartsName("RegUserId");
		lblRegUserId.setBounds(new Rectangle(xOfEditorCol1 + lblRegDateTime.getWidth(), yOfLabelRegister, 150, 20));
		this.add(lblRegUserId);
		
		yOfLabelRegister +=25;
		
		// Updated Label
		lblUpdated = new MUILabel();
		lblUpdated.setOpaque(false);
		lblUpdated.setText("Updated");
		lblUpdated.setBounds(new Rectangle(25, yOfLabelRegister , lblWidthCol1, 20));
		this.add(lblUpdated);
		
		// Updated time show Label
		lblUpdDateTime = new MUIShowLabel();
		lblUpdDateTime.setPartsName("UpdDateTime");
		lblUpdDateTime.setBounds(new Rectangle(xOfEditorCol1, yOfLabelRegister, 100, 20));
		this.add(lblUpdDateTime);
		
		// Updated user show label
		lblUpdUserId = new MUIShowLabel();
		lblUpdUserId.setPartsName("UpdUserId");
		lblUpdUserId.setBounds(new Rectangle(xOfEditorCol1 + lblUpdDateTime.getWidth(), yOfLabelRegister, 150, 20));
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
				
			} else {
				
				this.txtId.setEnabled(true);
				this.txtId.showMandatoryLabel();
				
			}
		}
	}
	
	/**
	 * Get default unEdit component
	 * 
	 * @return
	 */
	protected List<JComponent> getDefaultUnEditComponents() {
		List<JComponent> compList = new ArrayList<JComponent>();

		return compList;
	}
	
		/**
	 * Set enable/disable for table and button
	 * 
	 * @param param
	 */
	protected void setEnableControl(boolean param) {
		this.btnReissueDate.setEnabled(param);
	}
}

