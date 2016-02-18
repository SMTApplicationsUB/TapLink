package com.smtgames.space.objects;

import com.smtgames.space.engine.Game;
import com.smtgames.space.math.GeometrySquare;
import com.smtgames.space.gfx.ImageManager;
import com.smtgames.space.gfx.Shader;
import com.smtgames.space.math.Vector3f;

public abstract class GameObject {

    protected Vector3f vector;
    protected int shaderProgram;

    protected Shader shader;
    protected ImageManager im;
    protected Game game;
    protected GeometrySquare gs;

    public GameObject(Game game) {
        this.game = game;
        im = game.getIm();
    }

    public abstract void update();
    public abstract void draw(float[] mvpMatrix);
}
