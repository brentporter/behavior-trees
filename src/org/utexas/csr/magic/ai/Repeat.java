package org.utexas.csr.magic.ai;

import org.utexas.csr.magic.Board;
import org.utexas.csr.magic.Droid;

public class Repeat extends Routine {

    private final Routine routine;
    private int times;
    private int originalTimes;

    public Repeat(Routine routine) {
        super();
        this.routine = routine;
        this.times = -1; // infinite
        this.originalTimes = times;
    }

    public Repeat(Routine routine, int times) {
        super();
        if (times < 1) {
            throw new RuntimeException("Can't repeat negative times.");
        }
        this.routine = routine;
        this.times = times;
        this.originalTimes = times;
    }

    @Override
    public void start() {
        super.start();
        this.routine.start();
    }

    public void reset() {
        // reset counters
        this.times = originalTimes;
    }

    @Override
    public void act(Droid droid, Board board) {
        if (routine.isFailure()) {
            fail();
        } else if (routine.isSuccess()) {
            if (times == 0) {
                succeed();
                return;
            }
            if (times > 0 || times <= -1) {
                times--;
                routine.reset();
                routine.start();
            }
        }
        if (routine.isRunning()) {
            routine.act(droid, board);
        }
    }
}
