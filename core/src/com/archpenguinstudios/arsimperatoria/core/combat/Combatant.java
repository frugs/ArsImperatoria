package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;

public interface Combatant extends GameWorldEntity {
    CombatActivity getCombatActivity();

    boolean canPerformCombatAction();

    Combatant getCombatTarget();

    float attackRange();

    void attack();

    void takeDamage();
}
