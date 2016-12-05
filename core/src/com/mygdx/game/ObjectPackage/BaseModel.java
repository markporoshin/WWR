package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Random;




/**
 * Created by Mark on 24.10.2016.
 */

public class BaseModel extends Thread{
    static ObjLoader loader;
    static Model model = new Model();
    static AssetManager assets;
    static ModelBuilder modelBuilder = new ModelBuilder();
    static Random r = new Random();

    @Override
    public void run() {
        super.run();
          
    }

    static Model Forest() {
        loader = new ObjLoader();
        return model = loader.loadModel(Gdx.files.internal("model/forest/forest1.obj"));
    }

    static Model Runner() {
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/boat/papboat.obj"));
        return model;
    }

    static Model Box(float hight, float wight, float depth, Material material) {

        model = modelBuilder.createBox(hight, wight, depth, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);
        return model;
    }
    static Model Tree(){
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/barrier/tree02.obj"));
        return model;
    }
    static Model downTree(){
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/forest/down.obj"));
        return model;
    }
    static Model Stone(){
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/barrier/stone.obj"));
        return model;
    }
    static Model Cloud1(){
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/cloud/cloud.obj"));
        return model;
    }
    static Model Cloud2(){
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/cloud/cloud1.obj"));
        return model;
    }
}
