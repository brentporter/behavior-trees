package org.utexas.csr.magic.ai;

import org.utexas.csr.magic.Board;
import org.utexas.csr.magic.Droid;

public class IsDroidInRange extends Routine {
    final protected Droid destX;
    final protected Board destY;

    //public IsDroidInRange() {}

    public IsDroidInRange(Droid droid, Board board) {
        super();
        this.destX = droid;
        this.destY = board;
    }

    @Override
    public void reset() {
        start();
    }

    @Override
    public void act(Droid droid, Board board) {
        // find droid in range
        for (Droid enemy : board.getDroids()) {
            if (!droid.getName().equals(enemy.getName())) {
                System.out.println(" Name of droid acquired " + enemy.getName() + " by " + droid.getName());
                if (isInRangeDF(droid, enemy)) {
                    if(enemy.getHealth()>0 && droid.isAlive()) {
                        enemy.setHealth(enemy.getHealth() - droid.getDamage());
                        succeed(enemy.getName() + " now has health of " + enemy.getHealth());
                        break;
                    } else{
                        break;
                    }
                }
            }
        }
        fail();
    }

    private boolean isInRange(Droid droid, Droid enemy) {
        return (Math.abs(droid.getX() - enemy.getX()) <= droid.getRange()
                && Math.abs(droid.getY() - enemy.getY()) <= droid.getRange());
    }

    private boolean isInRangeDF(Droid droid, Droid enemy) {
            System.out.println(Math.sqrt(Math.abs(Math.pow(droid.getX()-enemy.getX(),2)+Math.pow(droid.getY()-enemy.getY(),2))));
        return (Math.sqrt(Math.abs(Math.pow(droid.getX()-enemy.getX(),2)+Math.pow(droid.getY()-enemy.getY(),2)))<=droid.getRange());
    }
}
