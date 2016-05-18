/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S4DataFind Class's Description <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class S4DataFind implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataFind.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	/** Data finder */
	private MstTContractFinder dataFinder;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataFind() {
	}
	
	////////// Methods Define //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	
		// Init data finder
		dataFinder = (MstTContractFinder) factory
				.getInstance(MstTContractFinder.class);
	}
	
	/**
	 * Process Data find task <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Get context
		Mst3032Context context = (Mst3032Context) ctx;
		
		// Get input data from context
		Mst3032InputData inputData = context.getInputData();

		// Get data
		MstTContractData data = dataFinder.findData(
			inputData.getId());

		// Check data to return
		if (data == null) {
			throw new Com00UserError("MSG0010E", "Id");
		} else {
			// Set into context
			context.setCurrentData(data);
		}

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}
