package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Button;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Mark on 18.11.2016.
 */
public class GamePauseScreen {
    public static Button unPause;
    public GamePauseScreen(){
        unPause = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/play.png"))), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    public Command render(SpriteBatch batch){
        batch.begin();
        unPause.draw(batch);
        batch.end();
        if(GameModelRender.gamePause == false){
            return Command.GAMERENDER;
        }
        return  Command.PAUSE;
    }
    public void dispose(){
        ;
    }
}
