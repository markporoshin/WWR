package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.mygdx.game.ObjectPackage.BaseModel;

public class MyGdxGame extends Game{

	public ModelBatch modelBatch;
	public SpriteBatch spriteBatch;
	public static BitmapFont font, levels;
	public com.mygdx.game.GameScreen.GameScreenRender GSR;
	public com.mygdx.game.GameScreen.GameSpriteRender GSpR;
	public int WIDTH = 1080;
	public int HEIGHT = 720;
	private boolean flag = true;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	@Override
	public void create () {
		modelBatch = new ModelBatch();
		spriteBatch  = new SpriteBatch();
		setFont();
		/*Start s = new Start();
		Thread Init = new Thread(s);
		Init.start();
		while(flag){}*/

		this.setScreen(new MainMenuScreen(this));
		BaseModel baseModel = new BaseModel();
		GSpR = new com.mygdx.game.GameScreen.GameSpriteRender();
		GSR = new com.mygdx.game.GameScreen.GameScreenRender();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor( 0.0627f, 0.474f, 0.588f, 1);
		super.render();
	}

	@Override
	public void dispose () {
		modelBatch.dispose();
		spriteBatch.dispose();
		//ground.dispose();
	}

	public void setFont()
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Gdx.graphics.getHeight() / 10; // Размер шрифта. Я сделал его исходя из размеров экрана. Правда коряво, но вы сами можете поиграться, как вам угодно.
		param.characters = FONT_CHARACTERS; // Наши символы
		font = generator.generateFont(param); // Генерируем шрифт
		param.size = Gdx.graphics.getHeight() / 20;
		levels = generator.generateFont(param);
		font.setColor(Color.WHITE); // Цвет белый
		levels.setColor(Color.WHITE);
		generator.dispose();
	}

	class Start implements Runnable{
		@Override
		public void run() {
			Gdx.app.log("Новый поток", "Начат");

			Gdx.app.log("Новый поток", "Закончен");
			flag = false;
		}
	}
}
