package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

/**
 * Created by Mark on 09.11.2016.
 */
public class Runner extends Object {
    AssetManager assets;
    public Runner(){
        //model = ;


        model = BaseModel.Runner();
        instance = new ModelInstance(model);
        instance.transform.setToTranslation(0, 0, 0);
    }

    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1, int x2, int y1, int y2, int dx, int dy) {

    }
}
