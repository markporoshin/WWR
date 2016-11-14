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
    float wx, wx1;
    float lbx, lb1x;
    float rbx, rb1x;
    float beachOffset;
    float DeltaTime;
    GameScreenRender(){
        //init beach offect for water
        beachOffset = (ObjectHelper.Wheight + ObjectHelper.Bheight) / 2;

        //init beginer coord
        wx = 0;
        wx1 = ObjectHelper.Wwidth;
        lbx = 0;
        lb1x = ObjectHelper.Bwidth;
        rbx = 0;
        rb1x = ObjectHelper.Bwidth;

        //init Object
        ObjectArr.add(new Water());
        ObjectArr.add(new Water());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Beach());
        ObjectArr.add(new Runner());
        ObjectArr.get(6).setToTransform(11, 0.1f, ObjectHelper.Rx);
    }

    public void reshape(float DeltaTime){
        upData();
        this.DeltaTime = DeltaTime;
        //set the position
        ObjectArr.get(0).setToTransform(wx, -0.1f, 0);//water
        ObjectArr.get(1).setToTransform(wx1, -0.1f, 0);//water
        ObjectArr.get(2).setToTransform(lbx, 0, beachOffset);//left beach
        ObjectArr.get(3).setToTransform(lb1x, 0, beachOffset);//left 2 beach
        ObjectArr.get(4).setToTransform(rbx, 0, -beachOffset);//right beach
        ObjectArr.get(5).setToTransform(rb1x, 0, -beachOffset);//right 2 beach
       // ObjectArr.get(6).setToTransform(11, 0.1f, ObjectHelper.Rx);//right 2 beach

        //updata
        ObjectArr.get(0).updata();//water
        ObjectArr.get(1).updata();//left beach
        ObjectArr.get(2).updata();//right bech
        ObjectArr.get(3).updata();//water
        ObjectArr.get(4).updata();//left beach
        ObjectArr.get(5).updata();//right bech
        ObjectArr.get(6).updata();//right bech

    }

    public void upData(){
        if (wx <= 0 + 0.1f) wx = 2*ObjectHelper.Wwidth;
        else wx -= 1.5f * DeltaTime;

        if (wx1 <= 0 + 0.1f) wx1 = 2*ObjectHelper.Wwidth;
        else wx1 -= 1.5f * DeltaTime;

        if (lbx >= 2*ObjectHelper.Bwidth-0.1f) lbx = 0;
        else lbx += DeltaTime;

        if (lb1x >= 2*ObjectHelper.Bwidth-0.1f) lb1x = 0;
        else lb1x += DeltaTime;

        if (rbx >= 2*ObjectHelper.Bwidth-0.1f) rbx = 0;
        else rbx += DeltaTime;

        if (rb1x >= 2*ObjectHelper.Bwidth-0.1f) rb1x = 0;
        else rb1x += DeltaTime;
    }


    public void render(ModelBatch batch, Environment e){
        for (Object o:ObjectArr) {
            batch.render(o.modelArr, e);
        }
    }
}