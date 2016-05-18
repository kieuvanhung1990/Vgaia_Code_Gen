/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.ap.cmn.APHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cmn.constant.BusinessRoleInfo;
import jp.co.okasan.cm.cmn.PRData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S1Initial Class's Description <br>
 * 
 * 
 * @author HungKieu 2016/04/26 Create New
 */ 
public class S1Initial implements IStage {
	
	////////// Define Variables //////////

	/** Class name of initial stage */
	private static final String CLASS_NAME = S1Initial.class.getName();
	
 	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Define Constructor //////////
	
	/**
	 * Constructor <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S1Initial() {
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
	 * Process initial data. <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception SQLException
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Validate PRData
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();
		APHelper.validatePRData(inputData.getPrData());

		// Check role
		checkBusinessRole(ctx);

		// Trim data
		trimInputData(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Trim all the input data <br>
	 * 
	 * @param ctx Context
	 * @exception Nothing
	 */
	private void trimInputData(Context ctx) {
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();

		
		// Id
		inputData.setId(CommonHelper.trimObject(inputData.getId()));
		
		// Contract No
		inputData.setContractNo(CommonHelper.trimObject(inputData.getContractNo()));
		
		// Contract Type Id
		inputData.setContractTypeId(CommonHelper.trimObject(inputData.getContractTypeId()));
		
		// Contract Name
		inputData.setContractName(CommonHelper.trimObject(inputData.getContractName()));
		
		// Company
		inputData.setCompany(CommonHelper.trimObject(inputData.getCompany()));
		
		// Tel
		inputData.setTel(CommonHelper.trimObject(inputData.getTel()));
		
		// Address
		inputData.setAddress(CommonHelper.trimObject(inputData.getAddress()));
		
		// Represent Name
		inputData.setRepresentName(CommonHelper.trimObject(inputData.getRepresentName()));
		
		// Represent Id
		inputData.setRepresentId(CommonHelper.trimObject(inputData.getRepresentId()));
		
		// Contract Date
		inputData.setContractDate(CommonHelper.trimObject(inputData.getContractDate()));
		
		// Finish Date
		inputData.setFinishDate(CommonHelper.trimObject(inputData.getFinishDate()));
		
		// Transaction Cd
		inputData.setTransactionCd(CommonHelper.trimObject(inputData.getTransactionCd()));
		
		// Remarks
		inputData.setRemarks(CommonHelper.trimObject(inputData.getRemarks()));
		
		// Status
		inputData.setStatus(CommonHelper.trimObject(inputData.getStatus()));
		
		// Reg Date Time
		inputData.setRegDateTime(CommonHelper.trimObject(inputData.getRegDateTime()));
		
		// Reg User Id
		inputData.setRegUserId(CommonHelper.trimObject(inputData.getRegUserId()));
		
		// Upd Date Time
		inputData.setUpdDateTime(CommonHelper.trimObject(inputData.getUpdDateTime()));
		
		// Upd User Id
		inputData.setUpdUserId(CommonHelper.trimObject(inputData.getUpdUserId()));
	}
	
	/**
	 * Check business role.<br>
	 * 
	 * @param ctx
	 *            : Context
	 * @throws SQLException
	 */
	private void checkBusinessRole(Context ctx) throws SQLException {

		// Get input data
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();

		// Get PrData
		PRData prData = inputData.getPrData();

		// Check accept form
		APHelper.checkBusinessRole(prData.getUserId(), BusinessRoleInfo.F3032,
				true);

		// Get action mode
		String mode = inputData.getActionMode();

		// Check business role execute
		if (ConstantValues.MODE_ENTRY.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F3032_INSERT, true);
		} else if (ConstantValues.MODE_UPDATE.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F3032_UPDATE, true);
		} else if (ConstantValues.MODE_DELETE.equals(mode)) {
			APHelper.checkBusinessRole(prData.getUserId(),
					BusinessRoleInfo.F3032_DELETE, true);
		}
	}
}
