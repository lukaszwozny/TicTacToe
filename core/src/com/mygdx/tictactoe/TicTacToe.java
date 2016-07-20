package com.mygdx.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.Screens.GameScreen;
import com.mygdx.tictactoe.Screens.LevelSelectScreen;
import com.mygdx.tictactoe.Screens.MainMenuScreen;

public class TicTacToe extends Game {
	public enum ScreenEnum{

		MAIN_MENU{
			@Override
			public AbstractScreen getScreen(Object... params){
				return new MainMenuScreen();
			}
		},

		LEVEL_SELECT{
			@Override
			public AbstractScreen getScreen(Object... params){
				return new LevelSelectScreen();
			}
		},

		GAME{
			@Override
			public AbstractScreen getScreen(Object... params) {
				return new GameScreen((Integer) params[0]);
			}
		};

		public abstract AbstractScreen getScreen(Object... params);
	}

	public static final String TITLE = "TicTacToe";

	public static final int WIDTH = 405;
	public static final int HEiGHT = 720;

	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
