/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp6032;


import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.okasan.cm.hlp.hlp6032.Hlp6032InputData;
import jp.co.okasan.cm.hlp.hlp6032.Hlp6032ResultData;

/**
 * Hlp6032Context Class's Description. <br>
 * Context of MstTContract
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Hlp6032Context extends Context {
	
	////////// Constance Variables //////////
	
    /** Get logger name */
    private static final String LOGGER_NAME = Hlp6032Context.class.getPackage().getName();
	
	////////// Define Variables //////////
			
	/** Response data List */
    private List<?> dataList;
	
	/** input data class */
    private Hlp6032InputData inputData;
	
	/** Response data */
    private Hlp6032ResultData resultData;
	
	////////// Define Methods //////////
	
	/**
	 * Initialize variables <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
    public void clear() {
        dataList = null;
        inputData = null;
        resultData = null;
    }
	
	/**
     * Get MstTContract dataList<BR>
     * 
     * @param Nothing
     * @return countryDataList List
     * @exception Nothing
     */
    public List<?> getDataList() {
        return dataList;
    }
	
	/**
     * Get inputData <br>
     * 
     * @param Nothing
     * @return inputData Hlp6032InputData
     * @exception Nothing
     */
    public Hlp6032InputData getInputData() {
        return inputData;
    }
	
	/**
     * Get Logger Name <br>
     * @param
     * @return String
     * @exception
     */
    public String getLoggerName() {
        return LOGGER_NAME;
    }
	
	/**
     * Get response data <br>
     * 
     * @param Nothing
     * @return resultData Hlp6032ResultData
     * @exception Nothing
     */
    public Hlp6032ResultData getResultData() {
        return resultData;
    }
	
	/**
     * Release variables of class <br>
     * 
     * @param
     * @return
     * @exception
     */
    public void release() {
        super.release();
        dataList = null;
        inputData = null;
        resultData = null;
    }
	
	/**
     * Set data list <br>
     * 
     * @param dataList data to return
     * @exception Nothing
     */
    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
	
	/**
     * Set input data<BR>
     * 
     * @param input Frw00InputData(inputData)
     * @exception Nothing
     */
    public void setInputData(Frw00InputData input) {
        super.setInputData(input);
        inputData = (Hlp6032InputData) input;
    }
	
	/**
     * Get output data <br>
     * 
     * @param output Frw00ResultData(outputData)
     * @exception Nothing
     */
    public void setResultData(Frw00ResultData output) {
        super.setResultData(output);
        resultData = (Hlp6032ResultData) output;
    }
}
