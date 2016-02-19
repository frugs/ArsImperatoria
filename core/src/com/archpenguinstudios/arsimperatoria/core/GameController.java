package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.entity.GameEntity;
import com.archpenguinstudios.arsimperatoria.core.entity.GameEntityModel;
import com.archpenguinstudios.arsimperatoria.core.entity.unit.Unit;
import com.badlogic.gdx.math.Vector2;

public class GameController {

    private final GameEntityModel gameEntityModel;

    public GameController(GameEntityModel gameEntityModel) {
        this.gameEntityModel = gameEntityModel;
    }

    public GameEntity introduceUnit(Vector2 position, float movementSpeed, float attackRange) {
        GameEntity unit = new Unit(position, movementSpeed, attackRange);
        gameEntityModel.addGameEntity(unit);

        // TODO: Register listener to remove upon destruction

        return unit;
    }
}
