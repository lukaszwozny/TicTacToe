package com.mygdx.tictactoe.Service;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.TicTacToe;
import com.mygdx.tictactoe.util.ScreenEnum;

/**
 * Created by Senpai on 20.07.2016.
 */
public class ScreenManager {

    private static ScreenManager instance;

    private Game game;

    private ScreenManager(){
        super();
    }

    public static ScreenManager getInstance() {
        if(instance == null){
            instance = new ScreenManager();
        }
        return instance;
    }

    public void initialize(Game game){
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum, Object... params){

        // Get current screen to dispose it
        Screen curentScreen = game.getScreen();

        // Show new Screen
        AbstractScreen newScreen = screenEnum.getScreen(params);
        newScreen.buildStage();
        game.setScreen(newScreen);

        // Dispose old screen
        if(curentScreen!=null){
            curentScreen.dispose();
        }

    }
}
