package Model;

import java.util.ArrayList;
import java.util.List;

// A boat is conprimsed of a list of squares and it has a size
public class Boat {
    public Boattype boattype;
    public List<Square> positions;
    public int size;
    public int afloat;
    public boolean horizontal;
    public boolean sunk;

    public Boat(Boattype type) {
        if (type == Boattype.CARRIER) {
            size = 5;
        } else if (type == Boattype.BATTLESHIP) {
            size = 4;
        } else if (type == Boattype.CRUISER || type == Boattype.SUBMARINE) {
            size = 3;
        } else if (type == Boattype.DESTROYER) {
            size = 2;
        }
        afloat = size;
        sunk = false;
        positions = new ArrayList<>();
        boattype = type;
    }

    public void hit(int pos) {
        afloat--;
        if (afloat == 0) {
            sunk = true;
        }
        for(int i = 0; i < size; i++) {
            Square s = positions.get(i);
            if (s.pos == pos) {
                s.state = State.DESTROYED;
            }
        }
    }

    public void addSquare(Square s) {
        s.state = State.OCCUPIED;
        positions.add(s);
    }

    public void removeSquare(Square s) {
        positions.remove(s);
    }

}
