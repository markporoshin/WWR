package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Mark on 14.11.2016.
 */
public class MyGameInputProcessor implements InputProcessor {
    static byte BottunState = 0;
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
        if((screenX <= GameSpriteRender.lbottuns.getWidth() * 1.5f && screenX >= GameSpriteRender.lbottuns.getWidth() * 0.5f) &&
                (screenY >= Gdx.graphics.getHeight()- GameSpriteRender.lbottuns.getHeight() * 1.5f && screenY <= Gdx.graphics.getHeight() - GameSpriteRender.lbottuns.getWidth() * 0.5f)) {
            BottunState = 1;
        }
        if((screenX >= (Gdx.graphics.getWidth()- GameSpriteRender.rbottuns.getWidth() * 1.5f) && screenX <= (Gdx.graphics.getWidth()- GameSpriteRender.rbottuns.getHeight() * 0.5f)) &&
                (screenY >= Gdx.graphics.getHeight()- GameSpriteRender.rbottuns.getHeight() * 1.5f && screenY <= Gdx.graphics.getHeight() - GameSpriteRender.rbottuns.getWidth() * 0.5f)) {
            BottunState = 2;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(((screenX <= GameSpriteRender.lbottuns.getWidth() * 1.5f && screenX >= GameSpriteRender.lbottuns.getWidth() * 0.5f) &&
                (screenY >= Gdx.graphics.getHeight()- GameSpriteRender.lbottuns.getHeight() * 1.5f && screenY <= Gdx.graphics.getHeight() - GameSpriteRender.lbottuns.getWidth() * 0.5f) ||
                screenX >= (Gdx.graphics.getWidth()- GameSpriteRender.rbottuns.getWidth() * 1.5f) && screenX <= (Gdx.graphics.getWidth()- GameSpriteRender.rbottuns.getHeight() * 0.5f)) &&
        (screenY >= Gdx.graphics.getHeight()- GameSpriteRender.rbottuns.getHeight() * 1.5f && screenY <= Gdx.graphics.getHeight() - GameSpriteRender.rbottuns.getWidth() * 0.5f)) {
            BottunState = 0;
        }
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
