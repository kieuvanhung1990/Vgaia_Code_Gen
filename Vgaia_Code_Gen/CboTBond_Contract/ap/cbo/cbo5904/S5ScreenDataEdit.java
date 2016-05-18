/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904ResultData;

/**
 * S5ScreenDataEdit Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class S5ScreenDataEdit implements IStage {

	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S5ScreenDataEdit.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor Method <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S5ScreenDataEdit() {
	}
	
	////////// Class Methods //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	}
	
	/**
	 * Process Screen Data Edit task <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Edit screen data
		editScreenData(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Method edit screen data <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void editScreenData(Context ctx) {
		Cbo5904Context context = (Cbo5904Context) ctx;
		Cbo5904ResultData resultData = context.getResultData();

		// Get Action mode
		final String actionMode = context.getInputData().getActionMode();

		// Mode
		resultData.setActionMode(actionMode);
		
		// Get current data from context
		CboTBond_ContractData currentData = context.getCurrentData();

		
		// Set Id
		if(currentData.getId() == null){
			resultData.setId("");
		}else{
			resultData.setId(currentData.getId().toString());
		}
		
		// Set Contract No
		resultData.setContractNo(currentData.getContractNo());
		
		// Set Contract Type
		if(currentData.getContractType() == null){
			resultData.setContractType("");
		}else{
			resultData.setContractType(currentData.getContractType().toString());
		}
		
		// Set Bond Cd
		resultData.setBondCd(currentData.getBondCd());
		
		// Set Sub Acco Cd
		if(currentData.getSubAccoCd() == null){
			resultData.setSubAccoCd("");
		}else{
			resultData.setSubAccoCd(currentData.getSubAccoCd().toString());
		}
		
		// Set Qty
		if(currentData.getQty() == null){
			resultData.setQty("");
		}else{
			resultData.setQty(currentData.getQty().toString());
		}
		
		// Set Amount
		if(currentData.getAmount() == null){
			resultData.setAmount("");
		}else{
			resultData.setAmount(currentData.getAmount().toString());
		}
		
		// Set Tax Amt
		if(currentData.getTaxAmt() == null){
			resultData.setTaxAmt("");
		}else{
			resultData.setTaxAmt(currentData.getTaxAmt().toString());
		}
		
		// Set Interest Amt
		if(currentData.getInterestAmt() == null){
			resultData.setInterestAmt("");
		}else{
			resultData.setInterestAmt(currentData.getInterestAmt().toString());
		}
		
		// Set Payment Method
		if(currentData.getPaymentMethod() == null){
			resultData.setPaymentMethod("");
		}else{
			resultData.setPaymentMethod(currentData.getPaymentMethod().toString());
		}
		
		// Set Int Payment Method
		if(currentData.getIntPaymentMethod() == null){
			resultData.setIntPaymentMethod("");
		}else{
			resultData.setIntPaymentMethod(currentData.getIntPaymentMethod().toString());
		}
		
		// Set Contract Date
		if(currentData.getContractDate() == null){
			resultData.setContractDate("");
		}else{
			resultData.setContractDate(currentData.getContractDate().toString());
		}
		
		// Set Payment Cash Date
		if(currentData.getPaymentCashDate() == null){
			resultData.setPaymentCashDate("");
		}else{
			resultData.setPaymentCashDate(currentData.getPaymentCashDate().toString());
		}
		
		// Set Payment Sec Date
		if(currentData.getPaymentSecDate() == null){
			resultData.setPaymentSecDate("");
		}else{
			resultData.setPaymentSecDate(currentData.getPaymentSecDate().toString());
		}
		
		// Set Transaction Cd
		resultData.setTransactionCd(currentData.getTransactionCd());
		
		// Set Contract Sts
		if(currentData.getContractSts() == null){
			resultData.setContractSts("");
		}else{
			resultData.setContractSts(currentData.getContractSts().toString());
		}
		
		// Set Status
		if(currentData.getStatus() == null){
			resultData.setStatus("");
		}else{
			resultData.setStatus(currentData.getStatus().toString());
		}
		
		// Set Remarks
		resultData.setRemarks(currentData.getRemarks());
	
		// Registered Date Time
		if (currentData.getRegDateTime() != null) {
			resultData.setRegDateTime(new SimpleDateFormat("MM/dd/yy HH:mm")
					.format(currentData.getRegDateTime()));
		} else {
			resultData.setRegDateTime("");
		}

		// Registered User Id
		resultData.setRegUserId(currentData.getRegUserId());

		// Updated Date Time
		if (currentData.getUpdDateTime() != null) {
			resultData.setUpdDateTime(new SimpleDateFormat("MM/dd/yy HH:mm")
					.format(currentData.getUpdDateTime()));
			resultData.setTimeStamp(currentData.getUpdDateTime().toString());
		} else {
			resultData.setUpdDateTime("");
			resultData.setTimeStamp("");
		}

		// Updated User Id
		resultData.setUpdUserId(currentData.getUpdUserId());
	}
}
