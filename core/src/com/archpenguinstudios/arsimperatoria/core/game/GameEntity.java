package com.archpenguinstudios.arsimperatoria.core.game;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;

public interface GameEntity extends GameWorldEntity {

    MovementComponent getMovementComponent();

    CombatComponent getCombatComponent();
}
