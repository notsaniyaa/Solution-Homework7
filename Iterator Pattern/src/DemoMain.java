import iterators.BingeIterator;
import model.Episode;
import model.Season;
import model.Series;

public class DemoMain {
    public static void main(String[] args) {
        Series series = new Series();

        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1", 1200));
        season1.addEpisode(new Episode("S1E2", 1300));
        series.addSeason(season1);

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1", 1400));
        season2.addEpisode(new Episode("S2E2", 1500));
        series.addSeason(season2);

        System.out.println("--- Normal Order ---");
        for (Episode e : season1) {
            System.out.println(e.getTitle());
        }

        System.out.println("--- Binge Watch ---");
        BingeIterator bingeIterator = new BingeIterator(series);
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }
    }
}

