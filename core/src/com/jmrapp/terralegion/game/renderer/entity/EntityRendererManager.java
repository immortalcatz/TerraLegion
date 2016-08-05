package com.jmrapp.terralegion.game.renderer.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jmrapp.terralegion.engine.views.drawables.AnimationDrawable;
import com.jmrapp.terralegion.engine.views.drawables.ResourceManager;
import com.jmrapp.terralegion.engine.views.drawables.SpriteSheet;
import com.jmrapp.terralegion.engine.views.drawables.TexturedDrawable;
import com.jmrapp.terralegion.engine.world.entity.WorldBody;
import com.jmrapp.terralegion.game.world.entity.Drop;
import com.jmrapp.terralegion.game.world.entity.impl.Bunny;
import com.jmrapp.terralegion.game.world.entity.impl.Player;

import java.util.HashMap;

public class EntityRendererManager {

	private static final HashMap<Class<? extends WorldBody>, EntityRenderer> renderers = new HashMap<Class<? extends WorldBody>, EntityRenderer>();

	static {
		renderers.put(Drop.class, new DropRenderer());
		renderers.put(Bunny.class, new LivingEntityRenderer(new TexturedDrawable(ResourceManager.getInstance().getTexture("bunny"))));
		renderers.put(Player.class, new LivingEntityRenderer(new AnimationDrawable(new SpriteSheet(ResourceManager.getInstance().getTexture("playerAnimated"), 32, 36, 4, 4))));
	}

	public static void render(WorldBody entity, SpriteBatch sb, double lightValue) {
		EntityRenderer renderer = renderers.get(entity.getClass());
		renderer.render(entity, sb, lightValue);
	}
}
