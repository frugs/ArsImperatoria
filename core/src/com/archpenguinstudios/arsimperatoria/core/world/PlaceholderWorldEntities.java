package com.archpenguinstudios.arsimperatoria.core.world;

import com.badlogic.gdx.math.Vector2;

public class PlaceholderWorldEntities {

    private static final Vector2 FAR_FAR_AWAY = new Vector2(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    private static final WorldEntity NULL_WORLD_ENTITY = new NullWorldEntity();

    private PlaceholderWorldEntities() {}

    public static WorldEntity nullWorldEntity() {
        return NULL_WORLD_ENTITY;
    }

    private static class NullWorldEntity implements WorldEntity {

        @Override
        public Vector2 getPosition() {
            return FAR_FAR_AWAY;
        }

        @Override
        public void setPosition(Vector2 newPos) {}
    }
}
