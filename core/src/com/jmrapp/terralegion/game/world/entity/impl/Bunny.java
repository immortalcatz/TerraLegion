package com.jmrapp.terralegion.game.world.entity.impl;

import com.badlogic.gdx.math.MathUtils;
import com.jmrapp.terralegion.engine.utils.Timer;
import com.jmrapp.terralegion.engine.world.entity.BodyType;
import com.jmrapp.terralegion.game.world.entity.FriendlyEntity;

/**
 * Created by Jon on 12/19/15.
 */
public class Bunny extends FriendlyEntity {

	private static final float WIDTH = 26f;
	private static final float HEIGHT = 24f;

	private float lastDirectionChange;
	private float moveX = 0;

	public Bunny(float x, float y) {
		super(x, y, WIDTH, HEIGHT, BodyType.DYNAMIC, 7f, 10, 7, 3.5f);
	}

	@Override
	public void update() {
		if (Timer.getGameTimeElapsed() - lastDirectionChange > 4) {
			if (MathUtils.random(1, 100) > 50) {
				moveX = -getSpeed();
				lastDirectionChange = Timer.getGameTimeElapsed();
			} else {
				moveX = getSpeed();
				lastDirectionChange = Timer.getGameTimeElapsed();
			}
		}
		if (MathUtils.random(1, 100) < 20) {
			if (canJump()) {
				jump();
			}
		}
		addVelocity(moveX, 0);
	}

}

