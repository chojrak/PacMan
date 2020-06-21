package Model;

import javax.swing.*;

public class Wall {

    private ImageIcon picture;
    private boolean obstacle;
   // private int rotation;

    public Wall (ImageIcon picture, boolean obstacle) {
        this.picture = picture;
        this.obstacle = obstacle;
     //   this.rotation = rotation;
    }

    public ImageIcon getPicture() {
        return picture;
    }

}
