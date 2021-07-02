package model;


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
        for (int i= 0; i< width*length; i++) {
            Square s = new Square(i);
            squares.add(s);
        }
    }

    public void addBoat(Boat b) {
        List<Square> boat = b.positions;
        for (int i = 0; i< boat.size(); i++) {
            squares.set(i, boat.get(i));
        }
    }

}
