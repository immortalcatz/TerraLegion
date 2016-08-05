package com.jmrapp.terralegion.game.renderer.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jmrapp.terralegion.game.utils.LightUtils;
import com.jmrapp.terralegion.game.world.entity.Drop;

public class DropRenderer extends EntityRenderer<Drop> {
	@Override
	public void render(Drop drop, SpriteBatch sb, double lightValue) {
		float value = (float) (lightValue < LightUtils.MIN_LIGHT_VALUE ? LightUtils.MIN_LIGHT_VALUE : lightValue);
		sb.setColor(value, value, value, 1);
		com.jmrapp.terralegion.game.renderer.ItemIconManager.getIcon(drop.getItem()).render(sb, drop.getX(), drop.getY());
		sb.setColor(Color.WHITE);
	}
}
