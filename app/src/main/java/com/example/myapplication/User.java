package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "website")
    public String website;

    //public Address address;
    //public Geo geo;
    /*
     * {
     *     "id": 1,
     *     "name": "Leanne Graham",
     *     "username": "Bret",
     *     "email": "Sincere@april.biz",
     *     "address": {
     *       "street": "Kulas Light",
     *       "suite": "Apt. 556",
     *       "city": "Gwenborough",
     *       "zipcode": "92998-3874",
     *       "geo": {
     *         "lat": "-37.3159",
     *         "lng": "81.1496"
     *       }
     *     },
     *     "phone": "1-770-736-8031 x56442",
     *     "website": "hildegard.org",
     *     "company": {
     *       "name": "Romaguera-Crona",
     *       "catchPhrase": "Multi-layered client-server neural-net",
     *       "bs": "harness real-time e-markets"
     *     }
     */

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /*public String getStreet() { return this.address.getStreet(); }
    public void setStreet(String street) { this.address.setStreet(street); }
    public String getSuit() { return this.address.getSuite(); }
    public void setSuite(String suite) { this.address.setSuite(suite); }
    public String getCity() { return address.getCity(); }
    public void setCity(String city) {
        this.address.setCity(city);
    }
    public String getZipcode() { return this.address.getZipcode(); }
    public void setZipcode(String code) { this.address.setZipcode(code); }
    public double getLatitude() { return this.geo.getLat(); }
    public void setLatitude(double latitude) { this.geo.setLat(latitude); }
    public double getLongitude() {
        return this.geo.getLng();
    }
    public void setLongitude(double longitude) { this.geo.setLng(longitude); }*/
     /*"company": {
     *       "name": "Romaguera-Crona",
     *       "catchPhrase": "Multi-layered client-server neural-net",
     *       "bs": "harness real-time e-markets"
                *     }
      */

     /*"address": {
     *       "street": "Kulas Light",
     *       "suite": "Apt. 556",
     *       "city": "Gwenborough",
     *       "zipcode": "92998-3874",
     *       "geo": {
     *         "lat": "-37.3159",
     *         "lng": "81.1496"
                    *       }
      */

     /*"geo": {
     *         "lat": "-37.3159",
     *         "lng": "81.1496"
                *       }
      */
}
