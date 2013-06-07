package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Player extends Actor {
	
	private LogicGame trafficGame;
	private Rectangle bounds = new Rectangle();
	private int lane;
	private int puntos;
	private float velocidad;
	private int vidas;
	private Array<Bonus> bonusArray;
	private int cont_pasivos;
	public boolean inmortal = false;
	//private boolean fantasma = false;
	private float activacionDeInmortal;
	private boolean ocupado[] = new boolean[3]; 
	private float stateTime; 
	public boolean activo;
	
	
	public Player(LogicGame trafficGame) {
		this.trafficGame = trafficGame;
		bonusArray = new Array<Bonus>();
		nuevo();
	}
	
	public void nuevo(){
		setWidth(Assets.escala+(Assets.escala/2));
		setHeight(Assets.escala);
		lane = 1;
		setPosition(100, trafficGame.lane1 - getHeight()/2);
		setColor(Color.WHITE);
		velocidad = Assets.velocidad_global;
		vidas = 3;
		
		Iterator<Bonus> iterB = bonusArray.iterator();
		
		while (iterB.hasNext()) {
			Bonus BonusActual = iterB.next();
			BonusActual.addAction(removeActor());
		}
		bonusArray.clear();
		setActivo(true);
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		updateBounds();
		finInmortal();
	}
	
	public void finInmortal(){
		if(inmortal)
		if (TimeUtils.nanoTime() - activacionDeInmortal> 3000000000f){
			inmortal = false;
		}
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		if(activo)
		stateTime+= Gdx.graphics.getDeltaTime();
		batch.draw(Assets.tortugaCamina.getKeyFrame(stateTime), getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		
		batch.draw(Assets.bonus_boton, 0, 0 ,Assets.escala,Assets.escala);
		batch.draw(Assets.bonus_boton, Assets.bonus_boton.getRegionWidth(), 0,Assets.escala,Assets.escala);
		batch.draw(Assets.bonus_boton, Assets.bonus_boton.getRegionWidth() * 2, 0,Assets.escala,Assets.escala);

	
		
        

        //informacion
        Assets.font.draw(batch, "Puntos: "+puntos+"", Gdx.graphics.getWidth()-Assets.escala, Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/20);
        Assets.font.draw(batch, "Vidas: ["+vidas+"]" + "FPS" + Gdx.graphics.getFramesPerSecond(), 0 , Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/20);
       
        
	}
	
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
		Iterator<Bonus> iterB = bonusArray.iterator();
		cont_pasivos =0;
		ocupado[0] =ocupado[1] =ocupado[2] =false;
		while (iterB.hasNext()) {
			Bonus BonusActual = iterB.next();
			if(BonusActual.esActivo){
				if (BonusActual.isVisible()) {
					//BonusActual.setX(getX());
					BonusActual.setY(getY());
					BonusActual.setStateTime(stateTime);
				}else{
					iterB.remove();
					trafficGame.removeActor(BonusActual);
				}
				
			}
			 
				if(!BonusActual.esActivo){
					cont_pasivos++;
					if(BonusActual.getindex() == 0){
						ocupado[0] = true;
					}
					if(BonusActual.getindex() == 1){
						ocupado[1] = true;
					}
					if(BonusActual.getindex() == 2){
						ocupado[2] = true;
					}
					
				}
			
		}
		
		Assets.velocidad_local = velocidad;
	}

	public void tryMoveUp() {
		if ((getActions().size == 0) && (lane != 2)) moveToLane(lane+1);
	}

	public void tryMoveDown() {
		if ((getActions().size == 0) && (lane != 0)) moveToLane(lane-1);
	}
	
	private void moveToLane(int lane) {
		this.lane = lane;
		
		switch (lane) {
			case 0:
				addAction(moveTo(getX(), trafficGame.lane0 - getHeight()/2, 0.5f));
				break;
			case 1:
				addAction(moveTo(getX(), trafficGame.lane1 - getHeight()/2, 0.5f));
				break;
			case 2:
				addAction(moveTo(getX(), trafficGame.lane2 - getHeight()/2, 0.5f));
				break;
		}
	}

	public void esInmortal(){
		inmortal = true;
	}
	
	public void setActivo(boolean _activo){
		activo = _activo;
	}
	
	public void button1(float x, float y){
		if(bonusArray.size > 0 ){
			
			Iterator<Bonus> iterB = bonusArray.iterator();
			while (iterB.hasNext()) {
				Bonus BonusActual = iterB.next();
				if (BonusActual.getBounds().x + BonusActual.getWidth() <= 0) {
					iterB.remove();
					trafficGame.removeActor(BonusActual);
					
				}
				if (BonusActual.getBounds().overlaps(new Rectangle(x,y,1,1))) {					
					BonusActual.ActivarBonus();
					BonusActual.BonusActivo();
					BonusActual.setBounds(getX(), getY(), getWidth(), getHeight());
					BonusActual.setRotation(0);
					if(BonusActual.getTipo() == 2){
						trafficGame.Rapido();
					}else if(BonusActual.getTipo() == 0){
						esInmortal();
						activacionDeInmortal = TimeUtils.nanoTime();
					}else if(BonusActual.getTipo() == 1){
						//esInmortal();
						//activacionDeInmortal = TimeUtils.nanoTime();
						ganarVida();
					}
					
				
				}
				 
				
				
			}
			
		}
	}

	public int perderVida(){
		if(!inmortal){
			if(vidas > 0){
				vidas--;
			}
			if(vidas == 0){
				clearActions();
				addAction(rotateBy(180, 1f));
			}
		}
		
		return vidas;
	}
	
	public void ganarVida(){
		if(vidas < 3){
		vidas ++;	
		}
	}
	
	public boolean estaVivo(){
		
		if(vidas > 0){
			return true;
		}
		return false;
		
	}
	
	public void agregarPoder(Bonus poder){
		if(cont_pasivos < 3){
		if(poder.getTipo() == 1){
			//ganarVida();
			}
		poder.setHeight(Assets.escala);
		poder.setWidth(Assets.escala);
		bonusArray.add(poder);
		}
		
	}

	
	public int numeroPoderes(){
		if(cont_pasivos > 2){
			return 3;
		}else{
			if(!ocupado[0]){
				return 0;
			}
			if(!ocupado[1]){
				return 1;
			}
			if(!ocupado[2]){
				return 2;
			}
		}
		
		return 5;
	}
	
	public void sumarPuntos(int extra_puntos){
		puntos += extra_puntos;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public float getEstateTime(){
		
		return stateTime;
	}
}
