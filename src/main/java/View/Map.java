package View;

import Model.Events;
import Model.Ghost;
import Model.MapStructure;
import Model.Player;
import Model.Sounds;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    JFrame window;
    static Player player = new Player();
    JLabel player1 = new JLabel(player.getPic());
    Ghost blinky = new Ghost("blinky");
    Ghost clyde = new Ghost("clyde");
    Ghost inky = new Ghost("inky");
    Ghost pinky = new Ghost("pinky");
    JLabel ghost1 = new JLabel(blinky.getPic());
    JLabel ghost2 = new JLabel(clyde.getPic());
    JLabel ghost3 = new JLabel(inky.getPic());
    JLabel ghost4 = new JLabel(pinky.getPic());
    JLabel points = new JLabel();
    RightPanel right;
    LeftPanel left;
    boolean notCatched = true;
    public String eatenGhost = "none";


    public Map(JFrame window, RightPanel right, LeftPanel left) {
        this.window = window;
        this.right = right;
        this.left = left;
        add(this.player1);
        add(this.ghost1);
        add(this.ghost2);
        add(this.ghost3);
        add(this.ghost4);
        setLayout(null);
        MapStructure.generatePacmanMap();
        Events events = new Events(player, this, blinky, clyde, inky, pinky);
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
        while (notCatched == true && eatenGhost.equals("none")) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.movePlayer();
            blinky.movePlayer();
            clyde.movePlayer();
            inky.movePlayer();
            pinky.movePlayer();
            Events events = new Events(player, this, blinky, clyde, inky, pinky);
            repaint();
            right.repaint();
            left.repaint();
            if (player.getLastMoveSnap() + 500 < player.movesCounter) {
                eatenGhost = "none";
                blinky.setEatableGhosts(false);
                clyde.setEatableGhosts(false);
                inky.setEatableGhosts(false);
                pinky.setEatableGhosts(false);
            }

        }


        if (notCatched == false && player.getLifes() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.resetPosition();
            blinky.resetPosition();
            clyde.resetPosition();
            inky.resetPosition();
            pinky.resetPosition();
            this.notCatched = true;
            repaint();
            animation();
        } else if (!eatenGhost.equals("none")) {
            int horizontal = player.getCurrentHorizontalPosition();
            int vertical = player.getCurrentVerticalPosition();
            player.setCurrentHorizontalPosition(-1000);
            player.setCurrentVerticalPosition(-1000);
            if (eatenGhost.equals("blinky")) {
                blinky.setCurrentHorizontalPosition(-1000);
                blinky.setCurrentVerticalPosition(-1000);
            }
            if (eatenGhost.equals("clyde")) {
                clyde.setCurrentHorizontalPosition(-1000);
                clyde.setCurrentVerticalPosition(-1000);
            }
            if (eatenGhost.equals("inky")) {
                inky.setCurrentHorizontalPosition(-1000);
                inky.setCurrentVerticalPosition(-1000);
            }
            if (eatenGhost.equals("pinky")) {
                pinky.setCurrentHorizontalPosition(-1000);
                pinky.setCurrentVerticalPosition(-1000);
            }

            labelCreator(points, "200", Color.cyan, horizontal - 24, vertical - 24, 50, 50);
            add(points);
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.setCurrentVerticalPosition(vertical);
            player.setCurrentHorizontalPosition(horizontal);
            if (eatenGhost.equals("blinky")) blinky.resetPosition();
            if (eatenGhost.equals("clyde")) clyde.resetPosition();
            if (eatenGhost.equals("inky")) inky.resetPosition();
            if (eatenGhost.equals("pinky")) pinky.resetPosition();
            eatenGhost = "none";
            points.setText("");
            player.addPoints(200);
            repaint();

            animation();


        } else {
            JLabel gameOver = new JLabel("GAME OVER", SwingConstants.CENTER);
            gameOver.setFont(new Font("OCR A Extended", Font.BOLD, 18));
            gameOver.setForeground(Color.RED);
            gameOver.setBounds(0, 372, 672, 50);
            this.add(gameOver);
            repaint();

        }

    }

    public void setNotCatched(boolean notCatched) {
        this.notCatched = notCatched;
    }

    public void labelCreator(JLabel label, String text, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
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
                if (MapStructure.Map[j][i].getTreat().equals("smallDot")) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(i * 24 + 8, j * 24 + 8, 8, 8);
                } else if (MapStructure.Map[j][i].getTreat().equals("bigDot")) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(i * 24 + 2, j * 24 + 2, 20, 20);
                }
            }
        }


        player1.setIcon(player.getPic());
        player1.setBounds(player.getCurrentHorizontalPosition() - 23, player.getCurrentVerticalPosition() - 23, 46, 46);
        ghost1.setIcon(blinky.getPic());
        ghost1.setBounds(blinky.getCurrentHorizontalPosition() - 23, blinky.getCurrentVerticalPosition() - 23, 46, 46);
        ghost2.setIcon(clyde.getPic());
        ghost2.setBounds(clyde.getCurrentHorizontalPosition() - 23, clyde.getCurrentVerticalPosition() - 23, 46, 46);
        ghost3.setIcon(inky.getPic());
        ghost3.setBounds(inky.getCurrentHorizontalPosition() - 23, inky.getCurrentVerticalPosition() - 23, 46, 46);
        ghost4.setIcon(pinky.getPic());
        ghost4.setBounds(pinky.getCurrentHorizontalPosition() - 23, pinky.getCurrentVerticalPosition() - 23, 46, 46);


    }

}