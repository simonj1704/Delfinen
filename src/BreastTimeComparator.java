package src;

import java.util.Comparator;

public class BreastTimeComparator implements Comparator<EliteSwimmer> {
    public int compare(EliteSwimmer e1, EliteSwimmer e2) {
        double trainingTime1;
        double trainingTime2;
        if (e1.getTrainingTime("bryst") == 0) {
            trainingTime1 = 10000;
        } else {
            trainingTime1 = e1.getTrainingTime("bryst");
        }
        if (e2.getTrainingTime("bryst") == 0) {
            trainingTime2 = 10000;
        } else {
            trainingTime2 = e2.getTrainingTime("bryst");
        }
        return Double.compare(trainingTime1, trainingTime2);
    }
}
