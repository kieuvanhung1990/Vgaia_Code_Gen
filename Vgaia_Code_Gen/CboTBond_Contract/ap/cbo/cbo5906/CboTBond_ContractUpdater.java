/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5906;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.ResultSet;

import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0100.ap.dao.SqlWhere;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.BaseCboTBond_ContractUpdater;
import jp.co.okasan.dao.CboTBond_ContractConst;
import jp.co.okasan.dao.CboTBond_ContractData;
import jp.co.okasan.dao.CboTBond_ContractTarget;

/**
 * CboTBond_ContractUpdater Class's Description <br>
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class CboTBond_ContractUpdater extends BaseCboTBond_ContractUpdater {
	
	////////// Class methods //////////
	
	/**
	 * Delete CboTBond_ContractData from table CboTBond_Contract <br>
	 * 
	 * @param CboTBond_ContractData delete content condition class
	 * @return int deleted records
	 * @exception SQLException
	 */
    protected int deleteFromTable(CboTBond_ContractData data)
			throws SQLException {
		// create Target object
		CboTBond_ContractTarget target = new CboTBond_ContractTarget();
		
		// delCd
		target.setDelCd(true);
		
		// UpdatedDateTime
		target.setUpdDateTime(true);
		
		// UpdatedUser
		target.setUpdUserId(true);

		return update(target, data);
	}
	
	/**
	 * Search CboTBond_Contract for update <br>
	 * Select all field of the table
	 * 
	 * @param id String Key to searck
	 * @return CboTBond_ContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected CboTBond_ContractData findDataForUpdate(
		BigDecimal id)
			throws Frw00BlockadeException, SQLException {
		return findDataForUpdate(id, ConstantValues.NOT_DEL);
	}
	
	/**
	 *Search CboTBond_Contract for update with Delcode <br>
	 * 
	 * @param id String Key to find
	 * @param delCode BigDecimal
	 * @return CboTBond_ContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected CboTBond_ContractData findDataForUpdate(
			BigDecimal id, 
			BigDecimal delCode) throws Frw00BlockadeException, SQLException {
			
		// Create SQL Where
		SqlWhere where = new SqlWhere();
		
		// Add key where to condition
		where.addCondition(CboTBond_ContractConst.ID, EQUAL, id);
		
		// add del code to condition
		where.addCondition(CboTBond_ContractConst.DEL_CD, EQUAL, delCode);

		// Exec and return
		return selectForUpdate(where, new CboTBond_ContractTarget(true));
	}
	
	/**
	 * Insert a record data into table CboTBond_Contract<br>
	 * 
	 * @param data CboTBond_ContractData insert content
	 * @return int insert records number
	 * @exception SQLException
	 */
    protected int insertIntoTable(CboTBond_ContractData data)
			throws SQLException {
		return insert(data);
	}
	
	/**
	 * Update a record data into table CboTBond_Contract<br>
	 * 
	 * @param data CboTBond_ContractData update data content
	 * @return int update records number
	 * @exception SQLException
	 */
    protected int updateFromTable(CboTBond_ContractData currentData)
			throws SQLException {
			
		// Create target data
		CboTBond_ContractTarget targetData = new CboTBond_ContractTarget();
		
		// Set Id
		targetData.setId(true);
		
		// Set Contract No
		targetData.setContractNo(true);
		
		// Set Contract Type
		targetData.setContractType(true);
		
		// Set Bond Cd
		targetData.setBondCd(true);
		
		// Set Sub Acco Cd
		targetData.setSubAccoCd(true);
		
		// Set Qty
		targetData.setQty(true);
		
		// Set Amount
		targetData.setAmount(true);
		
		// Set Tax Amt
		targetData.setTaxAmt(true);
		
		// Set Interest Amt
		targetData.setInterestAmt(true);
		
		// Set Payment Method
		targetData.setPaymentMethod(true);
		
		// Set Int Payment Method
		targetData.setIntPaymentMethod(true);
		
		// Set Contract Date
		targetData.setContractDate(true);
		
		// Set Payment Cash Date
		targetData.setPaymentCashDate(true);
		
		// Set Payment Sec Date
		targetData.setPaymentSecDate(true);
		
		// Set Transaction Cd
		targetData.setTransactionCd(true);
		
		// Set Contract Sts
		targetData.setContractSts(true);
		
		// Set Status
		targetData.setStatus(true);
		
		// Set Remarks
		targetData.setRemarks(true);
		
		// Set Upd Date Time
		targetData.setUpdDateTime(true);
		
		// Set Upd User Id
		targetData.setUpdUserId(true);
		
		
		return update(targetData, currentData);
	}
}
