package com.smtgames.space.engine;

public class MainThread extends Thread {
    private final int UPS = 60;
    public boolean running;
    private MainSurfaceView mGLView;

    public MainThread(MainSurfaceView mGLView) {
        super();
        this.mGLView = mGLView;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / UPS;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                mGLView.update();
                delta--;
            }
        }
    }

    public void onPause() {
        //TODO: This Pause
    }

    public void onResume() {
        //TODO: This Resume
    }

    public void setRunning(boolean b) {
        running = b;
    }
}
