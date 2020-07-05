package View;

import Model.Events;
import Model.Ghost;
import Model.MapStructure;
import Model.Player;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private JFrame window;
    static Player player = new Player();
    JLabel player1 = new JLabel(player.getPic());
    Ghost ghost = new Ghost("blinky");
    JLabel ghost1 = new JLabel(ghost.getPic());
    RightPanel right;
    LeftPanel left;


    public Map(JFrame window, RightPanel right, LeftPanel left) {
        this.window = window;
        this.right = right;
        this.left = left;
        add(this.player1);
        add(this.ghost1);
        setLayout(null);
        MapStructure.generatePacmanMap();
        Events events = new Events(player, this, ghost);
        Listener moves = new Listener(this);
        JButton jb = new JButton();
        jb.addKeyListener(moves);
        add(jb);

    }



    public void animation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean notCatched = true;
        while (notCatched = true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.movePlayer();
            ghost.movePlayer();
            Events events = new Events(player, this, ghost);
            repaint();
            right.repaint();
            left.repaint();

        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(672, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int j = 0; j <= 29; j++) {
            for (int i = 0; i <= 27; i++) {
                g.drawImage(MapStructure.Map[j][i].getPicture(), i * 24, j * 24, this);
                if (MapStructure.Map[j][i].isTreat()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(i * 24 + 8, j * 24 + 8, 8, 8);
                }
            }
        }


        player1.setIcon(player.getPic());
        player1.setBounds(player.getCurrentHorizontalPosition() - 23, player.getCurrentVerticalPosition() - 23, 46, 46);
        ghost1.setIcon(ghost.getPic());
        ghost1.setBounds(ghost.getCurrentHorizontalPosition() - 23, ghost.getCurrentVerticalPosition() - 23, 46, 46);





    }
}
