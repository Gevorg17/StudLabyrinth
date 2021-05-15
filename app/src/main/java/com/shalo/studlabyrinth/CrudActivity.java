package com.shalo.studlabyrinth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.services.RouteRepository;

public class CrudActivity extends AppCompatActivity {
    private RouteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repository = new RouteRepository(this);

        repository.Insert(new Route("1","1","1"));
        repository.Insert(new Route("2","2","2"));
        repository.Insert(new Route("3","3","3"));

        System.out.println(repository.Select(1));
        System.out.println(repository.Select().size());

        repository.Delete(3);
        System.out.println(repository.Select().size());

        repository.DeleteAll();
        System.out.println(repository.Select().size());
    }
}
