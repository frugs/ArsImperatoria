package com.archpenguinstudios.arsimperatoria.core.combat;

import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;

public class CombatController {

    private final GameWorldModel gameWorldModel;

    public CombatController(GameWorldModel gameWorldModel) {
        this.gameWorldModel = gameWorldModel;
    }

    public void resolveCombat(Iterable<Combatant> combatants) {
        for (Combatant combatant : combatants) {
            Combatant target = combatant.getCombatTarget();

            switch (combatant.getCombatActivity()) {
                case ATTACK_TARGET:
                    if (isValidCombatScenario(combatant, target)) {
                        combatant.attack();
                        target.takeDamage();
                    }
                    break;
                case FIRE_PROJECTILE_AT_TARGET:
                    if (isValidCombatScenario(combatant, target)) {
                        // TODO: Create and initialise projectile
                        combatant.attack();
                    }
                    break;
                case NONE:
                default:
            }
        }
    }

    // Checks whether combat can actually occur between the attacker and his target e.g. by confirming that the attacker
    // is in a state to perform his desired combat action, and that the target is within range.
    private boolean isValidCombatScenario(Combatant attacker, Combatant target) {
        return attacker.canPerformCombatAction()
                && attacker.attackRange() > gameWorldModel.euclideanDistance(attacker, target);
    }
}
