/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5906;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cm.cbo.cbo5906.Cbo5906InputData;

/**
 * S2InputDataCheck class's Description <br>
 * 
 * @author HungKieu 2016/04/19 Create New
 */
public class S2InputDataCheck implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S2InputDataCheck.class.getName();
	
	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////

	/**
	 * Constructor <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S2InputDataCheck() {
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
	 * Process input data check task. <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Validate item
		validateItem(ctx);

		// validate relation of item
		validateRelationalItem(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Validate the input item from screen by Tab order. <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void validateItem(Context ctx) {
	
		// Get input data from context
		Cbo5906InputData inputData = ((Cbo5906Context) ctx).getInputData();
		
		
		// Check Id	
		ItemValidator.checkValue(ConstantValues.TYPE_MANDATORY, inputData.getId(), 0, "id");
		ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getId(), 0, "id");
		ItemValidator.checkDecimalValue(inputData.getId(), 18, 4, "id");
		
		// Check Contract No	
		if (ItemValidator.isNotEmpty(inputData.getContractNo())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractNo(), 80, "contractNo");
		}
		
		// Check Contract Type	
		if (ItemValidator.isNotEmpty(inputData.getContractType())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractType(), 0, "contractType");
			ItemValidator.checkDecimalValue(inputData.getContractType(), 18, 4, "contractType");
		}
		
		// Check Bond Cd	
		if (ItemValidator.isNotEmpty(inputData.getBondCd())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getBondCd(), 80, "bondCd");
		}
		
		// Check Sub Acco Cd	
		if (ItemValidator.isNotEmpty(inputData.getSubAccoCd())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getSubAccoCd(), 0, "subAccoCd");
			ItemValidator.checkDecimalValue(inputData.getSubAccoCd(), 18, 4, "subAccoCd");
		}
		
		// Check Qty	
		if (ItemValidator.isNotEmpty(inputData.getQty())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getQty(), 0, "qty");
			ItemValidator.checkDecimalValue(inputData.getQty(), 18, 4, "qty");
		}
		
		// Check Amount	
		if (ItemValidator.isNotEmpty(inputData.getAmount())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getAmount(), 0, "amount");
			ItemValidator.checkDecimalValue(inputData.getAmount(), 18, 4, "amount");
		}
		
		// Check Tax Amt	
		if (ItemValidator.isNotEmpty(inputData.getTaxAmt())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getTaxAmt(), 0, "taxAmt");
			ItemValidator.checkDecimalValue(inputData.getTaxAmt(), 18, 4, "taxAmt");
		}
		
		// Check Interest Amt	
		if (ItemValidator.isNotEmpty(inputData.getInterestAmt())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getInterestAmt(), 0, "interestAmt");
			ItemValidator.checkDecimalValue(inputData.getInterestAmt(), 18, 4, "interestAmt");
		}
		
		// Check Payment Method	
		if (ItemValidator.isNotEmpty(inputData.getPaymentMethod())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getPaymentMethod(), 0, "paymentMethod");
			ItemValidator.checkDecimalValue(inputData.getPaymentMethod(), 18, 4, "paymentMethod");
		}
		
		// Check Int Payment Method	
		if (ItemValidator.isNotEmpty(inputData.getIntPaymentMethod())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getIntPaymentMethod(), 0, "intPaymentMethod");
			ItemValidator.checkDecimalValue(inputData.getIntPaymentMethod(), 18, 4, "intPaymentMethod");
		}
		
		// Check Contract Date	
		if (ItemValidator.isNotEmpty(inputData.getContractDate())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractDate(), 0, "contractDate");
			ItemValidator.checkDecimalValue(inputData.getContractDate(), 18, 4, "contractDate");
		}
		
		// Check Payment Cash Date	
		if (ItemValidator.isNotEmpty(inputData.getPaymentCashDate())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getPaymentCashDate(), 0, "paymentCashDate");
			ItemValidator.checkDecimalValue(inputData.getPaymentCashDate(), 18, 4, "paymentCashDate");
		}
		
		// Check Payment Sec Date	
		if (ItemValidator.isNotEmpty(inputData.getPaymentSecDate())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getPaymentSecDate(), 0, "paymentSecDate");
			ItemValidator.checkDecimalValue(inputData.getPaymentSecDate(), 18, 4, "paymentSecDate");
		}
		
		// Check Transaction Cd	
		if (ItemValidator.isNotEmpty(inputData.getTransactionCd())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getTransactionCd(), 12, "transactionCd");
		}
		
		// Check Contract Sts	
		if (ItemValidator.isNotEmpty(inputData.getContractSts())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractSts(), 0, "contractSts");
			ItemValidator.checkDecimalValue(inputData.getContractSts(), 18, 4, "contractSts");
		}
		
		// Check Status	
		if (ItemValidator.isNotEmpty(inputData.getStatus())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getStatus(), 0, "status");
			ItemValidator.checkDecimalValue(inputData.getStatus(), 18, 4, "status");
		}
		
		// Check Remarks	
		if (ItemValidator.isNotEmpty(inputData.getRemarks())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getRemarks(), 800, "remarks");
		}
	}
	
	/**
	 * Validation relation between item <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void validateRelationalItem(Context ctx) {
	}
}
