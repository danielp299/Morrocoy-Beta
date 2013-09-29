package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Tutorial extends Table{
	//moverse y donde estan las vidas
	//usar los poderes
	// ganar logros

	Imagenes tutorialEstrella;
	Imagenes tutorialPowConejo ;
	Imagenes tutorialMasConejo;
	Imagenes tutorialRapido ;
	Imagenes tutorialDefensa ;
	Imagenes tutorialVida ;
	Imagenes tutorialMover;
	Imagenes foco;
	//Dedo dedo;
	
	public Dedo dedo;
	public int actual;
	public int max;
	public boolean tutorialCompleto = false;
	
	public TextButton bsalir ;
	public TextButton bsiguiente;
	public TextButton batras;
	
	public Tutorial() {
		// TODO Auto-generated constructor stub
		//dedo = new Dedo();
		setBounds(0,Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//setBackground(Assets.skin.getDrawable("fondo_tabla"));
		right();
		top();
		pad(Assets.escala);
		//setLayoutEnabled(false);
		bsalir = new TextButton("Salir",Assets.skin);
		bsiguiente = new TextButton("siguiente",Assets.skin);
		batras = new TextButton("",Assets.skin);
		
		tutorialMover = new Imagenes(Assets.tutorialMover);
		tutorialEstrella = new Imagenes(Assets.tutorialEstrellas);
		tutorialPowConejo = new Imagenes(Assets.tutorialPowConejo);
		tutorialMasConejo =new Imagenes(Assets.tutorialMasConejo);
		tutorialRapido = new  Imagenes(Assets.tutorialRapido);
		tutorialDefensa = new Imagenes(Assets.tutorialDefensa);
		tutorialVida = new Imagenes(Assets.tutorialVida);
		foco = new Imagenes(Assets.foco);
		dedo = new Dedo();
		
		tutorialMover.setBounds(getHeight()/2-Assets.escala/2, Assets.escala, Assets.escala*2, Assets.escala*3);
		tutorialEstrella.setBounds(getX()+Assets.escala*2, Assets.escala*3, Assets.escala*3, Assets.escala); 
		tutorialPowConejo.setBounds(getX()+Assets.escala*2, Assets.escala, Assets.escala*3, Assets.escala);
		
		tutorialMasConejo.setBounds(getX()+Assets.escala, Assets.escala, Assets.escala*4, Assets.escala*3);
		
		tutorialRapido.setBounds(getX()+Assets.escala*2, Assets.escala, Assets.escala*3, Assets.escala); ;
		tutorialDefensa.setBounds(getX()+Assets.escala*2, Assets.escala*2, Assets.escala*3, Assets.escala); 
		tutorialVida.setBounds(getX()+Assets.escala*2, Assets.escala*3, Assets.escala*3, Assets.escala); 
		
		foco.setBounds(getWidth()-Assets.escala*3, Assets.escala*3, Assets.escala, Assets.escala); 
		dedo.setBounds(tutorialMover.getWidth()+tutorialMover.getX()+Assets.escala/5, Assets.escala*3, Assets.escala*2, Assets.escala*2); 
		
		
		dedo.addAction(visible(false));
		foco.addAction(visible(false));
		tutorialEstrella.addAction(visible(false));
		tutorialPowConejo.addAction(visible(false));
		tutorialMasConejo.addAction(visible(false));
		tutorialRapido.addAction(visible(false));
		tutorialDefensa.addAction(visible(false));
		tutorialVida.addAction(visible(false));
	
		
		addActor(tutorialMover);
		addActor(tutorialEstrella);
		addActor(tutorialPowConejo);
		addActor(tutorialMasConejo);
		addActor(tutorialRapido);
		addActor(tutorialDefensa);
		addActor(tutorialVida);
		
		addActor(foco);
		addActor(dedo);
		
		add(bsiguiente).width(Assets.escala*1.5f).height(Assets.escala);
		row();
		add(batras).width(Assets.escala*1.5f).height(Assets.escala);
		row();
		add(bsalir).width(Assets.escala*1.5f).height(Assets.escala);
		
		bsalir.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					salir();
				}
				return false;
			}});
		bsiguiente.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					proximo();
				}
				return false;
			}});
		
		batras.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					if(actual>=0)
					actual-=2;
					proximo();
					
				}
				return false;
			}});
		
		max =4;
		actual = max;
	}
	
	public void tutorial(){
			actual = -1;
			addAction(sequence(visible(true),moveTo(0,0,1)));
			proximo();
			}
	
	public void proximo(){
		if(actual<max){
			actual++;
		}else{
			/*if(tutorialCompleto){
				
			}
			actual= 0;
			tutorialCompleto = true;*/
			salir();
		}
		
		//System.out.println(actual);
		
		foco.clearActions();
		tutorialMover.clearActions();
		tutorialEstrella.clearActions();
		tutorialPowConejo.clearActions();
		tutorialMasConejo.clearActions();
		tutorialRapido.clearActions();
		tutorialDefensa.clearActions();
		tutorialVida.clearActions();
		dedo.clearActions();
		
		dedo.addAction(visible(false));
		foco.addAction(visible(false));
		tutorialMover.addAction(visible(false));
		tutorialEstrella.addAction(visible(false));
		tutorialPowConejo.addAction(visible(false));
		tutorialMasConejo.addAction(visible(false));
		tutorialRapido.addAction(visible(false));
		tutorialDefensa.addAction(visible(false));
		tutorialVida.addAction(visible(false));
		
			switch (actual) {
			case 0:

				tutorialMover.addAction(visible(true));
				dedo.addAction(visible(true));
				dedo.setBounds(tutorialMover.getWidth()+tutorialMover.getX()+Assets.escala/5, Assets.escala*3, Assets.escala*2, Assets.escala*2); 
				dedo.addAction(forever(sequence(visible(true),moveBy(0, -Assets.escala*3,2f),moveBy(0, Assets.escala*3,2f),delay(0.5f))));
				break;

			case 1:
				
				//dedo.addAction(sequence(fadeOut(0.1f),visible(false)));
				//tutorialMover.addAction(sequence(fadeOut(0.1f),visible(false)));
				tutorialEstrella.addAction(sequence(visible(true)));
				foco.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2-Assets.escala/2);
				foco.addAction(sequence(visible(true),moveTo(Gdx.graphics.getWidth()-Assets.escala, Gdx.graphics.getHeight()-Assets.escala-Assets.escala/3,1f),delay(2f),moveTo(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2-Assets.escala/2,1f),delay(0.5f),moveTo(0+Assets.escala, Gdx.graphics.getHeight()-Assets.escala-Assets.escala/3,1f)));
				tutorialPowConejo.addAction(sequence(delay(4f),visible(true)));
				
				break;

			case 2:
				
				tutorialEstrella.addAction(visible(false));
				tutorialPowConejo.addAction(visible(false));
				foco.addAction(visible(false));
				tutorialMasConejo.addAction(visible(true));
				break;

			case 3:
				tutorialMasConejo.addAction(visible(false));
				tutorialVida.addAction(visible(true));
				tutorialDefensa.addAction(sequence(delay(1f),visible(true)));
				tutorialRapido.addAction(sequence(delay(2),visible(true)));
				//dedo.clearActions();
				dedo.addAction(visible(true));
				dedo.setPosition(0, -Assets.escala*2); 
				dedo.addAction(forever(sequence(delay(3),moveTo(Gdx.graphics.getWidth()-Assets.escala, -Assets.escala,2f),delay(1f),moveTo(Gdx.graphics.getWidth()-Assets.escala*2, -Assets.escala,2f),delay(1f),moveTo(Gdx.graphics.getWidth()-Assets.escala*3, -Assets.escala,2f))));
				
				
				break;

			default:
				break;
			}
		
		
	}
	
	
	public void salir(){
		foco.addAction(visible(false));
		dedo.addAction(visible(false));
		tutorialEstrella.addAction(visible(false));
		tutorialPowConejo.addAction(visible(false));
		tutorialMasConejo.addAction(visible(false));
		tutorialRapido.addAction(visible(false));
		tutorialDefensa.addAction(visible(false));
		tutorialVida.addAction(visible(false));
		addAction(sequence(moveTo(0, Gdx.graphics.getHeight(),1),visible(false)));
		
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		/*
		 * if(isVisible()){
			
		}
		*/
	}
	
	private class Imagenes extends Actor{
		TextureRegion imagen;
		
		public Imagenes( TextureRegion region) {
			// TODO Auto-generated constructor stub
			imagen = region;
		}
		
		
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			batch.draw(imagen, getX(), getY(),getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		}
	}
	
private class Dedo extends Actor{
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			batch.draw(Assets.dedo, getX(), getY(),getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		}
	}
	
}
