package com.omar;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)) {
            return false;
        }

        Coordinates position = (Coordinates) o;

        return (position.getX() == this.x && position.getY() == this.y);
    }

    @Override
    public int hashCode() {
        return x + y << 16;
    }

}
