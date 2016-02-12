package com.archpenguinstudios.arsimperatoria.core.movement;

import com.archpenguinstudios.arsimperatoria.core.util.VectorMath;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldModel;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class MovementController {

    private final GameWorldModel gameWorldModel;

    public MovementController(GameWorldModel gameWorldModel) {
        this.gameWorldModel = gameWorldModel;
    }

    public void resolveMovement(Iterable<MobileEntity> mobileEntities, float delta) {
        for (MobileEntity mobileEntity : mobileEntities) {
            switch (mobileEntity.getMovementActivity()) {
                case FOLLOW_TARGET:
                case MOVE_TO_LOCATION:
                    Vector2 destination = mobileEntity.getTargetDestination();
                    moveMobileEntityTowardsDestination(delta, mobileEntity, destination);
                    break;
                case NONE:
                default:
                    break;
            }
        }
    }

    private void moveMobileEntityTowardsDestination(float delta, MobileEntity mobileEntity, Vector2 destination) {
        Vector2 start = mobileEntity.getPosition();
        List<Vector2> path = gameWorldModel.findWaypointsBetweenPositions(start, destination);

        Vector2 movement = VectorMath.sub(path.get(0), start);
        float movementLength = Math.min(mobileEntity.getMovementSpeed() * delta, movement.len());
        movement.setLength(movementLength);

        mobileEntity.move(movement);
    }
}
