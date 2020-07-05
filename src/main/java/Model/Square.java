package Model;

import javax.swing.*;
import java.awt.*;

public class Square {

    private Image picture;
    private boolean obstacle;
    private boolean treat;
   // private int rotation;

    public Square(Image picture, boolean obstacle, boolean treat) {
        this.picture = picture;
        this.obstacle = obstacle;
        this.treat = treat;
     //   this.rotation = rotation;
    }

    public Image getPicture() {
        return picture;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public boolean isTreat() {
        return treat;
    }

    public void setTreat(boolean treat) {
        this.treat = treat;
    }
}
