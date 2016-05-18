/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 */
package jp.co.okasan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jp.co.nec.frw0100.ap.dao.*;
import jp.co.nec.frw0000.cm.Frw00RuntimeException;

/**
 * BaseCboTBond_Contract class's Description <BR>
 *
 * @author: HungKieu 2016/04/19 Create new
 */
public abstract class BaseCboTBond_ContractFinder
	extends BaseDaoFinder
	implements SqlConst, CboTBond_ContractConst {
	
	////////// Class methods //////////
	
	/**
	 * Select data with where condition. <br>
	 * Return null if have no data.
	 *
	 * @param where Where condition
	 * @return CboTBond_ContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected CboTBond_ContractData select(SqlWhere where)
		throws SQLException {
		// Check block ade 
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Get Target object
		CboTBond_ContractTarget target = new CboTBond_ContractTarget(true);
		
		// Get instance info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// SQL select
		SqlSelect select = new SqlSelect(info, where, target, READONLY);
		
		// Excute to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// return first data if found
		if (list.size() == 0) {
			return null;
		} else {
			return (CboTBond_ContractData)list.get(0);
		}
	}
	
	/**
	 * Select data with where condition and target data. <br>
	 * Return null if have no data.
	 * 
	 * @param where Where condition
	 * @param target data to select
	 * @return CboTBond_ContractData search result
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected CboTBond_ContractData select(SqlWhere where,
		CboTBond_ContractTarget target)
		throws SQLException {
		
		// Check block ade 
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Get instance info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// SQL select
		SqlSelect select = new SqlSelect(info, where, target, READONLY);
		
		// Excute to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// return first data if found?
		if (list.size() == 0) {
			return null;
		} else {
			return (CboTBond_ContractData)list.get(0);
		}
	}
	
	/**
	 * Select list data with where condition and target data. <BR>
	 * @param where: Where condition
	 * @param target object: CboTBond_ContractTarget
	 * @param order: OrderBy condition
	 *
	 * @return List CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List select(SqlWhere where,
		CboTBond_ContractTarget target,
		SqlOrder order)
		throws SQLException {
		// Check block ade
		checkBlockade(CmnT01Answer_push_messageConst.TABLE_NAME);
		
		// Create Source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create Select SQL
		SqlSelect select = new SqlSelect(info, where, target, order, READONLY);
		
		// return list data
		return executeQuery(select.getSql(), select.getSqlParam());
	}
	
	/**
	 * Select list data <br>
	 *
	 * @param where condition
	 * @param target object
	 * @param order OrderBy condition
	 * @param offset
	 * @param num
	 * 
	 * @return List CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List select(SqlWhere where,
		CboTBond_ContractTarget target,
		SqlOrder order, int offset, int num)
		throws SQLException {
		// Check block ade
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Create Source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL selection
		SqlSelect select = new SqlSelect(info, where, target, order, offset, num);
		
		// Excute and return data
		return executeQuery(select.getSql(), select.getSqlParam());
	}
	
	/**
	 * Get Count number of records <br>
	 *
	 * @param where condition
	 * @return record number
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected int getCount(SqlWhere where)
		throws SQLException {
		// Check block ade
		checkBlockade(CmnT01Answer_push_messageConst.TABLE_NAME);
		
		// Create Source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL selection
		SqlSelect select = new SqlSelect(info, where);
		
		// Excute data to list
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// Number element of list?
		return ((Integer)list.get(0)).intValue();
	}
	
	/**
	 * GetData object from resultset <br>
	 *
	 * @param resultset object
	 * @return Object data
	 * @exception SQLException
	 */
	protected Object getData(ResultSet resultset)
		throws SQLException {

		// Get data from ResultSet and return
		return CboTBond_ContractReader.read(resultset);
	}
	
	/**
	 * Search all data column by key <br>
	 * Return null if have no data.
	 * 
	 * @param id: String
	 * @return CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	public CboTBond_ContractData getDataAllColumns(
		String id
	) throws SQLException {
		// Create SQl Where
		SqlWhere where = new SqlWhere();
		
		// Add condition
		where.addCondition(ID, EQUAL,  id);
		
		// Create target
		CboTBond_ContractTarget target = new CboTBond_ContractTarget(true);
		
		// exec and return
		return select(where, target);
	}
	
	/**
	 * Search by the key specified. <br>
	 * Return null if have no data.
	 *
	 * @param id String
	 * @param target object: CboTBond_ContractTarget
	 * @return CboTBond_ContractData
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	public CboTBond_ContractData getDataSelectedColumns(
		String id,
		CboTBond_ContractTarget target
	) throws SQLException {

		// Create SQL Where
		SqlWhere where = new SqlWhere();
		
		// Add condition
		where.addCondition(ID, EQUAL,  id);

		return select(where, target);
	}
}
