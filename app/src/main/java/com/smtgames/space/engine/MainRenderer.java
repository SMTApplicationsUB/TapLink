package com.smtgames.space.engine;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainRenderer implements GLSurfaceView.Renderer {

    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];

    private MainSurfaceView mGLView;

    public static int width = 1080, height = 1920;
    public static float ratio = (float) width / height;

    public MainRenderer(MainSurfaceView mGLView) {
        this.mGLView = mGLView;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mGLView.getGame().init();

    }

    public void onDrawFrame(GL10 unused) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        Matrix.setLookAtM(mViewMatrix, 0, 0f, 0f, -3f, 0f, 0f, 0f, 0f, 1f, 0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        mGLView.getGame().draw(mMVPMatrix);

        //FPSCounter.logFrame();
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        this.width = width;
        this.height = height;

        ratio = (float) width / height;

        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
    }

    public void onPause() {
        //TODO: This Pause
    }

    public void onResume() {
        //TODO: This Resume
    }
}
