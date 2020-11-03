package com.omar;

public class Board {
    private final int width;
    private final int height;
    private final Cell field[][];

    public Board(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.field = new Cell[width][height];
    }

    /**
     * Fills the board with the specified number of mines in random positions
     * @param mines the number of mines that the board will contain
     */
    private static void fill(int mines) {
        //TODO
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void clickCell(int x, int y, Cell c) {
        this.field[x][y].click();
    }

    public void flagCell(int x, int y) {
        this.field[x][y].flag();
    }

    public Cell getCell(int x, int y) {
        return this.field[x][y];
    }
}