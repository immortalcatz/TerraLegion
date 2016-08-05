package com.jmrapp.terralegion.game.renderer.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jmrapp.terralegion.engine.views.drawables.AnimationDrawable;
import com.jmrapp.terralegion.engine.views.drawables.Drawable;
import com.jmrapp.terralegion.game.utils.Direction;
import com.jmrapp.terralegion.game.utils.LightUtils;
import com.jmrapp.terralegion.game.world.entity.LivingEntity;

public class LivingEntityRenderer<T extends LivingEntity> extends EntityRenderer<T> {

	private static final ShapeRenderer shapeRenderer = new ShapeRenderer();
	private static final float healthBarWidth = 30, healthBarHeight = 5;

	private final Drawable drawable;

	public LivingEntityRenderer(Drawable drawable) {
		this.drawable = drawable;
	}

	@Override
	public void render(T entity, SpriteBatch sb, double lightValue) {
		float value = (float) (lightValue < LightUtils.MIN_LIGHT_VALUE ? LightUtils.MIN_LIGHT_VALUE : lightValue);
		sb.setColor(value, value, value, 1);
		sb.draw(drawable.getTextureRegion(), entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
		sb.setColor(Color.WHITE);

		Direction facingDirection = entity.getFacingDirection();
		if(drawable instanceof AnimationDrawable) {
			AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
			if(facingDirection == Direction.LEFT) {
				animationDrawable.setAnimationByType(AnimationDrawable.Type.WALK_LEFT);
			}
			else if(facingDirection == Direction.RIGHT) {
				animationDrawable.setAnimationByType(AnimationDrawable.Type.WALK_RIGHT);
			}
		}
		else {
			drawable.getTextureRegion().flip(facingDirection == Direction.LEFT, false);
		}

		if (entity.wasRecentlyDamaged()) {
			renderHealthBar(sb, entity);
		}
	}

	public void renderHealthBar(SpriteBatch sb, T entity) {
		float renderX = entity.getX() + (drawable.getWidth() / 2) - (healthBarWidth / 2);
		float renderY = entity.getY() + (drawable.getHeight() + 5);
		float currentHealthWidth = entity.getHealth() * (healthBarWidth / entity.getMaxHealth());
		if (currentHealthWidth < 0)
			currentHealthWidth = 0;
		sb.end();

		shapeRenderer.setProjectionMatrix(sb.getProjectionMatrix());
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(renderX, renderY, healthBarWidth, healthBarHeight);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(renderX, renderY, currentHealthWidth, healthBarHeight);
		shapeRenderer.end();

		sb.begin();
	}
}
