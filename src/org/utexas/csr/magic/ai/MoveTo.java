package org.utexas.csr.magic.ai;

import org.utexas.csr.magic.Board;
import org.utexas.csr.magic.Droid;

public class MoveTo extends Routine {

    final protected int destX;
    final protected int destY;

    public MoveTo(int destX, int destY) {
        super();
        this.destX = destX;
        this.destY = destY;
    }

    public void reset() {
        start();
    }

    @Override
    public void act(Droid droid, Board board) {
        //System.out.println(board.getDroids());
        if (isRunning()) {
            if (!droid.isAlive()) {
                fail(droid.getName());
                return;
            }
            IsDroidInRange isDroidInRange = new IsDroidInRange(droid,board);
            isDroidInRange.act(droid,board);
            if (!isDroidAtDestination(droid)) {
                moveDroid(droid);
            }
        }
    }

    private void moveDroid(Droid droid) {
        if (destY != droid.getY()) {
            if (destY > droid.getY()) {
                droid.setY(droid.getY() + 1);
            } else {
                droid.setY(droid.getY() - 1);
            }
        }
        if (destX != droid.getX()) {
            if (destX > droid.getX()) {
                droid.setX(droid.getX() + 1);
            } else {
                droid.setX(droid.getX() - 1);
            }
        }
        if (isDroidAtDestination(droid)) {
            succeed(droid.getName());
        }
    }

    private boolean isDroidAtDestination(Droid droid) {
        return destX == droid.getX() && destY == droid.getY();
    }
}
