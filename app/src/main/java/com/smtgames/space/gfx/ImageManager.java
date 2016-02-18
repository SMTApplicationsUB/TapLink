package com.smtgames.space.gfx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

public class ImageManager {

    public int texAsteroid, texEarth, texMars, texMercury, texMoon, texSatellite, texSettingsIcon, texSettingsIconPressed, texSpace, texSun, texVenus;

    private Context context;

    public ImageManager(Context context) {
        this.context = context;
        texAsteroid = loadTexture(R.drawable.asteroid);
        texEarth = loadTexture(R.drawable.earth);
        texMars = loadTexture(R.drawable.mars);
        texMercury = loadTexture(R.drawable.mercury);
        texMoon = loadTexture(R.drawable.moon);
        texSatellite = loadTexture(R.drawable.satellite);
        texSettingsIcon = loadTexture(R.drawable.settingsicon);
        texSettingsIconPressed = loadTexture(R.drawable.settingsiconpressed);
        texSpace = loadTexture(R.drawable.space);
        texSun = loadTexture(R.drawable.sun);
        texVenus = loadTexture(R.drawable.venus);
    }

    private int loadTexture(int srcId) {
        final int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;

        final Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), srcId, options);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[0]);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);

        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();

        return textures[0];
    }
}
