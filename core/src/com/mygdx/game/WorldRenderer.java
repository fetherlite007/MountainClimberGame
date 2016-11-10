package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private MountainClimberGame mountainclimbergame;
	World world;
	private SpriteBatch batch;
	private Texture characterImg;
	private Character character;
	private LevelRenderer levelrenderer;
	public static final int BLOCK_SIZE = 40;
	
	public WorldRenderer(MountainClimberGame mountainclimbergame, World world) {
        this.mountainclimbergame = mountainclimbergame;
        batch = mountainclimbergame.batch;
 
        this.world = world;
        character = world.getCharacter();
 
        characterImg = new Texture("character01.png");
        levelrenderer = new LevelRenderer(mountainclimbergame.batch, world.getLevel());
    }
	public void render(float delta) {
		levelrenderer.render();
		SpriteBatch batch = MountainClimberGame.batch;
		 batch.begin();
	     Vector2 pos = world.getCharacter().getPosition();
	     batch.draw(characterImg, pos.x - BLOCK_SIZE/2, MountainClimberGame.HEIGHT - pos.y - BLOCK_SIZE/2);
	    
	     
	     batch.end();
	}
}
