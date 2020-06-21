package View;

import Model.MapStructure;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
  //  private JFrame window;

    public Map() {
      //  this.window = window;
        setLayout(null);
        MapStructure.generatePacmanMap();
        FillMap();


    }

    public void FillMap() {
        for (int j = 0; j <= 29; j++) {
            for (int i = 0; i <= 27; i++) {
                JLabel square = new JLabel(MapStructure.Map[j][i].getPicture());
                square.setBounds(i * 24, j * 24, 24, 24);
                add(square);
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(672, 720);
    }


}
