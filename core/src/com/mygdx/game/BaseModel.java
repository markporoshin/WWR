package com.mygdx.game;

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

public class BaseModel {
    static ObjLoader loader;
    static Model model = new Model();
    static AssetManager assets;
    static ModelBuilder modelBuilder = new ModelBuilder();
    static Random r = new Random();

    static Model Forest() {
        loader = new ObjLoader();
        return model = loader.loadModel(Gdx.files.internal("model/forest/forst.obj"));
    }

    /*static Model Tree(){
        loader = new ObjLoader();
        switch(Math.abs(r.nextInt() % 9)){
            case 0:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree1.obj"));
                break;
            case 1:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree2.obj"));
                break;
            case 2:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree3.obj"));
                break;
            case 3:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree4.obj"));
                break;
            case 4:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree5.obj"));
                break;
            case 5:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree6.obj"));
                break;
            case 6:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree7.obj"));
                break;
            case 7:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree8.obj"));
                break;
            case 8:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree9.obj"));
                break;
            default:
                model = loader.loadModel(Gdx.files.internal("model/tree/tree9.obj"));
                break;
        }

        return model;
    }*/
    static Model Runner() {
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/boat/boat.obj"));
        return model;
    }

    static Model Box(float hight, float wight, float depth, Material material) {

        model = modelBuilder.createBox(hight, wight, depth, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);
        return model;
    }
}
