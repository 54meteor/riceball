package net.yasite.testinfo;

import android.content.Context;
import android.os.Message;
import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.RequestEntity;
import net.yasite.riceball.net.HandlerHelp;
import net.yasite.testinfo.constant.APIUrl;
import net.yasite.testinfo.entity.GoodListEntity;

public class GetActivity extends BaseNewActivity {

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
		new TestHandler(context).execute();
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	class TestHandler extends HandlerHelp{
		GoodListEntity list ;

		public TestHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
//			service = new BaseService();
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			RequestEntity entity = new RequestEntity();
			entity.setContext(context);
			entity.setUrl(APIUrl.GET + "/?a=1&b=2");
			entity.setEntity(GoodListEntity.class);
//			list = (GoodListEntity)BaseService.getData(context, 
//					APIUrl.GET + "/?a=1&b=2",GoodListEntity.class);
			list = (GoodListEntity)BaseService.getData(entity);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
	}
}
