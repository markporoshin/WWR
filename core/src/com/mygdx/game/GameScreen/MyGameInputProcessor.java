package com.mygdx.game.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.MainGameScreen;
import com.mygdx.game.MainMenuScreen;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Mark on 14.11.2016.
 */
public class MyGameInputProcessor implements InputProcessor {
   public static byte BottunState = 0;
   private MyGdxGame game;

    public MyGameInputProcessor(MyGdxGame game){
        this.game = game;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        if(GameSpriteRender.Right.touchDown(screenX, screenY)){
            BottunState = 2;
        }
        if(GameSpriteRender.Left.touchDown(screenX, screenY)){
            BottunState = 1;
        }

        if(GameSpriteRender.Pause.touchDown(screenX, screenY)){
            GameModelRender.gamePause = true;
        }
        if(GamePauseScreen.unPause.touchDown(screenX, screenY)){
            GameModelRender.gamePause = false;
        }

        if(GameModelRender.gameOver) {
            if(GameOverScreen.rePlay.touchDown(screenX, screenY)){
                game.GSR.init();
                game.GSpR.init();
                game.setScreen(new MainGameScreen(game));
            }
            if(GameOverScreen.exitGame.touchDown(screenX, screenY)){
                game.setScreen(new MainMenuScreen(game));
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(GameSpriteRender.Left.touchUp(screenX, screenY) || GameSpriteRender.Right.touchUp(screenX, screenY)){
            BottunState = 0;
        }

        GameSpriteRender.Pause.touchUp(screenX, screenY);
        GamePauseScreen.unPause.touchUp(screenX, screenY);
        GameOverScreen.rePlay.touchUp(screenX, screenY);
        GameOverScreen.exitGame.touchUp(screenX, screenY);




        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
