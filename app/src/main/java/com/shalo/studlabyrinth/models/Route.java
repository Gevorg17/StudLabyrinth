package com.shalo.studlabyrinth.models;

public class Route {

    private int id;
    private String MapName;
    private String BeginningPointName;
    private String endPointName;

    public Route(String mapName, String beginningPointName, String endPointName) {
        MapName = mapName;
        BeginningPointName = beginningPointName;
        this.endPointName = endPointName;
    }

    public Route(int id, String mapName, String beginningPointName, String endPointName) {
        this.id = id;
        MapName = mapName;
        BeginningPointName = beginningPointName;
        this.endPointName = endPointName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMapName() {
        return MapName;
    }

    public void setMapName(String mapName) {
        MapName = mapName;
    }

    public String getBeginningPointName() {
        return BeginningPointName;
    }

    public void setBeginningPointName(String beginningPointName) {
        BeginningPointName = beginningPointName;
    }

    public String getEndPointName() {
        return endPointName;
    }

    public void setEndPointName(String endPointName) {
        this.endPointName = endPointName;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", MapName='" + MapName + '\'' +
                ", BeginningPointName='" + BeginningPointName + '\'' +
                ", endPointName='" + endPointName + '\'' +
                '}';
    }
}
