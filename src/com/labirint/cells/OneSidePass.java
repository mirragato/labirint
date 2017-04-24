package com.labirint.cells;

/**
 * Created by Ира on 25.11.2015.
 */
enum Direct { //перечисление
    UP, DOWN, RIGHT, LEFT
}

public class OneSidePass extends Cell {
    private final Direct direct;

    public OneSidePass(Direct direct) {
        super(false);
        this.direct = direct;
    }

    public Boolean obstacle(Direct direct) {
        return !this.direct.equals(direct);
    }
}
