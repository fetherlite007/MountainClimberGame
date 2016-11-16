package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InstructionScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture instructionImg;
	private SpriteBatch batch;
	private Sound bgm;
	private MenuScreen menuscreen;
	
	public InstructionScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		instructionImg = new Texture("instruction01.png");
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		batch.draw(instructionImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			menuscreen.bgmMenu.stop();
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
			
		}
	}
}

