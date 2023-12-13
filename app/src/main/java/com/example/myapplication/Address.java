package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class Address {

    public String street;

    public String suite;

    public String city;

    public String zipcode;

    public Geo geo;

    public Address() {}

    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {return this.street;}

    public void setSuite(String suite) {
        this.suite = suite;
    }
    public String getSuite() {return this.suite;}

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {return this.city;}

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getZipcode() {return this.zipcode;}

    public Geo getGeo() {return this.geo;}
    public void setGeo(Geo g) { this.geo = g; }
}
