package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.ObjectHelper;

import java.util.Random;

/**
 * Created by Mark on 25.11.2016.
 */
public class DownTree extends Object{
    float maxy;
    Random rand;
    float scl;
    float rot, rotSpeed, direction;

    public DownTree(){
        scl = 2;
        rand = new Random();
        r = new Rect(x, y, 0.3f, 0.3f);
        r.width = 0.05f * scl;
        r.height = 0.45f * scl;
        r.x = x;
        r.y = y + r.height / 2;
        model = BaseModel.modelList.get(3);
        modelArr.add(new ModelInstance(model));
       /*

         modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/forest1.obj")));0
        modelArr.add(loader.loadModel(Gdx.files.internal("model/boat/ship.obj")));1
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/tree02.obj")));2
        modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/down.obj")));3
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/stone.obj")));4
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud.obj")));5
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud1.obj")));6
        modelArr.add(loader.loadModel(Gdx.files.internal("model/skybox/skybox.obj")));7material = new Material();
        model = BaseModel.Box(2 * r.width, 0.1f,2 * r.height, material);
        modelArr.add(new ModelInstance(model));*/
    }
    @Override
    public void init(float speed, float maxy, float x, float y){
        this.speed = speed;
        this.maxy = maxy;
        this.x = x;
        this.y = y;
        rot = 0;
        rotSpeed = 20;
        direction = 1;
    }

    @Override
    public void  updata() {
        if(direction != 0)
            modelArr.get(0).transform.setToTranslation(x,0.1f,y);
        //modelArr.get(1).transform.setToTranslation(x,0.1f,y - r.height / 2 * direction);
        modelArr.get(0).transform.scl(0.1f * scl);
        up();
    }

    private void up(){
        if (x >= 2 * ObjectHelper.Bwidth-0.1f) {
            x = 0;
            rot = 0;
            rotSpeed = 1f;
            direction = rand.nextInt() % 2;
            y = maxy * direction;
        } else {
            x += speed * Gdx.graphics.getDeltaTime();
            modelArr.get(0).transform.rotate(1, 0, 0, rot);
        }
        if(rot < 90 && rot > -90){
            rotSpeed +=direction * 1.5f;
            rot += -rotSpeed * Gdx.graphics.getDeltaTime();
            r.x = 2;
            r.y = 0;
        }else{
            r.x = x;
            r.y = y - r.height / 2 * direction;
        }
        /*if(x > 0 && x < 0.20f ){
            y = maxy;
            Gdx.app.log("Stone1","position changev" + x);
        }*/
    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
