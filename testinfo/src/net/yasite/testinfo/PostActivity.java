package net.yasite.testinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.apache.http.NameValuePair;

import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.net.HandlerHelp;
import net.yasite.testinfo.constant.APIUrl;
import net.yasite.testinfo.entity.GoodListEntity;
import android.content.Context;
import android.os.Message;

public class PostActivity extends BaseNewActivity {

	@Override
	public void setupView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		new PostHandler(context).execute();
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
	class PostHandler extends HandlerHelp{
		GoodListEntity entity;

		public PostHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(getValue("a", "1"));
			list.add(getValue("bb", "dafdf"));
			entity = (GoodListEntity)BaseService.postData(context, 
					APIUrl.POST, GoodListEntity.class, list);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
