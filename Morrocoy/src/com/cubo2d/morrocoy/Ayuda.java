package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.visible;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Ayuda extends Table {

	//Image image1;
	//Image image2;
	//Image image3;
	public Label ayuda1;
	public Label ayuda2;
	public Label ayuda3;
	String Texto;
	int imagenActual;
	ImageButton cerrar;
	
	public Ayuda() {
		// TODO Auto-generated constructor stub
		setBounds(0, 0,Gdx.graphics.getWidth()	*3, Gdx.graphics.getHeight());
		setBackground(Assets.skin.getDrawable("fondo_tabla"));
		
		ayuda1 = new Label(Texto, Assets.skin);
		ayuda2 = new Label(Texto, Assets.skin);
		ayuda3 = new Label(Texto, Assets.skin);
		
		cerrar = new ImageButton(Assets.skin.getDrawable("cerrar"));
		
		cerrar.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {

				if(event.toString() == "touchDown"){
					addAction(sequence( moveTo(0,Gdx.graphics.getHeight(),1f),visible(false)));
				}
				return false;
			}
		});
		
		add(ayuda1).right().expand(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
	    add(ayuda2).center().expand(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
		add(ayuda3).center().expand(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());
		
		
		add(cerrar).width(Assets.escala/2).height(Assets.escala/2).left();
		
		imagenActual =0;
	}
	
	public void mostrarAyuda(){

	}
	
	public void mostrarAcerca(){
		
	}

	public void moverDerecha(){
		if(getActions().size == 0){
			if(imagenActual == 0){
			addAction(moveTo(-Gdx.graphics.getWidth(), 0,1f));
			imagenActual++;
			}else if(imagenActual == 1){
			addAction(moveTo(-Gdx.graphics.getWidth()*2, 0,1f));
			imagenActual++;
			}
		}
	}
	
	public void moverIzquierda(){
		if( getActions().size == 0){
			if(imagenActual == 2){
			addAction(moveTo(-Gdx.graphics.getWidth(), 0,1f));
			imagenActual--;
			}else if(imagenActual == 1){
			addAction(moveTo(0, 0,1f));
			imagenActual--;
			}
		}
	}
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}
	
	
	
	

		
	

	
}
