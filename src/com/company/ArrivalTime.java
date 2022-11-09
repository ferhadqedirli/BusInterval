package com.company;

import java.util.Date;
import java.util.List;

public class ArrivalTime {
    private List<Date> arrivalTimesA;
    private List<Date> arrivalTimesB;

    public List<Date> getArrivalTimesA() {
        return arrivalTimesA;
    }

    public void setArrivalTimesA(List<Date> arrivalTimeA) {
        this.arrivalTimesA = arrivalTimeA;
    }

    public List<Date> getArrivalTimesB() {
        return arrivalTimesB;
    }

    public void setArrivalTimesB(List<Date> arrivalTimeB) {
        this.arrivalTimesB = arrivalTimeB;
    }

    @Override
    public String toString() {
        return "ArrivalTime{" +
                "arrivalTimesA=" + arrivalTimesA +
                ", arrivalTimesB=" + arrivalTimesB +
                '}';
    }
}
