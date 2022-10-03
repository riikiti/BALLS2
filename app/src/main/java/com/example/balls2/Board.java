package com.example.balls2;

import android.widget.TextView;

public class Board {
    private int[][] board = new int[3][3];
    private boolean Status = false;


    public Board(int[][] board) {
        System.arraycopy(board, 0, this.board, 0, board.length);
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setBoard(int[][] board) {
         System.arraycopy(board, 0, this.board, 0, 9);
/*
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = board[i][j];
            }
        }
        */

    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Board Move(int i, int j) {

        int temp1 = this.board[i][j];
        int temp2 = this.board[i][j + 1];
        int temp3 = this.board[i + 1][j];
        int temp4 = this.board[i + 1][j + 1];

        this.board[i][j] = temp3;
        this.board[i + 1][j] = temp4;
        this.board[i][j + 1] = temp1;
        this.board[i + 1][j + 1] = temp2;
        return this;
        //вот тут может быть баг
    }

    public boolean Win() {
        if (this.board[0][1] == 1 && this.board[1][1] == 1 && this.board[2][1] == 1) {
            return true;
        }
        return false;
    }
}
