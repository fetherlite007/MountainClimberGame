package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelRenderer {
		private Level level;
	    private SpriteBatch batch;
	    private Texture floorImg;
	    private Texture skyImg;
	    
	    public LevelRenderer(SpriteBatch batch, Level level) {
	        this.level = level;
	        this.batch = batch;
	        floorImg = new Texture("floor01.png");
	        skyImg = new Texture("sky01.png");
	    }
	 
	    public void render() {
	        batch.begin();
	        for(int r = 0; r < level.getHeight(); r++) {
	            for(int c = 0; c < level.getWidth(); c++) {
	                int x = c * WorldRenderer.BLOCK_SIZE;
	                int y = MountainClimberGame.HEIGHT - (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
	 
	                if(level.hasFloorAt(r, c)) {
	                    batch.draw(floorImg, x, y);
	                } else if(level.hasSkyAt(r, c)) {
	                    batch.draw(skyImg, x, y);
	                }
	            }
	        }
	        batch.end();
	    }
}
