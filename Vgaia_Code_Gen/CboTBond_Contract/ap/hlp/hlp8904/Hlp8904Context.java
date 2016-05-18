/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.hlp.hlp8904;


import java.util.List;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.okasan.cm.hlp.hlp8904.Hlp8904InputData;
import jp.co.okasan.cm.hlp.hlp8904.Hlp8904ResultData;

/**
 * Hlp8904Context Class's Description. <br>
 * Context of CboTBond_Contract
 * 
 * @author: HungKieu 2016/04/15 Create New
 */
public class Hlp8904Context extends Context {
	
	////////// Constance Variables //////////
	
    /** Get logger name */
    private static final String LOGGER_NAME = Hlp8904Context.class.getPackage().getName();
	
	////////// Define Variables //////////
			
	/** Response data List */
    private List<?> dataList;
	
	/** input data class */
    private Hlp8904InputData inputData;
	
	/** Response data */
    private Hlp8904ResultData resultData;
	
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
     * Get CboTBond_Contract dataList<BR>
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
     * @return inputData Hlp8904InputData
     * @exception Nothing
     */
    public Hlp8904InputData getInputData() {
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
     * @return resultData Hlp8904ResultData
     * @exception Nothing
     */
    public Hlp8904ResultData getResultData() {
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
        inputData = (Hlp8904InputData) input;
    }
	
	/**
     * Get output data <br>
     * 
     * @param output Frw00ResultData(outputData)
     * @exception Nothing
     */
    public void setResultData(Frw00ResultData output) {
        super.setResultData(output);
        resultData = (Hlp8904ResultData) output;
    }
}
