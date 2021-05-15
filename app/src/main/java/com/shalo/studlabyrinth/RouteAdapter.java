package com.shalo.studlabyrinth;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.shalo.studlabyrinth.HistoryActivity;
import com.shalo.studlabyrinth.R;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.services.RouteRepository;

import java.util.List;

public class RouteAdapter extends ArrayAdapter<Route> {
    private RouteRepository repository;
    private LayoutInflater inflater;
    private int layout;
    private List<Route> routes;
    private Context context;

    public RouteAdapter(Context context, int layout, List<Route> routes) {
        super(context, layout, routes);
        this.layout = layout;
        this.routes = routes;
        this.inflater = LayoutInflater.from(context);
        repository = new RouteRepository(context);
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);

        Button routeButton = convertView.findViewById(R.id.route_button);
        Button deleteButton = convertView.findViewById(R.id.delete_button);

        Route route = routes.get(position);
        String routeName = String.format("%s %s %s",
                route.getMapName(),
                route.getBeginningPointName(),
                route.getEndPointName());

        routeButton.setText(routeName);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repository.Delete(route.getId());
                Intent intent = new Intent(context, HistoryActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
