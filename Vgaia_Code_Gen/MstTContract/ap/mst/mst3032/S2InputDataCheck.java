/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;

/**
 * S2InputDataCheck class's Description <br>
 * 
 * @author HungKieu 2016/04/26 Create New
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

		// Validate item
		validateItem(ctx);

		// validate relation of item
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
	
		// Get input data from context
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();
		
		
		// Check Id	
		ItemValidator.checkValue(ConstantValues.TYPE_MANDATORY, inputData.getId(), 0, "id");
		ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getId(), 0, "id");
		ItemValidator.checkDecimalValue(inputData.getId(), 18, 4, "id");
		
		// Check Contract No	
		ItemValidator.checkValue(ConstantValues.TYPE_MANDATORY, inputData.getContractNo(), 12, "contractNo");
		ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractNo(), 12, "contractNo");
		
		// Check Contract Type Id	
		ItemValidator.checkValue(ConstantValues.TYPE_MANDATORY, inputData.getContractTypeId(), 0, "contractTypeId");
		ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractTypeId(), 0, "contractTypeId");
		ItemValidator.checkDecimalValue(inputData.getContractTypeId(), 18, 4, "contractTypeId");
		
		// Check Contract Name	
		if (ItemValidator.isNotEmpty(inputData.getContractName())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractName(), 2000, "contractName");
		}
		
		// Check Company	
		if (ItemValidator.isNotEmpty(inputData.getCompany())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getCompany(), 800, "company");
		}
		
		// Check Tel	
		if (ItemValidator.isNotEmpty(inputData.getTel())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getTel(), 80, "tel");
		}
		
		// Check Address	
		if (ItemValidator.isNotEmpty(inputData.getAddress())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getAddress(), 2000, "address");
		}
		
		// Check Represent Name	
		if (ItemValidator.isNotEmpty(inputData.getRepresentName())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getRepresentName(), 800, "representName");
		}
		
		// Check Represent Id	
		if (ItemValidator.isNotEmpty(inputData.getRepresentId())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getRepresentId(), 48, "representId");
		}
		
		// Check Contract Date	
		if (ItemValidator.isNotEmpty(inputData.getContractDate())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getContractDate(), 0, "contractDate");
			ItemValidator.checkDecimalValue(inputData.getContractDate(), 18, 4, "contractDate");
		}
		
		// Check Finish Date	
		if (ItemValidator.isNotEmpty(inputData.getFinishDate())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getFinishDate(), 0, "finishDate");
			ItemValidator.checkDecimalValue(inputData.getFinishDate(), 18, 4, "finishDate");
		}
		
		// Check Transaction Cd	
		if (ItemValidator.isNotEmpty(inputData.getTransactionCd())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getTransactionCd(), 3, "transactionCd");
		}
		
		// Check Remarks	
		if (ItemValidator.isNotEmpty(inputData.getRemarks())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getRemarks(), 800, "remarks");
		}
		
		// Check Status	
		if (ItemValidator.isNotEmpty(inputData.getStatus())) {
			ItemValidator.checkValue(ConstantValues.TYPE_MAX, inputData.getStatus(), 0, "status");
			ItemValidator.checkDecimalValue(inputData.getStatus(), 18, 4, "status");
		}
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
