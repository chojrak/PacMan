package View;

import Model.Events;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    private JFrame window;
    private JLabel scoreValue = new JLabel();

    public RightPanel (JFrame window){
        this.window = window;
        setLayout(null);
        this.setBackground(Color.BLACK);

        JLabel score = new JLabel("SCORE:", SwingConstants.LEFT);
        score.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
        score.setForeground(Color.WHITE);
        score.setBounds(0,24,75,24);
        add(score);


        scoreValue.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
        scoreValue.setText(String.valueOf(Map.player.getPoints()));
        scoreValue.setForeground(Color.WHITE);
        scoreValue.setBounds(70,24,58,24);
        add(scoreValue);


    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(128, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreValue.setText(String.valueOf(Map.player.getPoints()));
    }
}
