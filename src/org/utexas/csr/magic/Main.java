package org.utexas.csr.magic;

import org.utexas.csr.magic.ai.Routine;
import org.utexas.csr.magic.ai.Routines;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private JPanel panel1;
    private JPanel mainPanel;
    private JPanel canvas;
    private static Random random = new Random();

    public static void main(String[] args) {
        
        //System.out.println((random.nextInt(2)+1 )+ " " + (random.nextInt(2)+1));
        Board board = new Board(25, 25);
        Droid droid1 = new Droid("Droid_1", 5, 2, random.nextInt(6)+3, random.nextInt(2)+1, random.nextInt(3)+2);
        Droid droid2 = new Droid("Droid_2", 6, 3, random.nextInt(6)+2, random.nextInt(2)+1, random.nextInt(3)+2);
        Droid droid3 = new Droid("Droid_3", 4, 5, random.nextInt(3)+1, random.nextInt(1)+1, random.nextInt(3)+2);

        board.addDroid(droid1);
        board.addDroid(droid2);
        board.addDroid(droid3);

        Routine brain2 = Routines.sequence(
            Routines.repeat(Routines.wander(board), 4)
        );
        droid2.setRoutine(brain2);


        Routine brain3 = Routines.sequence(
                Routines.isDroidInRange(droid1,board),
                Routines.isDroidInRange(droid2,board)
        );

        droid3.setRoutine(brain3);

        Routine brain1 = Routines.sequence(
                Routines.moveTo(5, 10),
                Routines.moveTo(10, 12),
                Routines.moveTo(2, 4)
        );
        droid1.setRoutine(brain1);
        List<Droid> aryDroidStack = new ArrayList<>();
        aryDroidStack.add(droid1);
        aryDroidStack.add(droid2);
        aryDroidStack.add(droid3);

        for (int i = 0; i < 30; i++) {
            System.out.println(droid1.toString());
            System.out.println(droid2.toString());
            System.out.println(droid3.toString());
            Collections.shuffle(aryDroidStack);
            for(int j=0;j<3;j++){
                aryDroidStack.get(j).update();
            }
            //droid1.update();
            //droid2.update();
            //droid3.update();
            if(!droid1.isAlive() && !droid2.isAlive() && !droid3.isAlive()){
                break;
            }
        }
    }
}
