/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */

package jp.co.okasan.ap.hlp.hlp6032;

import java.sql.SQLException;
import java.util.List;

import jp.co.nec.frw0100.ap.dao.SqlOrder;
import jp.co.nec.frw0100.ap.dao.SqlParam;
import jp.co.nec.frw0100.ap.dao.SqlWhere;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ItemValidator;
import jp.co.okasan.dao.BaseMstTContractFinder;
import jp.co.okasan.dao.MstTContractConst;
import jp.co.okasan.dao.MstTContractTarget;
import jp.co.okasan.cm.hlp.hlp6032.Hlp6032InputData;

/**
 * MstTContractFinder Class's Description <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractFinder extends BaseMstTContractFinder {
	
	////////// Class methods //////////
	
	/**
	 * Search data <br>
	 * @param Nothing
	 * @return list data response
	 * @exception SQLException have failure when search data
	 */
	protected List getDataForSearch() throws SQLException {
	
		// Create SQL Where
        SqlWhere where = new SqlWhere();
		
		// DEL_CD 
        SqlParam paramDelCD = new SqlParam();
        paramDelCD.addParameter(ConstantValues.NOT_DEL);              
        where.addCondition(MstTContractConst.DEL_CD + " = ?", paramDelCD);
		
		// Create target data
        MstTContractTarget registrationTarget = new MstTContractTarget(true);
				
		// Crete order data
        SqlOrder order = new SqlOrder();
		order.addAscending(ID);
				
		return super.select(where, registrationTarget, order);
	}
	
	/**
	 * Search data with input search<br>
	 * @param Nothing
	 * @return list data response
	 * @exception SQLException have failure when search data
	 */
	protected List getDataForSearch(Hlp6032InputData inputData) throws SQLException {
	
		// Create SQL Where
        SqlWhere where = new SqlWhere();
		
		// add some condition to search here.
		
		// DEL_CD 
        SqlParam paramDelCD = new SqlParam();
        paramDelCD.addParameter(ConstantValues.NOT_DEL);              
        where.addCondition(MstTContractConst.DEL_CD + " = ?", paramDelCD);
		
		// Create target data
        MstTContractTarget registrationTarget = new MstTContractTarget(true);
				
		// Crete order data
        SqlOrder order = new SqlOrder();
		order.addAscending(ID);
				
		return super.select(where, registrationTarget, order);
	}
}
