package com.shalo.studentlabyrunth.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Map {

    @Id
    private int id;

    private String name;
    private int length;
    private int width;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "map_id")
    @JsonManagedReference
    private Set<Way> ways = new HashSet<>();

    public Map() {
    }

    public Map(int id,String name, int length, int width) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public List<Way> findWayByOnePointName(String point_name) {
        List<Way> ways = new ArrayList<>();

        for (Way way : this.ways) {
            if (way.isEnd(point_name)) ways.add(way);
        }

        return ways;
    }

    public Way findWayByTwoPointNames(String first_point_name, String second_point_name) {

        int min_length = 999999999;
        Way need_way = null;
        List<Way> ways = null;

        if (!first_point_name.equals("") && !second_point_name.equals("")) {
            for (Way way : this.ways) {
                if ((way.getBeginning_point_name().equals(first_point_name) && way.getEnd_point_name().equals(second_point_name))
                        || (way.getBeginning_point_name().equals(second_point_name) && way.getEnd_point_name().equals(first_point_name))) {
                    return way;
                }
            }
        }
        else if (first_point_name.equals("")) {
            ways = findWayByOnePointName(second_point_name);
        }
        else if (second_point_name.equals("")) {
            ways = findWayByOnePointName(first_point_name);
        }
        for (Way way : ways) {
            for (Point point : way.getPoints()) {
                if ((point.getName().equals(way.getEnd_point_name()) || point.getName().equals(way.getBeginning_point_name())) && !point.getName().equals(first_point_name) && !point.getName().equals(second_point_name)) {
                    if (point.getName().contains("Лестница")) {
                        if (way.calcLength() < min_length) {
                            min_length = way.calcLength();
                            need_way = way;
                        }
                    }
                }
            }
        }
        return need_way;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Way> getWays() {
        return ways;
    }

    public void setWays(Set<Way> ways) {
        this.ways = ways;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Название: " + this.name + "; Длина: " + this.length + "; Ширина: " + this.width;
    }

}
