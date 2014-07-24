package net.obviam.bt;

import java.util.ArrayList;
import java.util.List;

public class Board {

    final int width;
    final int height;

    private List<Droid> droids = new ArrayList<Droid>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addDroid(Droid droid) {
        if (isTileWalkable(droid.getX(), droid.getY())) {
            droids.add(droid);
        }
    }

    private boolean isTileWalkable(int x, int y) {
        for (Droid droid : droids) {
            if (droid.getX() == x && droid.getY() == y) {
                return false;
            }
        }
        return true;
    }
}