package com.cubo2d.morrocoy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;

public class Assets {
	public static TextureAtlas atlas;
	public static TextureRegion car;
	public static TextureRegion road;
	public static TextureRegion bonus_boton;
	public static TextureRegion poder;
	public static TextureRegion puntos;
	public static TextureRegion rapido_icono;
	public static TextureRegion comida_icono;
	public static TextureRegion defensa_icono;
	public static TextureRegion rapido;
	public static TextureRegion comida;
	public static TextureRegion defensa;
	public static TextureRegion meta;
	public static TextureRegion caminoSuperior;
	public static TextureRegion caminoInferior;
	public static TextureRegion fondo;
	public static TextureRegion boton;
	public static TextureRegion bloqueado;
	public static TextureRegion logroPuntosIcono;
	public static TextureRegion logroConejosIcono;
	public static TextureRegion logroPoderesIcono;
	public static TextureRegion metai;
	public static TextureRegion mas;
	public static TextureRegion menos;
	public static TextureRegion corazon;
	//ayuda
	public static TextureRegion dedo;
	public static TextureRegion foco;
	public static TextureRegion tutorialEstrellas;
	public static TextureRegion tutorialMover;
	public static TextureRegion tutorialDefensa;
	public static TextureRegion tutorialVida;
	public static TextureRegion tutorialMasConejo;
	public static TextureRegion tutorialPowConejo;
	public static TextureRegion tutorialRapido;
	
	
	public static float escala ;
	public static float escalaE2 ;
	public static float escalaE4 ;
	public static TextureRegion camino;
	public static int totalNiveles = 90;
	
	
	//sonidos
	public static Sound golpe;
	public static Sound empujar;
	public static Sound completo;
	public static Sound menu;
	//musica
	public static Music musica;
	
	//animacion
	public static Animation tortugaCamina;
	public static Animation defensaCamina;
	public static Animation comidaCamina;
	public static Animation rapidoCamina;
	public static Animation conejoCamina;

	public static float velocidad_global = 1f;
	public static float velocidad_local = velocidad_global;
	public static BitmapFont font;
	public static Skin skin;
	public static float volumen;

	

	public static void load() {
		if(Gdx.graphics.getWidth() > Gdx.graphics.getHeight()){
			escala = Gdx.graphics.getHeight()/5;
		}else{
			escala = Gdx.graphics.getWidth()/5;
		}
		
		atlas = new TextureAtlas(Gdx.files.internal("data/empaquetado.atlas"));
		//car = atlas.findRegion("t0005");
		
		bonus_boton = atlas.findRegion("espacio_poder");
		poder = atlas.findRegion("poder");
		rapido_icono = atlas.findRegion("rapido_icono");
		comida_icono = atlas.findRegion("comida_icono");
		defensa_icono = atlas.findRegion("defensa_icono");
		rapido = atlas.findRegion("rapido");
		comida = atlas.findRegion("cura");
		defensa = atlas.findRegion("defensa");
		puntos = atlas.findRegion("puntos");
		caminoSuperior = atlas.findRegion("grama");
		caminoInferior = atlas.findRegion("zona_botones");
		fondo = atlas.findRegion("portada");
		boton = atlas.findRegion("boton_Amarillo");
		bloqueado = atlas.findRegion("candado");
		metai = atlas.findRegion("metai");
		
		logroPuntosIcono = atlas.findRegion("puntos");
		logroConejosIcono = atlas.findRegion("c0001");
		logroPoderesIcono = atlas.findRegion("poderes_icono");
		mas =atlas.findRegion("mas");
		menos =atlas.findRegion("menos");
		corazon =atlas.findRegion("corazon");
		
		
		//ayuda
		tutorialMover = atlas.findRegion("tutorialMover");
		tutorialDefensa= atlas.findRegion("tutorialDefensa");
		tutorialEstrellas=  atlas.findRegion("tutorialEstrellas");
		tutorialMasConejo= atlas.findRegion("tutorialMasConejo");
		tutorialPowConejo=  atlas.findRegion("tutorialPowConejo");
		tutorialRapido= atlas.findRegion("tutorialRapido");
		tutorialVida=  atlas.findRegion("tutorialVida");
		dedo = atlas.findRegion("dedo");
		foco = atlas.findRegion("foco");
		
		Array<TextureRegion> arrayT = new Array<TextureRegion>();
		car = atlas.findRegion("t0001");
		arrayT.add(car);
		car = atlas.findRegion("t0002");
		arrayT.add(car);
		car = atlas.findRegion("t0003");
		arrayT.add(car);
		car = atlas.findRegion("t0004");
		arrayT.add(car);
		car = atlas.findRegion("t0005");
		arrayT.add(car);
		//animacion
		tortugaCamina = new Animation(0.05f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("c0001");
		arrayT.add(car);
		car = atlas.findRegion("c0002");
		arrayT.add(car);
		car = atlas.findRegion("c0003");
		arrayT.add(car);
		car = atlas.findRegion("c0004");
		arrayT.add(car);
		car = atlas.findRegion("c0005");
		arrayT.add(car);
		conejoCamina = new Animation(0.07f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("co0001");
		arrayT.add(car);
		car = atlas.findRegion("co0002");
		arrayT.add(car);
		car = atlas.findRegion("co0003");
		arrayT.add(car);
		car = atlas.findRegion("co0004");
		arrayT.add(car);
		car = atlas.findRegion("co0005");
		arrayT.add(car);
		car = atlas.findRegion("co0006");
		arrayT.add(car);
		car = atlas.findRegion("co0007");
		arrayT.add(car);
		car = atlas.findRegion("co0008");
		arrayT.add(car);
		car = atlas.findRegion("co0009");
		arrayT.add(car);
		car = atlas.findRegion("co0010");
		arrayT.add(car);
		comidaCamina = new Animation(0.05f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("d0001");
		arrayT.add(car);
		car = atlas.findRegion("d0002");
		arrayT.add(car);
		car = atlas.findRegion("d0003");
		arrayT.add(car);
		car = atlas.findRegion("d0004");
		arrayT.add(car);
		car = atlas.findRegion("d0005");
		arrayT.add(car);
		defensaCamina = new Animation(0.05f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("r0002");
		arrayT.add(car);
		car = atlas.findRegion("r0004");
		arrayT.add(car);
		car = atlas.findRegion("r0006");
		arrayT.add(car);
		car = atlas.findRegion("r0008");
		arrayT.add(car);
		car = atlas.findRegion("r0010");
		arrayT.add(car);
		rapidoCamina = new Animation(0.10f, arrayT, Animation.LOOP_PINGPONG);
		
		//fuente
		font = new BitmapFont(Gdx.files.internal("roboto.fnt"), atlas.findRegion("roboto"), false);
		if(Gdx.graphics.getWidth() < 400){
			font.setScale(0.42f);	
		}else if(Gdx.graphics.getWidth() < 900){
			font.setScale(0.6f);	
		}else if(Gdx.graphics.getWidth() < 1200){
			font.setScale(1f);	
		}else if(Gdx.graphics.getWidth() < 1600){
			font.setScale(1.2f);
		}else {
			font.setScale(1.4f);
		}
		
		skin = new Skin();
	
		
		//botones
		// Generate a 1x1 white texture and store it in the skin named "white".
				skin.add("fondo", new TextureRegion(atlas.findRegion("portada")));
				skin.add("boton", new TextureRegion(atlas.findRegion("boton_Amarillo4")));
				skin.add("boton2", new TextureRegion(atlas.findRegion("candado")));
				skin.add("poderes_icono", new TextureRegion(atlas.findRegion("poderes_icono")));
				skin.add("conejos_icono", new TextureRegion(atlas.findRegion("c0001")));
				skin.add("puntos_icono", new TextureRegion(atlas.findRegion("puntos")));
				skin.add("meta_icono", new TextureRegion(atlas.findRegion("meta")));
				skin.add("corazon_icono", new TextureRegion(atlas.findRegion("corazon")));
				skin.add("nivel_icono", new TextureRegion(atlas.findRegion("nivel")));
				skin.add("fondo_tabla", new TextureRegion(atlas.findRegion("borde")));
				skin.add("cerrar", new TextureRegion(atlas.findRegion("cerrar")));
				skin.add("mapa1", new TextureRegion(atlas.findRegion("mapa1")));
				skin.add("casa1", new TextureRegion(atlas.findRegion("casa1")));
				skin.add("casa2", new TextureRegion(atlas.findRegion("casa2")));
				skin.add("casa3", new TextureRegion(atlas.findRegion("casa3")));
				skin.add("casa4", new TextureRegion(atlas.findRegion("casa4")));
				skin.add("casa5", new TextureRegion(atlas.findRegion("casa5")));
				
				
				
				
				
				
				Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
				pixmap.setColor(Color.WHITE);
				pixmap.fill();
				skin.add("white", new Texture(pixmap));

				// Store the default libgdx font under the name "default".
				skin.add("default", font);

				// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
				TextButtonStyle textButtonStyle = new TextButtonStyle();
				textButtonStyle.up = skin.newDrawable("boton",Color.WHITE);
				textButtonStyle.down = skin.newDrawable("boton", Color.RED);
				//textButtonStyle.checked = skin.newDrawable(skin.getDrawable("grama"), Color.DARK_GRAY);
				textButtonStyle.over = skin.newDrawable("boton", Color.LIGHT_GRAY);
				textButtonStyle.font = font;
				skin.add("default", textButtonStyle);

				LabelStyle labelStyle =new LabelStyle();
				labelStyle.font = font;
				skin.add("default", labelStyle);
						// Create a table that fills the screen. Everything else will go inside this table.
				ImageButtonStyle imageButtonStyle = new ImageButtonStyle();
						
				imageButtonStyle.up = skin.newDrawable("boton");
				imageButtonStyle.down = skin.newDrawable("boton");
				imageButtonStyle.checked = skin.newDrawable("boton");
				imageButtonStyle.over = skin.newDrawable("boton2");
				skin.add("default", imageButtonStyle);
				
				
						
			//sonidos
			volumen = 1f;
			golpe = Gdx.audio.newSound(Gdx.files.internal("golpe.mp3"));
			empujar = Gdx.audio.newSound(Gdx.files.internal("empujar.mp3"));
			completo =Gdx.audio.newSound(Gdx.files.internal("completo.mp3"));
			menu = Gdx.audio.newSound(Gdx.files.internal("menu.mp3"));
			cambiarMusica();
	}
	
	public static void cargarCamino(int id){
		switch (id) {
		case 0:
			road = atlas.findRegion("piso_tierra");
			break;
		case 1:
			road = atlas.findRegion("piso_verde");
			break;
		case 2:
			road = atlas.findRegion("piso_motana");
			break;
		case 3:
			road = atlas.findRegion("piso_lago");
			break;
		default:
			road = atlas.findRegion("piso_tierra");
			break;
		}
	}

	public static void dispose() {
		atlas.dispose();
		font.dispose();
		skin.dispose();
	}
	
	public static void resise(){
		if(Gdx.graphics.getWidth() > Gdx.graphics.getHeight()){
			escala = Gdx.graphics.getHeight()/5;
		}else{
			escala = Gdx.graphics.getWidth()/5;
		}
	}
	
	public static void cambiarMusica(){
		String cansion1 = "book_of_the_monkey.lite.mp3";
		//String cansion2 = "sonido-musica/Rocker.lite.mp3";
		String cansion2 = "book_of_the_monkey.lite.mp3";
		
		int cansion = MathUtils.random(0, 1);
		
		if(cansion == 0){
			musica = Gdx.audio.newMusic(Gdx.files.internal(cansion1));
		}else if(cansion == 1){
			musica = Gdx.audio.newMusic(Gdx.files.internal(cansion2));
		}else{
			musica = Gdx.audio.newMusic(Gdx.files.internal(cansion1));
		}
		
		musica.setVolume(volumen*0.5f);
		musica.setLooping(true);
	}
}
