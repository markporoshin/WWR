package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;

/**
 * Created by Mark on 13.11.2016.
 */
public class Beach extends Object{
    float width, height, sclconst;

    public Beach() {

        width = ObjectHelper.Bwidth;
        height = ObjectHelper.Bheight;
        sclconst = 0.06f * height;//соотношение координат блендера с кординатами игры
        x = 5;
        y = 0;
        z = 0.3f;
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/beacht.jpg"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        modelArr.add(new ModelInstance(model));
        model = BaseModel.Forest();
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        modelArr.get(0).transform.setToTranslation(x,z,y);

        modelArr.get(1).transform.setToTranslation(x,z + 0.1f,y);
        modelArr.get(1).transform.scl(sclconst);


    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}