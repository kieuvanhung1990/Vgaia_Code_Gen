/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.cm.cbo.cbo5906;

import java.util.HashMap;

import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ItemValidator;

/**
* 59065906Row data for grid. <br>
* <p>
*  Row data class of CboTBond_Contract.
* </p>
* Set and Get data of screen component.
*
* @author: HungKieu 2016/04/19 Create New
*/
public class Cbo5906RowData  {
	
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
	
	/** Contract Type Column */
	public static final int ContractTypeCol = 4;
	
	/** Bond Cd Column */
	public static final int BondCdCol = 4;
	
	/** Sub Acco Cd Column */
	public static final int SubAccoCdCol = 4;
	
	/** Qty Column */
	public static final int QtyCol = 4;
	
	/** Amount Column */
	public static final int AmountCol = 4;
	
	/** Tax Amt Column */
	public static final int TaxAmtCol = 4;
	
	/** Interest Amt Column */
	public static final int InterestAmtCol = 4;
	
	/** Payment Method Column */
	public static final int PaymentMethodCol = 4;
	
	/** Int Payment Method Column */
	public static final int IntPaymentMethodCol = 4;
	
	/** Contract Date Column */
	public static final int ContractDateCol = 4;
	
	/** Payment Cash Date Column */
	public static final int PaymentCashDateCol = 4;
	
	/** Payment Sec Date Column */
	public static final int PaymentSecDateCol = 4;
	
	/** Transaction Cd Column */
	public static final int TransactionCdCol = 4;
	
	/** Contract Sts Column */
	public static final int ContractStsCol = 4;
	
	/** Status Column */
	public static final int StatusCol = 4;
	
	/** Remarks Column */
	public static final int RemarksCol = 4;
	
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
	
	
	
	
	////////// Class Methods //////////
	
	/**
	 * Get RowData from Row data in Table
	 * 
	 * @return Cbo5906RowData
	 */
	public static Cbo5906RowData getCbo5906RowData(Object[] row) {
		Cbo5906RowData obj = new Cbo5906RowData();
		
		if (row[SelectionCol] != null) {
			obj.setSelect(Boolean.valueOf(row[SelectionCol].toString()));
		}
		
		obj.setUpdateFlg(CommonHelper.getStringFromObject(row[UpdateFlagCol]));
		obj.setErrorFlag(CommonHelper.getStringFromObject(row[ErrorFlagCol]));
		obj.setTimeStamp(CommonHelper.getStringFromObject(row[TimeStampCol]));

		obj.setId(CommonHelper.getStringFromObject(row[IdCol]));
		obj.setDelCd(CommonHelper.getStringFromObject(row[DelCdCol]));
		obj.setContractNo(CommonHelper.getStringFromObject(row[ContractNoCol]));
		obj.setContractType(CommonHelper.getStringFromObject(row[ContractTypeCol]));
		obj.setBondCd(CommonHelper.getStringFromObject(row[BondCdCol]));
		obj.setSubAccoCd(CommonHelper.getStringFromObject(row[SubAccoCdCol]));
		obj.setQty(CommonHelper.getStringFromObject(row[QtyCol]));
		obj.setAmount(CommonHelper.getStringFromObject(row[AmountCol]));
		obj.setTaxAmt(CommonHelper.getStringFromObject(row[TaxAmtCol]));
		obj.setInterestAmt(CommonHelper.getStringFromObject(row[InterestAmtCol]));
		obj.setPaymentMethod(CommonHelper.getStringFromObject(row[PaymentMethodCol]));
		obj.setIntPaymentMethod(CommonHelper.getStringFromObject(row[IntPaymentMethodCol]));
		obj.setContractDate(CommonHelper.getStringFromObject(row[ContractDateCol]));
		obj.setPaymentCashDate(CommonHelper.getStringFromObject(row[PaymentCashDateCol]));
		obj.setPaymentSecDate(CommonHelper.getStringFromObject(row[PaymentSecDateCol]));
		obj.setTransactionCd(CommonHelper.getStringFromObject(row[TransactionCdCol]));
		obj.setContractSts(CommonHelper.getStringFromObject(row[ContractStsCol]));
		obj.setStatus(CommonHelper.getStringFromObject(row[StatusCol]));
		obj.setRemarks(CommonHelper.getStringFromObject(row[RemarksCol]));
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
	public HashMap<String, Object> getCbo5906RowDataHashMap() {

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
		hashMap.put(String.valueOf(ContractTypeCol), this.getContractType());
		hashMap.put(String.valueOf(BondCdCol), this.getBondCd());
		hashMap.put(String.valueOf(SubAccoCdCol), this.getSubAccoCd());
		hashMap.put(String.valueOf(QtyCol), this.getQty());
		hashMap.put(String.valueOf(AmountCol), this.getAmount());
		hashMap.put(String.valueOf(TaxAmtCol), this.getTaxAmt());
		hashMap.put(String.valueOf(InterestAmtCol), this.getInterestAmt());
		hashMap.put(String.valueOf(PaymentMethodCol), this.getPaymentMethod());
		hashMap.put(String.valueOf(IntPaymentMethodCol), this.getIntPaymentMethod());
		hashMap.put(String.valueOf(ContractDateCol), this.getContractDate());
		hashMap.put(String.valueOf(PaymentCashDateCol), this.getPaymentCashDate());
		hashMap.put(String.valueOf(PaymentSecDateCol), this.getPaymentSecDate());
		hashMap.put(String.valueOf(TransactionCdCol), this.getTransactionCd());
		hashMap.put(String.valueOf(ContractStsCol), this.getContractSts());
		hashMap.put(String.valueOf(StatusCol), this.getStatus());
		hashMap.put(String.valueOf(RemarksCol), this.getRemarks());
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

