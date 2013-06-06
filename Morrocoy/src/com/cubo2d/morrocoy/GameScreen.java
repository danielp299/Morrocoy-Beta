package com.cubo2d.morrocoy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameScreen implements Screen, GestureListener {
	private Stage stage;
	private LogicGame trafficGame;
	private MyGame game;
	Enemy salir;
	int blen = 0; 
	public InputMultiplexer multiplexer;
	
	public GameScreen(MyGame _game , int nivel) {
		stage = new Stage();
		game = _game;
		trafficGame = new LogicGame(nivel,game);
		stage.addActor(trafficGame);
		
		
		//salir
		
		TextButton salir = new TextButton("Salir", Assets.skin);
		salir.setBounds(Gdx.graphics.getWidth()-Assets.escala,0,Assets.escala,Assets.escala);
		stage.addActor(salir);
		
		salir.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				//System.out.println(""+event.toString());
				
				if(event.toString() == "touchDown"){
					Assets.menu.play();
					game.menu();
				}
				
				return false;
			}
		});
		
				
				multiplexer = new InputMultiplexer();
				multiplexer.addProcessor(new GestureDetector(this));
				multiplexer.addProcessor(stage);
	}
	

	
	public void resize(int width, int height) {
		stage.setViewport(MyGame.WIDTH, MyGame.HEIGHT, true);
		stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);
	}

	@Override
	public void render(float delta) {
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(multiplexer);
		
	}

	@Override 
    public void hide() {
    	Gdx.input.setInputProcessor(null);
    }
	
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		if (velocityY < -100) trafficGame.playerCar.tryMoveUp();
		if (velocityY > 100) trafficGame.playerCar.tryMoveDown();
		
		return false;
	}

	@Override public boolean touchDown(float x, float y, int pointer, int button) {
		
		if(y > Gdx.graphics.getHeight()-Assets.escala){
		
		
		trafficGame.playerCar.button1(x,Gdx.graphics.getHeight()- y);
		
		}
		

		return false;
	}
	
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {}	
	@Override public boolean tap(float x, float y, int count, int button) {return false;}
	
	@Override public boolean longPress(float x, float y) {return false;}
	@Override public boolean pan(float x, float y, float deltaX, float deltaY) {return false;}
	@Override public boolean zoom(float initialDistance, float distance) {return false;}
	@Override public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {return false;}

}
