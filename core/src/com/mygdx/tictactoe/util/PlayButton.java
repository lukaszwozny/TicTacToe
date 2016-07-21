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

    public PlayButton(final GameScreen gameScreen, final IClickCallback callback){
        super(new ButtonStyle());

        this.gameScreen = gameScreen;

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(gameScreen.getGameStaus() == GameStatusEnum.IN_GAME){
                    checkSpot();
                    callback.onClick();
                }
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void checkSpot() {
        if(gameScreen.signArray.get(gamePos) == SignEnum.NONE){
            gameScreen.signArray.set(gamePos, getPlayerSign());
            SignImage signImage = new SignImage();
            signImage.setTexture(gameScreen.getTurnEnum(), gamePos);
            gameScreen.addActor(signImage);

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

    public SignEnum getPlayerSign() {
        return gameScreen.getTurnEnum().signEnum();
    }
}
