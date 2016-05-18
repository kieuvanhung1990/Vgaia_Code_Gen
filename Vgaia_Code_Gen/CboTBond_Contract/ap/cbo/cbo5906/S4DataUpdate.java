/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5906;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.CommonFunction;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.cmn.PRData;
import jp.co.okasan.cm.cbo.cbo5906.Cbo5906InputData;

/**
 * S4DataUpdate class's Description. <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class S4DataUpdate implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataUpdate.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	/** Declate data updater */
	private CboTBond_ContractUpdater dataUpdater;

	/** Declare data to update */
	private CboTBond_ContractData updateData;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataUpdate() {
	}
	
	////////// Methods Define //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	
		// Init data updater
		dataUpdater = (CboTBond_ContractUpdater) factory
				.getInstance(CboTBond_ContractUpdater.class);
	}
	
	/**
	 * Process Data Update task <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException,Frw00BlockadeException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");
        updateData = new CboTBond_ContractData();

		// Get data to update
		getUpdateData(ctx);

		// Update data
		updateData(ctx);

		// Set data after update
		setDataAfterUpdate(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Method get data to update <BR>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	private void getUpdateData(Context ctx) throws SQLException,
			Frw00BlockadeException {
			
		// Get old data
		CboTBond_ContractData oldData = ((Cbo5906Context) ctx).getCurrentData();
		
		// Get input data
		Cbo5906InputData inputData = ((Cbo5906Context) ctx).getInputData();
		
		updateData = dataUpdater.findDataForUpdate(oldData.getId());

		if (updateData == null) {
			throw new Com00UserError("MSG0011E", "Id");
		} else {
		
			// Check update time
			String oldUpdateDate = null;
			if (inputData.getTimeStamp() != null) {
				oldUpdateDate = inputData.getTimeStamp();
			} else {
				String[] msgArray = { "%1", "form timestamp" };
				List<String[]> msgLst = new ArrayList<>();
				msgLst.add(msgArray);
				throw new Com00UserError("MSG0290E", "", msgLst);
			}

			String newUpdateDate = null;
			if (updateData.getUpdDateTime() != null) {
				newUpdateDate = updateData.getUpdDateTime().toString();
			}

			// Check data and return
			if (!oldUpdateDate.equals(newUpdateDate)) {
				String[] msgArray = { "%1", updateData.getUpdUserId() };
				List<String[]> msgLst = new ArrayList<>();
				msgLst.add(msgArray);
				throw new Com00UserError("MSG0260E", "Id", msgLst);
			}
		}
	}
	
	/**
	 * Method update data <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	private void updateData(Context ctx) throws SQLException,
			Frw00BlockadeException {
			
		// Get input data
		Cbo5906InputData inputData = ((Cbo5906Context) ctx).getInputData();
		
		// Get Base PR data
		PRData prData = inputData.getPrData();

		// Get source data
		CboTBond_ContractData currentData = ((Cbo5906Context) ctx).getCurrentData();
		
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

		updateData.setUpdUserId(prData.getUserId());
		updateData.setUpdDateTime(CommonFunction.getTimeStamp());

		// update from table
		dataUpdater.updateFromTable(updateData);
	}
	
	/**
	 * Process data after delete record <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void setDataAfterUpdate(Context ctx) {
	
		// Get context data
		Cbo5906Context context = (Cbo5906Context) ctx;
		context.setCurrentData(updateData);
	}
}
