package com.example.balls2;

import android.widget.TextView;

import java.util.Stack;

public class Board {

    public int[][] board = {{0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},};


    public int[][] getBoard() {
        return board;
    }

    public Board(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            //this.arr[i] = Arrays.copyOf(arr[i],arr[i].length);
            //System.arraycopy(this.arr[i], 0, arr[i], 0, this.arr[i].length);
            for (int j = 0; j < board[i].length; ++j) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public void setBoard(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            //this.arr[i] = Arrays.copyOf(arr[i],arr[i].length);
            //System.arraycopy(this.arr[i], 0, arr[i], 0, this.arr[i].length);
            for (int j = 0; j < board[i].length; ++j) {
                this.board[i][j] = board[i][j];
            }
        }
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
        if (this.board[0][0] == 1 && this.board[1][1] == 1 && this.board[2][2] == 1) {
            return true;
        }
        return false;
    }
// 01 11 12


}
