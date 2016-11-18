package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture gameoverImg;
	private SpriteBatch batch;
	private Sound bgm;
	
	public GameOverScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		gameoverImg = new Texture("gameover01.png");
		bgm = Gdx.audio.newSound(Gdx.files.internal("falling01.mp3"));
        bgm.play();
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		batch.draw(gameoverImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
			Level.deadStat = 0;
			bgm.stop();
		}
		
		if(Gdx.input.isKeyPressed(Keys.I)) {
			mountainclimbergame.setScreen(new InstructionScreen(mountainclimbergame));
			Level.deadStat = 0;
			bgm.stop();
		}
	}
}
