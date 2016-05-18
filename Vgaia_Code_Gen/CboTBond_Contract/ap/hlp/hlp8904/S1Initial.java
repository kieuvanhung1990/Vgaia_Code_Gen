/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp8904;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;
/**
 * S1Initial Class's Descrpition. <br>
 * 
 * @author HungKieu 2016/04/15 Create new
 */
public class S1Initial implements IStage {
	
	////////// Define Variables //////////
	
    /** Class name of initial stage */
    private static final String CLASS_NAME = S1Initial.class.getName();

    /** Method name of initial stage */
    private static final String METHOD_NAME = "doTask";
	
	////////// Define Constructor //////////
	
	/**
     * Constructor. <br>
     * 
     * @param Nothing
     * @exception Nothing
     */
    public S1Initial() {
    }
	
	////////// Define Methods //////////
	
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
        logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
        return true;
    }
}

