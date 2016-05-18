/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.ResultSet;

import jp.co.nec.frw0000.ap.Frw00BlockadeException;
import jp.co.nec.frw0100.ap.dao.SqlWhere;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.dao.BaseMstTContractUpdater;
import jp.co.okasan.dao.MstTContractConst;
import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.dao.MstTContractTarget;

/**
 * MstTContractUpdater Class's Description <br>
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractUpdater extends BaseMstTContractUpdater {
	
	////////// Class methods //////////
	
	/**
	 * Delete MstTContractData from table MstTContract <br>
	 * 
	 * @param MstTContractData delete content condition class
	 * @return int deleted records
	 * @exception SQLException
	 */
    protected int deleteFromTable(MstTContractData data)
			throws SQLException {
		// create Target object
		MstTContractTarget target = new MstTContractTarget();
		
		// delCd
		target.setDelCd(true);
		
		// UpdatedDateTime
		target.setUpdDateTime(true);
		
		// UpdatedUser
		target.setUpdUserId(true);

		return update(target, data);
	}
	
	/**
	 * Search MstTContract for update <br>
	 * Select all field of the table
	 * 
	 * @param id String Key to searck
	 * @return MstTContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected MstTContractData findDataForUpdate(
		BigDecimal id)
			throws Frw00BlockadeException, SQLException {
		return findDataForUpdate(id, ConstantValues.NOT_DEL);
	}
	
	/**
	 *Search MstTContract for update with Delcode <br>
	 * 
	 * @param id String Key to find
	 * @param delCode BigDecimal
	 * @return MstTContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
    protected MstTContractData findDataForUpdate(
			BigDecimal id, 
			BigDecimal delCode) throws Frw00BlockadeException, SQLException {
			
		// Create SQL Where
		SqlWhere where = new SqlWhere();
		
		// Add key where to condition
		where.addCondition(MstTContractConst.ID, EQUAL, id);
		
		// add del code to condition
		where.addCondition(MstTContractConst.DEL_CD, EQUAL, delCode);

		// Exec and return
		return selectForUpdate(where, new MstTContractTarget(true));
	}
	
	/**
	 * Insert a record data into table MstTContract<br>
	 * 
	 * @param data MstTContractData insert content
	 * @return int insert records number
	 * @exception SQLException
	 */
    protected int insertIntoTable(MstTContractData data)
			throws SQLException {
		return insert(data);
	}
	
	/**
	 * Update a record data into table MstTContract<br>
	 * 
	 * @param data MstTContractData update data content
	 * @return int update records number
	 * @exception SQLException
	 */
    protected int updateFromTable(MstTContractData currentData)
			throws SQLException {
			
		// Create target data
		MstTContractTarget targetData = new MstTContractTarget();
		
		// Set Id
		targetData.setId(true);
		
		// Set Contract No
		targetData.setContractNo(true);
		
		// Set Contract Type Id
		targetData.setContractTypeId(true);
		
		// Set Contract Name
		targetData.setContractName(true);
		
		// Set Company
		targetData.setCompany(true);
		
		// Set Tel
		targetData.setTel(true);
		
		// Set Address
		targetData.setAddress(true);
		
		// Set Represent Name
		targetData.setRepresentName(true);
		
		// Set Represent Id
		targetData.setRepresentId(true);
		
		// Set Contract Date
		targetData.setContractDate(true);
		
		// Set Finish Date
		targetData.setFinishDate(true);
		
		// Set Transaction Cd
		targetData.setTransactionCd(true);
		
		// Set Remarks
		targetData.setRemarks(true);
		
		// Set Status
		targetData.setStatus(true);
		
		// Set Upd Date Time
		targetData.setUpdDateTime(true);
		
		// Set Upd User Id
		targetData.setUpdUserId(true);
		
		
		return update(targetData, currentData);
	}
}
