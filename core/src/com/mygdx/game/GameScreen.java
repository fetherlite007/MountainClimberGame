package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private MountainClimberGame mountainclimbergame;
	private Texture characterImg;
	private Character character;
	World world;
	private WorldRenderer worldrenderer;
	
	public GameScreen(MountainClimberGame mountainclimbergame){
		this.mountainclimbergame = mountainclimbergame;
		
		characterImg = new Texture("character01.png");
		
		world = new World(mountainclimbergame);
		character = world.getCharacter();
		
		worldrenderer = new WorldRenderer(mountainclimbergame ,world);
	}
	
	@Override
	public void render(float delta) {
		update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldrenderer.render(delta);
	}
	
	private void update(float delta) {
		
		updateCharacterDirection();
		world.update(delta);
    }
	
	private void updateCharacterDirection() {
		Character character = world.getCharacter();
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            character.setNextDirection(Character.DIRECTION_LEFT);
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            character.setNextDirection(Character.DIRECTION_RIGHT);
		}
		else if(Gdx.input.isKeyPressed(Keys.UP)) {
			character.setNextDirection(Character.DIRECTION_UP);
        }
		else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            character.setNextDirection(Character.DIRECTION_DOWN);
		}
		else 
		{
			character.setNextDirection(character.DIRECTION_STILL);
		}
    }

}