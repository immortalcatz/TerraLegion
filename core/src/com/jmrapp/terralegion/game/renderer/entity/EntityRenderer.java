package com.jmrapp.terralegion.game.renderer.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jmrapp.terralegion.engine.world.entity.WorldBody;

public abstract class EntityRenderer<T extends WorldBody> {
	public abstract void render(T entity, SpriteBatch sb, double lightValue);
}
