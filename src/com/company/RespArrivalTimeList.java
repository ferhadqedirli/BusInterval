package com.company;

import java.util.List;

public class RespArrivalTimeList {
    private Integer periodTime;
    private Integer interval;
    private Double exploitation;
    private Integer numberOfPeriod;
    private List<ArrivalTime> arrivalTimeList;

    public RespArrivalTimeList() {
    }

    public Integer getNumberOfPeriod() {
        return numberOfPeriod;
    }

    public void setNumberOfPeriod(Integer numberOfPeriod) {
        this.numberOfPeriod = numberOfPeriod;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Double getExploitation() {
        return exploitation;
    }

    public void setExploitation(Double exploitation) {
        this.exploitation = exploitation;
    }

    public List<ArrivalTime> getArrivalTimeList() {
        return arrivalTimeList;
    }

    public void setArrivalTimeList(List<ArrivalTime> arrivalTimeList) {
        this.arrivalTimeList = arrivalTimeList;
    }

    @Override
    public String toString() {
        return "RespArrivalTimeList{" +
                "periodTime='" + periodTime + '\'' +
                ", interval='" + interval + '\'' +
                ", exploitation=" + exploitation +
                ", numberOfPeriod=" + numberOfPeriod +
                ", arrivalTimeList=" + arrivalTimeList +
                '}';
    }
}
