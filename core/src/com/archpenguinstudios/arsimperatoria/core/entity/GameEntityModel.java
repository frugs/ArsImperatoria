package com.archpenguinstudios.arsimperatoria.core.entity;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public class GameEntityModel {

    private final List<GameEntity> gameEntities = new ArrayList<GameEntity>();

    public List<GameEntity> getGameEntities() {
        return ImmutableList.copyOf(gameEntities);
    }

    public List<GameEntity> getGameEntitiesWithComponent(final ComponentType componentType) {
        return ImmutableList.copyOf(Iterables.filter(gameEntities, new Predicate<GameEntity>() {
            @Override
            public boolean apply(GameEntity gameEntity) {
                return gameEntity.getSupportedComponents().contains(componentType);
            }
        }));
    }

    public void addGameEntity(GameEntity gameEntity) {
        gameEntities.add(gameEntity);
    }

    public void removeGameEntity(GameEntity gameEntity) {
        gameEntities.remove(gameEntity);
    }
}
