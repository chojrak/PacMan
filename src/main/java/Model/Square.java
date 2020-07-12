package Model;

import java.awt.*;

public class Square {

    private Image picture;
    private boolean obstacle;
    private boolean teleport;
    private String treat;
   // private int rotation;

    public Square(Image picture, boolean obstacle, boolean teleport, String treat) {
        this.picture = picture;
        this.obstacle = obstacle;
        this.teleport = teleport;
        this.treat = treat;
     //   this.rotation = rotation;
    }

    public Image getPicture() {
        return picture;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public boolean isTeleport() {
        return teleport;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }
}
