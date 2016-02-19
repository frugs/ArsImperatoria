package com.archpenguinstudios.arsimperatoria.core;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.combat.CombatSimulator;
import com.archpenguinstudios.arsimperatoria.core.actor.ComponentType;
import com.archpenguinstudios.arsimperatoria.core.actor.Actor;
import com.archpenguinstudios.arsimperatoria.core.actor.ActorModel;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementSimulator;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.List;

public class GameSimulator {

    public static final Function<Actor, MovementComponent> MAP_MOVEMENT_COMPONENT =
            new Function<Actor, MovementComponent>() {
                @Override
                public MovementComponent apply(Actor actor) {
                    return actor.getMovementComponent();
                }
            };

    public static final Function<Actor, CombatComponent> MAP_COMBAT_COMPONENT =
            new Function<Actor, CombatComponent>() {
                @Override
                public CombatComponent apply(Actor actor) {
                    return actor.getCombatComponent();
                }
            };


    private final ActorModel actorModel;
    private final CombatSimulator combatSimulator;
    private final MovementSimulator movementSimulator;

    public GameSimulator(ActorModel actorModel,
                         CombatSimulator combatSimulator,
                         MovementSimulator movementSimulator) {

        this.actorModel = actorModel;
        this.combatSimulator = combatSimulator;
        this.movementSimulator = movementSimulator;
    }

    public void step(float delta) {
        combatSimulator.simulateCombat(combatantCombatComponents());
        movementSimulator.resolveMovement(mobileEntityMovementComponents(), delta);
    }

    private Collection<MovementComponent> mobileEntityMovementComponents() {
        List<Actor> mobileEntities = actorModel.getGameEntitiesWithComponent(ComponentType.MOVEMENT);
        return Collections2.transform(mobileEntities, MAP_MOVEMENT_COMPONENT);
    }

    private Collection<CombatComponent> combatantCombatComponents() {
        List<Actor> combatants = actorModel.getGameEntitiesWithComponent(ComponentType.MOVEMENT);
        return Collections2.transform(combatants, MAP_COMBAT_COMPONENT);
    }
}
