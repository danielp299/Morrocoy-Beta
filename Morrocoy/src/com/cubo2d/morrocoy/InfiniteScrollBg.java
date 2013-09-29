package com.cubo2d.morrocoy;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class InfiniteScrollBg extends Actor {
	float Distancia;
	float recorrido;
	public float fin_rapido;
	boolean activo;
	float velocidad;
	float fondolejanoX;
	float fondosercanoX;
	boolean velocidad_normal;
	public boolean prepararMeta;
	public float linea1Y,linea2Y,linea3Y;
	public float tiempo_camino,bandera_tiempo_camino;
	float metaX;
	
	public InfiniteScrollBg(float width, float height) {
		setWidth(width);
		setHeight(height);
		setPosition(width, 0);
		recorrido =0;
		Distancia = 1000;
		activo = true;
		velocidad =9;
		velocidad_normal = true;
		prepararMeta = false;
		//addAction(forever(sequence(moveTo(0, 0, Assets.velocidad_local), moveTo(width, 0))));
		iniciarCamino(velocidad, Distancia,0);
		fondolejanoX = getWidth();
		linea1Y = getY()+ (getHeight()/2)+(getHeight()/4)-Assets.escala/2;
		linea2Y = getY()+ (getHeight()/2)-Assets.escala/2;
		linea3Y = getY()+ (getHeight()/2)-(getHeight()/4)-Assets.escala/2;
		tiempo_camino = 0;
		bandera_tiempo_camino =0;
		fondosercanoX = getWidth();
		
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		batch.draw(Assets.road, 0,0, getWidth(), getHeight());
		//zona de las estadisticas
		
		batch.draw(Assets.caminoSuperior, getX()-getWidth(),getY()+ getHeight()-(Assets.escala/2), getWidth(), Assets.escala/2);
		batch.draw(Assets.caminoSuperior, getX(),getY()+ getHeight()-(Assets.escala/2), getWidth() , Assets.escala/2);
		
		//lineas
		batch.draw(Assets.road, getX()-getWidth(),linea1Y, getWidth(), getHeight()/4);
		batch.draw(Assets.road, getX(),linea1Y, getWidth() , getHeight()/4);
		
		
		batch.draw(Assets.road, getX()-getWidth(),linea2Y, getWidth(), getHeight()/4);
		batch.draw(Assets.road, getX(),linea2Y, getWidth() , getHeight()/4);
		
		batch.draw(Assets.road, getX()-getWidth(),linea3Y, getWidth(), getHeight()/4);
		batch.draw(Assets.road, getX(),linea3Y, getWidth(), getHeight()/4);
		
		
		//zona de los botones
		batch.draw(Assets.caminoInferior, fondosercanoX-getWidth(),getY(), getWidth(), getHeight()/5);
		batch.draw(Assets.caminoInferior, fondosercanoX,getY(), getWidth(), getHeight()/5);
		
		
		if(prepararMeta){
			
			batch.draw(Assets.metai, metaX,linea3Y,Assets.escala, (getHeight()/4)*3);
		}
	}
	
	public void iniciarCamino(float _velocidad, float _distancia, int camino){
		velocidad = _velocidad;
		//escalar velocidad
		velocidad = (Gdx.graphics.getWidth()/800f)*velocidad;
		Distancia = _distancia;
		recorrido =0;
		activo = true;
		velocidad_normal = true;
		fin_rapido = 0;
		prepararMeta = false;
		tiempo_camino =0;
		bandera_tiempo_camino = 0;
		Assets.cargarCamino(camino);
	}
	
	
	
	public boolean finCamino(){
		if(recorrido >= Distancia){
			return true;
		}else return false;
		
	}
	
	public void cambiarVelociada(){
		if(velocidad_normal){
		fin_rapido = 50 + recorrido;
		velocidad_normal = false;
		}else{
			fin_rapido = 50 + recorrido;
			velocidad_normal = false;
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		if(activo){
			if(getX() > 0){
			setX(getX()-(velocidad));
			fondolejanoX =fondolejanoX-(velocidad-5f); 
			fondosercanoX = fondosercanoX-(velocidad); 
			if(bandera_tiempo_camino == 1){
				tiempo_camino+=0.1f;
			}
			}else if(getX()<=0){
			setX(getWidth());
			fondolejanoX = getWidth();
			fondosercanoX = getWidth();
			if(bandera_tiempo_camino == 0){
				bandera_tiempo_camino = 1;
			}else if(bandera_tiempo_camino == 1){
				bandera_tiempo_camino = 2;
			}
			}
			
			if(Distancia - recorrido < tiempo_camino){
				if(!prepararMeta)
					metaX = getWidth();
				prepararMeta = true;
				metaX-=velocidad;
			}
			
			
			if(recorrido >= Distancia){
				pausaCamino();
			}else{
				if(recorrido < fin_rapido  ){
				recorrido+=0.2;
				setX(getX()-velocidad); //7+7 velocidad x2
				if(prepararMeta)
					metaX-=velocidad;
				}else{
					if(!velocidad_normal){
					
					velocidad_normal = true;
					}
					recorrido+=0.1;
				}
			
				
				
			}
		}
	}
	
	public void pausaCamino(){
		activo = false;
	}
	
	
}
