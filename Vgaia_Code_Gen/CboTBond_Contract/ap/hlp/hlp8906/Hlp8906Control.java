/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp8906;

import jp.co.nec.com0000.ap.Com00UserError;
import jp.co.nec.com0000.ap.IStage;
import jp.co.nec.com0000.ap.Route;
import jp.co.nec.com0000.ap.RouteSelector;
import jp.co.nec.frw0000.ap.Frw00InstanceFactory;
import jp.co.nec.frw0000.cm.Frw00RuntimeException;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.okasan.cm.hlp.hlp8906.Hlp8906ResultData;

/**
 * Hlp8906Control class's Description. <br>
 * Route selector CboTBond_Contract <br>
 *
 * This route selector is generated as bellow. <br>
 *
 * 
 * @author: HungKieu 2016/04/19 Create New
 */
public class Hlp8906Control extends RouteSelector {
	
	////////// Define Variables //////////
	
	/** Search router */
    private Route search;
	
	////////// Define Methods //////////
	
	/**
	 * Create business route. <br>
	 * 
	 * @param factory Frw00InstanceFactory instance of Factory
	 * @exception Nothing
	 */
    public void create(Frw00InstanceFactory factory) {
	
        // Create search router
        search = createSearchRoute(factory);
		
        // Create context
        ctx = new Hlp8906Context();
    }
	
	/**
	 * According to input data the flowing route will be return. <br>
	 * 
	 * @param input Frw00InputData input data
	 * @return Route select result route
	 * @exception Com00UserError when cannot return any route
	 */
    protected Route selectRoute(Frw00InputData input) throws Com00UserError {
	
        // return router
        return search;
    }
	
	/**
     * Generate response data. <br>
     * 
     * @param input Frw00InputData {@link Hlp8906InputData}
     * @return result Frw00ResultData {@link Hlp8906ResultData}
     * @exception Frw00RuntimeException throw exception when response have failure.
     */
    protected Frw00ResultData createResultData(Frw00InputData input)
            throws Frw00RuntimeException {
			
        // Create result data
        Hlp8906ResultData result = new Hlp8906ResultData();
		
        // set result data and return
        result.setResultCode(Frw00ResultData.NORMAL_END);
        return result;
    }
	
	/**
     * Generate Search route and return <br>
     * <ul>
     * <li>{@link S1Initial}</li>
     * <li>{@link S2InputDataCheck}</li>
     * <li>{@link S3TableReadCheck}</li>
     * <li>{@link S4DataFind}</li>
     * <li>{@link S5ScreenDataEdit}</li>
     * <li>{@link S7End}</li>
     * </ul>
     * 
	 * @param factory Frw00InstanceFactory instance factory
	 * @return Route Entry Result
	 * @exception Nothing
     */
    private static Route createSearchRoute(Frw00InstanceFactory factory) {
        Route route = new Route();

        // Set init stage
        route.addStage((IStage) factory.getInstance(S1Initial.class));
		
        // Set input data check stage
        route.addStage((IStage) factory.getInstance(S2InputDataCheck.class));
		
        // Set table readcheck stage
        route.addStage((IStage) factory.getInstance(S3TableReadCheck.class));
		
        // Set data find stage
        route.addStage((IStage) factory.getInstance(S4DataFind.class));
		
        // Set screen  data edit stage
        route.addStage((IStage) factory.getInstance(S5ScreenDataEdit.class));
		
        // Set end stage
        route.addStage((IStage) factory.getInstance(S7End.class));
        
        return route;
    }
}
