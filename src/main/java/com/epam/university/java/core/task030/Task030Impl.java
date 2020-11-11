package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        int res;
        try {
            res = dateEnd.compareTo(dateStart);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return res;
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return (instantEnd.getEpochSecond() - instantStart.getEpochSecond());
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return (localDate.getDayOfWeek());
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        DayOfWeek init = localDate.getDayOfWeek();
        int daysToAdd = 0;
        DayOfWeek weekend = DayOfWeek.SATURDAY;
        switch (init) {
            case MONDAY:
                daysToAdd = 5;
                break;
            case TUESDAY:
                daysToAdd = 4;
                break;
            case WEDNESDAY:
                daysToAdd = 3;
                break;
            case THURSDAY:
                daysToAdd = 2;
                break;
            case FRIDAY:
                daysToAdd = 1;
                break;
            case SATURDAY:
                daysToAdd = 7;
                break;
            case SUNDAY:
                daysToAdd = 6;
                break;
            default:
                break;
        }
        LocalDate fin = localDate.plusDays(daysToAdd);
        return fin;
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        return LocalTime.parse(timeString, formatter);
    }

}
