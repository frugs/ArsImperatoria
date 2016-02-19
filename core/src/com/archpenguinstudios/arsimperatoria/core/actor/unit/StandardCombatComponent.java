package com.archpenguinstudios.arsimperatoria.core.actor.unit;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatActivity;
import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.combat.PlaceholderCombatComponents;
import com.archpenguinstudios.arsimperatoria.core.actor.Actor;
import com.archpenguinstudios.arsimperatoria.core.world.WorldEntity;

class StandardCombatComponent implements CombatComponent {

    private final WorldEntity owner;
    private final float attackRange;

    public StandardCombatComponent(Actor owner, float attackRange) {
        this.owner = owner;
        this.attackRange = attackRange;
    }

    @Override
    public WorldEntity getOwner() {
        return owner;
    }

    @Override
    public CombatActivity getCombatActivity() {
        return CombatActivity.NONE;
    }

    @Override
    public boolean canPerformCombatAction() {
        return false;
    }

    @Override
    public CombatComponent getCombatTarget() {
        return PlaceholderCombatComponents.nullCombatComponent();
    }

    @Override
    public float attackRange() {
        return attackRange;
    }

    @Override
    public void attack() {}

    @Override
    public void takeDamage() {}
}
