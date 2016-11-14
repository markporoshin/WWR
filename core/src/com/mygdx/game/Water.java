package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;

public class Water extends Object{
    float width, height;

    Water(){
        width = ObjectHelper.Wwidth + 0.3f;
        height = ObjectHelper.Wheight;
        x = 5;
        y = 0;
        z = 0;
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/Green24.png"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        modelArr.get(0).transform.setToTranslation(x,z,y);
        modelArr.get(0).transform.rotate(0, 0, 1, 180);
    }


    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }

}

