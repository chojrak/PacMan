package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.Sounds;
import View.Options.GoBack;

public class Highscores extends JPanel {
    JFrame highscores;
   
    
    public Highscores(JFrame highscores) {
    	this.highscores = highscores;
    	 setLayout(null);
         this.setBackground(Color.BLACK);
    
         JLabel logo = new JLabel();
         logo.setIcon(new ImageIcon("src\\main\\resources\\buttons\\pacmanlogo.png"));
         logo.setBounds(40, 50, 850, 150);
         highscores.add(logo); 
         
         
         JButton back = new JButton();
         back.setIcon(new ImageIcon("src\\main\\resources\\buttons\\back.png"));
         back.setBackground(Color.BLACK);
         back.setBorder(new LineBorder(Color.BLACK));
         back.setBounds(155, 600, 600, 100);
         highscores.add(back);
         back.addActionListener(new GoBack());
}
    class GoBack implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame back = new JFrame("PacMan");				
		
			back.add(new Menu(back));
			back.setLocationByPlatform(true);
			highscores.setVisible(false);
			highscores.dispose();
			back.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			back.setVisible(true);
			back.pack();		        
}		
}
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(928, 720);
    }
}
