/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;
import java.sql.Timestamp;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.CommonFunction;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.cmn.PRData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S4DataEntry class's Description. <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class S4DataEntry implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataEntry.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	/** Declare data updater */
	private MstTContractUpdater dataUpdater;

	/** Declare entry data */
	private MstTContractData entryData;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataEntry() {
	}
	
	////////// Class Methods //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	
		// Init data updater
		dataUpdater = (MstTContractUpdater) factory
				.getInstance(MstTContractUpdater.class);
	}
	
	/**
	 * Process Data Entry task <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException,Frw00BlockadeException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");
        entryData = new MstTContractData();

		// Get entry data
		getEntryData(ctx);

		// Entry data
		entryData(ctx);

		// Set entry data
		setDataAfterEntry(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Get entry data <BR>
	 * 
	 * @param ctx
	 *            Context
     * @exception Nothing
	 */
	private void getEntryData(Context ctx) {
		entryData = ((Mst3032Context) ctx).getCurrentData();
	}
	
	/**
	 * Process insert data <BR>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	private void entryData(Context ctx) throws SQLException,
			Frw00BlockadeException {
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();
		
		// Get Base PR data
		PRData prData = inputData.getPrData();

		// Set DEL code
		entryData.setDelCd(ConstantValues.NOT_DEL);

		// Set User to entry data
		entryData.setRegUserId(prData.getUserId());
		entryData.setUpdUserId(prData.getUserId());

		// get Timestamp
		Timestamp entryDateTime = CommonFunction.getTimeStamp();

		entryData.setRegDateTime(entryDateTime);
		entryData.setUpdDateTime(entryDateTime);
		
		// Insert into DB
		dataUpdater.insertIntoTable(entryData);
	}
	
	/**
	 * Process data after insert record data. <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception Nothing
	 */
	private void setDataAfterEntry(Context ctx) {
		// Get context
		Mst3032Context context = (Mst3032Context) ctx;
		context.setCurrentData(entryData);
	}
}

