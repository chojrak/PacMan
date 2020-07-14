package View;

import Model.Pointer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Menu extends JPanel {
    JFrame pacman;
    Pointer pointer;
    JLabel icon;
    JLabel logo;

    public Menu(JFrame pacman) {
        this.pacman = pacman;
        pointer = new Pointer(this);
        icon = new JLabel(pointer.getPic());
        icon.setBounds(500, pointer.getVerticalPosition() - 23, 46, 46);


        setLayout(null);
        this.setBackground(Color.BLACK);

        logo = new JLabel();
        logo.setIcon(new ImageIcon("src\\main\\resources\\buttons\\pacmanlogo.png"));
        logo.setBounds(0, 50, 1128, 150);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        pacman.add(logo);

        add(labelCreator("1 PLAYER", Color.WHITE, 564, 300, 846, 50));
        add(labelCreator("2 PLAYERS", Color.WHITE, 564, 350, 846, 50));
        add(labelCreator("HIGH SCORES", Color.WHITE, 564, 400, 846, 50));
        add(icon);
        JButton jb = new JButton();
        Enter enter = new Enter(this);
        jb.addKeyListener(enter);
        add(jb);

    }


    public JLabel labelCreator(String text, Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setHorizontalTextPosition(SwingConstants.LEFT);
        label.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        return label;
    }

    public void highScores () {
        JFrame highscores = new JFrame("PacMan");
        highscores.add(new Highscores(highscores));
        highscores.setLocation(pacman.getLocation());
        pacman.setVisible(false);
        pacman.dispose();
        highscores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        highscores.setVisible(true);
        highscores.pack();
    }

    public void Play (boolean human) {
        JFrame game = new JFrame("PacMan");

        LeftPanel left = new LeftPanel(game);
        RightPanel right = new RightPanel(game);
        Map map1 = new Map(game, right, left, human);
        Container container = new Container(map1, left, right);
        game.add(container);
        game.setLocation(pacman.getLocation());
        pacman.setVisible(false);
        pacman.dispose();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.pack();
        new Thread(map1::getReady).start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1128, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        icon.setIcon(pointer.getPic());
        icon.setBounds(500, pointer.getVerticalPosition() - 23, 46, 46);
        logo.setIcon(new ImageIcon("src\\main\\resources\\buttons\\pacmanlogo.png"));
    }
}


class Enter implements KeyListener {
    Menu menu;

    public Enter(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            boolean human = menu.pointer.getVerticalPosition() == 373? true : false;
            if (menu.pointer.getVerticalPosition() == 421) menu.highScores();
            else menu.Play(human);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) menu.pointer.goDown();
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP) menu.pointer.goUp();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
