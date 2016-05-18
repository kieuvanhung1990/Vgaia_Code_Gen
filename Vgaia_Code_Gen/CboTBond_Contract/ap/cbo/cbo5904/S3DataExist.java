/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;

/**
 * S3DataExist class's Description<br>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class S3DataExist implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S3DataExist.class.getName();
	
	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	/** Data fonder */
	private CboTBond_ContractFinder dataFinder;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor <BR>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S3DataExist() {
	}
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	
		// Init data finder
		dataFinder = (CboTBond_ContractFinder) factory
				.getInstance(CboTBond_ContractFinder.class);
	}
	
	/**
	 * Process DataExist task <BR>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean status of dotask
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Get input data from context
		Cbo5904InputData inputData = ((Cbo5904Context) ctx).getInputData();

		// Get data
		CboTBond_ContractData data = dataFinder.findData(
			inputData.getId());

		// Check data to return
		if (data == null) {
			throw new Com00UserError("MSG0010E", "Id");
		}

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}
