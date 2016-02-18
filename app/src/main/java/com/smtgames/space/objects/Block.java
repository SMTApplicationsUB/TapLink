package com.smtgames.space.objects;

import android.opengl.GLES20;

import com.smtgames.space.math.GeometrySquare;
import com.smtgames.space.gfx.Shader;

public class Block {

    private int shaderProgram;

    static final int COORDS_PER_VERTEX = 3;

    private float color[] = new float[] {0.0f, 0.3f, 0.7f, 1.0f};

    private Shader shader;
    private GeometrySquare gs;

    public Block() {
        gs = new GeometrySquare();
        shader = new Shader("shader/block.vert", "shader/block.frag");
        shaderProgram = shader.getShaderProgram();
    }

    public void draw(float[] mvpMatrix) {
        GLES20.glUseProgram(shaderProgram);

        int positionLoc = GLES20.glGetAttribLocation(shaderProgram, "vPosition");
        int colorLoc = GLES20.glGetUniformLocation(shaderProgram, "vColor");
        int mMVPMatrixHandle = GLES20.glGetUniformLocation(shaderProgram, "uMVPMatrix");


        GLES20.glEnableVertexAttribArray(positionLoc);

        GLES20.glVertexAttribPointer(positionLoc, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, gs.vertexBuffer);

        GLES20.glUniform4fv(colorLoc, 1, color, 0);

        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

        GLES20.glDrawElements(GLES20.GL_TRIANGLES, gs.indices.length, GLES20.GL_UNSIGNED_SHORT, gs.indexBuffer);
        GLES20.glDisableVertexAttribArray(positionLoc);
    }
}
