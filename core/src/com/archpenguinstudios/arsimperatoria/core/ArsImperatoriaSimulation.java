package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatSimulator;
import com.archpenguinstudios.arsimperatoria.core.entity.GameEntityModel;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementSimulator;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;

public class ArsImperatoriaSimulation {

    private final GameSimulator gameSimulator;
    private final GameController gameController;

    private ArsImperatoriaSimulation(GameSimulator gameSimulator, GameController gameController) {
        this.gameSimulator = gameSimulator;
        this.gameController = gameController;
    }

    public static ArsImperatoriaSimulation createArsImperatoriaSimulation() {
        GameWorldModel gameWorldModel = new GameWorldModel();

        GameEntityModel gameEntityModel = new GameEntityModel();
        CombatSimulator combatSimulator = new CombatSimulator(gameWorldModel);
        MovementSimulator movementSimulator = new MovementSimulator(gameWorldModel);

        GameSimulator gameSimulator = new GameSimulator(gameEntityModel, combatSimulator, movementSimulator);

        GameController gameController = new GameController(gameEntityModel);

        return new ArsImperatoriaSimulation(gameSimulator, gameController);
    }

    public void step(float delta) {
        gameSimulator.step(delta);
    }

    public GameController getController() {
        return gameController;
    }
}
