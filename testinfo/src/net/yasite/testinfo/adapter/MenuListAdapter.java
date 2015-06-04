package net.yasite.testinfo.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.testinfo.R;
import net.yasite.testinfo.entity.FunctionEntity;
import android.R.menu;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class MenuListAdapter extends YasiteAdapter {

	List<FunctionEntity> list = new ArrayList<FunctionEntity>();
	
	
	

	public List<FunctionEntity> getList() {
		return list;
	}

	public void setList(List<FunctionEntity> list) {
		this.list = list;
	}

	public MenuListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	protected void setupChildViews(View convertView, ViewHolder holder) {
		// TODO Auto-generated method stub
		MenuHolder menuHolder = (MenuHolder)holder;
		menuHolder.name = (TextView)convertView.findViewById(R.id.name);
	}

	@Override
	protected void setChildViewData(ViewHolder holder, int position, Object obj) {
		// TODO Auto-generated method stub
		MenuHolder menuHolder = (MenuHolder)holder;
		if(obj instanceof FunctionEntity){
			FunctionEntity entity = (FunctionEntity)obj;
			 menuHolder.name.setText(entity.getFunctionName());
		}
	}

	@Override
	protected ViewHolder setHolder() {
		// TODO Auto-generated method stub
		return new MenuHolder();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.menu_list_item;
	}
	
	class MenuHolder extends ViewHolder{
		TextView name;
	}


}
