/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 * 
 */
package jp.co.okasan.dao;

import jp.co.nec.frw0100.ap.dao.*;

/**
 * CboTBond_ContractTarget Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 * @author: HungKieu 2016/04/19 Create New
 */
public class CboTBond_ContractTarget
	implements Target {
	
	////////// Class Variables //////////
	
	/** Target Id state */
	private boolean targetId = false;
	
	/** Target Del Cd state */
	private boolean targetDelCd = false;
	
	/** Target Contract No state */
	private boolean targetContractNo = false;
	
	/** Target Contract Type state */
	private boolean targetContractType = false;
	
	/** Target Bond Cd state */
	private boolean targetBondCd = false;
	
	/** Target Sub Acco Cd state */
	private boolean targetSubAccoCd = false;
	
	/** Target Qty state */
	private boolean targetQty = false;
	
	/** Target Amount state */
	private boolean targetAmount = false;
	
	/** Target Tax Amt state */
	private boolean targetTaxAmt = false;
	
	/** Target Interest Amt state */
	private boolean targetInterestAmt = false;
	
	/** Target Payment Method state */
	private boolean targetPaymentMethod = false;
	
	/** Target Int Payment Method state */
	private boolean targetIntPaymentMethod = false;
	
	/** Target Contract Date state */
	private boolean targetContractDate = false;
	
	/** Target Payment Cash Date state */
	private boolean targetPaymentCashDate = false;
	
	/** Target Payment Sec Date state */
	private boolean targetPaymentSecDate = false;
	
	/** Target Transaction Cd state */
	private boolean targetTransactionCd = false;
	
	/** Target Contract Sts state */
	private boolean targetContractSts = false;
	
	/** Target Status state */
	private boolean targetStatus = false;
	
	/** Target Remarks state */
	private boolean targetRemarks = false;
	
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
	public CboTBond_ContractTarget() {
		this(false);
	}
	
	/**
	 * Constructor. <br>
	 * @param selection selection state default for all fields
	 * @exception Nothing
	 */
	public CboTBond_ContractTarget(boolean selection) {
		targetId = selection;
		targetDelCd = selection;
		targetContractNo = selection;
		targetContractType = selection;
		targetBondCd = selection;
		targetSubAccoCd = selection;
		targetQty = selection;
		targetAmount = selection;
		targetTaxAmt = selection;
		targetInterestAmt = selection;
		targetPaymentMethod = selection;
		targetIntPaymentMethod = selection;
		targetContractDate = selection;
		targetPaymentCashDate = selection;
		targetPaymentSecDate = selection;
		targetTransactionCd = selection;
		targetContractSts = selection;
		targetStatus = selection;
		targetRemarks = selection;
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
	 * Set Target Contract Type state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractType(boolean selection) {
		targetContractType = selection;
	}
	
	/**
	 * Set Target Bond Cd state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setBondCd(boolean selection) {
		targetBondCd = selection;
	}
	
	/**
	 * Set Target Sub Acco Cd state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setSubAccoCd(boolean selection) {
		targetSubAccoCd = selection;
	}
	
	/**
	 * Set Target Qty state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setQty(boolean selection) {
		targetQty = selection;
	}
	
	/**
	 * Set Target Amount state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setAmount(boolean selection) {
		targetAmount = selection;
	}
	
	/**
	 * Set Target Tax Amt state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setTaxAmt(boolean selection) {
		targetTaxAmt = selection;
	}
	
	/**
	 * Set Target Interest Amt state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setInterestAmt(boolean selection) {
		targetInterestAmt = selection;
	}
	
	/**
	 * Set Target Payment Method state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setPaymentMethod(boolean selection) {
		targetPaymentMethod = selection;
	}
	
	/**
	 * Set Target Int Payment Method state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setIntPaymentMethod(boolean selection) {
		targetIntPaymentMethod = selection;
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
	 * Set Target Payment Cash Date state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setPaymentCashDate(boolean selection) {
		targetPaymentCashDate = selection;
	}
	
	/**
	 * Set Target Payment Sec Date state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setPaymentSecDate(boolean selection) {
		targetPaymentSecDate = selection;
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
	 * Set Target Contract Sts state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setContractSts(boolean selection) {
		targetContractSts = selection;
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
	 * Set Target Remarks state<BR>
	 * @param selection state
	 * @exception Nothing
	 */
	public void setRemarks(boolean selection) {
		targetRemarks = selection;
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
	 * Get Target Contract Type state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractType() {
		return targetContractType;
	}
	
	/**
	 * Get Target Bond Cd state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getBondCd() {
		return targetBondCd;
	}
	
	/**
	 * Get Target Sub Acco Cd state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getSubAccoCd() {
		return targetSubAccoCd;
	}
	
	/**
	 * Get Target Qty state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getQty() {
		return targetQty;
	}
	
	/**
	 * Get Target Amount state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getAmount() {
		return targetAmount;
	}
	
	/**
	 * Get Target Tax Amt state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getTaxAmt() {
		return targetTaxAmt;
	}
	
	/**
	 * Get Target Interest Amt state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getInterestAmt() {
		return targetInterestAmt;
	}
	
	/**
	 * Get Target Payment Method state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getPaymentMethod() {
		return targetPaymentMethod;
	}
	
	/**
	 * Get Target Int Payment Method state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getIntPaymentMethod() {
		return targetIntPaymentMethod;
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
	 * Get Target Payment Cash Date state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getPaymentCashDate() {
		return targetPaymentCashDate;
	}
	
	/**
	 * Get Target Payment Sec Date state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getPaymentSecDate() {
		return targetPaymentSecDate;
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
	 * Get Target Contract Sts state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getContractSts() {
		return targetContractSts;
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
	 * Get Target Remarks state <br>
	 * @param Nothing
	 * @return boolean State of field
	 * @exception
	 */
	public boolean getRemarks() {
		return targetRemarks;
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
			targetContractType,
			targetBondCd,
			targetSubAccoCd,
			targetQty,
			targetAmount,
			targetTaxAmt,
			targetInterestAmt,
			targetPaymentMethod,
			targetIntPaymentMethod,
			targetContractDate,
			targetPaymentCashDate,
			targetPaymentSecDate,
			targetTransactionCd,
			targetContractSts,
			targetStatus,
			targetRemarks,
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
		setContractType(false);
		setBondCd(false);
		setSubAccoCd(false);
		setQty(false);
		setAmount(false);
		setTaxAmt(false);
		setInterestAmt(false);
		setPaymentMethod(false);
		setIntPaymentMethod(false);
		setContractDate(false);
		setPaymentCashDate(false);
		setPaymentSecDate(false);
		setTransactionCd(false);
		setContractSts(false);
		setStatus(false);
		setRemarks(false);
		setRegDateTime(false);
		setRegUserId(false);
		setUpdDateTime(false);
		setUpdUserId(false);
	}
}
