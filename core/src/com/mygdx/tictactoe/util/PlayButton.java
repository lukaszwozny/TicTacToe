package com.mygdx.tictactoe.util;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.tictactoe.Screens.GameScreen;

/**
 * Created by Senpai on 20.07.2016.
 */
public class PlayButton extends Button {

    private int gamePos;

    private GameScreen gameScreen;

    public PlayButton(GameScreen gameScreen, final IClickCallback callback){
        super(new ButtonStyle());

        this.gameScreen = gameScreen;

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                checkSpot();
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void checkSpot() {
        if(gameScreen.signArray.get(gamePos) == SignEnum.NONE){
            System.out.println("Yupi");
            gameScreen.signArray.set(gamePos, getPlayerSign());

        }
    }

    public void setgamePosition(int position){
        gamePos = position;
    }

    /*
    *
    * Gettees and setters
    *
    */

    public int getGamePosX() {
        return gamePos;
    }

    public SignEnum getPlayerSign() {
        switch(gameScreen.getTurnEnum()){
            case PLAYER_1:
                return SignEnum.CROSS;
            case PLAYER_2:
                return  SignEnum.CIRCLE;
        }
        return SignEnum.NONE;
    }
}
