package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture endImg;
	private SpriteBatch batch;
	private LevelSelectScreen levelselectscreen;
	private Sound bgm;
	
	public EndScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		endImg = new Texture("end01.png");
		bgm = Gdx.audio.newSound(Gdx.files.internal("ending01.mp3"));
        bgm.play();
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		batch.draw(endImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			levelselectscreen.mapNumber++;
			if(levelselectscreen.mapNumber == 5){
				levelselectscreen.mapNumber = 1;
			}
	
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
			Level.wonStat = 0;
			bgm.stop();
		}
		
		if(Gdx.input.isKeyPressed(Keys.I)) {
			mountainclimbergame.setScreen(new InstructionScreen(mountainclimbergame));
			Level.wonStat = 0;
			bgm.stop();
		}
	}
}
