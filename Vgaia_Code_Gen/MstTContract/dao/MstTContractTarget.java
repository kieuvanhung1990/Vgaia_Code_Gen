/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 * 
 */
package jp.co.okasan.dao;

import jp.co.nec.frw0100.ap.dao.*;

/**
 * MstTContractTarget Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 * @author: HungKieu 2016/04/26 Create New
 */
public class MstTContractTarget
	implements Target {
	
	////////// Class Variables //////////
	
	/** Target Id state */
	private boolean targetId = false;
	
	/** Target Del Cd state */
	private boolean targetDelCd = false;
	
	/** Target Contract No state */
	private boolean targetContractNo = false;
	
	/** Target Contract Type Id state */
	private boolean targetContractTypeId = false;
	
	/** Target Contract Name state */
	private boolean targetContractName = false;
	
	/** Target Company state */
	private boolean targetCompany = false;
	
	/** Target Tel state */
	private boolean targetTel = false;
	
	/** Target Address state */
	private boolean targetAddress = false;
	
	/** Target Represent Name state */
	private boolean targetRepresentName = false;
	
	/** Target Represent Id state */
	private boolean targetRepresentId = false;
	
	/** Target Contract Date state */
	private boolean targetContractDate = false;
	
	/** Target Finish Date state */
	private boolean targetFinishDate = false;
	
	/** Target Transaction Cd state */
	private boolean targetTransactionCd = false;
	
	/** Target Remarks state */
	private boolean targetRemarks = false;
	
	/** Target Status state */
	private boolean targetStatus = false;
	
	/** Target Reg Date Time state */
	private boolean targetRegDateTime = false;
	
	/** Target Reg User Id state */
	private boolean targetRegUserId = false;
	
	/** Target Upd Date Time state */
	private boolean targetUpdDateTime = false;
	
	/** Target Upd User Id state */
	private boolean targetUpdUserId = false;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor. <br>
	 * @param Nothing
	 * @exception Nothing
	 */
	public MstTContractTarget() {
		this(false);
	}
	
	/**
	 * Constructor. <br>
	 * @param selection selection state default for all fields
	 * @exception Nothing
	 */
	public MstTContractTarget(boolean selection) {
		targetId = selection;
		targetDelCd = selection;
		targetContractNo = selection;
		targetContractTypeId = selection;
		targetContractName = selection;
		targetCompany = selection;
		targetTel = selection;
		targetAddress = selection;
		targetRepresentName = selection;
		targetRepresentId = selection;
		targetContractDate = selection;
		targetFinishDate = selection;
		targetTransactionCd = selection;
		targetRemarks = selection;
		targetStatus = selection;
		targetRegDateTime = selection;
		targetRegUserId = selection;
		targetUpdDateTime = selection;
		targetUpdUserId = selection;
	}
	
	////////// Class Methods //////////
		
	/**
	 * Set Target Id state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setId(boolean selection) {
		targetId = selection;
	}
	
	/**
	 * Set Target Del Cd state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setDelCd(boolean selection) {
		targetDelCd = selection;
	}
	
	/**
	 * Set Target Contract No state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractNo(boolean selection) {
		targetContractNo = selection;
	}
	
	/**
	 * Set Target Contract Type Id state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractTypeId(boolean selection) {
		targetContractTypeId = selection;
	}
	
	/**
	 * Set Target Contract Name state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractName(boolean selection) {
		targetContractName = selection;
	}
	
	/**
	 * Set Target Company state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setCompany(boolean selection) {
		targetCompany = selection;
	}
	
	/**
	 * Set Target Tel state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setTel(boolean selection) {
		targetTel = selection;
	}
	
	/**
	 * Set Target Address state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setAddress(boolean selection) {
		targetAddress = selection;
	}
	
	/**
	 * Set Target Represent Name state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRepresentName(boolean selection) {
		targetRepresentName = selection;
	}
	
	/**
	 * Set Target Represent Id state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRepresentId(boolean selection) {
		targetRepresentId = selection;
	}
	
	/**
	 * Set Target Contract Date state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractDate(boolean selection) {
		targetContractDate = selection;
	}
	
	/**
	 * Set Target Finish Date state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setFinishDate(boolean selection) {
		targetFinishDate = selection;
	}
	
	/**
	 * Set Target Transaction Cd state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setTransactionCd(boolean selection) {
		targetTransactionCd = selection;
	}
	
	/**
	 * Set Target Remarks state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRemarks(boolean selection) {
		targetRemarks = selection;
	}
	
	/**
	 * Set Target Status state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setStatus(boolean selection) {
		targetStatus = selection;
	}
	
	/**
	 * Set Target Reg Date Time state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRegDateTime(boolean selection) {
		targetRegDateTime = selection;
	}
	
	/**
	 * Set Target Reg User Id state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRegUserId(boolean selection) {
		targetRegUserId = selection;
	}
	
	/**
	 * Set Target Upd Date Time state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setUpdDateTime(boolean selection) {
		targetUpdDateTime = selection;
	}
	
	/**
	 * Set Target Upd User Id state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setUpdUserId(boolean selection) {
		targetUpdUserId = selection;
	}
	
	/**
	 * Get Target Id state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getId() {
		return targetId;
	}
	
	/**
	 * Get Target Del Cd state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getDelCd() {
		return targetDelCd;
	}
	
	/**
	 * Get Target Contract No state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractNo() {
		return targetContractNo;
	}
	
	/**
	 * Get Target Contract Type Id state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractTypeId() {
		return targetContractTypeId;
	}
	
	/**
	 * Get Target Contract Name state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractName() {
		return targetContractName;
	}
	
	/**
	 * Get Target Company state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getCompany() {
		return targetCompany;
	}
	
	/**
	 * Get Target Tel state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getTel() {
		return targetTel;
	}
	
	/**
	 * Get Target Address state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getAddress() {
		return targetAddress;
	}
	
	/**
	 * Get Target Represent Name state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRepresentName() {
		return targetRepresentName;
	}
	
	/**
	 * Get Target Represent Id state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRepresentId() {
		return targetRepresentId;
	}
	
	/**
	 * Get Target Contract Date state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractDate() {
		return targetContractDate;
	}
	
	/**
	 * Get Target Finish Date state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getFinishDate() {
		return targetFinishDate;
	}
	
	/**
	 * Get Target Transaction Cd state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getTransactionCd() {
		return targetTransactionCd;
	}
	
	/**
	 * Get Target Remarks state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRemarks() {
		return targetRemarks;
	}
	
	/**
	 * Get Target Status state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getStatus() {
		return targetStatus;
	}
	
	/**
	 * Get Target Reg Date Time state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRegDateTime() {
		return targetRegDateTime;
	}
	
	/**
	 * Get Target Reg User Id state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRegUserId() {
		return targetRegUserId;
	}
	
	/**
	 * Get Target Upd Date Time state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getUpdDateTime() {
		return targetUpdDateTime;
	}
	
	/**
	 * Get Target Upd User Id state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getUpdUserId() {
		return targetUpdUserId;
	}
	
	
	/**
	 * Get target columns<BR>
	 * @param Nothing
	 * @return boolean[] get all state of columns to array.
	 * @exception Nothing
	 */
	public boolean[] getTargetColumns() {
		boolean[] targetColumns = new boolean[] {
			targetId,
			targetDelCd,
			targetContractNo,
			targetContractTypeId,
			targetContractName,
			targetCompany,
			targetTel,
			targetAddress,
			targetRepresentName,
			targetRepresentId,
			targetContractDate,
			targetFinishDate,
			targetTransactionCd,
			targetRemarks,
			targetStatus,
			targetRegDateTime,
			targetRegUserId,
			targetUpdDateTime,
			targetUpdUserId,
		};
		
		return targetColumns;
	}
	
	/**
	 * Method reset all state of fields <br>
	 * @param Nothing
	 * @exception Nothing
	 */
	public void reset() {
		setId(false);
		setDelCd(false);
		setContractNo(false);
		setContractTypeId(false);
		setContractName(false);
		setCompany(false);
		setTel(false);
		setAddress(false);
		setRepresentName(false);
		setRepresentId(false);
		setContractDate(false);
		setFinishDate(false);
		setTransactionCd(false);
		setRemarks(false);
		setStatus(false);
		setRegDateTime(false);
		setRegUserId(false);
		setUpdDateTime(false);
		setUpdUserId(false);
	}
}
