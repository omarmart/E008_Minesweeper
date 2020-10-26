package com.omar;

public class MineSweeper {
    private Board board;

    /**
     * Creates a game with the given width, height, and mines
     * @param width The width of the simulation
     * @param height The height of the simulation
     * @param mines The number of mines
     */
    public MineSweeper(int width, int heigth, int mines) {
        this.board = new Board(width, heigth, mines);
    }
}
