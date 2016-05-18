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
 * BaseMstTContract Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 *
 * @author: HungKieu 2016/04/26 Create New
 */
public abstract class BaseMstTContractUpdater
	extends BaseDaoUpdater
	implements SqlConst, MstTContractConst {
	
	////////// Class methods //////////
	
	/**
	 * Method selectData with Where condition. <br>
	 *
	 * @param where Where condition
	 * @return MstTContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected MstTContractData select(SqlWhere where)
		throws SQLException {
		// Check block ade 
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Get Target object
		MstTContractTarget target = new MstTContractTarget(true);
		
		// Get instance info
		Info info = MstTContractInfo.getInstance();
		
		// SQL select
		SqlSelect select = new SqlSelect(info, where, target, READONLY);
		
		// Excute to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// return first data if found?
		if (list.size() == 0) {
			return null;
		} else {
			return (MstTContractData)list.get(0);
		}
	}
	
	/**
	 * Method select data <br>
	 *
	 * @param where Where condition
	 * @param target data to get
	 * @return MstTContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected MstTContractData select(SqlWhere where,
		MstTContractTarget target)
		throws SQLException {
		
		// Check block ade 
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Get instance info
		Info info = MstTContractInfo.getInstance();
		
		// SQL select
		SqlSelect select = new SqlSelect(info, where, target, READONLY);
		
		// Excute to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// return first data if found?
		if (list.size() == 0) {
			return null;
		} else {
			return (MstTContractData)list.get(0);
		}
	}
	
	/**
	 * Method select data <br>
	 * @param where Where condition
	 * @param target data to select
	 * @param order OrderBy
	 * @return List MstTContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List select(SqlWhere where,
		MstTContractTarget target,
		SqlOrder order)
		throws SQLException {
		// Check block ade
		checkBlockade(CmnT01Answer_push_messageConst.TABLE_NAME);
		
		// Create Source info
		Info info = MstTContractInfo.getInstance();
		
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
	 * @return List MstTContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List select(SqlWhere where,
		MstTContractTarget target,
		SqlOrder order, int offset, int num)
		throws SQLException {
		// Check block ade
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Create Source info
		Info info = MstTContractInfo.getInstance();
		
		// Create SQL selection
		SqlSelect select = new SqlSelect(info, where, target, order, offset, num);
		
		// Excute and return data
		return executeQuery(select.getSql(), select.getSqlParam());
	}
	
	/**
	 * Method select for Update<BR>
	 * @param where Where condition
	 * @param target object
	 * @return MstTContractData object
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected MstTContractData selectForUpdate(SqlWhere where)
		throws SQLException {

		// Create target object
		MstTContractTarget target = new MstTContractTarget(true);
		
		// Select data for UpDate and return
		return selectForUpdate(where, target);
	}
	
	/**
	 * Method select for Update<BR>
	 * @param where Where condition
	 * @param target object
	 * @return MstTContractData object
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected MstTContractData selectForUpdate(SqlWhere where,
		MstTContractTarget target)
		throws SQLException {

		// Check block ade
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Create source info
		Info info = MstTContractInfo.getInstance();
		
		// Create SQL Selection
		SqlSelect select = new SqlSelect(info, where, target, WITHLOCK);
		
		// Execute SQL to list data
		List list = executeQuery(select.getSql(), select.getSqlParam());
		
		// Check data to return
		if (list.size() == 0) {
			return null;
		} else {
			return (MstTContractData)list.get(0);
		}
	}
		
	/**
	 * Method select for Update <br>
	 *
	 * @param where Where condition
	 * @param target object
	 * @param order OrderBy condition
	 * @return List MstTContractData search response
	 * @exception Frw00BlockadeException have blockade table
	 * @exception SQLException have failure when search data
	 */
	protected List selectForUpdate(SqlWhere where,
		MstTContractTarget target,
		SqlOrder order)
		throws SQLException {

		// Check block ade
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Create Source info
		Info info = MstTContractInfo.getInstance();
		
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
	protected int insert(MstTContractData data)
		throws SQLException {

		// Check block ade
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Create source info
		Info info = MstTContractInfo.getInstance();
		
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
		MstTContractTarget target,
		MstTContractData data)
		throws SQLException {

		// Check block ade
		checkBlockade(MstTContractConst.TABLE_NAME);
		
		// Create source info
		Info info = MstTContractInfo.getInstance();
		
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
		MstTContractTarget target,
		MstTContractData data
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
		return MstTContractReader.read(resultset);
	}
}
