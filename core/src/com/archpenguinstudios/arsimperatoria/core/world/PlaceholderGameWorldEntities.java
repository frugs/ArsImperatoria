package com.archpenguinstudios.arsimperatoria.core.world;

import com.badlogic.gdx.math.Vector2;

public class PlaceholderGameWorldEntities {

    private static final Vector2 FAR_FAR_AWAY = new Vector2(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    private static final GameWorldEntity NULL_GAME_WORLD_ENTITY = new NullGameWorldEntity();

    private PlaceholderGameWorldEntities() {}

    public static GameWorldEntity nullGameWorldEntity() {
        return NULL_GAME_WORLD_ENTITY;
    }

    private static class NullGameWorldEntity implements GameWorldEntity {

        @Override
        public Vector2 getPosition() {
            return FAR_FAR_AWAY;
        }

        @Override
        public void setPosition(Vector2 newPos) {}
    }
}
