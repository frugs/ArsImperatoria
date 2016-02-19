package com.archpenguinstudios.arsimperatoria.core.world;

import com.badlogic.gdx.math.Vector2;

public interface WorldEntity {

    WorldEntityId getId();

    Vector2 getPosition();

    void setPosition(Vector2 newPos);
}
