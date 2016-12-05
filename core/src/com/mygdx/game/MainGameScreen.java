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



    public MainGameScreen(MyGdxGame game)
    {
        this.game = game;
        game.GSR.init();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //cam.position.set(10f, 40f, 0f);
        cam.position.set(13.6f, 1.4f, 0f);
        cam.lookAt(0f, 0f, 0f);
        cam.near = 0.1f;
        cam.far = 10f;
        cam.update();


        Gdx.input.setInputProcessor(new com.mygdx.game.GameScreen.MyGameInputProcessor(game));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport ( 0 , 0 , Gdx.graphics.getWidth (), Gdx.graphics.getHeight ());
        Gdx.gl.glClearColor( 0.0627f, 0.474f, 0.588f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);

        game.GSR.render(game.spriteBatch, game.modelBatch, environment, cam, game);
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
    }
}