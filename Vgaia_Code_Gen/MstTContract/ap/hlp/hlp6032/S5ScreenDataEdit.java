/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp6032;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.logging.Frw00Logger;
import jp.co.okasan.cmn.CommonFunction;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.hlp.hlp6032.Hlp6032InputData;
import jp.co.okasan.cm.hlp.hlp6032.Hlp6032ResultData;

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

		// Run edit screen edit
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
		Hlp6032Context context = (Hlp6032Context) ctx;
		Hlp6032InputData inputData = context.getInputData();
		Hlp6032ResultData resultData = context.getResultData();

		// Get data list
		List<?> dataList = context.getDataList();
		List<String[]> list = new ArrayList<>();

		Iterator<?> i = dataList.iterator();

		while (i.hasNext()) {
			MstTContractData sourceData = (MstTContractData) i.next();

			String column[] = new String[19];
			
			column[0] = sourceData.getIdSt();
			column[1] = sourceData.getDelCdSt();
			column[2] = sourceData.getContractNo();
			column[3] = sourceData.getContractTypeIdSt();
			column[4] = sourceData.getContractName();
			column[5] = sourceData.getCompany();
			column[6] = sourceData.getTel();
			column[7] = sourceData.getAddress();
			column[8] = sourceData.getRepresentName();
			column[9] = sourceData.getRepresentId();
			column[10] = sourceData.getContractDateSt();
			column[11] = sourceData.getFinishDateSt();
			column[12] = sourceData.getTransactionCd();
			column[13] = sourceData.getRemarks();
			column[14] = sourceData.getStatusSt();
			column[15] = sourceData.getRegDateTimeSt();
			column[16] = sourceData.getRegUserId();
			column[17] = sourceData.getUpdDateTimeSt();
			column[18] = sourceData.getUpdUserId();

			list.add(column);
		}
		
		// Set result data
		resultData.setId(inputData.getId());
		resultData.setDelCd(inputData.getDelCd());
		resultData.setContractNo(inputData.getContractNo());
		resultData.setContractTypeId(inputData.getContractTypeId());
		resultData.setContractName(inputData.getContractName());
		resultData.setCompany(inputData.getCompany());
		resultData.setTel(inputData.getTel());
		resultData.setAddress(inputData.getAddress());
		resultData.setRepresentName(inputData.getRepresentName());
		resultData.setRepresentId(inputData.getRepresentId());
		resultData.setContractDate(inputData.getContractDate());
		resultData.setFinishDate(inputData.getFinishDate());
		resultData.setTransactionCd(inputData.getTransactionCd());
		resultData.setRemarks(inputData.getRemarks());
		resultData.setStatus(inputData.getStatus());
		resultData.setRegDateTime(inputData.getRegDateTime());
		resultData.setRegUserId(inputData.getRegUserId());
		resultData.setUpdDateTime(inputData.getUpdDateTime());
		resultData.setUpdUserId(inputData.getUpdUserId());
		
		resultData.setDataList(list);
        
        CommonFunction.setRowCountMsg(resultData, dataList.size());
	}
}

