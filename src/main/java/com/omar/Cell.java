package com.omar;

public class Cell {
    private char display = '○';
    private Status state = Status.COVERED;
    private boolean mined = false; //TODO: Preguntar si es mejor meter los valores predeterminados aqui o en el Constructor

    public void click() {

    }

    public char getDisplay() {
        return display;
    }

    public Status getState() {
        return state;
    }
}
