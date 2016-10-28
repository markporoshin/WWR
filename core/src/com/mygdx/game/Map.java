package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;


/**
 * Created by Mark on 11.10.2016.
 */
public class Map extends Object {
    float angle, dangle;
    public Map(){
        super();
        Loader = new ObjLoader();

        instance = new ModelInstance(Loader.loadModel(Gdx.files.internal("Rabbit/Rabbit.obj")));


        /*ModelBuilder modelBuilder = new ModelBuilder();
        TextureAttribute textureAttribute = TextureAttribute.createDiffuse(new Texture("picture/picture.jpg"));
        material = new Material(textureAttribute);
        model = modelBuilder.createBox(10f, 10f, 10f, material, VertexAttributes.Usage.Position| VertexAttributes.Usage.Normal| VertexAttributes.Usage.TextureCoordinates);
        instance = new ModelInstance(model);*/
        instance.transform.setTranslation(0f, -0.5f, 0f);
    }
    @Override
    public void  updata(    boolean touchScreen,
                            boolean untouchScreen,
                            boolean draggedTouch,
                            int x1,int x2,int y1,int y2, int dx, int dy)
    {
        instance.transform.idt();
        //angle = -(float)t.millis() % 1000.0f / 1000;
        if(draggedTouch) {
            if ((Math.abs(x2 - x1)) < Math.abs((y2 - y1))) {
                ;//instance.transform.rotate(1, 0, 0, Math.abs(x2 - x1) % 1500);
            } else if ((Math.abs(x2 - x1)) > Math.abs((y2 - y1))) {
                angle += dx;
            }
        }
        instance.transform.scl(10);
        instance.transform.rotate(0, 1, 0, angle);

    }

}
