package com.archpenguinstudios.arsimperatoria.core.entity.unit;

import com.archpenguinstudios.arsimperatoria.core.movement.MovementActivity;
import com.archpenguinstudios.arsimperatoria.core.movement.MovementComponent;
import com.archpenguinstudios.arsimperatoria.core.util.VectorMath;
import com.archpenguinstudios.arsimperatoria.core.world.GameWorldEntity;
import com.badlogic.gdx.math.Vector2;

class StandardMovementComponent implements MovementComponent {

    private final GameWorldEntity owner;

    private MovementActivity movementActivity = MovementActivity.NONE;
    private Vector2 destinationLocation = new Vector2();
    private float movementSpeed;

    public StandardMovementComponent(GameWorldEntity owner, float movementSpeed) {
        this.owner = owner;
        this.movementSpeed = movementSpeed;
    }

    @Override
    public GameWorldEntity getOwner() {
        return owner;
    }

    @Override
    public MovementActivity getMovementActivity() {
        return movementActivity;
    }

    @Override
    public Vector2 getTargetDestination() {
        return destinationLocation;
    }

    @Override
    public float getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public void move(Vector2 movement) {
        getOwner().setPosition(VectorMath.add(getOwner().getPosition(), movement));
    }
}
