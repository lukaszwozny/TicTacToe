package com.mygdx.tictactoe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.tictactoe.Core.AbstractScreen;

/**
 * Created by Senpai on 20.07.2016.
 */
public class MainMenuScreen extends AbstractScreen {

    Texture logo;

    public MainMenuScreen(){
        super();
        logo = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    @Override
    public void buildStage() {

        Image logoImg = new Image(logo);
        addActor(logoImg);
    }
}
