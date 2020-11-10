package com.omar;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MineSweeper {
    private Board board;
    private Coordinates display;
    private boolean playing = true;

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
        } else if (mines == 0) {
            System.out.println("There can't be less than 1 mine");
            return;
        }

        Set<Coordinates> coordinates = calcRandomCoordinates(width, heigth, mines);

        this.board = new Board(width, heigth, coordinates);
    }

    public void loadInstructions() {
        System.out.println("Commands:");
        System.out.println("-exit to exit the game");
        System.out.println("-click coordinateX,coordinateY to click a cell");
        System.out.println("-flag coordinateX,coordinateY to flag a cell");
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        String input;
        Display display = new Display(board);

        loadInstructions();
        System.out.println("");
        display.draw();

        while (playing) {
            input = sc.nextLine();
            if (input.equals("-exit")) {
                playing = false;
                return;
            }
            parseCommand(input);

            display.update(board);
            display.draw();
        }
    }

    private void parseCommand(String input) {
        //TODO Check input correct format
        //TODO Check correct coordinates
        String command = input.split(" ")[0];
        int posX = Integer.parseInt(input.split(" ")[1].split(",")[0]);
        int posY = Integer.parseInt(input.split(" ")[1].split(",")[1]);

        switch (command) {
            case "-click":
                if (board.getCell(posX, posY).isMined()) {
                    playing = false;
                    return;
                }
                board.clickCell(posX, posY); //TODO refactor clickCell to use Coordinates
                break;
            case "-flag":
                board.flagCell(posX, posY);
                break;
        }
    }

    /**
    * Returns a set of random positions inside the given limits
    * @param maxWidth the limit of the x position
    * @param maxHeight the limit of the y position
    * @param total the number of random positions that will be returned
    * @return a set of random Coordinates
    */
    private Set<Coordinates> calcRandomCoordinates(int maxWidth, int maxHeight, int total) {
        Set<Coordinates> coordinates = new HashSet<Coordinates>();

        int i = 0;
        while (i < total) {
            if (coordinates.add(getRandomCoordinate(maxWidth, maxHeight))) {
                i++;
            }
        }

        return coordinates;
    }

    private Coordinates getRandomCoordinate(int maxWidth, int maxHeight) {
        Random random = new Random();
        return new Coordinates(random.nextInt(maxWidth), random.nextInt(maxHeight));
    }
}
