package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;

public interface CombatComponent {

    GameWorldEntity getOwner();

    CombatActivity getCombatActivity();

    boolean canPerformCombatAction();

    CombatComponent getCombatTarget();

    float attackRange();

    void attack();

    void takeDamage();
}
