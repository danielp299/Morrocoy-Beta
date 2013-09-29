package com.cubo2d.morrocoy;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.ads.*;
//import com.g

public class MainActivity extends AndroidApplication {
	//private static final String MY_AD_UNIT_ID = "ca-pub-0830572119976712";
	private AdView adView;
	protected AdView fullAdView; //big ad
	private final String ADCODE = "a151b6b4d1c7006";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        //initialize(new MyGame(), cfg);
        //this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        RelativeLayout layout = new RelativeLayout(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        View gameView = initializeForView(new MyGame(new RequestHandler(adView, fullAdView)), cfg);
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        
        //AdSize ss = new AdSize((int)metrics.widthPixels/2,(int) metrics.heightPixels/6);
        
        
        adView = new AdView(this,AdSize.BANNER, ADCODE);
        
       
        
        AdRequest adRequest = new AdRequest();
        //adRequest.addKeyword(keyword)
        
        adView.loadAd(adRequest);
        RelativeLayout.LayoutParams adParams = 
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
     
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        
        layout.addView(gameView);
        layout.addView(adView, adParams);
        
        
        //fullAdView.setVisibility(View.GONE); //closed at the start
        
        // logros
        
        
        setContentView(layout);
    }
    
    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
    
    
    public class RequestHandler implements IReqHandler {

    	protected AdView adV;
    	protected AdView fadV;
    	protected int adHeight = 10;

    	private final int SHOW_ADS = 1;
    	private final int HIDE_ADS = 0;
    	private final int SHOW_FULLADS = 3;
    	private final int HIDE_FULLADS = 4;
    	
    	public void showFullAd(boolean show) {
    		handler.sendEmptyMessage(show ? SHOW_FULLADS : HIDE_FULLADS);
    	}

    	public RequestHandler(AdView adView, AdView fad) {
    		this.adV = adView;
    		this.fadV = fad;
    	}

    	public void showAds(boolean show) {
    		handler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
    	}

    	protected Handler handler = new Handler() {
    		@Override
    		public void handleMessage(Message msg) {
    			switch (msg.what) {
    			case SHOW_ADS: {
    				adV.setVisibility(View.VISIBLE);
    				break;
    			}
    			case HIDE_ADS: {
    				adV.setVisibility(View.GONE);
    				break;
    			}
    			case SHOW_FULLADS: {
    				fadV.setVisibility(View.VISIBLE);
    				break;
    			}
    			case HIDE_FULLADS: {
    				fadV.setVisibility(View.GONE);
    				break;
    			}
    			}
    		}
    	};

    	@Override
    	public void showAd(boolean show) {
    		// TODO Auto-generated method stub
    		
    	}
    	

    }
    
  
    
}