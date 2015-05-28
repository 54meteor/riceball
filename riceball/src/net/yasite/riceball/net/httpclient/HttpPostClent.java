package net.yasite.riceball.net.httpclient;

import net.yasite.riceball.net.BaseAPI;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;

public class HttpPostClent extends AHttpClient {

	
	public HttpPostClent(BaseAPI param){
		super(param);
		request = new HttpPost(param.getMethod());
		request.addHeader("Pragma", "no-cache");
	    request.addHeader("Cache-Control", "no-cache");
	    request.addHeader("charset", HTTP.UTF_8);
	    
	}
	@Override
	public void doRequest(BaseAPI param)  throws Exception {
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(param.getValuePair(),HTTP.UTF_8);
		((HttpPost) request).setEntity(entity);
//		StringEntity stringEntity = new StringEntity(new Gson().toJson(param.getRequestParam()),	HTTP.UTF_8);
//		stringEntity.setContentType("application/json;charset=UTF-8");
//		((HttpPost) request).setEntity(stringEntity);
		response = httpClient.execute(request);
		
		
		excute(response, content, param);
	}

}
