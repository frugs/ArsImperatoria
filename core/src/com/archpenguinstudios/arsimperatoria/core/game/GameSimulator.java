package com.archpenguinstudios.arsimperatoria.core.game;

import com.archpenguinstudios.arsimperatoria.core.combat.CombatComponent;
import com.archpenguinstudios.arsimperatoria.core.combat.CombatSimulator;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementSimulator;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.List;

public class GameSimulator {

    public static final Function<GameEntity, MovementComponent> MAP_MOVEMENT_COMPONENT =
            new Function<GameEntity, MovementComponent>() {
                @Override
                public MovementComponent apply(GameEntity gameEntity) {
                    return gameEntity.getMovementComponent();
                }
            };

    public static final Function<GameEntity, CombatComponent> MAP_COMBAT_COMPONENT =
            new Function<GameEntity, CombatComponent>() {
                @Override
                public CombatComponent apply(GameEntity gameEntity) {
                    return gameEntity.getCombatComponent();
                }
            };


    private final GameEntityModel gameEntityModel;
    private final CombatSimulator combatSimulator;
    private final MovementSimulator movementSimulator;

    public GameSimulator(GameEntityModel gameEntityModel,
                         CombatSimulator combatSimulator,
                         MovementSimulator movementSimulator) {

        this.gameEntityModel = gameEntityModel;
        this.combatSimulator = combatSimulator;
        this.movementSimulator = movementSimulator;
    }

    public void step(float delta) {
        combatSimulator.simulateCombat(combatantCombatComponents());
        movementSimulator.resolveMovement(mobileEntityMovementComponents(), delta);
    }

    private Collection<MovementComponent> mobileEntityMovementComponents() {
        List<GameEntity> mobileEntities = gameEntityModel.getGameEntitiesWithComponent(ComponentType.MOVEMENT);
        return Collections2.transform(mobileEntities, MAP_MOVEMENT_COMPONENT);
    }

    private Collection<CombatComponent> combatantCombatComponents() {
        List<GameEntity> combatants = gameEntityModel.getGameEntitiesWithComponent(ComponentType.MOVEMENT);
        return Collections2.transform(combatants, MAP_COMBAT_COMPONENT);
    }
}
