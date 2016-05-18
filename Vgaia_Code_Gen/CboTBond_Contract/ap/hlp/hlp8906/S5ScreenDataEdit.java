/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp8906;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;
import jp.co.okasan.cmn.CommonFunction;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.cm.hlp.hlp8906.Hlp8906InputData;
import jp.co.okasan.cm.hlp.hlp8906.Hlp8906ResultData;

/**
 * S5ScreenDataEdit Class's Description. <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
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
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @return boolean dotask state
	 * @exception SQLException
	 * @exception Frw00BlockadeException when table is blockade
	 */
	public boolean doTask(Context ctx) throws SQLException {
		final Frw00Logger logger = ctx.getLogger();
		logger.writeTrace(CLASS_NAME, METHOD_NAME, "enter");

		// Run edit screen edit
		editScreenData(ctx);

		logger.writeTrace(CLASS_NAME, METHOD_NAME, "exit");
		return true;
	}
	
	/**
	 * Method edit screen data <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception Nothing
	 */
	private void editScreenData(Context ctx) {
		Hlp8906Context context = (Hlp8906Context) ctx;
		Hlp8906InputData inputData = context.getInputData();
		Hlp8906ResultData resultData = context.getResultData();

		// Get data list
		List<?> dataList = context.getDataList();
		List<String[]> list = new ArrayList<>();

		Iterator<?> i = dataList.iterator();

		while (i.hasNext()) {
			CboTBond_ContractData sourceData = (CboTBond_ContractData) i.next();

			String column[] = new String[23];
			
			column[0] = sourceData.getIdSt();
			column[1] = sourceData.getDelCdSt();
			column[2] = sourceData.getContractNo();
			column[3] = sourceData.getContractTypeSt();
			column[4] = sourceData.getBondCd();
			column[5] = sourceData.getSubAccoCdSt();
			column[6] = sourceData.getQtySt();
			column[7] = sourceData.getAmountSt();
			column[8] = sourceData.getTaxAmtSt();
			column[9] = sourceData.getInterestAmtSt();
			column[10] = sourceData.getPaymentMethodSt();
			column[11] = sourceData.getIntPaymentMethodSt();
			column[12] = sourceData.getContractDateSt();
			column[13] = sourceData.getPaymentCashDateSt();
			column[14] = sourceData.getPaymentSecDateSt();
			column[15] = sourceData.getTransactionCd();
			column[16] = sourceData.getContractStsSt();
			column[17] = sourceData.getStatusSt();
			column[18] = sourceData.getRemarks();
			column[19] = sourceData.getRegDateTimeSt();
			column[20] = sourceData.getRegUserId();
			column[21] = sourceData.getUpdDateTimeSt();
			column[22] = sourceData.getUpdUserId();

			list.add(column);
		}
		
		// Set result data
		resultData.setId(inputData.getId());
		resultData.setDelCd(inputData.getDelCd());
		resultData.setContractNo(inputData.getContractNo());
		resultData.setContractType(inputData.getContractType());
		resultData.setBondCd(inputData.getBondCd());
		resultData.setSubAccoCd(inputData.getSubAccoCd());
		resultData.setQty(inputData.getQty());
		resultData.setAmount(inputData.getAmount());
		resultData.setTaxAmt(inputData.getTaxAmt());
		resultData.setInterestAmt(inputData.getInterestAmt());
		resultData.setPaymentMethod(inputData.getPaymentMethod());
		resultData.setIntPaymentMethod(inputData.getIntPaymentMethod());
		resultData.setContractDate(inputData.getContractDate());
		resultData.setPaymentCashDate(inputData.getPaymentCashDate());
		resultData.setPaymentSecDate(inputData.getPaymentSecDate());
		resultData.setTransactionCd(inputData.getTransactionCd());
		resultData.setContractSts(inputData.getContractSts());
		resultData.setStatus(inputData.getStatus());
		resultData.setRemarks(inputData.getRemarks());
		resultData.setRegDateTime(inputData.getRegDateTime());
		resultData.setRegUserId(inputData.getRegUserId());
		resultData.setUpdDateTime(inputData.getUpdDateTime());
		resultData.setUpdUserId(inputData.getUpdUserId());
		
		resultData.setDataList(list);
        
        CommonFunction.setRowCountMsg(resultData, dataList.size());
	}
}

