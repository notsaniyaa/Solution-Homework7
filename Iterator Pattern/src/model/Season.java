package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import iterators.SeasonIterator;
import iterators.ReverseSeasonIterator;
import iterators.ShuffleSeasonIterator;
import model.Episode;
import model.EpisodeIterator;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator createSeasonIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator() {
        return new ShuffleSeasonIterator(episodes);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}

