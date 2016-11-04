package com.mygdx.game;

public class Level {
	private String[] MAP = new String [] {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "####################"    
    };
	private int height;
	private int width;
	public Level() {
        height = MAP.length;
        width = MAP[0].length();
    }
 
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public boolean hasFloorAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasSkyAt(int r, int c) {
        return MAP[r].charAt(c) == '.';
    }
}
