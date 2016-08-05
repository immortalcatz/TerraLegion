package com.jmrapp.terralegion.game.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jmrapp.terralegion.engine.views.drawables.Drawable;
import com.jmrapp.terralegion.engine.views.drawables.ResourceManager;
import com.jmrapp.terralegion.game.utils.LightUtils;
import com.jmrapp.terralegion.game.world.block.Block;
import com.jmrapp.terralegion.game.world.block.BlockType;

import java.util.HashMap;

public class BlockDrawableManager {

	private static final HashMap<BlockType, Drawable> icons = new HashMap<BlockType, Drawable>();

	static {
		//icons.put(BlockType.AIR, null);
		icons.put(BlockType.GRASS, ResourceManager.getInstance().getDrawable("grass"));
		icons.put(BlockType.DIRT, ResourceManager.getInstance().getDrawable("dirt"));
		icons.put(BlockType.STONE, ResourceManager.getInstance().getDrawable("stone"));
		icons.put(BlockType.DIAMOND, ResourceManager.getInstance().getDrawable("diamond"));
		icons.put(BlockType.COAL, ResourceManager.getInstance().getDrawable("coal"));
		icons.put(BlockType.TORCH, ResourceManager.getInstance().getDrawable("torch"));
		icons.put(BlockType.STONE_WALL, ResourceManager.getInstance().getDrawable("stoneWall"));
		icons.put(BlockType.DIRT_WALL, ResourceManager.getInstance().getDrawable("dirtWall"));
		icons.put(BlockType.WOOD, ResourceManager.getInstance().getDrawable("wood"));
		icons.put(BlockType.LEAVES, ResourceManager.getInstance().getDrawable("leaves"));
		icons.put(BlockType.WOOD_CHEST, ResourceManager.getInstance().getDrawable("chest"));
	}

	public static Drawable getDrawable(Block block) {
		return getDrawable(block.getType());
	}

	public static Drawable getDrawable(BlockType type) {
		return icons.get(type);
	}

	public static void render(Block block, SpriteBatch sb, float x, float y, float lightValue) {
		render(block.getType(), sb, x, y, lightValue);
	}

	public static void render(BlockType type, SpriteBatch sb, float x, float y, float lightValue) {
		float value = lightValue < LightUtils.MIN_LIGHT_VALUE ? LightUtils.MIN_LIGHT_VALUE : lightValue;
		sb.setColor(value, value, value, 1);
		Drawable drawable = getDrawable(type);
		drawable.render(sb, x, y);
		sb.setColor(Color.WHITE);
	}
}
