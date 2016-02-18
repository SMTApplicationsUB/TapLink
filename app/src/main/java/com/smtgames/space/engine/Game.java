package com.smtgames.space.engine;

import android.content.Context;

import com.smtgames.space.gfx.ImageManager;
import com.smtgames.space.objects.Block;
import com.smtgames.space.objects.Earth;
import com.smtgames.space.objects.GameObject;
import com.smtgames.space.objects.Space;

import java.util.ArrayList;

public class Game {
    private ImageManager im;

    private ArrayList<GameObject> objects = new ArrayList<>();

    private Context context;

    private Space space;
    private Earth earth;

    public Game(Context context) {
        this.context = context;
    }

    public void init() {
        im = new ImageManager(context);

        objects.add(space = new Space(im));
        objects.add(earth = new Earth(im, this));
    }

    public void update() {
        for (GameObject object : objects) {
            object.update();
        }
    }

    public void draw(float[] mvpMatrix) {
        for (GameObject object : objects) {
            object.draw(mvpMatrix);
        }
    }

    public ImageManager getIm() {
        return im;
    }

    public Space getSpace() {
        return space;
    }

    public Earth getEarth() {
        return earth;
    }
}
