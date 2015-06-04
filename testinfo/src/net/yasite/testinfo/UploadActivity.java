package net.yasite.testinfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.net.HandlerHelp;
import net.yasite.testinfo.constant.APIUrl;
import net.yasite.testinfo.entity.GoodListEntity;
import android.content.Context;
import android.os.Message;

public class UploadActivity extends BaseNewActivity {

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

	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
	class UploadHandler extends HandlerHelp{

		public UploadHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			List<NameValuePair> fileList = new ArrayList<NameValuePair>();
			
			//此集合用于构建需要上传的文件列表，key部分的为图片路径
//			fileList.add(getValue("f1", ""));
			//只上传文件调用以下方式
//			BaseService.uploadData(context, 
//					APIUrl.POST, GoodListEntity.class, fileList);
			//即上传文件，也需要提交数据用以下方式，同时此方式支持回调。
//			BaseService.uploadData(context, 
//					url, entity, list, fileList, processing);
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
