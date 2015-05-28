package net.yasite.riceball;

import java.util.ArrayList;
import java.util.List;

import net.yasite.riceball.net.BaseAPI;
import net.yasite.riceball.net.RequestAPI;

import org.apache.http.NameValuePair;

import android.content.Context;

public class BaseService {
	
	public static Object getData(Context context,
			String url,Class entity){
		return getData(context, url, entity, null);
	}
	
	public static Object getData(Context context,
			String url,Class entity,DataProcessing processing){
		BaseAPI api = new RequestAPI(context)
						.setMethod(url)
						.setEntity(entity);
		try {
			if(api.doGet()){
				if(processing != null){
					return processing.processing(api.getHandleResult());
				}
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static Object postData(Context context,String url,
			Class entity,List<NameValuePair> list){
		return postData(context, url, entity, list, null);
	}
	
	public static Object postData(Context context,String url,
			Class entity,List<NameValuePair> list,DataProcessing processing){
		BaseAPI api = new RequestAPI(context)
		.setMethod(url)
		.setEntity(entity)
		.setValuePair(list);
		try {
			if(api.doPost()){
				if(processing != null){
					return processing.processing(api.getHandleResult());
				}
				return api.getHandleResult();
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	
	public static Object uploadData(Context context,String url,
			Class entity,List<NameValuePair> fileList){
		return uploadData(context, url, entity, 
				new ArrayList<NameValuePair>(), fileList, null);
	}
	
	public static Object uploadData(Context context,String url,
			Class entity,List<NameValuePair> fileList,DataProcessing processing){
		return uploadData(context,url,entity,
				new ArrayList<NameValuePair>(),fileList,processing);
	}
	
	public static Object uploadData(Context context,String url,
			Class entity,List<NameValuePair> list,List<NameValuePair> fileList){
		return uploadData(context, url, entity, list, fileList, null);
	}
	
	public static Object uploadData(Context context,String url,
			Class entity,List<NameValuePair> list,List<NameValuePair> fileList,
			DataProcessing processing){
		BaseAPI api = new RequestAPI(context)
		.setMethod(url)
		.setEntity(entity)
		.setValuePair(list)
		.setFileList(fileList);
		try {
			if(api.doPost()){
				if(processing != null){
					return processing.processing(api.getHandleResult());
				}
				return api.getHandleResult();
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public interface DataProcessing{
		public Object processing(Object handleResult);
	}
}
