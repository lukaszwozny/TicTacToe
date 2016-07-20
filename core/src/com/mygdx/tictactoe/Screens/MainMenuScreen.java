package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.tictactoe.Core.AbstractScreen;

/**
 * Created by Senpai on 20.07.2016.
 */
public class MainMenuScreen extends AbstractScreen {

    Texture bg;

    public MainMenuScreen(){
        super();
        bg = new Texture(Gdx.files.internal("img/bg/bg.png"));
    }

    @Override
    public void buildStage() {
        // Bacground texture
        Image bgImg = new Image(bg);
        addActor(bgImg);

        // Start/Exit buttons

    }
}
