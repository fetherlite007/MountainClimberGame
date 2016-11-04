package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MountainClimberGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = MountainClimberGame.WIDTH;
        config.height = MountainClimberGame.HEIGHT;
        new LwjglApplication(new MountainClimberGame(), config);
	}
}
