package Model;

// A square represents one grid spot on the board and has a status that represents whether it is water, occupied, or destoyed

public class Square {
    public State state;
    public int pos;

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
