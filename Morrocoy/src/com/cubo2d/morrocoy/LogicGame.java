package com.cubo2d.morrocoy;




import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class LogicGame extends Table {
	public boolean pause;
	private InfiniteScrollBg backgroundRoad;
	private Array<Enemy> enemyCars;
	private Array<Bonus> bonusArray;
	private Array<Puntos> pointsArray;
	private long lastCarTime = 0;
	public  float lane2 = 0;
	public  float lane1 = 0;
	public  float lane0 = 0;
	public Player playerCar;
	private int linea;
	private Nivel nivel;
	private float ultimoEnemigo;
	private float ultimoBonus;
	private float ultimoPunto;
	private int contEnemigo;
	private int contBonus;
	private int contPuntos;
	public boolean gano;
	public Label Infonivel;
	public Label labelPuntosNivel;
	public Table table;
	public Table interfaz;
	public Table poderes;
	public MyGame game;
	public ImageButton logro1;
	public ImageButton logro2;
	public ImageButton logro3;
	public Label infoLogro1;
	public Label infoLogro2;
	public Label infoLogro3;

	//interfaz
	public Label ividas;
	public Label inivel;
	public Label ienemigos;
	public Label ibonus;
	public Label ipuntos;
	public Label imeta;
	TextButton siguiente;
	Corazon corazon;
	
	public LogicGame(int _nivel, MyGame _game) {
		pause = true;
		setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game = _game;
		setClip(true);
		lane2 = getHeight()/2 + getHeight()/4+Assets.escala/4;
		lane1 = getHeight()/2+Assets.escala/4;
		lane0 = getHeight()/2 - getHeight()/4+Assets.escala/4;
		backgroundRoad = new InfiniteScrollBg(getWidth(),getHeight());
		addActor(backgroundRoad);
		playerCar = new Player(this);
		addActor(playerCar);
		enemyCars = new Array<Enemy>();		
		bonusArray = new Array<Bonus>();	
		pointsArray = new Array<Puntos>();	
		nivel = new Nivel();
		corazon = new Corazon();
		corazon.setSize(Assets.escala, Assets.escala);
		corazon.setVisible(false);
		addActor(corazon);

		//interfaz
		interfaz = new Table();
		interfaz.setBounds(0, Gdx.graphics.getHeight()-Assets.escala/2,Gdx.graphics.getWidth(), Assets.escala/2);
		//interfaz.setBackground(Assets.skin.getDrawable("fondo"));
		interfaz.setLayoutEnabled(true);
		interfaz.bottom();
		
		
		ImageButton imavidas = new ImageButton(Assets.skin.getDrawable("corazon_icono"));
		interfaz.add(imavidas).width(Assets.escala/3).height(Assets.escala/3).padLeft(Assets.escala);
		ividas = new Label("3", Assets.skin);
		interfaz.add(ividas).expand().left();
		ImageButton imanivel = new ImageButton(Assets.skin.getDrawable("nivel_icono"));
		interfaz.add(imanivel).width(Assets.escala/3).height(Assets.escala/3);
		inivel = new Label("1-1", Assets.skin);
		interfaz.add(inivel).padRight(10);
		ImageButton imameta = new ImageButton(Assets.skin.getDrawable("meta_icono"));
		interfaz.add(imameta).width(Assets.escala/3).height(Assets.escala/3);
		imeta = new Label("666", Assets.skin);
		interfaz.add(imeta);
		ImageButton imabonus = new ImageButton(Assets.skin.getDrawable("poderes_icono"));
		interfaz.add(imabonus).width(Assets.escala/3).height(Assets.escala/3).height(Assets.escala/3).expand().right();
		ibonus = new Label("2/15", Assets.skin);
		interfaz.add(ibonus).padRight(10);
		ImageButton imaenemigos = new ImageButton(Assets.skin.getDrawable("conejos_icono"));
		interfaz.add(imaenemigos).width(Assets.escala/3).height(Assets.escala/3);
		ienemigos = new Label("5/7", Assets.skin);
		interfaz.add(ienemigos).padRight(10);
		ImageButton imapuntos = new ImageButton(Assets.skin.getDrawable("puntos_icono"));
		interfaz.add(imapuntos).width(Assets.escala/3);
		ipuntos = new Label("21/35", Assets.skin);
		interfaz.add(ipuntos);
		
		
		
		addActor(interfaz);
		
		
		//tabla final
		table = new Table();
		table.setLayoutEnabled(true);
		table.setBounds(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/4, Assets.escala, Gdx.graphics.getWidth()/2, Assets.escala*3.5f);
		table.setBackground(Assets.skin.getDrawable("fondo_tabla"));
		table.center();
		
				
				Infonivel =new Label("Total Puntos Nivel: "+playerCar.getPuntos(),  Assets.skin);
				table.add(Infonivel);
				table.row();
				labelPuntosNivel =new Label("Nivel 1-"+nivel.nivelActual+"Completo",  Assets.skin);
				table.add(labelPuntosNivel);
				table.row();
				
				//imagenes de logro
				Table tabla_lateral = new Table();
				logro1 = new ImageButton(Assets.skin.getDrawable("puntos_icono"));
				tabla_lateral.add(logro1).width(Assets.escala).height(Assets.escala);
				logro2 = new ImageButton(Assets.skin.getDrawable("conejos_icono"));
				tabla_lateral.add(logro2).width(Assets.escala).height(Assets.escala);
				logro3 = new ImageButton(Assets.skin.getDrawable("poderes_icono"));		
				tabla_lateral.add(logro3).width(Assets.escala).height(Assets.escala);
				table.add(tabla_lateral);
				table.row();
				//info logro
				Table tabla_lateral2 = new Table();
				infoLogro1 = new Label(" 00/00", Assets.skin);
				tabla_lateral2.add(infoLogro1).width(Assets.escala);
				infoLogro2 = new Label(" 00/00", Assets.skin);
				tabla_lateral2.add(infoLogro2).width(Assets.escala);
				infoLogro3 = new Label(" 00/00", Assets.skin);
				tabla_lateral2.add(infoLogro3).width(Assets.escala);
				table.add(tabla_lateral2);
				table.row();
				
				siguiente = new TextButton("Siguiente", Assets.skin);
				table.add(siguiente).bottom().right().width(Assets.escala).height(Assets.escala);
				addActor(table);
				siguiente.addListener(new EventListener() {
					
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							if(nivel.nivelActual<=nivel.nivelesDisponibles){
								if(nivel.nivelActual%9 ==0){
									game.menu();
								}else{
									nuevoJuego(++nivel.nivelActual);
								}
							}else{
							
							}
						}
						
						return false;
					}
				});
				
		
				nuevoJuego(_nivel);
	}
	
	public void mostrarTotalNivel(){
		//table.addAction(visible(true));
		if(!table.isVisible()){
			playerCar.borrarBonus();
			Assets.completo.play(Assets.volumen);
			Infonivel.setText(game.idioma.sNivel+" "+nivel.nivelActual+" "+game.idioma.rCompletado);
			labelPuntosNivel.setText(game.idioma.rTotal+": "+playerCar.getPuntos());
			if(nivel.nivelActual < nivel.nivelesDisponibles)
			game.jugador.Niveles[nivel.nivelActual].bloquedo = false;
			game.jugador.puntuacionTotal+=playerCar.getPuntos();
			game.jugador.puntuacionActual+=playerCar.getPuntos();
			game.jugador.BonusTotal+=contBonus;
			game.jugador.BonusActual+=contBonus;
			game.jugador.EnemigoTotal +=contEnemigo;
			game.jugador.EnemigoActual+=contEnemigo;
			//logros
			if(nivel.logroPuntos <= playerCar.getPuntos()){
				game.jugador.Niveles[nivel.nivelActual-1].todosLosPuntos = true;
				
				logro1.setVisible(true);
			}
			if(nivel.logroConejos <= contEnemigo){
				game.jugador.Niveles[nivel.nivelActual-1].todosLosConejos = true;
				logro2.setVisible(true);
			}
			if(nivel.logroPoderes <= contBonus){
				game.jugador.Niveles[nivel.nivelActual-1].todoslospoderes = true;
				logro3.setVisible(true);
			}
			infoLogro1.setText(" "+playerCar.getPuntos()+"/"+(int)nivel.logroPuntos);
			infoLogro2.setText(" "+contEnemigo+"/"+(int)nivel.logroConejos);
			infoLogro3.setText(" "+contBonus+"/"+(int)nivel.logroPoderes);
			game.Archivos.escribir(game.jugador);
		}
		table.setVisible(true);
	}
	
	public void ocultarTotalNivel(){

		//table.addAction(sequence( fadeOut(0.8f),visible(false)));
		table.setVisible(false);
		logro1.setVisible(false);
		logro2.setVisible(false);
		logro3.setVisible(false);
		
	}
	
	public void boton(float x, float y){
		if(playerCar.estaVivo())
		playerCar.button1(x, y);
		ividas.setText(""+playerCar.getVidas());
	}
	
	public void tratarDeSubir(){
		if(playerCar.estaVivo())
		playerCar.tryMoveUp();
	}
	
	public void tratarDeBajar(){
		if(playerCar.estaVivo())
		playerCar.tryMoveDown();
	}	
	
	public void GanoNivel(){
		gano = true;
		mostrarTotalNivel();
		limpiarPantalla();
	}
	
	public void limpiarPantalla() {
		playerCar.setActivo(false);
		Iterator<Enemy> iter = enemyCars.iterator();
		while (iter.hasNext()) {
			Enemy enemyCar = iter.next();
			enemyCar.remove();
		}
		
		
		//puntos
		Iterator<Puntos> iterP = pointsArray.iterator();
		while (iterP.hasNext()) {
			Puntos enemyCar = iterP.next();
			enemyCar.remove();
		}
		//bonus
		Iterator<Bonus> iterB = bonusArray.iterator();
		while (iterB.hasNext()) {
			Bonus enemyCar = iterB.next();
			enemyCar.remove();
			
		}
	}
	
	public void Pause(){
		Assets.musica.stop();
		pause = true;
	}
	
	public void Resumen(){
		Assets.musica.play();
		pause = false;
	}
	
	public boolean isPause(){
		return pause;
	}
	
	public void PerdioNivel(){
		backgroundRoad.pausaCamino();
		limpiarPantalla();
	}
	
	@Override
	public void act(float delta) {
		
		if(!pause){
		super.act(delta);
		backgroundRoad.act(delta);

		
		if(backgroundRoad.finCamino()){ //
			GanoNivel();
		}
		
		if(!backgroundRoad.finCamino()){
		//pantalla de ganar
		
			
		if(playerCar.estaVivo()){
		
		if (TimeUtils.nanoTime() - lastCarTime > 800000000f) spawnCar();
		//enemigos
		Iterator<Enemy> iter = enemyCars.iterator();
		while (iter.hasNext()) {
			Enemy enemyCar = iter.next();
			if(enemyCar.getBounds().x < Gdx.graphics.getWidth())
			if (enemyCar.getBounds().x + enemyCar.getWidth() <= 0) {
				iter.remove();
				removeActor(enemyCar);
			}else if (enemyCar.getBounds().overlaps(playerCar.getBounds())) {
                iter.remove();
                contEnemigo ++;
                if (enemyCar.getX() > playerCar.getX()) {
                    if (enemyCar.getY() > playerCar.getY()){ enemyCar.crash(true, true);}
                    else{ enemyCar.crash(true, false);}
                    if(playerCar.inmortal){
                    	Assets.empujar.play(Assets.volumen);
                    	
                    }else{
                    	playerCar.perderVida(); 
                    	Assets.golpe.play(Assets.volumen);
                    	ividas.setText(""+playerCar.getVidas());
                    	//corazon.perderCorazon(playerCar.getX()+playerCar.getWidth()/2,playerCar.getY());
                    }
                }
                else {
                    if (enemyCar.getY() > playerCar.getY()) enemyCar.crash(false, true);
                    else enemyCar.crash(false, false);
                    Assets.empujar.play(Assets.volumen);
                }
                ienemigos.setText(""+(int)contEnemigo+"/"+(int)nivel.logroConejos);
			}
		}
		
		
		//puntos
		Iterator<Puntos> iterP = pointsArray.iterator();
		while (iterP.hasNext()) {
			Puntos enemyCar = iterP.next();
			if(enemyCar.getBounds().x < Gdx.graphics.getWidth())
			if (enemyCar.getBounds().x + enemyCar.getWidth() <= 0) {
				iterP.remove();
				removeActor(enemyCar);
			}else 
			if (enemyCar.getBounds().overlaps(playerCar.getBounds())) {
                iterP.remove();

                

                if (enemyCar.getX() > playerCar.getX()) {
                	playerCar.sumarPuntos(enemyCar.Puntos);
                    if (enemyCar.getY() > playerCar.getY()) enemyCar.crash(true, true);
                    else enemyCar.crash(true, false);
                }else {
                	playerCar.sumarPuntos(1);
                    if (enemyCar.getY() > playerCar.getY()) enemyCar.crash(false, true);
                    else enemyCar.crash(false, false);
                }
                ipuntos.setText(""+(int)playerCar.getPuntos()+"/"+(int)nivel.logroPuntos);
			}
		}
		//bonus
		Iterator<Bonus> iterB = bonusArray.iterator();
		while (iterB.hasNext()) {
			Bonus enemyCar = iterB.next();
			if(enemyCar.getBounds().x < Gdx.graphics.getWidth())
			if (enemyCar.getBounds().x + enemyCar.getWidth() <= 0) {
				iterB.remove();
				removeActor(enemyCar);
			}else 
			if (enemyCar.getBounds().overlaps(playerCar.getBounds())) {
				
				iterB.remove();
				if(playerCar.numeroPoderes()>2){
					playerCar.sumarPuntos(+1);
					ipuntos.setText(""+(int)playerCar.getPuntos()+"/"+(int)nivel.logroPuntos);
				}else{
					 contBonus++;
					 ibonus.setText(""+(int)contBonus +"/"+(int)nivel.logroPoderes);
				}
				enemyCar.crash(playerCar.numeroPoderes());
                   playerCar.agregarPoder(enemyCar);
				}
			
		}
		
		}else {
			PerdioNivel();
		}
		imeta.setText(""+(int)(backgroundRoad.Distancia-backgroundRoad.recorrido));
		}else{
			GanoNivel();
		}
		
		}//end pause
	}

	private void spawnCar() {
		
		int lineasUsadas =0;
		float yPos = 0;
		if(backgroundRoad.recorrido - ultimoEnemigo > nivel.frecuenciaEnemigos){
			Enemy enemyCar;
			switch (nivel.getTipoEnemigo()) {
			case 1:
				linea = MathUtils.random(0, 2);
				
				if (linea == 0) yPos = lane0;
				if (linea == 1) yPos = lane1;
				if (linea == 2) yPos = lane2;
				
				enemyCar = new Enemy(getWidth(), yPos,nivel.velocidadEnemigoMax,nivel.velocidadEnemigoMin);
				enemyCars.add(enemyCar);
				addActor(enemyCar);
				lineasUsadas = linea;
				while(linea == lineasUsadas){
					linea = MathUtils.random(0, 2);
				}
				
				if (linea == 0) yPos = lane0;
				if (linea == 1) yPos = lane1;
				if (linea == 2) yPos = lane2;
				
				enemyCar = new Enemy(getWidth(), yPos,nivel.velocidadEnemigoMax,nivel.velocidadEnemigoMin);
				enemyCars.add(enemyCar);
				addActor(enemyCar);
				break;

			default:
				linea = MathUtils.random(0, 2);
				
				if (linea == 0) yPos = lane0;
				if (linea == 1) yPos = lane1;
				if (linea == 2) yPos = lane2;
				
				enemyCar = new Enemy(getWidth(), yPos,nivel.velocidadEnemigoMax,nivel.velocidadEnemigoMin);
				enemyCars.add(enemyCar);
				addActor(enemyCar);
				lineasUsadas = linea;
				break;
			}
			
			
			ultimoEnemigo = backgroundRoad.recorrido;
		}
		
		
		if(backgroundRoad.recorrido - ultimoBonus > nivel.frecuenciaBonus){
			linea = MathUtils.random(0, 2);
			while(linea == lineasUsadas){
				linea = MathUtils.random(0, 2);
			}
			
			if (linea == 0) yPos = lane0;
			if (linea == 1) yPos = lane1;
			if (linea == 2) yPos = lane2;
			
			Bonus enemyCar = new Bonus(getWidth(), yPos,nivel.getTipoBonus());
			bonusArray.add(enemyCar);
			addActor(enemyCar);
			ultimoBonus = backgroundRoad.recorrido;
		}
		
		if(backgroundRoad.recorrido - ultimoPunto > nivel.frecuenciaPuntos && contPuntos < nivel.puntos){
			linea = MathUtils.random(0, 2);
			
			if (linea == 0) yPos = lane0;
			if (linea == 1) yPos = lane1;
			if (linea == 2) yPos = lane2;
			
			Puntos enemyCar = new Puntos(getWidth(), yPos);
			pointsArray.add(enemyCar);
			addActor(enemyCar);
			ultimoPunto = backgroundRoad.recorrido;
			contPuntos++;
		}
		
		lastCarTime = TimeUtils.nanoTime();
		
		
	}
	
	public void Rapido(){
		backgroundRoad.cambiarVelociada();
	}
	
	public void nuevoJuego(int _nivel){
		nivel.setNivel(_nivel);
		ultimoBonus = ultimoPunto = ultimoEnemigo = contPuntos =0;
		bonusArray.clear();
		enemyCars.clear();
		pointsArray.clear();
		backgroundRoad.iniciarCamino(nivel.velocidad, nivel.distancia,nivel.piso);
		playerCar.nuevo();
		Infonivel.setText("Nivel 1-"+nivel.nivelActual+" Completo");
		gano = false;
		contEnemigo = 0;
		contBonus = 0;
		//interfaz
		ividas.setText(""+playerCar.getVidas());
		inivel.setText(game.idioma.sNivel+": "+(int)nivel.nivelActual);
		ienemigos.setText("0/"+(int)nivel.logroConejos);
		ibonus.setText("0/"+(int)nivel.logroPoderes);
		ipuntos.setText("0/"+(int)nivel.logroPuntos);
		imeta.setText(""+(int)nivel.distancia);
		
		ocultarTotalNivel();
		
	}
	
	public void reiniciar(){
		limpiarPantalla();
		nuevoJuego(nivel.nivelActual);
	}

	public void cambiarIdioma(){
		siguiente.setText(""+game.idioma.rSiguiente);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		batch.setColor(Color.WHITE);
		//Assets.font.draw(batch, ""+Gdx.graphics.getFramesPerSecond(), 0, Gdx.graphics.getHeight());
		
	}
	
	public class Corazon extends Actor{
		boolean mas;
		public Corazon() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			setColor(1,1,1,1);
			if(mas){
			batch.draw(Assets.mas, getX()-getWidth()+getWidth()/4, getY()+getHeight()/4, getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2, getScaleX(), getScaleY(), getRotation());
			batch.draw(Assets.corazon, getX()-getWidth()/2, getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
			}else{
			batch.draw(Assets.menos, getX()-getWidth()+getWidth()/4, getY()+getHeight()/4, getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2, getScaleX(), getScaleY(), getRotation());
			batch.draw(Assets.corazon, getX()-getWidth()/2, getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
			}
		}
		
		public void ganarCorazon(float x,float y){
			mas = true;
			setPosition(x, y);
			addAction(sequence(visible(true),moveBy(0, Assets.escala, 2f),visible(false)));
		}
		public void perderCorazon(float x,float y){
			mas = false;
			setPosition(x, y);
			addAction(sequence(visible(true),moveBy(0, Assets.escala, 2f),visible(false)));
		}
		}
}
