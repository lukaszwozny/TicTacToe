package com.mygdx.tictactoe.Core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.tictactoe.TicTacToe;
import javafx.scene.Scene;

/**
 * Created by Senpai on 19.07.2016.
 */
public abstract class AbstractScreen extends Stage implements Screen {

    protected AbstractScreen(){
        super(new StretchViewport(TicTacToe.WIDTH,TicTacToe.HEiGHT,new OrthographicCamera()));
    }

    public abstract void buildStage();

    @Override
    public void render(float delta) {
        //Clear screen
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.act(delta);
        super.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
