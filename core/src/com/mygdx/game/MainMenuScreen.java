package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GameScreen.MyGameInputProcessor;

/**
 * Created by Mark on 24.10.2016.
 */
public class MainMenuScreen implements Screen {
    MyGdxGame myGame;

    static float scl;
    public static Button play, setting, exit;
    public MainMenuScreen(MyGdxGame Game){
        myGame = Game;
        play = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/play3.png"))), (int)(3.0f / 6 * Gdx.graphics.getWidth()), (int)(2.0f / 3 * Gdx.graphics.getHeight()));
        exit = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/nastroyki144.png"))), (int)(2.5f / 6 * Gdx.graphics.getWidth()), (int)(1.0f / 3 * Gdx.graphics.getHeight()));
        setting = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/vykhod144.png"))), (int)(3.5f / 6 * Gdx.graphics.getWidth()), (int)(1.0f / 3 * Gdx.graphics.getHeight()));

        Gdx.input.setInputProcessor(new MyMenuInputProcessor(myGame));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        myGame.spriteBatch.begin();
        play.draw(myGame.spriteBatch);
        setting.draw(myGame.spriteBatch);
        exit.draw(myGame.spriteBatch);
        myGame.spriteBatch.end();
    }

    @Override
    public void dispose() {
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



}
