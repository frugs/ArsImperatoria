package com.archpenguinstudios.arsimperatoria;

import com.archpenguinstudios.arsimperatoria.core.game.GameController;
import com.archpenguinstudios.arsimperatoria.core.game.GameSimulator;
import com.archpenguinstudios.arsimperatoria.core.game.GameEntityModel;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;
import com.archpenguinstudios.arsimperatoria.core.combat.CombatSimulator;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementSimulator;
import com.archpenguinstudios.arsimperatoria.input.GameInputProcessor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ArsImperatoriaGame extends ApplicationAdapter {

	private static final float FRAME_RATE_CAP = 1f / 60f;

	private SpriteBatch batch;
	private Texture img;
    private GameSimulator gameSimulator;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		GameWorldModel gameWorldModel = new GameWorldModel();

        GameEntityModel gameEntityModel = new GameEntityModel();
        CombatSimulator combatSimulator = new CombatSimulator(gameWorldModel);
        MovementSimulator movementSimulator = new MovementSimulator(gameWorldModel);

        gameSimulator = new GameSimulator(gameEntityModel, combatSimulator, movementSimulator);

        GameController gameController = new GameController(gameEntityModel);

		gameController.introduceUnit(new Vector2(1f, 1f), 3f, 0.5f);
        gameController.introduceUnit(new Vector2(0f, 0f), 2f, 0.5f);

        Gdx.input.setInputProcessor(new GameInputProcessor());
	}

	@Override
	public void render () {
        float delta = Math.min(Gdx.graphics.getDeltaTime(), FRAME_RATE_CAP);
        gameSimulator.step(delta);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
