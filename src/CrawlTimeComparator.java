package src;

import java.util.Comparator;

public class CrawlTimeComparator implements Comparator<EliteSwimmer> {
    public int compare(EliteSwimmer e1, EliteSwimmer e2) {
        return Double.compare(e1.getTrainingTime("crawl"), e2.getTrainingTime("crawl"));
    }

}
