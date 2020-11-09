package com.omar;

public class Display {

    Board board;

    public Display(Board board) {
        this.board = board;
    }

    public void update(Board board) {
        this.board = board;
    }

    /**
     * Draws the board on the screen
     */
    public void draw() {
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                switch (board.getCell(i, j).getState()) {
                    case FLAGGED:
                        System.out.println("◘");
                        break;
                    case COVERED:
                        System.out.println("■");
                        break;
                    case UNCOVERED:
                        //TODO -- Board: CalculateSurrounding
                        System.out.println("Result Surrounding");
                        break;

                }
            }
        }
    }

}
