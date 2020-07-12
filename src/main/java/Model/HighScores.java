package Model;

import java.io.*;
import java.util.TreeSet;

public abstract class HighScores implements Serializable {

    public static TreeSet<Score> highScores = new TreeSet<Score>();

    static {
        readScores();
    }

    public static void addRecord(Score s) {
        if (goodGame(s)) highScores.add(s);
        if (highScores.size() > 10) highScores.pollLast();
        saveScores();
    }


    public static void readScores () {
        try {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\data.pac");
            ObjectInputStream ois = new ObjectInputStream(fis);
            highScores = (TreeSet<Score>) ois.readObject();
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean goodGame(Score s) {
        return (s.compareTo(highScores.last()) > 0 || highScores.size() < 10);
    }

    public static void saveScores () {
        try {
            FileOutputStream fos = new FileOutputStream("src\\main\\resources\\data.pac");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(highScores);
            oos.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        highScores.add(new Score("chojrak", 99999));
        highScores.add(new Score("Piotr M", 99999));
        highScores.add(new Score("piotrolot1", 0));
        highScores.add(new Score("piotrek96k", 0));
        highScores.add(new Score("piotrek96k", 0));
        saveScores();
    }
}
