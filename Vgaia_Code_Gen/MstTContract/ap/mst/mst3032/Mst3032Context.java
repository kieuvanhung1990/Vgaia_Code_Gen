/*
 * Copyright(C) 2012 Okasan Information Systems Co.,Ltd. All rights reserved.
 */
package jp.co.okasan.ap.mst.mst3032;

import jp.co.nec.com0000.ap.Context;
import jp.co.nec.frw0000.cm.data.Frw00InputData;
import jp.co.nec.frw0000.cm.data.Frw00ResultData;
import jp.co.nec.inf3000.ap.registration.Inf30AnsPushMsgRegHelper;

import jp.co.okasan.dao.MstTContractData;
import jp.co.okasan.cm.mst.mst3032.Mst3032InputData;
import jp.co.okasan.cm.mst.mst3032.Mst3032ResultData;

/**
 * Mst3032Context Class's Description <br>
 * Context of MstTContract
 * 
 * @author: HungKieu 2016/04/26 Create New
 */
public class Mst3032Context extends Context {
	
	////////// Constance Variables //////////
	
	/** Get logger name */
	private static final String LOGGER_NAME = Mst3032Context.class.getPackage().getName();
	
	////////// Define Variables //////////
	
	/** AnswerId */
	private String answerId;

	/** Table data Class */
	private MstTContractData currentData;

	/** Input data class */
	private Mst3032InputData inputData;
	
	/** Response data class */
	private Mst3032ResultData resultData;
	
	/** Push Message */
	private String pushMsgId;
	
	/** Answer push message registration helper*/
	private Inf30AnsPushMsgRegHelper regHelper;
	
	/** Answer content */
    private String answerContent;
    
	/** Answer title*/
	private String title;
    
	/** Answer message author */
	private String[] ansMsgAut;
	
	////////// Define Methods //////////
	
	/**
	 * Initialize variables <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public void clear() {
		answerId = "";
		pushMsgId = "";
		regHelper = null;
		inputData = null;
		resultData = null;
		currentData = null;
	}
	
	/**
	 * Get answerId <br>
	 * 
	 * @param Nothing
	 * @return answerId String
	 * @exception Nothing
	 */
	public String getAnswerId() {
		return answerId;
	}
	
	/**
	 * Get currentData <br>
	 * 
	 * @param Nothing
	 * @return currentData MstTContractData
	 * @exception Nothing
	 */
    public MstTContractData getCurrentData() {
		return currentData;
	}
	
	/**
	 * Get inputData <br>
	 * 
	 * @param Nothing
	 * @return inputData Mst3032InputData
	 * @exception Nothing
	 */
    public Mst3032InputData getInputData() {
		return inputData;
	}
	
	/**
	 * Get logger name <br>
	 * 
	 * @param Nothing
	 * @return String logger name
	 * @exception Nothing
	 */
	public String getLoggerName() {
		return LOGGER_NAME;
	}
	
	/**
	 * Get pushMsgId <br>
	 * 
	 * @param Nothing
	 * @return pushMsgId String
	 * @exception Nothing
	 */
	public String getPushMsgId() {
		return pushMsgId;
	}
	
	/**
	 * Get regHelper <br>
	 * 
	 * @param Nothing
	 * @return regHelper Inf30AnsPushMsgRegHelper
	 * @exception Nothing
	 */
	public Inf30AnsPushMsgRegHelper getRegHelper() {
		return regHelper;
	}
	
	/**
	 * Get resultData <br>
	 * 
	 * @param Nothing
	 * @return resultData Mst3032ResultData
	 * @exception Nothing
	 */
    public Mst3032ResultData getResultData() {
		return resultData;
	}
	
	/**
	 * Release variables of class <br>
	 * 
	 * @param Nothing
	 * @exception Nothing
	 */
	public void release() {
		super.release();
		regHelper = null;
		inputData = null;
		resultData = null;
		currentData = null;
	}
	
	/**
	 * Set answerId <br>
	 * 
	 * @param answerId String
	 * @exception Nothing
	 */
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	
	/**
	 * Set currentData <br>
	 * 
	 * @param currentData MstTContractData
	 * @exception Nothing
	 */
    public void setCurrentData(MstTContractData currentData) {
		this.currentData = currentData;
	}
	
	/**
     * Set input data <br>
     * 
     * @param inputData Frw00InputData(inputData)
     * @exception Nothing
     */
    public void setInputData(Frw00InputData inputData) {
        super.setInputData(inputData);
        this.inputData = (Mst3032InputData) inputData;
    }
	
	/**
	 * Set pushMsgId <br>
	 * 
	 * @param pushMsgId	String
	 * @exception Nothing
	 */
	public void setPushMsgId(String pushMsgId) {
		this.pushMsgId = pushMsgId;
	}
	
	/**
	 * Set regHelper <br>
	 * 
	 * @param regHelper Inf30AnsPushMsgRegHelper
	 * @exception Nothing
	 */
	public void setRegHelper(Inf30AnsPushMsgRegHelper regHelper) {
		this.regHelper = regHelper;
	}
	
	/**
	 * Set ResultData <br>
	 * 
	 * @param resultData Frw00ResultData (resultData)
	 * @exception Nothing
	 */
	public void setResultData(Frw00ResultData resultData) {
		super.setResultData(resultData);
		this.resultData = (Mst3032ResultData) resultData;
	}
	
	/**
     * Get Mst3032Context.java Ans Message
	 *
     * @return Mst3032Context.java String[]
     * @exception Nothing
     */
    public String[] getAnsMsgAut() {
        return ansMsgAut;
    }
	
	/**
     * Set Mst3032Context.java
	 *
     * @param Mst3032Context.java String[]
     * @exception
     */
    public void setAnsMsgAut(String[] ansMsgAut) {
        this.ansMsgAut = ansMsgAut;
    }
	
	/**
     * Get Mst3032Context.java Ans content
	 *
     * @param Nothing
     * @return Mst3032Context String
     * @exception Nothing
     */
    public String getAnswerContent() {
        return answerContent;
    }
	
	/**
     * Set Mst3032Context.java Ans content
	 *
     * @param Mst3032Context String
     * @exception Nothing
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
	
	/**
     * Get Mst3032Context.java title
	 *
     * @param Nothing
     * @return Mst3032Context.java String
     * @exception Nothing
     */
    public String getTitle() {
        return title;
    }
	
	/**
     * Set Mst3032Context.java title
	 *
     * @param Mst3032Context.java String
     * @exception Nothing
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
