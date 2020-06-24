package Start;

import View.Map;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame pacman = new JFrame("PacMan");
        Map map1 = new Map(pacman);

        pacman.add(map1);
        pacman.setLocationByPlatform(true);

        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setVisible(true);
        pacman.pack();

        map1.animation();


    }
}