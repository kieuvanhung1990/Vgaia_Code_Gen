/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3033;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.okasan.cm.mst.mst3033.Mst3033ResultData;
import jp.co.okasan.cm.mst.mst3033.Mst3033_01RowData;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.ans.AnswerCell;
import jp.co.okasan.cmn.ans.AnswerTable02;

/**
 * Mst3033AnswerOutput Class's Description. <br>
 * Answer output stage class.
 * 
 * @author: HoaNP 2015/01/15 Create New
 */
public class Mst3033AnswerOutput {

	// //////// Class Variables //////////

	/**
	 * Modify the content of answer and insert into answer component. <br>
	 * 
	 * @param ctx
	 *            Context the contextual of MstTContract_Type
	 * @exception SQLException
	 */
	public void doTask(Context ctx) throws SQLException {

		// Context
		Mst3033Context context = (Mst3033Context) ctx;

		// Get Response data
		Mst3033ResultData resultData = context.getResultData();

		// ///// Table in main tab /////////////////////

		// Initial table Answer
		AnswerTable02 table = new AnswerTable02();

		// Header
		// Action Mode
		table.newHeaderRow().newLabelValueCellHeader("MODE",
				CommonHelper.getActionModeDisplay(resultData.getActionMode()));

		// ID
		table.newHeaderRow().newLabelValueCellHeader("Mst3033Panel_lblId",
				resultData.getId());

		// Add boby of main tab

		// Row 1
		table.newBodyRow().newLabelValueCellBody("Mst3033Panel_lblTypeName",
				resultData.getTypeName());

		// New row
		table.newBodyRow().newLabelValueCellBody("Mst3033Panel_lblRemarks",
				resultData.getRemarks());

		// /////// Table in tab 01 //////////////
		List<?> dataList01 = new ArrayList<>();

		if (resultData.getActionMode().equals(ConstantValues.MODE_DELETE)) {
			dataList01 = context.getDisplayData01();
		} else {
			dataList01 = new MstTContract_ParamFinder().findListParam(
					resultData.getId(), resultData.getActionMode());
		}

		if (dataList01 != null && dataList01.size() > 0) {
			// Create new tabGrid;
			table.newTabGrid();

			table.getTabGrid().setTitleGrid("Mst3033Panel_lblSubPanel");
			// Add header
			table.getTabGrid().newHeaderGrid("Mst3033Panel_FieldCodeCol",
					"Mst3033Panel_FieldNameCol", "Mst3033Panel_FieldTypeCol",
					"Mst3033Panel_SeqNoCol", "Mst3033Panel_lblStatus",
					"Mst3033Panel_RemarkCol");

			Iterator<?> iter = dataList01.iterator();
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				Mst3033_01RowData rowData = Mst3033_01RowData
						.getMst3033_01RowData(obj);

				table.getTabGrid().newBodyRow()
						.newBodyCell(rowData.getFieldCode())
						.newBodyCell(rowData.getFieldName())
						.newBodyCell(rowData.getFieldTypeDisplay())
						.newBodyCell(rowData.getSeqNo(), AnswerCell.NUMBER)
						.newBodyCell(rowData.getStatusDisp())
						.newBodyCell(rowData.getRemarks());
			}

			// Set table column width
			table.getTabGrid().addWidthColumn(50, 150, 150, 50, 120);
		}

		// ////////////////Footer /////////////////////

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
		table.addWidthColumn(150);

		// Set answer content result to context class
		context.setAnswerContent(table.getTableString());
	}
}
