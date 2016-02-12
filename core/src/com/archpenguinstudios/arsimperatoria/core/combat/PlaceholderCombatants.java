package com.archpenguinstudios.arsimperatoria.core.combat;

import com.badlogic.gdx.math.Vector2;

public class PlaceholderCombatants {

    private static final Combatant NULL_COMBATANT = new NullCombatant();

    public static Combatant nullCombatant() {
        return NULL_COMBATANT;
    }

    private PlaceholderCombatants() {}

    private static class NullCombatant implements Combatant {
        @Override
        public CombatActivity getCombatActivity() {
            return CombatActivity.NONE;
        }

        @Override
        public boolean canPerformCombatAction() {
            return false;
        }

        @Override
        public Combatant getCombatTarget() {
            return this;
        }

        @Override
        public float attackRange() {
            return 0;
        }

        @Override
        public void attack() {
        }

        @Override
        public void takeDamage() {
        }

        @Override
        public Vector2 getPosition() {
            return Vector2.Zero;
        }
    }
}