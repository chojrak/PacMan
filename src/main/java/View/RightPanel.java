package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RightPanel extends JPanel {
    private JFrame window;
    private JLabel scoreValue;
    private JLabel levelValue;
    private JLabel life1;

    {
        scoreValue = new JLabel();
        levelValue = new JLabel();
        life1 = new JLabel();
    }


    public RightPanel(JFrame window) {
        this.window = window;
        setLayout(null);
        this.setBackground(Color.BLACK);
        Font gameFont = new Font("OCR A Extended", Font.PLAIN, 18);

        JLabel score = new JLabel();
        labelCreator(score, "SCORE:", gameFont, Color.WHITE, 0, 24, 114, 24);
        add(score);

        labelCreator(scoreValue, String.valueOf(Map.player.getPoints()), gameFont, Color.WHITE, 114, 24, 58, 24);
        scoreValue.setHorizontalAlignment(SwingConstants.LEFT);
        add(scoreValue);

        JLabel lifes = new JLabel();
        labelCreator(lifes, "LIFES:", gameFont, Color.WHITE, 0, 72, 114, 24);
        add(lifes);

        JLabel level = new JLabel();
        labelCreator(level, "LEVEL:", gameFont, Color.WHITE, 0, 150, 114, 24);
        add(level);

        labelCreator(levelValue, String.valueOf(Map.player.getLevel()), gameFont, Color.WHITE, 114, 150, 58, 24);
        levelValue.setHorizontalAlignment(SwingConstants.LEFT);
        add(levelValue);


    }

    public void labelCreator(JLabel label, String text, Font font, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(font);
        label.setForeground(color);
        label.setBounds(x, y, width, height);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(228, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreValue.setText(String.valueOf(Map.player.getPoints()));
        levelValue.setText(String.valueOf(Map.player.getLevel()));

        for(int i = 1; i<= Map.player.getLifes(); i++)
        {
            try {
                Image img = ImageIO.read(new File("src\\main\\resources\\pacman mini.png"));
                g.drawImage(img, (i+1)*24, 100,24,24, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
