package com.archpenguinstudios.arsimperatoria.core.game;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;

import java.util.*;

public class GameEntityModel {

    private final Map<GameEntity, Set<ComponentType>> gameEntityIndex = new HashMap<GameEntity, Set<ComponentType>>();
    private final Map<ComponentType, Set<GameEntity>> componentTypeIndex;

    public GameEntityModel() {
        this.componentTypeIndex = new HashMap<ComponentType, Set<GameEntity>>();
        for (ComponentType componentType : ComponentType.values()) {
            componentTypeIndex.put(componentType, new HashSet<GameEntity>());
        }
    }

    public List<GameEntity> getGameEntities() {
        return new ArrayList<GameEntity>(gameEntityIndex.keySet());
    }

    public List<GameEntity> getGameEntitiesWithComponent(ComponentType componentType) {
        return new ArrayList<GameEntity>(componentTypeIndex.get(componentType));
    }

    public Set<ComponentType> getComponentsSupportedByGameEntity(GameEntity gameEntity) {
        return gameEntityIndex.get(gameEntity);
    }

    public void addGameEntity(GameEntity gameEntity, Set<ComponentType> componentTypes) {
        for (ComponentType componentType : componentTypes) {
            componentTypeIndex.get(componentType).add(gameEntity);
        }

        gameEntityIndex.put(gameEntity, componentTypes);
    }

    public void removeGameEntity(GameEntity gameEntity) {
        for (ComponentType componentType : ComponentType.values()) {
            componentTypeIndex.get(componentType).remove(gameEntity);
        }

        gameEntityIndex.remove(gameEntity);
    }
}
