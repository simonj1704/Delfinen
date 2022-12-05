package src;

import java.util.Comparator;

public class RygTimeComparator implements Comparator<EliteSwimmer> {


    public int compare(EliteSwimmer e1, EliteSwimmer e2) {
        return Double.compare(e1.getTrainingTime("ryg"), e2.getTrainingTime("ryg"));
    }

}
