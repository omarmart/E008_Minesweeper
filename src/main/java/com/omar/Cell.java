package com.omar;

public class Cell {
    private Status state = Status.COVERED;
    private boolean mined = false;

    public void click() {
        state = Status.UNCOVERED;
    }

    public void flag() {
        state = Status.FLAGGED;
    }

    public Status getState() {
        return state;
    }
}
