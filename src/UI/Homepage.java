package UI;

import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage implements ActionListener {
    private static final int framewidth = 420;
    private static final int framelength = framewidth;
    protected JFrame frame;
    protected JButton start;
    protected JButton quit;
    protected JLabel title;
    protected JLabel description;

    public Homepage() {
        frame = new JFrame();
        start = new JButton("Start Game");
        quit = new JButton("Quit :(");
        title = new JLabel();
        description = new JLabel();

        setLabel(title, 100, 10, 200, 15, "Welcome to Battleship!!!");
        setLabel(description, 50, 50, 300, 10, "Press start to begin a game or quit to quit");

        setButton(start,120,200);
        setButton(quit,120,245);
        start.addActionListener(this);
        quit.addActionListener(this);

        frame.add(title);
        frame.add(start);
        frame.add(quit);
        frame.add(title);
        frame.add(description);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(framewidth,framelength);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setButton(JButton jb, int xpos, int ypos) {
        jb.setBounds(xpos,ypos,150,25);
        jb.setFont(new Font("Ink Free",Font.PLAIN,10));
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
        if (e.getSource() == quit) {
            frame.dispose();
        } else {
            frame.dispose();
            Setuppage setup = new Setuppage();
            frame.dispose();
        }
    }
}
