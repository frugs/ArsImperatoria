package com.archpenguinstudios.arsimperatoria.core.unit;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatActivity;
import com.archpenguinstudios.arsimperatoria.core.combat.Combatant;
import com.archpenguinstudios.arsimperatoria.core.movement.MobileEntity;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementActivity;
import com.badlogic.gdx.math.Vector2;

import static com.archpenguinstudios.arsimperatoria.core.combat.PlaceholderCombatants.nullCombatant;

public class BasicSoldier implements Combatant, MobileEntity {

    private CombatActivity combatActivity = CombatActivity.NONE;
    private MovementActivity movementActivity = MovementActivity.NONE;
    private Vector2 position;

    public BasicSoldier(Vector2 position) {
        this.position = position;
    }

    @Override
    public CombatActivity getCombatActivity() {
        return combatActivity;
    }

    @Override
    public boolean canPerformCombatAction() {
        return true;
    }

    @Override
    public Combatant getCombatTarget() {
        return nullCombatant();
    }

    @Override
    public float attackRange() {
        return 0.5f;
    }

    @Override
    public void attack() {

    }

    @Override
    public void takeDamage() {

    }

    @Override
    public MovementActivity getMovementActivity() {
        return movementActivity;
    }

    @Override
    public Vector2 getTargetDestination() {
        return getPosition();
    }

    @Override
    public float getMovementSpeed() {
        return 0;
    }

    @Override
    public void move(Vector2 movement) {
        position.add(movement);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }
}
