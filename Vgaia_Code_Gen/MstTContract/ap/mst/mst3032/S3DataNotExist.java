﻿/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S3DataNotExist class's Description<br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class S3DataNotExist implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S3DataNotExist.class.getName();
	
	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";

	/** data finder */
	private MstTContractFinder dataFinder;
	
	////////// Class Constructor //////////
	
	/**
	 * Contructor. <BR>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S3DataNotExist() {
	}
	
	////////// Methods define //////////
	
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
	 * Process DataNotExist task <BR>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @return boolean status of dotask
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Get input data from context
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();
		
		// Find data 0
		MstTContractData data0 = dataFinder.findData(
			inputData.getId());
		if (data0 != null) {
			throw new Com00UserError("MSG0012E", "Id");
		}

		// Find data 9
		MstTContractData data9 = dataFinder.findData(
			inputData.getId(), 
			ConstantValues.DEL);
		if (data9 != null) {
			throw new Com00UserError("MSG0190E", "Id");
		}

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}