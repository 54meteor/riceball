package net.yasite.riceball.net;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class RequestAPI extends BaseAPI {

	public RequestAPI(Context context){
		super(context);
	}
	
	public RequestAPI(Context context, String method, Class entity) {
		super(context, method, entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), entity);
	}
}
