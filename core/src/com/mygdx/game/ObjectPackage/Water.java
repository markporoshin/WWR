package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.mygdx.game.*;

public class Water extends Object {
    float width, height;

    public Water(){
        width = ObjectHelper.Wwidth + 0.1f;
        height = ObjectHelper.Wheight;
        x = 5;
        y = 0;
        z = 0;
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/water2.png"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        up();
        modelArr.get(0).transform.setToTranslation(x,z,y);
        modelArr.get(0).transform.rotate(0, 0, 1, 180);
    }

    @Override
    public void init(float speed, float maxy, float x, float y){
        this.z = -0.2f;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void up(){
        if (x <= 0) x = 2 * ObjectHelper.Wwidth;
        else x -= speed * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }

}

