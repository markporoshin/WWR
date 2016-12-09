package com.mygdx.game.GameScreen;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ObjectHelper;
import com.mygdx.game.ObjectPackage.Beach;
import com.mygdx.game.ObjectPackage.Cloud;
import com.mygdx.game.ObjectPackage.DownTree;
import com.mygdx.game.ObjectPackage.Object;
import com.mygdx.game.ObjectPackage.Runner;
import com.mygdx.game.ObjectPackage.SkyBox;
import com.mygdx.game.ObjectPackage.Stone;
import com.mygdx.game.ObjectPackage.Tree;
import com.mygdx.game.ObjectPackage.Water;

/**
 * Created by Mark on 25.11.2016.
 */
public class GameModelRender {
    public Array<Object> StaticObjectArr = new Array<Object>();
    public Array<Object> DynamicObjectArr = new Array<Object>();
    public static boolean gameOver = false;
    public static boolean gamePause = false;
    private float beachOffset;
    private float DeltaTime;
    private float beachSpeed, waterSpeed, treeSpeed;
    public static int rot;
    //public Preferences stat = Gdx.app.getPreferences("stat");
    public GameModelRender(){
        beachSpeed = 4f;
        waterSpeed = 1.5f;
        treeSpeed = 1.5f;
        beachOffset = (ObjectHelper.Wheight + ObjectHelper.Bheight) / 2;

        //init Object
        StaticObjectArr.add(new Water());//0
        StaticObjectArr.add(new Water());//1
        rot = -1;
        StaticObjectArr.add(new Beach());//2
        StaticObjectArr.add(new Beach());//3
        rot = 1;
        StaticObjectArr.add(new Beach());//4
        StaticObjectArr.add(new Beach());//5
        StaticObjectArr.add(new Cloud());//8
        StaticObjectArr.add(new Cloud());//8
        StaticObjectArr.add(new Cloud());//8
        StaticObjectArr.add(new Cloud());//8
        StaticObjectArr.add(new Cloud());//8
        //StaticObjectArr.add(new SkyBox());//8

        DynamicObjectArr.add(new Runner());//0
        DynamicObjectArr.add(new Tree());//1
        DynamicObjectArr.add(new Tree());//2
        DynamicObjectArr.add(new Tree());//3
        DynamicObjectArr.add(new Stone());//4
        DynamicObjectArr.add(new Stone());//5
        DynamicObjectArr.add(new Stone());//6
        DynamicObjectArr.add(new DownTree());//7

    }

    public void init(){
        gameOver = false;
        gamePause = false;

        StaticObjectArr.get(0).init(waterSpeed, 0, 0, 0);
        StaticObjectArr.get(1).init(waterSpeed, 0, ObjectHelper.Wwidth, 0);
        StaticObjectArr.get(2).init(beachSpeed, 0,0,  beachOffset);
        StaticObjectArr.get(3).init(beachSpeed, 0, ObjectHelper.Bwidth, beachOffset);
        StaticObjectArr.get(4).init(beachSpeed, 0,0,  -beachOffset );
        StaticObjectArr.get(5).init(beachSpeed, 0, ObjectHelper.Bwidth,  -beachOffset );
        StaticObjectArr.get(6).init(beachSpeed + 0.5f, 0, 1.5f * ObjectHelper.Bwidth,  -beachOffset );
        StaticObjectArr.get(7).init(beachSpeed + 0.5f, 0, -1f * ObjectHelper.Bwidth,  -beachOffset / 2  );
        StaticObjectArr.get(8).init(beachSpeed + 0.5f, 0, 1f * ObjectHelper.Bwidth,  -beachOffset / 3 );
        StaticObjectArr.get(8).init(beachSpeed + 0.5f, 0, 0.7f * ObjectHelper.Bwidth,  0 );
        StaticObjectArr.get(8).init(beachSpeed + 0.5f, 0, -1.5f * ObjectHelper.Bwidth,  beachOffset );
        //StaticObjectArr.get(9).init(0, 0, 0, 0);

        DynamicObjectArr.get(0).init(0,0,0,0);
        DynamicObjectArr.get(1).init(treeSpeed, beachOffset, 0, -beachOffset / 1.2f);
        DynamicObjectArr.get(2).init(treeSpeed, beachOffset, ObjectHelper.Bwidth / 2, 0);
        DynamicObjectArr.get(3).init(treeSpeed, beachOffset, ObjectHelper.Bwidth, beachOffset /2);
        DynamicObjectArr.get(4).init(beachSpeed, beachOffset, 0, beachOffset / 1.8f);
        DynamicObjectArr.get(5).init(beachSpeed, beachOffset, ObjectHelper.Bwidth / 2, beachOffset / 1.3f);
        DynamicObjectArr.get(6).init(beachSpeed, beachOffset, ObjectHelper.Bwidth, beachOffset);
        DynamicObjectArr.get(7).init(beachSpeed, beachOffset / 1.3f, ObjectHelper.Bwidth, beachOffset / 1.3f);
    }


    public void reshape(float DeltaTime){

        this.DeltaTime = DeltaTime;
        if(!gameOver)
            if(!gamePause) {
                for (Object o : StaticObjectArr) {
                    o.updata();
                }
                for (Object o: DynamicObjectArr) {
                    o.updata();
                }
            }
    }

    public void check(MyGdxGame game){
        DynamicObjectArr.get(1).speed = treeSpeed;
        DynamicObjectArr.get(2).speed = treeSpeed;
        DynamicObjectArr.get(3).speed = treeSpeed;

        for (Object o:DynamicObjectArr) {
            if(o instanceof Tree){
                if( o.r.Intersects(DynamicObjectArr.get(4).r) ){
                    o.speed = beachSpeed;
                }
                if( o.r.Intersects(DynamicObjectArr.get(5).r) ){
                    o.speed = beachSpeed;
                }
                if( o.r.Intersects(DynamicObjectArr.get(6).r) ){
                    o.speed = beachSpeed;
                }
                if( o.r.Intersects(DynamicObjectArr.get(7).r) ){
                    o.speed = beachSpeed;
                }

            }
        }
        if( DynamicObjectArr.get(1).r.Intersects(DynamicObjectArr.get(2).r) || DynamicObjectArr.get(1).r.Intersects(DynamicObjectArr.get(3).r) ){
            DynamicObjectArr.get(1).speedx = beachSpeed / 2;
        }else if( DynamicObjectArr.get(2).r.Intersects(DynamicObjectArr.get(1).r) || DynamicObjectArr.get(2).r.Intersects(DynamicObjectArr.get(3).r) ){
            DynamicObjectArr.get(2).speedx = -beachSpeed / 2;
        }else if( DynamicObjectArr.get(3).r.Intersects(DynamicObjectArr.get(2).r) || DynamicObjectArr.get(3).r.Intersects(DynamicObjectArr.get(1).r) ){
            DynamicObjectArr.get(3).speedx = beachSpeed / 2;
        }
        if( DynamicObjectArr.get(1).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(2).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(3).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(4).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(5).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(6).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}
        if( DynamicObjectArr.get(7).r.Intersects(DynamicObjectArr.get(0).r) ){gameOver = true;}

    }


    public Command render(ModelBatch batch, Environment e, PerspectiveCamera cam){
        batch.begin(cam);
        for (Object o: StaticObjectArr) {
            batch.render(o.modelArr, e);
        }
        for (Object o: DynamicObjectArr) {
            batch.render(o.modelArr, e);
        }
        batch.end();
        if(gameOver)
            return Command.GAMEOVER;
        return Command.GAMERENDER;
    }

    public void dispose(){

    }
}
