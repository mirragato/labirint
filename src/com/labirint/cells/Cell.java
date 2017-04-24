package com.labirint.cells;

/**
 * Created by Ира on 25.11.2015.
 */
public class Cell {
    private Boolean obstacle;

    public Cell(Boolean obstacle) {
        this.obstacle = obstacle;
    }

    protected Boolean obstacle() {
        return obstacle;
    }

    protected void setObstacle(Boolean obstacle) {
        this.obstacle = obstacle;
    }
}
