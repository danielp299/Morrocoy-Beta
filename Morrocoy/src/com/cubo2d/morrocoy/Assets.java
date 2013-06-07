package com.cubo2d.morrocoy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	public static final float escala = Gdx.graphics.getHeight()/5;
	public static TextureRegion camino;
	public static int totalNiveles = 9;

	public static Sound golpe;
	public static Sound empujar;
	public static Sound completo;
	public static Sound menu;
	
	//animacion
	public static Animation tortugaCamina;
	public static Animation defensaCamina;
	public static Animation comidaCamina;
	public static Animation rapidoCamina;
	public static Animation conejoCamina;

	public static float velocidad_global = 1f;
	public static float velocidad_local = velocidad_global;
	public static BitmapFont font = new BitmapFont(Gdx.files.internal("fuente.fnt"),Gdx.files.internal("fuente.png"),false);
	public static Skin skin;
	

	

	public static void load() {
		atlas = new TextureAtlas(Gdx.files.internal("empaquetado.txt"));
		//car = atlas.findRegion("t0005");
		road = atlas.findRegion("piso_tierra");
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
		
		Array<TextureRegion> arrayT = new Array<TextureRegion>();
		car = atlas.findRegion("t0001");
		arrayT.add(car);
		car = atlas.findRegion("t0003");
		arrayT.add(car);
		car = atlas.findRegion("t0005");
		arrayT.add(car);
		//animacion
		tortugaCamina = new Animation(0.10f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("c0001");
		arrayT.add(car);
		car = atlas.findRegion("c0003");
		arrayT.add(car);
		car = atlas.findRegion("c0005");
		arrayT.add(car);
		conejoCamina = new Animation(0.15f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("co0001");
		arrayT.add(car);
		car = atlas.findRegion("co0003");
		arrayT.add(car);
		car = atlas.findRegion("co0005");
		arrayT.add(car);
		comidaCamina = new Animation(0.10f, arrayT, Animation.LOOP_PINGPONG);
		
		arrayT.clear();
		car = atlas.findRegion("d0001");
		arrayT.add(car);
		car = atlas.findRegion("d0003");
		arrayT.add(car);
		car = atlas.findRegion("d0005");
		arrayT.add(car);
		defensaCamina = new Animation(0.10f, arrayT, Animation.LOOP_PINGPONG);
		
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
		font.setScale(0.5f);
		
		skin = new Skin();
		
		//botones
		// Generate a 1x1 white texture and store it in the skin named "white".
				Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
				pixmap.setColor(Color.WHITE);
				pixmap.fill();
				skin.add("white", new Texture(pixmap));

				// Store the default libgdx font under the name "default".
				skin.add("default", new BitmapFont());

				// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
						TextButtonStyle textButtonStyle = new TextButtonStyle();
						textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
						textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
						textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
						textButtonStyle.over = skin.newDrawable("white", Color.GREEN);
						textButtonStyle.font = font;
						skin.add("default", textButtonStyle);

						LabelStyle labelStyle =new LabelStyle();
						labelStyle.font = font;
						skin.add("default", labelStyle);
						// Create a table that fills the screen. Everything else will go inside this table.
						
			//sonidos
			golpe = Gdx.audio.newSound(Gdx.files.internal("golpe.mp3"));
			empujar = Gdx.audio.newSound(Gdx.files.internal("empujar.mp3"));
			completo =Gdx.audio.newSound(Gdx.files.internal("completo.mp3"));
			menu = Gdx.audio.newSound(Gdx.files.internal("menu.mp3"));
			 
		
	}

	public static void dispose() {
		atlas.dispose();
		font.dispose();
	}
}
