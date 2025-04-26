package iterators;

import java.util.Iterator;
import java.util.List;
import model.Episode;
import model.EpisodeIterator;
import model.Season;
import model.Series;

public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int seasonIndex = 0;
    private Iterator<Episode> currentIterator;

    public BingeIterator(Series series) {
        this.seasons = series.getSeasons();
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).iterator();
        }
    }

    @Override
    public boolean hasNext() {
        while ((currentIterator == null || !currentIterator.hasNext()) && seasonIndex < seasons.size() - 1) {
            seasonIndex++;
            currentIterator = seasons.get(seasonIndex).iterator();
        }
        return currentIterator != null && currentIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new RuntimeException("No more episodes");
        }
        return currentIterator.next();
    }
}
