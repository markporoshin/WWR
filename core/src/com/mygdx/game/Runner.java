package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Mark on 09.11.2016.
 */
public class Runner extends Object {
    float sclconst;
    public Runner(){
        r = new Rect( x + 0.2f, y, 2, 0.8f);
        r.height = 0.4f;
        r.width = 1;
        r.x = x + 0.2f;
        r.y = y;
        sclconst = 0.3f;
        model = BaseModel.Runner();
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        switch (MyGameInputProcessor.BottunState){
            case 1:
                y+= Gdx.graphics.getDeltaTime();
                break;
            case 2:
                y-= Gdx.graphics.getDeltaTime();
                break;
        }

        if(y > ObjectHelper.Wheight / 3)
            y = ObjectHelper.Wheight / 3;

        if(y < -ObjectHelper.Wheight / 3)
            y = -ObjectHelper.Wheight / 3;
        r.x = x + 0.2f;
        r.y = y;

        modelArr.get(0).transform.setToTranslation(x,z,y);
        modelArr.get(0).transform.scl(sclconst);
        modelArr.get(0).transform.rotate(0, 1, 0, -90);
    }


    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
