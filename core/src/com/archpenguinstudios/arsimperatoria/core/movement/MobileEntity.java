package com.archpenguinstudios.arsimperatoria.core.movement;

import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;
import com.badlogic.gdx.math.Vector2;

public interface MobileEntity extends GameWorldEntity {
    MovementActivity getMovementActivity();

    Vector2 getTargetDestination();

    float getMovementSpeed();

    void move(Vector2 movement);
}
