package com.archpenguinstudios.arsimperatoria;

import com.archpenguinstudios.arsimperatoria.core.GameController;
import com.archpenguinstudios.arsimperatoria.core.GameSimulator;
import com.archpenguinstudios.arsimperatoria.core.GameEntityModel;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;
import com.archpenguinstudios.arsimperatoria.core.combat.CombatController;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementController;
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
        CombatController combatController = new CombatController(gameWorldModel);
        MovementController movementController = new MovementController(gameWorldModel);

        gameSimulator = new GameSimulator(gameEntityModel, combatController, movementController);

        GameController gameController = new GameController(gameEntityModel);

        gameController.introduceBasicSoldier(Vector2.Zero);
        gameController.introduceBasicSoldier(new Vector2(1f, 1f));

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
