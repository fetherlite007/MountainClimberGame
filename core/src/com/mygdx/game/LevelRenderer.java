package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelRenderer {
	private Level level;
	private SpriteBatch batch;
    private Texture rockImg;
    private Texture itemImg;
    private Texture bgImg;
    private Texture trap01Img;
    private Texture trap02Img;
    private Texture trap03Img;
    private Texture trap04Img;
    private Texture trap05Img;
    private Texture trap06Img;
    private Texture exitImg;
    
    public LevelRenderer(SpriteBatch batch, Level level) {
        this.level = level;
        this.batch = batch;
        rockImg = new Texture("rock01.png");
        itemImg = new Texture("key01.png");
        bgImg = new Texture("grass01.jpg");
        trap01Img = new Texture("trap01.png");
        trap02Img = new Texture("trap02.png");
        trap03Img = new Texture("trap03.png");
        trap04Img = new Texture("trap04.png");
        trap05Img = new Texture("trap05.png");
        trap06Img = new Texture("trap06.png");
        exitImg = new Texture("exit01.png");    
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
                } else if(level.hasTrap01At(r, c)) {
                    batch.draw(trap01Img, x, y);
                } else if(level.hasTrap02At(r, c)) {
                    batch.draw(trap02Img, x, y);
                } else if(level.hasTrap03At(r, c)) {
                    batch.draw(trap03Img, x, y);
                } else if(level.hasTrap04At(r, c)) {
                    batch.draw(trap04Img, x, y);
                } else if(level.hasTrap05At(r, c)) {
                    batch.draw(trap05Img, x, y);
                } else if(level.hasTrap06At(r, c)) {
                    batch.draw(trap06Img, x, y);
                } else if(level.hasExitAt(r, c)) {
                    batch.draw(exitImg, x, y);
                }
            }
        }
	    batch.end();
	}
}
