package com.archpenguinstudios.arsimperatoria.core.game.unit;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.game.GameEntity;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.badlogic.gdx.math.Vector2;

public class Unit implements GameEntity {

    private final MovementComponent movementComponent;
    private final CombatComponent combatComponent;

    private Vector2 position = new Vector2();

    public Unit(Vector2 position, float movementSpeed, float attackRange) {
        this.position.set(position);
        this.movementComponent = new StandardMovementComponent(this, movementSpeed);
        this.combatComponent = new StandardCombatComponent(this, attackRange);
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
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vector2 newPos) {
        position.set(newPos);
    }
}
