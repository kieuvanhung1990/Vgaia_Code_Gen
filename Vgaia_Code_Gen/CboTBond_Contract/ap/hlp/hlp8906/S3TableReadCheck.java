/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp8906;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

/**
 * S3TableReadCheck Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class S3TableReadCheck implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
    private static final String CLASS_NAME = S3TableReadCheck.class.getName();
	
    /** Method name of initial stage */
    private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S3TableReadCheck() {
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
	 * Process TableReadCheck task. <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}

