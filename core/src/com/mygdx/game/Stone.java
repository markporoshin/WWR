package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Mark on 14.11.2016.
 */
public class Stone extends Object {

    public Stone(){
        r = new Rect(x, y, 0.3f, 0.3f);
        r.width = 0.15f;
        r.height = 0.15f;
        r.x = x;
        r.y = y;
        model = BaseModel.Stone();
        modelArr.add(new ModelInstance(model));
    }
    @Override
    public void  updata() {
        modelArr.get(0).transform.setToTranslation(x,z,y);
        modelArr.get(0).transform.scl(0.1f);
        r.x = x;
        r.y = y;
    }


    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
