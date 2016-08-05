package com.jmrapp.terralegion.game.world.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jmrapp.terralegion.engine.utils.Timer;
import com.jmrapp.terralegion.engine.world.collision.CollisionInfo;
import com.jmrapp.terralegion.engine.world.collision.CollisionSide;
import com.jmrapp.terralegion.engine.world.entity.BodyType;
import com.jmrapp.terralegion.engine.world.entity.WorldBody;
import com.jmrapp.terralegion.game.item.impl.ToolItem;
import com.jmrapp.terralegion.game.utils.Direction;

/**
 * Created by Jon on 12/21/15.
 */
public abstract class LivingEntity extends WorldBody {

	protected static final ShapeRenderer shapeRenderer = new ShapeRenderer();
	private static final float healthBarWidth = 30, healthBarHeight = 5;

	private Direction facingDirection = Direction.LEFT;
	private boolean canJump = true;
	private float speed, health, maxHealth, jumpVelocity;
	private float lastToolUsedTime, lastDamageReceived = Timer.getGameTimeElapsed();

	public LivingEntity(float x, float y, float width, float height, BodyType bodyType, float speed, float maxHealth, float health, float jumpVelocity) {
		super(x, y, width, height, bodyType);
		this.speed = speed;
		this.health = health;
		this.maxHealth = maxHealth;
		this.jumpVelocity = jumpVelocity;
	}

	@Override
	public boolean collision(WorldBody obj, CollisionInfo info) {
        boolean isThisCollisionA = info.getCollisionA() == this;
        boolean isThisCollisionB = info.getCollisionB() == this;
        boolean isBottomCollisionA = CollisionSide.BOTTOM == info.getCollisionASide();
        boolean isBottomCollisionB = CollisionSide.BOTTOM == info.getCollisionBSide();
		if ((isThisCollisionA || isThisCollisionB) && (isBottomCollisionA || isBottomCollisionB)) {
            canJump = true;
        }
		return true;
	}

	public void damage(float damage) {
		health -= damage;
		lastDamageReceived = Timer.getGameTimeElapsed();
	}

	public boolean wasRecentlyDamaged() {
		return Timer.getGameTimeElapsed() - lastDamageReceived <= 5f;
	}

	public void heal(float amount) {
		health += amount;
		if (health > maxHealth)
			health = maxHealth;
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void usedTool() {
		lastToolUsedTime = Timer.getGameTimeElapsed();
	}

	public boolean canUseTool(ToolItem item) {
		return Timer.getGameTimeElapsed() - lastToolUsedTime >= item.getUseDelay();
	}

	public void jump() {
		velY = jumpVelocity;
		canJump = false;
	}

	public boolean canJump() {
		return canJump;
	}

	public float getSpeed() {
		return speed;
	}

	public float getHealth() {
		return health;
	}

	public float getMaxHealth() {
		return maxHealth;
	}

	public float getJumpVelocity() {
		return jumpVelocity;
	}

    public void faceDirection(Direction direction) {
        facingDirection = direction;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

	@Override
	public void addVelocity(float x, float y) {
        if(x < 0 && velX != 0) {
            faceDirection(Direction.RIGHT);
        } else if(x > 0 && velX != 0) {
            faceDirection(Direction.LEFT);
        }
        super.addVelocity(x, y);
    }
}