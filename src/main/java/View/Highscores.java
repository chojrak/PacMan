package View;

import Model.HighScores;
import Model.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Highscores extends JPanel {
    JFrame highscores;


    public Highscores(JFrame highscores) {
        this.highscores = highscores;
        setLayout(null);
        this.setBackground(Color.BLACK);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src\\main\\resources\\buttons\\pacmanlogo.png"));
        logo.setBounds(0, 50, 1128, 150);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        highscores.add(logo);
        Escape esc = new Escape(this);
        JButton jb = new JButton();
        jb.addKeyListener(esc);
        add(jb);


        int i = 1;
        for (Score s : HighScores.highScores) {
            JLabel temp = new JLabel();
            labelCreator(temp, s.toString(), Color.WHITE, 0, i * 24 + 200, 1128, 24);
            add(temp);
            i++;
        }

        JLabel escape = new JLabel();
        labelCreator(escape, "PRESS \"ESC\" TO GO BACK", Color.WHITE, 0, 650, 1128, 24);
        add(escape);
    }

    public void goBack() {

        JFrame back = new JFrame("PacMan");

        back.add(new Menu(back));
        back.setLocation(highscores.getLocation());
        highscores.setVisible(false);
        highscores.dispose();
        back.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.setVisible(true);
        back.pack();
    }

    public void labelCreator(JLabel label, String text, Color color, int x, int y, int width, int height) {
        label.setText(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1128, 720);
    }
}

class Escape implements KeyListener {
    Highscores hs;

    public Escape(Highscores hs) {
        this.hs = hs;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) hs.goBack();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
