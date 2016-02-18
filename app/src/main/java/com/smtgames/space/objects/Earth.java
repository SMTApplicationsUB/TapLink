package com.smtgames.space.objects;

import android.opengl.GLES20;

import com.smtgames.space.engine.Game;
import com.smtgames.space.gfx.*;

public class Earth extends GameObject {

    private Game game;

    public Earth(ImageManager im, Game game) {
        super(im);
        this.game = game;

        shader = new Shader("shader/standard.vert", "shader/standard.frag");
        shaderProgram = shader.getShaderProgram();
    }

    @Override
    public void update(){

    }

    @Override
    public void draw(float[] mvpMatrix) {
        GLES20.glUseProgram(shaderProgram);

        int positionLoc = GLES20.glGetAttribLocation(shaderProgram, "vPosition");
        int texCoordLoc = GLES20.glGetAttribLocation(shaderProgram, "aTexCoord");

        int samplerLoc = GLES20.glGetUniformLocation(shaderProgram, "sTexture");
        int mMVPMatrixHandle = GLES20.glGetUniformLocation(shaderProgram, "uMVPMatrix");

        //Texture Bind
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, im.texEarth);

        GLES20.glEnableVertexAttribArray(positionLoc);
        GLES20.glEnableVertexAttribArray(texCoordLoc);

        GLES20.glVertexAttribPointer(positionLoc, gs.COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, gs.vertexBuffer);
        GLES20.glVertexAttribPointer(texCoordLoc, 2, GLES20.GL_FLOAT, false, 0, gs.textureBuffer);

        GLES20.glUniform1i(samplerLoc, 0);

        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);

        GLES20.glDrawElements(GLES20.GL_TRIANGLES, gs.indices.length, GLES20.GL_UNSIGNED_SHORT, gs.indexBuffer);

        GLES20.glDisableVertexAttribArray(positionLoc);
        GLES20.glDisableVertexAttribArray(texCoordLoc);
    }
}
