/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.math.BigDecimal;
import java.sql.SQLException;

import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0100.ap.dao.SqlWhere;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.BaseMstTContractFinder;
import jp.co.okasan.dao.MstTContractConst;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.dao.MstTContractTarget;

/**
 * MstTContractFinder Class's Description <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractFinder extends BaseMstTContractFinder {
	
	////////// Class methods //////////
	
	/**
	 * Search by the key specified. <br>
	 * Return null if have no data.
	 * 
	 * @param id String
	 * @return MstTContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected MstTContractData findData(
		String id)
			throws Frw00BlockadeException, SQLException {
		return findData(id, ConstantValues.NOT_DEL);
	}
	
	/**
	 * Search by the key specified. <br>
	 * Return null if have no data.
	 * 
	 * @param id String
	 * @param delCode BigDecimal
	 * @return MstTContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected MstTContractData findData(
		String id, BigDecimal delCode)
			throws Frw00BlockadeException, SQLException {
			
		// Create SQL Where
		SqlWhere where = new SqlWhere();
		
		// Add condition by key into clause
		where.addCondition(MstTContractConst.ID, EQUAL, id);
		
		// Add condition by DEL_CD into clause
		where.addCondition(MstTContractConst.DEL_CD, EQUAL, delCode);

		return super.select(where, new MstTContractTarget(true));
	}
	
	/**
	 * Search all the field with the key specified. <br>
	 * 
	 * @param String
	 * @return MstTContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected MstTContractData getAllDataColumns(
		String id)
			throws Frw00BlockadeException, SQLException {
		return super.getDataAllColumns(id);
	}
}
