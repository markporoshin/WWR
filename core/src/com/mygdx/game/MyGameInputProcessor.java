package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Mark on 14.11.2016.
 */
public class MyGameInputProcessor implements InputProcessor {
    static byte BottunState = 0;
    private int scl = GameSpriteRender.scl;
    private float x1 = Gdx.graphics.getWidth() / 8, y1 = 7 * Gdx.graphics.getHeight() / 8;
    private float x2 = 7 * Gdx.graphics.getWidth() / 8 - GameSpriteRender.rbottuns.getRegionWidth(), y2 = 7 * Gdx.graphics.getHeight() / 8;

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
        if(screenX < x1 + scl * GameSpriteRender.lbottuns.getWidth() / 2 && screenX > x1 - scl * GameSpriteRender.lbottuns.getWidth() / 2 &&
                screenY < y1 + scl * GameSpriteRender.lbottuns.getHeight() / 2 && screenY > y1 - scl * GameSpriteRender.lbottuns.getHeight() / 2) {
            BottunState = 1;
        }
        if(screenX < x2 + scl * GameSpriteRender.rbottuns.getWidth() / 2 && screenX > x2 - scl * GameSpriteRender.rbottuns.getWidth() / 2 &&
                screenY < y2 + scl * GameSpriteRender.rbottuns.getHeight() / 2 && screenY > y2 - scl * GameSpriteRender.rbottuns.getHeight() / 2) {
            BottunState = 2;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(true) {
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
