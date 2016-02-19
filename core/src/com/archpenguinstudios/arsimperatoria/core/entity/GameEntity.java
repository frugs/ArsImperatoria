package com.archpenguinstudios.arsimperatoria.core.entity;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;

import java.util.Set;

public interface GameEntity extends GameWorldEntity {

    Set<ComponentType> getSupportedComponents();

    MovementComponent getMovementComponent();

    CombatComponent getCombatComponent();
}
