package com.shalo.studentlabyrunth.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
public class Way {

    @Id
    private Integer id;

    private String beginning_point_name;
    private String end_point_name;

    private Integer map_id;

    @ManyToMany
    @JoinTable (
            name = "point_links",
            joinColumns = @JoinColumn(name = "way_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id")
    )
    @JsonManagedReference
    private List<Point> points = new ArrayList<>();

    public Way() {

    }

    public Way(int id,String beginning_point_name, String end_point_name, int map_id) {
        this.id = id;
        this.beginning_point_name = beginning_point_name;
        this.end_point_name = end_point_name;
        this.map_id = map_id;
    }

    public boolean isEnd(String point_name) {
        if (this.end_point_name.equals(point_name) || this.beginning_point_name.equals(point_name)) return true;

        return false;
    }

    public int calcLength() {

        int length = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            Point current_point = points.get(i);
            Point adjacent_point = points.get(i + 1);

            length += current_point.calcDistance(adjacent_point);
        }
        return length;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeginning_point_name() {
        return beginning_point_name;
    }

    public void setBeginning_point_name(String beginning_point_name) {
        this.beginning_point_name = beginning_point_name;
    }

    public Integer getMap_id() {
        return map_id;
    }

    public void setMap_id(Integer map_id) {
        this.map_id = map_id;
    }

    public String getEnd_point_name() {
        return end_point_name;
    }

    public void setEnd_point_name(String end_point_name) {
        this.end_point_name = end_point_name;
    }

    @Override
    public String toString() {
        return "Первая точка: " + this.beginning_point_name + " ; Вторая точка: " + this.end_point_name + "; map_id: " + this.map_id;
    }
}
