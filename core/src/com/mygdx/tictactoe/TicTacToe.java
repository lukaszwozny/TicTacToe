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
import com.mygdx.tictactoe.Service.ScreenManager;

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
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_MENU);
	}

	@Override
	public void render () {
	}
	
	@Override
	public void dispose () {
	}
}
