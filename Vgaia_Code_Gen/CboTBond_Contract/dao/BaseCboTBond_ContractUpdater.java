/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 */
package jp.co.okasan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jp.co.nec.frw0000.cm.Frw00RuntimeException;
import jp.co.nec.frw0100.ap.dao.*;

/**
 * BaseCboTBond_Contract Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 *
 * @author: HungKieu 2016/04/19 Create New
 */
public abstract class BaseCboTBond_ContractUpdater
	extends BaseDaoUpdater
	implements SqlConst, CboTBond_ContractConst {
	
	////////// Class methods //////////
	
	/**
	 * Method selectData with Where condition. <br>
	 *
	 * @param where Where condition
	 * @return CboTBond_ContractData search response
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
		
		// return first data if found?
		if (list.size() == 0) {
			return null;
		} else {
			return (CboTBond_ContractData)list.get(0);
		}
	}
	
	/**
	 * Method select data <br>
	 *
	 * @param where Where condition
	 * @param target data to get
	 * @return CboTBond_ContractData search response
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
	 * Method select data <br>
	 * @param where Where condition
	 * @param target data to select
	 * @param order OrderBy
	 * @return List CboTBond_ContractData search response
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
	 * Method select data <br>
	 *
	 * @param where condition
	 * @param target object
	 * @param order OrderBy condition
	 * @param offset
	 * @param num
	 * @return List CboTBond_ContractData search response
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
	 * Method select for Update<BR>
	 * @param where Where condition
	 * @param target object
	 * @return CboTBond_ContractData object
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected CboTBond_ContractData selectForUpdate(SqlWhere where)
		throws SQLException {

		// Create target object
		CboTBond_ContractTarget target = new CboTBond_ContractTarget(true);
		
		// Select data for UpDate and return
		return selectForUpdate(where, target);
	}
	
	/**
	 * Method select for Update<BR>
	 * @param where Where condition
	 * @param target object
	 * @return CboTBond_ContractData object
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected CboTBond_ContractData selectForUpdate(SqlWhere where,
		CboTBond_ContractTarget target)
		throws SQLException {

		// Check block ade
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Create source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL Selection
		SqlSelect select = new SqlSelect(info, where, target, WITHLOCK);
		
		// Execute SQL to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// Check data to return
		if (list.size() == 0) {
			return null;
		} else {
			return (CboTBond_ContractData)list.get(0);
		}
	}
		
	/**
	 * Method select for Update <br>
	 *
	 * @param where Where condition
	 * @param target object
	 * @param order OrderBy condition
	 * @return List CboTBond_ContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List selectForUpdate(SqlWhere where,
		CboTBond_ContractTarget target,
		SqlOrder order)
		throws SQLException {

		// Check block ade
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Create Source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL Selection
		SqlSelect select = new SqlSelect(info, where, target, order, WITHLOCK);
		
		// Excute SQL and return data
		return executeQuery(select.getSql(), select.getSqlParam());
	}
	
	/**
	 * Method insert data<BR>
	 * @param data
	 * @return 
	 * @exception Frw00BlockadeException 
	 * @exception SQLException
	 */
	protected int insert(CboTBond_ContractData data)
		throws SQLException {

		// Check block ade
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Create source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL to insert
		SqlInsert insert = new SqlInsert(info, data);
		
		// Excute insert and return
		return executeUpdate(insert.getSql(), insert.getSqlParam());
	}
	
	/**
	 * Method Update data <br>
	 *
	 * @param where condition to update
	 * @param target field selected to updated
	 * @param data data content to update
	 * @return int number records updated
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 * @exception Frw00RuntimeException
	 */
	protected int update(SqlWhere where,
		CboTBond_ContractTarget target,
		CboTBond_ContractData data)
		throws SQLException {

		// Check block ade
		checkBlockade(CboTBond_ContractConst.TABLE_NAME);
		
		// Create source info
		Info info = CboTBond_ContractInfo.getInstance();
		
		// Create SQL to update
		SqlUpdate update = new SqlUpdate(info, where, target, data);
		
		// Excute Update data and get result
		int result = executeUpdate(update.getSql(), update.getSqlParam());
		
		// check status result
		if (result == 0) {
			// Create message here
			String message = "";
			
			// throw exception to display
			throw new Frw00RuntimeException(message);
		}
		
		// return data
		return result;
	}
	
	/**
	 * Method Update data <br>
	 *
	 * @param target field selected for update
	 * @param data content data for update
	 * @return int number records updated
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	public int update(
		CboTBond_ContractTarget target,
		CboTBond_ContractData data
	) throws SQLException {

		// Create SQL Where
		SqlWhere where = new SqlWhere();
		where.addCondition("ROWID", EQUAL, data.getRowId());

		return update(where, target, data);
	}
	
	/**
	 * Method getData from resultset<BR>
	 * @param resultset object
	 * @return Object data
	 * @exception SQLException
	 */
	protected Object getData(ResultSet resultset)
		throws SQLException {

		// Get data from result set
		return CboTBond_ContractReader.read(resultset);
	}
}
