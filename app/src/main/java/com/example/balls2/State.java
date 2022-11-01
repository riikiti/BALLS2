package com.example.balls2;

public class State implements Comparable<State> {

    private State parent;
    private int[][] board = new int[3][3];
    private int button;

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    private int F;

    public State(int[][] board) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.board[i][j] = board[i][j];
            }
        }}

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
    public void setButton(int button) {
      this.button = button;
    }

    public int[][] getBoard() {
        return board;
    }

    public State getParent() {
        return parent;
    }

    @Override
    public int compareTo(State state) {
        int compareQuantity = ((State) state).getF();

        //ascending order
        return this.F - compareQuantity;
    }
}
