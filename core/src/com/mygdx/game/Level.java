package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Level {
	private String[] MAP = new String [] {
            "#########################",
            "#             .         #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#                       #",
            "#########################"    
    };
	private int height;
	private int width;
	private boolean [][] hasItem;
	
	public Level() {
        height = MAP.length;
        width = MAP[0].length();
        initItemData();   
    }
	
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public boolean hasRockAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasItemAt(int r, int c) {
    	return hasItem[r][c];
    }
    
    private void initItemData() {
    	hasItem = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasItem[r][c] = MAP[r].charAt(c) == '.';
            }
        }
    }
    
    public void removeItemAt(int r, int c) {
        hasItem[r][c] = false;
    }
}
