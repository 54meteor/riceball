package net.yasite.testinfo;

import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.net.HandlerHelp;
import net.yasite.testinfo.entity.GoodListEntity;
import android.content.Context;
import android.os.Message;

public class MainActivity extends BaseNewActivity {

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
			System.out.println(list.getData().size());
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			list = (GoodListEntity)BaseService.getData(context, 
					"http://www.yasite.net/shopapi/index.php/goodController/getGoodList", 
					GoodListEntity.class);
			
			
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}
}
