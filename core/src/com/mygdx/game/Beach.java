package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.Random;

/**
 * Created by Mark on 24.10.2016.
 */
public class Beach extends Object{
    final int numOfTreeX = 17, numOfTreeY = 7;//количество по высоте и количестов по ширине
    float width = 100, height = 50;
    float x, y, z, rand[] = new float[numOfTreeX];
    float offsetX, offsetY;
    Random r = new Random();
    ModelInstance inst;


    public Beach() {
        x = 5;
        y = 0;
        z = 0.3f;
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/beacht.jpg"));
        material = new Material(textureAttribute);
        model = BaseModel.Box(width, 0.3f, height, material);
        instance = new ModelInstance(model);
        //instance.transform.setToTranslation(x,z,y);

        offsetX = - width / 2 + width / numOfTreeX / 2;
        offsetY = - height / 2 + height / numOfTreeY / 2;
        setRand();
        for(int i = 0; i < numOfTreeX; i++)
            for (int j = 0; j < numOfTreeY; j++) {
                inst = new ModelInstance(BaseModel.Tree());
                //inst.transform.setToTranslation(i * width / numOfTreeX + x + offsetX, z,
                //                                j * height / numOfTreeY + y + offsetY);
                modelArr.add(inst);
            }
    }

    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1, int x2, int y1, int y2, int dx, int dy) {
        beachUpdata();
    }

    public void beachUpdata(){
        instance.transform.setToTranslation(x,z,y);
        for(int i=0,k=0; i < numOfTreeX; i++)
            for (int j = 1; j < numOfTreeY - 1; j++){
                modelArr.get(k).transform.setToTranslation(i * width / numOfTreeX + x + offsetX, z,
                                                           j * height / numOfTreeY + y + offsetY);
                modelArr.get(k++).transform.scl(0.3f);
            }
    }

    public void setRand() {
        for(int i = 0; i < numOfTreeX; i++){
            for (int j = 0; j < numOfTreeY; j++)
                rand[i] = r.nextInt() % (height / 3);
        }
    }
}
