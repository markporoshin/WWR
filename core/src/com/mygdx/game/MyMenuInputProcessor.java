package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Mark on 16.11.2016.
 */
public class MyMenuInputProcessor implements InputProcessor {

    private float scl = MainMenuScreen.scl;
    private MyGdxGame game;
    MyMenuInputProcessor(MyGdxGame game){
        this.game = game;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        MainMenuScreen.play.touchDown(screenX, screenY);
        MainMenuScreen.setting.touchDown(screenX, screenY);
        if(MainMenuScreen.exit.touchDown(screenX, screenY)){
            Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        MainMenuScreen.play.touchUp(screenX, screenY);
        MainMenuScreen.setting.touchUp(screenX, screenY);
        MainMenuScreen.exit.touchUp(screenX, screenY);
        if(MainMenuScreen.play.getUp()){
            game.GSR.init();
            game.setScreen(new MainGameScreen(game));
        }if(MainMenuScreen.setting.getUp()){
            game.GSR.init();
            game.setScreen(new MainGameScreen(game));
        }/*if(MainMenuScreen.exit.getUp()){
           Gdx.app.exit();
        }*/
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}