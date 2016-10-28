package com.mygdx.game;

/**
 * Created by Mark on 22.10.2016.
 */
public class Place{
    Water W, W1;
    Beach B, B1;
    public Place(){
        W = new Water();
        W1 = new Water();
        W1.x = 1.70f *(2 * W.sizei + 1)  * W.size;
        B = new Beach();
        B1 = new Beach();
        B1.x = 2 * (2 * W.sizej + 1)* W.size;
        B1.z = 10;
    }

    public void upData(boolean touchScreen,
                       boolean untouchScreen,
                       boolean draggedTouch,
                       int x1, int x2, int y1, int y2, int dx, int dy){

        up();
        W.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        W1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        B.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        B1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);

    }

    public void up(){
        if(W.x < 1.65f * 1.70f *(2 * W.sizei + 1)  * W.size)
            W.x += 0.2f;
        else
            W.x = 0f;
        //if(B.x < (2 * W.sizei - 2)  * W.size)
        //    B.x += 0.01f;
        //else
        //    B.x = 0f;

        if(W1.x < 1.65f * 1.70f *(2 * W.sizei + 1)  * W.size)
            W1.x += 0.2f;
        else
            W1.x = 0;
        //if(B1.x < (2 * W.sizei - 2)  * W.size)
        //    B1.x += 0.01f;
        //else
        //    B1.x = 0f;
    }
}
