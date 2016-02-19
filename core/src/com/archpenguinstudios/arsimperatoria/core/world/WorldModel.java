package com.archpenguinstudios.arsimperatoria.core.world;

import com.badlogic.gdx.math.Vector2;

import java.util.Collections;
import java.util.List;

public class WorldModel {
    public float euclideanDistance(WorldEntity first, WorldEntity second) {
        return 0;
    }

    public List<Vector2> findWaypointsBetweenPositions(Vector2 position, Vector2 targetPosition) {
        return Collections.singletonList(targetPosition);
    }
}
