package model;

import java.util.List;

public class Boat {
    public Boattype boattype;
    public List<Square> positions;
    public int size;
    public int afloat;
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
        positions = null;
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
        positions.add(s);
    }

}
