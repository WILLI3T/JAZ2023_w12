package com.users.usersdata.model.projections;

public class PersonAverageProjection {

    double average;

    public PersonAverageProjection(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
