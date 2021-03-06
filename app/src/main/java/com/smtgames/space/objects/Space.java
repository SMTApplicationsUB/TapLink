package com.smtgames.space.objects;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.smtgames.space.engine.Game;
import com.smtgames.space.engine.MainRenderer;
import com.smtgames.space.math.GeometrySquare;
import com.smtgames.space.gfx.ImageManager;
import com.smtgames.space.gfx.Shader;
import com.smtgames.space.math.Vector3f;

public class Space extends GameObject {

    private float verticies[] = {
            -MainRenderer.ratio, -1.0f, 0.0f,
            -MainRenderer.ratio, 1.0f, 0.0f,
            MainRenderer.ratio, -1.0f, 0.0f,
            MainRenderer.ratio , 1.0f, 0.0f
    };

    public Space(Game game) {
        super(game);

        gs = new GeometrySquare(verticies);
        vector = new Vector3f(0.0f, 0.0f, 0.0f);

        shader = new Shader("shader/space.vert", "shader/space.frag");
        shaderProgram = shader.getShaderProgram();
    }

    @Override
    public void update(){

    }

    @Override
    public void draw(float[] mvpMatrix) {
        GLES20.glUseProgram(shaderProgram);

        //Attrib Location
        int positionLoc = GLES20.glGetAttribLocation(shaderProgram, "vPosition");
        int texCoordLoc = GLES20.glGetAttribLocation(shaderProgram, "aTexCoord");

        //Uniform Location
        int samplerLoc = GLES20.glGetUniformLocation(shaderProgram, "sTexture");
        int mMVPMatrixHandle = GLES20.glGetUniformLocation(shaderProgram, "uMVPMatrix");

        //Texture
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, im.texSpace);

        //Enable Vertex Array
        GLES20.glEnableVertexAttribArray(positionLoc);
        GLES20.glEnableVertexAttribArray(texCoordLoc);

        //Point Vertex Array
        GLES20.glVertexAttribPointer(positionLoc, gs.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, gs.vertexBuffer);
        GLES20.glVertexAttribPointer(texCoordLoc, 2, GLES20.GL_FLOAT, false, 0, gs.textureBuffer);

        //Set frag uniform
        GLES20.glUniform1i(samplerLoc, 0);

        //Matrix
        Matrix.translateM(mvpMatrix, 0, vector.getX(), vector.getY(), vector.getZ());
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

        //Draw
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, gs.indices.length, GLES20.GL_UNSIGNED_SHORT, gs.indexBuffer);

        //Disable Vertex Array
        GLES20.glDisableVertexAttribArray(positionLoc);
        GLES20.glDisableVertexAttribArray(texCoordLoc);
    }
}
