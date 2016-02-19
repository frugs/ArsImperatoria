package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.WorldEntity;

public interface CombatComponent {

    WorldEntity getOwner();

    CombatActivity getCombatActivity();

    boolean canPerformCombatAction();

    CombatComponent getCombatTarget();

    float attackRange();

    void attack();

    void takeDamage();
}
