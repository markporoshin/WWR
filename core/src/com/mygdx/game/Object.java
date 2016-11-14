package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by Mark on 13.11.2016.
 */
public class Object {
    public Model model;
    public Array<ModelInstance> modelArr = new Array<ModelInstance>();
    public Material material;
    public TimeUtils t;
    public float x, y, z;
    public Rect r;
    public Object(){
    }

    public void  updata(){

    }

    public void setToTransform(float x, float y, float z){

    }

}
