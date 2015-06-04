package net.yasite.testinfo;

import java.util.ArrayList;
import java.util.List;

import net.yasite.riceball.BaseNewActivity;
import net.yasite.riceball.BaseService;
import net.yasite.riceball.net.HandlerHelp;
import net.yasite.testinfo.adapter.MenuListAdapter;
import net.yasite.testinfo.entity.FunctionEntity;
import net.yasite.testinfo.entity.GoodListEntity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends BaseNewActivity  implements OnItemClickListener{
	ListView listView;
	List<FunctionEntity> list = new ArrayList<FunctionEntity>();
	MenuListAdapter adapter;
	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listview);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		setList();
		adapter = new MenuListAdapter(context);
		listView.setAdapter(adapter);
		adapter.setList(list);
		adapter.notifyDataSetChanged();
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	 
	private void setList(){
		list = new ArrayList<FunctionEntity>();
		list.add(setEntity("get«Î«Û", GetActivity.class));
		list.add(setEntity("post«Î«Û", PostActivity.class));
		list.add(setEntity("upload«Î«Û", UploadActivity.class));
	}
	private FunctionEntity setEntity(String name,Class act){
		FunctionEntity entity = new FunctionEntity();
		entity.setFunctionName(name);
		entity.setActivityName(act);
		return entity;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent it = new Intent();
		it.setClass(context, list.get(position).getActivityName());
		startActivity(it);
		
	}
}
