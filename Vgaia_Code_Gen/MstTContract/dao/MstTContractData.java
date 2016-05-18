/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 * 
 * 
 */
package jp.co.okasan.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.co.nec.frw0100.ap.dao.BaseData;
import jp.co.nec.frw0000.cm.Frw00RuntimeException;
import jp.co.nec.frw0100.ap.dao.*;
/**
 * MstTContractData Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 * @author: HungKieu 2016/04/26 Create new
 */
public class MstTContractData
	extends BaseData
	implements MstTContractConst {
	
	////////// Class Variables //////////
	
	/** Target object data*/
	private MstTContractTarget target = null;
	
	////////// Class Constructor //////////
		
	/**
	 * Constructor. <br>
	 * Call from base tamplate 
	 * @param Nothing
	 * @exception Nothing
	 */
	public MstTContractData() {
		super();
		target = new MstTContractTarget();
		setId((BigDecimal)null);
		setDelCd((BigDecimal)null);
		setContractNo((String)null);
		setContractTypeId((BigDecimal)null);
		setContractName((String)null);
		setCompany((String)null);
		setTel((String)null);
		setAddress((String)null);
		setRepresentName((String)null);
		setRepresentId((String)null);
		setContractDate((BigDecimal)null);
		setFinishDate((BigDecimal)null);
		setTransactionCd((String)null);
		setRemarks((String)null);
		setStatus((BigDecimal)null);
		setRegDateTime((Timestamp)null);
		setRegUserId((String)null);
		setUpdDateTime((Timestamp)null);
		setUpdUserId((String)null);
	}
	
	////////// Class Methods //////////
	
	/**
	 * Set Id<BR>
	 * @param value Id
	 * @exception Nothing
	 */
	public void setId(BigDecimal value) {
		items.put(ID, value);
		target.setId(true);
	}
	
	/**
	 * Set Id from String<BR>
	 * @param value Id
	 * @exception Nothing
	 */
	public void setIdSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setId(setValue);
	}
	
	/**
	 * Set DelCd<BR>
	 * @param value DelCd
	 * @exception Nothing
	 */
	public void setDelCd(BigDecimal value) {
		items.put(DEL_CD, value);
		target.setDelCd(true);
	}
	
	/**
	 * Set DelCd from String<BR>
	 * @param value DelCd
	 * @exception Nothing
	 */
	public void setDelCdSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setDelCd(setValue);
	}
	
	/**
	 * Set ContractNo<BR>
	 * @param value ContractNo
	 * @exception Nothing
	 */
	public void setContractNo(String value) {
		items.put(CONTRACT_NO, value);
		target.setContractNo(true);
	}
	
	
	/**
	 * Set ContractTypeId<BR>
	 * @param value ContractTypeId
	 * @exception Nothing
	 */
	public void setContractTypeId(BigDecimal value) {
		items.put(CONTRACT_TYPE_ID, value);
		target.setContractTypeId(true);
	}
	
	/**
	 * Set ContractTypeId from String<BR>
	 * @param value ContractTypeId
	 * @exception Nothing
	 */
	public void setContractTypeIdSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setContractTypeId(setValue);
	}
	
	/**
	 * Set ContractName<BR>
	 * @param value ContractName
	 * @exception Nothing
	 */
	public void setContractName(String value) {
		items.put(CONTRACT_NAME, value);
		target.setContractName(true);
	}
	
	
	/**
	 * Set Company<BR>
	 * @param value Company
	 * @exception Nothing
	 */
	public void setCompany(String value) {
		items.put(COMPANY, value);
		target.setCompany(true);
	}
	
	
	/**
	 * Set Tel<BR>
	 * @param value Tel
	 * @exception Nothing
	 */
	public void setTel(String value) {
		items.put(TEL, value);
		target.setTel(true);
	}
	
	
	/**
	 * Set Address<BR>
	 * @param value Address
	 * @exception Nothing
	 */
	public void setAddress(String value) {
		items.put(ADDRESS, value);
		target.setAddress(true);
	}
	
	
	/**
	 * Set RepresentName<BR>
	 * @param value RepresentName
	 * @exception Nothing
	 */
	public void setRepresentName(String value) {
		items.put(REPRESENT_NAME, value);
		target.setRepresentName(true);
	}
	
	
	/**
	 * Set RepresentId<BR>
	 * @param value RepresentId
	 * @exception Nothing
	 */
	public void setRepresentId(String value) {
		items.put(REPRESENT_ID, value);
		target.setRepresentId(true);
	}
	
	
	/**
	 * Set ContractDate<BR>
	 * @param value ContractDate
	 * @exception Nothing
	 */
	public void setContractDate(BigDecimal value) {
		items.put(CONTRACT_DATE, value);
		target.setContractDate(true);
	}
	
	/**
	 * Set ContractDate from String<BR>
	 * @param value ContractDate
	 * @exception Nothing
	 */
	public void setContractDateSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setContractDate(setValue);
	}
	
	/**
	 * Set FinishDate<BR>
	 * @param value FinishDate
	 * @exception Nothing
	 */
	public void setFinishDate(BigDecimal value) {
		items.put(FINISH_DATE, value);
		target.setFinishDate(true);
	}
	
	/**
	 * Set FinishDate from String<BR>
	 * @param value FinishDate
	 * @exception Nothing
	 */
	public void setFinishDateSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setFinishDate(setValue);
	}
	
	/**
	 * Set TransactionCd<BR>
	 * @param value TransactionCd
	 * @exception Nothing
	 */
	public void setTransactionCd(String value) {
		items.put(TRANSACTION_CD, value);
		target.setTransactionCd(true);
	}
	
	
	/**
	 * Set Remarks<BR>
	 * @param value Remarks
	 * @exception Nothing
	 */
	public void setRemarks(String value) {
		items.put(REMARKS, value);
		target.setRemarks(true);
	}
	
	
	/**
	 * Set Status<BR>
	 * @param value Status
	 * @exception Nothing
	 */
	public void setStatus(BigDecimal value) {
		items.put(STATUS, value);
		target.setStatus(true);
	}
	
	/**
	 * Set Status from String<BR>
	 * @param value Status
	 * @exception Nothing
	 */
	public void setStatusSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setStatus(setValue);
	}
	
	/**
	 * Set RegDateTime<BR>
	 * @param value RegDateTime
	 * @exception Nothing
	 */
	public void setRegDateTime(Timestamp value) {
		items.put(REG_DATE_TIME, value);
		target.setRegDateTime(true);
	}
	
	/**
	 * Set RegDateTime from String<BR>
	 * @param value RegDateTime
	 * @exception Nothing
	 */
	public void setRegDateTimeSt(String value) {
		Timestamp setValue = null;
		if (value != null) {
			setValue = Convert.toTimestamp(value);
			if (setValue == null) {
				throw new Frw00RuntimeException(
					"Timestamp is not format");
			}
		}
		setRegDateTime(setValue);
	}
	
	/**
	 * Set RegUserId<BR>
	 * @param value RegUserId
	 * @exception Nothing
	 */
	public void setRegUserId(String value) {
		items.put(REG_USER_ID, value);
		target.setRegUserId(true);
	}
	
	
	/**
	 * Set UpdDateTime<BR>
	 * @param value UpdDateTime
	 * @exception Nothing
	 */
	public void setUpdDateTime(Timestamp value) {
		items.put(UPD_DATE_TIME, value);
		target.setUpdDateTime(true);
	}
	
	/**
	 * Set UpdDateTime from String<BR>
	 * @param value UpdDateTime
	 * @exception Nothing
	 */
	public void setUpdDateTimeSt(String value) {
		Timestamp setValue = null;
		if (value != null) {
			setValue = Convert.toTimestamp(value);
			if (setValue == null) {
				throw new Frw00RuntimeException(
					"Timestamp is not format");
			}
		}
		setUpdDateTime(setValue);
	}
	
	/**
	 * Set UpdUserId<BR>
	 * @param value UpdUserId
	 * @exception Nothing
	 */
	public void setUpdUserId(String value) {
		items.put(UPD_USER_ID, value);
		target.setUpdUserId(true);
	}
	
	
	/**
	 * Get Id<BR>
	 * @param Nothing
	 * @return Id value
	 * @exception Nothing
	 */
	public BigDecimal getId() {
		return (BigDecimal)items.get(ID);
	}
	
	/**
	 * Get Id <br>
	 * @param Nothing
	 * @return Id String value
	 * @exception Nothing
	 */
	public String getIdSt() {
		if(items.get(ID)!= null){
			return items.get(ID).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get DelCd<BR>
	 * @param Nothing
	 * @return DelCd value
	 * @exception Nothing
	 */
	public BigDecimal getDelCd() {
		return (BigDecimal)items.get(DEL_CD);
	}
	
	/**
	 * Get DelCd <br>
	 * @param Nothing
	 * @return DelCd String value
	 * @exception Nothing
	 */
	public String getDelCdSt() {
		if(items.get(DEL_CD)!= null){
			return items.get(DEL_CD).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get ContractNo<BR>
	 * @param Nothing
	 * @return ContractNo value
	 * @exception Nothing
	 */
	public String getContractNo() {
		return (String)items.get(CONTRACT_NO);
	}
	
	/**
	 * Get ContractTypeId<BR>
	 * @param Nothing
	 * @return ContractTypeId value
	 * @exception Nothing
	 */
	public BigDecimal getContractTypeId() {
		return (BigDecimal)items.get(CONTRACT_TYPE_ID);
	}
	
	/**
	 * Get ContractTypeId <br>
	 * @param Nothing
	 * @return ContractTypeId String value
	 * @exception Nothing
	 */
	public String getContractTypeIdSt() {
		if(items.get(CONTRACT_TYPE_ID)!= null){
			return items.get(CONTRACT_TYPE_ID).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get ContractName<BR>
	 * @param Nothing
	 * @return ContractName value
	 * @exception Nothing
	 */
	public String getContractName() {
		return (String)items.get(CONTRACT_NAME);
	}
	
	/**
	 * Get Company<BR>
	 * @param Nothing
	 * @return Company value
	 * @exception Nothing
	 */
	public String getCompany() {
		return (String)items.get(COMPANY);
	}
	
	/**
	 * Get Tel<BR>
	 * @param Nothing
	 * @return Tel value
	 * @exception Nothing
	 */
	public String getTel() {
		return (String)items.get(TEL);
	}
	
	/**
	 * Get Address<BR>
	 * @param Nothing
	 * @return Address value
	 * @exception Nothing
	 */
	public String getAddress() {
		return (String)items.get(ADDRESS);
	}
	
	/**
	 * Get RepresentName<BR>
	 * @param Nothing
	 * @return RepresentName value
	 * @exception Nothing
	 */
	public String getRepresentName() {
		return (String)items.get(REPRESENT_NAME);
	}
	
	/**
	 * Get RepresentId<BR>
	 * @param Nothing
	 * @return RepresentId value
	 * @exception Nothing
	 */
	public String getRepresentId() {
		return (String)items.get(REPRESENT_ID);
	}
	
	/**
	 * Get ContractDate<BR>
	 * @param Nothing
	 * @return ContractDate value
	 * @exception Nothing
	 */
	public BigDecimal getContractDate() {
		return (BigDecimal)items.get(CONTRACT_DATE);
	}
	
	/**
	 * Get ContractDate <br>
	 * @param Nothing
	 * @return ContractDate String value
	 * @exception Nothing
	 */
	public String getContractDateSt() {
		if(items.get(CONTRACT_DATE)!= null){
			return items.get(CONTRACT_DATE).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get FinishDate<BR>
	 * @param Nothing
	 * @return FinishDate value
	 * @exception Nothing
	 */
	public BigDecimal getFinishDate() {
		return (BigDecimal)items.get(FINISH_DATE);
	}
	
	/**
	 * Get FinishDate <br>
	 * @param Nothing
	 * @return FinishDate String value
	 * @exception Nothing
	 */
	public String getFinishDateSt() {
		if(items.get(FINISH_DATE)!= null){
			return items.get(FINISH_DATE).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get TransactionCd<BR>
	 * @param Nothing
	 * @return TransactionCd value
	 * @exception Nothing
	 */
	public String getTransactionCd() {
		return (String)items.get(TRANSACTION_CD);
	}
	
	/**
	 * Get Remarks<BR>
	 * @param Nothing
	 * @return Remarks value
	 * @exception Nothing
	 */
	public String getRemarks() {
		return (String)items.get(REMARKS);
	}
	
	/**
	 * Get Status<BR>
	 * @param Nothing
	 * @return Status value
	 * @exception Nothing
	 */
	public BigDecimal getStatus() {
		return (BigDecimal)items.get(STATUS);
	}
	
	/**
	 * Get Status <br>
	 * @param Nothing
	 * @return Status String value
	 * @exception Nothing
	 */
	public String getStatusSt() {
		if(items.get(STATUS)!= null){
			return items.get(STATUS).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get RegDateTime<BR>
	 * @param Nothing
	 * @return RegDateTime value
	 * @exception Nothing
	 */
	public Timestamp getRegDateTime() {
		return (Timestamp)items.get(REG_DATE_TIME);
	}
	
	/**
	 * Get RegDateTime <br>
	 * @param Nothing
	 * @return RegDateTime String value
	 * @exception Nothing
	 */
	public String getRegDateTimeSt() {
		if(items.get(REG_DATE_TIME)!= null){
			return items.get(REG_DATE_TIME).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get RegUserId<BR>
	 * @param Nothing
	 * @return RegUserId value
	 * @exception Nothing
	 */
	public String getRegUserId() {
		return (String)items.get(REG_USER_ID);
	}
	
	/**
	 * Get UpdDateTime<BR>
	 * @param Nothing
	 * @return UpdDateTime value
	 * @exception Nothing
	 */
	public Timestamp getUpdDateTime() {
		return (Timestamp)items.get(UPD_DATE_TIME);
	}
	
	/**
	 * Get UpdDateTime <br>
	 * @param Nothing
	 * @return UpdDateTime String value
	 * @exception Nothing
	 */
	public String getUpdDateTimeSt() {
		if(items.get(UPD_DATE_TIME)!= null){
			return items.get(UPD_DATE_TIME).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get UpdUserId<BR>
	 * @param Nothing
	 * @return UpdUserId value
	 * @exception Nothing
	 */
	public String getUpdUserId() {
		return (String)items.get(UPD_USER_ID);
	}
	
	
	/**
	 * Get all columns data <br>
	 * @param  Nothing
	 * @return List data of field in content 
	 * @exception Nothing
	 */
	public List getColumnData() {
		List columnData = new ArrayList();
		columnData.add(getId());
		columnData.add(getDelCd());
		columnData.add(getContractNo());
		columnData.add(getContractTypeId());
		columnData.add(getContractName());
		columnData.add(getCompany());
		columnData.add(getTel());
		columnData.add(getAddress());
		columnData.add(getRepresentName());
		columnData.add(getRepresentId());
		columnData.add(getContractDate());
		columnData.add(getFinishDate());
		columnData.add(getTransactionCd());
		columnData.add(getRemarks());
		columnData.add(getStatus());
		columnData.add(getRegDateTime());
		columnData.add(getRegUserId());
		columnData.add(getUpdDateTime());
		columnData.add(getUpdUserId());
		return columnData;
	}
	
	/**
	 * Get all SQL Types of table <BR>
	 * @param Nothing
	 * @return list SQL Types
	 * @exception Nothing
	 */
	public int[] getSqlTypes() {
		return SQLTYPES;
	}

	/**
	 * Get target data <br>
	 * @param Nothing
	 * @return Target data
	 * @exception  Nothing
	 */
	public Target getTarget() {
		return target;
	}

	/**
	 * Reset target for select <br>
	 * @param Nothing
	 * @exception Nothing
	 */
	public void resetTarget() {
		target.reset();
	}
}

