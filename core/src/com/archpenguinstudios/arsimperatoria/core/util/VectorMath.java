package com.archpenguinstudios.arsimperatoria.core.util;

import com.badlogic.gdx.math.Vector2;

public class VectorMath {

    private VectorMath() {}

    public static Vector2 sub(Vector2 v1, Vector2 v2) {
        return v1.cpy().sub(v2);
    }
}
