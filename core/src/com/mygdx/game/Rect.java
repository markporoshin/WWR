package com.mygdx.game;

/**
 * Created by Mark on 14.11.2016.
 */
public class Rect {
    float width, height;//rad
    float x, y;//mid
    Rect(float x, float y,float width, float height)
    {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    boolean Intersects(Rect r2){
        if(this.x-this.width > (r2.x+r2.width) || this.x+this.width < r2.x-r2.width ||
                this.y-this.height > (r2.y+r2.height) || this.y+this.height < r2.y-r2.height ) return false;
        return true;
    }
}
