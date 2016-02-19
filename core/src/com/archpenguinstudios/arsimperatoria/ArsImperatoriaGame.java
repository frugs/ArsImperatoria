package com.archpenguinstudios.arsimperatoria;

import com.archpenguinstudios.arsimperatoria.core.ArsImperatoriaSimulation;
import com.archpenguinstudios.arsimperatoria.core.GameController;
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
    private ArsImperatoriaSimulation simulation;

    @Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        simulation = ArsImperatoriaSimulation.createArsImperatoriaSimulation();

        GameController controller = simulation.getController();
        controller.introduceUnit(new Vector2(1f, 1f), 3f, 0.5f);
        controller.introduceUnit(new Vector2(0f, 0f), 2f, 0.5f);

        Gdx.input.setInputProcessor(new GameInputProcessor());
	}

	@Override
	public void render () {
        float delta = Math.min(Gdx.graphics.getDeltaTime(), FRAME_RATE_CAP);
        simulation.step(delta);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
