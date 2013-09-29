package com.cubo2d.morrocoy;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Morrocoy";
		cfg.useGL20 = false;
		cfg.width =800;
		cfg.height = 480;
		
		new LwjglApplication(new MyGame(new IReqHandler() {
			
			@Override
			public void showFullAd(boolean show) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void showAd(boolean show) {
				// TODO Auto-generated method stub
				
			}
		}), cfg);
	}
}
