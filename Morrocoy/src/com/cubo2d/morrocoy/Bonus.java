package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bonus extends Enemy{
	private int tipo;
	private int index;
	
	public boolean esActivo = false;

	public Bonus(float x, float y, int _tipo) {
		super(x, y);
		// TODO Auto-generated constructor stub
		tipo = _tipo;
	
		setColor(Color.WHITE);

		esActivo = false;
		index = -1;

	}
	
	public int getTipo(){
		
		return tipo;
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		if(tipo == 0){

			if(esActivo){
				batch.draw(Assets.defensa, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
			}else{
				batch.draw(Assets.defensa_icono, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
				}
			}else if(tipo == 1){
				if(esActivo){
					batch.draw(Assets.comida, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
				}else{
					batch.draw(Assets.comida_icono, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
					} 
			}else if(tipo == 2){
				if(esActivo){
					batch.draw(Assets.rapido, getX()-50, getY()-20, getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1f, 2.5f, 270);			
					
					
				}else{
					batch.draw(Assets.rapido_icono, getX(), getY(), getWidth()/2, getHeight()/2, Assets.escala, Assets.escala, 1, 1, getRotation());			
					}
			}

		
		//Assets.font.draw(batch,""+index, getX(), getY());
	}
	
	public void crash(int posicion) {
		clearActions();
		index = posicion;
		//addAction(fadeOut(1f));
		if (posicion == 0) addAction(sequence(parallel(rotateBy(-720, 1f), moveTo(0, 0,1f))));
		if (posicion == 1) addAction(sequence(parallel(rotateBy(720, 1f), moveTo(Assets.bonus_boton.getRegionWidth() , 0,1f) )));
		if (posicion == 2) addAction(sequence(parallel(rotateBy(720, 1f), moveTo(Assets.bonus_boton.getRegionWidth() *2, 0,1f))));
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
		addAction(fadeOut(5f));
		addAction(sequence(scaleBy(200, 200, 5f),visible(false)));
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
