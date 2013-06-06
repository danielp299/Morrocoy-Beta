package com.cubo2d.morrocoy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
public class Menu implements Screen{
	
	
	Table table;
	Table niveles;
	Table opciones;
	Table puntuaciones;
	
	MyGame game;
	private Stage stage;
	Fondo fondo;
	
	public Menu(MyGame _migame) {
		game = _migame;
		stage = new Stage();
		fondo = new Fondo();
		stage.addActor(fondo);
		
		table = new Table();
		table.debug();
		table.debugTable();
		//table.setLayoutEnabled(false);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
				TextButton button = new TextButton("Jugar", Assets.skin);
				button.setName("Jugar");
				//button.setBounds(Assets.escala, Assets.escala*3,Assets.escala*2,Assets.escala);
				
				
				TextButton butto2n = new TextButton("Puntuaciones", Assets.skin);
				//butto2n.setBounds(Assets.escala, Assets.escala*2,Assets.escala*2,Assets.escala);
				
				
				TextButton salir = new TextButton("salir", Assets.skin);
				//salir.setBounds(Assets.escala, Assets.escala*1,Assets.escala*2,Assets.escala);
				
				
				//table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);
				
				
				
				table.center();
				table.add(button).width(Assets.escala*2);
				table.row();
				table.add(butto2n).width(Assets.escala*2);
				table.row();
				table.add(salir).width(Assets.escala*2);
				
				niveles = new Table();
				niveles.setVisible(false);
				niveles.center();
					
				menuNiveles();
				
				
				
				
				niveles.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				stage.addActor(table);
				stage.addActor(niveles);
				
				
				
				button.addListener(new EventListener() {
					
					

					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							niveles.setVisible(true);
							Assets.menu.play();
							table.setVisible(false);
						}
						
						return false;
					}
				});
				
				salir.addListener(new EventListener() {
					
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							Gdx.app.exit();
						}
						
						return false;
					}
				});
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	
		stage.act(delta);
		stage.draw();
		//Table.drawDebug(stage);
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		table.setWidth(width);
		table.setHeight(height);
		stage.setViewport(MyGame.WIDTH, MyGame.HEIGHT, true);
		stage.getCamera().translate(stage.getGutterWidth(), stage.getGutterHeight(), 0);
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		//Gdx.input.setInputProcessor(new GestureDetector(this));
		Gdx.input.setInputProcessor(stage);
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
    	Gdx.input.setInputProcessor(null);
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrarPuntuaciones(){
		
	}
	
	public void menuNiveles(){
		TextButton nivel = new TextButton("nivel "+1, Assets.skin);
		niveles.add(nivel).width(Assets.escala);
		nivel.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[0].bloquedo){
					Assets.menu.play();
					game.jugar(1);	
					}
				}	
				return false;
			}});
		
		TextButton nivel2 = new TextButton("nivel "+2, Assets.skin);
		niveles.add(nivel2).width(Assets.escala);
		nivel2.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){

					if(!game.jugador.Niveles[1].bloquedo)
					game.jugar(2);	
				}	
				return false;
			}});
		
		TextButton nivel3 = new TextButton("nivel "+3, Assets.skin);
		niveles.add(nivel3).width(Assets.escala);
		nivel3.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){

					if(!game.jugador.Niveles[2].bloquedo){
					game.jugar(3);	
					}
				}	
				return false;
			}});
		
		niveles.row();
		
		TextButton nivel4 = new TextButton("nivel "+4, Assets.skin);
		niveles.add(nivel4).width(Assets.escala);
		nivel4.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[3].bloquedo)
					game.jugar(4);	
				}	
				return false;
			}});
		
		TextButton nivel5 = new TextButton("nivel "+5, Assets.skin);
		niveles.add(nivel5).width(Assets.escala);
		nivel5.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[4].bloquedo)
					game.jugar(5);	
				}	
				return false;
			}});
		
		TextButton nivel6 = new TextButton("nivel "+6, Assets.skin);
		niveles.add(nivel6).width(Assets.escala);
		nivel6.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[5].bloquedo)
					game.jugar(6);	
				}	
				return false;
			}});
		niveles.row();
		TextButton nivel7 = new TextButton("nivel "+7, Assets.skin);
		niveles.add(nivel7).width(Assets.escala);
		nivel7.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[6].bloquedo)
					game.jugar(7);	
				}	
				return false;
			}});
		
		TextButton nivel8 = new TextButton("nivel "+8, Assets.skin);
		niveles.add(nivel8).width(Assets.escala);
		nivel8.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[7].bloquedo)
					game.jugar(8);	
				}	
				return false;
			}});
		
		TextButton nivel9 = new TextButton("nivel "+9, Assets.skin);
		niveles.add(nivel9).width(Assets.escala);
		nivel9.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[8].bloquedo)
					game.jugar(9);	
				}	
				return false;
			}});
		niveles.row();
		TextButton atras = new TextButton("Atras ", Assets.skin);
		niveles.add(atras).width(Assets.escala);
		atras.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play();
					table.setVisible(true);
					niveles.setVisible(false);
				}	
				return false;
			}});
		
		
	}
	
	public void menuOpciones(){
		TextButton reiniciarPerfil = new TextButton("nivel "+1, Assets.skin);
		niveles.add(reiniciarPerfil).width(Assets.escala);
		reiniciarPerfil.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[0].bloquedo){
					Assets.menu.play();
					game.jugador.nuevo();	
					}
				}	
				return false;
			}});
	}
	
	private class Fondo extends Actor{
		
		public Fondo() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			batch.draw(Assets.road, 0, 0,Assets.road.getRegionWidth()/2,Assets.road.getRegionHeight()/2,Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1, 1, getRotation());			
			
		}
		
	}

}
