package com.omar;

import java.util.Random;

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
    private void setMines(int mines) {
        Random random = new Random();
        for (int i = 0; i < mines; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            field[x][y].setMined(true);
        }
    }

    /**
    * Gets the number of mined cells surrounding the given position
    * @return the number of mined cells surrounding the given position
    */
    private short getSurroundingMines(int cooX, int cooY) {
        short minedCells = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (cooX + x < 0 || cooY + y < 0 || cooX + x >= width || cooY + y >= height || x == 0 && y == 0) {
                    continue;
                }
                if (field[cooX + x][cooY + y].isMined()) {
                    minedCells++;
                }
            }
        }

        return minedCells;
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