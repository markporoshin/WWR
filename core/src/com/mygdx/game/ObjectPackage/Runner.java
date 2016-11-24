package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.GameScreen.MyGameInputProcessor;
import com.mygdx.game.ObjectHelper;

/**
 * Created by Mark on 09.11.2016.
 */
public class Runner extends Object {
    float sclconst;
    public Runner(){
        r = new Rect( x + 0.2f, y, 2, 0.8f);
        r.height = 0.1f;
        r.width = 0.2f;
        r.x = x + 1f;
        r.y = y;
        sclconst = 0.1f;
        model = BaseModel.Runner();
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void init(float speed, float maxy, float x, float y) {
        this.setToTransform(ObjectHelper.Ry, 0.1f, ObjectHelper.Rx);
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
