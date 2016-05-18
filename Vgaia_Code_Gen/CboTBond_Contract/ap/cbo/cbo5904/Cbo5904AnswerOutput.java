/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.cbo.cbo5904;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.frw1000.cm.Frw10StringUtil;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.LanguageGetter;
import jp.co.okasan.cm.cbo.cbo5904.Cbo5904ResultData;

/**
 * Cbo5904AnswerOutput Class's Description. <br>
 * Answer output stage class.
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Cbo5904AnswerOutput {

	////////// Class Variables //////////
	
	/** Action mode name */
	private String actionModeName = null;
	
	/**
	 * Modify the content of answer and insert into answer component. <br>
	 * 
	 * @param ctx Context the contextual of CboTBond_Contract
	 * @exception SQLException
	 */
	public void doTask(Context ctx) throws SQLException {
		
		// Max title width column 1
		final int TITLE_WIDTH_COL1 = 20;

		// Max data width column 1
		final int DATA_WIDTH_COL1 = 20;

		
		// Create buffer for answer content
		StringBuffer answer = new StringBuffer();
		
		// Context
		Cbo5904Context context = (Cbo5904Context) ctx;
		
		// Get Response data
		Cbo5904ResultData resultData = context.getResultData();
		
		// Settings of ActionMode
		actionModeName = CommonHelper.getActionModeDisplay(resultData.getActionMode());
		
		// Mode
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("MODE"), TITLE_WIDTH_COL1, ' '));
		answer.append(resultData.getActionMode());
		answer.append(" : ");
		answer.append(actionModeName);
		
		
		// Id
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblId"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getId(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractNo
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblContractNo"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getContractNo(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractType
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblContractType"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getContractType(),
				DATA_WIDTH_COL1, ' '));
		
		// BondCd
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblBondCd"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getBondCd(),
				DATA_WIDTH_COL1, ' '));
		
		// SubAccoCd
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblSubAccoCd"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getSubAccoCd(),
				DATA_WIDTH_COL1, ' '));
		
		// Qty
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblQty"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getQty(),
				DATA_WIDTH_COL1, ' '));
		
		// Amount
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblAmount"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getAmount(),
				DATA_WIDTH_COL1, ' '));
		
		// TaxAmt
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblTaxAmt"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getTaxAmt(),
				DATA_WIDTH_COL1, ' '));
		
		// InterestAmt
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblInterestAmt"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getInterestAmt(),
				DATA_WIDTH_COL1, ' '));
		
		// PaymentMethod
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblPaymentMethod"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getPaymentMethod(),
				DATA_WIDTH_COL1, ' '));
		
		// IntPaymentMethod
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblIntPaymentMethod"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getIntPaymentMethod(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractDate
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblContractDate"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getContractDate(),
				DATA_WIDTH_COL1, ' '));
		
		// PaymentCashDate
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblPaymentCashDate"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getPaymentCashDate(),
				DATA_WIDTH_COL1, ' '));
		
		// PaymentSecDate
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblPaymentSecDate"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getPaymentSecDate(),
				DATA_WIDTH_COL1, ' '));
		
		// TransactionCd
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblTransactionCd"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getTransactionCd(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractSts
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblContractSts"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getContractSts(),
				DATA_WIDTH_COL1, ' '));
		
		// Status
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblStatus"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getStatus(),
				DATA_WIDTH_COL1, ' '));
		
		// Remarks
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Cbo5904Panel_lblRemarks"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getRemarks(),
				DATA_WIDTH_COL1, ' '));
		
		answer.append("\n\n");
		answer.append(CommonHelper.rightPadByte("REGISTERED", TITLE_WIDTH_COL1));
		answer.append(resultData.getRegDateTime());

		answer.append("   ");
		answer.append(resultData.getRegUserId());

		answer.append("\n");
		answer.append(CommonHelper.rightPadByte("UPDATED", TITLE_WIDTH_COL1));
		answer.append(resultData.getUpdDateTime());

		answer.append("   ");
		answer.append(resultData.getUpdUserId());
		
		answer.append("\n\n");
		answer.append(" --------- End Of Data ---------");

		// Set answer content result to context class
        context.setAnswerContent(answer.toString());
	}
}
