package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Random;

/**
 * Created by Mark on 24.10.2016.
 */
public class Beach extends Object{
    public final int sizei = 3, sizej = 5; //number of block water
    private float mas[][] = new float[sizei][sizej];//water y offset
    private boolean vec[][] = new boolean[sizei][sizej];//water y offset direction //true - up, false - down
    private float size = 5;//size of block water
    private float offsetx = -(size * (sizej-0.5f)), offsetz = -(size * (sizei-2));
    private float beachOffsetx = (-size * (sizej) / 2), beachOffsetz =  size * (sizei - 0.5f);
    private Random rnd = new Random();

    public float x = 10, z = 0;
    public Beach(){
        createBeach();
    }

    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1, int x2, int y1, int y2, int dx, int dy) {
        beachUpdata();
    }

    void createBeach(){
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/beach.jpg"));
        material = new Material(textureAttribute);
        modelBuilder = new ModelBuilder();
        model = BaseModel.Box(size * sizej, 0.3f, size * sizei, material);
        leftBeach = new ModelInstance(model);
        leftBeach.transform.setToTranslation(beachOffsetx, 1.0f, beachOffsetz);
        leftBeach.transform.rotate(1, 0, 0, -10);
        rightBeach = new ModelInstance(model);
        rightBeach.transform.setToTranslation(beachOffsetx, 1.0f,  -beachOffsetz);
        rightBeach.transform.rotate(1, 0, 0, 10);
    }

    void beachUpdata(){
        leftBeach.transform.setToTranslation(beachOffsetx + x, 1.0f, beachOffsetz + z);
        leftBeach.transform.rotate(1, 0, 0, -10);
        rightBeach.transform.setToTranslation(beachOffsetx + x, 1.0f, -beachOffsetz + z);
        rightBeach.transform.rotate(1, 0, 0, 10);
    }
}
