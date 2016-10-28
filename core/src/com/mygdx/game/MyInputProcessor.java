package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by Mark on 15.10.2016.
 */
public class MyInputProcessor implements InputProcessor {
    boolean touchScreen = false,
            untouchScreen = false,
            draggedTouch = false;
    int x1 = 0, x2 = 0, y1 = 0, y2 = 0, dx, dy;
    @Override
    public boolean keyDown (int keycode) {
        return false;
    }

    @Override
    public boolean keyUp (int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
        this.touchScreen = true;
        this.untouchScreen = false;
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        this.x2 = x;
        this.y2 = y;
        this.untouchScreen = true;
        this.touchScreen = false;
        this.draggedTouch = false;
        return false;
    }

    @Override
    public boolean touchDragged (int x, int y, int pointer) {
        this.dx = x - this.x2;
        this.dy = y - this.y2;
        this.x2 = x;
        this.y2 = y;
        this.draggedTouch = true;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }
}