/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904InputData;

/**
 * S2InputKeyCheck class's Description <br>
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class S2InputKeyCheck implements IStage {
	
	////////// Class variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S2InputKeyCheck.class.getName();
	
	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S2InputKeyCheck() {
	}
	
	////////// Class Methods //////////
	
	/**
	 * Create business route. <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	}
	
	/**
	 * Process input key check task <BR>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask stage
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// validate key
		validateKey(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Validate the key <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception
	 */
	private void validateKey(Context ctx) {
		// Get input data
		Cbo5904InputData inputData = ((Cbo5904Context) ctx).getInputData();
		
		// Check Id
		ItemValidator.checkValue(ConstantValues.TYPE_MANDATORY, inputData.getId(), 1, "id");
		// ItemValidator.checkId(inputData.getId(), "id"); 
		
	}
}
