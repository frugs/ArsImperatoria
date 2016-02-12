package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatController;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementController;

public class GameSimulator {

    private final GameEntityModel gameEntityModel;
    private final CombatController combatController;
    private final MovementController movementController;

    public GameSimulator(GameEntityModel gameEntityModel,
                         CombatController combatController,
                         MovementController movementController) {

        this.gameEntityModel = gameEntityModel;
        this.combatController = combatController;
        this.movementController = movementController;
    }

    public void step(float delta) {
        combatController.resolveCombat(gameEntityModel.getCombatants());
        movementController.resolveMovement(gameEntityModel.getMobileEntities(), delta);
    }
}
