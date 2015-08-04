package net.yasite.testinfo;

import java.io.File;

import net.yasite.riceball.DownloadProgressListener;
import net.yasite.riceball.net.httpclient.HttpDownload;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadActivity extends Activity {
    private EditText downloadpathText;
    private TextView resultView;
    private ProgressBar progressBar;
    //当Handler被创建会关联到创建它的当前线程的消息队列，该类用于往消息队列发送消息
    //消息队列中的消息由当前线程内部进行处理
    private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {			
			switch (msg.what) {
			case 1:				
				progressBar.setProgress(msg.getData().getInt("size"));
				float num = (float)progressBar.getProgress()/(float)progressBar.getMax();
				int result = (int)(num*100);
				resultView.setText(result+ "%");
				if(progressBar.getProgress()==progressBar.getMax()){
					Toast.makeText(DownloadActivity.this, R.string.success, 1).show();
				}
				break;

			case -1:
				Toast.makeText(DownloadActivity.this, R.string.error, 1).show();
				break;
			}
		}
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_layout);
        
        downloadpathText = (EditText) this.findViewById(R.id.downloadpath);
        progressBar = (ProgressBar) this.findViewById(R.id.downloadbar);
        resultView = (TextView) this.findViewById(R.id.result);
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String path = downloadpathText.getText().toString();
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
					download(path, Environment.getExternalStorageDirectory());
				}else{
					Toast.makeText(DownloadActivity.this, R.string.sdcarderror, 1).show();
				}
				
			}
		});
    }
    //主线程(UI线程)
    //业务逻辑正确，但是该程序运行的时候有问题
    //对于显示控件的界面更新只是由UI线程负责，如果是在非UI线程更新控件的属性值，更新后的显示界面不会反映到屏幕上
    private void download(final String path, final File savedir) {
    	System.out.println(path);
    	new Thread(new Runnable() {			
			@Override
			public void run() {
				HttpDownload loader = new HttpDownload(DownloadActivity.this, path, savedir, 3);
		    	progressBar.setMax(loader.getFileSize());//设置进度条的最大刻度为文件的长度
				try {
					loader.download(new DownloadProgressListener() {
						@Override
						public void onDownloadSize(int size) {//实时获知文件已经下载的数据长度
							Message msg = new Message();
							msg.what = 1;
							msg.getData().putInt("size", size);
							handler.sendMessage(msg);//发送消息
						}
					});
				} catch (Exception e) {
					handler.obtainMessage(-1).sendToTarget();
				}
			}
		}).start();
	}
}