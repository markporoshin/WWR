package com.mygdx.game;

/**
 * Created by Mark on 13.11.2016.
 */
import com.badlogic.gdx.Gdx;
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
    float sx, sx1, sx2;
    float beachOffset;
    float DeltaTime;
    float beachSpeed, waterSpeed;
    GameScreenRender(){
        //speed
        beachSpeed =1f;
        waterSpeed=1.5f;
        //init beach offect for water
        beachOffset = (ObjectHelper.Wheight + ObjectHelper.Bheight) / 2;

        //init beginer coord
        wx = 0;
        wx1 = ObjectHelper.Wwidth;
        lbx = 0;
        lb1x = ObjectHelper.Bwidth;
        rbx = 0;
        rb1x = ObjectHelper.Bwidth;
        sx = 0;
        sx1 =  ObjectHelper.Bwidth / 2;
        sx2 =  ObjectHelper.Bwidth;

        //init Object
        ObjectArr.add(new Water());//0
        ObjectArr.add(new Water());//1
        ObjectArr.add(new Beach());//2
        ObjectArr.add(new Beach());//3
        ObjectArr.add(new Beach());//4
        ObjectArr.add(new Beach());//5
        ObjectArr.add(new Runner());//6
        ObjectArr.add(new Stone());//7
        ObjectArr.add(new Stone());//8
        ObjectArr.add(new Stone());//9
        ObjectArr.get(6).setToTransform(11, 0.1f, ObjectHelper.Rx);
    }

    public void init(){
        wx = 0;
        wx1 = ObjectHelper.Wwidth;
        lbx = 0;
        lb1x = ObjectHelper.Bwidth;
        rbx = 0;
        rb1x = ObjectHelper.Bwidth;
        sx = 0;
        sx1 =  ObjectHelper.Bwidth / 2;
        sx2 =  ObjectHelper.Bwidth;
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
        ObjectArr.get(7).setToTransform(sx, 0, -beachOffset / 2);//stone
        ObjectArr.get(8).setToTransform(sx2, 0, beachOffset / 2);//stone
        ObjectArr.get(9).setToTransform(sx1, 0, 0);//stone
       // ObjectArr.get(6).setToTransform(11, 0.1f, ObjectHelper.Rx);//right 2 beach

        //updata
        ObjectArr.get(0).updata();//water
        ObjectArr.get(1).updata();//left beach
        ObjectArr.get(2).updata();//right bech
        ObjectArr.get(3).updata();//water
        ObjectArr.get(4).updata();//left beach
        ObjectArr.get(5).updata();//right bech
        ObjectArr.get(6).updata();//right runner
        ObjectArr.get(7).updata();//right stone
        ObjectArr.get(8).updata();//right stone
        ObjectArr.get(9).updata();//right stone

    }

    public void check(MyGdxGame game){
        if( ObjectArr.get(7).r.Intersects(ObjectArr.get(6).r) ){
            Gdx.app.log("True","Intersects");
            game.setScreen(new MainMenuScreen(game));
        }
        if( ObjectArr.get(8).r.Intersects(ObjectArr.get(6).r) ){
            Gdx.app.log("True","Intersects");
            game.setScreen(new MainMenuScreen(game));
        }
        if( ObjectArr.get(9).r.Intersects(ObjectArr.get(6).r) ){
            Gdx.app.log("True","Intersects");
            game.setScreen(new MainMenuScreen(game));
        }
    }

    public void upData(){
        if (wx <= 0/* + 0.1f*/) wx = 2*ObjectHelper.Wwidth;
        else wx -= waterSpeed * DeltaTime;

        if (wx1 <= 0 /*+ 0.1f*/) wx1 = 2*ObjectHelper.Wwidth;
        else wx1 -= waterSpeed * DeltaTime;

        if (lbx >= 2*ObjectHelper.Bwidth-0.1f) lbx = 0;
        else lbx += beachSpeed*DeltaTime;

        if (lb1x >= 2*ObjectHelper.Bwidth-0.1f) lb1x = 0;
        else lb1x += beachSpeed*DeltaTime;

        if (rbx >= 2*ObjectHelper.Bwidth-0.1f) rbx = 0;
        else rbx += beachSpeed*DeltaTime;

        if (rb1x >= 2*ObjectHelper.Bwidth-0.1f) rb1x = 0;
        else rb1x += beachSpeed*DeltaTime;

        if (sx >= 2*ObjectHelper.Bwidth-0.1f) sx = 0;
        else sx += beachSpeed*DeltaTime;

        if (sx1 >= 2*ObjectHelper.Bwidth-0.1f) sx1 = 0;
        else sx1 += beachSpeed*DeltaTime;

        if (sx2 >= 2*ObjectHelper.Bwidth-0.1f) sx2 = 0;
        else sx2 += beachSpeed*DeltaTime;
    }


    public void render(ModelBatch batch, Environment e){
        for (Object o:ObjectArr) {
            batch.render(o.modelArr, e);
        }

    }

    public void dispose(){

    }
}