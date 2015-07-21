package net.yasite.testinfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.RequestEntity;
import net.yasite.riceball.net.BaseAPI;
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
		new UploadHandler(context).execute();
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
			
			
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			List<NameValuePair> fileList = new ArrayList<NameValuePair>();
			fileList.add(getValue("f1", "/mnt/sdcard/a.jpg"));
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(getValue("a", "1"));
			list.add(getValue("bb", "dafdf"));
			list.add(getValue("cc", "8989898989"));
			RequestEntity entity = new RequestEntity();
			entity.setContext(context);
			entity.setUrl(APIUrl.UPLOAD);
			entity.setEntity(GoodListEntity.class);
			entity.setList(list);
			entity.setType(BaseAPI.UPLOAD);
			entity.setFileList(fileList);
			
			//此集合用于构建需要上传的文件列表，key部分的为图片路径
			//只上传文件调用以下方式
			BaseService.getData(entity);
			
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
