package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MountainClimberGame extends Game {
	public static SpriteBatch batch;
	public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;
	 
    @Override
    public void create () {
    	batch = new SpriteBatch();
        setScreen(new MenuScreen(this));
    }
 
    @Override
    public void render () {
        super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}
