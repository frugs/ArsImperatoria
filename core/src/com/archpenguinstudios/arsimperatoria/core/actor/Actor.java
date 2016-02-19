package com.archpenguinstudios.arsimperatoria.core.actor;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.world.WorldEntity;

import java.util.Set;

public interface Actor extends WorldEntity {

    Set<ComponentType> getSupportedComponents();

    MovementComponent getMovementComponent();

    CombatComponent getCombatComponent();
}
