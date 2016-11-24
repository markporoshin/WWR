package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Mark on 19.11.2016.
 */
public class Button {
    public float x, y;
    public Sprite s;
    public float  scl;
    public boolean stateDown = false, stateUp = false, stateWait  = false;
    public Button(Sprite s, int x, int y){
        this.s = s;
        this.x = x;
        this.y = y;
        this.scl =  Gdx.graphics.getHeight() / 12.0f / this.s.getHeight();
        this.s.scale(scl);
        this.s.setPosition(this.x - this.s.getWidth()/2, this.y - this.s.getHeight()/2);
        this.s.setOrigin(this.s.getWidth()/2,this.s.getHeight()/2);
    }

    public void setScl(float scl){
        this.scl =  Gdx.graphics.getHeight() / scl / this.s.getHeight();
    }

    public void draw(SpriteBatch sb){
        s.draw(sb);
    }

    public void init(){
        stateDown = false;
        stateUp = false;
        stateWait = false;
    }
    public boolean touchDown(int screenX, int screenY){
        if(screenX < x + this.s.getWidth() / 2 && screenX > x -this.s.getWidth() / 2 &&
                Gdx.graphics.getHeight() - screenY < y + this.s.getHeight() / 2  && Gdx.graphics.getHeight() - screenY > y - this.s.getHeight() / 2) {
            stateDown = true;
            stateUp = false;
            stateWait = true;
            return  true;
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY){
        if(Gdx.graphics.getWidth() - screenX < x + this.s.getWidth() / 2 && Gdx.graphics.getWidth() - screenX > x -this.s.getWidth() / 2 &&
                Gdx.graphics.getHeight() - screenY < y + this.s.getHeight() / 2  && Gdx.graphics.getHeight() - screenY > y - this.s.getHeight() / 2) {
            stateUp = true;
            stateDown = false;
            stateWait = false;
            return true;
        }
        return false;
    }

    public boolean getTouch(){ return stateDown; }
    public boolean getWait(){ return stateWait; }
    public boolean getUp(){ return stateUp; }
}
