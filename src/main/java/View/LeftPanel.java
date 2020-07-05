package View;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private JFrame window;

    public LeftPanel (JFrame window){
        this.window = window;
        setLayout(null);
        this.setBackground(Color.BLACK);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(128, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
