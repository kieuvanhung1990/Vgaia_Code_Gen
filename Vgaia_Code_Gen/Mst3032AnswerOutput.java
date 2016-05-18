/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.okasan.ap.cmn.APHelper;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;
import jp.co.okasan.cm.mst.mst3032.Mst3032_01RowData;
import jp.co.okasan.cm.mst.mst3032.Mst3032_02RowData;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ans.AnswerCell;
import jp.co.okasan.cmn.ans.AnswerTable02;
import jp.co.okasan.dao.MstTBranchData;
import jp.co.okasan.dao.MstTContract_TypeData;

/**
 * Mst3032AnswerOutput Class's Description. <br>
 * Answer output stage class.
 * 
 * @author: HoaNP 2015/01/09 Create New
 */
public class Mst3032AnswerOutput {

	// //////// Class Variables //////////

	/**
	 * Modify the content of answer and insert into answer component. <br>
	 * 
	 * @param ctx
	 *            Context the contextual of MstTContract
	 * @exception SQLException
	 */
	public void doTask(Context ctx) throws SQLException {

		// Context
		Mst3032Context context = (Mst3032Context) ctx;

		// Get Response data
		Mst3032ResultData resultData = context.getResultData();

		// ///// Table in main tab /////////////////////

		// Initial table Answer
		AnswerTable02 table = new AnswerTable02();

		// Header
		// Action Mode
		table.newHeaderRow().newLabelValueCellHeader("MODE",
				CommonHelper.getActionModeDisplay(resultData.getActionMode()));

		// ID
		table.newHeaderRow().newLabelValueCellHeader("Mst3032Panel_lblId",
				resultData.getId());

		// Add boby of main tab

		String contractTypeName = "";
		MstTContract_TypeData contractTypeData = context.getContractTypeData();
		if (contractTypeData == null) {
			contractTypeData = new MstTContract_TypeFinder()
					.findData(resultData.getContractTypeId());
		}

		if (contractTypeData != null) {
			contractTypeName = contractTypeData.getTypeName();
		}

		// Row 1
		table.newBodyRow()
				.newLabelValueCellBody("Mst3032Panel_lblContractTypeId",
						contractTypeName)
				.newLabelValueCellBody("Mst3032Panel_lblContractNo",
						resultData.getContractNo());

		// Row 02
		table.newBodyRow()
				.newLabelValueCellBodyColspan("Mst3032Panel_lblContractName",
						resultData.getContractName(), 2);

		MstTBranchData transData = APHelper.getTransactionData(resultData
				.getTransactionCd());
		String transName = transData.getBranchSname();

		// Row03
		table.newBodyRow()
				.newLabelValueCellBody("Mst3032Panel_lblCompany",
						resultData.getCompany())
				.newLabelValueCellBody("Mst3032Panel_lblTransactionCd",
						transName);

		// Row04
		table.newBodyRow()
				.newLabelValueCellBody("Mst3032Panel_lblTel",
						resultData.getTel())
				.newLabelValueCellBody("Mst3032Panel_lblAddress",
						resultData.getAddress());

		// New row
		table.newBodyRow()
				.newLabelValueCellBody("Mst3032Panel_lblRepresentName",
						resultData.getRepresentName())
				.newLabelValueCellBody("Mst3032Panel_lblRepresentId",
						resultData.getRepresentId());

		// New row
		table.newBodyRow()
				.newLabelValueCellBody("Mst3032Panel_lblContractDate",
						resultData.getContractDate(), AnswerCell.DATE)
				.newLabelValueCellBody("Mst3032Panel_lblFinishDate",
						resultData.getFinishDate(), AnswerCell.DATE);

		// /////// Table in tab 01 //////////////
		List<?> dataList01 = new ArrayList<>();

		if (resultData.getActionMode().equals(ConstantValues.MODE_DELETE)) {
			dataList01 = context.getDisplayData01();
		} else {
			dataList01 = new MstTContract_DetailFinder().findListDetail(
					resultData.getId(), resultData.getActionMode());
		}

		if (dataList01 != null && dataList01.size() > 0) {
			// Create new tabGrid;
			table.newTabGrid();

			table.getTabGrid().setTitleGrid("Mst3032Panel_lblDetailGroup");
			// Add header
			table.getTabGrid().newHeaderGrid("Mst3032Panel_FieldCodeCol",
					"Mst3032Panel_ValueCol", "Mst3033Panel_FieldTypeCol",
					"Mst3033Panel_SeqNoCol", "Mst3033Panel_RemarkCol");

			Iterator<?> iter = dataList01.iterator();
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				Mst3032_01RowData rowData = Mst3032_01RowData
						.getMst3032_01RowData(obj);

				table.getTabGrid().newBodyRow()
						.newBodyCell(rowData.getFieldCode())
						.newBodyCell(rowData.getFieldTypeDisp())
						.newBodyCell(rowData.getValue())
						.newBodyCell(rowData.getSeqNo())
						.newBodyCell(rowData.getRemarks());
			}

			// Set table column width
			table.getTabGrid().addWidthColumn(100, 150, 200);
		}

		// ////// Table in tab 02 /////////////
		List<?> dataList02 = new ArrayList<>();

		if (resultData.getActionMode().equals(ConstantValues.MODE_DELETE)) {
			dataList02 = context.getDisplayData02();
		} else {
			dataList02 = new MstTContract_AttachFinder01().findDataList(
					resultData.getId(), resultData.getActionMode());
		}

		if (dataList02 != null && dataList02.size() > 0) {
			// Create new tabGrid;
			table.newTabGrid();

			table.getTabGrid().setTitleGrid("Mst3032Panel_lblAttachGroup");

			// Add header
			table.getTabGrid().newHeaderGrid("Mst3032Panel_NameCol",
					"Mst3032Panel_FileNameCol", "Mst3033Panel_RemarkCol");

			Iterator<?> iter = dataList02.iterator();
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				Mst3032_02RowData rowData = Mst3032_02RowData
						.getMst3032_02RowData(obj);

				table.getTabGrid().newBodyRow().newBodyCell(rowData.getName())
						.newBodyCell(rowData.getFileName())
						.newBodyCell(rowData.getRemarks());
			}

			// Set table column width
			table.getTabGrid().addWidthColumn(200, 200, 300);
		}

		// Footer
		// Register
		String registered = resultData.getRegDateTime() + "   "
				+ resultData.getRegUserId();
		table.newFooterRow().newLabelValueCellFooterColspan("REGISTERED",
				registered, 2);
		// Updater
		String updated = resultData.getUpdDateTime() + "   "
				+ resultData.getUpdUserId();
		table.newFooterRow().newLabelValueCellFooterColspan("UPDATED", updated,
				2);

		// Set table column width
		table.addWidthColumn(150, 200, 150, 250);

		// Set answer content result to context class
		context.setAnswerContent(table.getTableString());
	}
}