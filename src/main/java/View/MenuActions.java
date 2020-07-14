package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActions {
    Menu menu;



    class VievHighscores implements ActionListener {
        Menu menu;

        public VievHighscores(Menu menu) {
            this.menu = menu;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame highscores = new JFrame("PacMan");
            highscores.add(new Highscores(highscores));
            menu.pacman.setVisible(false);
            menu.pacman.dispose();
            highscores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            highscores.setVisible(true);
            highscores.pack();
        }
    }

    class Play implements ActionListener {
        Menu menu;
        boolean human;

        public Play(Menu menu, boolean human) {
            this.menu = menu;
            this.human = human;
        }

        public void actionPerformed(ActionEvent e) {

            JFrame game = new JFrame("PacMan");

            LeftPanel left = new LeftPanel(game);
            RightPanel right = new RightPanel(game);
            Map map1 = new Map(game, right, left, human);
            Container container = new Container(map1, left, right);
            game.add(container);
            menu.pacman.setVisible(false);
            menu.pacman.dispose();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setVisible(true);
            game.pack();
            new Thread(map1::getReady).start();

        }


    }
}
