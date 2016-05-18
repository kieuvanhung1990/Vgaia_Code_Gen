/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.com0000.ap.Route;
import jp.co.nec.com0000.ap.RouteSelector;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.Frw00RuntimeException;
import jp.co.nec.frw0000.cm.data.Frw00HeaderData;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;

import jp.co.okasan.cmn.ConstantValues;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

/**
 * Mst3032Control Class's Description <br>
 * Route selector MstTContract <br>
 *
 * This route selector is generated as bellow. <br>
 * 
 * <ul>
 * <li>Insert Confirm Route from WNDSTAT_INPUT to WNDSTAT_CONFIRM</li>
 * <li>Insert Result Route from WNDSTAT_CONFIRM to WNDSTAT_RESULT</li>
 * <li>Update Search from WNDSTAT_INPUT to WNDSTAT_CHANGE_INPUT</li>
 * <li>Update Confirm from WNDSTAT_CHANGE_INPUT to WNDSTAT_CONFIRM</li>
 * <li>Update Result from WNDSTAT_CONFIRM to WNDSTAT_RESULT</li>
 * <li>Delete Confirm from WNDSTAT_INPUT to WNDSTAT_CONFIRM</li>
 * <li>Delete Result from WNDSTAT_CONFIRM to WNDSTAT_RESULT</li>
 * </ul>
 * <p/>{@link #selectRoute(Mst3032InputData)}
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032Control extends RouteSelector {
	
	////////// Define Variables //////////

	/** Entry Confirm insert confirm route */
	private Route entryConfirm;

	/** Entry Result insert result route */
	private Route entryResult;

	/** Update search route */
	private Route changeInput;

	/** Update Confirm route */
	private Route changeConfirm;

	/** Update Result route */
	private Route changeResult;

	/** Delete Confirm route */
	private Route deleteConfirm;

	/** Delete result route */
	private Route deleteResult;
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
	public void create(Frw00InstanceFactory factory) {
	
		// Create entryConfirm
		entryConfirm = createEntryConfirmRoute(factory);
		
		// Create entryResult
		entryResult = createEntryResultRoute(factory);
		
		// Create changeInput
		changeInput = createChangeInputRoute(factory);
		
		// Create changeConfirm
		changeConfirm = createChangeConfirmRoute(factory);
		
		// Create changeResult
		changeResult = createChangeResultRoute(factory);
		
		// Create deleteConfirm
		deleteConfirm = createDeleteConfirmRoute(factory);
		
		// Create deleteResult
		deleteResult = createDeleteResultRoute(factory);

		// Create context
		ctx = new Mst3032Context();
	}
	
	/**
	 * According to input data the flowing route will be return. <br>
	 * 
	 *  Route select condition
	 * <ul>
	 * <li>Action mode = ENTRY, Window State = WNDSTAT_INPUT return entryConfirm </li>
	 * <li>Action mode = ENTRY, Window State = WNDSTAT_CONFIRM return entryResult </li>
	 * <li>Action mode = UPDATE, Window State = WNDSTAT_INPUT return changeInput </li>
	 * <li>Action mode = UPDATE, Window State = WNDSTAT_CHANGE_INPUT return changeConfirm </li>
	 * <li>Action mode = UPDATE, Window State = WNDSTAT_CONFIRM return changeResult </li>
	 * <li>Action mode = DELETE, Window State = WNDSTAT_INPUT return deleteConfirm </li>
	 * <li>Action mode = DELETE, Window State = WNDSTAT_CONFIRM return deleteResult</li>
	 * </ul>
	 * 
	 * @param input Frw00InputData input data
	 * @return Route select result route
	 * @exception Com00UserError when cannot return any route
	 */
	protected Route selectRoute(Frw00InputData input) throws Com00UserError {
	
		// Get input data from context
		Mst3032InputData inputData = ((Mst3032Context) ctx).getInputData();
		
		// Get windowStatus
		String windowStatus = inputData.getHeaderData().getWindowStatus();
		
		// Get Action Mode
		String actionMode = inputData.getActionMode();

		// according to windowStatus and actionMode the return route will be different
		if (actionMode.equals(ConstantValues.MODE_ENTRY)) {
		
			// ENTRY (Insert mode) 
			if (windowStatus.equals(Frw00HeaderData.WNDSTAT_INPUT)) {
			
				// entryConfirm
				setNormalMessage("MSG0274I");
				return entryConfirm;
			} else if (windowStatus.equals(Frw00HeaderData.WNDSTAT_CONFIRM)) {
			
				// entryResult
				setNormalMessage("MSG0275I");
				return entryResult;
			} else {
				return null;
			}
		} else if (actionMode.equals(ConstantValues.MODE_UPDATE)) {
		
			// UPDATE (update mode)
			if (windowStatus.equals(Frw00HeaderData.WNDSTAT_INPUT)) {
			
				// changeInput
				setNormalMessage("MSG0273I");
				return changeInput;
			} else if (windowStatus.equals(Frw00HeaderData.WNDSTAT_CHANGE_INPUT)) {
			
				// changeConfirm
				setNormalMessage("MSG0274I");
				return changeConfirm;
			} else if (windowStatus.equals(Frw00HeaderData.WNDSTAT_CONFIRM)) {
			
				// changeResult
				setNormalMessage("MSG0275I");
				return changeResult;
			} else {
				return null;
			}
		} else if (actionMode.equals(ConstantValues.MODE_DELETE)) {
		
			// DELETE (Delete mode)
			if (windowStatus.equals(Frw00HeaderData.WNDSTAT_INPUT)) {
			
				// deleteConfirm
				setNormalMessage("MSG0274I");
				return deleteConfirm;
			} else if (windowStatus.equals(Frw00HeaderData.WNDSTAT_CONFIRM)) {
			
				// deleteResult
				setNormalMessage("MSG0275I");
				return deleteResult;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Generate response data. <br>
	 * 
	 * @param inputData Frw00InputData {@link Mst3032InputData}
	 * @return result Frw00ResultData {@link Mst3032ResultData}
	 * @exception Frw00RuntimeException throw exception when response have failure.
	 */
	protected Frw00ResultData createResultData(Frw00InputData inputData)
			throws Frw00RuntimeException {
			
		// Response data data
		final Mst3032ResultData result = new Mst3032ResultData();

		// Normal (succesfull)
		result.setResultCode(Frw00ResultData.NORMAL_END);

		return result;
	}
	
	/**
	 * Generate Entry confirm route and return <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @return Route Entry Confirm
	 * @exception Nothing
	 */
	private static Route createEntryConfirmRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add inital stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check input data stage into Route
		route.addStage((IStage) factory.getInstance(S2InputDataCheck.class));
		
		// Add check read table stage into Route
		route.addStage((IStage) factory.getInstance(S3TableReadCheck.class));
		
		// Add check data not exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataNotExist.class));
		
		// Add data editor stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEditor.class));
		
		// Add screen data edit stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate Entry result route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route Entry Result
	 * @exception Nothing
	 */
	private static Route createEntryResultRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add Initialize stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check input data stage into Route
		route.addStage((IStage) factory.getInstance(S2InputDataCheck.class));
		
		// Add check read table stage into Route
		route.addStage((IStage) factory.getInstance(S3TableReadCheck.class));
		
		// Add check data not exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataNotExist.class));
		
		// Add data editor stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEditor.class));
		
		// Add data entry stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEntry.class));
		
		// Add screen data edit stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add data output stage into Route
		route.addStage((IStage) factory.getInstance(S6DataOutput.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate Change input route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route Change input
	 * @exception Nothing
	 */
	private static Route createChangeInputRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add initial stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check input data stage into Route
		route.addStage((IStage) factory.getInstance(S2InputKeyCheck.class));
		
		// Add data find stage into Route
		route.addStage((IStage) factory.getInstance(S4DataFind.class));
		
		// Add screen data edit into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate Change confirm route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route Change confirm
	 * @exception Nothing
	 */
	private static Route createChangeConfirmRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add initial stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check input data stage into Route
		route.addStage((IStage) factory.getInstance(S2InputDataCheck.class));
		
		// Add check read table stage into Route
		route.addStage((IStage) factory.getInstance(S3TableReadCheck.class));
		
		// Add check data exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataExist.class));
		
		// Add data editor stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEditor.class));
		
		// Add screen data edit stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate Change result route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route Change result
	 * @exception Nothing
	 */
	private static Route createChangeResultRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add initial stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check data input stage into Route
		route.addStage((IStage) factory.getInstance(S2InputDataCheck.class));
		
		// Add check read table stage into Route
		route.addStage((IStage) factory.getInstance(S3TableReadCheck.class));
		
		// Add check data exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataExist.class));
		
		// Add data editor stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEditor.class));
		
		// Add data updator stage into Route?
		route.addStage((IStage) factory.getInstance(S4DataUpdate.class));
		
		// Add screen data edit stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add output stage into Route
		route.addStage((IStage) factory.getInstance(S6DataOutput.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate delete confirm route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route delete confirm
	 * @exception Nothing
	 */
	private static Route createDeleteConfirmRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add initial stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check key input stage into Route
		route.addStage((IStage) factory.getInstance(S2InputKeyCheck.class));
		
		// Add check data exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataExist.class));
		
		// Add data finder stage into Route
		route.addStage((IStage) factory.getInstance(S4DataFind.class));
		
		// Add screen data editor stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
	
	/**
	 * Generate delete result route and return <BR>
	 * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route delete result
	 * @exception Nothing
	 */
	private static Route createDeleteResultRoute(Frw00InstanceFactory factory) {
		Route route = new Route();

		// Add Initialize stage into Route
		route.addStage((IStage) factory.getInstance(S1Initial.class));
		
		// Add check data exist stage into Route
		route.addStage((IStage) factory.getInstance(S3DataExist.class));
		
		// Add data editor stage into Route
		route.addStage((IStage) factory.getInstance(S4DataEditor.class));
		
		// Add data delete stage into Route
		route.addStage((IStage) factory.getInstance(S4DataDelete.class));
		
		// Add screen data editor stage into Route
		route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
		// Add data output stage into Route
		route.addStage((IStage) factory.getInstance(S6DataOutput.class));
		
		// Add end stage into Route
		route.addStage((IStage) factory.getInstance(S7End.class));

		return route;
	}
}
