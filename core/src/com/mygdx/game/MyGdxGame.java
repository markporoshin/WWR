package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

public class MyGdxGame extends Game {
	static public Place p;
	public ModelBatch modelBatch;
	public SpriteBatch spriteBatch;
	public BitmapFont font, levels;
	public int WIDTH = 720;
	public int HEIGHT = 480;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	@Override
	public void create () {
		InitThread t = new InitThread();
		modelBatch = new ModelBatch();
		spriteBatch  = new SpriteBatch();
		t.run();

		setFont();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
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
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Matreshka.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Gdx.graphics.getHeight() / 18; // Размер шрифта. Я сделал его исходя из размеров экрана. Правда коряво, но вы сами можете поиграться, как вам угодно.
		param.characters = FONT_CHARACTERS; // Наши символы
		font = generator.generateFont(param); // Генерируем шрифт
		param.size = Gdx.graphics.getHeight() / 20;
		levels = generator.generateFont(param);
		font.setColor(Color.WHITE); // Цвет белый
		levels.setColor(Color.WHITE);
		generator.dispose();
	}
}

class InitThread implements Runnable {
	Thread thread;
	// Конструктор
	InitThread() {
		// Создаём новый второй поток
		thread = new Thread(this);
		thread.start(); // Запускаем поток
	}

	// Обязательный метод для интерфейса Runnable
	public void run() {
		try {
			MyGdxGame.p = new Place();
		} catch (Exception e) {
			Gdx.app.log("Второй Поток","Прерван" + e);
		}
		Gdx.app.log("Второй Поток","Завершён");
	}
}
