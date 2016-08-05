package com.jmrapp.terralegion.game.world.entity.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.jmrapp.terralegion.engine.world.entity.BodyType;
import com.jmrapp.terralegion.game.item.ItemManager;
import com.jmrapp.terralegion.game.item.ItemStack;
import com.jmrapp.terralegion.game.item.inventory.Inventory;
import com.jmrapp.terralegion.game.world.block.BlockType;
import com.jmrapp.terralegion.game.world.chunk.Chunk;
import com.jmrapp.terralegion.game.world.entity.Drop;
import com.jmrapp.terralegion.game.world.entity.LivingEntity;

public class Player extends LivingEntity {

	private static final float WIDTH = 32f;
	private static final float HEIGHT = 36f;

	private Inventory inventory;

	public Player(float x, float y) {
		super(x, y, WIDTH, HEIGHT, BodyType.DYNAMIC, 12f, 100, 100, 6.5f);
		inventory = new Inventory(5, 8);

		this.inventory.addItemStack(ItemManager.getInstance().getItem(BlockType.WOOD_CHEST), 1);
	}

	public void pickUpDrop(Drop drop, Chunk chunk) {
		if (inventory.addItemStack(drop.getItem(), drop.getStackCount())) {
			chunk.removeEntity(drop);
			drop.destroy();
		}
	}

	@Override
	public void update() {
		if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
			if (canJump())
				jump();
		}
		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
			addVelocity(-getSpeed(), 0);
		}
		if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
			addVelocity(getSpeed(), 0);
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
