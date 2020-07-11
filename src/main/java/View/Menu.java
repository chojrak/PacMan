package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.Sounds;


public class Menu extends JPanel {
    JFrame pacman;
   
    
    public Menu(JFrame pacman) {
    	this.pacman = pacman;
    	
        setLayout(null);
        this.setBackground(Color.BLACK);
    	
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src\\main\\resources\\buttons\\pacmanlogo.png"));
        logo.setBounds(40, 50, 850, 150);
        pacman.add(logo);        
        
        JButton single = new JButton();
        single.setBackground(Color.BLACK);
        single.setBorder(new LineBorder(Color.BLACK));
        single.setIcon(new ImageIcon("src\\main\\resources\\buttons\\single.png"));
        single.setBounds(145, 300, 630, 100);
        pacman.add(single);
    	single.addActionListener(new Play());
    	
    	JButton multiplayer = new JButton();
    	multiplayer.setBackground(Color.BLACK);
    	multiplayer.setBorder(new LineBorder(Color.BLACK));
    	multiplayer.setBounds(120, 400, 680, 100);
    	multiplayer.setIcon(new ImageIcon("src\\main\\resources\\buttons\\multi.png"));
    	pacman.add(multiplayer);
    	
    	JButton options = new JButton();
    	options.setIcon(new ImageIcon("src\\main\\resources\\buttons\\options.png"));
    	options.setBackground(Color.BLACK);
    	options.setBorder(new LineBorder(Color.BLACK));
    	options.setBounds(240, 500, 420, 100);
    	pacman.add(options);
    	options.addActionListener(new ChangeOptions());
    	
    	JButton highscores = new JButton();
    	highscores.setIcon(new ImageIcon("src\\main\\resources\\buttons\\highscores.png"));
    	highscores.setBackground(Color.BLACK);
    	highscores.setBorder(new LineBorder(Color.BLACK));
    	highscores.setBounds(155, 600, 600, 100);
    	pacman.add(highscores);
    	highscores.addActionListener(new VievHighscores());
    }
    
    class Play implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			JFrame game = new JFrame("PacMan");
	        LeftPanel left = new LeftPanel(game);
	        RightPanel right = new RightPanel(game);

	        Map map1 = new Map(game, right, left);


	        Container container = new Container(map1, left, right);
	        game.add(container);
	        pacman.setVisible(false);
	        pacman.dispose();
	        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.setVisible(true);
	        game.pack();
	  //      map1.animation();	        
	}
    }	
		class ChangeOptions implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame options = new JFrame("PacMan");				
			
				options.add(new Options(options));
				pacman.setVisible(false);
		        pacman.dispose();
		        options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        options.setVisible(true);
		        options.pack();		        
	}		
	}    
		class VievHighscores implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame highscores = new JFrame("PacMan");				
			
				highscores.add(new Highscores(highscores));
				pacman.setVisible(false);
		        pacman.dispose();
		        highscores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        highscores.setVisible(true);
		        highscores.pack();
	}		
	}
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(928, 720);
    }
}
