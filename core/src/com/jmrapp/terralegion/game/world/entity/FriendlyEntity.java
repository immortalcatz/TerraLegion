package com.jmrapp.terralegion.game.world.entity;

import com.jmrapp.terralegion.engine.world.entity.BodyType;

/**
 * Created by Jon on 12/21/15.
 */
public abstract class FriendlyEntity extends LivingEntity {

	public FriendlyEntity(float x, float y, float width, float height, BodyType bodyType, float speed, float maxHealth, float health, float jumpVelocity) {
		super( x, y, width, height, bodyType, speed, maxHealth, health, jumpVelocity);
	}

}
