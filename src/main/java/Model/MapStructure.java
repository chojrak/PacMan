package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MapStructure {

    public static Square[][] Map = new Square[31][28];
    private static HashMap<String, Image> elements = new HashMap<String, Image>();
    private static int gateHorizontal = 13;
    private static int getGateVertical = 12;
    static int[][] pacmanMap = {
            {6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 12, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 13},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 2, 8, 8, 9, 0, 2, 8, 8, 8, 9, 0, 7, 15, 0, 2, 8, 8, 8, 9, 0, 2, 8, 8, 9, 0, 3},
            {3, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 7, 15, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 3},
            {3, 0, 17, 8, 8, 16, 0, 17, 8, 8, 8, 16, 0, 18, 21, 0, 17, 8, 8, 8, 16, 0, 17, 8, 8, 16, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 2, 8, 8, 9, 0, 2, 9, 0, 2, 8, 8, 8, 8, 8, 8, 9, 0, 2, 9, 0, 2, 8, 8, 9, 0, 3},
            {3, 0, 17, 8, 8, 16, 0, 1, 1, 0, 17, 8, 8, 9, 2, 8, 8, 16, 0, 1, 1, 0, 17, 8, 8, 16, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 3},
            {23, 10, 10, 10, 10, 13, 0, 1, 17, 8, 8, 9, 0, 1, 1, 0, 2, 8, 8, 16, 1, 0, 6, 10, 10, 10, 10, 22},
            {0, 0, 0, 0, 0, 3, 0, 1, 2, 8, 8, 16, 0, 17, 16, 0, 17, 8, 8, 9, 1, 0, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 1, 1, 0, 6, 10, 10, 27, 27, 10, 10, 13, 0, 1, 1, 0, 3, 0, 0, 0, 0, 0},
            {10, 10, 10, 10, 10, 22, 0, 17, 16, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 17, 16, 0, 23, 10, 10, 10, 10, 10},
            {28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28},
            {10, 10, 10, 10, 10, 13, 0, 2, 9, 0, 23, 10, 10, 10, 10, 10, 10, 22, 0, 2, 9, 0, 6, 10, 10, 10, 10, 10},
            {0, 0, 0, 0, 0, 3, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 1, 1, 0, 2, 8, 8, 8, 8, 8, 8, 9, 0, 1, 1, 0, 3, 0, 0, 0, 0, 0},
            {6, 10, 10, 10, 10, 22, 0, 17, 16, 0, 17, 8, 8, 9, 2, 8, 8, 16, 0, 17, 16, 0, 23, 10, 10, 10, 10, 13},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 2, 8, 8, 9, 0, 2, 8, 8, 8, 9, 0, 1, 1, 0, 2, 8, 8, 8, 9, 0, 2, 8, 8, 9, 0, 3},
            {3, 0, 17, 8, 9, 1, 0, 17, 8, 8, 8, 16, 0, 17, 16, 0, 17, 8, 8, 8, 16, 0, 1, 2, 8, 16, 0, 3},
            {3, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 3},
            {5, 14, 20, 0, 1, 1, 0, 2, 9, 0, 2, 8, 8, 8, 8, 8, 8, 9, 0, 2, 9, 0, 1, 1, 0, 19, 14, 25},
            {4, 24, 21, 0, 17, 16, 0, 1, 1, 0, 17, 8, 8, 9, 2, 8, 8, 16, 0, 1, 1, 0, 17, 16, 0, 18, 24, 26},
            {3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 2, 8, 8, 8, 8, 16, 17, 8, 8, 9, 0, 1, 1, 0, 2, 8, 8, 16, 17, 8, 8, 8, 8, 9, 0, 3},
            {3, 0, 17, 8, 8, 8, 8, 8, 8, 8, 8, 16, 0, 17, 16, 0, 17, 8, 8, 8, 8, 8, 8, 8, 8, 16, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {23, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 22}
    };



    public static void generatePacmanMap() {
        for (int i = 0; i <= 28; i++) {
            String x = "wall" + i;
            try {
                Image img = ImageIO.read(new File("src\\main\\resources\\walls\\wall" + i + ".png"));
                elements.put(x, img);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fillWithTreats();
        }



    }

    public static int getGateHorizontal() {
        return gateHorizontal;
    }

    public static int getGetGateVertical() {
        return getGateVertical;
    }

    public static void fillWithTreats (){
        for (int i = 0; i <= 29; i++)
            for (int j = 0; j <= 27; j++) {
                String treat = "none";
                if (i == 3 && j == 1 || i == 3 && j == 26 || i == 22 && j == 1 || i == 22 && j == 26) treat = "bigDot";
                else if (((i < 9 && i != 3 || i > 18) && pacmanMap[i][j] == 0)) treat = "smallDot";
                else if ((j == 6 || j == 21) && pacmanMap[i][j] == 0) treat = "smallDot";
                else if (i == 3 && (j == 1 || j == 26)) treat = "smallDot";
                else if (i == 3 && j == 12) treat = "smallDot";
                else if (i == 3 && j == 15) treat = "smallDot";
                Map[i][j] = new Square(elements.get("wall" + pacmanMap[i][j]), (pacmanMap[i][j] > 0 && pacmanMap[i][j] < 28),
                        (pacmanMap[i][j] == 28), treat);
            }
    }
}


