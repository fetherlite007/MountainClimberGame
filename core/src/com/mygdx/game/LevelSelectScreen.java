package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelSelectScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture levelSelectImg;
	private SpriteBatch batch;
	private Sound bgm;
	private MenuScreen menuscreen;
	private Level level;
	public static int mapNumber;
	
	public LevelSelectScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		levelSelectImg = new Texture("levelSelect01.png");
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		batch.draw(levelSelectImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
			mapNumber = 1;
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
		}
		if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
			mapNumber = 2;	
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
		}
		if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
			mapNumber = 3;
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
		}
		if(Gdx.input.isKeyPressed(Keys.NUM_4)) {
			mapNumber = 4;
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
		}
	}
}