package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends ScreenAdapter{
	private MountainClimberGame mountainclimbergame;
	private Texture menuImg;
	private SpriteBatch batch;
	private Sound bgm;
	
	public MenuScreen(MountainClimberGame mountainclimbergame) {
		this.mountainclimbergame = mountainclimbergame;
		batch = mountainclimbergame.batch;
		menuImg = new Texture("menu01.png");
		bgm = Gdx.audio.newSound(Gdx.files.internal("bgm01.mp3"));
		bgm.loop();
        bgm.play();
	}
	
	public void render(float delta) {
		update(delta);
		batch.begin();
		
		batch.draw(menuImg, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			mountainclimbergame.setScreen(new GameScreen(mountainclimbergame));
			bgm.stop();
		}
	}
}