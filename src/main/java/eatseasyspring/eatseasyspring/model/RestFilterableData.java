package eatseasyspring.eatseasyspring.model;

import java.util.List;


public class RestFilterableData {

    private float gpsLat;
    private float gpsLon;
    private List<String> restTypes;

    public RestFilterableData(float gpsLat, float gpsLon, List<String> restTypes) {
        this.gpsLat = gpsLat;
        this.gpsLon = gpsLon;
        this.restTypes = restTypes;
    }

    public RestFilterableData(RestFilterableData restFilterableData)
    {
        this.gpsLat = restFilterableData.gpsLat;
        this.gpsLon = restFilterableData.gpsLon;
        this.restTypes = restFilterableData.restTypes;
    }

    public void setGpsLat(float gpsLat) {
        this.gpsLat = gpsLat;
    }

    public void setGpsLon(float gpsLon) {
        this.gpsLon = gpsLon;
    }

    public void setRestTypes(List<String> restTypes) {
        this.restTypes = restTypes;
    }

    public float getGpsLat() {
        return gpsLat;
    }

    public float getGpsLon() {
        return gpsLon;
    }

    public List<String> getRestTypes() {
        return restTypes;
    }
}