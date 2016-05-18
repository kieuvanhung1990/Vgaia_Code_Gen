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
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.cmn.PRData;
import jp.co.okasan.cm.cbo.cbo5906.Cbo5906InputData;

/**
 * S4DataDelete class's Description <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class S4DataDelete implements IStage {

	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataDelete.class.getName();
	
	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	/** Data updater */
	private CboTBond_ContractUpdater dataUpdater;

	/** Delete data */
	private CboTBond_ContractData deleteData;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataDelete() {
	}
	
	////////// Methods define //////////
	
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
	 * Process DataDelete task <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException,Frw00BlockadeException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");
        deleteData = new CboTBond_ContractData();

		// Get delete data
		getDeleteData(ctx);

		// delete data
		deleteData(ctx);

		// Set data after delete
		setDataAfterDelete(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Get delete data <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	private void getDeleteData(Context ctx) throws SQLException,
			Frw00BlockadeException {
		// Get delete data from context
		CboTBond_ContractData oldData = ((Cbo5906Context) ctx).getCurrentData();
		
		// Get input data
		Cbo5906InputData inputData = ((Cbo5906Context) ctx).getInputData();
		
		deleteData = dataUpdater.findDataForUpdate(
			oldData.getId());

		if (deleteData == null) {
			throw new Com00UserError("MSG0011E", "Id");
		} else {
		
			// Set timestamp
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
			if (deleteData.getUpdDateTime() != null) {
				newUpdateDate = deleteData.getUpdDateTime().toString();
			}
			
			// if old update time <> new update time then raise error
			if (!oldUpdateDate.equals(newUpdateDate)) {
				String[] msgArray = { "%1", deleteData.getUpdUserId() };
				List<String[]> msgLst = new ArrayList<>();
				msgLst.add(msgArray);
				throw new Com00UserError("MSG0260E", "Id%>", msgLst);
			}
		}
	}
	
	/**
	 * Process delete record <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	private void deleteData(Context ctx) throws Frw00BlockadeException,SQLException {
	
		// Set Del code
		deleteData.setDelCd(ConstantValues.DEL);

		Cbo5906InputData inputData = ((Cbo5906Context) ctx).getInputData();

		// Get Base PR data
		PRData prData = inputData.getPrData();

		// Set update User Id
		deleteData.setUpdUserId(prData.getUserId());
		
		// Set update time
		deleteData.setUpdDateTime(CommonFunction.getTimeStamp());
		
		// Delete data
		dataUpdater.deleteFromTable(deleteData);
	}
	
	/**
	 * Process data after delete record <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void setDataAfterDelete(Context ctx) {
	
		// Get context
		Cbo5906Context context = (Cbo5906Context) ctx;
		context.setCurrentData(deleteData);
	}
}

