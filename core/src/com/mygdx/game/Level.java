package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Level {
	public String[] MAP2 = new String [] {
            "#########################",
            "# ddddX.aaae.  X      EX#",
            "# w###wa d   w    sddddw#",
            "#d dXaw  # w X  #Xdw#####",
            "##s##w  X#dd X  ###w#####",
            "##s#X   X#w# w  #sa dddX#",
            "#X.     X#w#  ss#Xa dddw#",
            "#.s##  saa d #  #  wdd .#",
            "#wX## #s#    #      #d  #",
            "#wa   #.#X d #      #wd #",
            "##### de#dw  #    dX#wd #",
            "#saaaswdd s  ########wd #",
            "#e  a dwX#ds######ddd dw#",
            "#Xaaa.dddX#ddddddd Xw####",
            "#########################"    
    };
	public String[] MAP1 = new String [] {
			"#########################",
            "#  Xe#####X.. #saa.dd  .#",   
            "#swXw    a a  a dXw w   #",
            "# dXa ...w####w X.wa ddX#",
            "#ssX####s#dddXw #s## dss#",
            "#  XEeaaa#w##ww #.## #. #",
            "#dsX##w###.dd X X ## d  #",
            "#   d  d #w##se dX## #  #",
            "#sdX##s            # #ds#",
            "#. X.a #X#s##s Es# # #Es#",
            "#  X##s#wa e.ass   #   s#",
            "#ddX.a s#ss Xw s## # #Es#",
            "#. a dsa   eX# ddd d ##X#",
            "#  X#Xa#   .X#.ddd.e d .#",
            "#########################"    
    };
	public String[] MAP3 = new String [] {
            "#########################",
            "# Xd.#d.X#e  dddddX#   .#",
            "#   d  dX#.  X######  aas#",
            "#XXs##d E#ws   d     as.#",
            "#waa#e#ssa  ddddddddddd #",
            "####Ew# dX####.##  ####X#",
            "#.X##.#sdw#   w .wsddddw#",
            "#waa w# ww#w # ws.dw#.ew#",
            "#waa    X   X#  X  X#   #",
            "##### # w X e      wEwws#",
            "#s. a d d X   E     d   #",
            "#s#s#s###wwwww# ssX##e. #",
            "#e..#.ds#dddsa  sd   #X##",
            "#waa#Xaa#X.  a ddddX.d E#",
            "#########################"    
    };
	public String[] MAP4 = new String [] {
            "#########################",
            "# dddsdddddddddddddddddX#",
            "# d Xdws#e#   X   d  EdX#",
            "# .#Xwdds##   w#Xd ddddX#",
            "# d  sdX d.dsa dww##ddsX#",
            "# .#dXwaa   ddwdd d. dde#",
            "#sddd X w  ddddddddddssX#",
            "#.dX#Eddddd ds d w.#EXdX#",
            "# d.#X ####sa.d     dddX#",
            "# dX#X .. a dsX .  d dsX#",
            "# d #X     sXXa.E.d dsdE#",
            "# d ###d dd wXa#dXddddsX#",
            "# d #X#ws#Xd d d d.. ssX#",
            "# d  w#X.#X e a w#Xa ddX#",
            "#########################"    
    };
	public String[] MAP;
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
	private MountainClimberGame mountainclimbergame;
	private LevelSelectScreen levelselectscreen;
	public static int itemCount = 0;
	public static int wonStat = 0;
	public static int maxItemCount = 3;
	public static int deadStat = 0;
	
	public Level() {
		levelSelected();
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
	
	public void levelSelected(){
		if(levelselectscreen.mapNumber == 1){
			MAP = MAP1;
		} else if(levelselectscreen.mapNumber == 2){
			MAP = MAP2;
		} else if(levelselectscreen.mapNumber == 3){
			MAP = MAP3;
		} else if(levelselectscreen.mapNumber == 4){
			MAP = MAP4;
		}
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
