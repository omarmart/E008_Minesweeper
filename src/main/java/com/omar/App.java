package com.omar;

public class App {

    /***
     * Launches the game
     * @param args The arguments of the game. (Size and number of bombs)
     */
    public static void main(String[] args) {
        MineSweeper mineGame = new MineSweeper(10, 10, 50);
        mineGame.play();
    }
}
