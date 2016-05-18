/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.hlp.hlp6032;

import java.util.List;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;

/**
 * Hlp6032ResultData class's Description <br>
 * <P>
 * Response data class of MstTContract
 * <p>
 * Set and Get value for response data class from Server
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Hlp6032ResultData extends Frw00ResultData {
	
	////////// Class Variables //////////
	
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
	public Hlp6032ResultData() {		
		super();
	}
	
	/**
	 * Constructor <br>
	 * <P>
	 * Call Constructor base template.
	 * 
	 * @param Hlp6032InputData data
	 * @exception Nothing
	 */
	public Hlp6032ResultData(Hlp6032InputData inputData) {		
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
	 * Get Contract Type Id<BR>
	 * 
	 * @param
	 * @return Contract Type Id String
	 * @exception
	 */
	public String getContractTypeId() {
		return contractTypeId;
	}
	
	/**
	 * Get Contract Name<BR>
	 * 
	 * @param
	 * @return Contract Name String
	 * @exception
	 */
	public String getContractName() {
		return contractName;
	}
	
	/**
	 * Get Company<BR>
	 * 
	 * @param
	 * @return Company String
	 * @exception
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Get Tel<BR>
	 * 
	 * @param
	 * @return Tel String
	 * @exception
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Get Address<BR>
	 * 
	 * @param
	 * @return Address String
	 * @exception
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Get Represent Name<BR>
	 * 
	 * @param
	 * @return Represent Name String
	 * @exception
	 */
	public String getRepresentName() {
		return representName;
	}
	
	/**
	 * Get Represent Id<BR>
	 * 
	 * @param
	 * @return Represent Id String
	 * @exception
	 */
	public String getRepresentId() {
		return representId;
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
	 * Get Finish Date<BR>
	 * 
	 * @param
	 * @return Finish Date String
	 * @exception
	 */
	public String getFinishDate() {
		return finishDate;
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
	 * Set Contract Type Id<BR>
	 * 
	 * @param contractTypeId String
	 * @return
	 * @exception
	 */
	public void setContractTypeId(String contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	
	/**
	 * Set Contract Name<BR>
	 * 
	 * @param contractName String
	 * @return
	 * @exception
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	
	/**
	 * Set Company<BR>
	 * 
	 * @param company String
	 * @return
	 * @exception
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Set Tel<BR>
	 * 
	 * @param tel String
	 * @return
	 * @exception
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Set Address<BR>
	 * 
	 * @param address String
	 * @return
	 * @exception
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Set Represent Name<BR>
	 * 
	 * @param representName String
	 * @return
	 * @exception
	 */
	public void setRepresentName(String representName) {
		this.representName = representName;
	}
	
	/**
	 * Set Represent Id<BR>
	 * 
	 * @param representId String
	 * @return
	 * @exception
	 */
	public void setRepresentId(String representId) {
		this.representId = representId;
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
	 * Set Finish Date<BR>
	 * 
	 * @param finishDate String
	 * @return
	 * @exception
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
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

