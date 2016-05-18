/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;


import java.sql.SQLException;
import java.sql.Timestamp;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;

/**
 * S4DataEditor Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class S4DataEditor implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataEditor.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataEditor() {
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
	 * Process Data Editor task <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Get context
		Cbo5904Context context = (Cbo5904Context) ctx;
		Cbo5904InputData inputData = context.getInputData();

		CboTBond_ContractData updateData = new CboTBond_ContractData();
		
		// Set Id
		updateData.setIdSt(inputData.getId());
		
		// Set Contract No
		updateData.setContractNo(inputData.getContractNo());
		
		// Set Contract Type
		updateData.setContractTypeSt(inputData.getContractType());
		
		// Set Bond Cd
		updateData.setBondCd(inputData.getBondCd());
		
		// Set Sub Acco Cd
		updateData.setSubAccoCdSt(inputData.getSubAccoCd());
		
		// Set Qty
		updateData.setQtySt(inputData.getQty());
		
		// Set Amount
		updateData.setAmountSt(inputData.getAmount());
		
		// Set Tax Amt
		updateData.setTaxAmtSt(inputData.getTaxAmt());
		
		// Set Interest Amt
		updateData.setInterestAmtSt(inputData.getInterestAmt());
		
		// Set Payment Method
		updateData.setPaymentMethodSt(inputData.getPaymentMethod());
		
		// Set Int Payment Method
		updateData.setIntPaymentMethodSt(inputData.getIntPaymentMethod());
		
		// Set Contract Date
		updateData.setContractDateSt(inputData.getContractDate());
		
		// Set Payment Cash Date
		updateData.setPaymentCashDateSt(inputData.getPaymentCashDate());
		
		// Set Payment Sec Date
		updateData.setPaymentSecDateSt(inputData.getPaymentSecDate());
		
		// Set Transaction Cd
		updateData.setTransactionCd(inputData.getTransactionCd());
		
		// Set Contract Sts
		updateData.setContractStsSt(inputData.getContractSts());
		
		// Set Status
		updateData.setStatusSt(inputData.getStatus());
		
		// Set Remarks
		updateData.setRemarks(inputData.getRemarks());
		
		// Set update time
		if (ItemValidator.isNotEmpty(inputData.getTimeStamp())) {
			updateData.setUpdDateTime(Timestamp.valueOf(inputData
					.getTimeStamp()));
		} else {
			updateData.setUpdDateTime(null);
		}

		// Set Current data
		context.setCurrentData(updateData);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}

