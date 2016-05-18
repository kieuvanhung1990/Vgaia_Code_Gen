/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.mst.mst3032;

import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.okasan.cm.cmn.PRData;

/**
* 30323032InputData class's Description. <br>
* <p>
*  Input data class of MstTContract.
* </p>
* Set and Get data of screen component.
*
* @author: HungKieu 2016/04/26 Create New
*/
public class Mst3032InputData extends Frw00InputData {
	
	////////// Class Variables //////////
	
	/** Action Mode */
	private String actionMode;
	
	/** Id */
	private String id;
	
	/** Del Cd */
	private String delCd;
	
	/** Contract No */
	private String contractNo;
	
	/** Contract Type Id */
	private String contractTypeId;
	
	/** Contract Name */
	private String contractName;
	
	/** Company */
	private String company;
	
	/** Tel */
	private String tel;
	
	/** Address */
	private String address;
	
	/** Represent Name */
	private String representName;
	
	/** Represent Id */
	private String representId;
	
	/** Contract Date */
	private String contractDate;
	
	/** Finish Date */
	private String finishDate;
	
	/** Transaction Cd */
	private String transactionCd;
	
	/** Remarks */
	private String remarks;
	
	/** Status */
	private String status;
	
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
	 * Contract Type Id 
	 * @param Nothing
	 * @return String Contract Type Id
	 * @exception Nothing
	 */
	public String getContractTypeId() {
		return contractTypeId;
	}
	
	/**
	 * Contract Name 
	 * @param Nothing
	 * @return String Contract Name
	 * @exception Nothing
	 */
	public String getContractName() {
		return contractName;
	}
	
	/**
	 * Company 
	 * @param Nothing
	 * @return String Company
	 * @exception Nothing
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Tel 
	 * @param Nothing
	 * @return String Tel
	 * @exception Nothing
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Address 
	 * @param Nothing
	 * @return String Address
	 * @exception Nothing
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Represent Name 
	 * @param Nothing
	 * @return String Represent Name
	 * @exception Nothing
	 */
	public String getRepresentName() {
		return representName;
	}
	
	/**
	 * Represent Id 
	 * @param Nothing
	 * @return String Represent Id
	 * @exception Nothing
	 */
	public String getRepresentId() {
		return representId;
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
	 * Finish Date 
	 * @param Nothing
	 * @return String Finish Date
	 * @exception Nothing
	 */
	public String getFinishDate() {
		return finishDate;
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
	 * Remarks 
	 * @param Nothing
	 * @return String Remarks
	 * @exception Nothing
	 */
	public String getRemarks() {
		return remarks;
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
	 * Contract Type Id
	 * @param contractTypeId String Contract Type Id
	 * @exception Nothing
	 */
	public void setContractTypeId(String contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	
	/**
	 * Contract Name
	 * @param contractName String Contract Name
	 * @exception Nothing
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	/**
	 * Company
	 * @param company String Company
	 * @exception Nothing
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Tel
	 * @param tel String Tel
	 * @exception Nothing
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Address
	 * @param address String Address
	 * @exception Nothing
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Represent Name
	 * @param representName String Represent Name
	 * @exception Nothing
	 */
	public void setRepresentName(String representName) {
		this.representName = representName;
	}
	
	/**
	 * Represent Id
	 * @param representId String Represent Id
	 * @exception Nothing
	 */
	public void setRepresentId(String representId) {
		this.representId = representId;
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
	 * Finish Date
	 * @param finishDate String Finish Date
	 * @exception Nothing
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
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
	 * Remarks
	 * @param remarks String Remarks
	 * @exception Nothing
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		inputData.append(",contractTypeId=");
		inputData.append(contractTypeId);
		inputData.append(",contractName=");
		inputData.append(contractName);
		inputData.append(",company=");
		inputData.append(company);
		inputData.append(",tel=");
		inputData.append(tel);
		inputData.append(",address=");
		inputData.append(address);
		inputData.append(",representName=");
		inputData.append(representName);
		inputData.append(",representId=");
		inputData.append(representId);
		inputData.append(",contractDate=");
		inputData.append(contractDate);
		inputData.append(",finishDate=");
		inputData.append(finishDate);
		inputData.append(",transactionCd=");
		inputData.append(transactionCd);
		inputData.append(",remarks=");
		inputData.append(remarks);
		inputData.append(",status=");
		inputData.append(status);
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

