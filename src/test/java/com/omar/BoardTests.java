package com.omar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BoardTests {

    private Board board;

    /**
     * _ _ _ _ _ _ X _
     * _ _ _ X _ _ _ _
     * _ _ _ _ _ _ _ _
     * _ _ X _ _ _ _ _
     */
    @Before
    public void initializeBoard() {
        Set<Coordinates> mines = new HashSet<>(Arrays.asList(
            new Coordinates(2, 3),
            new Coordinates(3, 1),
            new Coordinates(6, 0)
        ));
        board = new Board(8, 5, mines);
    }

    @Test
    public void shouldCreateBoardWithSpecifiedMines() {
        assertTrue(board.getCell(2, 3).isMined());
        assertTrue(board.getCell(3, 1).isMined());
        assertTrue(board.getCell(6, 0).isMined());
    }

    @Test
    public void shouldReturnSurroundingMines() {
        assertEquals("No mines arround (0,0)", 0, board.getSurroundingMines(0, 0));
        assertEquals("One mine arround (1,3)", 1, board.getSurroundingMines(1, 3));
        assertEquals("One mine arround (5,1)", 1, board.getSurroundingMines(5, 1));
        assertEquals("Two mines arround (3,2)", 2, board.getSurroundingMines(3, 2));
    }

    @Test
    public void clickCoveredCellShouldUncoverIt() {
        board.clickCell(0, 1);
        assertEquals(Status.UNCOVERED, board.getCell(0, 1).getState());
    }
}
