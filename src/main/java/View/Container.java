package View;

import javax.swing.*;

import Model.Sounds;

import java.awt.*;

public class Container extends JPanel {

    Map map;
    LeftPanel left;
    RightPanel right;

    public Container (Map map, LeftPanel left, RightPanel right) {
        this.map = map;
        this.left = left;
        this.right = right;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Sounds.music();
        add(left);
        add(map);
        add(right);
    }



}
