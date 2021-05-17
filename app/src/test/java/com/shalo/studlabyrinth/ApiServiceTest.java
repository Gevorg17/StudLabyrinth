package com.shalo.studlabyrinth;

import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.services.ApiService;
import com.shalo.studlabyrinth.services.WayFinder;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ApiServiceTest {
    @Test
    public void addition_isCorrect() throws ExecutionException, InterruptedException, IOException {
        WayFinder finder = new WayFinder();

        assertEquals(5, finder.find(new Route("Студгородок","ИКИТ","Корпус В")).size());
    }
}