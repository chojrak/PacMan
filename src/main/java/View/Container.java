package View;

import javax.swing.*;
<<<<<<< HEAD
=======

import Model.Sounds;

import java.awt.*;
>>>>>>> c8be0d059129871b54db21dbd5be24fdd161f3e9

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
