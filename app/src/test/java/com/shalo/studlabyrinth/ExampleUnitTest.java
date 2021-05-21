package com.shalo.studlabyrinth;

import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.model.AppSearchAlgorithm;
import com.shalo.studlabyrinth.models.model.DBbringer;
import com.shalo.studlabyrinth.services.WayFinder;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        String points = DBbringer.getPoints();
        System.out.println(points);
        assertEquals(false,points.isEmpty());
    }
}