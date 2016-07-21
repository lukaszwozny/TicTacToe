package com.mygdx.tictactoe.util;

/**
 * Created by Senpai on 21.07.2016.
 */
public enum TurnEnum {
    PLAYER_1 {
        @Override
        public SignEnum signEnum() {
            return SignEnum.CROSS;
        }

        @Override
        public GameStatusEnum gameStatusOnWin() {
            return GameStatusEnum.WINS_X;
        }
    },
    PLAYER_2 {
        @Override
        public SignEnum signEnum() {
            return SignEnum.CIRCLE;
        }

        @Override
        public GameStatusEnum gameStatusOnWin() {
            return GameStatusEnum.WINS_O;
        }
    };
//    COMPUTER

    public abstract SignEnum signEnum();
    public abstract GameStatusEnum gameStatusOnWin();
}
