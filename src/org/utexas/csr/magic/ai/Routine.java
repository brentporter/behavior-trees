package org.utexas.csr.magic.ai;

import org.utexas.csr.magic.Board;
import org.utexas.csr.magic.Droid;

public abstract class Routine {

    public enum RoutineState {
        Success,
        Failure,
        Running
    }

    protected RoutineState state;

    protected Routine() { }

    public void start() {
        System.out.println(">>> Starting routine: " + this.getClass().getSimpleName());
        this.state = RoutineState.Running;
    }

    public abstract void reset();

    public abstract void act(Droid droid, Board board);

    protected void succeed() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED");
        this.state = RoutineState.Success;
    }

    protected void succeed(String incomingDroid) {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " SUCCEEDED " + incomingDroid);
        this.state = RoutineState.Success;
    }

    protected void fail() {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED");
        this.state = RoutineState.Failure;
    }

    protected void fail(String incomingDroid) {
        System.out.println(">>> Routine: " + this.getClass().getSimpleName() + " FAILED " + incomingDroid);
        this.state = RoutineState.Failure;
    }

    public boolean isSuccess() {
        return state.equals(RoutineState.Success);
    }

    public boolean isFailure() {
        return state.equals(RoutineState.Failure);
    }

    public boolean isRunning() {
        return state.equals(RoutineState.Running);
    }

    public RoutineState getState() {
        return state;
    }
}
