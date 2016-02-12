package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;
import com.archpenguinstudios.arsimperatoria.core.world.PlaceholderGameWorldEntities;

public class PlaceholderCombatComponents {

    private static final CombatComponent NULL_COMBAT_COMPONENT = new NullCombatComponent();

    public static CombatComponent nullCombatComponent() {
        return NULL_COMBAT_COMPONENT;
    }

    private PlaceholderCombatComponents() {}

    private static class NullCombatComponent implements CombatComponent {
        @Override
        public GameWorldEntity getOwner() {
            return PlaceholderGameWorldEntities.nullGameWorldEntity();
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
            return this;
        }

        @Override
        public float attackRange() {
            return 0;
        }

        @Override
        public void attack() {}

        @Override
        public void takeDamage() {}
    }
}