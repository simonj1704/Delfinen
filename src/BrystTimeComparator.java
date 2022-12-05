package src;

import java.util.Comparator;

public class BrystTimeComparator implements Comparator<EliteSwimmer> {
    public int compare(EliteSwimmer e1, EliteSwimmer e2) {
        return Double.compare(e1.getTrainingTime("bryst"), e2.getTrainingTime("bryst"));
    }

}
