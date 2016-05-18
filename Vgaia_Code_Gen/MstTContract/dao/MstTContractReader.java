/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 */
package jp.co.okasan.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jp.co.nec.frw0100.ap.dao.*;

/**
 * MstTContractReader Class's Description. <br>
 *
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractReader
	implements SqlConst, MstTContractConst {
	
	////////// Class Methods //////////
	
	/**
	 * Method read data<BR>
	 * @param resultset data to read
	 * @return Object object data to response
	 * @exception SQLException
	 */
	public static Object read(ResultSet resultset)
		throws SQLException {
		
		// Create result set metadata
		ResultSetMetaData rsmd = resultset.getMetaData();
		// Get Column index
		int index = 1;
		String columnName = null;
		columnName = rsmd.getColumnName(index);
		
		// Check COUNTALIAS
		if (columnName.equals(COUNTALIAS)) {
			return new Integer(resultset.getInt(index));
		}
		
		// Declare MstTContract data
		MstTContractData data = new MstTContractData();
		
		// Get column count
		int columnCount = rsmd.getColumnCount();
		
		// GET ROWID
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(ROWIDALIAS)) {
				data.setRowId(resultset.getString(index++));
			}
		}
		
		// Id
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(ID)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setId(value);
			}
		}
		
		// Del Cd
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(DEL_CD)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setDelCd(value);
			}
		}
		
		// Contract No
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_NO)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setContractNo(value);
			}
		}
		
		// Contract Type Id
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_TYPE_ID)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setContractTypeId(value);
			}
		}
		
		// Contract Name
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_NAME)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setContractName(value);
			}
		}
		
		// Company
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(COMPANY)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setCompany(value);
			}
		}
		
		// Tel
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(TEL)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setTel(value);
			}
		}
		
		// Address
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(ADDRESS)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setAddress(value);
			}
		}
		
		// Represent Name
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(REPRESENT_NAME)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setRepresentName(value);
			}
		}
		
		// Represent Id
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(REPRESENT_ID)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setRepresentId(value);
			}
		}
		
		// Contract Date
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_DATE)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setContractDate(value);
			}
		}
		
		// Finish Date
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(FINISH_DATE)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setFinishDate(value);
			}
		}
		
		// Transaction Cd
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(TRANSACTION_CD)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setTransactionCd(value);
			}
		}
		
		// Remarks
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(REMARKS)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setRemarks(value);
			}
		}
		
		// Status
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(STATUS)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setStatus(value);
			}
		}
		
		// Reg Date Time
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(REG_DATE_TIME)) {
				Timestamp value = resultset.getTimestamp(index++);
				if(value !=null){
					data.setRegDateTime(value);
				}
			}
		}
		
		// Reg User Id
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(REG_USER_ID)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setRegUserId(value);
			}
		}
		
		// Upd Date Time
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(UPD_DATE_TIME)) {
				Timestamp value = resultset.getTimestamp(index++);
				if(value !=null){
					data.setUpdDateTime(value);
				}
			}
		}
		
		// Upd User Id
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(UPD_USER_ID)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setUpdUserId(value);
			}
		}
		
		
		data.resetTarget();
		return data;
	}
}
