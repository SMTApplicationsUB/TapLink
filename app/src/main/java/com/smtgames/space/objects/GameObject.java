package com.smtgames.space.objects;

import com.smtgames.space.math.GeometrySquare;
import com.smtgames.space.gfx.ImageManager;
import com.smtgames.space.gfx.Shader;

public abstract class GameObject {
    
    protected int shaderProgram;
    protected Shader shader;
    protected ImageManager im;
    protected GeometrySquare gs;

    public GameObject(ImageManager im) {
        this.im = im;

        gs = new GeometrySquare();
    }

    public abstract void update();
    public abstract void draw(float[] mvpMatrix);
}
