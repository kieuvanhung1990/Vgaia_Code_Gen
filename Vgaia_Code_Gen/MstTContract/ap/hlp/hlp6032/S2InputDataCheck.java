/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp6032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

/**
 * S2InputDataCheck Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
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
	 * @param ctx Context the contextual of MstTContract
	 * @return boolean dotask state
	 * @exception SQLException
	 */
    public boolean doTask(Context ctx) throws SQLException {
        final Frw00Logger logger = ctx.getLogger();
        logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

        // Validate context
        validateItem(ctx);

        // Validate relation
        validateRelationalItem(ctx);

        logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
        return true;
    }
	
	/**
	 * Validate the input item from screen by Tab order. <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception Nothing
	 */
    private void validateItem(Context ctx) {
    }
	
	/**
	 * Validation relation between item <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception Nothing
	 */
    private void validateRelationalItem(Context ctx) {
    }
}

