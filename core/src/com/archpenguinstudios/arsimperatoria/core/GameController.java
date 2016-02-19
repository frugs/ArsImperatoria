package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.actor.Actor;
import com.archpenguinstudios.arsimperatoria.core.actor.ActorModel;
import com.archpenguinstudios.arsimperatoria.core.actor.unit.Unit;
import com.badlogic.gdx.math.Vector2;

public class GameController {

    private final ActorModel actorModel;

    public GameController(ActorModel actorModel) {
        this.actorModel = actorModel;
    }

    public Actor introduceUnit(Vector2 position, float movementSpeed, float attackRange) {
        Actor unit = new Unit(position, movementSpeed, attackRange);
        actorModel.addActor(unit);

        // TODO: Register listener to remove upon destruction

        return unit;
    }
}
