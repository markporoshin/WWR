package com.mygdx.game.GameScreen;
/**
 * Created by Mark on 13.11.2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ObjectPackage.Object;


public class GameScreenRender {
    GameModelRender GMR;
    GameSpriteRender GSpR;
    GamePauseScreen GPS;
    GameOverScreen GOS;
    Command command;
    public static float  time;

    public static Preferences stat = Gdx.app.getPreferences("stat");
    public GameScreenRender() {
        command  = Command.GAMERENDER;
        GMR = new GameModelRender();
        GSpR = new GameSpriteRender();
        GPS = new GamePauseScreen();
        GOS = new GameOverScreen();
    }

    public void render(SpriteBatch sb, ModelBatch mb, Environment e, PerspectiveCamera cam, MyGdxGame game){

        switch (command){
            case GAMERENDER:
                time += Gdx.graphics.getDeltaTime();
                GMR.reshape(Gdx.graphics.getDeltaTime());
                GMR.check(game);
                GMR.render(mb, e, cam);
                command = GSpR.render(sb,GMR.gameOver,GMR.gamePause);
                Gdx.app.log("time GR","" + (int)time);
                break;

            case GAMEOVER:
                Gdx.app.log("time GO","" + (int)time);
                if(stat.getInteger("highScore") < (int)time)
                    stat.putInteger("highScore", (int)time);
                stat.flush();
                GMR.render(mb, e, cam);
                GOS.render(sb);
                break;

            case PAUSE:
                GMR.render(mb, e, cam);
                command = GPS.render(sb);
                break;
            default:
                break;
        }
    }

    public void init(){
        Gdx.app.log("time INIT","" + (int)time);
        time = 0;
        GMR.init();
        GSpR.init();
        command  = Command.GAMERENDER;
    }
}