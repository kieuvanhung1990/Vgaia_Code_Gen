/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.dao;

import java.sql.Types;
/**
 * MstTContractConst Class's Description. <br>
 *
 * @author HungKieu 2016/04/26 Create New
 */
public interface MstTContractConst {
	
	////////// Class Variables //////////
	
	/** Table const name */
	public static final String TABLE_NAME = "MSTTCONTRACT";
	
	/** Column Id const name */
	public static final String ID = "ID";
	
	/** Column Del Cd const name */
	public static final String DEL_CD = "DEL_CD";
	
	/** Column Contract No const name */
	public static final String CONTRACT_NO = "CONTRACT_NO";
	
	/** Column Contract Type Id const name */
	public static final String CONTRACT_TYPE_ID = "CONTRACT_TYPE_ID";
	
	/** Column Contract Name const name */
	public static final String CONTRACT_NAME = "CONTRACT_NAME";
	
	/** Column Company const name */
	public static final String COMPANY = "COMPANY";
	
	/** Column Tel const name */
	public static final String TEL = "TEL";
	
	/** Column Address const name */
	public static final String ADDRESS = "ADDRESS";
	
	/** Column Represent Name const name */
	public static final String REPRESENT_NAME = "REPRESENT_NAME";
	
	/** Column Represent Id const name */
	public static final String REPRESENT_ID = "REPRESENT_ID";
	
	/** Column Contract Date const name */
	public static final String CONTRACT_DATE = "CONTRACT_DATE";
	
	/** Column Finish Date const name */
	public static final String FINISH_DATE = "FINISH_DATE";
	
	/** Column Transaction Cd const name */
	public static final String TRANSACTION_CD = "TRANSACTION_CD";
	
	/** Column Remarks const name */
	public static final String REMARKS = "REMARKS";
	
	/** Column Status const name */
	public static final String STATUS = "STATUS";
	
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
	
	/** SQL TYPE OF COLUMN CONTRACT_TYPE_ID */
	public static final int SQLTYPE_CONTRACT_TYPE_ID = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN CONTRACT_NAME */
	public static final int SQLTYPE_CONTRACT_NAME = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN COMPANY */
	public static final int SQLTYPE_COMPANY = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN TEL */
	public static final int SQLTYPE_TEL = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN ADDRESS */
	public static final int SQLTYPE_ADDRESS = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN REPRESENT_NAME */
	public static final int SQLTYPE_REPRESENT_NAME = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN REPRESENT_ID */
	public static final int SQLTYPE_REPRESENT_ID = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN CONTRACT_DATE */
	public static final int SQLTYPE_CONTRACT_DATE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN FINISH_DATE */
	public static final int SQLTYPE_FINISH_DATE = Types.NUMERIC;
	
	/** SQL TYPE OF COLUMN TRANSACTION_CD */
	public static final int SQLTYPE_TRANSACTION_CD = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN REMARKS */
	public static final int SQLTYPE_REMARKS = Types.VARCHAR;
	
	/** SQL TYPE OF COLUMN STATUS */
	public static final int SQLTYPE_STATUS = Types.NUMERIC;
	
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
		CONTRACT_TYPE_ID,
		CONTRACT_NAME,
		COMPANY,
		TEL,
		ADDRESS,
		REPRESENT_NAME,
		REPRESENT_ID,
		CONTRACT_DATE,
		FINISH_DATE,
		TRANSACTION_CD,
		REMARKS,
		STATUS,
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
		SQLTYPE_CONTRACT_TYPE_ID,
		SQLTYPE_CONTRACT_NAME,
		SQLTYPE_COMPANY,
		SQLTYPE_TEL,
		SQLTYPE_ADDRESS,
		SQLTYPE_REPRESENT_NAME,
		SQLTYPE_REPRESENT_ID,
		SQLTYPE_CONTRACT_DATE,
		SQLTYPE_FINISH_DATE,
		SQLTYPE_TRANSACTION_CD,
		SQLTYPE_REMARKS,
		SQLTYPE_STATUS,
		SQLTYPE_REG_DATE_TIME,
		SQLTYPE_REG_USER_ID,
		SQLTYPE_UPD_DATE_TIME,
		SQLTYPE_UPD_USER_ID,
	};
}
