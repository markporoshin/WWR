package com.mygdx.game.ObjectPackage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.mygdx.game.GameScreen.GameModelRender;
import com.mygdx.game.GameScreen.GameScreenRender;
import com.mygdx.game.ObjectHelper;

/**
 * Created by Mark on 13.11.2016.
 */
public class Beach extends Object {
    float width, height, sclconst;
    private int rotate;
    public Beach() {
        rotate = GameModelRender.rot;
        width = ObjectHelper.Bwidth + 0.1f;
        height = ObjectHelper.Bheight;
        sclconst = 0.06f * height;//соотношение координат блендера с кординатами игры
        x = 5;
        y = 0;
        z = 0f;
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/beacht.jpg"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        modelArr.add(new ModelInstance(model));
        model = BaseModel.modelList.get(0);
        /*
         modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/forest1.obj")));0
        modelArr.add(loader.loadModel(Gdx.files.internal("model/boat/ship.obj")));1
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/tree02.obj")));2
        modelArr.add(loader.loadModel(Gdx.files.internal("model/forest/down.obj")));3
        modelArr.add(loader.loadModel(Gdx.files.internal("model/barrier/stone.obj")));4
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud.obj")));5
        modelArr.add(loader.loadModel(Gdx.files.internal("model/cloud/cloud1.obj")));6
        modelArr.add(loader.loadModel(Gdx.files.internal("model/skybox/skybox.obj")));7*/
        modelArr.add(new ModelInstance(model));
    }

    @Override
    public void  updata() {
        up();
        modelArr.get(0).transform.setToTranslation(x,z,y);
        modelArr.get(0).transform.rotate(1, 0, 0, 8 * rotate);
        modelArr.get(1).transform.setToTranslation(x,z + 0.1f,y);
        //modelArr.get(1).transform.rotate(1, 0, 0, 12 * rotate);
        modelArr.get(1).transform.scl(sclconst);


    }

    @Override
    public void init(float speed, float maxy, float x, float y){
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void up(){
        if (x >= 2 * ObjectHelper.Bwidth - 0.1f) x = 0;
        else x += speed * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void setToTransform(float x, float z, float y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}