package com.jmrapp.terralegion.game.world.entity;

import com.jmrapp.terralegion.game.world.block.BlockType;
import com.jmrapp.terralegion.game.item.ItemManager;
import com.jmrapp.terralegion.game.item.ItemType;

import java.util.HashMap;

/**
 * Created by Jon on 9/30/15.
 */
public class DropManager {

    private static final DropManager instance = new DropManager();
    private final HashMap<Integer, Drop> drops = new HashMap<Integer, Drop>();

    private DropManager() {
        drops.put(BlockType.DIRT.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.DIRT)));
        drops.put(BlockType.GRASS.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.GRASS)));
        drops.put(BlockType.STONE.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.STONE)));
        drops.put(BlockType.TORCH.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.TORCH)));
        drops.put(BlockType.DIAMOND.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.DIAMOND)));
        drops.put(BlockType.COAL.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.COAL)));
        drops.put(BlockType.WOOD.getId(), new Drop(ItemManager.getInstance().getItem(ItemType.STICK)));
        drops.put(BlockType.LEAVES.getId(), new Drop(ItemManager.getInstance().getItem(BlockType.LEAVES)));
        drops.put(ItemType.WOODEN_PICKAXE.getId(), new Drop(ItemManager.getInstance().getItem(ItemType.WOODEN_PICKAXE)));
        drops.put(ItemType.SWORD.getId(), new Drop(ItemManager.getInstance().getItem(ItemType.SWORD)));
        drops.put(ItemType.STICK.getId(), new Drop(ItemManager.getInstance().getItem(ItemType.STICK)));
    }

    public Drop getDrop(BlockType type, int stackCount, float x, float y) {
        return drops.get(type.getId()).getInstance(type.getId(), stackCount, x, y);
    }

    public Drop getDrop(ItemType type, int stackCount, float x, float y) {
        return drops.get(type.getId()).getInstance(type.getId(), stackCount, x, y);
    }

    public Drop getDrop(int id, int stackCount, float x, float y) {
        return drops.get(id).getInstance(id, stackCount, x, y);
    }

    public static DropManager getInstance() {
        return instance;
    }

}
