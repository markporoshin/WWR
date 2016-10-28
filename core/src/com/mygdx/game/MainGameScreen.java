package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

/**
 * Created by Mark on 22.10.2016.
 */
public class MainGameScreen implements Screen{
    MyGdxGame game;
    PerspectiveCamera cam;
    public Environment environment;
    public MyInputProcessor inputProcessor;
    public Place p;
    public MainGameScreen(MyGdxGame game)
    {
        this.game = game;

        inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(55f, 10f, 0f);
        cam.lookAt(30f, 0f, 0f);
        cam.near = 1f;
        cam.far = 40f;
        cam.update();
        p = new Place();
    }

    @Override
    public void render(float delta) {
        p.upData(inputProcessor.touchScreen,
                inputProcessor.untouchScreen,
                inputProcessor.draggedTouch,
                inputProcessor.x1, inputProcessor.x2,
                inputProcessor.y1, inputProcessor.y2,
                inputProcessor.dx, inputProcessor.dy);

        Gdx.gl.glViewport ( 0 , 0 , Gdx.graphics.getWidth (), Gdx.graphics.getHeight ());
        Gdx.gl.glClearColor( 0.178f, 0.233f, 0.238f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);


        game.modelBatch.begin(cam);
        game.modelBatch.render(p.W.water, environment);
        //game.modelBatch.render(p.B.leftBeach, environment);
        //game.modelBatch.render(p.B.rightBeach, environment);

        game.modelBatch.render(p.W1.water, environment);
        //game.modelBatch.render(p.B1.leftBeach, environment);
        //game.modelBatch.render(p.B1.rightBeach, environment);

        //game.modelBatch.render(o2.rightBeach, environment);
        //game.modelBatch.render(o2.leftBeach, environment);
        //game.modelBatch.render(o2.water, environment);

        game.modelBatch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        p.W.model.dispose();
        p.B.model.dispose();
        p.W1.model.dispose();
        p.B1.model.dispose();

    }
}
