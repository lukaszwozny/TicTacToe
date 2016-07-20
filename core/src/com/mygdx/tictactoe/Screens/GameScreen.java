package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.TicTacToe;
import com.mygdx.tictactoe.util.IClickCallback;
import com.mygdx.tictactoe.util.PlayButton;

/**
 * Created by Senpai on 20.07.2016.
 */
public class GameScreen extends AbstractScreen {

    private Texture bgTexture;
    private Array<PlayButton> playButtonArray;

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

        initPlayButtons();
    }

    private void initPlayButtons() {
        final int SIZE = 110;
        // Start positions
        final int START_X = 30;
        final int START_Y = 170;
        final int INTERVAL = SIZE + 20;

        playButtonArray = new Array<PlayButton>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                PlayButton newPlayButton = new PlayButton(new IClickCallback() {
                    @Override
                    public void onClick() {

                    }
                });
                newPlayButton.setSize(SIZE, SIZE);
                newPlayButton.setPosition(START_X + INTERVAL * i, START_Y + INTERVAL * j);
                newPlayButton.setgamePosition(i,j);
                newPlayButton.setDebug(true);
                playButtonArray.add(newPlayButton);
                addActor(newPlayButton);
            }
        }
    }


}
