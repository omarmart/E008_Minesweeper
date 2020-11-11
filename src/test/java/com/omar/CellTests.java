package com.omar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTests
{
    @Test
    public void shouldCreateCellWithoutMine()
    {
        Cell cell = new Cell(false);
        assertFalse(cell.isMined());
    }

    @Test
    public void shouldCreateMinedCell()
    {
        Cell cell = new Cell(true);
        assertTrue(cell.isMined());
    }

    @Test
    public void shouldCreateCellUncovered() {
        Cell cell = new Cell(false);
        assertEquals(Status.COVERED, cell.getState());
    }

    @Test
    public void afterClickShouldSetUncovered() {
        Cell cell = new Cell(false);
        cell.click();
        assertEquals(Status.UNCOVERED, cell.getState());
    }

    @Test
    public void afterFlagShouldToggleFlagState() {
        Cell cell = new Cell(true);
        cell.flag();
        assertEquals(Status.FLAGGED, cell.getState());
        cell.flag();
        assertEquals(Status.COVERED, cell.getState());
    }
}
