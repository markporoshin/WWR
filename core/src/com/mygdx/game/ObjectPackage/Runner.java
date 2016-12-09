package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.GameScreen.MyGameInputProcessor;
import com.mygdx.game.ObjectHelper;

/**
 * Created by Mark on 09.11.2016.
 */
public class Runner extends Object {
    float sclconst;
    float offset;
    float rot=0;
    public Runner(){
        offset = -0.2f;
        r = new Rect( x + 0.2f, y, 2, 0.8f);
        sclconst = 0.1f;
        r.height = 2.5f * sclconst;
        r.width = 5f * sclconst;
        r.x = x + offset;
        r.y = y;

        model = BaseModel.modelList.get(1);
        modelArr.add(new ModelInstance(model));
       /* material = new Material();
        model = BaseModel.Box(2*r.width, 0.1f,2 * r.height, material);
        modelArr.add(new ModelInstance(model));*/
    }

    @Override
    public void init(float speed, float maxy, float x, float y) {
        this.setToTransform(ObjectHelper.Ry, 0.1f, ObjectHelper.Rx);
    }

    @Override
    public void  updata() {

        switch (MyGameInputProcessor.BottunState){
            case 1:
                if(rot < 20)
                    rot++;
                y+= Gdx.graphics.getDeltaTime();
                break;
            case 2:
                if(rot > -20)
                    rot--;

                y-= Gdx.graphics.getDeltaTime();
                break;
            default:
                if(rot < 0)
                    rot++;
                else if(rot > 0)
                    rot--;
        }

        if(y > ObjectHelper.Wheight / 3)
            y = ObjectHelper.Wheight / 3;

        if(y < -ObjectHelper.Wheight / 3)
            y = -ObjectHelper.Wheight / 3;
        r.x = x + offset;
        r.y = y;

        modelArr.get(0).transform.setToTranslation(x,z,y);
        //modelArr.get(1).transform.setToTranslation(x + offset,0.1f,y);
        modelArr.get(0).transform.scl(sclconst*2);
        modelArr.get(0).transform.rotate(0, 1, 0, -90);
        modelArr.get(0).transform.rotate(0,1,0,rot);
    }


    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
