package Start;

import View.Container;
import View.LeftPanel;
import View.Map;
import View.RightPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame game = new JFrame("PacMan");
        LeftPanel left = new LeftPanel(game);
        RightPanel right = new RightPanel(game);

        Map map1 = new Map(game, right, left);
        Container container = new Container(map1, left, right);

        game.add(container);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.pack();
        map1.getReady();


    }
}