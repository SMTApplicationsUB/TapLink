package com.smtgames.space.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MainSurfaceView extends GLSurfaceView {
    private final MainRenderer renderer;
    private static AssetManager am;
    private MainThread mainThread;
    private Game game;

    synchronized void stop() {
        boolean retry = true;
        while (retry) {
            try {
                mainThread.setRunning(false);
                mainThread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            retry = false;
        }
    }

    public MainSurfaceView(Context context) {
        super(context);
        am = context.getAssets();

        setEGLContextClientVersion(2);
        renderer = new MainRenderer(this);
        setRenderer(renderer);
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        game = new Game(context);
    }

    public void update() {
        game.update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        renderer.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        renderer.onResume();
    }

    public Game getGame() {
        return game;
    }

    public static AssetManager getAssetManager() {
        return am;
    }
}
