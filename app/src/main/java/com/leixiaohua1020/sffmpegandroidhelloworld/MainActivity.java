package com.leixiaohua1020.sffmpegandroidhelloworld;


import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final TextView libinfoText = (TextView) findViewById(R.id.text_libinfo);
        libinfoText.setMovementMethod(ScrollingMovementMethod.getInstance()); 
        
        libinfoText.setText(configurationinfo());
        
        Button configurationButton = (Button) this.findViewById(R.id.button_configuration);
		Button urlprotocolButton = (Button) this.findViewById(R.id.button_urlprotocol);
		Button avformatButton = (Button) this.findViewById(R.id.button_avformat);
		Button avcodecButton = (Button) this.findViewById(R.id.button_avcodec);
		Button avfilterButton = (Button) this.findViewById(R.id.button_avfilter);
		
		urlprotocolButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				libinfoText.setText(urlprotocolinfo());
			}
		});
		
		avformatButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				libinfoText.setText(avformatinfo());
			}
		});
		
		avcodecButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				libinfoText.setText(avcodecinfo());
			}
		});
		
		avfilterButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				libinfoText.setText(avfilterinfo());
			}
		});
		
		configurationButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				libinfoText.setText(configurationinfo());
			}
		});
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //JNI
    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();
    public native String configurationinfo();
    
    static{
    	System.loadLibrary("avutil-54");
    	System.loadLibrary("swresample-1");
    	System.loadLibrary("avcodec-56");
    	System.loadLibrary("avformat-56");
    	System.loadLibrary("swscale-3");
    	System.loadLibrary("postproc-53");
    	System.loadLibrary("avfilter-5");
    	System.loadLibrary("avdevice-56");
    	System.loadLibrary("sffhelloworld");
    }
    
}
