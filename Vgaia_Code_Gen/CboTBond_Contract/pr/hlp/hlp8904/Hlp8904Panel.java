/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.hlp.hlp8904;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;

import jp.co.nec.frw0000.pr.util.Frw00CloseWindowAction;
import jp.co.nec.frw0000.pr.util.Frw00TransferKeyData;
import jp.co.nec.frw0000.pr.view.Frw00BaseTemplateFrame;
import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.component.UILabel;
import jp.co.nec.frw1000.pr.component.event.TableMouseAdapter;
import jp.co.nec.frw1000.pr.component.table.UITableColumn;
import jp.co.okasan.cmn.TableLabelRenderer;
import jp.co.okasan.frw.pr.MUIHalfWidthANTextField;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUITable;
import jp.co.okasan.frw.pr.MUITableColumn;

/**
 * Hlp8904Panel Class's Description <br>
 * <p>
 * Client area class of CboTBond_Contract
 * </p>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Hlp8904Panel extends Frw00ClientPanel {
	
	////////// Define Variables //////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** jscroll panel */
	JScrollPane jScrollPane = null;
	
	/** table data List */  
	MUITable tblDataList = null;
	
	/** Id Label*/
	MUILabel lblId = null;
	
	/** Id TextField  */
	MUIHalfWidthTextField txtId = null;
	
	/** DelCd Label*/
	MUILabel lblDelCd = null;
	
	/** DelCd TextField  */
	MUIHalfWidthTextField txtDelCd = null;
	
	/** ContractNo Label*/
	MUILabel lblContractNo = null;
	
	/** ContractNo TextField  */
	MUIHalfWidthTextField txtContractNo = null;
	
	/** ContractType Label*/
	MUILabel lblContractType = null;
	
	/** ContractType TextField  */
	MUIHalfWidthTextField txtContractType = null;
	
	/** BondCd Label*/
	MUILabel lblBondCd = null;
	
	/** BondCd TextField  */
	MUIHalfWidthTextField txtBondCd = null;
	
	/** SubAccoCd Label*/
	MUILabel lblSubAccoCd = null;
	
	/** SubAccoCd TextField  */
	MUIHalfWidthTextField txtSubAccoCd = null;
	
	/** Qty Label*/
	MUILabel lblQty = null;
	
	/** Qty TextField  */
	MUIHalfWidthTextField txtQty = null;
	
	/** Amount Label*/
	MUILabel lblAmount = null;
	
	/** Amount TextField  */
	MUIHalfWidthTextField txtAmount = null;
	
	/** TaxAmt Label*/
	MUILabel lblTaxAmt = null;
	
	/** TaxAmt TextField  */
	MUIHalfWidthTextField txtTaxAmt = null;
	
	/** InterestAmt Label*/
	MUILabel lblInterestAmt = null;
	
	/** InterestAmt TextField  */
	MUIHalfWidthTextField txtInterestAmt = null;
	
	/** PaymentMethod Label*/
	MUILabel lblPaymentMethod = null;
	
	/** PaymentMethod TextField  */
	MUIHalfWidthTextField txtPaymentMethod = null;
	
	/** IntPaymentMethod Label*/
	MUILabel lblIntPaymentMethod = null;
	
	/** IntPaymentMethod TextField  */
	MUIHalfWidthTextField txtIntPaymentMethod = null;
	
	/** ContractDate Label*/
	MUILabel lblContractDate = null;
	
	/** ContractDate TextField  */
	MUIHalfWidthTextField txtContractDate = null;
	
	/** PaymentCashDate Label*/
	MUILabel lblPaymentCashDate = null;
	
	/** PaymentCashDate TextField  */
	MUIHalfWidthTextField txtPaymentCashDate = null;
	
	/** PaymentSecDate Label*/
	MUILabel lblPaymentSecDate = null;
	
	/** PaymentSecDate TextField  */
	MUIHalfWidthTextField txtPaymentSecDate = null;
	
	/** TransactionCd Label*/
	MUILabel lblTransactionCd = null;
	
	/** TransactionCd TextField  */
	MUIHalfWidthTextField txtTransactionCd = null;
	
	/** ContractSts Label*/
	MUILabel lblContractSts = null;
	
	/** ContractSts TextField  */
	MUIHalfWidthTextField txtContractSts = null;
	
	/** Status Label*/
	MUILabel lblStatus = null;
	
	/** Status TextField  */
	MUIHalfWidthTextField txtStatus = null;
	
	/** Remarks Label*/
	MUILabel lblRemarks = null;
	
	/** Remarks TextField  */
	MUIHalfWidthTextField txtRemarks = null;
	
	/** RegDateTime Label*/
	MUILabel lblRegDateTime = null;
	
	/** RegDateTime TextField  */
	MUIHalfWidthTextField txtRegDateTime = null;
	
	/** RegUserId Label*/
	MUILabel lblRegUserId = null;
	
	/** RegUserId TextField  */
	MUIHalfWidthTextField txtRegUserId = null;
	
	/** UpdDateTime Label*/
	MUILabel lblUpdDateTime = null;
	
	/** UpdDateTime TextField  */
	MUIHalfWidthTextField txtUpdDateTime = null;
	
	/** UpdUserId Label*/
	MUILabel lblUpdUserId = null;
	
	/** UpdUserId TextField  */
	MUIHalfWidthTextField txtUpdUserId = null;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor <br>
	 * Call Constructor base template.
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public Hlp8904Panel() {
        super();

        try {
            // Init panel
            jbInit();

        } catch (Exception e) {
            // Show error if exist
            showErrorDialog(e, true);
        }
    }
	
	////////// Methods Define//////////
	
	/**
	 * Put selected data from help screen to parent screen. <br>
	 * 
	 * @param Nothing
	 * @return HashMap map put data
	 * @exception Frw10ClientException when have a failure of select data
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap createDeliverData() throws Frw10ClientException {
	
		// Init HashMap
        HashMap map = new HashMap();
		
		// Init row to map
		int getRow0 = 0;
		int getRow1 = 1;
		int getRow2 = 2;
		int getRow3 = 3;
		int getRow4 = 4;
		int getRow5 = 5;
		int getRow6 = 6;
		int getRow7 = 7;
		int getRow8 = 8;
		int getRow9 = 9;
		int getRow10 = 10;
		int getRow11 = 11;
		int getRow12 = 12;
		int getRow13 = 13;
		int getRow14 = 14;
		int getRow15 = 15;
		int getRow16 = 16;
		int getRow17 = 17;
		int getRow18 = 18;
		int getRow19 = 19;
		int getRow20 = 20;
		int getRow21 = 21;
        
		// Init transfer param
		String transferId = "id";
		String transferContractNo = "contractNo";
		String transferContractType = "contractType";
		String transferBondCd = "bondCd";
		String transferSubAccoCd = "subAccoCd";
		String transferQty = "qty";
		String transferAmount = "amount";
		String transferTaxAmt = "taxAmt";
		String transferInterestAmt = "interestAmt";
		String transferPaymentMethod = "paymentMethod";
		String transferIntPaymentMethod = "intPaymentMethod";
		String transferContractDate = "contractDate";
		String transferPaymentCashDate = "paymentCashDate";
		String transferPaymentSecDate = "paymentSecDate";
		String transferTransactionCd = "transactionCd";
		String transferContractSts = "contractSts";
		String transferStatus = "status";
		String transferRemarks = "remarks";
		String transferRegDateTime = "regDateTime";
		String transferRegUserId = "regUserId";
		String transferUpdDateTime = "updDateTime";
		String transferUpdUserId = "updUserId";
        
        // Get row model array
        Object[] objTblRowModel= tblDataList.getSelectedRowModel();

        // Put into map
        if ( objTblRowModel != null ) {
            map.put(toTransferName(transferId), objTblRowModel[getRow0]);
            map.put(toTransferName(transferContractNo), objTblRowModel[getRow1]);
            map.put(toTransferName(transferContractType), objTblRowModel[getRow2]);
            map.put(toTransferName(transferBondCd), objTblRowModel[getRow3]);
            map.put(toTransferName(transferSubAccoCd), objTblRowModel[getRow4]);
            map.put(toTransferName(transferQty), objTblRowModel[getRow5]);
            map.put(toTransferName(transferAmount), objTblRowModel[getRow6]);
            map.put(toTransferName(transferTaxAmt), objTblRowModel[getRow7]);
            map.put(toTransferName(transferInterestAmt), objTblRowModel[getRow8]);
            map.put(toTransferName(transferPaymentMethod), objTblRowModel[getRow9]);
            map.put(toTransferName(transferIntPaymentMethod), objTblRowModel[getRow10]);
            map.put(toTransferName(transferContractDate), objTblRowModel[getRow11]);
            map.put(toTransferName(transferPaymentCashDate), objTblRowModel[getRow12]);
            map.put(toTransferName(transferPaymentSecDate), objTblRowModel[getRow13]);
            map.put(toTransferName(transferTransactionCd), objTblRowModel[getRow14]);
            map.put(toTransferName(transferContractSts), objTblRowModel[getRow15]);
            map.put(toTransferName(transferStatus), objTblRowModel[getRow16]);
            map.put(toTransferName(transferRemarks), objTblRowModel[getRow17]);
            map.put(toTransferName(transferRegDateTime), objTblRowModel[getRow18]);
            map.put(toTransferName(transferRegUserId), objTblRowModel[getRow19]);
            map.put(toTransferName(transferUpdDateTime), objTblRowModel[getRow20]);
            map.put(toTransferName(transferUpdUserId), objTblRowModel[getRow21]);
        }
        return map;
	}
	
	/**
     * Method clear table data of screen's component. <br>
     * 
     * @param
     * @exception
     */
    void clearTable() {
	
    	// Reset table data List
    	tblDataList.reset();
		Frw00BaseTemplateFrame frame = (Frw00BaseTemplateFrame) getTopLevelAncestor();
		frame.transferFocus();
    }
	
	/**
	 * Method init panel of screen. <br>
	 * 
	 * @param Nothing
	 * @exception Exception when have an exception while screen creating
	 */
	private void jbInit() throws Exception {
	
		// Id Label
		lblId = new MUILabel();
		lblId.setOpaque(false);
		lblId.setText("Hlp8904Panel_lblId");
		lblId.setBounds(new Rectangle(25,10,80,20));
		this.add(lblId);
		
		// Id TextField
		txtId = new MUIHalfWidthTextField();
		txtId.setBounds(new Rectangle(25, 35, 80, 20));
		txtId.setPartsName("id");
		this.add(txtId);
		
		// ContractNo Label
		lblContractNo = new MUILabel();
		lblContractNo.setOpaque(false);
		lblContractNo.setText("Hlp8904Panel_lblContractNo");
		lblContractNo.setBounds(new Rectangle(105,10,80,20));
		this.add(lblContractNo);
		
		// ContractNo TextField
		txtContractNo = new MUIHalfWidthTextField();
		txtContractNo.setMaxLength(80);
		txtContractNo.setBounds(new Rectangle(105, 35, 80, 20));
		txtContractNo.setPartsName("contractNo");
		this.add(txtContractNo);
		
		// ContractType Label
		lblContractType = new MUILabel();
		lblContractType.setOpaque(false);
		lblContractType.setText("Hlp8904Panel_lblContractType");
		lblContractType.setBounds(new Rectangle(185,10,80,20));
		this.add(lblContractType);
		
		// ContractType TextField
		txtContractType = new MUIHalfWidthTextField();
		txtContractType.setBounds(new Rectangle(185, 35, 80, 20));
		txtContractType.setPartsName("contractType");
		this.add(txtContractType);
		
		// BondCd Label
		lblBondCd = new MUILabel();
		lblBondCd.setOpaque(false);
		lblBondCd.setText("Hlp8904Panel_lblBondCd");
		lblBondCd.setBounds(new Rectangle(265,10,80,20));
		this.add(lblBondCd);
		
		// BondCd TextField
		txtBondCd = new MUIHalfWidthTextField();
		txtBondCd.setMaxLength(80);
		txtBondCd.setBounds(new Rectangle(265, 35, 80, 20));
		txtBondCd.setPartsName("bondCd");
		this.add(txtBondCd);
		
		// SubAccoCd Label
		lblSubAccoCd = new MUILabel();
		lblSubAccoCd.setOpaque(false);
		lblSubAccoCd.setText("Hlp8904Panel_lblSubAccoCd");
		lblSubAccoCd.setBounds(new Rectangle(345,10,80,20));
		this.add(lblSubAccoCd);
		
		// SubAccoCd TextField
		txtSubAccoCd = new MUIHalfWidthTextField();
		txtSubAccoCd.setBounds(new Rectangle(345, 35, 80, 20));
		txtSubAccoCd.setPartsName("subAccoCd");
		this.add(txtSubAccoCd);
		
		// Qty Label
		lblQty = new MUILabel();
		lblQty.setOpaque(false);
		lblQty.setText("Hlp8904Panel_lblQty");
		lblQty.setBounds(new Rectangle(425,10,80,20));
		this.add(lblQty);
		
		// Qty TextField
		txtQty = new MUIHalfWidthTextField();
		txtQty.setBounds(new Rectangle(425, 35, 80, 20));
		txtQty.setPartsName("qty");
		this.add(txtQty);
		
		// Amount Label
		lblAmount = new MUILabel();
		lblAmount.setOpaque(false);
		lblAmount.setText("Hlp8904Panel_lblAmount");
		lblAmount.setBounds(new Rectangle(505,10,80,20));
		this.add(lblAmount);
		
		// Amount TextField
		txtAmount = new MUIHalfWidthTextField();
		txtAmount.setBounds(new Rectangle(505, 35, 80, 20));
		txtAmount.setPartsName("amount");
		this.add(txtAmount);
		
		// TaxAmt Label
		lblTaxAmt = new MUILabel();
		lblTaxAmt.setOpaque(false);
		lblTaxAmt.setText("Hlp8904Panel_lblTaxAmt");
		lblTaxAmt.setBounds(new Rectangle(585,10,80,20));
		this.add(lblTaxAmt);
		
		// TaxAmt TextField
		txtTaxAmt = new MUIHalfWidthTextField();
		txtTaxAmt.setBounds(new Rectangle(585, 35, 80, 20));
		txtTaxAmt.setPartsName("taxAmt");
		this.add(txtTaxAmt);
		
		// InterestAmt Label
		lblInterestAmt = new MUILabel();
		lblInterestAmt.setOpaque(false);
		lblInterestAmt.setText("Hlp8904Panel_lblInterestAmt");
		lblInterestAmt.setBounds(new Rectangle(665,10,80,20));
		this.add(lblInterestAmt);
		
		// InterestAmt TextField
		txtInterestAmt = new MUIHalfWidthTextField();
		txtInterestAmt.setBounds(new Rectangle(665, 35, 80, 20));
		txtInterestAmt.setPartsName("interestAmt");
		this.add(txtInterestAmt);
		
		// PaymentMethod Label
		lblPaymentMethod = new MUILabel();
		lblPaymentMethod.setOpaque(false);
		lblPaymentMethod.setText("Hlp8904Panel_lblPaymentMethod");
		lblPaymentMethod.setBounds(new Rectangle(745,10,80,20));
		this.add(lblPaymentMethod);
		
		// PaymentMethod TextField
		txtPaymentMethod = new MUIHalfWidthTextField();
		txtPaymentMethod.setBounds(new Rectangle(745, 35, 80, 20));
		txtPaymentMethod.setPartsName("paymentMethod");
		this.add(txtPaymentMethod);
		
		// IntPaymentMethod Label
		lblIntPaymentMethod = new MUILabel();
		lblIntPaymentMethod.setOpaque(false);
		lblIntPaymentMethod.setText("Hlp8904Panel_lblIntPaymentMethod");
		lblIntPaymentMethod.setBounds(new Rectangle(825,10,80,20));
		this.add(lblIntPaymentMethod);
		
		// IntPaymentMethod TextField
		txtIntPaymentMethod = new MUIHalfWidthTextField();
		txtIntPaymentMethod.setBounds(new Rectangle(825, 35, 80, 20));
		txtIntPaymentMethod.setPartsName("intPaymentMethod");
		this.add(txtIntPaymentMethod);
		
		// ContractDate Label
		lblContractDate = new MUILabel();
		lblContractDate.setOpaque(false);
		lblContractDate.setText("Hlp8904Panel_lblContractDate");
		lblContractDate.setBounds(new Rectangle(905,10,80,20));
		this.add(lblContractDate);
		
		// ContractDate TextField
		txtContractDate = new MUIHalfWidthTextField();
		txtContractDate.setBounds(new Rectangle(905, 35, 80, 20));
		txtContractDate.setPartsName("contractDate");
		this.add(txtContractDate);
		
		// PaymentCashDate Label
		lblPaymentCashDate = new MUILabel();
		lblPaymentCashDate.setOpaque(false);
		lblPaymentCashDate.setText("Hlp8904Panel_lblPaymentCashDate");
		lblPaymentCashDate.setBounds(new Rectangle(985,10,80,20));
		this.add(lblPaymentCashDate);
		
		// PaymentCashDate TextField
		txtPaymentCashDate = new MUIHalfWidthTextField();
		txtPaymentCashDate.setBounds(new Rectangle(985, 35, 80, 20));
		txtPaymentCashDate.setPartsName("paymentCashDate");
		this.add(txtPaymentCashDate);
		
		// PaymentSecDate Label
		lblPaymentSecDate = new MUILabel();
		lblPaymentSecDate.setOpaque(false);
		lblPaymentSecDate.setText("Hlp8904Panel_lblPaymentSecDate");
		lblPaymentSecDate.setBounds(new Rectangle(1065,10,80,20));
		this.add(lblPaymentSecDate);
		
		// PaymentSecDate TextField
		txtPaymentSecDate = new MUIHalfWidthTextField();
		txtPaymentSecDate.setBounds(new Rectangle(1065, 35, 80, 20));
		txtPaymentSecDate.setPartsName("paymentSecDate");
		this.add(txtPaymentSecDate);
		
		// TransactionCd Label
		lblTransactionCd = new MUILabel();
		lblTransactionCd.setOpaque(false);
		lblTransactionCd.setText("Hlp8904Panel_lblTransactionCd");
		lblTransactionCd.setBounds(new Rectangle(1145,10,80,20));
		this.add(lblTransactionCd);
		
		// TransactionCd TextField
		txtTransactionCd = new MUIHalfWidthTextField();
		txtTransactionCd.setMaxLength(1);
		txtTransactionCd.setBounds(new Rectangle(1145, 35, 80, 20));
		txtTransactionCd.setPartsName("transactionCd");
		this.add(txtTransactionCd);
		
		// ContractSts Label
		lblContractSts = new MUILabel();
		lblContractSts.setOpaque(false);
		lblContractSts.setText("Hlp8904Panel_lblContractSts");
		lblContractSts.setBounds(new Rectangle(1225,10,80,20));
		this.add(lblContractSts);
		
		// ContractSts TextField
		txtContractSts = new MUIHalfWidthTextField();
		txtContractSts.setBounds(new Rectangle(1225, 35, 80, 20));
		txtContractSts.setPartsName("contractSts");
		this.add(txtContractSts);
		
		// Status Label
		lblStatus = new MUILabel();
		lblStatus.setOpaque(false);
		lblStatus.setText("Hlp8904Panel_lblStatus");
		lblStatus.setBounds(new Rectangle(1305,10,80,20));
		this.add(lblStatus);
		
		// Status TextField
		txtStatus = new MUIHalfWidthTextField();
		txtStatus.setBounds(new Rectangle(1305, 35, 80, 20));
		txtStatus.setPartsName("status");
		this.add(txtStatus);
		
		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Hlp8904Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(1385,10,80,20));
		this.add(lblRemarks);
		
		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(800);
		txtRemarks.setBounds(new Rectangle(1385, 35, 80, 20));
		txtRemarks.setPartsName("remarks");
		this.add(txtRemarks);
		
		// RegDateTime Label
		lblRegDateTime = new MUILabel();
		lblRegDateTime.setOpaque(false);
		lblRegDateTime.setText("Hlp8904Panel_lblRegDateTime");
		lblRegDateTime.setBounds(new Rectangle(1465,10,80,20));
		this.add(lblRegDateTime);
		
		// RegDateTime TextField
		txtRegDateTime = new MUIHalfWidthTextField();
		txtRegDateTime.setBounds(new Rectangle(1465, 35, 80, 20));
		txtRegDateTime.setPartsName("regDateTime");
		this.add(txtRegDateTime);
		
		// RegUserId Label
		lblRegUserId = new MUILabel();
		lblRegUserId.setOpaque(false);
		lblRegUserId.setText("Hlp8904Panel_lblRegUserId");
		lblRegUserId.setBounds(new Rectangle(1545,10,80,20));
		this.add(lblRegUserId);
		
		// RegUserId TextField
		txtRegUserId = new MUIHalfWidthTextField();
		txtRegUserId.setMaxLength(120);
		txtRegUserId.setBounds(new Rectangle(1545, 35, 80, 20));
		txtRegUserId.setPartsName("regUserId");
		this.add(txtRegUserId);
		
		// UpdDateTime Label
		lblUpdDateTime = new MUILabel();
		lblUpdDateTime.setOpaque(false);
		lblUpdDateTime.setText("Hlp8904Panel_lblUpdDateTime");
		lblUpdDateTime.setBounds(new Rectangle(1625,10,80,20));
		this.add(lblUpdDateTime);
		
		// UpdDateTime TextField
		txtUpdDateTime = new MUIHalfWidthTextField();
		txtUpdDateTime.setBounds(new Rectangle(1625, 35, 80, 20));
		txtUpdDateTime.setPartsName("updDateTime");
		this.add(txtUpdDateTime);
		
		// UpdUserId Label
		lblUpdUserId = new MUILabel();
		lblUpdUserId.setOpaque(false);
		lblUpdUserId.setText("Hlp8904Panel_lblUpdUserId");
		lblUpdUserId.setBounds(new Rectangle(1705,10,80,20));
		this.add(lblUpdUserId);
		
		// UpdUserId TextField
		txtUpdUserId = new MUIHalfWidthTextField();
		txtUpdUserId.setMaxLength(30);
		txtUpdUserId.setBounds(new Rectangle(1705, 35, 80, 20));
		txtUpdUserId.setPartsName("updUserId");
		this.add(txtUpdUserId);
		
		// Declare Columns
		MUITableColumn column0 = new MUITableColumn();
		MUITableColumn column1 = new MUITableColumn();
		MUITableColumn column2 = new MUITableColumn();
		MUITableColumn column3 = new MUITableColumn();
		MUITableColumn column4 = new MUITableColumn();
		MUITableColumn column5 = new MUITableColumn();
		MUITableColumn column6 = new MUITableColumn();
		MUITableColumn column7 = new MUITableColumn();
		MUITableColumn column8 = new MUITableColumn();
		MUITableColumn column9 = new MUITableColumn();
		MUITableColumn column10 = new MUITableColumn();
		MUITableColumn column11 = new MUITableColumn();
		MUITableColumn column12 = new MUITableColumn();
		MUITableColumn column13 = new MUITableColumn();
		MUITableColumn column14 = new MUITableColumn();
		MUITableColumn column15 = new MUITableColumn();
		MUITableColumn column16 = new MUITableColumn();
		MUITableColumn column17 = new MUITableColumn();
		MUITableColumn column18 = new MUITableColumn();
		MUITableColumn column19 = new MUITableColumn();
		MUITableColumn column20 = new MUITableColumn();
		MUITableColumn column21 = new MUITableColumn();
		
		// Id
		column0.setColumnName("Hlp8904Panel_lblId");
		column0.setWidth(80);
		column0.setColumnClass(String.class);
		//column0.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract No
		column1.setColumnName("Hlp8904Panel_lblContractNo");
		column1.setWidth(80);
		column1.setColumnClass(String.class);
		//column1.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Type
		column2.setColumnName("Hlp8904Panel_lblContractType");
		column2.setWidth(80);
		column2.setColumnClass(String.class);
		//column2.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Bond Cd
		column3.setColumnName("Hlp8904Panel_lblBondCd");
		column3.setWidth(80);
		column3.setColumnClass(String.class);
		//column3.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Sub Acco Cd
		column4.setColumnName("Hlp8904Panel_lblSubAccoCd");
		column4.setWidth(80);
		column4.setColumnClass(String.class);
		//column4.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Qty
		column5.setColumnName("Hlp8904Panel_lblQty");
		column5.setWidth(80);
		column5.setColumnClass(String.class);
		//column5.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Amount
		column6.setColumnName("Hlp8904Panel_lblAmount");
		column6.setWidth(80);
		column6.setColumnClass(String.class);
		//column6.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Tax Amt
		column7.setColumnName("Hlp8904Panel_lblTaxAmt");
		column7.setWidth(80);
		column7.setColumnClass(String.class);
		//column7.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Interest Amt
		column8.setColumnName("Hlp8904Panel_lblInterestAmt");
		column8.setWidth(80);
		column8.setColumnClass(String.class);
		//column8.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Payment Method
		column9.setColumnName("Hlp8904Panel_lblPaymentMethod");
		column9.setWidth(80);
		column9.setColumnClass(String.class);
		//column9.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Int Payment Method
		column10.setColumnName("Hlp8904Panel_lblIntPaymentMethod");
		column10.setWidth(80);
		column10.setColumnClass(String.class);
		//column10.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Date
		column11.setColumnName("Hlp8904Panel_lblContractDate");
		column11.setWidth(80);
		column11.setColumnClass(String.class);
		//column11.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Payment Cash Date
		column12.setColumnName("Hlp8904Panel_lblPaymentCashDate");
		column12.setWidth(80);
		column12.setColumnClass(String.class);
		//column12.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Payment Sec Date
		column13.setColumnName("Hlp8904Panel_lblPaymentSecDate");
		column13.setWidth(80);
		column13.setColumnClass(String.class);
		//column13.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Transaction Cd
		column14.setColumnName("Hlp8904Panel_lblTransactionCd");
		column14.setWidth(80);
		column14.setColumnClass(String.class);
		//column14.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Sts
		column15.setColumnName("Hlp8904Panel_lblContractSts");
		column15.setWidth(80);
		column15.setColumnClass(String.class);
		//column15.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Status
		column16.setColumnName("Hlp8904Panel_lblStatus");
		column16.setWidth(80);
		column16.setColumnClass(String.class);
		//column16.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Remarks
		column17.setColumnName("Hlp8904Panel_lblRemarks");
		column17.setWidth(80);
		column17.setColumnClass(String.class);
		//column17.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Reg Date Time
		column18.setColumnName("Hlp8904Panel_lblRegDateTime");
		column18.setWidth(80);
		column18.setColumnClass(String.class);
		//column18.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Reg User Id
		column19.setColumnName("Hlp8904Panel_lblRegUserId");
		column19.setWidth(80);
		column19.setColumnClass(String.class);
		//column19.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Upd Date Time
		column20.setColumnName("Hlp8904Panel_lblUpdDateTime");
		column20.setWidth(80);
		column20.setColumnClass(String.class);
		//column20.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Upd User Id
		column21.setColumnName("Hlp8904Panel_lblUpdUserId");
		column21.setWidth(80);
		column21.setColumnClass(String.class);
		//column21.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		Object[] column = {column0, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12, column13, column14, column15, column16, column17, column18, column19, column20, column21, };
		
		// data List
		tblDataList = new MUITable();
		tblDataList.setColumnData(column);
		tblDataList.setGridColor(Color.lightGray);
		tblDataList.setPartsName("dataList");
	    tblDataList.addMouseListener(new TableMouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	    		if (e.getClickCount() == 2) {
	    			try {
	    				createDeliverData();
	    				Frw00BaseTemplateFrame frame = (Frw00BaseTemplateFrame) getTopLevelAncestor();
	    				Frw00CloseWindowAction closeAction = new Frw00CloseWindowAction(); 
	    				closeAction.executeAction(frame);
	    			} catch (Frw10ClientException ex) {
	    				// 
	    			}
	    		}
	    	}
	    });
		
		TableCellRenderer render = tblDataList.getTableHeader().getDefaultRenderer();
	    JComponent comp = (JComponent)render.getTableCellRendererComponent(tblDataList, null, false, false, 0, 0);
	    Dimension dim = comp.getPreferredSize();
		
	    // Set Width & height
	    dim.height = 20; 
	    dim.width = 1150; 
	    comp.setPreferredSize(dim);
		
		// Add to scroll panel
		jScrollPane = new JScrollPane();
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(new Rectangle(25, 60, 580, 284));
		jScrollPane.getViewport().add(tblDataList, null);
		this.setPreferredSize(new Dimension(630, 380));
		this.add(jScrollPane);
	}
	
	/**
     * Return the source component which called the help screen <br>
     * 
     * @param name 
     * @return the source component
     * @exception Nothing
     */
    private String toTransferName(String name) {
        Frw00TransferKeyData keyData = getTransferKeyData();      
        if (keyData != null) {
            return keyData.getTransferKey(name);
        }
		
        return name;
    }
}
