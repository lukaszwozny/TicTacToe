package com.mygdx.tictactoe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tictactoe.Service.ScreenManager;
import com.mygdx.tictactoe.util.ScreenEnum;

public class TicTacToe extends Game {

	public static final String TITLE = "TicTacToe";

	public static final int WIDTH = 405;
	public static final int HEiGHT = 720;

	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		System.out.println("Create");
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_MENU);
	}
}
