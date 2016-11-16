package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Level {
	private String[] MAP = new String [] {
            "#########################",
            "# ddd dddX       .    e #",
            "#  w       e            #",
            "#    X                  #",
            "# s          X          #",
            "#   a                   #",
            "# .              X      #",
            "#                       #",
            "#                       #",
            "#        X              #",
            "#     e          e      #",
            "#                       #",
            "#e         e            #",
            "#    .             X   E#",
            "#########################"    
    };
	private int height;
	private int width;
	private boolean [][] hasItem;
	private boolean [][] hasTrap01;
	private boolean [][] hasTrap02;
	private boolean [][] hasTrap03;
	private boolean [][] hasTrap04;
	private boolean [][] hasTrap05;
	private boolean [][] hasTrap06;
	private boolean [][] hasExit;
	public static int deadStat = 0;
	private MountainClimberGame mountainclimbergame;
	public static int itemCount = 0;
	public static int wonStat = 0;
	public static int maxItemCount = 3;
	
	public Level() {
        height = MAP.length;
        width = MAP[0].length();
        initItemData();
        initTrapData();
        initTrap2Data();
        initTrap3Data();
        initTrap4Data();
        initTrap5Data();
        initTrap6Data();
        initExitData();
        
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
    
    public boolean hasTrap01At(int r, int c) {
    	return hasTrap01[r][c];
    }
    
    public boolean hasTrap02At(int r, int c) {
    	return hasTrap02[r][c];
    }
    
    public boolean hasTrap03At(int r, int c) {
    	return hasTrap03[r][c];
    }
    
    public boolean hasTrap04At(int r, int c) {
    	return hasTrap04[r][c];
    }
    
    public boolean hasTrap05At(int r, int c) {
    	return hasTrap05[r][c];
    }
    
    public boolean hasTrap06At(int r, int c) {
    	return hasTrap06[r][c];
    }
    
    public boolean hasExitAt(int r, int c) {
    	return hasExit[r][c];
    }
    
    private void initItemData() {
    	hasItem = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasItem[r][c] = MAP[r].charAt(c) == '.';
            }
        }
    }
    private void initTrapData() {
    	hasTrap01 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap01[r][c] = MAP[r].charAt(c) == 'X';
            }
        }
    }
    
    private void initTrap2Data() {
    	hasTrap02 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap02[r][c] = MAP[r].charAt(c) == 'e';
            }
        }
    }
    
    private void initTrap3Data() {
    	hasTrap03 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap03[r][c] = MAP[r].charAt(c) == 'd';
            }
        }
    }
    
    private void initTrap4Data() {
    	hasTrap04 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap04[r][c] = MAP[r].charAt(c) == 'w';
            }
        }
    }
    
    private void initTrap5Data() {
    	hasTrap05 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap05[r][c] = MAP[r].charAt(c) == 'a';
            }
        }
    }
    
    private void initTrap6Data() {
    	hasTrap06 = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasTrap06[r][c] = MAP[r].charAt(c) == 's';
            }
        }
    }
    
    public void initExitData() {
    	hasExit = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
            	hasExit[r][c] = MAP[r].charAt(c) == 'E';
            }
        }
    }
    
    public void removeItemAt(int r, int c) {
    	itemCount++;
        hasItem[r][c] = false;
       
    }
    
    public void deadAt(int r, int c) {
    	deadStat = 1;
    	
    }
    
    public void endAt(int r, int c){
    	if(itemCount == maxItemCount){
    		wonStat = 1;
    	}
    }
    
    
}
