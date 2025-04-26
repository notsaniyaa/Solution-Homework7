package model;

import model.Episode;

public interface EpisodeIterator {
    boolean hasNext();
    Episode next();
}
