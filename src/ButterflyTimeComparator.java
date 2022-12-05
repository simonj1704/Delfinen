package src;

import java.util.Comparator;

public class ButterflyTimeComparator implements Comparator<EliteSwimmer> {
    public int compare(EliteSwimmer e1, EliteSwimmer e2) {
        return Double.compare(e1.getTrainingTime("butterfly"), e2.getTrainingTime("butterfly"));
    }

}
