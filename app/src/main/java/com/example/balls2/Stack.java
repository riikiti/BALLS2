package com.example.balls2;

public class Stack {

    private int mSize; //mSize - максимальный размер
    private Board [] stackArray;
    private int top;



    public Stack(int m) {
        this.mSize = m;
        stackArray = new Board[mSize];
        top = -1;
    }
    public void addElement(Board element) {
        stackArray[++top] = element;
    }

    public Board deleteElement() {
        return stackArray[top--];
    }
    public Board readTop() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == mSize - 1);
    }
}

