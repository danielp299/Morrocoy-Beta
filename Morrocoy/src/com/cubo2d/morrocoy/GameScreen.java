package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.visible;

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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameScreen implements Screen, GestureListener {
	private Stage stage;
	private LogicGame trafficGame;
	private MyGame game;
	Enemy salir;
	int blen = 0; 
	public InputMultiplexer multiplexer;
	public Table botonesInferiores;
	public Ayuda ayuda;
	TextButton bMenu;
	TextButton bsalir;
	TextButton reiniciar;
	TextButton bayuda;
	Tutorial tutorial;
	public boolean pausa;
	
	public GameScreen(MyGame _game , int nivel) {
		stage = new Stage();
		game = _game;
		trafficGame = new LogicGame(nivel,game);
		stage.addActor(trafficGame);
		ayuda = new Ayuda();
		pausa = true;
		//botones inferiores
		
		botonesInferiores = new Table();
		botonesInferiores.setBounds(-botonesInferiores.getWidth(),Assets.escala/2, Assets.escala*2,Gdx.graphics.getHeight()-Assets.escala);
		botonesInferiores.setBackground(Assets.skin.getDrawable("fondo_tabla"));
		botonesInferiores.addAction(sequence( moveTo(-botonesInferiores.getWidth(),botonesInferiores.getY(),0.75f),visible(false)));
		stage.addActor(botonesInferiores);
		

		bMenu = new TextButton("Menu", Assets.skin);
		bMenu.setBounds(0, Gdx.graphics.getHeight()-Assets.escala, Assets.escala, Assets.escala);
		bMenu.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				//System.out.println(""+event.toString());
				
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					menu();
				}
				
				return false;
			}
		});
		
		
		
		//salir
		
		bsalir = new TextButton("Salir", Assets.skin);
		bsalir.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				//System.out.println(""+event.toString());
				
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					game.menu();
				}
				
				return false;
			}
		});
		
		//reiniciar
		reiniciar = new TextButton("Repetir", Assets.skin);
		reiniciar.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				// TODO Auto-generated method stub
				//System.out.println(""+event.toString());
				
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					menu();
					trafficGame.reiniciar();
				
					//tutorial.tutorial();
				}
				
				return false;
			}
		});
		//Ayuda
				bayuda = new TextButton("Ayuda", Assets.skin);
				bayuda.addListener(new EventListener() {
					
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							Assets.menu.play(Assets.volumen);
							if(!ayuda.isVisible()){
								ayuda.setVisible(true);
								ayuda.addAction( moveTo(0,0,1f));
								trafficGame.Pause();
							
							}else{
								ayuda.addAction(sequence( moveTo(0,Gdx.graphics.getHeight(),1f),visible(false)));
								//game.ExternalHandler.showAd(true);
								trafficGame.Resumen();
							}
						}
						
						return false;
					}
				});
				ayuda.setPosition(0, Gdx.graphics.getHeight());
				ayuda.setVisible(false);
				stage.addActor(ayuda);
				botonesInferiores.add(bayuda).width(Assets.escala).height(Assets.escala);
				botonesInferiores.row();
				botonesInferiores.add(reiniciar).width(Assets.escala).height(Assets.escala);
				botonesInferiores.row();
				botonesInferiores.add(bsalir).width(Assets.escala).height(Assets.escala);
				stage.addActor(bMenu);
				
				tutorial = new Tutorial();
				
				stage.addActor(tutorial);
				
				
				multiplexer = new InputMultiplexer();
				multiplexer.addProcessor(new GestureDetector(this));
				multiplexer.addProcessor(stage);
				if(nivel==1){
					tutorial.tutorial();
				}else{
					tutorial.salir();
				}
				
				cambiarIdioma();
				
	}
	
	public void menu(){
		if(botonesInferiores.getActions().size == 0)
		if(botonesInferiores.isVisible()){
			botonesInferiores.addAction(sequence( moveTo(-botonesInferiores.getWidth(),botonesInferiores.getY(),0.75f),visible(false)));
		}else{
			botonesInferiores.addAction(sequence(visible(true), moveTo(-Assets.escala/2,botonesInferiores.getY(),0.75f)));
		}
		
	}

	
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
		stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);
		Assets.resise();
	}

	@Override
	public void render(float delta) {
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		if(!trafficGame.playerCar.estaVivo() && !botonesInferiores.isVisible()){
			menu();
		}
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(multiplexer);
		
	}

	@Override 
    public void hide() {
    	Gdx.input.setInputProcessor(null);
    	Assets.musica.pause();
    }
	
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		if (velocityY < -100) trafficGame.tratarDeSubir();
		if (velocityY > 100) trafficGame.tratarDeBajar();
		if(ayuda.isVisible()){
			if(velocityX > 100){
				ayuda.moverIzquierda();
			}else if(velocityX < -100){
				ayuda.moverDerecha();
			}
		}
		
		return false;
	}

	@Override public boolean touchDown(float x, float y, int pointer, int button) {
		if(trafficGame.isPause() && !tutorial.isVisible() && !ayuda.isVisible()){
			trafficGame.Resumen();
		}
		
		
		if(y > Gdx.graphics.getHeight()-Assets.escala){
		
		trafficGame.boton(x,Gdx.graphics.getHeight()- y);
		}
		

		return false;
	}
	
	public void cambiarIdioma(){
		trafficGame.cambiarIdioma();
		bMenu.setText(""+game.idioma.jMenu);
		bsalir.setText(""+game.idioma.Atras);
		reiniciar.setText(""+game.idioma.jRepetir);
		bayuda.setText(""+game.idioma.jAyuda);
		ayuda.ayuda1.setText(""+game.idioma.aPagina1);
		ayuda.ayuda2.setText(""+game.idioma.aPagina2);
		ayuda.ayuda3.setText(""+game.idioma.aPagina3);
		tutorial.bsalir.setText(""+game.idioma.mSalir);
		tutorial.bsiguiente.setText(""+game.idioma.rSiguiente);
		tutorial.batras.setText(""+game.idioma.Atras);
	}
	
	@Override public void resume() {}
	@Override public void pause() {}
	@Override public void dispose() {
		//stage.dispose();
		Assets.musica.dispose();
	}	
	@Override public boolean tap(float x, float y, int count, int button) {return false;}
	
	@Override public boolean longPress(float x, float y) {return false;}
	@Override public boolean pan(float x, float y, float deltaX, float deltaY) {return false;}
	@Override public boolean zoom(float initialDistance, float distance) {return false;}
	@Override public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {return false;}

}
