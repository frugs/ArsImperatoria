package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.unit.BasicSoldier;
import com.badlogic.gdx.math.Vector2;

public class GameController {

    private final GameEntityModel gameEntityModel;

    public GameController(GameEntityModel gameEntityModel) {
        this.gameEntityModel = gameEntityModel;
    }

    public BasicSoldier introduceBasicSoldier(Vector2 position) {
        BasicSoldier basicSoldier = new BasicSoldier(position);
        gameEntityModel.addCombatant(basicSoldier);
        gameEntityModel.addMobileEntity(basicSoldier);

        // TODO: Add listener to unregister on death

        return basicSoldier;
    }
}
