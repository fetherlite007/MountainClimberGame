package com.mygdx.game;

public class World {
	private Character character;
    private MountainClimberGame mountainclimbergame;
    private Level level;
 
    World(MountainClimberGame mountainclimbergame) {
        this.mountainclimbergame = mountainclimbergame;
 
        character = new Character(60,60);
        level = new Level();
    }
 
    Character getCharacter() {
        return character;
    }
    
    Level getLevel(){
    	return level;
    }
}
