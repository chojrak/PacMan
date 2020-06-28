package View;

import Model.Ghost;
import Model.MapStructure;
import Model.Player;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private JFrame window;
    static Player player = new Player();
    JLabel player1 = new JLabel(player.getPic());
    static Ghost ghost = new Ghost();
    JLabel ghost1 = new JLabel(ghost.getPic());


    public Map(JFrame window) {
        this.window = window;
        add(this.player1);
        add(this.ghost1);
        setLayout(null);
        MapStructure.generatePacmanMap();
        Listener moves = new Listener(this);
        JButton jb = new JButton();
        jb.addKeyListener(moves);
        add(jb);
        fillWithTreats();
        fillMap();


    }

    public void fillMap() {
        for (int j = 0; j <= 29; j++) {
            for (int i = 0; i <= 27; i++) {
                JLabel square = new JLabel(MapStructure.Map[j][i].getPicture());
                square.setBounds(i * 24, j * 24, 24, 24);
                add(square);
            }
        }

    }

    public void fillWithTreats() {
        for (int j = 0; j <= 29; j++) {
            for (int i = 0; i <= 27; i++) {
                if (MapStructure.Map[j][i].isTreat()) {
                    JLabel dot = new JLabel(new ImageIcon("src\\main\\resources\\smalldot.png"));
                    dot.setBounds(i * 24, j * 24, 24, 24);
                    add(dot);
                }
            }
        }
    }


    public void animation() {
    	boolean notCatched = true;
        while (notCatched=true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            player.movePlayer();
            ghost.moveGhost();
            ghost02.moveGhost();
            repaint();

        }
    }
    
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(672, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.setIcon(player.getPic());
        player1.setBounds(player.getCurrentHorizontalPosition() - 23, player.getCurrentVerticalPosition() - 23, 46, 46);
        ghost1.setIcon(ghost.getPic());
        ghost1.setBounds(ghost.getCurrentHorizontalPosition() - 23, ghost.getCurrentVerticalPosition() - 23, 46, 46);
  
        // add(player1);
        

    }
}
