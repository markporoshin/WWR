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

public class BaseModel {
    static ObjLoader loader;
    static Model model = new Model();
    static AssetManager assets;
    static ModelBuilder modelBuilder = new ModelBuilder();
    static Random r = new Random();

    static Model Forest() {
        loader = new ObjLoader();
        return model = loader.loadModel(Gdx.files.internal("model/forest/forest1.obj"));
    }


    static Model Runner() {
        loader = new ObjLoader();
        model = loader.loadModel(Gdx.files.internal("model/boat.obj"));
        return model;
    }

    static Model Box(float hight, float wight, float depth, Material material) {

        model = modelBuilder.createBox(hight, wight, depth, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);
        return model;
    }
    static Model Stone(){
        loader = new ObjLoader();
        switch (r.nextInt()%1) {
            case 0:
                model = loader.loadModel(Gdx.files.internal("model/stone/tree02.obj"));
                break;

        }
        return model;
    }
}
