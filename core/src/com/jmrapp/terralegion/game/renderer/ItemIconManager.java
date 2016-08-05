package com.jmrapp.terralegion.game.renderer;

import com.jmrapp.terralegion.engine.views.drawables.Drawable;
import com.jmrapp.terralegion.engine.views.drawables.ResourceManager;
import com.jmrapp.terralegion.game.item.Item;
import com.jmrapp.terralegion.game.item.ItemStack;
import com.jmrapp.terralegion.game.item.ItemType;
import com.jmrapp.terralegion.game.world.block.Block;
import com.jmrapp.terralegion.game.world.block.BlockType;

import java.util.HashMap;

public class ItemIconManager {

	private static final HashMap<Integer, Drawable> icons = new HashMap<Integer, Drawable>();

	static {
		icons.put(BlockType.DIRT.getId(), ResourceManager.getInstance().getDrawable("dirt"));
		icons.put(BlockType.GRASS.getId(), ResourceManager.getInstance().getDrawable("grass"));
		icons.put(BlockType.STONE.getId(), ResourceManager.getInstance().getDrawable("stone"));
		icons.put(BlockType.TORCH.getId(), ResourceManager.getInstance().getDrawable("torch"));
		icons.put(BlockType.DIAMOND.getId(), ResourceManager.getInstance().getDrawable("diamond"));
		icons.put(BlockType.COAL.getId(), ResourceManager.getInstance().getDrawable("coal"));
		icons.put(ItemType.WOODEN_PICKAXE.getId(), ResourceManager.getInstance().getDrawable("woodenPickaxe"));
		icons.put(BlockType.LEAVES.getId(), ResourceManager.getInstance().getDrawable("leaves"));
		icons.put(ItemType.SWORD.getId(), ResourceManager.getInstance().getDrawable("sword"));
		icons.put(ItemType.STICK.getId(), ResourceManager.getInstance().getDrawable("stick"));
		icons.put(BlockType.WOOD_CHEST.getId(), ResourceManager.getInstance().getDrawable("chest"));
	}

	public static Drawable getIcon(ItemStack stack) {
		return getIcon(stack.getItem());
	}

	public static Drawable getIcon(Item item) {
		return getIcon(item.getTypeId());
	}

	public static Drawable getIcon(ItemType type) {
		return getIcon(type.getId());
	}

	public static Drawable getIcon(Block block) {
		return getIcon(block.getType());
	}

	public static Drawable getIcon(BlockType type) {
		return getIcon(type.getId());
	}

	public static Drawable getIcon(int id) {
		return icons.get(id);
	}
}
