package com.example.myapplication;

import androidx.room.Entity;


public class Company {
    public String name, catchPhrase, bs;

    public Company() {}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public String getCatchPhrase() {return this.catchPhrase;}
    public void setCatchPhrase(String catchPhrase) {this.catchPhrase = catchPhrase;}
    public String getBs() {return this.bs;}
    public void setBs(String bs) {this.bs = bs;}
}
