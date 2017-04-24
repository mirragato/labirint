package com.labirint.cells;

/**
 * Created by Ира on 25.11.2015.
 */
public class Door extends Cell{
    private final Key key;

    public Door(Boolean obstacle, Key key) {
        super(obstacle);
        this.key = key;
    }

    public Boolean open(Key key) {
        if (this.key.equals(key)) {
            setObstacle(false);
            return true;
        } else {
            return false;
        }
    }

    public Boolean obstacle() { //проходимость стеночки
        return super.obstacle();
    }
}
