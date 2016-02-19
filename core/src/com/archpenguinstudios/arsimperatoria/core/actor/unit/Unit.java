package com.archpenguinstudios.arsimperatoria.core.actor.unit;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.actor.ComponentType;
import com.archpenguinstudios.arsimperatoria.core.actor.Actor;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.world.WorldEntity;
import com.archpenguinstudios.arsimperatoria.core.world.WorldEntityId;
import com.badlogic.gdx.math.Vector2;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Unit implements Actor {

    private static final ImmutableSet<ComponentType> SUPPORTED_COMPONENTS =
            ImmutableSet.of(ComponentType.COMBAT, ComponentType.MOVEMENT);

    private final WorldEntityId id;

    private final MovementComponent movementComponent;
    private final CombatComponent combatComponent;

    private Vector2 position = new Vector2();

    public Unit(WorldEntityId id, Vector2 position, float movementSpeed, float attackRange) {
        this.id = id;
        this.position.set(position);
        this.movementComponent = new StandardMovementComponent(this, movementSpeed);
        this.combatComponent = new StandardCombatComponent(this, attackRange);
    }

    @Override
    public Set<ComponentType> getSupportedComponents() {
        return SUPPORTED_COMPONENTS;
    }

    @Override
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    @Override
    public CombatComponent getCombatComponent() {
        return combatComponent;
    }

    @Override
    public WorldEntityId getId() {
        return id;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vector2 newPos) {
        position.set(newPos);
    }
}
