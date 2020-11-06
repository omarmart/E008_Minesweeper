package com.omar;

public class MineSweeper {
    private Board board;
    private Coordinates display;

    /**
     * Creates a game with the given width, height, and mines
     * @param width The width of the simulation
     * @param height The height of the simulation
     * @param mines The number of mines
     */
    public MineSweeper(int width, int heigth, int mines) {
        if (mines > (width * heigth)) {
            System.out.println("There can't be more mines than cells on the board");
            return;
        }

        //this.board = new Board(width, heigth, mines);
    }
    //TODO:
    //Meter aqui el check surrounding y pasarle los numeros al display
}
