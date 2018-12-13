package org.utexas.csr.magic;
//Finished BAP

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int width;
    private final int height;

    private List<Droid> droids = new ArrayList<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addDroid(Droid droid) {
        if (isTileWalkable(droid.getX(), droid.getY())) {
            droids.add(droid);
            droid.setBoard(this);
        }
    }

    public boolean isTileWalkable(int x, int y) {
        for (Droid droid : droids) {
            if (droid.getX() == x && droid.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public List<Droid> getDroids() {
        return droids;
    }
}
