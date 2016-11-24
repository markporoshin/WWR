package com.mygdx.game.GameScreen;

/**
 * Created by Mark on 13.11.2016.
 */
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ObjectPackage.Beach;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ObjectPackage.Object;
import com.mygdx.game.ObjectHelper;
import com.mygdx.game.ObjectPackage.Runner;
import com.mygdx.game.ObjectPackage.Tree;
import com.mygdx.game.ObjectPackage.Water;

/**
 * Created by Mark on 13.11.2016.
 */
public class GameScreenRender {
    public Array<Object> ObjectArr = new Array<Object>();
    public static boolean gameOver = false;
    public static boolean gamePause = false;
    private float beachOffset;
    private float DeltaTime;
    private float beachSpeed, waterSpeed, treeSpeed;
    public GameScreenRender(){
        //speed
        beachSpeed =4f;
        waterSpeed = 1.5f;
        treeSpeed = 3.5f;

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
        ObjectArr.add(new Tree());//7
        ObjectArr.add(new Tree());//8
        ObjectArr.add(new Tree());//9
    }

    public void init(){
        gameOver = false;
        gamePause = false;

        ObjectArr.get(0).init(waterSpeed, 0, 0, 0);
        ObjectArr.get(1).init(waterSpeed, 0, ObjectHelper.Wwidth, 0);
        ObjectArr.get(2).init(beachSpeed, 0,0,  beachOffset);
        ObjectArr.get(3).init(beachSpeed, 0, ObjectHelper.Bwidth, beachOffset);
        ObjectArr.get(4).init(beachSpeed, 0,0,  -beachOffset );
        ObjectArr.get(5).init(beachSpeed, 0, ObjectHelper.Bwidth,  -beachOffset );
        ObjectArr.get(6).init(0,0,0,0);
        ObjectArr.get(7).init(treeSpeed, beachOffset, 0, -beachOffset / 1.2f);
        ObjectArr.get(8).init(treeSpeed, beachOffset, ObjectHelper.Bwidth / 2, 0);
        ObjectArr.get(9).init(treeSpeed, beachOffset, ObjectHelper.Bwidth, beachOffset /2);
    }


    public void reshape(float DeltaTime){

        this.DeltaTime = DeltaTime;
        if(!gameOver)
            if(!gamePause)
                for (Object o:ObjectArr) {
                    o.updata();
                }
    }

    public void check(MyGdxGame game){
        if( ObjectArr.get(7).r.Intersects(ObjectArr.get(6).r) ){
            gameOver = true;
            //game.setScreen(new MainMenuScreen(game));
        }
        if( ObjectArr.get(8).r.Intersects(ObjectArr.get(6).r) ){
            gameOver = true;
            //game.setScreen(new MainMenuScreen(game));
        }
       if( ObjectArr.get(9).r.Intersects(ObjectArr.get(6).r) ){
           gameOver = true;
           //game.setScreen(new MainMenuScreen(game));
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