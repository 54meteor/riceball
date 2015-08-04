package net.yasite.riceball;

import net.yasite.riceball.net.BaseAPI;
import net.yasite.riceball.net.RequestAPI;

public class BaseService {
	

	public static Object getData(RequestEntity request){
		BaseAPI api = setAPI(request);
		try {
			if(api.request()){
				if(request.getProcessing() != null){
					return request.getProcessing()
							.processing(api.getHandleResult());
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
	
	protected static BaseAPI setAPI(RequestEntity reqeust){
		if(reqeust.getApi() != null){
			return reqeust.getApi();
		}else{
			BaseAPI api = new RequestAPI(
					reqeust.getContext(), reqeust.getUrl(), 
					reqeust.getEntity());
			api.setType(reqeust.getType());
			api.setValuePair(reqeust.getList());
			api.setFileList(reqeust.getFileList());
			return api;
		}
	}
	
	
//	public static Object uploadData(Context context,String url,
//			Class entity,List<NameValuePair> list,List<NameValuePair> fileList,
//			DataProcessing processing){
//		BaseAPI api = new RequestAPI(context)
//		.setMethod(url)
//		.setEntity(entity)
//		.setValuePair(list)
//		.setFileList(fileList);
//		try {
//			if(api.doUpload()){
//				if(processing != null){
//					return processing.processing(api.getHandleResult());
//				}
//				return api.getHandleResult();
//			}
//		} catch (Exception e) {
//		// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		return null;
//	}
	
	public interface DataProcessing{
		public Object processing(Object handleResult);
	}
}
