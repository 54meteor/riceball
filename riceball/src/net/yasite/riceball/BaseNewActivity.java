package net.yasite.riceball;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public abstract class BaseNewActivity extends FragmentActivity implements ActivityPageSetting{
	public Context context;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		context = this;
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContent();
		if(getIntentValue()){
			setupView();
			setModel();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	protected Button getButton(int id) {
		return (Button) findViewById(id);
	}
	@Override
	protected void onPause() {
		super.onPause();
	}

	protected ImageButton getImageButton(int id) {
		return (ImageButton) findViewById(id);
	}

	protected EditText getEdit(int id) {
		return (EditText) findViewById(id);
	}

	protected TextView getTextView(int id) {
		return (TextView) findViewById(id);
	}

	protected ListView getListView(int id) {
		return (ListView) findViewById(id);
	}

	protected ImageView getImageView(int id) {
		return (ImageView) findViewById(id);
	}
	protected GridView getGridView(int id){
	    return (GridView)findViewById(id);
	}
	protected CheckBox getCheckBox(int id) {
		return (CheckBox) findViewById(id);
	}
	protected RelativeLayout getRelativeLayout(int id) {
        return (RelativeLayout) findViewById(id);
    }
	protected LinearLayout getLinearLayout(int id) {
        return (LinearLayout) findViewById(id);
    }
	protected void setTextViewText(int resourceId,int StringId){
	    getTextView(resourceId).setText(getResources().getString(StringId));
	}
	protected void setTextViewText(int resourceId,String string){
        getTextView(resourceId).setText(string);
    }

	public void pbShow(ProgressBar pb){
		if(pb != null){
			pb.setVisibility(View.VISIBLE);
		}
	}
	public void pbHide(ProgressBar pb){
		if(pb != null){
			pb.setVisibility(View.GONE);
		}
	}
}
