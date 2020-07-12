package View;

import Model.HighScores;
import Model.Score;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private JFrame window;

    public LeftPanel(JFrame window) {
        this.window = window;
        setLayout(null);
        this.setBackground(Color.BLACK);

        JLabel scores = new JLabel();
        labelCreator(scores, "HIGH SCORES:", Color.WHITE, 0, 24, 228, 24);
        add(scores);
        addScores();

        }



    public void labelCreator(JLabel label, String text, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
    }

    public void addScores() {
        int i = 1;
        for (Score s : HighScores.highScores) {
            JLabel temp = new JLabel();
            labelCreator(temp, s.toString(), Color.WHITE, 5, i * 24 + 48, 223, 24);
            add(temp);
            i++;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(228, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


    }


}


