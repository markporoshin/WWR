package com.mygdx.game;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by Mark on 11.10.2016.
 */
public class Object {
    public Model model;
    public ModelInstance instance;
    public ModelInstance leftBeach;
    public ModelInstance rightBeach;
    public Array<ModelInstance> modelArr = new Array<ModelInstance>();
    public Material material;
    public Texture texture;
    public ModelBuilder modelBuilder;
    public TimeUtils t;
    public ObjLoader Loader;
    public Mesh mesh;

    public Object(){
    }

    public void  updata(boolean touchScreen,
                        boolean untouchScreen,
                        boolean draggedTouch,
                        int x1,int x2,int y1,int y2, int dx, int dy){

    }
}
