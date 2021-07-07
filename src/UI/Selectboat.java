package UI;

import Model.Board;
import Model.Boat;
import Model.Boattype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class Selectboat implements ActionListener {
    private static final int framewidth = 420;
    private static final int framelength = framewidth;
    protected JFrame frame;
    protected JButton Carrier;
    protected JButton Destoyer;
    protected JButton Submarine;
    protected JButton Battleship;
    protected JButton Cruiser;
    protected JLabel description;
    protected JLabel baots;
    protected Board board;
    protected int numboats = 5;

    public Selectboat(Board b) {
        this.board = b;
        frame = new JFrame();
        Carrier = new JButton("Carrier");
        Destoyer = new JButton("Destroyer");
        Submarine = new JButton("Submarine");
        Battleship = new JButton("Battleship");
        Cruiser = new JButton("Cruiser");
        description = new JLabel();
        baots = new JLabel();

        setLabel(description, 75, 10, 250, 15, "Which boat do you want to add?");

        setButton(Carrier, 120, 200);
        setButton(Destoyer, 120, 240);
        setButton(Submarine, 120, 280);
        setButton(Battleship, 120, 160);
        setButton(Cruiser, 120, 120);
        Carrier.addActionListener(this);
        Destoyer.addActionListener(this);
        Submarine.addActionListener(this);
        Battleship.addActionListener(this);
        Cruiser.addActionListener(this);

        frame.add(Carrier);
        frame.add(Destoyer);
        frame.add(Submarine);
        frame.add(Battleship);
        frame.add(Cruiser);
        frame.add(description);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(framewidth, framelength);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setButton(JButton jb, int xpos, int ypos) {
        jb.setBounds(xpos, ypos, 150, 25);
        jb.setFont(new Font("Ink Free", Font.PLAIN, 10));
        jb.setFocusable(false);
    }

    private void setLabel(JLabel title, int x, int y, int width, int font, String text) {
        title.setBounds(x, y, width, 15);
        title.setFont(new Font("Verdana", Font.PLAIN, font));
        title.setBorder(BorderFactory.createBevelBorder(3));
        title.setOpaque(true);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boat b;
        if (numboats > 0) {
            if (e.getSource() == Cruiser) {
                b = new Boat(Boattype.CRUISER);
                frame.remove(Cruiser);
            } else if (e.getSource() == Battleship) {
                b = new Boat(Boattype.BATTLESHIP);
                frame.remove(Battleship);
            } else if (e.getSource() == Carrier) {
                b = new Boat(Boattype.CARRIER);
                frame.remove(Carrier);
            } else if (e.getSource() == Destoyer) {
                b = new Boat(Boattype.DESTROYER);
                frame.remove(Destoyer);
            } else {
                b = new Boat(Boattype.SUBMARINE);
                frame.remove(Submarine);
            }
            Addboat addboat = new Addboat(board, b);
            numboats--;
            if (numboats == 0) {
                frame.dispose();
                Playgame p1 = new Playgame(board);
            }
        }


    }
}
