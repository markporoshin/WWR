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
import com.mygdx.game.MyGdxGame;

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
        Pause = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/pause.png"))),Gdx.graphics.getWidth() / 10, 7 * Gdx.graphics.getHeight() / 8);
        Pause.setScl(18);
        Left = new Button(new Sprite(new Texture(Gdx.files.internal("image/left.png"))), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
        Right = new Button(new Sprite(new Texture(Gdx.files.internal("image/right.png"))), 7 * Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
    }
    public void init(){
        Left.init();
        Right.init();
        MyGameInputProcessor.BottunState = 0;
    }
    public Command render(SpriteBatch batch, boolean gameOver, boolean gamePause){
        batch.begin();
        //MyGdxGame.font.draw(batch,"" + GameScreenRender.stat.getInteger("highScore", 0), 4 * Gdx.graphics.getWidth() / 10, 7 * Gdx.graphics.getHeight() / 8);
        MyGdxGame.font.draw(batch,"" + (int)GameScreenRender.time, 9 * Gdx.graphics.getWidth() / 10, 7 * Gdx.graphics.getHeight() / 8);
        Pause.draw(batch);
        Left.draw(batch);
        Right.draw(batch);
        batch.end();
        if(gameOver){
            return Command.GAMEOVER;
        }else if(gamePause){
            return Command.PAUSE;
        }
        return Command.GAMERENDER;

    }
    public void dispose(){
        ;
    }
}
