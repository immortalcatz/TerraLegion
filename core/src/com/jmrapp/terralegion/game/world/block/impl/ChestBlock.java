package com.jmrapp.terralegion.game.world.block.impl;

import com.jmrapp.terralegion.engine.views.screens.ScreenManager;
import com.jmrapp.terralegion.game.views.screen.InventoryScreen;
import com.jmrapp.terralegion.game.world.block.BlockType;
import com.jmrapp.terralegion.game.world.block.InventoryBlock;
import com.jmrapp.terralegion.game.world.chunk.Chunk;
import com.jmrapp.terralegion.game.world.chunk.ChunkManager;

/**
 * Acts as a block where players may store items
 *
 * Created by root on 8/2/16.
 *
 * TODO For breaking, the chest could display a menu: "(Break) or (Open)", or it could hold a (Break) button inside the inventory screen.
 */
public class ChestBlock extends InventoryBlock {

    /** Whether the chest is opened **/
    private boolean open;

    public ChestBlock(int inventoryWidth, int inventoryHeight , BlockType type, float lightBlockingAmount, boolean collides, boolean transparent, float initHealth, float resistance){
        super(inventoryWidth, inventoryHeight, type, lightBlockingAmount, collides, transparent, initHealth, resistance);
    }

    @Override
    public void onBreak(ChunkManager chunkManager, Chunk chunk, int chunkTileX, int chunkTileY) {
        super.onBreak(chunkManager, chunk, chunkTileX, chunkTileY);

        ScreenManager.setScreen(new InventoryScreen(ScreenManager.getCurrent(), chunkManager.getWorld(), this.getInventory()));

        this.open();
    }

    /**
     * Opens the inventory display
     */
    public void open(){
        this.open = true;
    }

    /**
     * Closes the inventory display
     */
    public void close(){
        this.open = false;
    }

    public boolean isOpen(){
        return this.open;
    }


}
