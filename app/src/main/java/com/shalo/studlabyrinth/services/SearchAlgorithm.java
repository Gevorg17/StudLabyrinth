package com.shalo.studlabyrinth.services;

import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;

import java.io.IOException;
import java.util.List;

public interface SearchAlgorithm {

    public List<Point> search(Route route) throws IOException;
}
