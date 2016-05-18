/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.cbo.cbo5904;

import jp.co.nec.frw0000.cm.data.Frw00ResultData;

/**
 * Cbo5904ResultData class's Description <br>
 * <P>
 * Response data class of CboTBond_Contract
 * <p>
 * Set and Get value for response data class from Server
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Cbo5904ResultData extends Frw00ResultData {
	
	////////// Class Variables //////////
	
	/** Action Mode */
	private String actionMode;
	
	/** answerId **/
	private String[] answerIdArray;
	
	/** pushMessageId **/
	private String pushMessageId;
	
	//Id
	private String id;
	
	//Del Cd
	private String delCd;
	
	//Contract No
	private String contractNo;
	
	//Contract Type
	private String contractType;
	
	//Bond Cd
	private String bondCd;
	
	//Sub Acco Cd
	private String subAccoCd;
	
	//Qty
	private String qty;
	
	//Amount
	private String amount;
	
	//Tax Amt
	private String taxAmt;
	
	//Interest Amt
	private String interestAmt;
	
	//Payment Method
	private String paymentMethod;
	
	//Int Payment Method
	private String intPaymentMethod;
	
	//Contract Date
	private String contractDate;
	
	//Payment Cash Date
	private String paymentCashDate;
	
	//Payment Sec Date
	private String paymentSecDate;
	
	//Transaction Cd
	private String transactionCd;
	
	//Contract Sts
	private String contractSts;
	
	//Status
	private String status;
	
	//Remarks
	private String remarks;
	
	//Reg Date Time
	private String regDateTime;
	
	//Reg User Id
	private String regUserId;
	
	//Upd Date Time
	private String updDateTime;
	
	//Upd User Id
	private String updUserId;
	
	/** HiddenUpdateDateTime*/
	private String timeStamp;
	
	////////// Constructor //////////
	
	/**
	 * Cbo5904ResultData Constructor description. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public Cbo5904ResultData() {
		super();
	}
	
	/**
	 * Cbo5904ResultData Constructor description<BR>
	 * 
	 * @param  inputData Cbo5904ResultData input data from client
	 * @exception Nothing
	 */
	public Cbo5904ResultData(Cbo5904ResultData inputData) {
		super();
	}
	
	////////// Methods define //////////
	
	/**
	 * Get actionMode <br>
	 * 
	 * @param Nothing
	 * @return String actionMode
	 * @exception Nothing
	 */
	public String getActionMode() {
		return actionMode;
	}
	
	/**
     * Get answerIdArray <br>
     * @param Nothing
     * @return String[] answerIdArray
     * @exception Nothing
     */
    public String[] getAnswerIdArray() {
        return answerIdArray;
    }
	
	/**
     * Set pushMessageId <br>
     * @param Nothing
     * @return String pushMessageId
     * @exception Nothing
     */
    public String getPushMessageId() {
        return pushMessageId;
    }
	
	/**
     * Get timeStamp
     * @param Nothing
     * @return String timeStamp
     * @exception Nothing
     */
    public String getTimeStamp() {
        return timeStamp;
    }
	
	/**
	 * Get Id <br>
	 * 
	 * @param 
	 * @return String id
	 * @exception 
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Get Del Cd <br>
	 * 
	 * @param 
	 * @return String delCd
	 * @exception 
	 */
	public String getDelCd() {
		return delCd;
	}
	
	/**
	 * Get Contract No <br>
	 * 
	 * @param 
	 * @return String contractNo
	 * @exception 
	 */
	public String getContractNo() {
		return contractNo;
	}
	
	/**
	 * Get Contract Type <br>
	 * 
	 * @param 
	 * @return String contractType
	 * @exception 
	 */
	public String getContractType() {
		return contractType;
	}
	
	/**
	 * Get Bond Cd <br>
	 * 
	 * @param 
	 * @return String bondCd
	 * @exception 
	 */
	public String getBondCd() {
		return bondCd;
	}
	
	/**
	 * Get Sub Acco Cd <br>
	 * 
	 * @param 
	 * @return String subAccoCd
	 * @exception 
	 */
	public String getSubAccoCd() {
		return subAccoCd;
	}
	
	/**
	 * Get Qty <br>
	 * 
	 * @param 
	 * @return String qty
	 * @exception 
	 */
	public String getQty() {
		return qty;
	}
	
	/**
	 * Get Amount <br>
	 * 
	 * @param 
	 * @return String amount
	 * @exception 
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * Get Tax Amt <br>
	 * 
	 * @param 
	 * @return String taxAmt
	 * @exception 
	 */
	public String getTaxAmt() {
		return taxAmt;
	}
	
	/**
	 * Get Interest Amt <br>
	 * 
	 * @param 
	 * @return String interestAmt
	 * @exception 
	 */
	public String getInterestAmt() {
		return interestAmt;
	}
	
	/**
	 * Get Payment Method <br>
	 * 
	 * @param 
	 * @return String paymentMethod
	 * @exception 
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * Get Int Payment Method <br>
	 * 
	 * @param 
	 * @return String intPaymentMethod
	 * @exception 
	 */
	public String getIntPaymentMethod() {
		return intPaymentMethod;
	}
	
	/**
	 * Get Contract Date <br>
	 * 
	 * @param 
	 * @return String contractDate
	 * @exception 
	 */
	public String getContractDate() {
		return contractDate;
	}
	
	/**
	 * Get Payment Cash Date <br>
	 * 
	 * @param 
	 * @return String paymentCashDate
	 * @exception 
	 */
	public String getPaymentCashDate() {
		return paymentCashDate;
	}
	
	/**
	 * Get Payment Sec Date <br>
	 * 
	 * @param 
	 * @return String paymentSecDate
	 * @exception 
	 */
	public String getPaymentSecDate() {
		return paymentSecDate;
	}
	
	/**
	 * Get Transaction Cd <br>
	 * 
	 * @param 
	 * @return String transactionCd
	 * @exception 
	 */
	public String getTransactionCd() {
		return transactionCd;
	}
	
	/**
	 * Get Contract Sts <br>
	 * 
	 * @param 
	 * @return String contractSts
	 * @exception 
	 */
	public String getContractSts() {
		return contractSts;
	}
	
	/**
	 * Get Status <br>
	 * 
	 * @param 
	 * @return String status
	 * @exception 
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Get Remarks <br>
	 * 
	 * @param 
	 * @return String remarks
	 * @exception 
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * Get Reg Date Time <br>
	 * 
	 * @param 
	 * @return String regDateTime
	 * @exception 
	 */
	public String getRegDateTime() {
		return regDateTime;
	}
	
	/**
	 * Get Reg User Id <br>
	 * 
	 * @param 
	 * @return String regUserId
	 * @exception 
	 */
	public String getRegUserId() {
		return regUserId;
	}
	
	/**
	 * Get Upd Date Time <br>
	 * 
	 * @param 
	 * @return String updDateTime
	 * @exception 
	 */
	public String getUpdDateTime() {
		return updDateTime;
	}
	
	/**
	 * Get Upd User Id <br>
	 * 
	 * @param 
	 * @return String updUserId
	 * @exception 
	 */
	public String getUpdUserId() {
		return updUserId;
	}
	
	/**
	 * Set actionMode <br>
	 * 
	 * @param actionMode String
	 * @exception Nothing
	 */
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	
	/**
     * Set answerIdArray <br>
     * @param String[] answerIdArray
     * @exception Nothing
     */
    public void setAnswerIdArray(String[] answerIdArray) {
        this.answerIdArray = answerIdArray;
    }
	
	/**
     * Set pushMessageId
     * @param String pushMessageId
     * @exception Nothing
     */
    public void setPushMessageId(String pushMessageId) {
        this.pushMessageId = pushMessageId;
    }
	
	/**
	 * Set Id<br>
	 * 
	 * @param id String
	 * @exception Nothing
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Set Del Cd<br>
	 * 
	 * @param delCd String
	 * @exception Nothing
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Set Contract No<br>
	 * 
	 * @param contractNo String
	 * @exception Nothing
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Set Contract Type<br>
	 * 
	 * @param contractType String
	 * @exception Nothing
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	 * Set Bond Cd<br>
	 * 
	 * @param bondCd String
	 * @exception Nothing
	 */
	public void setBondCd(String bondCd) {
		this.bondCd = bondCd;
	}
	
	/**
	 * Set Sub Acco Cd<br>
	 * 
	 * @param subAccoCd String
	 * @exception Nothing
	 */
	public void setSubAccoCd(String subAccoCd) {
		this.subAccoCd = subAccoCd;
	}
	
	/**
	 * Set Qty<br>
	 * 
	 * @param qty String
	 * @exception Nothing
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Set Amount<br>
	 * 
	 * @param amount String
	 * @exception Nothing
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Set Tax Amt<br>
	 * 
	 * @param taxAmt String
	 * @exception Nothing
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Set Interest Amt<br>
	 * 
	 * @param interestAmt String
	 * @exception Nothing
	 */
	public void setInterestAmt(String interestAmt) {
		this.interestAmt = interestAmt;
	}
	
	/**
	 * Set Payment Method<br>
	 * 
	 * @param paymentMethod String
	 * @exception Nothing
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * Set Int Payment Method<br>
	 * 
	 * @param intPaymentMethod String
	 * @exception Nothing
	 */
	public void setIntPaymentMethod(String intPaymentMethod) {
		this.intPaymentMethod = intPaymentMethod;
	}
	
	/**
	 * Set Contract Date<br>
	 * 
	 * @param contractDate String
	 * @exception Nothing
	 */
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	
	/**
	 * Set Payment Cash Date<br>
	 * 
	 * @param paymentCashDate String
	 * @exception Nothing
	 */
	public void setPaymentCashDate(String paymentCashDate) {
		this.paymentCashDate = paymentCashDate;
	}
	
	/**
	 * Set Payment Sec Date<br>
	 * 
	 * @param paymentSecDate String
	 * @exception Nothing
	 */
	public void setPaymentSecDate(String paymentSecDate) {
		this.paymentSecDate = paymentSecDate;
	}
	
	/**
	 * Set Transaction Cd<br>
	 * 
	 * @param transactionCd String
	 * @exception Nothing
	 */
	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}
	
	/**
	 * Set Contract Sts<br>
	 * 
	 * @param contractSts String
	 * @exception Nothing
	 */
	public void setContractSts(String contractSts) {
		this.contractSts = contractSts;
	}
	
	/**
	 * Set Status<br>
	 * 
	 * @param status String
	 * @exception Nothing
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Set Remarks<br>
	 * 
	 * @param remarks String
	 * @exception Nothing
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * Set Reg Date Time<br>
	 * 
	 * @param regDateTime String
	 * @exception Nothing
	 */
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	/**
	 * Set Reg User Id<br>
	 * 
	 * @param regUserId String
	 * @exception Nothing
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	
	/**
	 * Set Upd Date Time<br>
	 * 
	 * @param updDateTime String
	 * @exception Nothing
	 */
	public void setUpdDateTime(String updDateTime) {
		this.updDateTime = updDateTime;
	}
	
	/**
	 * Set Upd User Id<br>
	 * 
	 * @param updUserId String
	 * @exception Nothing
	 */
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
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
     * Return response data infomation for management purpose. <br>
	 *
     * @param Nothing
     * @return String response data infomation
     * @exception Nothing
     */
	public String toString() {
		StringBuffer outputData = new StringBuffer(super.toString());
		outputData.append(",actionMode=");
		outputData.append(actionMode);
		outputData.append(",id=");
		outputData.append(id);
		outputData.append(",delCd=");
		outputData.append(delCd);
		outputData.append(",contractNo=");
		outputData.append(contractNo);
		outputData.append(",contractType=");
		outputData.append(contractType);
		outputData.append(",bondCd=");
		outputData.append(bondCd);
		outputData.append(",subAccoCd=");
		outputData.append(subAccoCd);
		outputData.append(",qty=");
		outputData.append(qty);
		outputData.append(",amount=");
		outputData.append(amount);
		outputData.append(",taxAmt=");
		outputData.append(taxAmt);
		outputData.append(",interestAmt=");
		outputData.append(interestAmt);
		outputData.append(",paymentMethod=");
		outputData.append(paymentMethod);
		outputData.append(",intPaymentMethod=");
		outputData.append(intPaymentMethod);
		outputData.append(",contractDate=");
		outputData.append(contractDate);
		outputData.append(",paymentCashDate=");
		outputData.append(paymentCashDate);
		outputData.append(",paymentSecDate=");
		outputData.append(paymentSecDate);
		outputData.append(",transactionCd=");
		outputData.append(transactionCd);
		outputData.append(",contractSts=");
		outputData.append(contractSts);
		outputData.append(",status=");
		outputData.append(status);
		outputData.append(",remarks=");
		outputData.append(remarks);
		outputData.append(",regDateTime=");
		outputData.append(regDateTime);
		outputData.append(",regUserId=");
		outputData.append(regUserId);
		outputData.append(",updDateTime=");
		outputData.append(updDateTime);
		outputData.append(",updUserId=");
		outputData.append(updUserId);
		outputData.append(",answerIdArray=");
		outputData.append(answerIdArray);	
		outputData.append(",pushMessageId=");
		outputData.append(pushMessageId);
		
		return outputData.toString();
	}
}
