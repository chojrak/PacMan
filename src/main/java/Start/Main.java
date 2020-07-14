package Start;

import View.Menu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        JFrame pacman = new JFrame("PacMan");
        pacman.setLocationByPlatform(true);
        Menu panel = new Menu(pacman);
        pacman.add(panel);
        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setVisible(true);
        pacman.pack();


    }
}