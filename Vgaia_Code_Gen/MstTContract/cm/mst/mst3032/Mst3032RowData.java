/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.mst.mst3032;

import java.util.HashMap;

import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ItemValidator;

/**
* 30323032Row data for grid. <br>
* <p>
*  Row data class of MstTContract.
* </p>
* Set and Get data of screen component.
*
* @author: HungKieu 2016/04/26 Create New
*/
public class Mst3032RowData  {
	
	////////// Class Variables //////////
	
	/** Selection Column */
	public static final int SelectionCol = 0;

	/** UpdateFlag Column */
	public static final int UpdateFlagCol = 1;

	/** ErrorFlag Column */
	public static final int ErrorFlagCol = 2;

	/** TimeStamp Column */
	public static final int TimeStampCol = 3;
	
	/** Id Column */
	public static final int IdCol = 4;
	
	/** Del Cd Column */
	public static final int DelCdCol = 4;
	
	/** Contract No Column */
	public static final int ContractNoCol = 4;
	
	/** Contract Type Id Column */
	public static final int ContractTypeIdCol = 4;
	
	/** Contract Name Column */
	public static final int ContractNameCol = 4;
	
	/** Company Column */
	public static final int CompanyCol = 4;
	
	/** Tel Column */
	public static final int TelCol = 4;
	
	/** Address Column */
	public static final int AddressCol = 4;
	
	/** Represent Name Column */
	public static final int RepresentNameCol = 4;
	
	/** Represent Id Column */
	public static final int RepresentIdCol = 4;
	
	/** Contract Date Column */
	public static final int ContractDateCol = 4;
	
	/** Finish Date Column */
	public static final int FinishDateCol = 4;
	
	/** Transaction Cd Column */
	public static final int TransactionCdCol = 4;
	
	/** Remarks Column */
	public static final int RemarksCol = 4;
	
	/** Status Column */
	public static final int StatusCol = 4;
	
	/** Reg Date Time Column */
	public static final int RegDateTimeCol = 4;
	
	/** Reg User Id Column */
	public static final int RegUserIdCol = 4;
	
	/** Upd Date Time Column */
	public static final int UpdDateTimeCol = 4;
	
	/** Upd User Id Column */
	public static final int UpdUserIdCol = 4;
	
	
	/** Column total */
	public static final int ColTotal = 8;
	
	/** selection */
	private Boolean select;
	
	/** Update Flag */
	private String updateFlg;
	
	/** ErrorFlag */
	private String errorFlag;
	
	/** Hidden Update DateTime */
	private String timeStamp;
	
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
	
	
	
	
	////////// Class Methods //////////
	
	/**
	 * Get RowData from Row data in Table
	 * 
	 * @return Mst3032RowData
	 */
	public static Mst3032RowData getMst3032RowData(Object[] row) {
		Mst3032RowData obj = new Mst3032RowData();
		
		if (row[SelectionCol] != null) {
			obj.setSelect(Boolean.valueOf(row[SelectionCol].toString()));
		}
		
		obj.setUpdateFlg(CommonHelper.getStringFromObject(row[UpdateFlagCol]));
		obj.setErrorFlag(CommonHelper.getStringFromObject(row[ErrorFlagCol]));
		obj.setTimeStamp(CommonHelper.getStringFromObject(row[TimeStampCol]));

		obj.setId(CommonHelper.getStringFromObject(row[IdCol]));
		obj.setDelCd(CommonHelper.getStringFromObject(row[DelCdCol]));
		obj.setContractNo(CommonHelper.getStringFromObject(row[ContractNoCol]));
		obj.setContractTypeId(CommonHelper.getStringFromObject(row[ContractTypeIdCol]));
		obj.setContractName(CommonHelper.getStringFromObject(row[ContractNameCol]));
		obj.setCompany(CommonHelper.getStringFromObject(row[CompanyCol]));
		obj.setTel(CommonHelper.getStringFromObject(row[TelCol]));
		obj.setAddress(CommonHelper.getStringFromObject(row[AddressCol]));
		obj.setRepresentName(CommonHelper.getStringFromObject(row[RepresentNameCol]));
		obj.setRepresentId(CommonHelper.getStringFromObject(row[RepresentIdCol]));
		obj.setContractDate(CommonHelper.getStringFromObject(row[ContractDateCol]));
		obj.setFinishDate(CommonHelper.getStringFromObject(row[FinishDateCol]));
		obj.setTransactionCd(CommonHelper.getStringFromObject(row[TransactionCdCol]));
		obj.setRemarks(CommonHelper.getStringFromObject(row[RemarksCol]));
		obj.setStatus(CommonHelper.getStringFromObject(row[StatusCol]));
		obj.setRegDateTime(CommonHelper.getStringFromObject(row[RegDateTimeCol]));
		obj.setRegUserId(CommonHelper.getStringFromObject(row[RegUserIdCol]));
		obj.setUpdDateTime(CommonHelper.getStringFromObject(row[UpdDateTimeCol]));
		obj.setUpdUserId(CommonHelper.getStringFromObject(row[UpdUserIdCol]));

		return obj;
	}

	/**
	 * Get HashMap from Row data in Table
	 * 
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> getMst3032RowDataHashMap() {

		HashMap<String, Object> hashMap = new HashMap<>();

		hashMap.put(String.valueOf(SelectionCol), this.select);

		if (this.getUpdateFlg() != null) {
			hashMap.put(String.valueOf(UpdateFlagCol), this.getUpdateFlg());
		}

		if (this.getTimeStamp() != null) {
			hashMap.put(String.valueOf(TimeStampCol), this.getTimeStamp());
		}

		if (ItemValidator.isNotEmpty(this.getId())) {
			hashMap.put(String.valueOf(IdCol), this.getId());
		}

		hashMap.put(String.valueOf(IdCol), this.getId());
		hashMap.put(String.valueOf(DelCdCol), this.getDelCd());
		hashMap.put(String.valueOf(ContractNoCol), this.getContractNo());
		hashMap.put(String.valueOf(ContractTypeIdCol), this.getContractTypeId());
		hashMap.put(String.valueOf(ContractNameCol), this.getContractName());
		hashMap.put(String.valueOf(CompanyCol), this.getCompany());
		hashMap.put(String.valueOf(TelCol), this.getTel());
		hashMap.put(String.valueOf(AddressCol), this.getAddress());
		hashMap.put(String.valueOf(RepresentNameCol), this.getRepresentName());
		hashMap.put(String.valueOf(RepresentIdCol), this.getRepresentId());
		hashMap.put(String.valueOf(ContractDateCol), this.getContractDate());
		hashMap.put(String.valueOf(FinishDateCol), this.getFinishDate());
		hashMap.put(String.valueOf(TransactionCdCol), this.getTransactionCd());
		hashMap.put(String.valueOf(RemarksCol), this.getRemarks());
		hashMap.put(String.valueOf(StatusCol), this.getStatus());
		hashMap.put(String.valueOf(RegDateTimeCol), this.getRegDateTime());
		hashMap.put(String.valueOf(RegUserIdCol), this.getRegUserId());
		hashMap.put(String.valueOf(UpdDateTimeCol), this.getUpdDateTime());
		hashMap.put(String.valueOf(UpdUserIdCol), this.getUpdUserId());

		return hashMap;
	}
	
	
	/**
	 * @return the select
	 */
	public Boolean getSelect() {
		return select;
	}

	/**
	 * @param select
	 *            the select to set
	 */
	public void setSelect(Boolean select) {
		this.select = select;
	}
	
	
	/**
	 * @return the errorFlag
	 */
	public String getErrorFlag() {
		return errorFlag;
	}

	/**
	 * @param errorFlag
	 *            the errorFlag to set
	 */
	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	/**
	 * @return the updateFlg
	 */
	public String getUpdateFlg() {
		return updateFlg;
	}

	/**
	 * @param updateFlg
	 *            the updateFlg to set
	 */
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
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

