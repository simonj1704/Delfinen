package src;

import java.util.Comparator;

public class TrainingTimesComparator implements Comparator<EliteSwimmer> {

    public int compare(EliteSwimmer e1, EliteSwimmer e2){
        return Double.compare(e1.getTrainingTimes(), e2.getTrainingTimes());
    }

}
