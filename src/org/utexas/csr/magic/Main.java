package org.utexas.csr.magic;

import org.utexas.csr.magic.ai.Routine;
import org.utexas.csr.magic.ai.Routines;

import javax.swing.*;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {

        Board board = new Board(25, 25);
        Droid droid1 = new Droid("Droid_1", 5, 2, 10, random.nextInt(3)+1, random.nextInt(3)+1);
        Droid droid2 = new Droid("Droid_2", 6, 3, 10, random.nextInt(3)+1, random.nextInt(3)+1);
        Droid droid3 = new Droid("Droid_3", 4, 5, 10, random.nextInt(3)+1, random.nextInt(3)+1);

        board.addDroid(droid1);
        board.addDroid(droid2);
        board.addDroid(droid3);

        Routine brain2 = Routines.sequence(
            Routines.repeat(Routines.wander(board), 4)
        );
        droid2.setRoutine(brain2);

        droid3.setRoutine(brain2);
        Routine brain1 = Routines.sequence(
                Routines.moveTo(5, 10),
                Routines.moveTo(15, 12),
                Routines.moveTo(2, 4)
        );
        droid1.setRoutine(brain1);

        for (int i = 0; i < 20; i++) {
            System.out.println(droid1.toString());
            System.out.println(droid2.toString());
            System.out.println(droid3.toString());
            droid1.update();
            droid2.update();
            droid3.update();
            if(!droid1.isAlive() && !droid2.isAlive() && !droid3.isAlive()){
                break;
            }
        }
    }
}
