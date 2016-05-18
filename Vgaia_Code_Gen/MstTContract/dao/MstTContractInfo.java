/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 * 
 */
package jp.co.okasan.dao;

import jp.co.nec.frw0100.ap.dao.*;

/**
 * MstTContractInfo Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractInfo
	implements TableInfo, MstTContractConst {
	
	////////// Class variables //////////
	
	/** Get source info */
	private static MstTContractInfo instance =
		new MstTContractInfo();
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * @param Nothing
	 * @exception Nothing
	 */
	private MstTContractInfo() {
	}
	
	////////// Class Methods //////////
	
	/**
	 * Get instance <br>
	 *
	 * @param Nothing
	 * @return MstTContractInfo
	 * @exception Nothing
	 */
	public static MstTContractInfo getInstance() {
		return instance;
	}
	
	/**
	 * Get table name<BR>
	 * @param Nothing
	 * @return String table name
	 * @exception Nothing
	 */
	public String getName() {
		return TABLE_NAME;
	}

	/**
	 * Get columns name<BR>
	 * @param Nothing
	 * @return String[] list columns name of table
	 * @exception Nothing
	 */
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}

	/**
	 * Get primary keys name <br>
	 * @param Nothing
	 * @return String list all primary keys of table
	 * @exception Nothing
	 */
	public String[] getPkNames() {
		return PK_NAMES;
	}
}
