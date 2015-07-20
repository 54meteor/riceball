package net.yasite.riceball;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.riceball.BaseService.DataProcessing;
import net.yasite.riceball.net.BaseAPI;
import android.content.Context;

public class RequestEntity implements Serializable {
	
	
	
	private Context context;
	private String url;
	private Class entity;
	private BaseAPI api;
	private DataProcessing processing;
	private int type = BaseAPI.GET;
	private List<NameValuePair> list;
	private List<NameValuePair> fileList;

	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Class getEntity() {
		return entity;
	}
	public void setEntity(Class entity) {
		this.entity = entity;
	}
	public DataProcessing getProcessing() {
		return processing;
	}
	public void setProcessing(DataProcessing processing) {
		this.processing = processing;
	}
	public BaseAPI getApi() {
		return api;
	}
	public void setApi(BaseAPI api) {
		this.api = api;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<NameValuePair> getList() {
		return list;
	}
	public void setList(List<NameValuePair> list) {
		this.list = list;
	}
	public List<NameValuePair> getFileList() {
		return fileList;
	}
	public void setFileList(List<NameValuePair> fileList) {
		this.fileList = fileList;
	}
}
