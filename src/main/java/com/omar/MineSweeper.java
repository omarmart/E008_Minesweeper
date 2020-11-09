package com.omar;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

        Set<Coordinates> coordinates = calcRandomCoordinates(width, heigth, mines);

        this.board = new Board(width, heigth, coordinates);
    }

    /**
    * Returns a set of random positions inside the given limits
    * @param maxWidth the limit of the x position
    * @param maxHeight the limit of the y position
    * @param total the number of random positions that will be returned
    * @return
    */
    private Set<Coordinates> calcRandomCoordinates(int maxWidth, int maxHeight, int total) {
        Set<Coordinates> coordinates = new HashSet<Coordinates>();

        Random random = new Random();

        int i = 0;
        while (i < total) {
            int x = random.nextInt(maxWidth);
            int y = random.nextInt(maxHeight);

            if (coordinates.add(new Coordinates(x, y))) {
                i++;
            }
        }

        return coordinates;

    }

    private Coordinates getRandomCoordinate(int maxWidth, int maxHeight) {
        Random random = new Random();
        return new Coordinates(random.nextInt(maxWidth), random.nextInt(maxHeight));
    }

    //TODO:
    //Meter aqui el check surrounding y pasarle los numeros al display
}
