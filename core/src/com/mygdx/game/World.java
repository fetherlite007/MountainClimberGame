package com.mygdx.game;

public class World {
	private Character character;
    private MountainClimberGame mountainclimbergame;
    private Level level;
 
    World(MountainClimberGame mountainclimbergame) {      
        level = new Level();
        character = new Character(60,60,this);
        this.mountainclimbergame = mountainclimbergame;
    }
 
    Character getCharacter() {
        return character;
    }
    
    Level getLevel(){
    	return level;
    }
    public void update(float delta) {
        character.update();
    }
}
