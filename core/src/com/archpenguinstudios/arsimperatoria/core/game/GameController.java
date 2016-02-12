package com.archpenguinstudios.arsimperatoria.core.game;

import com.archpenguinstudios.arsimperatoria.core.game.unit.Unit;
import com.badlogic.gdx.math.Vector2;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameController {

    private final GameEntityModel gameEntityModel;

    public GameController(GameEntityModel gameEntityModel) {
        this.gameEntityModel = gameEntityModel;
    }

    public GameEntity introduceUnit(Vector2 position, float movementSpeed, float attackRange) {
        GameEntity unit = new Unit(position, movementSpeed, attackRange);
        gameEntityModel.addGameEntity(unit, ImmutableSet.of(ComponentType.COMBAT, ComponentType.MOVEMENT));

        // TODO: Register listener to remove upon destruction

        return unit;
    }
}
