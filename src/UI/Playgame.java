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

public class Playgame implements ActionListener {
    private static final int framewidth = 420;
    private static final int framelength = framewidth;
    protected JFrame frame;
    protected List<JButton> buttons;
    protected Board board;

    public Playgame(Board board) {
        this.board = board;
        frame = new JFrame();
        buttons = new ArrayList<>();
        for (int i = 1; i< 101; i++) {
            JButton b = new JButton(String.valueOf(i));
            b.setForeground(Color.blue);
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
        JButton b = (JButton) e.getSource();
        b.setForeground(Color.BLACK);
        int pos = Integer.valueOf(b.getText());
        if (board.hit(pos)) {
            b.setForeground(Color.RED);
            board.squares.get(pos-1).state = State.DESTROYED;
        }
        if ((board.done())) {
            frame.dispose();
            Winner win = new Winner();
        }

    }
}
