/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.cbo.cbo5904;

import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.okasan.cm.cmn.PRData;

/**
* 59045904InputData class's Description. <br>
* <p>
*  Input data class of CboTBond_Contract.
* </p>
* Set and Get data of screen component.
*
* @author: HungKieu 2016/04/15 Create New
*/
public class Cbo5904InputData extends Frw00InputData {
	
	////////// Class Variables //////////
	
	/** Action Mode */
	private String actionMode;
	
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
	
	/** Hidden Update DateTime */
	private String timeStamp;
	
	/** Base PR data */
	private PRData prData;
	
	////////// Class Methods //////////
	
	/**
	 * Get actionMode
	 * @param Nothing
	 * @return String actionMode
	 * @exception Nothing
	 */
	public String getActionMode() {
		return actionMode;
	}
	
	/**
	 * Id 
	 * @param Nothing
	 * @return String Id
	 * @exception Nothing
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Del Cd 
	 * @param Nothing
	 * @return String Del Cd
	 * @exception Nothing
	 */
	public String getDelCd() {
		return delCd;
	}
	
	/**
	 * Contract No 
	 * @param Nothing
	 * @return String Contract No
	 * @exception Nothing
	 */
	public String getContractNo() {
		return contractNo;
	}
	
	/**
	 * Contract Type 
	 * @param Nothing
	 * @return String Contract Type
	 * @exception Nothing
	 */
	public String getContractType() {
		return contractType;
	}
	
	/**
	 * Bond Cd 
	 * @param Nothing
	 * @return String Bond Cd
	 * @exception Nothing
	 */
	public String getBondCd() {
		return bondCd;
	}
	
	/**
	 * Sub Acco Cd 
	 * @param Nothing
	 * @return String Sub Acco Cd
	 * @exception Nothing
	 */
	public String getSubAccoCd() {
		return subAccoCd;
	}
	
	/**
	 * Qty 
	 * @param Nothing
	 * @return String Qty
	 * @exception Nothing
	 */
	public String getQty() {
		return qty;
	}
	
	/**
	 * Amount 
	 * @param Nothing
	 * @return String Amount
	 * @exception Nothing
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * Tax Amt 
	 * @param Nothing
	 * @return String Tax Amt
	 * @exception Nothing
	 */
	public String getTaxAmt() {
		return taxAmt;
	}
	
	/**
	 * Interest Amt 
	 * @param Nothing
	 * @return String Interest Amt
	 * @exception Nothing
	 */
	public String getInterestAmt() {
		return interestAmt;
	}
	
	/**
	 * Payment Method 
	 * @param Nothing
	 * @return String Payment Method
	 * @exception Nothing
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * Int Payment Method 
	 * @param Nothing
	 * @return String Int Payment Method
	 * @exception Nothing
	 */
	public String getIntPaymentMethod() {
		return intPaymentMethod;
	}
	
	/**
	 * Contract Date 
	 * @param Nothing
	 * @return String Contract Date
	 * @exception Nothing
	 */
	public String getContractDate() {
		return contractDate;
	}
	
	/**
	 * Payment Cash Date 
	 * @param Nothing
	 * @return String Payment Cash Date
	 * @exception Nothing
	 */
	public String getPaymentCashDate() {
		return paymentCashDate;
	}
	
	/**
	 * Payment Sec Date 
	 * @param Nothing
	 * @return String Payment Sec Date
	 * @exception Nothing
	 */
	public String getPaymentSecDate() {
		return paymentSecDate;
	}
	
	/**
	 * Transaction Cd 
	 * @param Nothing
	 * @return String Transaction Cd
	 * @exception Nothing
	 */
	public String getTransactionCd() {
		return transactionCd;
	}
	
	/**
	 * Contract Sts 
	 * @param Nothing
	 * @return String Contract Sts
	 * @exception Nothing
	 */
	public String getContractSts() {
		return contractSts;
	}
	
	/**
	 * Status 
	 * @param Nothing
	 * @return String Status
	 * @exception Nothing
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Remarks 
	 * @param Nothing
	 * @return String Remarks
	 * @exception Nothing
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * Reg Date Time 
	 * @param Nothing
	 * @return String Reg Date Time
	 * @exception Nothing
	 */
	public String getRegDateTime() {
		return regDateTime;
	}
	
	/**
	 * Reg User Id 
	 * @param Nothing
	 * @return String Reg User Id
	 * @exception Nothing
	 */
	public String getRegUserId() {
		return regUserId;
	}
	
	/**
	 * Upd Date Time 
	 * @param Nothing
	 * @return String Upd Date Time
	 * @exception Nothing
	 */
	public String getUpdDateTime() {
		return updDateTime;
	}
	
	/**
	 * Upd User Id 
	 * @param Nothing
	 * @return String Upd User Id
	 * @exception Nothing
	 */
	public String getUpdUserId() {
		return updUserId;
	}
	
	/**
	 * Set actionMode
	 * @param actionMode String
	 * @exception 
	 */
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
	/**
	 * Id
	 * @param id String Id
	 * @exception Nothing
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Del Cd
	 * @param delCd String Del Cd
	 * @exception Nothing
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Contract No
	 * @param contractNo String Contract No
	 * @exception Nothing
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Contract Type
	 * @param contractType String Contract Type
	 * @exception Nothing
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	 * Bond Cd
	 * @param bondCd String Bond Cd
	 * @exception Nothing
	 */
	public void setBondCd(String bondCd) {
		this.bondCd = bondCd;
	}
	
	/**
	 * Sub Acco Cd
	 * @param subAccoCd String Sub Acco Cd
	 * @exception Nothing
	 */
	public void setSubAccoCd(String subAccoCd) {
		this.subAccoCd = subAccoCd;
	}
	
	/**
	 * Qty
	 * @param qty String Qty
	 * @exception Nothing
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Amount
	 * @param amount String Amount
	 * @exception Nothing
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Tax Amt
	 * @param taxAmt String Tax Amt
	 * @exception Nothing
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Interest Amt
	 * @param interestAmt String Interest Amt
	 * @exception Nothing
	 */
	public void setInterestAmt(String interestAmt) {
		this.interestAmt = interestAmt;
	}
	
	/**
	 * Payment Method
	 * @param paymentMethod String Payment Method
	 * @exception Nothing
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * Int Payment Method
	 * @param intPaymentMethod String Int Payment Method
	 * @exception Nothing
	 */
	public void setIntPaymentMethod(String intPaymentMethod) {
		this.intPaymentMethod = intPaymentMethod;
	}
	
	/**
	 * Contract Date
	 * @param contractDate String Contract Date
	 * @exception Nothing
	 */
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	
	/**
	 * Payment Cash Date
	 * @param paymentCashDate String Payment Cash Date
	 * @exception Nothing
	 */
	public void setPaymentCashDate(String paymentCashDate) {
		this.paymentCashDate = paymentCashDate;
	}
	
	/**
	 * Payment Sec Date
	 * @param paymentSecDate String Payment Sec Date
	 * @exception Nothing
	 */
	public void setPaymentSecDate(String paymentSecDate) {
		this.paymentSecDate = paymentSecDate;
	}
	
	/**
	 * Transaction Cd
	 * @param transactionCd String Transaction Cd
	 * @exception Nothing
	 */
	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}
	
	/**
	 * Contract Sts
	 * @param contractSts String Contract Sts
	 * @exception Nothing
	 */
	public void setContractSts(String contractSts) {
		this.contractSts = contractSts;
	}
	
	/**
	 * Status
	 * @param status String Status
	 * @exception Nothing
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Remarks
	 * @param remarks String Remarks
	 * @exception Nothing
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * Reg Date Time
	 * @param regDateTime String Reg Date Time
	 * @exception Nothing
	 */
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	/**
	 * Reg User Id
	 * @param regUserId String Reg User Id
	 * @exception Nothing
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	
	/**
	 * Upd Date Time
	 * @param updDateTime String Upd Date Time
	 * @exception Nothing
	 */
	public void setUpdDateTime(String updDateTime) {
		this.updDateTime = updDateTime;
	}
	
	/**
	 * Upd User Id
	 * @param updUserId String Upd User Id
	 * @exception Nothing
	 */
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
	}
	
	/**
     * Get timeStamp
     * @param Nothing
     * @return String timeStamp
     * @exception
     */
    public String getTimeStamp() {
        return timeStamp;
    }
    
    /**
     * Set timeStamp 
     * @param String timeStamp
     * @exception Nothing
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
	
	/**
     * Get prData
     * @param Nothing
     * @return String timeStamp
     * @exception
     */
    public PRData getPrData() {
        return prData;
    }
    
    /**
     * Set prData 
     * @param PRData prData
     * @exception Nothing
     */
    public void setPrData(PRData prData) {
        this.prData = prData;
    }
	
	/**
     * Return data input infomation for management purpose. <br>
	 *
     * @param Nothing
     * @return String data input infomation
     * @exception Nothing
     */
	public String toString() {
		StringBuffer inputData = new StringBuffer(super.toString());
		inputData.append(",id=");
		inputData.append(id);
		inputData.append(",delCd=");
		inputData.append(delCd);
		inputData.append(",contractNo=");
		inputData.append(contractNo);
		inputData.append(",contractType=");
		inputData.append(contractType);
		inputData.append(",bondCd=");
		inputData.append(bondCd);
		inputData.append(",subAccoCd=");
		inputData.append(subAccoCd);
		inputData.append(",qty=");
		inputData.append(qty);
		inputData.append(",amount=");
		inputData.append(amount);
		inputData.append(",taxAmt=");
		inputData.append(taxAmt);
		inputData.append(",interestAmt=");
		inputData.append(interestAmt);
		inputData.append(",paymentMethod=");
		inputData.append(paymentMethod);
		inputData.append(",intPaymentMethod=");
		inputData.append(intPaymentMethod);
		inputData.append(",contractDate=");
		inputData.append(contractDate);
		inputData.append(",paymentCashDate=");
		inputData.append(paymentCashDate);
		inputData.append(",paymentSecDate=");
		inputData.append(paymentSecDate);
		inputData.append(",transactionCd=");
		inputData.append(transactionCd);
		inputData.append(",contractSts=");
		inputData.append(contractSts);
		inputData.append(",status=");
		inputData.append(status);
		inputData.append(",remarks=");
		inputData.append(remarks);
		inputData.append(",regDateTime=");
		inputData.append(regDateTime);
		inputData.append(",regUserId=");
		inputData.append(regUserId);
		inputData.append(",updDateTime=");
		inputData.append(updDateTime);
		inputData.append(",updUserId=");
		inputData.append(updUserId);
		
		return inputData.toString();
	}
}

