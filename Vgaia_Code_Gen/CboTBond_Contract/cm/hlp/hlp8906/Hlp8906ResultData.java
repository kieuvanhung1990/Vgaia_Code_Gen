/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.hlp.hlp8906;

import java.util.List;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;

/**
 * Hlp8906ResultData class's Description <br>
 * <P>
 * Response data class of CboTBond_Contract
 * <p>
 * Set and Get value for response data class from Server
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class Hlp8906ResultData extends Frw00ResultData {
	
	////////// Class Variables //////////
	
	/** Id */
	private String id;
	
	/** Del Cd */
	private String delCd;
	
	/** Contract No */
	private String contractNo;
	
	/** Contract Type */
	private String contractType;
	
	/** Bond Cd */
	private String bondCd;
	
	/** Sub Acco Cd */
	private String subAccoCd;
	
	/** Qty */
	private String qty;
	
	/** Amount */
	private String amount;
	
	/** Tax Amt */
	private String taxAmt;
	
	/** Interest Amt */
	private String interestAmt;
	
	/** Payment Method */
	private String paymentMethod;
	
	/** Int Payment Method */
	private String intPaymentMethod;
	
	/** Contract Date */
	private String contractDate;
	
	/** Payment Cash Date */
	private String paymentCashDate;
	
	/** Payment Sec Date */
	private String paymentSecDate;
	
	/** Transaction Cd */
	private String transactionCd;
	
	/** Contract Sts */
	private String contractSts;
	
	/** Status */
	private String status;
	
	/** Remarks */
	private String remarks;
	
	/** Reg Date Time */
	private String regDateTime;
	
	/** Reg User Id */
	private String regUserId;
	
	/** Upd Date Time */
	private String updDateTime;
	
	/** Upd User Id */
	private String updUserId;
	
	/** data List */
	private List dataList;
	
	////////// Class Constructor //////////
	
	/**
	 * Constructor <br>
	 * <P>
	 * Call Constructor base template.
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public Hlp8906ResultData() {		
		super();
	}
	
	/**
	 * Constructor <br>
	 * <P>
	 * Call Constructor base template.
	 * 
	 * @param Hlp8906InputData data
	 * @exception Nothing
	 */
	public Hlp8906ResultData(Hlp8906InputData inputData) {		
		super();
	}
	
	////////// Class Methods //////////
	
	/**
	 * Get Id<BR>
	 * 
	 * @param
	 * @return Id String
	 * @exception
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Get Del Cd<BR>
	 * 
	 * @param
	 * @return Del Cd String
	 * @exception
	 */
	public String getDelCd() {
		return delCd;
	}
	
	/**
	 * Get Contract No<BR>
	 * 
	 * @param
	 * @return Contract No String
	 * @exception
	 */
	public String getContractNo() {
		return contractNo;
	}
	
	/**
	 * Get Contract Type<BR>
	 * 
	 * @param
	 * @return Contract Type String
	 * @exception
	 */
	public String getContractType() {
		return contractType;
	}
	
	/**
	 * Get Bond Cd<BR>
	 * 
	 * @param
	 * @return Bond Cd String
	 * @exception
	 */
	public String getBondCd() {
		return bondCd;
	}
	
	/**
	 * Get Sub Acco Cd<BR>
	 * 
	 * @param
	 * @return Sub Acco Cd String
	 * @exception
	 */
	public String getSubAccoCd() {
		return subAccoCd;
	}
	
	/**
	 * Get Qty<BR>
	 * 
	 * @param
	 * @return Qty String
	 * @exception
	 */
	public String getQty() {
		return qty;
	}
	
	/**
	 * Get Amount<BR>
	 * 
	 * @param
	 * @return Amount String
	 * @exception
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * Get Tax Amt<BR>
	 * 
	 * @param
	 * @return Tax Amt String
	 * @exception
	 */
	public String getTaxAmt() {
		return taxAmt;
	}
	
	/**
	 * Get Interest Amt<BR>
	 * 
	 * @param
	 * @return Interest Amt String
	 * @exception
	 */
	public String getInterestAmt() {
		return interestAmt;
	}
	
	/**
	 * Get Payment Method<BR>
	 * 
	 * @param
	 * @return Payment Method String
	 * @exception
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * Get Int Payment Method<BR>
	 * 
	 * @param
	 * @return Int Payment Method String
	 * @exception
	 */
	public String getIntPaymentMethod() {
		return intPaymentMethod;
	}
	
	/**
	 * Get Contract Date<BR>
	 * 
	 * @param
	 * @return Contract Date String
	 * @exception
	 */
	public String getContractDate() {
		return contractDate;
	}
	
	/**
	 * Get Payment Cash Date<BR>
	 * 
	 * @param
	 * @return Payment Cash Date String
	 * @exception
	 */
	public String getPaymentCashDate() {
		return paymentCashDate;
	}
	
	/**
	 * Get Payment Sec Date<BR>
	 * 
	 * @param
	 * @return Payment Sec Date String
	 * @exception
	 */
	public String getPaymentSecDate() {
		return paymentSecDate;
	}
	
	/**
	 * Get Transaction Cd<BR>
	 * 
	 * @param
	 * @return Transaction Cd String
	 * @exception
	 */
	public String getTransactionCd() {
		return transactionCd;
	}
	
	/**
	 * Get Contract Sts<BR>
	 * 
	 * @param
	 * @return Contract Sts String
	 * @exception
	 */
	public String getContractSts() {
		return contractSts;
	}
	
	/**
	 * Get Status<BR>
	 * 
	 * @param
	 * @return Status String
	 * @exception
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Get Remarks<BR>
	 * 
	 * @param
	 * @return Remarks String
	 * @exception
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * Get Reg Date Time<BR>
	 * 
	 * @param
	 * @return Reg Date Time String
	 * @exception
	 */
	public String getRegDateTime() {
		return regDateTime;
	}
	
	/**
	 * Get Reg User Id<BR>
	 * 
	 * @param
	 * @return Reg User Id String
	 * @exception
	 */
	public String getRegUserId() {
		return regUserId;
	}
	
	/**
	 * Get Upd Date Time<BR>
	 * 
	 * @param
	 * @return Upd Date Time String
	 * @exception
	 */
	public String getUpdDateTime() {
		return updDateTime;
	}
	
	/**
	 * Get Upd User Id<BR>
	 * 
	 * @param
	 * @return Upd User Id String
	 * @exception
	 */
	public String getUpdUserId() {
		return updUserId;
	}
	
	/**
	 * Get dataList<br>
	 * 
	 * @param Nothing
	 * @return List dataList
	 * @exception Nothing
	 */
	public List getDataList() {
		return dataList;
	}
	
	/**
	 * Set Id<BR>
	 * 
	 * @param id String
	 * @return
	 * @exception
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Set Del Cd<BR>
	 * 
	 * @param delCd String
	 * @return
	 * @exception
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Set Contract No<BR>
	 * 
	 * @param contractNo String
	 * @return
	 * @exception
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Set Contract Type<BR>
	 * 
	 * @param contractType String
	 * @return
	 * @exception
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	 * Set Bond Cd<BR>
	 * 
	 * @param bondCd String
	 * @return
	 * @exception
	 */
	public void setBondCd(String bondCd) {
		this.bondCd = bondCd;
	}
	
	/**
	 * Set Sub Acco Cd<BR>
	 * 
	 * @param subAccoCd String
	 * @return
	 * @exception
	 */
	public void setSubAccoCd(String subAccoCd) {
		this.subAccoCd = subAccoCd;
	}
	
	/**
	 * Set Qty<BR>
	 * 
	 * @param qty String
	 * @return
	 * @exception
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Set Amount<BR>
	 * 
	 * @param amount String
	 * @return
	 * @exception
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Set Tax Amt<BR>
	 * 
	 * @param taxAmt String
	 * @return
	 * @exception
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Set Interest Amt<BR>
	 * 
	 * @param interestAmt String
	 * @return
	 * @exception
	 */
	public void setInterestAmt(String interestAmt) {
		this.interestAmt = interestAmt;
	}
	
	/**
	 * Set Payment Method<BR>
	 * 
	 * @param paymentMethod String
	 * @return
	 * @exception
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * Set Int Payment Method<BR>
	 * 
	 * @param intPaymentMethod String
	 * @return
	 * @exception
	 */
	public void setIntPaymentMethod(String intPaymentMethod) {
		this.intPaymentMethod = intPaymentMethod;
	}
	
	/**
	 * Set Contract Date<BR>
	 * 
	 * @param contractDate String
	 * @return
	 * @exception
	 */
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	
	/**
	 * Set Payment Cash Date<BR>
	 * 
	 * @param paymentCashDate String
	 * @return
	 * @exception
	 */
	public void setPaymentCashDate(String paymentCashDate) {
		this.paymentCashDate = paymentCashDate;
	}
	
	/**
	 * Set Payment Sec Date<BR>
	 * 
	 * @param paymentSecDate String
	 * @return
	 * @exception
	 */
	public void setPaymentSecDate(String paymentSecDate) {
		this.paymentSecDate = paymentSecDate;
	}
	
	/**
	 * Set Transaction Cd<BR>
	 * 
	 * @param transactionCd String
	 * @return
	 * @exception
	 */
	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}
	
	/**
	 * Set Contract Sts<BR>
	 * 
	 * @param contractSts String
	 * @return
	 * @exception
	 */
	public void setContractSts(String contractSts) {
		this.contractSts = contractSts;
	}
	
	/**
	 * Set Status<BR>
	 * 
	 * @param status String
	 * @return
	 * @exception
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Set Remarks<BR>
	 * 
	 * @param remarks String
	 * @return
	 * @exception
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * Set Reg Date Time<BR>
	 * 
	 * @param regDateTime String
	 * @return
	 * @exception
	 */
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	/**
	 * Set Reg User Id<BR>
	 * 
	 * @param regUserId String
	 * @return
	 * @exception
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	
	/**
	 * Set Upd Date Time<BR>
	 * 
	 * @param updDateTime String
	 * @return
	 * @exception
	 */
	public void setUpdDateTime(String updDateTime) {
		this.updDateTime = updDateTime;
	}
	
	/**
	 * Set Upd User Id<BR>
	 * 
	 * @param updUserId String
	 * @return
	 * @exception
	 */
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}
	
	
	/**
	 * Set dataList <br>
	 * 
	 * @param dataList List
	 * @return
	 * @exception
	 */
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
}

