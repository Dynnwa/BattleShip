package model;

public class Square {
    public State state;
    public static int pos;

    public Square(int p) {
        state = State.EMPTY;
        pos = p;
    }

    public void changeState(State newstate) {
        this.state = newstate;
    }

    private int getPos() {
        return this.pos;
    }
}