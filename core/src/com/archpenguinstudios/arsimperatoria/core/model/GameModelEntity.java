package com.archpenguinstudios.arsimperatoria.core.model;

import com.archpenguinstudios.arsimperatoria.core.world.WorldEntityId;
import com.badlogic.gdx.math.Vector2;

public interface GameModelEntity {

    WorldEntityId getId();

    Vector2 getPosition();
}
