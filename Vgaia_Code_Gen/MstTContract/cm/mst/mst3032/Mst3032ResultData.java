/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.mst.mst3032;

import jp.co.nec.frw0000.cm.data.Frw00ResultData;

/**
 * Mst3032ResultData class's Description <br>
 * <P>
 * Response data class of MstTContract
 * <p>
 * Set and Get value for response data class from Server
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032ResultData extends Frw00ResultData {
	
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
	
	//Contract Type Id
	private String contractTypeId;
	
	//Contract Name
	private String contractName;
	
	//Company
	private String company;
	
	//Tel
	private String tel;
	
	//Address
	private String address;
	
	//Represent Name
	private String representName;
	
	//Represent Id
	private String representId;
	
	//Contract Date
	private String contractDate;
	
	//Finish Date
	private String finishDate;
	
	//Transaction Cd
	private String transactionCd;
	
	//Remarks
	private String remarks;
	
	//Status
	private String status;
	
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
	 * Mst3032ResultData Constructor description. <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public Mst3032ResultData() {
		super();
	}
	
	/**
	 * Mst3032ResultData Constructor description<BR>
	 * 
	 * @param  inputData Mst3032ResultData input data from client
	 * @exception Nothing
	 */
	public Mst3032ResultData(Mst3032ResultData inputData) {
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
	 * Get Contract Type Id <br>
	 * 
	 * @param 
	 * @return String contractTypeId
	 * @exception 
	 */
	public String getContractTypeId() {
		return contractTypeId;
	}
	
	/**
	 * Get Contract Name <br>
	 * 
	 * @param 
	 * @return String contractName
	 * @exception 
	 */
	public String getContractName() {
		return contractName;
	}
	
	/**
	 * Get Company <br>
	 * 
	 * @param 
	 * @return String company
	 * @exception 
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Get Tel <br>
	 * 
	 * @param 
	 * @return String tel
	 * @exception 
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Get Address <br>
	 * 
	 * @param 
	 * @return String address
	 * @exception 
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Get Represent Name <br>
	 * 
	 * @param 
	 * @return String representName
	 * @exception 
	 */
	public String getRepresentName() {
		return representName;
	}
	
	/**
	 * Get Represent Id <br>
	 * 
	 * @param 
	 * @return String representId
	 * @exception 
	 */
	public String getRepresentId() {
		return representId;
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
	 * Get Finish Date <br>
	 * 
	 * @param 
	 * @return String finishDate
	 * @exception 
	 */
	public String getFinishDate() {
		return finishDate;
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
	 * Set Contract Type Id<br>
	 * 
	 * @param contractTypeId String
	 * @exception Nothing
	 */
	public void setContractTypeId(String contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	
	/**
	 * Set Contract Name<br>
	 * 
	 * @param contractName String
	 * @exception Nothing
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	/**
	 * Set Company<br>
	 * 
	 * @param company String
	 * @exception Nothing
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Set Tel<br>
	 * 
	 * @param tel String
	 * @exception Nothing
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Set Address<br>
	 * 
	 * @param address String
	 * @exception Nothing
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Set Represent Name<br>
	 * 
	 * @param representName String
	 * @exception Nothing
	 */
	public void setRepresentName(String representName) {
		this.representName = representName;
	}
	
	/**
	 * Set Represent Id<br>
	 * 
	 * @param representId String
	 * @exception Nothing
	 */
	public void setRepresentId(String representId) {
		this.representId = representId;
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
	 * Set Finish Date<br>
	 * 
	 * @param finishDate String
	 * @exception Nothing
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
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
	 * Set Remarks<br>
	 * 
	 * @param remarks String
	 * @exception Nothing
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		outputData.append(",contractTypeId=");
		outputData.append(contractTypeId);
		outputData.append(",contractName=");
		outputData.append(contractName);
		outputData.append(",company=");
		outputData.append(company);
		outputData.append(",tel=");
		outputData.append(tel);
		outputData.append(",address=");
		outputData.append(address);
		outputData.append(",representName=");
		outputData.append(representName);
		outputData.append(",representId=");
		outputData.append(representId);
		outputData.append(",contractDate=");
		outputData.append(contractDate);
		outputData.append(",finishDate=");
		outputData.append(finishDate);
		outputData.append(",transactionCd=");
		outputData.append(transactionCd);
		outputData.append(",remarks=");
		outputData.append(remarks);
		outputData.append(",status=");
		outputData.append(status);
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
