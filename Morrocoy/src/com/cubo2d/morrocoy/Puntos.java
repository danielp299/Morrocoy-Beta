package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Puntos extends Enemy{

	int Puntos = 1;
	

	public Puntos(float x, float y) {
		super(x, y,4,6);
		// TODO Auto-generated constructor stub
		setWidth(Assets.escala);
		setHeight(Assets.escala);
		
		int rnd = MathUtils.random(0, 4);
		if (rnd == 0) setColor(new Color(0.992157f, 0.960784f, 0.901961f,1));
		if (rnd == 1) setColor(new Color(1f, 0.960784f, 0.951961f,1));
		if (rnd == 2) setColor(new Color(0.85f, 0.960784f, 1f,1));
		if (rnd == 3) setColor(new Color(0.91f, 0.980784f, 0.911961f,1));
		if (rnd == 4) setColor(new Color(1f,90f, 95f,1));
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		batch.draw(Assets.puntos, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
	}

	
	public void crash(boolean front, boolean above) {
		clearActions();
		addAction(fadeOut(2f));
		addAction(sequence(parallel(rotateBy(-720, 1.5f), moveTo(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/20,1f)), removeActor()));
		
	}
}
