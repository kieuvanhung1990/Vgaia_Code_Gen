/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.ap.cmn.APHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cmn.constant.BusinessRoleInfo;
import jp.co.okasan.cm.cmn.PRData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;

/**
 * S1Initial Class's Description <br>
 * 
 * 
 * @author HungKieu 2016/04/15 Create New
 */ 
public class S1Initial implements IStage {
	
	////////// Define Variables //////////

	/** Class name of initial stage */
	private static final String CLASS_NAME = S1Initial.class.getName();
	
 	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Define Constructor //////////
	
	/**
	 * Constructor <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S1Initial() {
	}
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	}
	
	/**
	 * Process initial data. <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Validate PRData
		Cbo5904InputData inputData = ((Cbo5904Context) ctx).getInputData();
		APHelper.validatePRData(inputData.getPrData());

		// Check role
		checkBusinessRole(ctx);

		// Trim data
		trimInputData(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Trim all the input data <br>
	 * 
	 * @param ctx Context
	 * @exception Nothing
	 */
	private void trimInputData(Context ctx) {
		Cbo5904InputData inputData = ((Cbo5904Context) ctx).getInputData();

		
		// Id
		inputData.setId(CommonHelper.trimObject(inputData.getId()));
		
		// Contract No
		inputData.setContractNo(CommonHelper.trimObject(inputData.getContractNo()));
		
		// Contract Type
		inputData.setContractType(CommonHelper.trimObject(inputData.getContractType()));
		
		// Bond Cd
		inputData.setBondCd(CommonHelper.trimObject(inputData.getBondCd()));
		
		// Sub Acco Cd
		inputData.setSubAccoCd(CommonHelper.trimObject(inputData.getSubAccoCd()));
		
		// Qty
		inputData.setQty(CommonHelper.trimObject(inputData.getQty()));
		
		// Amount
		inputData.setAmount(CommonHelper.trimObject(inputData.getAmount()));
		
		// Tax Amt
		inputData.setTaxAmt(CommonHelper.trimObject(inputData.getTaxAmt()));
		
		// Interest Amt
		inputData.setInterestAmt(CommonHelper.trimObject(inputData.getInterestAmt()));
		
		// Payment Method
		inputData.setPaymentMethod(CommonHelper.trimObject(inputData.getPaymentMethod()));
		
		// Int Payment Method
		inputData.setIntPaymentMethod(CommonHelper.trimObject(inputData.getIntPaymentMethod()));
		
		// Contract Date
		inputData.setContractDate(CommonHelper.trimObject(inputData.getContractDate()));
		
		// Payment Cash Date
		inputData.setPaymentCashDate(CommonHelper.trimObject(inputData.getPaymentCashDate()));
		
		// Payment Sec Date
		inputData.setPaymentSecDate(CommonHelper.trimObject(inputData.getPaymentSecDate()));
		
		// Transaction Cd
		inputData.setTransactionCd(CommonHelper.trimObject(inputData.getTransactionCd()));
		
		// Contract Sts
		inputData.setContractSts(CommonHelper.trimObject(inputData.getContractSts()));
		
		// Status
		inputData.setStatus(CommonHelper.trimObject(inputData.getStatus()));
		
		// Remarks
		inputData.setRemarks(CommonHelper.trimObject(inputData.getRemarks()));
		
		// Reg Date Time
		inputData.setRegDateTime(CommonHelper.trimObject(inputData.getRegDateTime()));
		
		// Reg User Id
		inputData.setRegUserId(CommonHelper.trimObject(inputData.getRegUserId()));
		
		// Upd Date Time
		inputData.setUpdDateTime(CommonHelper.trimObject(inputData.getUpdDateTime()));
		
		// Upd User Id
		inputData.setUpdUserId(CommonHelper.trimObject(inputData.getUpdUserId()));
	}
	
	/**
	 * Check business role.<br>
	 * 
	 * @param ctx
	 *            : Context
	 * @throws SQLException
	 */
	private void checkBusinessRole(Context ctx) throws SQLException {

		// Get input data
		Cbo5904InputData inputData = ((Cbo5904Context) ctx).getInputData();

		// Get PrData
		PRData prData = inputData.getPrData();

		// Check accept form
		APHelper.checkBusinessRole(prData.getUserId(), BusinessRoleInfo.F5904,
				true);

		// Get action mode
		String mode = inputData.getActionMode();

		// Check business role execute
		if (ConstantValues.MODE_ENTRY.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F5904_INSERT, true);
		} else if (ConstantValues.MODE_UPDATE.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F5904_UPDATE, true);
		} else if (ConstantValues.MODE_DELETE.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F5904_DELETE, true);
		}
	}
}
