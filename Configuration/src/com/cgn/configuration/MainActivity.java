package com.cgn.configuration;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	public EditText ori;
	public EditText navigation;
	public EditText touch;
	public EditText mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ori = (EditText) findViewById(R.id.EditText01);
        navigation = (EditText) findViewById(R.id.EditText02);
        touch = (EditText) findViewById(R.id.EditText03);
        mnc = (EditText) findViewById(R.id.EditText04);
        
        Button bt = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        

		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//��ȡϵͳ�Ĳ���
				Configuration cfg = getResources().getConfiguration();
				String screen = cfg.orientation == 
						Configuration.ORIENTATION_LANDSCAPE ? "������Ļ"
						: "������Ļ";
				String mncCode = cfg.mnc + "";
				
				String naviName = cfg.orientation ==
						Configuration.NAVIGATION_NONAV 
						? "û�з������" :
							cfg.orientation == Configuration.NAVIGATION_WHEEL
							? "���ַ������" :
								cfg.orientation == Configuration.NAVIGATION_DPAD
								? "������̿���" : "�켣�����";
				
				String touchName = cfg.touchscreen == 
					Configuration.TOUCHSCREEN_NOTOUCH
					? "�޴�����" : cfg.orientation == 
					Configuration.TOUCHSCREEN_STYLUS
					? "�������Դ�����" : "������ָ�Ĵ�����" ;
						
					ori.setText(screen);
					mnc.setText(mncCode);
					navigation.setText(naviName);
					touch.setText(touchName);
			}
		});
		
		//��дOnConfigurationChanged ��Ӧϵͳ���ø���
		bt2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
			
				Configuration config = getResources().getConfiguration();
				//�����ǰ��ĻΪ����
				if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
					
					//����Ϊ����
					MainActivity.this.setRequestedOrientation
					(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				
				//�����ǰ��ĻΪ����
				
				if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
					
					//����Ϊ����
					MainActivity.this.setRequestedOrientation
					(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);	
				}
				
			}
		});		
	}
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	
    	String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
    			? "������Ļ" : "������Ļ";
    	Toast.makeText(this, "ϵͳ����Ļ�������ı�" +"\n �޸ĺ����Ļ����Ϊ��" + screen, 
    			Toast.LENGTH_LONG).show();
    }
    
}
