/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;


import java.sql.SQLException;
import java.sql.Timestamp;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S4DataEditor Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class S4DataEditor implements IStage {
	
	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S4DataEditor.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S4DataEditor() {
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
	 * Process Data Editor task <br>
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
		Mst3032InputData inputData = context.getInputData();

		MstTContractData updateData = new MstTContractData();
		
		// Set Id
		updateData.setIdSt(inputData.getId());
		
		// Set Contract No
		updateData.setContractNo(inputData.getContractNo());
		
		// Set Contract Type Id
		updateData.setContractTypeIdSt(inputData.getContractTypeId());
		
		// Set Contract Name
		updateData.setContractName(inputData.getContractName());
		
		// Set Company
		updateData.setCompany(inputData.getCompany());
		
		// Set Tel
		updateData.setTel(inputData.getTel());
		
		// Set Address
		updateData.setAddress(inputData.getAddress());
		
		// Set Represent Name
		updateData.setRepresentName(inputData.getRepresentName());
		
		// Set Represent Id
		updateData.setRepresentId(inputData.getRepresentId());
		
		// Set Contract Date
		updateData.setContractDateSt(inputData.getContractDate());
		
		// Set Finish Date
		updateData.setFinishDateSt(inputData.getFinishDate());
		
		// Set Transaction Cd
		updateData.setTransactionCd(inputData.getTransactionCd());
		
		// Set Remarks
		updateData.setRemarks(inputData.getRemarks());
		
		// Set Status
		updateData.setStatusSt(inputData.getStatus());
		
		// Set update time
		if (ItemValidator.isNotEmpty(inputData.getTimeStamp())) {
			updateData.setUpdDateTime(Timestamp.valueOf(inputData
					.getTimeStamp()));
		} else {
			updateData.setUpdDateTime(null);
		}

		// Set Current data
		context.setCurrentData(updateData);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
}

