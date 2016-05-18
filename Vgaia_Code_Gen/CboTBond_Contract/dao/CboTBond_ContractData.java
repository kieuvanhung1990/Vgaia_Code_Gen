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
 * CboTBond_ContractData Class's Description. <br>
 * <UL>
 * <LI></LI>
 * </UL>
 * @author: HungKieu 2016/04/19 Create new
 */
public class CboTBond_ContractData
	extends BaseData
	implements CboTBond_ContractConst {
	
	////////// Class Variables //////////
	
	/** Target object data*/
	private CboTBond_ContractTarget target = null;
	
	////////// Class Constructor //////////
		
	/**
	 * Constructor. <br>
	 * Call from base tamplate 
	 * @param Nothing
	 * @exception Nothing
	 */
	public CboTBond_ContractData() {
		super();
		target = new CboTBond_ContractTarget();
		setId((BigDecimal)null);
		setDelCd((BigDecimal)null);
		setContractNo((String)null);
		setContractType((BigDecimal)null);
		setBondCd((String)null);
		setSubAccoCd((BigDecimal)null);
		setQty((BigDecimal)null);
		setAmount((BigDecimal)null);
		setTaxAmt((BigDecimal)null);
		setInterestAmt((BigDecimal)null);
		setPaymentMethod((BigDecimal)null);
		setIntPaymentMethod((BigDecimal)null);
		setContractDate((BigDecimal)null);
		setPaymentCashDate((BigDecimal)null);
		setPaymentSecDate((BigDecimal)null);
		setTransactionCd((String)null);
		setContractSts((BigDecimal)null);
		setStatus((BigDecimal)null);
		setRemarks((String)null);
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
	 * Set ContractType<BR>
	 * @param value ContractType
	 * @exception Nothing
	 */
	public void setContractType(BigDecimal value) {
		items.put(CONTRACT_TYPE, value);
		target.setContractType(true);
	}
	
	/**
	 * Set ContractType from String<BR>
	 * @param value ContractType
	 * @exception Nothing
	 */
	public void setContractTypeSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setContractType(setValue);
	}
	
	/**
	 * Set BondCd<BR>
	 * @param value BondCd
	 * @exception Nothing
	 */
	public void setBondCd(String value) {
		items.put(BOND_CD, value);
		target.setBondCd(true);
	}
	
	
	/**
	 * Set SubAccoCd<BR>
	 * @param value SubAccoCd
	 * @exception Nothing
	 */
	public void setSubAccoCd(BigDecimal value) {
		items.put(SUB_ACCO_CD, value);
		target.setSubAccoCd(true);
	}
	
	/**
	 * Set SubAccoCd from String<BR>
	 * @param value SubAccoCd
	 * @exception Nothing
	 */
	public void setSubAccoCdSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setSubAccoCd(setValue);
	}
	
	/**
	 * Set Qty<BR>
	 * @param value Qty
	 * @exception Nothing
	 */
	public void setQty(BigDecimal value) {
		items.put(QTY, value);
		target.setQty(true);
	}
	
	/**
	 * Set Qty from String<BR>
	 * @param value Qty
	 * @exception Nothing
	 */
	public void setQtySt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setQty(setValue);
	}
	
	/**
	 * Set Amount<BR>
	 * @param value Amount
	 * @exception Nothing
	 */
	public void setAmount(BigDecimal value) {
		items.put(AMOUNT, value);
		target.setAmount(true);
	}
	
	/**
	 * Set Amount from String<BR>
	 * @param value Amount
	 * @exception Nothing
	 */
	public void setAmountSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setAmount(setValue);
	}
	
	/**
	 * Set TaxAmt<BR>
	 * @param value TaxAmt
	 * @exception Nothing
	 */
	public void setTaxAmt(BigDecimal value) {
		items.put(TAX_AMT, value);
		target.setTaxAmt(true);
	}
	
	/**
	 * Set TaxAmt from String<BR>
	 * @param value TaxAmt
	 * @exception Nothing
	 */
	public void setTaxAmtSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setTaxAmt(setValue);
	}
	
	/**
	 * Set InterestAmt<BR>
	 * @param value InterestAmt
	 * @exception Nothing
	 */
	public void setInterestAmt(BigDecimal value) {
		items.put(INTEREST_AMT, value);
		target.setInterestAmt(true);
	}
	
	/**
	 * Set InterestAmt from String<BR>
	 * @param value InterestAmt
	 * @exception Nothing
	 */
	public void setInterestAmtSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setInterestAmt(setValue);
	}
	
	/**
	 * Set PaymentMethod<BR>
	 * @param value PaymentMethod
	 * @exception Nothing
	 */
	public void setPaymentMethod(BigDecimal value) {
		items.put(PAYMENT_METHOD, value);
		target.setPaymentMethod(true);
	}
	
	/**
	 * Set PaymentMethod from String<BR>
	 * @param value PaymentMethod
	 * @exception Nothing
	 */
	public void setPaymentMethodSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setPaymentMethod(setValue);
	}
	
	/**
	 * Set IntPaymentMethod<BR>
	 * @param value IntPaymentMethod
	 * @exception Nothing
	 */
	public void setIntPaymentMethod(BigDecimal value) {
		items.put(INT_PAYMENT_METHOD, value);
		target.setIntPaymentMethod(true);
	}
	
	/**
	 * Set IntPaymentMethod from String<BR>
	 * @param value IntPaymentMethod
	 * @exception Nothing
	 */
	public void setIntPaymentMethodSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setIntPaymentMethod(setValue);
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
	 * Set PaymentCashDate<BR>
	 * @param value PaymentCashDate
	 * @exception Nothing
	 */
	public void setPaymentCashDate(BigDecimal value) {
		items.put(PAYMENT_CASH_DATE, value);
		target.setPaymentCashDate(true);
	}
	
	/**
	 * Set PaymentCashDate from String<BR>
	 * @param value PaymentCashDate
	 * @exception Nothing
	 */
	public void setPaymentCashDateSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setPaymentCashDate(setValue);
	}
	
	/**
	 * Set PaymentSecDate<BR>
	 * @param value PaymentSecDate
	 * @exception Nothing
	 */
	public void setPaymentSecDate(BigDecimal value) {
		items.put(PAYMENT_SEC_DATE, value);
		target.setPaymentSecDate(true);
	}
	
	/**
	 * Set PaymentSecDate from String<BR>
	 * @param value PaymentSecDate
	 * @exception Nothing
	 */
	public void setPaymentSecDateSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setPaymentSecDate(setValue);
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
	 * Set ContractSts<BR>
	 * @param value ContractSts
	 * @exception Nothing
	 */
	public void setContractSts(BigDecimal value) {
		items.put(CONTRACT_STS, value);
		target.setContractSts(true);
	}
	
	/**
	 * Set ContractSts from String<BR>
	 * @param value ContractSts
	 * @exception Nothing
	 */
	public void setContractStsSt(String value) {
		BigDecimal setValue = null;
		if (value != null) {
			try {
				setValue = new BigDecimal(value);
			} catch (NumberFormatException ex) {
				throw new Frw00RuntimeException(
					"Number is not Format");
			}
		}
		setContractSts(setValue);
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
	 * Set Remarks<BR>
	 * @param value Remarks
	 * @exception Nothing
	 */
	public void setRemarks(String value) {
		items.put(REMARKS, value);
		target.setRemarks(true);
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
	 * Get ContractType<BR>
	 * @param Nothing
	 * @return ContractType value
	 * @exception Nothing
	 */
	public BigDecimal getContractType() {
		return (BigDecimal)items.get(CONTRACT_TYPE);
	}
	
	/**
	 * Get ContractType <br>
	 * @param Nothing
	 * @return ContractType String value
	 * @exception Nothing
	 */
	public String getContractTypeSt() {
		if(items.get(CONTRACT_TYPE)!= null){
			return items.get(CONTRACT_TYPE).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get BondCd<BR>
	 * @param Nothing
	 * @return BondCd value
	 * @exception Nothing
	 */
	public String getBondCd() {
		return (String)items.get(BOND_CD);
	}
	
	/**
	 * Get SubAccoCd<BR>
	 * @param Nothing
	 * @return SubAccoCd value
	 * @exception Nothing
	 */
	public BigDecimal getSubAccoCd() {
		return (BigDecimal)items.get(SUB_ACCO_CD);
	}
	
	/**
	 * Get SubAccoCd <br>
	 * @param Nothing
	 * @return SubAccoCd String value
	 * @exception Nothing
	 */
	public String getSubAccoCdSt() {
		if(items.get(SUB_ACCO_CD)!= null){
			return items.get(SUB_ACCO_CD).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get Qty<BR>
	 * @param Nothing
	 * @return Qty value
	 * @exception Nothing
	 */
	public BigDecimal getQty() {
		return (BigDecimal)items.get(QTY);
	}
	
	/**
	 * Get Qty <br>
	 * @param Nothing
	 * @return Qty String value
	 * @exception Nothing
	 */
	public String getQtySt() {
		if(items.get(QTY)!= null){
			return items.get(QTY).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get Amount<BR>
	 * @param Nothing
	 * @return Amount value
	 * @exception Nothing
	 */
	public BigDecimal getAmount() {
		return (BigDecimal)items.get(AMOUNT);
	}
	
	/**
	 * Get Amount <br>
	 * @param Nothing
	 * @return Amount String value
	 * @exception Nothing
	 */
	public String getAmountSt() {
		if(items.get(AMOUNT)!= null){
			return items.get(AMOUNT).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get TaxAmt<BR>
	 * @param Nothing
	 * @return TaxAmt value
	 * @exception Nothing
	 */
	public BigDecimal getTaxAmt() {
		return (BigDecimal)items.get(TAX_AMT);
	}
	
	/**
	 * Get TaxAmt <br>
	 * @param Nothing
	 * @return TaxAmt String value
	 * @exception Nothing
	 */
	public String getTaxAmtSt() {
		if(items.get(TAX_AMT)!= null){
			return items.get(TAX_AMT).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get InterestAmt<BR>
	 * @param Nothing
	 * @return InterestAmt value
	 * @exception Nothing
	 */
	public BigDecimal getInterestAmt() {
		return (BigDecimal)items.get(INTEREST_AMT);
	}
	
	/**
	 * Get InterestAmt <br>
	 * @param Nothing
	 * @return InterestAmt String value
	 * @exception Nothing
	 */
	public String getInterestAmtSt() {
		if(items.get(INTEREST_AMT)!= null){
			return items.get(INTEREST_AMT).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get PaymentMethod<BR>
	 * @param Nothing
	 * @return PaymentMethod value
	 * @exception Nothing
	 */
	public BigDecimal getPaymentMethod() {
		return (BigDecimal)items.get(PAYMENT_METHOD);
	}
	
	/**
	 * Get PaymentMethod <br>
	 * @param Nothing
	 * @return PaymentMethod String value
	 * @exception Nothing
	 */
	public String getPaymentMethodSt() {
		if(items.get(PAYMENT_METHOD)!= null){
			return items.get(PAYMENT_METHOD).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get IntPaymentMethod<BR>
	 * @param Nothing
	 * @return IntPaymentMethod value
	 * @exception Nothing
	 */
	public BigDecimal getIntPaymentMethod() {
		return (BigDecimal)items.get(INT_PAYMENT_METHOD);
	}
	
	/**
	 * Get IntPaymentMethod <br>
	 * @param Nothing
	 * @return IntPaymentMethod String value
	 * @exception Nothing
	 */
	public String getIntPaymentMethodSt() {
		if(items.get(INT_PAYMENT_METHOD)!= null){
			return items.get(INT_PAYMENT_METHOD).toString();
		}else{
			return "";
		}
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
	 * Get PaymentCashDate<BR>
	 * @param Nothing
	 * @return PaymentCashDate value
	 * @exception Nothing
	 */
	public BigDecimal getPaymentCashDate() {
		return (BigDecimal)items.get(PAYMENT_CASH_DATE);
	}
	
	/**
	 * Get PaymentCashDate <br>
	 * @param Nothing
	 * @return PaymentCashDate String value
	 * @exception Nothing
	 */
	public String getPaymentCashDateSt() {
		if(items.get(PAYMENT_CASH_DATE)!= null){
			return items.get(PAYMENT_CASH_DATE).toString();
		}else{
			return "";
		}
	}
	
	/**
	 * Get PaymentSecDate<BR>
	 * @param Nothing
	 * @return PaymentSecDate value
	 * @exception Nothing
	 */
	public BigDecimal getPaymentSecDate() {
		return (BigDecimal)items.get(PAYMENT_SEC_DATE);
	}
	
	/**
	 * Get PaymentSecDate <br>
	 * @param Nothing
	 * @return PaymentSecDate String value
	 * @exception Nothing
	 */
	public String getPaymentSecDateSt() {
		if(items.get(PAYMENT_SEC_DATE)!= null){
			return items.get(PAYMENT_SEC_DATE).toString();
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
	 * Get ContractSts<BR>
	 * @param Nothing
	 * @return ContractSts value
	 * @exception Nothing
	 */
	public BigDecimal getContractSts() {
		return (BigDecimal)items.get(CONTRACT_STS);
	}
	
	/**
	 * Get ContractSts <br>
	 * @param Nothing
	 * @return ContractSts String value
	 * @exception Nothing
	 */
	public String getContractStsSt() {
		if(items.get(CONTRACT_STS)!= null){
			return items.get(CONTRACT_STS).toString();
		}else{
			return "";
		}
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
	 * Get Remarks<BR>
	 * @param Nothing
	 * @return Remarks value
	 * @exception Nothing
	 */
	public String getRemarks() {
		return (String)items.get(REMARKS);
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
		columnData.add(getContractType());
		columnData.add(getBondCd());
		columnData.add(getSubAccoCd());
		columnData.add(getQty());
		columnData.add(getAmount());
		columnData.add(getTaxAmt());
		columnData.add(getInterestAmt());
		columnData.add(getPaymentMethod());
		columnData.add(getIntPaymentMethod());
		columnData.add(getContractDate());
		columnData.add(getPaymentCashDate());
		columnData.add(getPaymentSecDate());
		columnData.add(getTransactionCd());
		columnData.add(getContractSts());
		columnData.add(getStatus());
		columnData.add(getRemarks());
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

