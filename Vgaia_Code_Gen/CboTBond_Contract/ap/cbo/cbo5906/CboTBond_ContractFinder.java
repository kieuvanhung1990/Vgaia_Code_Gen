/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5906;

import java.math.BigDecimal;
import java.sql.SQLException;

import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0100.ap.dao.SqlWhere;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.BaseCboTBond_ContractFinder;
import jp.co.okasan.dao.CboTBond_ContractConst;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.dao.CboTBond_ContractTarget;

/**
 * CboTBond_ContractFinder Class's Description <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class CboTBond_ContractFinder extends BaseCboTBond_ContractFinder {
	
	////////// Class methods //////////
	
	/**
	 * Search by the key specified. <br>
	 * Return null if have no data.
	 * 
	 * @param id String
	 * @return CboTBond_ContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected CboTBond_ContractData findData(
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
	 * @return CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected CboTBond_ContractData findData(
		String id, BigDecimal delCode)
			throws Frw00BlockadeException, SQLException {
			
		// Create SQL Where
		SqlWhere where = new SqlWhere();
		
		// Add condition by key into clause
		where.addCondition(CboTBond_ContractConst.ID, EQUAL, id);
		
		// Add condition by DEL_CD into clause
		where.addCondition(CboTBond_ContractConst.DEL_CD, EQUAL, delCode);

		return super.select(where, new CboTBond_ContractTarget(true));
	}
	
	/**
	 * Search all the field with the key specified. <br>
	 * 
	 * @param String
	 * @return CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected CboTBond_ContractData getAllDataColumns(
		String id)
			throws Frw00BlockadeException, SQLException {
		return super.getDataAllColumns(id);
	}
}
