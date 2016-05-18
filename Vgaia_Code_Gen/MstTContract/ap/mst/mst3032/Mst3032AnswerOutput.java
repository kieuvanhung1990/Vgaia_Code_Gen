/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.frw1000.cm.Frw10StringUtil;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.LanguageGetter;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

/**
 * Mst3032AnswerOutput Class's Description. <br>
 * Answer output stage class.
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032AnswerOutput {

	////////// Class Variables //////////
	
	/** Action mode name */
	private String actionModeName = null;
	
	/**
	 * Modify the content of answer and insert into answer component. <br>
	 * 
	 * @param ctx Context the contextual of MstTContract
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
		Mst3032Context context = (Mst3032Context) ctx;
		
		// Get Response data
		Mst3032ResultData resultData = context.getResultData();
		
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
				LanguageGetter.getProperty("Mst3032Panel_lblId"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getId(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractNo
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblContractNo"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getContractNo(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractTypeId
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblContractTypeId"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getContractTypeId(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractName
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblContractName"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getContractName(),
				DATA_WIDTH_COL1, ' '));
		
		// Company
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblCompany"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getCompany(),
				DATA_WIDTH_COL1, ' '));
		
		// Tel
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblTel"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getTel(),
				DATA_WIDTH_COL1, ' '));
		
		// Address
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblAddress"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getAddress(),
				DATA_WIDTH_COL1, ' '));
		
		// RepresentName
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblRepresentName"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getRepresentName(),
				DATA_WIDTH_COL1, ' '));
		
		// RepresentId
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblRepresentId"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getRepresentId(),
				DATA_WIDTH_COL1, ' '));
		
		// ContractDate
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblContractDate"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getContractDate(),
				DATA_WIDTH_COL1, ' '));
		
		// FinishDate
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblFinishDate"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getFinishDate(),
				DATA_WIDTH_COL1, ' '));
		
		// TransactionCd
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblTransactionCd"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getTransactionCd(),
				DATA_WIDTH_COL1, ' '));
		
		// Remarks
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblRemarks"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPad(resultData.getRemarks(),
				DATA_WIDTH_COL1, ' '));
		
		// Status
		answer.append("\n");
		answer.append(Frw10StringUtil.rightPadByte(
				LanguageGetter.getProperty("Mst3032Panel_lblStatus"), TITLE_WIDTH_COL1, ' '));
		answer.append(CommonHelper.rightPadByteNumber(resultData.getStatus(),
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
