package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Button;

/**
 * Created by Mark on 19.11.2016.
 */
public class GameOverScreen {
    static Button rePlay, exitGame;
    public GameOverScreen(){
        rePlay = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/replay.png"))),(int)(2.5f * Gdx.graphics.getWidth() / 6), Gdx.graphics.getHeight() / 2);
        exitGame  = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/exit.png"))), (int)(3.5f * Gdx.graphics.getWidth() / 6), Gdx.graphics.getHeight() / 2);
    }

    public void render(SpriteBatch sb){
        rePlay.draw(sb);
        exitGame.draw(sb);
    }
}
