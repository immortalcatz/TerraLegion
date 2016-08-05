package com.jmrapp.terralegion.game.world.block;

public class Wall extends Block {

	public Wall(BlockType type, float initHealth, float resistance) {
		super(type, 0, false, false, initHealth, resistance);
	}
	
	@Override
	public boolean isWall() {
		return true;
	}

}
