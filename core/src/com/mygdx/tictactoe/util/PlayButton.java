package com.mygdx.tictactoe.util;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Senpai on 20.07.2016.
 */
public class PlayButton extends Button {

    private int gamePosX;
    private int gamePosY;

    public PlayButton(final IClickCallback callback){
        super(new ButtonStyle());

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void setgamePosition(int x, int y){
        gamePosX = x;
        gamePosY = y;
    }

    /*
    *
    * Gettees and setters
    *
    */

    public int getGamePosX() {
        return gamePosX;
    }

    public int getGamePosY() {
        return gamePosY;
    }
}
