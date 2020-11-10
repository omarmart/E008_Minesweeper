package com.omar;

import java.util.Set;

public class Board {
    private final int width;
    private final int height;
    private final Cell field[][];

    public Board(int width, int height, Set<Coordinates> minedPositions) {
        this.width = width;
        this.height = height;
        this.field = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Coordinates position = new Coordinates(x, y);
                field[x][y] = new Cell(minedPositions.contains(position));
            }
        }
    }

    /**
     * 
     * Gets the number of mined cells surrounding the given position
     * @param cooX The x position of the cell that is going to be checked
     * @param cooY The y position of the cell that is going to be checked
     * @return the number of mined cells surrounding the given position
     */
    public short getSurroundingMines(int cooX, int cooY) {
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

    public void clickCell(int cooX, int cooY) {
        this.field[cooX][cooY].click();
        revealSurrounding(cooX, cooY);
    }

    private void revealSurrounding(int cooX, int cooY) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (cooX + x < 0 || cooY + y < 0 || cooX + x >= width || cooY + y >= height || x == 0 && y == 0) {
                    continue;
                }
                if (getSurroundingMines(cooX + x, cooY + y) == 0
                        && getCell(cooX + x, cooY + y).getState() == Status.COVERED) {
                    clickCell(cooX + x, cooY + y);
                }
            }
        }
    }

    public void flagCell(int x, int y) {
        this.field[x][y].flag();
        //TODO
        //if flagged , deflag, if uncovered, do nothing
    }

    public void mineCell(int x, int y) {
        this.field[x][y].setMined(true);
    }

    public Cell getCell(int x, int y) {
        return this.field[x][y];
    }
}