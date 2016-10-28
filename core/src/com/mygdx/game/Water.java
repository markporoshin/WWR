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
public class Water extends Object {
    public int sizei = 3, sizej = 10; //number of block water
    private float mas[][] = new float[sizei][sizej];//water y offset
    private boolean vec[][] = new boolean[sizei][sizej];//water y offset direction //true - up, false - down
    public float size = 5;//size of block water
    private float offsetx = -(size * (sizej-0.5f)), offsetz = -(size * (sizei-2));
    private float beachOffsetx = (-size * (sizej) / 2), beachOffsetz =  size * (sizei - 0.5f);
    private Random rnd = new Random();
    private ModelInstance in;

    public float x = 10, z = 0;

    public Water(){
        super();
        createWater();
    }

    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1, int x2, int y1, int y2, int dx, int dy)
    {
        waterUpdata();
    }

    private void createWater(){
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("image/watertexture.jpg"));
        material = new Material(textureAttribute);
        modelBuilder = new ModelBuilder();
        model = BaseModel.Box(size, 0.3f, size, material);
        for(int i = 0; i < sizei; i++){
            for(int j = 0; j < sizej; j++){
                instance = new ModelInstance(model);
                instance.transform.setToTranslation(j * size + offsetx, -0.15f, i * size + offsetz);
                water.add(instance);
            }
        }
        for(int i = 0; i < sizei; i++){
            for(int j = 0; j < sizej; j++) {
                mas[i][j] = 0.15f;
                vec[i][j] = rnd.nextBoolean();
            }
        }
    }

    private void waterUpdata() {
        for(int i = 0; i < sizei; i++){
            for(int j = 0; j < sizej; j++){
                check(i, j);
                if(vec[i][j] == true) {
                    mas[i][j] += rnd.nextFloat() / 100;
                }
                else{
                    mas[i][j] -= rnd.nextFloat() / 100;
                }
                in = water.get(j*3 + i);
                in.transform.setToTranslation(j * size + offsetx + x, mas[i][j] - 0.15f,  i * size + offsetz + z);
            }
        }
    }

    private void check(int i, int j){
        if(mas[i][j] >= 0.3f)
            vec[i][j] = false;
        if( mas[i][j] <= 0)
            vec[i][j] = true;
    }
}
