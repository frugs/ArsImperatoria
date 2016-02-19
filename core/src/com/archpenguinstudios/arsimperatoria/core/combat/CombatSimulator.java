package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.WorldModel;

public class CombatSimulator {

    private final WorldModel worldModel;

    public CombatSimulator(WorldModel worldModel) {
        this.worldModel = worldModel;
    }

    public void simulateCombat(Iterable<CombatComponent> combatComponents) {
        for (CombatComponent combatComponent : combatComponents) {
            CombatComponent target = combatComponent.getCombatTarget();

            switch (combatComponent.getCombatActivity()) {
                case ATTACK_TARGET:
                    if (isValidCombatScenario(combatComponent, target)) {
                        combatComponent.attack();
                        target.takeDamage();
                    }
                    break;
                case FIRE_PROJECTILE_AT_TARGET:
                    if (isValidCombatScenario(combatComponent, target)) {
                        // TODO: Create and initialise projectile
                        combatComponent.attack();
                    }
                    break;
                case NONE:
                default:
                    break;
            }
        }
    }

    // Checks whether combat can actually occur between the attacker and his target e.g. by confirming that the attacker
    // is in a state to perform his desired combat action, and that the target is within range.
    private boolean isValidCombatScenario(CombatComponent attacker, CombatComponent target) {
        return attacker.canPerformCombatAction()
                && attacker.attackRange() > worldModel.euclideanDistance(attacker.getOwner(), target.getOwner() );
    }
}
