/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.hlp.hlp6032;

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
 * Hlp6032Panel Class's Description <br>
 * <p>
 * Client area class of MstTContract
 * </p>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Hlp6032Panel extends Frw00ClientPanel {
	
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
	
	/** ContractTypeId Label*/
	MUILabel lblContractTypeId = null;
	
	/** ContractTypeId TextField  */
	MUIHalfWidthTextField txtContractTypeId = null;
	
	/** ContractName Label*/
	MUILabel lblContractName = null;
	
	/** ContractName TextField  */
	MUIHalfWidthTextField txtContractName = null;
	
	/** Company Label*/
	MUILabel lblCompany = null;
	
	/** Company TextField  */
	MUIHalfWidthTextField txtCompany = null;
	
	/** Tel Label*/
	MUILabel lblTel = null;
	
	/** Tel TextField  */
	MUIHalfWidthTextField txtTel = null;
	
	/** Address Label*/
	MUILabel lblAddress = null;
	
	/** Address TextField  */
	MUIHalfWidthTextField txtAddress = null;
	
	/** RepresentName Label*/
	MUILabel lblRepresentName = null;
	
	/** RepresentName TextField  */
	MUIHalfWidthTextField txtRepresentName = null;
	
	/** RepresentId Label*/
	MUILabel lblRepresentId = null;
	
	/** RepresentId TextField  */
	MUIHalfWidthTextField txtRepresentId = null;
	
	/** ContractDate Label*/
	MUILabel lblContractDate = null;
	
	/** ContractDate TextField  */
	MUIHalfWidthTextField txtContractDate = null;
	
	/** FinishDate Label*/
	MUILabel lblFinishDate = null;
	
	/** FinishDate TextField  */
	MUIHalfWidthTextField txtFinishDate = null;
	
	/** TransactionCd Label*/
	MUILabel lblTransactionCd = null;
	
	/** TransactionCd TextField  */
	MUIHalfWidthTextField txtTransactionCd = null;
	
	/** Remarks Label*/
	MUILabel lblRemarks = null;
	
	/** Remarks TextField  */
	MUIHalfWidthTextField txtRemarks = null;
	
	/** Status Label*/
	MUILabel lblStatus = null;
	
	/** Status TextField  */
	MUIHalfWidthTextField txtStatus = null;
	
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
	public Hlp6032Panel() {
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
        
		// Init transfer param
		String transferId = "id";
		String transferContractNo = "contractNo";
		String transferContractTypeId = "contractTypeId";
		String transferContractName = "contractName";
		String transferCompany = "company";
		String transferTel = "tel";
		String transferAddress = "address";
		String transferRepresentName = "representName";
		String transferRepresentId = "representId";
		String transferContractDate = "contractDate";
		String transferFinishDate = "finishDate";
		String transferTransactionCd = "transactionCd";
		String transferRemarks = "remarks";
		String transferStatus = "status";
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
            map.put(toTransferName(transferContractTypeId), objTblRowModel[getRow2]);
            map.put(toTransferName(transferContractName), objTblRowModel[getRow3]);
            map.put(toTransferName(transferCompany), objTblRowModel[getRow4]);
            map.put(toTransferName(transferTel), objTblRowModel[getRow5]);
            map.put(toTransferName(transferAddress), objTblRowModel[getRow6]);
            map.put(toTransferName(transferRepresentName), objTblRowModel[getRow7]);
            map.put(toTransferName(transferRepresentId), objTblRowModel[getRow8]);
            map.put(toTransferName(transferContractDate), objTblRowModel[getRow9]);
            map.put(toTransferName(transferFinishDate), objTblRowModel[getRow10]);
            map.put(toTransferName(transferTransactionCd), objTblRowModel[getRow11]);
            map.put(toTransferName(transferRemarks), objTblRowModel[getRow12]);
            map.put(toTransferName(transferStatus), objTblRowModel[getRow13]);
            map.put(toTransferName(transferRegDateTime), objTblRowModel[getRow14]);
            map.put(toTransferName(transferRegUserId), objTblRowModel[getRow15]);
            map.put(toTransferName(transferUpdDateTime), objTblRowModel[getRow16]);
            map.put(toTransferName(transferUpdUserId), objTblRowModel[getRow17]);
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
		lblId.setText("Hlp6032Panel_lblId");
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
		lblContractNo.setText("Hlp6032Panel_lblContractNo");
		lblContractNo.setBounds(new Rectangle(105,10,80,20));
		this.add(lblContractNo);
		
		// ContractNo TextField
		txtContractNo = new MUIHalfWidthTextField();
		txtContractNo.setMaxLength(12);
		txtContractNo.setBounds(new Rectangle(105, 35, 80, 20));
		txtContractNo.setPartsName("contractNo");
		this.add(txtContractNo);
		
		// ContractTypeId Label
		lblContractTypeId = new MUILabel();
		lblContractTypeId.setOpaque(false);
		lblContractTypeId.setText("Hlp6032Panel_lblContractTypeId");
		lblContractTypeId.setBounds(new Rectangle(185,10,80,20));
		this.add(lblContractTypeId);
		
		// ContractTypeId TextField
		txtContractTypeId = new MUIHalfWidthTextField();
		txtContractTypeId.setBounds(new Rectangle(185, 35, 80, 20));
		txtContractTypeId.setPartsName("contractTypeId");
		this.add(txtContractTypeId);
		
		// ContractName Label
		lblContractName = new MUILabel();
		lblContractName.setOpaque(false);
		lblContractName.setText("Hlp6032Panel_lblContractName");
		lblContractName.setBounds(new Rectangle(265,10,80,20));
		this.add(lblContractName);
		
		// ContractName TextField
		txtContractName = new MUIHalfWidthTextField();
		txtContractName.setMaxLength(2000);
		txtContractName.setBounds(new Rectangle(265, 35, 80, 20));
		txtContractName.setPartsName("contractName");
		this.add(txtContractName);
		
		// Company Label
		lblCompany = new MUILabel();
		lblCompany.setOpaque(false);
		lblCompany.setText("Hlp6032Panel_lblCompany");
		lblCompany.setBounds(new Rectangle(345,10,80,20));
		this.add(lblCompany);
		
		// Company TextField
		txtCompany = new MUIHalfWidthTextField();
		txtCompany.setMaxLength(800);
		txtCompany.setBounds(new Rectangle(345, 35, 80, 20));
		txtCompany.setPartsName("company");
		this.add(txtCompany);
		
		// Tel Label
		lblTel = new MUILabel();
		lblTel.setOpaque(false);
		lblTel.setText("Hlp6032Panel_lblTel");
		lblTel.setBounds(new Rectangle(425,10,80,20));
		this.add(lblTel);
		
		// Tel TextField
		txtTel = new MUIHalfWidthTextField();
		txtTel.setMaxLength(80);
		txtTel.setBounds(new Rectangle(425, 35, 80, 20));
		txtTel.setPartsName("tel");
		this.add(txtTel);
		
		// Address Label
		lblAddress = new MUILabel();
		lblAddress.setOpaque(false);
		lblAddress.setText("Hlp6032Panel_lblAddress");
		lblAddress.setBounds(new Rectangle(505,10,80,20));
		this.add(lblAddress);
		
		// Address TextField
		txtAddress = new MUIHalfWidthTextField();
		txtAddress.setMaxLength(2000);
		txtAddress.setBounds(new Rectangle(505, 35, 80, 20));
		txtAddress.setPartsName("address");
		this.add(txtAddress);
		
		// RepresentName Label
		lblRepresentName = new MUILabel();
		lblRepresentName.setOpaque(false);
		lblRepresentName.setText("Hlp6032Panel_lblRepresentName");
		lblRepresentName.setBounds(new Rectangle(585,10,80,20));
		this.add(lblRepresentName);
		
		// RepresentName TextField
		txtRepresentName = new MUIHalfWidthTextField();
		txtRepresentName.setMaxLength(800);
		txtRepresentName.setBounds(new Rectangle(585, 35, 80, 20));
		txtRepresentName.setPartsName("representName");
		this.add(txtRepresentName);
		
		// RepresentId Label
		lblRepresentId = new MUILabel();
		lblRepresentId.setOpaque(false);
		lblRepresentId.setText("Hlp6032Panel_lblRepresentId");
		lblRepresentId.setBounds(new Rectangle(665,10,80,20));
		this.add(lblRepresentId);
		
		// RepresentId TextField
		txtRepresentId = new MUIHalfWidthTextField();
		txtRepresentId.setMaxLength(48);
		txtRepresentId.setBounds(new Rectangle(665, 35, 80, 20));
		txtRepresentId.setPartsName("representId");
		this.add(txtRepresentId);
		
		// ContractDate Label
		lblContractDate = new MUILabel();
		lblContractDate.setOpaque(false);
		lblContractDate.setText("Hlp6032Panel_lblContractDate");
		lblContractDate.setBounds(new Rectangle(745,10,80,20));
		this.add(lblContractDate);
		
		// ContractDate TextField
		txtContractDate = new MUIHalfWidthTextField();
		txtContractDate.setBounds(new Rectangle(745, 35, 80, 20));
		txtContractDate.setPartsName("contractDate");
		this.add(txtContractDate);
		
		// FinishDate Label
		lblFinishDate = new MUILabel();
		lblFinishDate.setOpaque(false);
		lblFinishDate.setText("Hlp6032Panel_lblFinishDate");
		lblFinishDate.setBounds(new Rectangle(825,10,80,20));
		this.add(lblFinishDate);
		
		// FinishDate TextField
		txtFinishDate = new MUIHalfWidthTextField();
		txtFinishDate.setBounds(new Rectangle(825, 35, 80, 20));
		txtFinishDate.setPartsName("finishDate");
		this.add(txtFinishDate);
		
		// TransactionCd Label
		lblTransactionCd = new MUILabel();
		lblTransactionCd.setOpaque(false);
		lblTransactionCd.setText("Hlp6032Panel_lblTransactionCd");
		lblTransactionCd.setBounds(new Rectangle(905,10,80,20));
		this.add(lblTransactionCd);
		
		// TransactionCd TextField
		txtTransactionCd = new MUIHalfWidthTextField();
		txtTransactionCd.setMaxLength(3);
		txtTransactionCd.setBounds(new Rectangle(905, 35, 80, 20));
		txtTransactionCd.setPartsName("transactionCd");
		this.add(txtTransactionCd);
		
		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Hlp6032Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(985,10,80,20));
		this.add(lblRemarks);
		
		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(800);
		txtRemarks.setBounds(new Rectangle(985, 35, 80, 20));
		txtRemarks.setPartsName("remarks");
		this.add(txtRemarks);
		
		// Status Label
		lblStatus = new MUILabel();
		lblStatus.setOpaque(false);
		lblStatus.setText("Hlp6032Panel_lblStatus");
		lblStatus.setBounds(new Rectangle(1065,10,80,20));
		this.add(lblStatus);
		
		// Status TextField
		txtStatus = new MUIHalfWidthTextField();
		txtStatus.setBounds(new Rectangle(1065, 35, 80, 20));
		txtStatus.setPartsName("status");
		this.add(txtStatus);
		
		// RegDateTime Label
		lblRegDateTime = new MUILabel();
		lblRegDateTime.setOpaque(false);
		lblRegDateTime.setText("Hlp6032Panel_lblRegDateTime");
		lblRegDateTime.setBounds(new Rectangle(1145,10,80,20));
		this.add(lblRegDateTime);
		
		// RegDateTime TextField
		txtRegDateTime = new MUIHalfWidthTextField();
		txtRegDateTime.setBounds(new Rectangle(1145, 35, 80, 20));
		txtRegDateTime.setPartsName("regDateTime");
		this.add(txtRegDateTime);
		
		// RegUserId Label
		lblRegUserId = new MUILabel();
		lblRegUserId.setOpaque(false);
		lblRegUserId.setText("Hlp6032Panel_lblRegUserId");
		lblRegUserId.setBounds(new Rectangle(1225,10,80,20));
		this.add(lblRegUserId);
		
		// RegUserId TextField
		txtRegUserId = new MUIHalfWidthTextField();
		txtRegUserId.setMaxLength(120);
		txtRegUserId.setBounds(new Rectangle(1225, 35, 80, 20));
		txtRegUserId.setPartsName("regUserId");
		this.add(txtRegUserId);
		
		// UpdDateTime Label
		lblUpdDateTime = new MUILabel();
		lblUpdDateTime.setOpaque(false);
		lblUpdDateTime.setText("Hlp6032Panel_lblUpdDateTime");
		lblUpdDateTime.setBounds(new Rectangle(1305,10,80,20));
		this.add(lblUpdDateTime);
		
		// UpdDateTime TextField
		txtUpdDateTime = new MUIHalfWidthTextField();
		txtUpdDateTime.setBounds(new Rectangle(1305, 35, 80, 20));
		txtUpdDateTime.setPartsName("updDateTime");
		this.add(txtUpdDateTime);
		
		// UpdUserId Label
		lblUpdUserId = new MUILabel();
		lblUpdUserId.setOpaque(false);
		lblUpdUserId.setText("Hlp6032Panel_lblUpdUserId");
		lblUpdUserId.setBounds(new Rectangle(1385,10,80,20));
		this.add(lblUpdUserId);
		
		// UpdUserId TextField
		txtUpdUserId = new MUIHalfWidthTextField();
		txtUpdUserId.setMaxLength(120);
		txtUpdUserId.setBounds(new Rectangle(1385, 35, 80, 20));
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
		
		// Id
		column0.setColumnName("Hlp6032Panel_lblId");
		column0.setWidth(80);
		column0.setColumnClass(String.class);
		//column0.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract No
		column1.setColumnName("Hlp6032Panel_lblContractNo");
		column1.setWidth(80);
		column1.setColumnClass(String.class);
		//column1.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Type Id
		column2.setColumnName("Hlp6032Panel_lblContractTypeId");
		column2.setWidth(80);
		column2.setColumnClass(String.class);
		//column2.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Name
		column3.setColumnName("Hlp6032Panel_lblContractName");
		column3.setWidth(80);
		column3.setColumnClass(String.class);
		//column3.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Company
		column4.setColumnName("Hlp6032Panel_lblCompany");
		column4.setWidth(80);
		column4.setColumnClass(String.class);
		//column4.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Tel
		column5.setColumnName("Hlp6032Panel_lblTel");
		column5.setWidth(80);
		column5.setColumnClass(String.class);
		//column5.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Address
		column6.setColumnName("Hlp6032Panel_lblAddress");
		column6.setWidth(80);
		column6.setColumnClass(String.class);
		//column6.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Represent Name
		column7.setColumnName("Hlp6032Panel_lblRepresentName");
		column7.setWidth(80);
		column7.setColumnClass(String.class);
		//column7.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Represent Id
		column8.setColumnName("Hlp6032Panel_lblRepresentId");
		column8.setWidth(80);
		column8.setColumnClass(String.class);
		//column8.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Contract Date
		column9.setColumnName("Hlp6032Panel_lblContractDate");
		column9.setWidth(80);
		column9.setColumnClass(String.class);
		//column9.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Finish Date
		column10.setColumnName("Hlp6032Panel_lblFinishDate");
		column10.setWidth(80);
		column10.setColumnClass(String.class);
		//column10.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Transaction Cd
		column11.setColumnName("Hlp6032Panel_lblTransactionCd");
		column11.setWidth(80);
		column11.setColumnClass(String.class);
		//column11.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Remarks
		column12.setColumnName("Hlp6032Panel_lblRemarks");
		column12.setWidth(80);
		column12.setColumnClass(String.class);
		//column12.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Status
		column13.setColumnName("Hlp6032Panel_lblStatus");
		column13.setWidth(80);
		column13.setColumnClass(String.class);
		//column13.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Reg Date Time
		column14.setColumnName("Hlp6032Panel_lblRegDateTime");
		column14.setWidth(80);
		column14.setColumnClass(String.class);
		//column14.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Reg User Id
		column15.setColumnName("Hlp6032Panel_lblRegUserId");
		column15.setWidth(80);
		column15.setColumnClass(String.class);
		//column15.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Upd Date Time
		column16.setColumnName("Hlp6032Panel_lblUpdDateTime");
		column16.setWidth(80);
		column16.setColumnClass(String.class);
		//column16.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		// Upd User Id
		column17.setColumnName("Hlp6032Panel_lblUpdUserId");
		column17.setWidth(80);
		column17.setColumnClass(String.class);
		//column17.setCellRenderer(TableLabelRenderer.getHorizontalCenterRenderer());
		
		Object[] column = {column0, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12, column13, column14, column15, column16, column17, };
		
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
	    dim.width = 950; 
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
