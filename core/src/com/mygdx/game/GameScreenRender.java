package com.mygdx.game;

/**
 * Created by Mark on 13.11.2016.
 */
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Mark on 13.11.2016.
 */
public class GameScreenRender {
    public Array<Object> ObjectArr = new Array<Object>();
    int wx, wx1;
    int lbx, lb1x;
    int rbx, rb1x;

    GameScreenRender(){
        ObjectArr.add(new Water());
        ObjectArr.add(new Water());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
    }

    public void reshape(float DeltaTime){
        //set the position
        ObjectArr.get(0).setToTransform(wx, -0.1f, 0);//water
        ObjectArr.get(1).setToTransform(wx1, -0.1f, 0);//water
        ObjectArr.get(2).setToTransform(lbx, 0, 0.75f + 1.5f);//left beach
        ObjectArr.get(3).setToTransform(lb1x, 0, -(0.75f + 1.5f));//right bech
        ObjectArr.get(4).setToTransform(rbx, 0, 0.75f + 1.5f);//left beach
        ObjectArr.get(5).setToTransform(rb1x, 0, -(0.75f + 1.5f));//right bech

        //updata
        ObjectArr.get(0).updata();//water
        ObjectArr.get(1).updata();//left beach
        ObjectArr.get(2).updata();//right bech
        ObjectArr.get(3).updata();//water
        ObjectArr.get(4).updata();//left beach
        ObjectArr.get(5).updata();//right bech

    }

    public void upData(){

    }


    public void render(ModelBatch batch, Environment e){
        for (Object o:ObjectArr) {
            batch.render(o.modelArr, e);
        }
    }
}