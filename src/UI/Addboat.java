package UI;

import Model.Board;
import Model.Boat;
import Model.Square;
import Model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Addboat implements ActionListener {
    protected Board board;
    private static final int framewidth = 420;
    private static final int framelength = framewidth;
    protected JFrame frame;
    protected Boat boat;
    protected List<JButton> buttons;
    protected int sizeofboat;

    public Addboat(Board board, Boat boat) {
        this.board = board;
        this.boat = boat;
        sizeofboat = boat.size;
        frame = new JFrame();
        buttons = new ArrayList<>();
        for (int i = 1; i< 101; i++) {
            JButton b = new JButton(String.valueOf(i));
            if (board.squares.get(i-1).state == State.OCCUPIED) {
                b.setForeground(Color.black);
            } else {
                b.setForeground(Color.blue);
            }
            b.addActionListener(this);
            buttons.add(b);
        }
        for (int i = 0; i< 100; i++) {
            frame.add(buttons.get(i));
        }

        frame.setLayout(new GridLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(framewidth, framelength);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (sizeofboat>0) {
            //board.squares.get(i-1).state = State.OCCUPIED;
            JButton b = (JButton) e.getSource();
            b.setForeground(Color.BLACK);
            int pos = Integer.valueOf(b.getText());
            board.squares.get(pos-1).state = State.OCCUPIED;
            Square s = new Square(pos);
            boat.addSquare(s);
            sizeofboat--;
        } else {
            frame.dispose();
        }
    }
}
