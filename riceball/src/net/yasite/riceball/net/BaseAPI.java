package net.yasite.riceball.net;

import java.util.List;

import net.yasite.riceball.net.httpclient.AHttpClient;
import net.yasite.riceball.net.httpclient.HttpGetClient;
import net.yasite.riceball.net.httpclient.HttpPostClent;
import net.yasite.riceball.net.httpclient.HttpUploadClient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public abstract class BaseAPI implements HttpAPI {

	protected Context context;
	protected int status;
	protected Object paramStr;
	protected List <NameValuePair> valuePair;//post请求数据
	protected List <NameValuePair> fileList;//文件上传数据
	protected int statuesCode;
	protected SharedPreferences prefs;
	protected JSONObject json = new JSONObject();
	protected HttpResponse res;
	protected AHttpClient httpClient;
	protected String method;
	protected BaseHttpParam requestParam;
	protected Object response;
	protected Object handleResult;
	protected Class entity;
	public static final boolean DEBUG = true;
    public static final String TOKEN = "token";
	
	public BaseAPI(Context context){
		this.context = context;
	}

	public BaseAPI(Context context,String method,Class entity) {
		this.context = context;
		this.method = method;
		this.entity = entity;
	}
	
	public HttpResponse getRes() {
		return res;
	}

	public void setRes(HttpResponse res) {
		this.res = res;
	}

	public int getStatuesCode() {
		return statuesCode;
	}

	public void setStatuesCode(int statuesCode) {
		this.statuesCode = statuesCode;
	}
	

	public List<NameValuePair> getFileList() {
		return fileList;
	}

	public BaseAPI setFileList(List<NameValuePair> fileList) {
		this.fileList = fileList;
		return this;
	}
	
	
 
	public Class getEntity() {
		return entity;
	}

	public BaseAPI setEntity(Class entity) {
		this.entity = entity;
		return this;
	}

	public boolean doUpload() throws Exception {
		httpClient = new HttpUploadClient(this);
		return doRequest();
	}

	public boolean doPost() throws Exception {
		httpClient = new HttpPostClent(this);
		return doRequest();
	}

	public boolean doGet() throws Exception {
		httpClient = new HttpGetClient(this);
        return doRequest();
    }
	private boolean doRequest() throws Exception{
		if (method == null) {
			Log.e(HttpConstant.DUG_TYPE_ERROR, "未设置请求方法");
			return false;
		}
		// 请求参数验证
		if(DEBUG){
			System.out.println("请求参数:" +  getMethod());
		}
		httpClient.doRequest(this);
		
		if(response != null){
			if(response.toString().startsWith("[")){
				json.put("list", new JSONArray(response.toString()));
			}else if(response.toString().startsWith("<html>")){
				json.put("content", response.toString());
			}else if(response.toString().startsWith("<?xml")){
				json.put("content", response.toString());
			}else{
				json = new JSONObject(response.toString());
			}
			if(DEBUG){
				System.out.println("返回结果:" + json.toString());
			}
			setHandleResult(handlerResult(json));
			return true;
		}
		return false;
	}
	
	@Override
	public int handlerError(JSONObject json) throws JSONException,Exception {
		throw new Exception("操作失败!");
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	


	public String getMethod() {
		return method;
	}


	public BaseAPI setMethod(String method) {
		this.method = method;
		return this;
	}


	public int getStatus() {
		return status;
	}

	
	public BaseAPI setRequestParam(BaseHttpParam requestParam) {
		this.requestParam = requestParam;
		return this;
	}

	public void setResponse(Object response) {
		this.response = response;
	}


	public Object getHandleResult() {
		return handleResult;
	}

	
	public void setHandleResult(Object object) {
		this.handleResult = object;
	}

	public List<NameValuePair> getValuePair() {
		return valuePair;
	}

	public BaseAPI setValuePair(List<NameValuePair> valuePair) {
		this.valuePair = valuePair;
		return this;
	}

	public AHttpClient getHttpClient() {
		return httpClient;
	}

	public BaseHttpParam getRequestParam() {
		return requestParam;
	}
	
	public Object getRequestParamToString(){
		return this.paramStr;
	}
}
