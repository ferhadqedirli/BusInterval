package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws ParseException {
        Date startDate = sdf.parse("09/11/2022 06:00");
        Date finishDate = sdf.parse("09/11/2022 23:00");

        RespArrivalTimeList response = calculateInterval(startDate, finishDate, 120, 30, 3, 8);
        System.out.println(response);
    }

    public static RespArrivalTimeList calculateInterval(Date startDate, Date finishDate, Integer departurePeriod, Integer returnPeriod, Integer numberOfBus, Integer lengthOfLine) {
        RespArrivalTimeList response = new RespArrivalTimeList();
        List<ArrivalTime> arrivalTimeList = new ArrayList<>();
        int timeOfPeriod = departurePeriod + returnPeriod;
        int intervalBetweenBuses = timeOfPeriod / numberOfBus;
        for (int i = 1; i <= numberOfBus; i++) {
            List<Date> arrivalTimeAList = new ArrayList<>();
            List<Date> arrivalTimeBList = new ArrayList<>();
            Date date = startDate;
            date = i != 1 ? addMinutesToDate(intervalBetweenBuses * (i - 1), date) : startDate;
            ArrivalTime arrivalTime = new ArrivalTime();
            while (date.compareTo(finishDate) <= 0) {
                arrivalTimeAList.add(date);
                date = addMinutesToDate(departurePeriod, date);
                if (date.compareTo(finishDate) >= 0)
                    break;
                arrivalTimeBList.add(date);
                date = addMinutesToDate(returnPeriod, date);
            }
            arrivalTime.setArrivalTimesA(arrivalTimeAList);
            arrivalTime.setArrivalTimesB(arrivalTimeBList);
            arrivalTimeList.add(arrivalTime);
        }
        response.setArrivalTimeList(arrivalTimeList);
        response.setPeriodTime(timeOfPeriod);
        response.setInterval(timeOfPeriod / numberOfBus);
        response.setExploitation(((double) lengthOfLine / timeOfPeriod * 60));
        response.setNumberOfPeriod(getNumberOfPeriod(startDate, finishDate, timeOfPeriod).intValue());
        return response;
    }

    public static Date addMinutesToDate(Integer minute, Date dateTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(dateTime);
        long timeInSecs = date.getTimeInMillis();
        return new Date(timeInSecs + (minute * 60 * 1000));
    }

    public static Date addHoursToDate(Integer hour) {
        Calendar date = Calendar.getInstance();
        long timeInSecs = date.getTimeInMillis();
        return new Date(timeInSecs + (hour * 60 * 60 * 1000));
    }

    public static Long getNumberOfPeriod(Date startDate, Date finishDate, Integer timeOfPeriod) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        long startDateMillis = date.getTimeInMillis();
        date.setTime(finishDate);
        long finishDateMillis = date.getTimeInMillis();
        return Math.round(((double) finishDateMillis - startDateMillis) / (1000L * 60 * timeOfPeriod) + 1);
    }

    public static String getTimeToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date).substring(11, 16);
    }
}
