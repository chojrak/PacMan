package View;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    private JFrame window;


    public Window(JFrame window) {
        this.window = window;

        setBackground(Color.BLACK);
        Map map1 = new Map();
        add(map1);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 750);
    }
}
