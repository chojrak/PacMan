package View;

import Model.*;

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
    static JLabel news = new JLabel();
    RightPanel right;
    LeftPanel left;
    public int refresh = 15;
    boolean notCatched = true;
    public String eatenGhost = "none";


    public Map(JFrame window, RightPanel right, LeftPanel left) {
        Sounds.music();
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

    public void getReady(){
        labelCreator(news, "FOR 2 PLAYERS PRESS \"ENTER\"", Color.YELLOW, 0, 372, 672, 50);
        add(news);
        repaint();
        sleep(2000);
        labelCreator(news, "READY?!", Color.YELLOW, 0, 372, 672, 50);
        add(news);
        repaint();
        steady();
    }

    public void steady(){
        sleep(1000);
        news.setText("");
        animation();
    }


    public void animation() {

        while (notCatched == true && eatenGhost.equals("none")) {
            standardMoves();
        }


        if (notCatched == false && player.getLifes() > 0) {
            lifeAfterDeath();
        } else if (!eatenGhost.equals("none")) {
           eatGhost();


        } else {
            labelCreator(news, "GAME OVER", Color.RED, 0,372,672,50);
            this.add(news);
            repaint();
            if (HighScores.goodGame(new Score("temp", player.getPoints()))) {
                String name = JOptionPane.showInputDialog(this, "Good Game, enter Your name:");
                HighScores.addRecord(new Score(name, player.getPoints()));
            }
        }

    }

    public void standardMoves() {
        sleep(refresh);

        player.movePlayer();
        blinky.movePlayer();
        clyde.movePlayer();
        inky.movePlayer();
        pinky.movePlayer();
        Events events = new Events(player, this, blinky, clyde, inky, pinky);
        repaint();
        right.repaint();
        left.repaint();
        if (player.getLastMoveSnap() + 500/blinky.getLevel() < player.movesCounter) {
            eatenGhost = "none";
            blinky.setEatableGhosts(false);
            clyde.setEatableGhosts(false);
            inky.setEatableGhosts(false);
            pinky.setEatableGhosts(false);
        }
    }

    public void lifeAfterDeath() {
        sleep(1000);
        player.resetPosition();
        blinky.resetPosition();
        clyde.resetPosition();
        inky.resetPosition();
        pinky.resetPosition();
        this.notCatched = true;
        repaint();
        animation();
    }

    public void eatGhost () {
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

        labelCreator(news, "200", Color.cyan, horizontal - 24, vertical - 24, 50, 50);
        add(news);
        repaint();
        sleep(500);
        player.setCurrentVerticalPosition(vertical);
        player.setCurrentHorizontalPosition(horizontal);
        if (eatenGhost.equals("blinky")) blinky.resetPosition();
        if (eatenGhost.equals("clyde")) clyde.resetPosition();
        if (eatenGhost.equals("inky")) inky.resetPosition();
        if (eatenGhost.equals("pinky")) pinky.resetPosition();
        eatenGhost = "none";
        news.setText("");
        player.addPoints(200);
        repaint();
        animation();
    }

    public void setNotCatched(boolean notCatched) {
        this.notCatched = notCatched;
    }

    public void labelCreator(JLabel label, String text, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("OCR A Extended", Font.BOLD, 18));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
    }

    public void sleep (int milis)
    {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
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