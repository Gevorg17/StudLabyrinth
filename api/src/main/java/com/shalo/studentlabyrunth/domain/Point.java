package com.shalo.studentlabyrunth.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Point {

    @Id
    private int id;

    private String name;
    private int x;
    private int y;
    private String status;

    @ManyToMany(mappedBy = "points")
    @JsonBackReference
    private Set<Way> ways = new HashSet<>();

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int id,String name, int dx, int dy, String status) {
        this.id = id;
        this.name = name;
        this.x = dx;
        this.y = dy;
        this.status = status;
    }

    public int calcDistance(Point other_point) {
        int delta_x = this.x - other_point.x;
        int delta_y = this.y - other_point.y;
        int distance = (int) Math.sqrt(Math.pow(delta_x,2) + Math.pow(delta_y,2));

        return distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Way> getWays() {
        return ways;
    }

    public void setWays(Set<Way> ways) {
        this.ways = ways;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int dx) {
        this.x = dx;
    }

    public int getY() {
        return y;
    }

    public void setY(int dy) {
        this.y = dy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Наименование: " + this.name + "; координата х:" + this.x + "; координата у:" + this.y + "; статус:" + this.status;
    }
}