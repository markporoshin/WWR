package com.mygdx.game;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

/**
 * Created by Mark on 24.10.2016.
 */
public class BaseModel {
    static Model model = new Model();
    static ModelBuilder modelBuilder = new ModelBuilder();

    static Model Box(float hight, float wight, float depth, Material material){
        model = modelBuilder.createBox(hight, wight, depth, material,
                VertexAttributes.Usage.Position| VertexAttributes.Usage.Normal| VertexAttributes.Usage.TextureCoordinates);
        return model;
    }
}
