package org.utexas.csr.magic.ai;

import org.utexas.csr.magic.Board;
import org.utexas.csr.magic.Droid;

/**
 * Static convenience methods to create routines using Factory Pattern
 */
public class Routines {

    public static Routine sequence(Routine... routines) {
        Sequence sequence = new Sequence();
        for (Routine routine : routines) {
            sequence.addRoutine(routine);
        }
        return sequence;
    }

    public static Routine selector(Routine... routines) {
        Selector selector = new Selector();
        for (Routine routine : routines) {
            selector.addRoutine(routine);
        }
        return selector;
    }

    public static Routine moveTo(int x, int y) {
        return new MoveTo(x, y);
    }

    public static Routine repeatInfinite(Routine routine) {
        return new Repeat(routine);
    }

    public static Routine repeat(Routine routine, int times) {
        return new Repeat(routine, times);
    }

    public static Routine wander(Board board) {
        return new Wander(board);
    }

    public static Routine isDroidInRange(Droid droid, Board board) {
        return new IsDroidInRange(droid, board);
    }

}
