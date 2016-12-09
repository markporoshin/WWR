package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.ObjectHelper;

import java.util.Random;

/**
 * Created by Mark on 02.12.2016.
 */
public class Cloud extends Object {
    float maxy;
    Random rand;
    float scl;
    public Cloud(){
        scl = 4;
        rand = new Random();
        r = new Rect(x, y, 0.3f, 0.3f);
        r.width = 0.45f * scl;
        r.height = 0.05f * scl;
        r.x = x;
        r.y = y;
        switch (Math.abs(rand.nextInt()% 2)) {
            case 0:
                model = BaseModel.modelList.get(5);
                break;
            case 1:
                model = BaseModel.modelList.get(6);
                break;
        }
        modelArr.add(new ModelInstance(model));
        /*
         modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/forest1.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/boat/ship.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/tree02.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/down.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/stone.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud1.obj")));
        modelArr.add(loader.loadModel(Gdx.files.internal("model/skybox/skybox.obj")));
        material = new Material();
        model = BaseModel.Box(2 * r.width, 0.1f,2 * r.height, material);
        modelArr.add(new ModelInstance(model));*/
    }
    @Override
    public void init(float speed, float maxy, float x, float y){
        speedx = 0;
        this.speed = speed;
        this.maxy = maxy;
        this.x = x;
        this.y = y;
        z = 4 + rand.nextFloat() * 2;
    }

    @Override
    public void  updata() {
        modelArr.get(0).transform.setToTranslation(x,z,y);
        //modelArr.get(1).transform.setToTranslation(x,0.1f,y);
        modelArr.get(0).transform.scl(0.1f * scl);
        r.x = x;
        r.y = y;
        up();
    }

    private void up(){
        if (x >= 2 * ObjectHelper.Bwidth-0.1f) {x = 0; y = y * -1 ;}
        else {x += speed * Gdx.graphics.getDeltaTime();}
        if(x > 0 && x < 0.20f ){

        }
        speedx = 0;
    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
