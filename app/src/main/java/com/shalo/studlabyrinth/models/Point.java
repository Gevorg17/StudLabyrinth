package com.shalo.studlabyrinth.models;

import java.util.HashSet;
import java.util.Set;

public class Point {


    private int id;

    private String name;
    private double x;
    private double y;
    private String status;

    private Set<Way> ways = new HashSet<>();

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(int id, String name, double x, double y, String status) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public int calcDistance(Point other_point) {
        double delta_x = this.x - other_point.x;
        double delta_y = this.y - other_point.y;
        int distance = (int) Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));

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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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