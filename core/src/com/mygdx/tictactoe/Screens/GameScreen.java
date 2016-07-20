package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.TicTacToe;

/**
 * Created by Senpai on 20.07.2016.
 */
public class GameScreen extends AbstractScreen {

    Texture bgTexture;

    public GameScreen() {
        initTexture();
    }

    private void initTexture() {
        bgTexture = new Texture(Gdx.files.internal("img/bg/game_bg.png"));
    }

    @Override
    public void buildStage() {
        Image bgbImage = new Image(bgTexture);
        bgbImage.setPosition(0, TicTacToe.HEiGHT / 2 - bgbImage.getWidth() / 2);
        addActor(bgbImage);
    }


}
