package com.mygdx.tictactoe.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tictactoe.Screens.GameScreen;

/**
 * Created by Senpai on 21.07.2016.
 */
public class SignImage extends Image {
    private final String CROSS1_TEX_DIR = "img/xs_and_os/x_1.png";
    private final String CROSS2_TEX_DIR = "img/xs_and_os/x_2.png";
    private final String CROSS3_TEX_DIR = "img/xs_and_os/x_3.png";
    private final String CIRCLE1_TEX_DIR = "img/xs_and_os/o_1.png";
    private final String CIRCLE2_TEX_DIR = "img/xs_and_os/o_2.png";
    private final String CIRCLE3_TEX_DIR = "img/xs_and_os/o_3.png";
    //private final String NONE_TEX_DIR = "img/xs_and_os/none.png";


    private Texture crossTexture1;
    private Texture crossTexture2;
    private Texture crossTexture3;
    private Texture circleTexture1;
    private Texture circleTexture2;
    private Texture circleTexture3;
    //private  Texture noneTexture;

    private Array<String> crossTexDirArray;
    private Array<String> circleTexDirArray;

    public SignImage() {
        super();
        initTexture();
    }

    private void initTexture() {
        crossTexDirArray = new Array<String>();
        crossTexDirArray.add(CROSS1_TEX_DIR);
        crossTexDirArray.add(CROSS2_TEX_DIR);
        crossTexDirArray.add(CROSS3_TEX_DIR);

        circleTexDirArray = new Array<String>();
        circleTexDirArray.add(CIRCLE1_TEX_DIR);
        circleTexDirArray.add(CIRCLE2_TEX_DIR);
        circleTexDirArray.add(CIRCLE3_TEX_DIR);
    }

    public void setTexture(TurnEnum turn, int gamePos) {
        Texture newTexture;
        int rand = MathUtils.random(0, 2);
        switch (turn) {
            case PLAYER_1:
                this.setWidth(124);
                this.setHeight(109);
                newTexture = new Texture(crossTexDirArray.get(rand));
                this.setDrawable(new SpriteDrawable(new Sprite(newTexture)));
                break;
            case PLAYER_2:
                this.setWidth(124);
                this.setHeight(109);
                newTexture = new Texture(circleTexDirArray.get(rand));
                this.setDrawable(new SpriteDrawable(new Sprite(newTexture)));
                break;
        }
        setNewPosition(gamePos);
    }

    private void setNewPosition(int gamePos) {
        final int START_X = 30;
        final int START_Y = 430;
        final int INTERVAL_X = 124;
        final int INTERVAL_Y = 109 + 20;

        this.setPosition(START_X + INTERVAL_X * (gamePos % 3), START_Y - INTERVAL_Y * (gamePos / 3));
    }
}
