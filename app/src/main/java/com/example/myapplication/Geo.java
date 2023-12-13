package com.example.myapplication;

import androidx.room.Entity;


public class Geo {
    public double lat, lng;

    public Geo() {}

    public double getLat() {return this.lat;}
    public void setLat(double lat) {this.lat = lat;}
    public double getLng() {return this.lng;}
    public void setLng(double lng) {this.lng = lng;}
}
