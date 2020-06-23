package Model;

import javax.swing.*;

public class Square {

    private ImageIcon picture;
    private boolean obstacle;
    private boolean treat;
   // private int rotation;

    public Square(ImageIcon picture, boolean obstacle, boolean treat) {
        this.picture = picture;
        this.obstacle = obstacle;
        this.treat = treat;
     //   this.rotation = rotation;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public boolean isTreat() {
        return treat;
    }
}
