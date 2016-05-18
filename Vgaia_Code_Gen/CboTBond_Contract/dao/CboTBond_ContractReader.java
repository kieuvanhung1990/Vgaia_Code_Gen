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
 * CboTBond_ContractReader Class's Description. <br>
 *
 * @author: HungKieu 2016/04/19 Create New
 */
public class CboTBond_ContractReader
	implements SqlConst, CboTBond_ContractConst {
	
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
		
		// Declare CboTBond_Contract data
		CboTBond_ContractData data = new CboTBond_ContractData();
		
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
		
		// Contract Type
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_TYPE)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setContractType(value);
			}
		}
		
		// Bond Cd
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(BOND_CD)) {
				String value = resultset.getString(index++);
				if (value == null) {
					value = "";
				}
				data.setBondCd(value);
			}
		}
		
		// Sub Acco Cd
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(SUB_ACCO_CD)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setSubAccoCd(value);
			}
		}
		
		// Qty
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(QTY)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setQty(value);
			}
		}
		
		// Amount
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(AMOUNT)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setAmount(value);
			}
		}
		
		// Tax Amt
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(TAX_AMT)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setTaxAmt(value);
			}
		}
		
		// Interest Amt
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(INTEREST_AMT)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setInterestAmt(value);
			}
		}
		
		// Payment Method
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(PAYMENT_METHOD)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setPaymentMethod(value);
			}
		}
		
		// Int Payment Method
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(INT_PAYMENT_METHOD)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setIntPaymentMethod(value);
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
		
		// Payment Cash Date
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(PAYMENT_CASH_DATE)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setPaymentCashDate(value);
			}
		}
		
		// Payment Sec Date
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(PAYMENT_SEC_DATE)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setPaymentSecDate(value);
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
		
		// Contract Sts
		if (index <= columnCount) {
			columnName = rsmd.getColumnName(index);
			if (columnName.equals(CONTRACT_STS)) {
				BigDecimal value = resultset.getBigDecimal(index++);
				if (value == null) {
					value = new BigDecimal("0");
				}
				data.setContractSts(value);
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
