package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Mark on 22.10.2016.
 */
public class Place{
    Water W, W1;//water
    Beach LB, LB1;//left beach
    Beach RB, RB1;//right beach
    Runner R;
    public Place(){
        W = new Water();
        W.x = W.width;
        W1 = new Water();
        W1.x = 0;

        LB = new Beach();
        LB.x = LB.width;
        LB.y = (W.height + LB.height) / 2;
        LB1 = new Beach();
        LB1.x = 0;
        LB1.y = (W.height + LB.height) / 2;

        RB = new Beach();
        RB.x = RB.width;
        RB.y = -(W.height + RB.height) / 2;
        RB1 = new Beach();
        RB1.x = 0;
        RB1.y = -(W.height + RB1.height) / 2;
        R = new Runner();
    }
    public void upData(boolean touchScreen,
                       boolean untouchScreen,
                       boolean draggedTouch,
                       int x1, int x2, int y1, int y2, int dx, int dy){
        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {

            }
        });
        up();
        W.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        W1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        LB.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        LB1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        RB.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        RB1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
    }
    public void up(){
        if(W.x < 2 * W.width - 0.5f)
            W.x += 0.3f;
        else
            W.x = 0f;
        if(W1.x < 2 * W.width - 0.5f)
            W1.x += 0.3f;
        else
            W1.x = 0;
        if(LB.x < 2 * LB.width - 0.3f)
            LB.x += 0.2f;
        else
            LB.x = 0f;
        if(LB1.x < 2 * LB1.width - 0.3f)
            LB1.x += 0.2f;
        else
            LB1.x = 0;


        if(RB.x < 2 * RB.width - 0.3f)
            RB.x += 0.2f;
        else
            RB.x = 0f;
        if(RB1.x < 2 * RB1.width - 0.3f)
            RB1.x += 0.2f;
        else
            RB1.x = 0;
    }
    /*Water W, W1;
    Beach B, B1;
    public Place(){
        W = new Water();
        W.x = 0;
        W.z = -W.size;

        W1 = new Water();
        W1.x = W.size * W.sizej;
        W1.z = -W.size;

        B = new Beach();
        B.x = B.size * B.sizej;
        B.z = 0;

        B1 = new Beach();
        B1.x = 2 *B.size * B.sizej;
        B1.z = 0;
    }

    public void upData(boolean touchScreen,
                       boolean untouchScreen,
                       boolean draggedTouch,
                       int x1, int x2, int y1, int y2, int dx, int dy){

        //up();
        W.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        W1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        B.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);
        B1.updata(touchScreen, untouchScreen, draggedTouch, x1, x2, y1, y2, dx, dy);

    }

    public void up(){
        if(W.x < 2 * W.size * W.sizej-0.2f)
            W.x += 0.2f;
        else
            W.x = 0f;
        if(W1.x < 2 * W1.size * W1.sizej - 0.1f)
            W1.x += 0.2f;
        else
            W1.x = 0;

        if(B.x < 3 * B.size * B.sizej)
            B.x += 0.1f;
        else
            B.x = W1.size * W1.sizej;
        if(B1.x < 3 * B1.size * B1.sizej)
            B1.x += 0.1f;
        else
            B1.x = W1.size * W1.sizej;
    }*/
}
