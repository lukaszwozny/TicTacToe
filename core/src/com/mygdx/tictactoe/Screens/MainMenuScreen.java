package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.tictactoe.Core.AbstractScreen;
import com.mygdx.tictactoe.Service.ScreenManager;
import com.mygdx.tictactoe.TicTacToe;
import com.mygdx.tictactoe.util.IClickCallback;
import com.mygdx.tictactoe.util.MainMenuButton;
import com.mygdx.tictactoe.util.ScreenEnum;

/**
 * Created by Senpai on 20.07.2016.
 */
public class MainMenuScreen extends AbstractScreen {

    Texture bgTexture;
    Texture playButtonTexture;
    Texture exitButtonTexture;

    public MainMenuScreen() {
        super();
        loadTextures();
    }

    private void loadTextures() {
        bgTexture = new Texture(Gdx.files.internal("img/bg/bg.png"));
        playButtonTexture = new Texture(Gdx.files.internal("img/button/play.png"));
        exitButtonTexture = new Texture(Gdx.files.internal("img/button/exit.png"));
    }

    @Override
    public void buildStage() {
        // Bacground texture
        Image bgImg = new Image(bgTexture);
        addActor(bgImg);

        // Start/Exit buttons
        final int START_X = TicTacToe.WIDTH / 2 - playButtonTexture.getWidth()/2;
        final int START_y = TicTacToe.HEiGHT - 250;
        final int INTERVAL = playButtonTexture.getHeight() + 40;
        MainMenuButton playButton = new MainMenuButton(playButtonTexture, new IClickCallback() {
            @Override
            public void onClick() {
                ScreenManager.getInstance().showScreen(ScreenEnum.GAME);
            }
        });
        playButton.setPosition(START_X,START_y);
        addActor(playButton);
    }
}
