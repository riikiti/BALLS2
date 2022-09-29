package com.example.balls2;

public class Board {
    private int[][] board;
    private boolean Status = false;

    public Board(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Board Move(int i, int j, int[][] board) {

        int temp1 = this.board[i][j];
        int temp2 = this.board[i][j + 1];
        int temp3 = this.board[i + 1][j];
        int temp4 = this.board[i + 1][j + 1];

        this.board[i][j] = temp3;
        this.board[i + 1][j] = temp4;
        this.board[i][j + 1] = temp1;
        this.board[i + 1][j + 1] = temp2;

        return Board.this;
        //вот тут может быть баг
    }

    public boolean Win() {
        if (this.board[0][1] == 1 && this.board[1][1] == 1 && this.board[2][1] == 1) {
            return true;
        }
        return false;
    }
}
