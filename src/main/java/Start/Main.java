package Start;

import View.Container;
import View.LeftPanel;
import View.Map;
import View.Menu;
import View.RightPanel;


import javax.swing.*;

import Model.Sounds;

public class Main {

    public static void main(String[] args) {

        JFrame pacman = new JFrame("PacMan");
        pacman.add(new Menu(pacman));	
        Sounds.background();

        
        
        
   //    LeftPanel left = new LeftPanel(pacman);
   //     RightPanel right = new RightPanel(pacman);

   //     Map map1 = new Map(pacman, right, left);


    //    Container container = new Container(map1, left, right);

   //     pacman.add(container);
   //     pacman.setLocationByPlatform(true);

        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setVisible(true);
        pacman.pack();

   //     map1.animation();



    }
}