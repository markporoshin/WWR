package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.mygdx.game.*;

import java.util.Random;

/**
 * Created by Mark on 14.11.2016.
 */
public class Tree extends Object {
    float maxy;
    Random rand;
    float scl;
    public Tree(){
        scl = 2;
        rand = new Random();
        r = new Rect(x, y, 0.3f, 0.3f);
        r.width = 0.45f * scl;
        r.height = 0.05f * scl;
        r.x = x;
        r.y = y;
        model = BaseModel.Tree();
        modelArr.add(new ModelInstance(model));
        /*material = new Material();
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
    }

    @Override
    public void  updata() {
        modelArr.get(0).transform.setToTranslation(x,-0.1f,y);
        //modelArr.get(1).transform.setToTranslation(x,0.1f,y);
        modelArr.get(0).transform.scl(0.1f * scl);
        r.x = x;
        r.y = y;
        up();
    }

    private void up(){
        if (x >= 2 * ObjectHelper.Bwidth-0.1f) {x = 0;}
        else {x += speed * Gdx.graphics.getDeltaTime();y+=Gdx.graphics.getDeltaTime() * speedx;}
        if(x > 0 && x < 0.20f ){
            y = (2 * rand.nextFloat()-1) * (maxy - 1.5f);
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
