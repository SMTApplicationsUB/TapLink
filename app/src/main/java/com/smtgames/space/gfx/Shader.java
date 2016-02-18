package com.smtgames.space.gfx;

import android.opengl.GLES20;

import com.smtgames.space.io.Loader;

public class Shader {

    private int shaderProgram;

    public Shader(String pathVertex, String pathFragment) {
        String vertexShaderCode = Loader.loadString(pathVertex);
        String fragmentShaderCode = Loader.loadString(pathFragment);

        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        shaderProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(shaderProgram, vertexShader);
        GLES20.glAttachShader(shaderProgram, fragmentShader);
        GLES20.glLinkProgram(shaderProgram);
    }

    public static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    public int getShaderProgram() {
        return shaderProgram;
    }
}
