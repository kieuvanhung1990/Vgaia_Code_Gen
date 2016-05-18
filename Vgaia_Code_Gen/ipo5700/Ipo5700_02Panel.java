/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.pr.ipo.ipo5700;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.pr.view.Frw00BaseTemplateFrame;
import jp.co.nec.frw0000.pr.view.Frw00ClientPanel;
import jp.co.nec.frw1000.pr.clcommon.Frw10ClientException;
import jp.co.nec.frw1000.pr.clcommon.Frw10WindowDataProc;
import jp.co.nec.frw1000.pr.component.event.RowListener;
import jp.co.okasan.cm.ipo.ipo5700.Ipo5700_02RowData;
import jp.co.okasan.cmn.ComboInfoGetter;
import jp.co.okasan.cmn.CommonHelper;
import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cmn.TableCheckBoxRenderer;
import jp.co.okasan.cmn.constant.InsertNullItemType;
import jp.co.okasan.cmn.constant.gui.ComboInfo;
import jp.co.okasan.cmn.constant.ipo.IpoTInfo_Roles_Status;
import jp.co.okasan.frw.pr.MUIAddButton;
import jp.co.okasan.frw.pr.MUIComboBox;
import jp.co.okasan.frw.pr.MUIHalfWidthTextField;
import jp.co.okasan.frw.pr.MUILabel;
import jp.co.okasan.frw.pr.MUIQuantityTextField;
import jp.co.okasan.frw.pr.MUIResetButton;
import jp.co.okasan.frw.pr.MUITableColumn;
import jp.co.okasan.frw.pr.UIHalfWidthTextField2;
import jp.co.okasan.frw.pr.UITable2;

/**
 * Ipo5700_02Panel Class's Description<br>
 * <P>
 * Client area class.
 * </p>
 * 
 * @author: HungKieu 2016/03/22 Create New
 */
public class Ipo5700_02Panel extends Frw00ClientPanel {

	// //////// Class Variables //////////

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Index on tab */
	public static int INDEX_ON_TAB = 1;

	/** Is Success: Use Add And Update */
	private boolean success = false;

	/* refer to parent */
	Ipo5700Panel parentPanel;

	/** Cust Type label */
	MUILabel lblCustType = null;

	/** Foreign Type label */
	MUILabel lblForeignType = null;

	/** Min Qty label */
	MUILabel lblMinQty = null;

	/** Max Qty label */
	MUILabel lblMaxQty = null;

	/** Status label */
	MUILabel lblStatus = null;

	/** Remarks label */
	MUILabel lblRemarks = null;

	/** CustType TextField */
	MUIComboBox cboCustType = null;

	/** ForeignType TextField */
	MUIComboBox cboForeignType = null;

	/** Min Qty TextField */
	MUIQuantityTextField txtMinQty = null;

	/** Max Qty TextField */
	MUIQuantityTextField txtMaxQty = null;

	/** Remarks TextField */
	MUIHalfWidthTextField txtRemarks = null;

	/** UpdateFlg */
	UIHalfWidthTextField2 txtUpdateFlg = null;

	/** add button */
	MUIAddButton btnAdd = null;

	/** Update button */
	MUIAddButton btnUpdate = null;

	/** reset button */
	MUIResetButton btnReset = null;

	/** Table */
	UITable2 tblDataList = null;

	/** ScrollPane */
	JScrollPane jScrollPane = null;

	/** Result data original LIST */
	private List<?> originList = null;

	/** Not Run Select Row */
	private boolean notRunSelectRow = false;

	/**
	 * @return the originList
	 */
	public List<?> getOriginList() {
		return originList;
	}

	/**
	 * @param originList
	 *            the originList to set
	 */
	public void setOriginList(List<?> originList) {
		this.originList = originList;
	}

	/**
	 * Adapter For Actions Of Table
	 * 
	 * @author HungKieu
	 * 
	 */
	private class Ipo5700_02Panel_RowAdapter implements RowListener {

		/** Ipo5700_02Panel adapter */
		Ipo5700_02Panel adapter;

		Ipo5700_02Panel_RowAdapter(Ipo5700_02Panel adapter) {
			this.adapter = adapter;
		}

		public void rowSelected(ListSelectionEvent e) {
			try {
				adapter.tblDataList_rowSelected(e);
			} catch (Frw10ClientException e1) {
				e1.printStackTrace();
				jp.co.okasan.pr.cmn.CommonHelper.showError(adapter,
						e1.getMessage());
			}
		}

		public void rowAdded(ActionEvent e) {
			try {
				adapter.tblDataList_rowAdded(e);
			} catch (Frw10ClientException e1) {
				e1.printStackTrace();
				jp.co.okasan.pr.cmn.CommonHelper.showError(adapter,
						e1.getMessage());
			}
		}

		public void rowUpdated(ActionEvent e) {
			try {
				adapter.tblDataList_rowUpdated(e);
			} catch (Frw10ClientException e1) {
				e1.printStackTrace();
				jp.co.okasan.pr.cmn.CommonHelper.showError(adapter,
						e1.getMessage());
			}
		}
	}

	// //////// Methods define //////////

	/**
	 * Constructor <br>
	 * Call constructor base template.
	 * 
	 * @param Nothing
	 * @exception
	 */
	public Ipo5700_02Panel() {
		super();

		try {
			// Initial control
			jbInit();
		} catch (Exception e) {
			// Show error dialog
			showErrorDialog(e, true);
		}
	}

	/**
	 * Method show data<br>
	 * 
	 * @param dataList
	 *            HashMap
	 * @exception Frw10ClientException
	 */
	@SuppressWarnings("rawtypes")
	public void showData(HashMap dataList) throws Frw10ClientException {
		// Set window data
		Frw10WindowDataProc.setWindowData(this, dataList);
	}

	/**
	 * Method create instance of screen's component <br>
	 * 
	 * @param Nothing
	 * @exception Exception
	 */
	private void jbInit() throws Exception {

		/** Update Flag */
		txtUpdateFlg = new UIHalfWidthTextField2();
		txtUpdateFlg.setBounds(new Rectangle(500, 25, 30, 20));
		txtUpdateFlg.setPartsName("updateFlag02");
		txtUpdateFlg.setVisible(false);
		this.add(txtUpdateFlg);

		/** width of label */
		final int lblWidthCol1 = 60;

		/** Location x of editor */
		int xOfEditorCol1 = lblWidthCol1 + 50;

		int y = 15;

		// Cust Type Label
		lblCustType = new MUILabel();
		lblCustType.setOpaque(false);
		lblCustType.setText("Ipo5700Panel_lblCustType");
		lblCustType.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblCustType);

		// Cust Type TextField
		cboCustType = new MUIComboBox(ComboInfo.IPOTINFO_CUST_TYPE,
				InsertNullItemType.NONE, "", "");
		cboCustType.setBounds(new Rectangle(xOfEditorCol1, y, 75, 20));
		cboCustType.setPartsName("custType");
		this.add(cboCustType);

		y += 25;

		// Min quantity Label
		lblMinQty = new MUILabel();
		lblMinQty.setOpaque(false);
		lblMinQty.setText("Ipo5700Panel_lblMinQty");
		lblMinQty.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblMinQty);

		// Min Quantity TextField
		txtMinQty = new MUIQuantityTextField();
		txtMinQty.setLocation(xOfEditorCol1, y);
		txtMinQty.setPartsName("minQty");
		this.add(txtMinQty);

		y += 25;

		// Remarks Label
		lblRemarks = new MUILabel();
		lblRemarks.setOpaque(false);
		lblRemarks.setText("Ipo5700Panel_lblRemarks");
		lblRemarks.setBounds(new Rectangle(25, y, lblWidthCol1, 20));
		this.add(lblRemarks);

		// Remarks TextField
		txtRemarks = new MUIHalfWidthTextField();
		txtRemarks.setMaxLength(200);
		txtRemarks.setBounds(new Rectangle(xOfEditorCol1, y, 600, 20));
		txtRemarks.setAlphabetUpper(false);
		txtRemarks.setPartsName("remarks02");
		this.add(txtRemarks);

		// Define column 2
		int xOfLabelCol2 = txtMinQty.getX() + txtMinQty.getWidth() + 50;
		int lblWidthCol2 = 75;
		int xOfEditorCol2 = xOfLabelCol2 + lblWidthCol2 + 25;

		// ForeignType Label
		lblForeignType = new MUILabel();
		lblForeignType.setOpaque(false);
		lblForeignType.setText("Ipo5700Panel_lblForeignType");
		lblForeignType.setBounds(new Rectangle(xOfLabelCol2,
				cboCustType.getY(), lblWidthCol2, 20));
		this.add(lblForeignType);

		// ForeignType TextField
		cboForeignType = new MUIComboBox(ComboInfo.IPOTINFO_FOREIGN_TYPE,
				InsertNullItemType.NONE, "", "");
		cboForeignType.setBounds(xOfEditorCol2, cboCustType.getY(), 90, 20);
		cboForeignType.setPartsName("foreignType");
		this.add(cboForeignType);

		// MaxQty Label
		lblMaxQty = new MUILabel();
		lblMaxQty.setOpaque(false);
		lblMaxQty.setText("Ipo5700Panel_lblMaxQty");
		lblMaxQty.setBounds(new Rectangle(xOfLabelCol2, txtMinQty.getY(),
				lblWidthCol2, 20));
		this.add(lblMaxQty);

		// MaxQty TextField
		txtMaxQty = new MUIQuantityTextField();
		txtMaxQty.setLocation(xOfEditorCol2, txtMinQty.getY());
		txtMaxQty.setPartsName("maxQty");
		this.add(txtMaxQty);

		// Declare Columns
		MUITableColumn column[] = { new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn(),
				new MUITableColumn(), new MUITableColumn() };

		// Column Delete
		column[Ipo5700_02RowData.SelectionCol]
				.setColumnName("Ipo5700Panel_Del");
		column[Ipo5700_02RowData.SelectionCol].setWidth(35);
		column[Ipo5700_02RowData.SelectionCol].setColumnClass(Boolean.class);
		column[Ipo5700_02RowData.SelectionCol]
				.setCellRenderer(TableCheckBoxRenderer
						.getHorizontalCenterRenderer());

		// Column Update Flag - Hidden
		column[Ipo5700_02RowData.UpdateFlagCol].setColumnName("<UpdateFlg>");
		column[Ipo5700_02RowData.UpdateFlagCol].setWidth(45);
		column[Ipo5700_02RowData.UpdateFlagCol].setVisible(false);
		column[Ipo5700_02RowData.UpdateFlagCol].setColumnClass(String.class);

		// Column Error Flag - Hidden
		column[Ipo5700_02RowData.ErrorFlagCol].setColumnName("<ErrorFlg>");
		column[Ipo5700_02RowData.ErrorFlagCol].setVisible(false);
		column[Ipo5700_02RowData.ErrorFlagCol].setWidth(45);
		column[Ipo5700_02RowData.ErrorFlagCol].setColumnClass(String.class);

		// Column time stamp - Hidden
		column[Ipo5700_02RowData.TimeStampCol].setColumnName("<timestamp>");
		column[Ipo5700_02RowData.TimeStampCol].setVisible(false);
		column[Ipo5700_02RowData.TimeStampCol].setWidth(45);
		column[Ipo5700_02RowData.TimeStampCol].setColumnClass(String.class);

		// Cust type column
		column[Ipo5700_02RowData.CustTypeDispCol]
				.setColumnName("Ipo5700Panel_lblCustType");
		column[Ipo5700_02RowData.CustTypeDispCol].setWidth(85);
		column[Ipo5700_02RowData.CustTypeDispCol].setColumnClass(String.class);

		// Foreign type column
		column[Ipo5700_02RowData.ForeignTypeDispCol]
				.setColumnName("Ipo5700Panel_lblForeignType");
		column[Ipo5700_02RowData.ForeignTypeDispCol].setWidth(105);
		column[Ipo5700_02RowData.ForeignTypeDispCol]
				.setColumnClass(String.class);

		// MinQty column
		column[Ipo5700_02RowData.MinQtyCol]
				.setColumnName("Ipo5700Panel_lblMinQty");
		column[Ipo5700_02RowData.MinQtyCol].setWidth(110);
		column[Ipo5700_02RowData.MinQtyCol].setColumnClass(BigDecimal.class);

		// MaxQty column
		column[Ipo5700_02RowData.MaxQtyCol]
				.setColumnName("Ipo5700Panel_lblMaxQty");
		column[Ipo5700_02RowData.MaxQtyCol].setWidth(110);
		column[Ipo5700_02RowData.MaxQtyCol].setColumnClass(BigDecimal.class);

		// statusDisplay column
		column[Ipo5700_02RowData.StatusDispCol]
				.setColumnName("Ipo5700Panel_lblStatus");
		column[Ipo5700_02RowData.StatusDispCol].setWidth(100);
		column[Ipo5700_02RowData.StatusDispCol].setColumnClass(String.class);

		// Remarks column
		column[Ipo5700_02RowData.RemarksCol]
				.setColumnName("Ipo5700Panel_lblRemarks");
		column[Ipo5700_02RowData.RemarksCol].setWidth(200);
		column[Ipo5700_02RowData.RemarksCol].setColumnClass(String.class);

		// Column RegUserId
		column[Ipo5700_02RowData.RegUserCol]
				.setColumnName("Ipo5700Panel_lblRegUserId");
		column[Ipo5700_02RowData.RegUserCol].setWidth(100);
		column[Ipo5700_02RowData.RegUserCol].setColumnClass(String.class);

		// Column RegTime
		column[Ipo5700_02RowData.RegTimeCol]
				.setColumnName("Ipo5700Panel_lblRegTime");
		column[Ipo5700_02RowData.RegTimeCol].setWidth(120);
		column[Ipo5700_02RowData.RegTimeCol].setColumnClass(String.class);

		// Column UpdUserId
		column[Ipo5700_02RowData.UpdUserCol]
				.setColumnName("Ipo5700Panel_lblUpdUserId");
		column[Ipo5700_02RowData.UpdUserCol].setWidth(110);
		column[Ipo5700_02RowData.UpdUserCol].setColumnClass(String.class);

		// Column UpdTime
		column[Ipo5700_02RowData.UpdTimeCol]
				.setColumnName("Ipo5700Panel_lblUpdTime");
		column[Ipo5700_02RowData.UpdTimeCol].setWidth(120);
		column[Ipo5700_02RowData.UpdTimeCol].setColumnClass(String.class);

		// Column id
		column[Ipo5700_02RowData.IdCol].setColumnName("Ipo5700Panel_lblId");
		column[Ipo5700_02RowData.IdCol].setVisible(false);
		column[Ipo5700_02RowData.IdCol].setWidth(120);
		column[Ipo5700_02RowData.IdCol].setColumnClass(String.class);

		// Column status
		column[Ipo5700_02RowData.StatusCol]
				.setColumnName("Ipo5700Panel_lblStatus");
		column[Ipo5700_02RowData.StatusCol].setVisible(false);
		column[Ipo5700_02RowData.StatusCol].setWidth(120);
		column[Ipo5700_02RowData.StatusCol].setColumnClass(String.class);

		// Column cust type
		column[Ipo5700_02RowData.CustTypeCol]
				.setColumnName("Ipo5700Panel_lblCustType");
		column[Ipo5700_02RowData.CustTypeCol].setVisible(false);
		column[Ipo5700_02RowData.CustTypeCol].setWidth(120);
		column[Ipo5700_02RowData.CustTypeCol].setColumnClass(String.class);

		// Column ForeignTypeCol
		column[Ipo5700_02RowData.ForeignTypeCol]
				.setColumnName("Ipo5700Panel_lblForeignType");
		column[Ipo5700_02RowData.ForeignTypeCol].setVisible(false);
		column[Ipo5700_02RowData.ForeignTypeCol].setWidth(120);
		column[Ipo5700_02RowData.ForeignTypeCol].setColumnClass(String.class);

		tblDataList = new UITable2();
		tblDataList.setColumnData(column);
		tblDataList.setCellEditable(true);
		tblDataList.setErrorColumnIndex(Ipo5700_02RowData.ErrorFlagCol);
		tblDataList.setGridColor(Color.lightGray);
		tblDataList.setPartsName("dataList02");

		TableCellRenderer render = tblDataList.getTableHeader()
				.getDefaultRenderer();
		JComponent comp = (JComponent) render.getTableCellRendererComponent(
				tblDataList, null, false, false, 0, 0);

		Dimension dim = comp.getPreferredSize();
		dim.height = 20;
		dim.width = 700;
		comp.setPreferredSize(dim);

		tblDataList.addRowListener(new Ipo5700_02Panel_RowAdapter(this));

		TableCellEditor checkBoxEditor = tblDataList
				.getDefaultEditor(Boolean.class);
		checkBoxEditor.addCellEditorListener(new CellEditorListener() {
			public void editingStopped(javax.swing.event.ChangeEvent e) {
				txtUpdateFlg.setText(ConstantValues.TAB_UPDATE);
				changeFormStatus();
			}

			public void editingCanceled(javax.swing.event.ChangeEvent e) {
			}

		});

		// Scroll panel contain table data list
		jScrollPane = new JScrollPane();
		jScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setBounds(new Rectangle(25, txtRemarks.getY() + 65, 695,
				120));
		jScrollPane.getViewport().add(tblDataList, null);
		this.add(jScrollPane);

		// Reset button
		btnReset = new MUIResetButton();
		btnReset.setLocation(jScrollPane.getX() + jScrollPane.getWidth() - 70,
				txtRemarks.getY() + 40);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reset();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					jp.co.okasan.pr.cmn.CommonHelper.showError(btnReset,
							e1.getMessage());
				}
			}
		});

		btnReset.setText("Ipo5700Panel_lblReset");
		this.add(btnReset);

		// Update button
		btnUpdate = new MUIAddButton();
		btnUpdate.setLocation(btnReset.getX() - 80 - 5, txtRemarks.getY() + 40);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (success) {
					resetInputField();
					notRunSelectRow = true;
					tblDataList.clearSelection();
					notRunSelectRow = false;
					success = false;
				}
			}
		});

		btnUpdate.setAction(tblDataList.createUpdateRowAction());
		btnUpdate.setText("Ipo5700Panel_lblUpdate");
		this.add(btnUpdate);

		// Add button
		btnAdd = new MUIAddButton();
		btnAdd.setLocation(btnUpdate.getX() - 80 - 5, txtRemarks.getY() + 40);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (success) {
					resetInputField();
					notRunSelectRow = true;
					tblDataList.clearSelection();
					notRunSelectRow = false;
					success = false;
				}
			}
		});

		btnAdd.setAction(tblDataList.createAddRowAction());
		btnAdd.setText("Ipo5700Panel_lblAdd");
		this.add(btnAdd);

	}

	/**
	 * Even table data list row added </Br> Be call when click button add
	 * 
	 * @param e
	 *            : ActionEvent
	 * @throws Frw10ClientException
	 */
	private void tblDataList_rowAdded(ActionEvent e)
			throws Frw10ClientException {
		success = false;

		if (super.dataCheck(this)) {
			HashMap<?, ?> hashMap = createRowDataFromEditField(ConstantValues.ROW_ADD);

			if (hashMap.isEmpty() == false) {
				txtUpdateFlg.reset();
				txtUpdateFlg.setText(ConstantValues.TAB_UPDATE);
				notRunSelectRow = true;
				tblDataList.addRow(hashMap);
				success = true;
				changeFormStatus();
			}
		}
	}

	/**
	 * Selected row on table then set data in input component
	 * 
	 * @param e
	 *            : ListSelectionEvent
	 * @throws Frw10ClientException
	 */
	private void tblDataList_rowSelected(ListSelectionEvent e)
			throws Frw10ClientException {
		if (notRunSelectRow) {
			return;
		}

		int selectedRowNO = tblDataList.getSelectedRow();

		if (selectedRowNO != -1) {
			// reset input field
			resetInputField();

			Object[] rowModel = tblDataList.getSelectedRowModel();
			Ipo5700_02RowData data = Ipo5700_02RowData
					.getIpo5700_02RowData(rowModel);

			this.cboCustType.setValue(data.getCustType());
			this.cboForeignType.setValue(data.getForeignType());
			this.txtMinQty.setValue(data.getMinQty());
			this.txtMaxQty.setValue(data.getMaxQty());
			this.txtRemarks.setValue(data.getRemarks());
		}
	}

	/**
	 * Even Table data list row updated </Br> Be call when click button update
	 * 
	 * @param e
	 *            : ActionEvent
	 * @throws Frw10ClientException
	 */
	private void tblDataList_rowUpdated(ActionEvent e)
			throws Frw10ClientException {
		success = false;

		if (super.dataCheck(this)) {
			HashMap<?, ?> hashMap = new HashMap<Object, Object>();
			int selectedRow = tblDataList.getSelectedRow();

			if (selectedRow > -1) {
				Object[] rowData = tblDataList.getSelectedRowModel();
				Ipo5700_02RowData data = Ipo5700_02RowData
						.getIpo5700_02RowData(rowData);

				if (ConstantValues.ROW_ADD.equals(data.getUpdateFlg())) {
					hashMap = createRowDataFromEditField(ConstantValues.ROW_ADD);
				} else {
					hashMap = createRowDataFromEditField(ConstantValues.ROW_UPDATE);
				}
			}

			if (hashMap.isEmpty() == false) {
				txtUpdateFlg.reset();
				txtUpdateFlg.setText(ConstantValues.TAB_UPDATE);
				notRunSelectRow = true;
				tblDataList.updateRow(hashMap);
				success = true;
				changeFormStatus();
			}
		}
	}

	/**
	 * Create Row Data From Edit Field
	 * 
	 * @param processFlg
	 *            : Process flag is update or insert
	 * @return
	 * @throws Frw10ClientException
	 */
	private HashMap<?, ?> createRowDataFromEditField(String processFlg)
			throws Frw10ClientException {
		Ipo5700_02RowData data = new Ipo5700_02RowData();

		data.setSelect(false);
		data.setUpdateFlg(processFlg);
		data.setErrFlag(null);

		data.setCustType(this.cboCustType.getValue());
		data.setForeignType(this.cboForeignType.getValue());
		data.setMinQty(this.txtMinQty.getValue());
		data.setMaxQty(this.txtMaxQty.getValue());
		data.setCustTypeDisp(ComboInfoGetter.getDisplayValue(
				ComboInfo.IPOTINFO_CUST_TYPE, data.getCustType()));
		data.setForeignTypeDisp(ComboInfoGetter.getDisplayValue(
				ComboInfo.IPOTINFO_FOREIGN_TYPE, data.getForeignType()));

		// Default status = 0 when create new
		data.setStatusDisp(ComboInfoGetter.getDisplayValue(
				ComboInfo.IPOTINFO_ROLES_STATUS,
				IpoTInfo_Roles_Status.VALID.toString()));

		data.setRemarks(this.txtRemarks.getValue());

		return data.getIpo5700_02RowDataHashMap();
	}

	/**
	 * Reset Input Field
	 */
	private void resetInputField() {
		this.cboCustType.reset();
		this.cboForeignType.reset();
		this.txtMinQty.reset();
		this.txtMaxQty.reset();
		this.txtRemarks.reset();
	}

	/**
	 * Event Reset Button
	 * 
	 * @throws ClassNotFoundException
	 */
	private void reset() throws ClassNotFoundException {
		resetInputField();

		notRunSelectRow = true;
		tblDataList.setData(CommonHelper.cloneList(getOriginList()));
		tblDataList.clearSelection();
		notRunSelectRow = false;
	}

	/**
	 * Change form status </Br> Be call when change table data list
	 */
	private void changeFormStatus() {
		Frw00BaseTemplateFrame frame = (Frw00BaseTemplateFrame) getTopLevelAncestor();

		String status = frame.getCurrentBusinessState().getWindowStatus();

		if (status.equals(Frw00HeaderData.WNDSTAT_CONFIRM)) {
			Ipo5700Confirm confirmStatus = (Ipo5700Confirm) frame
					.getCurrentBusinessState();
			confirmStatus.notifyUITableChanged();
		}
	}

	/**
	 * set data from server to grid
	 */
	public void setDataToGrid(List<?> dataList02, boolean isFailedResult) {

		this.tblDataList.setData(dataList02);

		/**
		 * if set data from failed result, then search for error row and bind to
		 * fields editor
		 */
		if (isFailedResult) {
			Iterator<?> tblIterator = dataList02.iterator();
			int i = 0;

			while (tblIterator.hasNext()) {
				Object[] rowData = (Object[]) tblIterator.next();

				if (rowData[Ipo5700_02RowData.ErrorFlagCol] != null) {
					this.tblDataList.setRowSelection(i);
					break;
				}

				i++;
			}
		}
	}

	// set enable component in panel
	protected void setEnabledControl(boolean param) {
		btnAdd.setEnabled(param);
		btnUpdate.setEnabled(param);
		btnReset.setEnabled(param);
		txtMinQty.setEnabled(param);
		txtMaxQty.setEnabled(param);
		cboCustType.setEnabled(param);
		cboForeignType.setEnabled(param);
		txtRemarks.setEnabled(param);
		tblDataList.setEnabled(param);
	}
}
