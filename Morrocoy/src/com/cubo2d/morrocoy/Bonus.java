package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bonus extends Enemy{
	private int tipo;
	private int index;
	float stateTime;
	
	public boolean esActivo = false;

	public Bonus(float x, float y, int _tipo) {
		super(x, y,3,6);
		// TODO Auto-generated constructor stub
		tipo = _tipo;
	
		setColor(Color.WHITE);

		esActivo = false;
		index = -1;
		stateTime =0;

	}
	
	public int getTipo(){
		
		return tipo;
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(new Color(1f, 1f, 1f,getColor().a));	
		if(tipo == 0){

			if(esActivo){
				batch.draw(Assets.defensaCamina.getKeyFrame(stateTime), getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), Assets.escala, 1, 1, getRotation());			
			}else{
				batch.draw(Assets.defensa_icono, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
				}
			}else if(tipo == 1){
				if(esActivo){
					batch.draw(Assets.comidaCamina.getKeyFrame(stateTime), getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), Assets.escala, 1, 1, getRotation());			
				}else{
					batch.draw(Assets.comida_icono, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
					} 
			}else if(tipo == 2){
				if(esActivo){
					batch.draw(Assets.rapidoCamina.getKeyFrame(stateTime), getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), Assets.escala, 1f, 1.5f,  getRotation());			
					
				}else{
					batch.draw(Assets.rapido_icono, getX(), getY(), getWidth()/2, getHeight()/2,Assets.escala , Assets.escala, 1, 1, getRotation());			
					}
			}

		
		//Assets.font.draw(batch,""+index, getX(), getY());
	}
	
	public void setStateTime(float st){
		
		stateTime = st;
	}
	
	public void crash(int posicion) {
		clearActions();
		index = posicion;
		//addAction(fadeOut(1f));
		if (posicion == 0) addAction(sequence(parallel(rotateBy(-720, 1f), moveTo(Gdx.graphics.getWidth() -Assets.escala, 0,1f))));
		if (posicion == 1) addAction(sequence(parallel(rotateBy(720, 1f), moveTo(Gdx.graphics.getWidth() -Assets.escala*2, 0,1f) )));
		if (posicion == 2) addAction(sequence(parallel(rotateBy(720, 1f), moveTo(Gdx.graphics.getWidth() -Assets.escala*3, 0,1f))));
		if (posicion > 2) {addAction(sequence(parallel(rotateBy(-720, 1f), moveTo(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),1f),fadeOut(0.8f)), removeActor()));
		}
		}
	
	public int getindex(){
		return index;
	}
	
	public void BonusActivo(){
		clearActions();
		setColor(Color.PINK);
		if(tipo == 0){
			}else if(tipo == 1){
				} else if(tipo == 2){
				}
		addAction(fadeOut(4f));
		addAction(sequence(scaleBy(200, 200, 4f),visible(false)));
	}
	
	public void ActivarBonus(){
		esActivo = true;
	}
	
	public void BonusPasivo(){
		if(tipo == 0){
			}else if(tipo == 1){
				} else if(tipo == 2){
				}
		
	}

}
