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
				//获取系统的布局
				Configuration cfg = getResources().getConfiguration();
				String screen = cfg.orientation == 
						Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕"
						: "竖向屏幕";
				String mncCode = cfg.mnc + "";
				
				String naviName = cfg.orientation ==
						Configuration.NAVIGATION_NONAV 
						? "没有方向控制" :
							cfg.orientation == Configuration.NAVIGATION_WHEEL
							? "滚轮方向控制" :
								cfg.orientation == Configuration.NAVIGATION_DPAD
								? "方向键盘控制" : "轨迹球控制";
				
				String touchName = cfg.touchscreen == 
					Configuration.TOUCHSCREEN_NOTOUCH
					? "无触摸屏" : cfg.orientation == 
					Configuration.TOUCHSCREEN_STYLUS
					? "触摸笔试触摸屏" : "接受手指的触摸屏" ;
						
					ori.setText(screen);
					mnc.setText(mncCode);
					navigation.setText(naviName);
					touch.setText(touchName);
			}
		});
		
		//重写OnConfigurationChanged 响应系统设置更改
		bt2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
			
				Configuration config = getResources().getConfiguration();
				//如果当前屏幕为横屏
				if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
					
					//设置为竖屏
					MainActivity.this.setRequestedOrientation
					(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				
				//如果当前屏幕为竖屏
				
				if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
					
					//设置为竖屏
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
    			? "横向屏幕" : "竖向屏幕";
    	Toast.makeText(this, "系统的屏幕方向发生改变" +"\n 修改后的屏幕方向为：" + screen, 
    			Toast.LENGTH_LONG).show();
    }
    
}
