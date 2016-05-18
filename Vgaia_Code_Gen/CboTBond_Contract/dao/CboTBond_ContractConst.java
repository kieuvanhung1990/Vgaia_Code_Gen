/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.dao;

import java.sql.Types;
/**
 * CboTBond_ContractConst Class's Description. <br>
 *
 * @author HungKieu 2016/04/19 Create New
 */
public interface CboTBond_ContractConst {
	
	////////// Class Variables //////////
	
	/** Table const name */
	public static final String TABLE_NAME = "CBOTBOND_CONTRACT";
	
	/** Column Id const name */
	public static final String ID = "ID";
	
	/** Column Del Cd const name */
	public static final String DEL_CD = "DEL_CD";
	
	/** Column Contract No const name */
	public static final String CONTRACT_NO = "CONTRACT_NO";
	
	/** Column Contract Type const name */
	public static final String CONTRACT_TYPE = "CONTRACT_TYPE";
	
	/** Column Bond Cd const name */
	public static final String BOND_CD = "BOND_CD";
	
	/** Column Sub Acco Cd const name */
	public static final String SUB_ACCO_CD = "SUB_ACCO_CD";
	
	/** Column Qty const name */
	public static final String QTY = "QTY";
	
	/** Column Amount const name */
	public static final String AMOUNT = "AMOUNT";
	
	/** Column Tax Amt const name */
	public static final String TAX_AMT = "TAX_AMT";
	
	/** Column Interest Amt const name */
	public static final String INTEREST_AMT = "INTEREST_AMT";
	
	/** Column Payment Method const name */
	public static final String PAYMENT_METHOD = "PAYMENT_METHOD";
	
	/** Column Int Payment Method const name */
	public static final String INT_PAYMENT_METHOD = "INT_PAYMENT_METHOD";
	
	/** Column Contract Date const name */
	public static final String CONTRACT_DATE = "CONTRACT_DATE";
	
	/** Column Payment Cash Date const name */
	public static final String PAYMENT_CASH_DATE = "PAYMENT_CASH_DATE";
	
	/** Column Payment Sec Date const name */
	public static final String PAYMENT_SEC_DATE = "PAYMENT_SEC_DATE";
	
	/** Column Transaction Cd const name */
	public static final String TRANSACTION_CD = "TRANSACTION_CD";
	
	/** Column Contract Sts const name */
	public static final String CONTRACT_STS = "CONTRACT_STS";
	
	/** Column Status const name */
	public static final String STATUS = "STATUS";
	
	/** Column Remarks const name */
	public static final String REMARKS = "REMARKS";
	
	/** Column Reg Date Time const name */
	public static final String REG_DATE_TIME = "REG_DATE_TIME";
	
	/** Column Reg User Id const name */
	public static final String REG_USER_ID = "REG_USER_ID";
	
	/** Column Upd Date Time const name */
	public static final String UPD_DATE_TIME = "UPD_DATE_TIME";
	
	/** Column Upd User Id const name */
	public static final String UPD_USER_ID = "UPD_USER_ID";
	
	/** SQL TYPE OF COLUMN ID */
	public static final int SQLTYPE_ID = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN DEL_CD */
	public static final int SQLTYPE_DEL_CD = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN CONTRACT_NO */
	public static final int SQLTYPE_CONTRACT_NO = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN CONTRACT_TYPE */
	public static final int SQLTYPE_CONTRACT_TYPE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN BOND_CD */
	public static final int SQLTYPE_BOND_CD = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN SUB_ACCO_CD */
	public static final int SQLTYPE_SUB_ACCO_CD = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN QTY */
	public static final int SQLTYPE_QTY = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN AMOUNT */
	public static final int SQLTYPE_AMOUNT = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN TAX_AMT */
	public static final int SQLTYPE_TAX_AMT = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN INTEREST_AMT */
	public static final int SQLTYPE_INTEREST_AMT = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN PAYMENT_METHOD */
	public static final int SQLTYPE_PAYMENT_METHOD = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN INT_PAYMENT_METHOD */
	public static final int SQLTYPE_INT_PAYMENT_METHOD = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN CONTRACT_DATE */
	public static final int SQLTYPE_CONTRACT_DATE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN PAYMENT_CASH_DATE */
	public static final int SQLTYPE_PAYMENT_CASH_DATE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN PAYMENT_SEC_DATE */
	public static final int SQLTYPE_PAYMENT_SEC_DATE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN TRANSACTION_CD */
	public static final int SQLTYPE_TRANSACTION_CD = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN CONTRACT_STS */
	public static final int SQLTYPE_CONTRACT_STS = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN STATUS */
	public static final int SQLTYPE_STATUS = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN REMARKS */
	public static final int SQLTYPE_REMARKS = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN REG_DATE_TIME */
	public static final int SQLTYPE_REG_DATE_TIME = Types.TIMESTAMP;
	
	/** SQL TYPE OF COLUMN REG_USER_ID */
	public static final int SQLTYPE_REG_USER_ID = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN UPD_DATE_TIME */
	public static final int SQLTYPE_UPD_DATE_TIME = Types.TIMESTAMP;
	
	/** SQL TYPE OF COLUMN UPD_USER_ID */
	public static final int SQLTYPE_UPD_USER_ID = Types.VARCHAR;
	
	/** All columns name in the table */	
	public static final String[] COLUMN_NAMES = new String[] {
		ID,
		DEL_CD,
		CONTRACT_NO,
		CONTRACT_TYPE,
		BOND_CD,
		SUB_ACCO_CD,
		QTY,
		AMOUNT,
		TAX_AMT,
		INTEREST_AMT,
		PAYMENT_METHOD,
		INT_PAYMENT_METHOD,
		CONTRACT_DATE,
		PAYMENT_CASH_DATE,
		PAYMENT_SEC_DATE,
		TRANSACTION_CD,
		CONTRACT_STS,
		STATUS,
		REMARKS,
		REG_DATE_TIME,
		REG_USER_ID,
		UPD_DATE_TIME,
		UPD_USER_ID,
	};
	
	/** All PrimaryKeys name in the table */
	public static final String[] PK_NAMES = new String[] {
		ID,
	};
	
	public static final int[] SQLTYPES = new int[] {
		SQLTYPE_ID,
		SQLTYPE_DEL_CD,
		SQLTYPE_CONTRACT_NO,
		SQLTYPE_CONTRACT_TYPE,
		SQLTYPE_BOND_CD,
		SQLTYPE_SUB_ACCO_CD,
		SQLTYPE_QTY,
		SQLTYPE_AMOUNT,
		SQLTYPE_TAX_AMT,
		SQLTYPE_INTEREST_AMT,
		SQLTYPE_PAYMENT_METHOD,
		SQLTYPE_INT_PAYMENT_METHOD,
		SQLTYPE_CONTRACT_DATE,
		SQLTYPE_PAYMENT_CASH_DATE,
		SQLTYPE_PAYMENT_SEC_DATE,
		SQLTYPE_TRANSACTION_CD,
		SQLTYPE_CONTRACT_STS,
		SQLTYPE_STATUS,
		SQLTYPE_REMARKS,
		SQLTYPE_REG_DATE_TIME,
		SQLTYPE_REG_USER_ID,
		SQLTYPE_UPD_DATE_TIME,
		SQLTYPE_UPD_USER_ID,
	};
}
