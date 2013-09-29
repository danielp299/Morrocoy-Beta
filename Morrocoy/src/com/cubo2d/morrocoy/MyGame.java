package com.cubo2d.morrocoy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Preferences;

public class MyGame extends Game {
	public GameScreen gameScreen;
	public Perfil_jugador jugador = null;
	public FileManager Archivos;
	Preferences config;
	public Idioma idioma;
	private Menu menuScrean;

	//pisadas o musica
	public static IReqHandler ExternalHandler;
	
	public MyGame(IReqHandler irh) {
		// TODO Auto-generated constructor stub
		MyGame.ExternalHandler = irh;
		MyGame.ExternalHandler.showAd(true);
		
	}
	
	public MyGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		Assets.load();
		Archivos = new FileManager();
		Perfil_jugador tmp;
		tmp = Archivos.leer();
		if(Archivos.Actualizar){
			jugador = new Perfil_jugador();
			jugador.actualizarPerfilv2(tmp);
		}
		
		if(tmp == null){
			jugador= new Perfil_jugador();
		}else{
			if(Archivos.Actualizar){
				jugador = new Perfil_jugador();
				jugador.actualizarPerfilv2(tmp);
			}else{
			jugador = tmp;
		}
		}
		
		idioma = new Idioma(jugador.idioma);
		
		menuScrean = new Menu(this);
		setScreen(gameScreen);
		setScreen(menuScrean);
	}

	@Override
	public void dispose() {
		Archivos.escribir(jugador);
		Assets.dispose();
		//gameScreen.dispose();
		menuScrean.dispose();
		if(Archivos.Actualizar){
			Archivos.borrarPerfilViejo();
		}
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		Archivos.escribir(jugador);
	}
	
	public void jugar(int _nivel){
		
		setScreen(new GameScreen(this,_nivel));
	}
	
	public void menu(){
		menuScrean.verificarBloqueo(menuScrean.zona);
		menuScrean.ocultarMenuNiveles();
		setScreen(menuScrean);
		
	}
	
}


