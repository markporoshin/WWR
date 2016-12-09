package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.mygdx.game.ObjectHelper;

/**
 * Created by Mark on 07.12.2016.
 */
public class SkyBox extends Object {
    float width, height;
    int rot=0;
    public SkyBox(){
        width = 9;
       //13.6f, 1.4f, 0f
        x = 13.6f;
        y = 0;
        z = 1.4f;

        model = BaseModel.Skybox();
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        up();
        modelArr.get(0).transform.setToTranslation(x,z-2,y);
        modelArr.get(0).transform.scl(9f);
        modelArr.get(0).transform.rotate(1, 0, 0, -90);
        modelArr.get(0).transform.rotate(0, 0, 1, rot++ / 10.0f);

    }

    @Override
    public void init(float speed, float maxy, float x, float y){
    }

    public void up(){
    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }

}