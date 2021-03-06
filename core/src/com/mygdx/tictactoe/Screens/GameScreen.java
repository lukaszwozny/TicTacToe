package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.Service.ScreenManager;
import com.mygdx.tictactoe.TicTacToe;
import com.mygdx.tictactoe.util.*;

/**
 * Created by Senpai on 20.07.2016.
 */
public class GameScreen extends AbstractScreen {

    private final String BG_TEX_DIR = "img/bg/game_bg.png";
    private final String AGAIN_BTN_TEX_DIR = "img/button/again.png";
    private final String MENU_BTN_TEX_DIR = "img/button/menu.png";

    private Texture bgTexture;
    private Texture againButtonTexture;
    private Texture menuButtonTexture;

    private Array<PlayButton> playButtonArray;
    public Array<SignEnum> signArray;

    private TurnEnum turnEnum;
    private GameStatusEnum gameStaus = GameStatusEnum.IN_GAME;

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
        bgTexture = new Texture(Gdx.files.internal(BG_TEX_DIR));
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
        turnLabel.setText("Now plays: " + turnEnum + "\n" +
                "Game state:" + gameStaus);
    }

    @Override
    public void buildStage() {
        initLabel();
        initBackground();
        initMenuButton();
        initSignArray();
        initPlayButtons();
    }

    private void initMenuButton() {
        menuButtonTexture = new Texture(Gdx.files.internal(MENU_BTN_TEX_DIR));

        MainMenuButton menuButton = new MainMenuButton(menuButtonTexture, new IClickCallback() {
            @Override
            public void onClick() {
                ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_MENU);
            }
        });
        menuButton.setPosition(TicTacToe.WIDTH-menuButton.getWidth()-20,40);
        addActor(menuButton);
    }

    private void initAgainButton() {
        againButtonTexture = new Texture(Gdx.files.internal(AGAIN_BTN_TEX_DIR));

        MainMenuButton againButton = new MainMenuButton(againButtonTexture, new IClickCallback() {
            @Override
            public void onClick() {
                ScreenManager.getInstance().showScreen(ScreenEnum.GAME);
            }
        });
        againButton.setPosition(20,40);
        addActor(againButton);
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
                    gameStaus = checkGameStatus();
                    changePlayer();
                    endGame();
                }
            });
            newPlayButton.setSize(SIZE, SIZE);
            newPlayButton.setPosition(START_X + INTERVAL * (i % 3), START_Y - INTERVAL * (i / 3));
            newPlayButton.setgamePosition(i);
            playButtonArray.add(newPlayButton);
            addActor(newPlayButton);
        }
    }

    private void endGame() {
        if(gameStaus != GameStatusEnum.IN_GAME){
            initAgainButton();
        }
    }

    private GameStatusEnum checkGameStatus() {
        for (int i = 0; i < 3; i++) {
            int x = i * 3;
            int y = i;
            // Check horizontaly
            if (signArray.get(x) != SignEnum.NONE && signArray.get(x) == signArray.get(x + 1) && signArray.get(x) == signArray.get(x + 2)) {
                return turnEnum.gameStatusOnWin();
            }
            // Check veritical
            if (signArray.get(y) != SignEnum.NONE && signArray.get(y) == signArray.get(y + 3) && signArray.get(y) == signArray.get(y + 6)) {
                return turnEnum.gameStatusOnWin();
            }
        }
        // Check cross
        // Up-left to down-right
        if (signArray.get(0) != SignEnum.NONE && signArray.get(0) == signArray.get(4) && signArray.get(0) == signArray.get(8)) {
            return turnEnum.gameStatusOnWin();
        }
        // Up-right to down-left
        if (signArray.get(2) != SignEnum.NONE && signArray.get(2) == signArray.get(4) && signArray.get(2) == signArray.get(6)) {
            return turnEnum.gameStatusOnWin();
        }
        // Check draw
        for (SignEnum sign : signArray) {
            if (sign == SignEnum.NONE) {
                return GameStatusEnum.IN_GAME;
            }
        }
        return GameStatusEnum.DRAW;
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

    public GameStatusEnum getGameStaus() {
        return gameStaus;
    }
}
