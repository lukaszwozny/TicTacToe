package com.mygdx.tictactoe.util;

/**
 * Created by Senpai on 21.07.2016.
 */
public enum TurnEnum {
    PLAYER_1 {
        @Override
        public GameStatusEnum gameStatusOnWin() {
            return GameStatusEnum.WINS_X;
        }
    },
    PLAYER_2 {
        @Override
        public GameStatusEnum gameStatusOnWin() {
            return GameStatusEnum.WINS_O;
        }
    };
//    COMPUTER

    public abstract GameStatusEnum gameStatusOnWin();
}
