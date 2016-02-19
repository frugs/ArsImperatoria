package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatSimulator;
import com.archpenguinstudios.arsimperatoria.core.actor.ActorModel;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementSimulator;
import com.archpenguinstudios.arsimperatoria.core.world.WorldModel;

public class ArsImperatoriaSimulation {

    private final GameSimulator gameSimulator;
    private final GameController gameController;

    private ArsImperatoriaSimulation(GameSimulator gameSimulator, GameController gameController) {
        this.gameSimulator = gameSimulator;
        this.gameController = gameController;
    }

    public static ArsImperatoriaSimulation createArsImperatoriaSimulation() {
        WorldModel worldModel = new WorldModel();

        ActorModel actorModel = new ActorModel();
        CombatSimulator combatSimulator = new CombatSimulator(worldModel);
        MovementSimulator movementSimulator = new MovementSimulator(worldModel);

        GameSimulator gameSimulator = new GameSimulator(actorModel, combatSimulator, movementSimulator);

        GameController gameController = new GameController(actorModel);

        return new ArsImperatoriaSimulation(gameSimulator, gameController);
    }

    public void step(float delta) {
        gameSimulator.step(delta);
    }

    public GameController getController() {
        return gameController;
    }
}
