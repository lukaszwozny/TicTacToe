package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.TicTacToe;
import com.mygdx.tictactoe.util.*;

/**
 * Created by Senpai on 20.07.2016.
 */
public class GameScreen extends AbstractScreen {

    private Texture bgTexture;

    private Array<PlayButton> playButtonArray;
    public Array<SignEnum> signArray;

    private TurnEnum turnEnum;

    private Label turnLabel;

    public GameScreen() {
        init();
    }

    private void init() {
        turnEnum = TurnEnum.PLAYER_1;
    }

    private void initLabel() {
        turnLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        turnLabel.setPosition(10, TicTacToe.HEiGHT - 30);
        addActor(turnLabel);
    }

    private void initBackground() {
        bgTexture = new Texture(Gdx.files.internal("img/bg/game_bg.png"));
        Image bgImage = new Image(bgTexture);
        bgImage.setPosition(0, TicTacToe.HEiGHT / 2 - bgImage.getWidth() / 2);
        addActor(bgImage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
    }

    private void update() {
        // TODO Change to display images instead PLAYER_! etc
        turnLabel.setText("Now plays: " + turnEnum);
    }

    @Override
    public void buildStage() {
        initLabel();
        initBackground();
        initSignArray();
        initPlayButtons();
    }

    private void initSignArray() {
        signArray = new Array<SignEnum>();
        for (int i = 0; i < 9; i++) {
            signArray.add(SignEnum.NONE);
        }

    }

    private void initPlayButtons() {
        final int SIZE = 110;
        // Start positions
        final int START_X = 30;
        final int START_Y = 430;
        final int INTERVAL = SIZE + 20;

        playButtonArray = new Array<PlayButton>();

        for (int i = 0; i < 9; i++) {
            PlayButton newPlayButton = new PlayButton(this, new IClickCallback() {
                @Override
                public void onClick() {
                    changePlayer();
                    checkGameStatus();
                }
            });
            newPlayButton.setSize(SIZE, SIZE);
            newPlayButton.setPosition(START_X + INTERVAL * (i % 3), START_Y - INTERVAL * (i / 3));
            newPlayButton.setgamePosition(i);
            newPlayButton.setDebug(true);
            playButtonArray.add(newPlayButton);
            addActor(newPlayButton);
        }
    }

    private void checkGameStatus() {
        for (int i = 0; i < 3; i++) {
            int x = i * 3;
            int y = i;
            // Check horizontaly
            if (signArray.get(x) != SignEnum.NONE && signArray.get(x) == signArray.get(x + 1) && signArray.get(x) == signArray.get(x + 2)) {
                return;
            }
            // Check veritical
            if (signArray.get(y) != SignEnum.NONE && signArray.get(y) == signArray.get(y + 3) && signArray.get(y) == signArray.get(y + 6)) {
                return;
            }
        }
        // Check cross
        // Up-left to down-right
        if (signArray.get(0) != SignEnum.NONE && signArray.get(0) == signArray.get(4) && signArray.get(0) == signArray.get(8)) {
            return;
        }
        // Up-right to down-left
        if (signArray.get(2) != SignEnum.NONE && signArray.get(2) == signArray.get(4) && signArray.get(2) == signArray.get(6)) {
            return;
        }
    }

    private void changePlayer() {
        if (turnEnum == TurnEnum.PLAYER_1) {
            turnEnum = TurnEnum.PLAYER_2;
        } else {
            turnEnum = TurnEnum.PLAYER_1;
        }
    }

    public TurnEnum getTurnEnum() {
        return turnEnum;
    }
}
