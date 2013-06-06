package com.cubo2d.morrocoy;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
	public final static int WIDTH = 800;
	public final static int HEIGHT =480;
	private GameScreen gameScreen;
	public Perfil_jugador jugador = null;
	public FileManager Archivos;
	private Menu menuScrean;

	@Override
	public void create() {
		Assets.load();
		Archivos = new FileManager();
		jugador = Archivos.leer();
		if(jugador == null){
			jugador= new Perfil_jugador();
		}else{
			System.out.println("Nombre: "+jugador.nombre);
		}
		
		//gameScreen = new GameScreen(this);
		menuScrean = new Menu(this);
		setScreen(gameScreen);
		setScreen(menuScrean);
	}

	@Override
	public void dispose() {
		Archivos.escribir(jugador);
		Assets.dispose();
	}
	
	public void jugar(int _nivel){
		
		setScreen(new GameScreen(this,_nivel));
	}
	
	public void menu(){
		setScreen(menuScrean);
		
	}
	
}
