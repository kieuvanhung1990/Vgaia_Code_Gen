/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

/**
 * S5ScreenDataEdit Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class S5ScreenDataEdit implements IStage {

	////////// Class Variables //////////
	
	/** Class name of initial stage */
	private static final String CLASS_NAME = S5ScreenDataEdit.class.getName();

	/** Method name of initial stage */
	private static final String METHOD_NAME = "doTask";
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor Method <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public S5ScreenDataEdit() {
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
	 * Process Screen Data Edit task <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Edit screen data
		editScreenData(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Method edit screen data <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
	 * @exception Nothing
	 */
	private void editScreenData(Context ctx) {
		Mst3032Context context = (Mst3032Context) ctx;
		Mst3032ResultData resultData = context.getResultData();

		// Get Action mode
		final String actionMode = context.getInputData().getActionMode();

		// Mode
		resultData.setActionMode(actionMode);
		
		// Get current data from context
		MstTContractData currentData = context.getCurrentData();

		
		// Set Id
		if(currentData.getId() == null){
			resultData.setId("");
		}else{
			resultData.setId(currentData.getId().toString());
		}
		
		// Set Contract No
		resultData.setContractNo(currentData.getContractNo());
		
		// Set Contract Type Id
		if(currentData.getContractTypeId() == null){
			resultData.setContractTypeId("");
		}else{
			resultData.setContractTypeId(currentData.getContractTypeId().toString());
		}
		
		// Set Contract Name
		resultData.setContractName(currentData.getContractName());
		
		// Set Company
		resultData.setCompany(currentData.getCompany());
		
		// Set Tel
		resultData.setTel(currentData.getTel());
		
		// Set Address
		resultData.setAddress(currentData.getAddress());
		
		// Set Represent Name
		resultData.setRepresentName(currentData.getRepresentName());
		
		// Set Represent Id
		resultData.setRepresentId(currentData.getRepresentId());
		
		// Set Contract Date
		if(currentData.getContractDate() == null){
			resultData.setContractDate("");
		}else{
			resultData.setContractDate(currentData.getContractDate().toString());
		}
		
		// Set Finish Date
		if(currentData.getFinishDate() == null){
			resultData.setFinishDate("");
		}else{
			resultData.setFinishDate(currentData.getFinishDate().toString());
		}
		
		// Set Transaction Cd
		resultData.setTransactionCd(currentData.getTransactionCd());
		
		// Set Remarks
		resultData.setRemarks(currentData.getRemarks());
		
		// Set Status
		if(currentData.getStatus() == null){
			resultData.setStatus("");
		}else{
			resultData.setStatus(currentData.getStatus().toString());
		}
	
		// Registered Date Time
		if (currentData.getRegDateTime() != null) {
			resultData.setRegDateTime(new SimpleDateFormat("MM/dd/yy HH:mm")
					.format(currentData.getRegDateTime()));
		} else {
			resultData.setRegDateTime("");
		}

		// Registered User Id
		resultData.setRegUserId(currentData.getRegUserId());

		// Updated Date Time
		if (currentData.getUpdDateTime() != null) {
			resultData.setUpdDateTime(new SimpleDateFormat("MM/dd/yy HH:mm")
					.format(currentData.getUpdDateTime()));
			resultData.setTimeStamp(currentData.getUpdDateTime().toString());
		} else {
			resultData.setUpdDateTime("");
			resultData.setTimeStamp("");
		}

		// Updated User Id
		resultData.setUpdUserId(currentData.getUpdUserId());
	}
}
