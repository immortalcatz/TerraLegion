package com.jmrapp.terralegion.game.world.block;

import com.jmrapp.terralegion.game.world.block.impl.ChestBlock;
import com.jmrapp.terralegion.game.world.block.impl.LightBlock;
import com.jmrapp.terralegion.game.world.block.impl.WoodBlock;

import java.util.HashMap;

public class BlockManager {

	private static final HashMap<BlockType, Block> blocks = new HashMap<BlockType, Block>();
	private static final BlockType[] blockTypeArray = BlockType.values(); //used becasue calling values() method creates new array each call. Takes up too many resources

	static {
		blocks.put(BlockType.AIR, new Block(BlockType.AIR, 0.05f, false, false, 0, 0));
		blocks.put(BlockType.GRASS, new Block(BlockType.GRASS, .15f, true, false, .5f, .25f));
		blocks.put(BlockType.DIRT, new Block(BlockType.DIRT, .15f, true, false, .5f, .25f));
		blocks.put(BlockType.STONE, new Block(BlockType.STONE, .15f, true, false, .7f, .35f));
		blocks.put(BlockType.DIAMOND, new Block(BlockType.DIAMOND, .15f, true, false, .8f, .75f));
		blocks.put(BlockType.COAL, new Block(BlockType.COAL, .15f, true, false, .8f, .35f));
		blocks.put(BlockType.TORCH, new LightBlock(BlockType.TORCH, .05f, false, 1f, true, .1f, .1f));
		blocks.put(BlockType.STONE_WALL, new Wall(BlockType.STONE_WALL, .5f, .15f));
		blocks.put(BlockType.DIRT_WALL, new Wall(BlockType.DIRT_WALL, .5f, .15f));
		blocks.put(BlockType.WOOD, new WoodBlock(BlockType.WOOD, .15f, true, true, .6f, .3f));
		blocks.put(BlockType.LEAVES, new Block(BlockType.LEAVES, .15f, true, false, .5f, .1f));
		blocks.put(BlockType.WOOD_CHEST, new ChestBlock(3, 3, BlockType.WOOD_CHEST, .15f, true, false, 5f, .1f));
	}
	
	public static Block getBlock(BlockType type) {
		return blocks.get(type);
	}

	public static BlockType getBlockType(int id) {
		for (BlockType type : blockTypeArray) {
			if (type.getId() == id) {
				return type;
			}
		}
		return null;
	}

}
