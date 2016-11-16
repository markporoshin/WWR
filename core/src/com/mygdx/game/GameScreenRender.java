package com.mygdx.game;

/**
 * Created by Mark on 13.11.2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by Mark on 13.11.2016.
 */
public class GameScreenRender {
    public Array<Object> ObjectArr = new Array<Object>();
    float beachOffset;
    float DeltaTime;
    float beachSpeed, waterSpeed;
    GameScreenRender(){
        //speed
        beachSpeed =4f;
        waterSpeed=1.5f;

        //init beach offect for water
        beachOffset = (ObjectHelper.Wheight + ObjectHelper.Bheight) / 2;

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
    }

    public void init(){
        ObjectArr.get(0).init(waterSpeed, 0, 0, 0);
        ObjectArr.get(1).init(waterSpeed, 0, ObjectHelper.Wwidth, 0);
        ObjectArr.get(2).init(beachSpeed, 0,0,  beachOffset);
        ObjectArr.get(3).init(beachSpeed, 0, ObjectHelper.Bwidth, beachOffset);
        ObjectArr.get(4).init(beachSpeed, 0,0,  -beachOffset );
        ObjectArr.get(5).init(beachSpeed, 0, ObjectHelper.Bwidth,  -beachOffset );
        ObjectArr.get(6).init(0,0,0,0);
        ObjectArr.get(7).init(beachSpeed, beachOffset, 0, -beachOffset / 1.2f);
        ObjectArr.get(8).init(beachSpeed, beachOffset, ObjectHelper.Bwidth / 2, 0);
        ObjectArr.get(9).init(beachSpeed, beachOffset, ObjectHelper.Bwidth, beachOffset /2);
    }


    public void reshape(float DeltaTime){
        this.DeltaTime = DeltaTime;
        for (Object o:ObjectArr) {
            o.updata();
        }
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


    public void render(ModelBatch batch, Environment e){
        for (Object o:ObjectArr) {
            batch.render(o.modelArr, e);
        }

    }

    public void dispose(){

    }
}