package com.cubo2d.morrocoy;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor {
	private Rectangle bounds = new Rectangle();
	float stateTime;
	
	public Enemy(float x, float y, float max, float min) {
		setWidth(Assets.escala+Assets.escala/2);
		setHeight(Assets.escala);
		setPosition(x, y - getHeight()/2);

		int rnd = MathUtils.random(0, 4);
		if (rnd == 0) setColor(new Color(0.992157f, 0.960784f, 0.901961f,1));
		if (rnd == 1) setColor(new Color(1f, 0.960784f, 0.951961f,1));
		if (rnd == 2) setColor(new Color(0.85f, 0.960784f, 1f,1));
		if (rnd == 3) setColor(new Color(0.91f, 0.980784f, 0.911961f,1));
		if (rnd == 4) setColor(new Color(0.46f, 0.56f, 0.66f,1));
		
		addAction(moveTo(-getWidth(), getY(), MathUtils.random(min, max)));
	}
	
	
	
	@Override
	public void act(float delta){
		super.act(delta);
		updateBounds();
		stateTime+= Gdx.graphics.getDeltaTime();
	}
	

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);		
		//batch.draw(Assets.car, getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		
		batch.draw(Assets.conejoCamina.getKeyFrame(stateTime), getX(), getY(), getWidth()/2, getHeight()/2, getWidth(), getHeight(), 1, 1, getRotation());
		
	}
	
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
	}
	
	public void crash(boolean front, boolean above) {
		clearActions();
		addAction(fadeOut(1f));
		if (front && above) addAction(sequence(parallel(rotateBy(-360, 1.5f), moveBy(200, 200, 1.5f)), removeActor()));
		if (front && !above) addAction(sequence(parallel(rotateBy(360, 1.5f), moveBy(200, -200, 1.5f)), removeActor()));
		if (!front && above) addAction(sequence(parallel(rotateBy(360, 1.5f), moveBy(-200, 200, 1.5f)), removeActor()));
		if (!front && !above) addAction(sequence(parallel(rotateBy(-360, 1.5f), moveBy(-200, -200, 1.5f)), removeActor()));
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
