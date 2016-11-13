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
public class Water extends Object {
    float width = 100, height = 15;
    float x = 5, y = 0;
    public Water()
    {
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/Green24.png"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        instance = new ModelInstance(model);
        //instance.transform.setToTranslation(x,0,y);
        //instance.transform.rotate(0, 0, 1, 180);
    }

    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1, int x2, int y1, int y2, int dx, int dy) {
        waterUpdata();
    }
    public void waterUpdata(){
        instance.transform.setToTranslation(x,0,y);
        instance.transform.rotate(0, 0, 1, 180);
    }

}
