package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class Character {
	public static Vector2 position;
	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    public static final int SPEED = 5;
    private int currentDirection;
    private int nextDirection;
    public int canMove = 1;
    private Sound slipSound;
    private Sound pickingSound;
    private World world;    
    
    public Character(int x, int y, World world) {
        position = new Vector2(x,y);
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        this.world = world;
		slipSound = Gdx.audio.newSound(Gdx.files.internal("slipping01.mp3"));
		pickingSound = Gdx.audio.newSound(Gdx.files.internal("picking01.mp3"));
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int dir) { 
    	position.x += SPEED * DIR_OFFSETS[dir][0];   
    	position.y += SPEED * DIR_OFFSETS[dir][1];
    }
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
    
    public void update() {
    	Level level = world.getLevel();
        if(isAtCenter()) {
        	if(level.hasItemAt(getRow(), getColumn())) {
        		pickingSound.play();
        		level.removeItemAt(getRow(), getColumn());
        	}
        	
        	if(level.hasTrap01At(getRow(), getColumn())) {
        		level.deadAt(getRow(), getColumn());
        	}
        	
        	if(level.hasTrap02At(getRow(), getColumn())) {	
        		level.deadAt(getRow(), getColumn());
        	}
       
        	if(level.hasTrap03At(getRow(), getColumn())) {
        		slipSound.play();
        		canMove = 0;
        		position.x += 40; 		
        	}
        	
        	if(level.hasTrap04At(getRow(), getColumn())) {
        		slipSound.play();
        		canMove = 0;
        		position.y -= 40;
        	}
        	
        	if(level.hasTrap05At(getRow(), getColumn())) {
        		slipSound.play();
        		canMove = 0;
        		position.x -= 40;
        	}
        	
        	if(level.hasTrap06At(getRow(), getColumn())) {
        		slipSound.play();
        		canMove = 0;
        		position.y += 40;
        	}
        	if(level.hasExitAt(getRow(), getColumn())) {
        		level.endAt(getRow(), getColumn());
        	}
            if(canMoveInDirection(nextDirection)&&canMove ==1) {
                currentDirection = nextDirection;    
            } else {
                currentDirection = DIRECTION_STILL;   
                canMove = 1;
            }
        }
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
        position.y += SPEED * DIR_OFFSETS[currentDirection][1];
    }
    
    public boolean isAtCenter() {
        int blockSize = WorldRenderer.BLOCK_SIZE;
        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
    }
    
    private boolean canMoveInDirection(int dir) 
    {
    	Level level = world.getLevel();
    	int newRow = getRow()+DIR_OFFSETS[dir][1];
    	int newCol = getColumn()+DIR_OFFSETS[dir][0];
    	if(level.hasRockAt(newRow, newCol))
    	{
    		return false;
    	} else {
    		return true;
    	}
    }
    
    private int getRow() {
        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
    }
 
    private int getColumn() {
        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
    }
}