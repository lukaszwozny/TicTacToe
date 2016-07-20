package com.mygdx.tictactoe.util;

import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.Screens.GameScreen;
import com.mygdx.tictactoe.Screens.LevelSelectScreen;
import com.mygdx.tictactoe.Screens.MainMenuScreen;

/**
 * Created by Senpai on 20.07.2016.
 */
public enum ScreenEnum {
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
            return new GameScreen();
        }
    };

    public abstract AbstractScreen getScreen(Object... params);
}
