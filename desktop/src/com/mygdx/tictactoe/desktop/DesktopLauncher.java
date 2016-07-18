package com.mygdx.tictactoe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.tictactoe.TicTacToe;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = TicTacToe.TITLE;
		config.width = TicTacToe.WIDTH;
		config.height = TicTacToe.HEiGHT;
		config.resizable = false;

		new LwjglApplication(new TicTacToe(), config);
	}
}
