package com.mygdx.game;

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

/**
 * Created by Mark on 14.11.2016.
 */
public class GameSpriteRender {
    public static Sprite lbottuns, rbottuns;
    public static int scl = 2;
    private Label label;
    private BitmapFont font;
    private Stage stage;
    private long startTime;
    public GameSpriteRender(){
        lbottuns = new Sprite(new Texture(Gdx.files.internal("image/left.png")));
        lbottuns.setPosition(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 - lbottuns.getRegionHeight() / 2);
        lbottuns.scale(scl);

        rbottuns = new Sprite(new Texture(Gdx.files.internal("image/right.png")));
        rbottuns.setPosition(7 * Gdx.graphics.getWidth() / 8 - rbottuns.getRegionWidth(), Gdx.graphics.getHeight() / 8 - rbottuns.getRegionHeight() / 2);
        rbottuns.scale(scl);

        font = new BitmapFont();
        label = new Label(" ", new Label.LabelStyle(font, Color.WHITE));
        label.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 20);

        stage = new Stage();
        startTime = System.currentTimeMillis();
        stage.addActor(label);

    }

    public void render(SpriteBatch batch){
        StringBuilder builder = new StringBuilder();
        builder.append(" FPS: ").append(Gdx.graphics.getFramesPerSecond());
        long time = System.currentTimeMillis() - startTime;
        builder.append("| Game time: ").append(time);
        label.setText(builder);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        batch.begin();
        lbottuns.draw(batch);
        rbottuns.draw(batch);
        batch.end();
    }
    public void dispose(){
        ;
    }
}
