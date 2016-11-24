package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Button;

/**
 * Created by Mark on 14.11.2016.
 */
public class GameSpriteRender {
    public static Button Left, Right, Pause;
    GameOverScreen GOS;
    GamePauseScreen GPS;
    public GameSpriteRender(){
        GPS = new GamePauseScreen();
        GOS = new GameOverScreen();
        Pause = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/pause.png"))), Gdx.graphics.getWidth() / 10, 7 * Gdx.graphics.getHeight() / 8);
        Pause.setScl(18);
        Left = new Button(new Sprite(new Texture(Gdx.files.internal("image/left.png"))), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
        Right = new Button(new Sprite(new Texture(Gdx.files.internal("image/right.png"))), 7 * Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
    }
    public void init(){
        Left.init();
        Right.init();
        MyGameInputProcessor.BottunState = 0;
    }
    public void render(SpriteBatch batch, boolean gameOver, boolean gamePause){
        batch.begin();
        Left.draw(batch);
        Right.draw(batch);
        Pause.draw(batch);
        if(gameOver){
            GOS.render(batch);
        }else if(gamePause){
            GPS.render(batch);
        }
        batch.end();
    }
    public void dispose(){
        ;
    }
}
