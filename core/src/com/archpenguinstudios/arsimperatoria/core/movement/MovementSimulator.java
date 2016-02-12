package com.archpenguinstudios.arsimperatoria.core.movement;

import com.archpenguinstudios.arsimperatoria.core.util.VectorMath;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class MovementSimulator {

    private final GameWorldModel gameWorldModel;

    public MovementSimulator(GameWorldModel gameWorldModel) {
        this.gameWorldModel = gameWorldModel;
    }

    public void resolveMovement(Iterable<MovementComponent> mobileEntities, float delta) {
        for (MovementComponent movementComponent : mobileEntities) {
            switch (movementComponent.getMovementActivity()) {
                case FOLLOW_TARGET:
                case MOVE_TO_LOCATION:
                    Vector2 destination = movementComponent.getTargetDestination();
                    moveMobileEntityTowardsDestination(delta, movementComponent, destination);
                    break;
                case NONE:
                default:
                    break;
            }
        }
    }

    private void moveMobileEntityTowardsDestination(float delta, MovementComponent movementComponent, Vector2 destination) {
        Vector2 start = movementComponent.getOwner().getPosition();
        List<Vector2> path = gameWorldModel.findWaypointsBetweenPositions(start, destination);

        Vector2 movement = VectorMath.sub(path.get(0), start);
        float movementLength = Math.min(movementComponent.getMovementSpeed() * delta, movement.len());
        movement.setLength(movementLength);

        movementComponent.move(movement);
    }
}
