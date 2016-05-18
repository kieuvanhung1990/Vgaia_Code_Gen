/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.mst.mst3032;

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


import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * Mst3032Panel Class's Description<br>
 * <P>
 * Client area class of MstTContract screen.
 * </p>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032Panel extends Frw00ClientPanel implements ItemListener {
	
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
	
	/** Contract Type Id label */
	MUILabel lblContractTypeId = null;
	
	/** Contract Name label */
	MUILabel lblContractName = null;
	
	/** Company label */
	MUILabel lblCompany = null;
	
	/** Tel label */
	MUILabel lblTel = null;
	
	/** Address label */
	MUILabel lblAddress = null;
	
	/** Represent Name label */
	MUILabel lblRepresentName = null;
	
	/** Represent Id label */
	MUILabel lblRepresentId = null;
	
	/** Contract Date label */
	MUILabel lblContractDate = null;
	
	/** Finish Date label */
	MUILabel lblFinishDate = null;
	
	/** Transaction Cd label */
	MUILabel lblTransactionCd = null;
	
	/** Remarks label */
	MUILabel lblRemarks = null;
	
	/** Status label */
	MUILabel lblStatus = null;
	
	/** Reg Date Time label */
	MUILabel lblRegistered = null;
	
	/** Upd Date Time label */
	MUILabel lblUpdated = null;
	
	/** Id TextField */
	MUIHalfWidthTextField txtId = null;
	
	/** Contract No TextField */
	MUIHalfWidthTextField txtContractNo = null;
	
	/** Contract Type Id TextField */
	MUIHalfWidthTextField txtContractTypeId = null;
	
	/** Contract Name TextField */
	MUIHalfWidthTextField txtContractName = null;
	
	/** Company TextField */
	MUIHalfWidthTextField txtCompany = null;
	
	/** Tel TextField */
	MUIHalfWidthTextField txtTel = null;
	
	/** Address TextField */
	MUIHalfWidthTextField txtAddress = null;
	
	/** Represent Name TextField */
	MUIHalfWidthTextField txtRepresentName = null;
	
	/** Represent Id TextField */
	MUIHalfWidthTextField txtRepresentId = null;
	
	/** Contract Date TextField */
	MUIHalfWidthTextField txtContractDate = null;
	
	/** Finish Date TextField */
	MUIHalfWidthTextField txtFinishDate = null;
	
	/** Transaction Cd TextField */
	MUIHalfWidthTextField txtTransactionCd = null;
	
	/** Remarks TextField */
	MUIHalfWidthTextField txtRemarks = null;
	
	/** Status TextField */
	MUIHalfWidthTextField txtStatus = null;
	
	
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
	public Mst3032Panel() {
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
        String defaultHelpId = "6032";

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
		lblId.setText("Mst3032Panel_lblId");
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
		lblContractNo.setText("Mst3032Panel_lblContractNo");
		lblContractNo.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractNo);
		
		// Contract No TextField
		txtContractNo = new MUIHalfWidthTextField();
		txtContractNo.setMaxLength(12);
		txtContractNo.setBounds(new Rectangle(xOfEditorCol1, lblContractNo.getY(), 100, 20));
		txtContractNo.setAlphabetUpper(false);
		txtContractNo.setPartsName("contractNo");
		this.add(txtContractNo);
		
		y += 25;
		
		// Contract Type Id Label
		lblContractTypeId = new MUILabel();
		lblContractTypeId.setOpaque(false);
		lblContractTypeId.setText("Mst3032Panel_lblContractTypeId");
		lblContractTypeId.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractTypeId);
		
		// Contract Type Id TextField
		txtContractTypeId = new MUIHalfWidthTextField();
		txtContractTypeId.setBounds(new Rectangle(xOfEditorCol1, lblContractTypeId.getY(), 100, 20));
		txtContractTypeId.setAlphabetUpper(false);
		txtContractTypeId.setPartsName("contractTypeId");
		this.add(txtContractTypeId);
		
		y += 25;
		
		// Contract Name Label
		lblContractName = new MUILabel();
		lblContractName.setOpaque(false);
		lblContractName.setText("Mst3032Panel_lblContractName");
		lblContractName.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractName);
		
		// Contract Name TextField
		txtContractName = new MUIHalfWidthTextField();
		txtContractName.setMaxLength(2000);
		txtContractName.setBounds(new Rectangle(xOfEditorCol1, lblContractName.getY(), 100, 20));
		txtContractName.setAlphabetUpper(false);
		txtContractName.setPartsName("contractName");
		this.add(txtContractName);
		
		y += 25;
		
		// Company Label
		lblCompany = new MUILabel();
		lblCompany.setOpaque(false);
		lblCompany.setText("Mst3032Panel_lblCompany");
		lblCompany.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblCompany);
		
		// Company TextField
		txtCompany = new MUIHalfWidthTextField();
		txtCompany.setMaxLength(800);
		txtCompany.setBounds(new Rectangle(xOfEditorCol1, lblCompany.getY(), 100, 20));
		txtCompany.setAlphabetUpper(false);
		txtCompany.setPartsName("company");
		this.add(txtCompany);
		
		y += 25;
		
		// Tel Label
		lblTel = new MUILabel();
		lblTel.setOpaque(false);
		lblTel.setText("Mst3032Panel_lblTel");
		lblTel.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblTel);
		
		// Tel TextField
		txtTel = new MUIHalfWidthTextField();
		txtTel.setMaxLength(80);
		txtTel.setBounds(new Rectangle(xOfEditorCol1, lblTel.getY(), 100, 20));
		txtTel.setAlphabetUpper(false);
		txtTel.setPartsName("tel");
		this.add(txtTel);
		
		y += 25;
		
		// Address Label
		lblAddress = new MUILabel();
		lblAddress.setOpaque(false);
		lblAddress.setText("Mst3032Panel_lblAddress");
		lblAddress.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblAddress);
		
		// Address TextField
		txtAddress = new MUIHalfWidthTextField();
		txtAddress.setMaxLength(2000);
		txtAddress.setBounds(new Rectangle(xOfEditorCol1, lblAddress.getY(), 100, 20));
		txtAddress.setAlphabetUpper(false);
		txtAddress.setPartsName("address");
		this.add(txtAddress);
		
		y += 25;
		
		// Represent Name Label
		lblRepresentName = new MUILabel();
		lblRepresentName.setOpaque(false);
		lblRepresentName.setText("Mst3032Panel_lblRepresentName");
		lblRepresentName.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblRepresentName);
		
		// Represent Name TextField
		txtRepresentName = new MUIHalfWidthTextField();
		txtRepresentName.setMaxLength(800);
		txtRepresentName.setBounds(new Rectangle(xOfEditorCol1, lblRepresentName.getY(), 100, 20));
		txtRepresentName.setAlphabetUpper(false);
		txtRepresentName.setPartsName("representName");
		this.add(txtRepresentName);
		
		y += 25;
		
		// Represent Id Label
		lblRepresentId = new MUILabel();
		lblRepresentId.setOpaque(false);
		lblRepresentId.setText("Mst3032Panel_lblRepresentId");
		lblRepresentId.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblRepresentId);
		
		// Represent Id TextField
		txtRepresentId = new MUIHalfWidthTextField();
		txtRepresentId.setMaxLength(48);
		txtRepresentId.setBounds(new Rectangle(xOfEditorCol1, lblRepresentId.getY(), 100, 20));
		txtRepresentId.setAlphabetUpper(false);
		txtRepresentId.setPartsName("representId");
		this.add(txtRepresentId);
		
		y += 25;
		
		// Contract Date Label
		lblContractDate = new MUILabel();
		lblContractDate.setOpaque(false);
		lblContractDate.setText("Mst3032Panel_lblContractDate");
		lblContractDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblContractDate);
		
		// Contract Date TextField
		txtContractDate = new MUIHalfWidthTextField();
		txtContractDate.setBounds(new Rectangle(xOfEditorCol1, lblContractDate.getY(), 100, 20));
		txtContractDate.setAlphabetUpper(false);
		txtContractDate.setPartsName("contractDate");
		this.add(txtContractDate);
		
		y += 25;
		
		// Finish Date Label
		lblFinishDate = new MUILabel();
		lblFinishDate.setOpaque(false);
		lblFinishDate.setText("Mst3032Panel_lblFinishDate");
		lblFinishDate.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblFinishDate);
		
		// Finish Date TextField
		txtFinishDate = new MUIHalfWidthTextField();
		txtFinishDate.setBounds(new Rectangle(xOfEditorCol1, lblFinishDate.getY(), 100, 20));
		txtFinishDate.setAlphabetUpper(false);
		txtFinishDate.setPartsName("finishDate");
		this.add(txtFinishDate);
		
		y += 25;
		
		// Transaction Cd Label
		lblTransactionCd = new MUILabel();
		lblTransactionCd.setOpaque(false);
		lblTransactionCd.setText("Mst3032Panel_lblTransactionCd");
		lblTransactionCd.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblTransactionCd);
		
		// Transaction Cd TextField
		txtTransactionCd = new MUIHalfWidthTextField();
		txtTransactionCd.setMaxLength(3);
		txtTransactionCd.setBounds(new Rectangle(xOfEditorCol1, lblTransactionCd.getY(), 100, 20));
		txtTransactionCd.setAlphabetUpper(false);
		txtTransactionCd.setPartsName("transactionCd");
		this.add(txtTransactionCd);
		
		y += 25;
		
		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Mst3032Panel_lblRemarks");
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
		
		// Status Label
		lblStatus = new MUILabel();
		lblStatus.setOpaque(false);
		lblStatus.setText("Mst3032Panel_lblStatus");
		lblStatus.setBounds(new Rectangle(xOfLabelCol1, y, lblWidthCol1, 20));
		this.add(lblStatus);
		
		// Status TextField
		txtStatus = new MUIHalfWidthTextField();
		txtStatus.setBounds(new Rectangle(xOfEditorCol1, lblStatus.getY(), 100, 20));
		txtStatus.setAlphabetUpper(false);
		txtStatus.setPartsName("status");
		this.add(txtStatus);
		
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

