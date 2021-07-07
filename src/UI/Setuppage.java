package UI;

import Model.Board;
import Model.Boat;
import Model.Boattype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.CRC32;

public class Setuppage implements ActionListener {
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

    public Setuppage() {
        this.board = new Board();
        frame = new JFrame();
        Carrier = new JButton("Carrier");
        Destoyer = new JButton("Destroyer");
        Submarine = new JButton("Submarine");
        Battleship = new JButton("Battleship");
        Cruiser = new JButton("Cruiser");
        description = new JLabel();
        baots = new JLabel();

        setLabel(description, 75, 10, 250, 15, "Which boat do you want to add?");
        setLabel(baots, 75, 40, 250, 15, "You have already placed:");

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
        frame.add(baots);
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
        if (e.getSource() == Cruiser) {
            b = new Boat(Boattype.CRUISER);
// 3
        } else if (e.getSource() == Battleship) {
            b = new Boat(Boattype.BATTLESHIP);
// 4
        } else if (e.getSource() == Carrier) {
            b = new Boat(Boattype.CARRIER);
// 5
        } else if (e.getSource() == Destoyer) {
            b = new Boat(Boattype.DESTROYER);
// 2
        } else {
            b = new Boat(Boattype.SUBMARINE);
// 3
        }
        Addboat addboat = new Addboat(board, b);


    }
}
