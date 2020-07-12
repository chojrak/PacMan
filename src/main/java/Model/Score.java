package Model;

import java.io.Serializable;

public class Score implements Comparable <Score>, Serializable {
    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Score s1) {
        if (score - s1.score  == 0) return name.compareTo(s1.name) ;
        else return s1.score - score;
    }

    @Override
    public String toString() {
        return name+" - "+score;
    }
}
