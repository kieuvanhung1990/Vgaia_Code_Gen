/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5906;
import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.AnswerOutput;
import jp.co.okasan.cmn.AnswerOutputHelper;
import jp.co.okasan.cmn.LanguageGetter;
import jp.co.okasan.cmn.MessageOutput;
import jp.co.okasan.cmn.ReportFunction;

/**
 * S6DataOutput Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
  */
public class S6DataOutput implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S6DataOutput.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";

	////////// Class Constructor //////////
	
	/**
	 * Constructor Method <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S6DataOutput() {
	}
	
	////////// Class Methods //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
		ReportFunction.create(factory);
        AnswerOutput.create(factory);
        MessageOutput.create(factory);
	}
	
	/**
	 * Process Data Output task <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Get current context
		Cbo5906Context context = (Cbo5906Context) ctx;

        // Set title
		context.setTitle(LanguageGetter.getProperty("CboTBond_Contract"));
		
		// Write log
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "Excuted setTitle");

		AnswerOutputHelper answerOutputHelper = new AnswerOutputHelper();
		context.setRegHelper(answerOutputHelper.initAnswer());

		// Write log
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "Excuted setRegHelper");

		Cbo5906AnswerOutput answerOutput = new Cbo5906AnswerOutput();
		answerOutput.doTask(context);

        // Write log
        logger.writeTrace(CLASS_NAME, METHOD_NAME, "Excuted answerOutput.doTask");
        AnswerOutput.doTask(context, context.getResultData());
		
		// Write log
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "Excuted AnswerOutput.doTask");

        MessageOutput.doTask(context, context.getResultData());

		// Write log
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "Excute answerOutputHelper.doTransaction");
		answerOutputHelper.doTransaction(context.getRegHelper());

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}

