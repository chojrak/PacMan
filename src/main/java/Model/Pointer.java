package Model;

import View.Menu;

import javax.swing.*;

public class Pointer {
    int verticalPosition;
    ImageIcon pic;
    Menu menu;

    {
        pic = new ImageIcon("src\\main\\resources\\pacman\\pacmanRight1.png");
        verticalPosition = 325;

    }

    public Pointer(Menu menu) {
        this.menu = menu;
    }

    public void goDown() {
        if (verticalPosition < 421) {
            verticalPosition += 48;
            menu.repaint();
        }
    }

    public void goUp() {
        if (verticalPosition > 325) {
            verticalPosition -= 48;
            menu.repaint();
        }
    }




    public int getVerticalPosition() {
        return verticalPosition;
    }


    public ImageIcon getPic() {
        return pic;
    }
}
