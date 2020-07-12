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

    public void labelCreator(JLabel label, String text, Font font, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setFont(font);
        label.setForeground(color);
        label.setBounds(x, y, width, height);
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
