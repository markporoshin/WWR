package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Button;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Mark on 19.11.2016.
 */
public class GameOverScreen {
    static Button rePlay, exitGame, rec;
    public GameOverScreen(){

        rePlay = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/replay.png"))),(int)(2.5f * Gdx.graphics.getWidth() / 6), Gdx.graphics.getHeight() / 2);
        exitGame  = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/exit.png"))), (int)(3.5f * Gdx.graphics.getWidth() / 6), Gdx.graphics.getHeight() / 2);
        rec  = new Button(new Sprite(new Texture(Gdx.files.internal("image/menu/fonbut.png"))), Gdx.graphics.getWidth() / 2,2 * Gdx.graphics.getHeight() / 8);
    }

    public void render(SpriteBatch sb){
        sb.begin();
        rePlay.draw(sb);
        exitGame.draw(sb);
        rec.draw(sb);
        MyGdxGame.font.draw(sb, "" + GameScreenRender.stat.getInteger("highScore", 0),3.5f * Gdx.graphics.getWidth() / 6 - MyGdxGame.font.getSpaceWidth()/2 * GameScreenRender.stat.getInteger("highScore", 0) / 10, 2 * Gdx.graphics.getHeight() / 8 + MyGdxGame.font.getLineHeight() / 4);
        sb.end();
    }
}
