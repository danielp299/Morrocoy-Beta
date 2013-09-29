package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.visible;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
public class Menu implements Screen{
	
	
	Table table;
	Table niveles;
	Table opciones;
	Table mapa;
	Table MenuPersonal;
	Table puntuaciones;
	
	
	MyGame game;
	private Stage stage;
	Fondo fondo;
	
	//menu inicio
	TextButton button;
	TextButton acerca;
	TextButton salir;
	TextButton bopciones;
	Ayuda acercaInfo;
	
	
	//niveles
	botonNivel nivel;
	botonNivel nivel2;
	botonNivel nivel3;
	botonNivel nivel4;
	botonNivel nivel5;
	botonNivel nivel6;
	botonNivel nivel7;
	botonNivel nivel8;
	botonNivel nivel9;
	TextButton ssalir;
	
	//opciones
	TextButton idioma;
	TextButton sonido;
	TextButton atras;
	TextButton reiniciarPerfil;
	public int idiomaNuevo;
	public int zona;
	
	//menu personal
	ImageButton casa;
	TextButton satras;
	ImageButton ppuntos;
	Label plpuntos;
	ImageButton pconejos;
	Label plconejos;
	ImageButton ppoderes;
	Label plpoderes;
	
	//menuMapa
	botonMapa Zona1;
	botonMapa Zona2;
	botonMapa Zona3;
	botonMapa Zona4;
	botonMapa Zona5;
	botonMapa Zona6;
	
	//
	
	public Menu(MyGame _migame) {
		game = _migame;
		stage = new Stage();
		fondo = new Fondo();
		stage.addActor(fondo);
		zona = 0;
		
		table = new Table();
		table.center();
		//table.setBackground(Assets.skin.getDrawable("fondo_tabla"));
				button = new TextButton("Jugar", Assets.skin);
				acerca = new TextButton("Acerca", Assets.skin);
				bopciones = new TextButton("Opciones", Assets.skin);
				salir = new TextButton("salir", Assets.skin);
				
				table.add(button).width(Assets.escala*2).height(Assets.escala);
				table.row();
				table.add(acerca).width(Assets.escala*2).height(Assets.escala);
				table.row();
				table.add(bopciones).width(Assets.escala*2).height(Assets.escala);
				table.row();
				table.add(salir).width(Assets.escala*2).height(Assets.escala);
				table.center();
				
				niveles = new Table();
				niveles.setVisible(true);
				niveles.center();
				niveles.setBackground(Assets.skin.getDrawable("fondo_tabla"));
					
				menuNiveles();
				
				opciones = new Table();
				opciones.setVisible(false);
				opciones.center();
				
				menuOpciones();
				MenuMapa();
				MenuPersonal();
				
				mapa.setBounds(Assets.escala, 0, Gdx.graphics.getWidth()-Assets.escala, Gdx.graphics.getHeight());
				niveles.setBounds(0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				opciones.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				MenuPersonal.setBounds(-Assets.escala*2, 0,Assets.escala*2, Gdx.graphics.getHeight());
				stage.addActor(table);
				//stage.addActor(MenuPersonal);
				stage.addActor(mapa);
				stage.addActor(MenuPersonal);
				stage.addActor(niveles);
				stage.addActor(opciones);
				
				
				
				button.addListener(new EventListener() {
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							//verificarBloqueo();
							//niveles.setVisible(true);
							mapa.setVisible(true);
							mostrarMenuPersonal();
							Assets.menu.play(Assets.volumen);
							table.setVisible(false);
							
						}
						return false;
					}
				});
				
				acerca.addListener(new EventListener() {
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							if(!acercaInfo.isVisible()){
							acercaInfo.setVisible(true);
							acercaInfo.addAction( moveTo(0,0,1f));
							}else{
							acercaInfo.addAction(sequence( moveTo(0,Gdx.graphics.getHeight(),1f),visible(false)));
							}
						}
						return false;
					}
				});
				
				bopciones.addListener(new EventListener() {
					
					@Override
					public boolean handle(Event event) {
						// TODO Auto-generated method stub
						//System.out.println(""+event.toString());
						
						if(event.toString() == "touchDown"){
							opciones.setVisible(true);
							Assets.menu.play(Assets.volumen);
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
				
		acercaInfo = new Ayuda();
		acercaInfo.setBounds(0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		acercaInfo.ayuda1.setText("Elavorado Por:\nDaniel Pernia & Cubo2D\ndanielp299@gmail.com\nTodos los derechos reservados\nVenezuela 2013");
		acercaInfo.ayuda2.setText("");
		acercaInfo.ayuda3.setText("");
		acercaInfo.setVisible(false);
		stage.addActor(acercaInfo);
		
		Assets.volumen = game.jugador.volumen;
		cambiarIdioma();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	
		stage.act(delta);
		stage.draw();
		table.debug();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		table.setWidth(width);
		table.setHeight(height);
		opciones.setWidth(width);
		opciones.setHeight(height);
		niveles.setWidth(width);
		niveles.setHeight(height);
		stage.setViewport(width, height, true);
		stage.getCamera().translate(stage.getGutterWidth(), stage.getGutterHeight(), 0);
		//table.setBounds(0, 0, width, height);
		Assets.resise();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//Gdx.input.setInputProcessor(new GestureDetector(this));
		verificarBloqueo(zona);
		actualizarEstadisticas();
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
	public void MenuMapa(){
		mapa = new Table();
		mapa.setBackground(Assets.skin.getDrawable("mapa1"));
		mapa.setVisible(false);
		
		Zona1 = new botonMapa("   1-9", Assets.skin.getDrawable("casa2"), 1);
		Zona1.setBounds(Assets.escala*1.2f, Assets.escala*3.8f, Assets.escala, Assets.escala);	
		mapa.addActor(Zona1);
		Zona1.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					//if(!game.jugador.Niveles[1].bloquedo)
					//game.jugar(2);	
					mostrarMenuNiveles(0);
				}	
				return false;
			}});
		
		
		Zona2 = new botonMapa( " 10-18", Assets.skin.getDrawable("casa3"), 1);
		Zona2.setBounds(Assets.escala*0.6f, Assets.escala*1.7f, Assets.escala, Assets.escala);	
		mapa.addActor(Zona2);
		Zona2.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					//if(!game.jugador.Niveles[1].bloquedo)
					//game.jugar(2);	
					mostrarMenuNiveles(1);
				}	
				return false;
			}});
		
		Zona3 = new botonMapa("  19-27", Assets.skin.getDrawable("casa4"), 1);
		Zona3.setBounds(Assets.escala*2.5f, Assets.escala*2.2f, Assets.escala, Assets.escala);	
		mapa.addActor(Zona3);
		Zona3.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					//if(!game.jugador.Niveles[1].bloquedo)
					//game.jugar(2);	
					mostrarMenuNiveles(2);
				}	
				return false;
			}});
		
		Zona4= new botonMapa("  28-36", Assets.skin.getDrawable("casa5"), 1);
		Zona4.setBounds(Assets.escala*4.5f, Assets.escala*2, Assets.escala, Assets.escala);	
		mapa.addActor(Zona4);
		Zona4.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					//if(!game.jugador.Niveles[1].bloquedo)
					//game.jugar(2);	
					mostrarMenuNiveles(3);
				}	
				return false;
			}});
		
	}
	
	public void ocultarMenuNiveles(){
		niveles.addAction(sequence( moveTo(niveles.getX(), Gdx.graphics.getHeight(), 1f)));
	}
	
	public void mostrarMenuNiveles(int _zona){
		verificarBloqueo(_zona);
		niveles.addAction(sequence(visible(true),moveTo(niveles.getX(), 0, 1f)));
	}
	
	
	public void MenuPersonal(){
		MenuPersonal = new Table();
		MenuPersonal.setBackground(Assets.skin.getDrawable("fondo_tabla"));
		
		casa = new ImageButton(Assets.skin.getDrawable("casa1"));
		//MenuPersonal.add(casa).width(Assets.escala).height(Assets.escala);
		casa.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					//table.setVisible(true);
					//niveles.setVisible(false);
				}	
				return false;
			}});
		MenuPersonal.row();
		Table tmp = new Table();
		ppuntos = new ImageButton(Assets.skin.getDrawable("puntos_icono"));
		plpuntos = new Label(""+game.jugador.puntuacionTotal,Assets.skin);
		tmp.add(ppuntos).width(Assets.escala/4).height(Assets.escala/4);
		tmp.add(plpuntos);
		MenuPersonal.add(tmp);
		
		MenuPersonal.row();
		Table tmp2 = new Table();
		pconejos = new ImageButton(Assets.skin.getDrawable("conejos_icono"));
		plconejos = new Label(""+game.jugador.EnemigoTotal,Assets.skin);
		tmp2.add(pconejos).width(Assets.escala/4).height(Assets.escala/4);
		tmp2.add(plconejos);
		MenuPersonal.add(tmp2);
		
		MenuPersonal.row();
		Table tmp3= new Table();
		ppoderes = new ImageButton(Assets.skin.getDrawable("poderes_icono"));
		plpoderes = new Label(""+game.jugador.BonusTotal,Assets.skin);
		tmp3.add(ppoderes).width(Assets.escala/4).height(Assets.escala/4);
		tmp3.add(plpoderes);
		MenuPersonal.add(tmp3);
		
		MenuPersonal.row();
		satras = new TextButton("Atras ", Assets.skin);
		MenuPersonal.add(satras).width(Assets.escala).height(Assets.escala);
		satras.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					table.setVisible(true);
					niveles.setVisible(false);
					OcultarMenuPersonal();
				}	
				return false;
			}});
	}
	
	public void actualizarEstadisticas(){
		plpuntos.setText(/*game.jugador.puntuacionActual+"/"+*/game.jugador.puntuacionTotal+"");
		plconejos.setText(/*game.jugador.EnemigoActual+"/"+*/game.jugador.EnemigoTotal+"");
		plpoderes.setText(/*game.jugador.BonusTotal+"/"+*/game.jugador.BonusTotal+"");
	}
	
	public void mostrarMenuPersonal(){
		MenuPersonal.addAction(sequence(visible(true), moveTo(-Assets.escala/2, 0, 1f)));
	}
	
	public void OcultarMenuPersonal(){
		MenuPersonal.addAction(sequence(moveTo(-Assets.escala*2, 0,1)));
		mapa.setVisible(false);
	}
	
	
	public void menuNiveles(){

		nivel = new botonNivel("nivel", Assets.skin,1);
		niveles.add(nivel).width(Assets.escala).height(Assets.escala);
		nivel.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+0].bloquedo){
					Assets.menu.play(Assets.volumen);
					game.jugar(nivel.nivel);	
					}
				}	
				return false;
			}});
		
		nivel2 = new botonNivel("nivel ", Assets.skin,2);
		niveles.add(nivel2).width(Assets.escala).height(Assets.escala);
		nivel2.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){

					if(!game.jugador.Niveles[(9*zona)+1].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel2.nivel);	
						}
				}	
				return false;
			}});
		
		nivel3 = new botonNivel("nivel ", Assets.skin,3);
		niveles.add(nivel3).width(Assets.escala).height(Assets.escala);
		nivel3.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){

					if(!game.jugador.Niveles[(9*zona)+2].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel3.nivel);	
						}
				}	
				return false;
			}});
		
		niveles.row();
		
		nivel4 = new botonNivel("nivel ", Assets.skin,4);
		niveles.add(nivel4).width(Assets.escala).height(Assets.escala);
		nivel4.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+3].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel4.nivel);	
						}
				}	
				return false;
			}});
		
		nivel5 = new botonNivel("nivel ", Assets.skin,5);
		niveles.add(nivel5).width(Assets.escala).height(Assets.escala);
		nivel5.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+4].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel5.nivel);	
						}
				}	
				return false;
			}});
		
		nivel6 =new botonNivel("nivel ", Assets.skin,6);
		niveles.add(nivel6).width(Assets.escala).height(Assets.escala);
		nivel6.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+5].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel6.nivel);	
						}	
				}	
				return false;
			}});
		niveles.row();
		nivel7 =new botonNivel("nivel ", Assets.skin,7);
		niveles.add(nivel7).width(Assets.escala).height(Assets.escala);
		nivel7.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+6].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel7.nivel);	
						}	
				}	
				return false;
			}});
		
		nivel8 = new botonNivel("nivel ", Assets.skin,8);
		niveles.add(nivel8).width(Assets.escala).height(Assets.escala);
		nivel8.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+7].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel8.nivel);	
						}
				}	
				return false;
			}});
		
		nivel9 = new botonNivel("nivel ", Assets.skin,9);
		niveles.add(nivel9).width(Assets.escala).height(Assets.escala);
		nivel9.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					if(!game.jugador.Niveles[(9*zona)+8].bloquedo){
						Assets.menu.play(Assets.volumen);
						game.jugar(nivel9.nivel);	
						}
				}	
				return false;
			}});
		niveles.row();
		ssalir = new TextButton("Salir", Assets.skin);
		niveles.add(ssalir).width(Assets.escala).height(Assets.escala);
		ssalir.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					ocultarMenuNiveles();	
					Assets.menu.play(Assets.volumen);
				}	
				return false;
			}});
		
		
	}
	
	public void verificarBloqueo(int _zona){
		
		Zona1.bloqueado = false;
		if(!game.jugador.Niveles[9].bloquedo){
			Zona2.bloqueado = false;
		}if(!game.jugador.Niveles[18].bloquedo){
			Zona3.bloqueado = false;
		}if(!game.jugador.Niveles[27].bloquedo){
			Zona4.bloqueado = false;
		}
		
		if(zona > 3)
			zona = 0;
			
		
		int constante = _zona*9;
		zona = _zona;
		
		nivel.setNivel(constante+1);
		nivel2.setNivel(constante+2);
		nivel3.setNivel(constante+3);
		nivel4.setNivel(constante+4);
		nivel5.setNivel(constante+5);
		nivel6.setNivel(constante+6);
		nivel7.setNivel(constante+7);
		nivel8.setNivel(constante+8);
		nivel9.setNivel(constante+9);
		
		
		nivel.bloqueado = game.jugador.Niveles[nivel.getNivelPos()].bloquedo;
		nivel2.bloqueado = game.jugador.Niveles[nivel2.getNivelPos()].bloquedo;
		nivel3.bloqueado = game.jugador.Niveles[nivel3.getNivelPos()].bloquedo;
		nivel4.bloqueado = game.jugador.Niveles[nivel4.getNivelPos()].bloquedo;
		nivel5.bloqueado = game.jugador.Niveles[nivel5.getNivelPos()].bloquedo;
		nivel6.bloqueado = game.jugador.Niveles[nivel6.getNivelPos()].bloquedo;
		nivel7.bloqueado = game.jugador.Niveles[nivel7.getNivelPos()].bloquedo;
		nivel8.bloqueado = game.jugador.Niveles[nivel8.getNivelPos()].bloquedo;
		nivel9.bloqueado = game.jugador.Niveles[nivel9.getNivelPos()].bloquedo;
		
		nivel.logro1 =  game.jugador.Niveles[nivel.getNivelPos()].todosLosPuntos;
		nivel2.logro1 =  game.jugador.Niveles[nivel2.getNivelPos()].todosLosPuntos;
		nivel3.logro1 =  game.jugador.Niveles[nivel3.getNivelPos()].todosLosPuntos;
		nivel4.logro1 =  game.jugador.Niveles[nivel4.getNivelPos()].todosLosPuntos;
		nivel5.logro1 =  game.jugador.Niveles[nivel5.getNivelPos()].todosLosPuntos;
		nivel6.logro1 =  game.jugador.Niveles[nivel6.getNivelPos()].todosLosPuntos;
		nivel7.logro1 =  game.jugador.Niveles[nivel7.getNivelPos()].todosLosPuntos;
		nivel8.logro1 =  game.jugador.Niveles[nivel8.getNivelPos()].todosLosPuntos;
		nivel9.logro1 =  game.jugador.Niveles[nivel9.getNivelPos()].todosLosPuntos;
		

		nivel.logro2 =  game.jugador.Niveles[nivel.getNivelPos()].todosLosConejos;
		nivel2.logro2 =  game.jugador.Niveles[nivel2.getNivelPos()].todosLosConejos;
		nivel3.logro2 =  game.jugador.Niveles[nivel3.getNivelPos()].todosLosConejos;
		nivel4.logro2 =  game.jugador.Niveles[nivel4.getNivelPos()].todosLosConejos;
		nivel5.logro2 =  game.jugador.Niveles[nivel5.getNivelPos()].todosLosConejos;
		nivel6.logro2 =  game.jugador.Niveles[nivel6.getNivelPos()].todosLosConejos;
		nivel7.logro2 =  game.jugador.Niveles[nivel7.getNivelPos()].todosLosConejos;
		nivel8.logro2 =  game.jugador.Niveles[nivel8.getNivelPos()].todosLosConejos;
		nivel9.logro2 =  game.jugador.Niveles[nivel9.getNivelPos()].todosLosConejos;
		

		nivel.logro3 =  game.jugador.Niveles[nivel.getNivelPos()].todoslospoderes;
		nivel2.logro3 =  game.jugador.Niveles[nivel2.getNivelPos()].todoslospoderes;
		nivel3.logro3 =  game.jugador.Niveles[nivel3.getNivelPos()].todoslospoderes;
		nivel4.logro3 =  game.jugador.Niveles[nivel4.getNivelPos()].todoslospoderes;
		nivel5.logro3 =  game.jugador.Niveles[nivel5.getNivelPos()].todoslospoderes;
		nivel6.logro3 =  game.jugador.Niveles[nivel6.getNivelPos()].todoslospoderes;
		nivel7.logro3 =  game.jugador.Niveles[nivel7.getNivelPos()].todoslospoderes;
		nivel8.logro3 =  game.jugador.Niveles[nivel8.getNivelPos()].todoslospoderes;
		nivel9.logro3 =  game.jugador.Niveles[nivel9.getNivelPos()].todoslospoderes;
	}
	
	public void menuOpciones(){
		reiniciarPerfil = new TextButton("Borrar: \n"+game.jugador.nombre, Assets.skin);
		opciones.add(reiniciarPerfil).width(Assets.escala*2).height(Assets.escala);
		reiniciarPerfil.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					game.jugador.nuevo();	
					
				}	
				return false;
			}});
		opciones.row();
		idiomaNuevo =0;
		idioma = new TextButton("Idioma:"+"ES", Assets.skin);
		opciones.add(idioma).width(Assets.escala*2).height(Assets.escala);
		idioma.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					idiomaNuevo++;
					if(idiomaNuevo > Idioma.listaIdiomas.length-1){
						idiomaNuevo = 0;
					}
					idioma.setText(""+game.idioma.oIdioma+" "+Idioma.listaIdiomas[idiomaNuevo]);
					
				}	
				return false;
			}});
		opciones.row();
		
		sonido= new TextButton("", Assets.skin);
		if(game.jugador.volumen == 1){
			sonido.setText(game.idioma.oSonido+": "+game.idioma.Si);
		}else{
			sonido.setText(game.idioma.oSonido+": "+game.idioma.No);
		}
		opciones.add(sonido).width(Assets.escala*2).height(Assets.escala);
		sonido.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					
					if(game.jugador.volumen == 0){
						sonido.setText(game.idioma.oSonido+": "+game.idioma.Si);
						Assets.volumen = 1f;
						game.jugador.volumen = Assets.volumen;
					}else{
						sonido.setText(game.idioma.oSonido+": "+game.idioma.No);
						Assets.volumen = 0f;
						game.jugador.volumen = Assets.volumen;
					}
					
				}	
				return false;
			}});
		opciones.row();
		atras = new TextButton("Atras ", Assets.skin);
		opciones.add(atras).width(Assets.escala*2).height(Assets.escala);
		atras.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				if(event.toString() == "touchDown"){
					Assets.menu.play(Assets.volumen);
					table.setVisible(true);
					opciones.setVisible(false);
					if(idiomaNuevo != game.idioma.actual){
						game.idioma.cambiarLenguage(idiomaNuevo);
						cambiarIdioma();
						game.jugador.idioma = idiomaNuevo;
					}
				}	
				return false;
			}});
	}
	
	public void cambiarIdioma(){
		button.setText(""+game.idioma.mJugar+"");
		acerca.setText(""+game.idioma.mAcerca);
		salir.setText(""+game.idioma.mSalir);
		bopciones.setText(""+game.idioma.mOpciones);
		acercaInfo.ayuda1.setText(""+game.idioma.cAcerca);
		//menu
		reiniciarPerfil.setText(""+game.idioma.oBorrarcuenta);
		idioma.setText(""+game.idioma.oIdioma+" "+Idioma.listaIdiomas[game.idioma.actual]);
		if(game.jugador.volumen == 1){
			sonido.setText(game.idioma.oSonido+": "+game.idioma.Si);
		}else{
			sonido.setText(game.idioma.oSonido+": "+game.idioma.No);
		}
		atras.setText(""+game.idioma.Atras);
		ssalir.setText(""+game.idioma.Atras);
		//niveles
		nivel.setText(""+game.idioma.sNivel);
		nivel2.setText(""+game.idioma.sNivel);
		nivel3.setText(""+game.idioma.sNivel);
		nivel4.setText(""+game.idioma.sNivel);
		nivel5.setText(""+game.idioma.sNivel);
		nivel6.setText(""+game.idioma.sNivel);
		nivel7.setText(""+game.idioma.sNivel);
		nivel8.setText(""+game.idioma.sNivel);
		nivel9.setText(""+game.idioma.sNivel);
		satras.setText(""+game.idioma.Atras);
		
	}
	
	
	private class Fondo extends Actor{
		
		public Fondo() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			batch.draw(Assets.fondo, 0, 0,Assets.fondo.getRegionWidth()/2,Assets.fondo.getRegionHeight()/2,Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1, 1, getRotation());			
			//batch.draw(Assets.puntos, Gdx.graphics.getWidth()-Assets.escala-Assets.escala/3, Gdx.graphics.getHeight() -Assets.escala/2,Assets.fondo.getRegionWidth()/2,Assets.fondo.getRegionHeight()/2,Assets.escala/3, Assets.escala/3, 1, 1, getRotation());			
			//Assets.font.draw(batch, game.jugador.puntuacionTotal+"", Gdx.graphics.getWidth()-Assets.escala, Gdx.graphics.getHeight() -Assets.escala/4);
			
		}
		
	}

	
	
	public class botonNivel extends TextButton{
		public boolean bloqueado;
		public boolean logro1;
		public boolean logro2;
		public boolean logro3;
		public int nivel;
		public String nombreN;
		int x=0;
		public botonNivel(String text, Skin skin,int _nivel) {
			super(text +""+_nivel, skin);
			// TODO Auto-generated constructor stub
			bloqueado = true;
			logro1 = false;
			logro2 = false;
			logro3 = false;
			nivel = _nivel;
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			if(bloqueado){
				batch.draw(Assets.bloqueado, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
			}else{
				if(logro1){
					batch.draw(Assets.logroPuntosIcono, getX(), getY(), getWidth()/2, getHeight(), getWidth()/3, getHeight()/3, 1, 1, getRotation());
				}
				if(logro2){
					batch.draw(Assets.logroConejosIcono	, getX()+getWidth()/3, getY(), getWidth()/2, getHeight()/3, getWidth()/3, getHeight()/3, 1, 1, getRotation());
				}
				if(logro3){
					batch.draw(Assets.logroPoderesIcono, getX()+(getWidth()/3)*2, getY(), getWidth()/2, getHeight()/3, getWidth()/3, getHeight()/3,1, 1, getRotation());
				}
				
			}
			
			
		}
		
		public void setText(String text){
			nombreN = text;
			super.setText(text + " "+ nivel);
			
		}
		
		public void setNivel(int _nivel){
			nivel = _nivel;
			super.setText(nombreN + " "+ nivel);
		}
		
		public int getNivelPos(){
			return nivel-1;
		}
		
	}
	
	public class botonMapa extends ImageButton{
		public boolean bloqueado;
		public String Nombre;
		public boolean logro1;
		public boolean logro2;
		public boolean logro3;
		public int zona;
		int x=0;
		public botonMapa(String text,Drawable drawable,int _nivel) {
			super(drawable);
			// TODO Auto-generated constructor stub
			Nombre = text;
			bloqueado = true;
			logro1 = false;
			logro2 = false;
			logro3 = false;
			zona = _nivel;
		}
		
		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			super.draw(batch, parentAlpha);
			Assets.font.draw(batch, Nombre, getX(), getY()+getHeight());
			if(bloqueado){
				batch.draw(Assets.bloqueado, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
			}else{
				if(logro1){
					batch.draw(Assets.logroPuntosIcono, getX(), getY(), getWidth()/2, getHeight(), getWidth()/3, getHeight()/3, 1, 1, getRotation());
				}
				if(logro2){
					batch.draw(Assets.logroConejosIcono	, getX()+getWidth()/3, getY(), getWidth()/2, getHeight()/3, getWidth()/3, getHeight()/3, 1, 1, getRotation());
				}
				if(logro3){
					batch.draw(Assets.logroPoderesIcono, getX()+(getWidth()/3)*2, getY(), getWidth()/2, getHeight()/3, getWidth()/3, getHeight()/3,1, 1, getRotation());
				}
				
			}
			
			
		}
		
		public void setText(String text){
			
			
		}
		
	}

}
