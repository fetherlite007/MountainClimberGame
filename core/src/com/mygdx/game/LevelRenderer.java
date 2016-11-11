package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelRenderer {
	private Level level;
	private SpriteBatch batch;
    private Texture rockImg;
    private Texture itemImg;
    private Texture bgImg;
    
    public LevelRenderer(SpriteBatch batch, Level level) {
        this.level = level;
        this.batch = batch;
        rockImg = new Texture("rock01.png");
        itemImg = new Texture("key01.png");
        bgImg = new Texture("grass01.jpg");
        
    }
 
    public void render() {
        batch.begin();
        batch.draw(bgImg,0,0);
        for(int r = 0; r < level.getHeight(); r++) {
            for(int c = 0; c < level.getWidth(); c++) {
                int x = c * WorldRenderer.BLOCK_SIZE;
                int y = MountainClimberGame.HEIGHT -
                		(r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
                if(level.hasRockAt(r, c)) {
                    batch.draw(rockImg, x, y);
                } else if(level.hasItemAt(r, c)) {
                    batch.draw(itemImg, x, y);
                }
            }
        }
	    batch.end();
	}
}
