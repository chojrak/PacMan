package View;

import Model.Events;
import Model.Ghost;
import Model.MapStructure;
import Model.Player;
import Model.Sounds;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private JFrame window;
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
    RightPanel right;
    LeftPanel left;
    boolean notCatched = true;
    


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
        while (notCatched == true) {
            try {
                Thread.sleep(10);
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

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (player.getLifes() > 0) {
            player.resetPosition();
            blinky.resetPosition();
            clyde.resetPosition();
            inky.resetPosition();
            pinky.resetPosition();
            this.notCatched = true;
            repaint();
            animation();
        }

        
        else {
        	JLabel gameOver = new JLabel("GAME OVER", SwingConstants.CENTER);
            gameOver.setFont(new Font("OCR A Extended", Font.BOLD, 18));
            gameOver.setForeground(Color.RED);
            gameOver.setBounds(0,372,672,50);
            this.add(gameOver);
            repaint();

        }

    }

    public void setNotCatched(boolean notCatched) {
        this.notCatched = notCatched;
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
