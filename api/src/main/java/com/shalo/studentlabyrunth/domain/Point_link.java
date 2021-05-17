package com.shalo.studentlabyrunth.domain;

public class Point_link {

    private int way_id;
    private int point_id;

    public Point_link(int way_id, int point_id) {
        this.way_id = way_id;
        this.point_id = point_id;
    }

    public int getWay_id() {
        return way_id;
    }

    public void setWay_id(int way_id) {
        this.way_id = way_id;
    }

    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    @Override
    public String toString() {
        return "Way id: " + this.way_id + "; point_id: " + this.point_id;
    }
}
