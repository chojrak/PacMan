package Start;

import View.Window;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame pacman = new JFrame("PacMan");

        pacman.add(new Window(pacman));
        pacman.setLocationByPlatform(true);

        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setVisible(true);
        pacman.pack();
    }
}
