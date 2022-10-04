package com.example.balls2;

public class State {

    private State parent;
    private int[][] board;
    private int button;

    public State(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            //this.arr[i] = Arrays.copyOf(arr[i],arr[i].length);
            //System.arraycopy(this.arr[i], 0, arr[i], 0, this.arr[i].length);
            for (int j = 0; j < board[i].length; ++j) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public State(State parent, int x, int y) {
        this.parent = parent;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.board[i][j] = parent.getBoard()[i][j];
            }
        }

        if (x == 0)
            if (y == 0)
                this.button = 0;
            else
                this.button = 1;
        else {
            if (y == 0)
                this.button = 2;
            else
                this.button = 3;
        }

        int temp1 = this.board[x][y];
        int temp2 = this.board[x][y + 1];
        int temp3 = this.board[x + 1][y];
        int temp4 = this.board[x + 1][y + 1];

        this.board[x][y] = temp3;
        this.board[x + 1][y] = temp4;
        this.board[x][y + 1] = temp1;
        this.board[x + 1][y + 1] = temp2;

    }

    public int getButton() {
        return button;
    }

    public int[][] getBoard() {
        return board;
    }

    public State getParent() {
        return parent;
    }
}
