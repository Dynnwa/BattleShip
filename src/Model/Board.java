package Model;


import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<Square> squares;
    public int width;
    public int length;

    public Board() {
        this.width = 10;
        this.length = 10;
        squares = new ArrayList<>();
        for (int i= 1; i< width*length + 1; i++) {
            Square s = new Square(i);
            squares.add(s);
        }
    }

    public void addBoat(Boat b) {
        List<Square> boat = b.positions;
        for (int i = 0; i< boat.size(); i++) {
            squares.set(boat.get(i).pos - 1, boat.get(i));
        }
    }

    public boolean hit(int pos1) {
        if (this.squares.get(pos1 - 1).state == State.OCCUPIED) {
            this.squares.get(pos1 - 1).state = State.DESTROYED;
            return true;
        }
        return false;
    }

    public boolean gone() {
        for (int i = 0; i< this.squares.size(); i++) {
            if (this.squares.get(i).state == State.OCCUPIED) {
                return false;
            }
        }
        return true;
    }
}
