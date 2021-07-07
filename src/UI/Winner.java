package UI;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class Winner {
    private static final int framewidth = 420;
    private static final int framelength = framewidth;
    protected JFrame frame;
    protected JLabel label;

    public Winner() {
        frame = new JFrame();
        label = new JLabel();

        setLabel(label, 100, 10, 200, 15, "We have a winner!");

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(framewidth,framelength);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void setLabel(JLabel title, int x, int y, int width, int font, String text) {
        title.setBounds(x, y, width, 15);
        title.setFont(new Font("Verdana", Font.PLAIN, font));
        title.setBorder(BorderFactory.createBevelBorder(3));
        title.setOpaque(true);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setText(text);
    }
}
