package com.omar;

public class Cell {
    private Status state = Status.COVERED;
    private boolean mined = false;

    public void click() {
        state = Status.UNCOVERED;
    }

    public Status getState() {
        return state;
    }
}
