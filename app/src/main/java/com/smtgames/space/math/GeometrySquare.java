package com.smtgames.space.math;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class GeometrySquare {
    public FloatBuffer vertexBuffer;
    public FloatBuffer textureBuffer;
    public ShortBuffer indexBuffer;

    public final int COORDS_PER_VERTEX = 3;

    public float texture[] = {
            0.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 1.0f,
            1.0f, 0.0f,
    };

    public short indices[] = {0, 1, 2, 1, 3, 2};

    public GeometrySquare(float[] verticies) {
        ByteBuffer bb = ByteBuffer.allocateDirect(verticies.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(verticies);
        vertexBuffer.position(0);

        bb = ByteBuffer.allocateDirect(texture.length * 4);
        bb.order(ByteOrder.nativeOrder());
        textureBuffer = bb.asFloatBuffer();
        textureBuffer.put(texture);
        textureBuffer.position(0);

        bb = ByteBuffer.allocateDirect(indices.length * 2);
        bb.order(ByteOrder.nativeOrder());
        indexBuffer = bb.asShortBuffer();
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }
}
