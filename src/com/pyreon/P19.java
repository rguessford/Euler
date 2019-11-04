package com.pyreon;

/**
 * Counting Sundays
 *
 * Problem 19
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class P19 {
    public static void main(String[] args) {
        int cntr = 0;
        long days = 366;
        for (int i = 1901; i < 2001; i++) {
            //jan
            days += 31;
            if(days % 7 == 0) cntr ++;
            //feb
            if(i % 4 == 0 && (i%100 != 0 || i%400 == 0)){
                days+=29;
            } else
                days+=28;
            if(days % 7 == 0) cntr ++;
            //mar
            days += 31;
            if(days % 7 == 0) cntr ++;
            //apr
            days += 30;
            if(days % 7 == 0) cntr ++;
            //may
            days += 31;
            if(days % 7 == 0) cntr ++;
            //jun
            days += 30;
            if(days % 7 == 0) cntr ++;
            //jul
            days += 31;
            if(days % 7 == 0) cntr ++;
            //aug
            days += 31;
            if(days % 7 == 0) cntr ++;
            //sep
            days += 30;
            if(days % 7 == 0) cntr ++;
            //oct
            days += 31;
            if(days % 7 == 0) cntr ++;
            //nov
            days += 30;
            if(days % 7 == 0) cntr ++;
            //dec
            days += 31;
            if(days % 7 == 0 && i != 2000) cntr ++;
            System.out.println(days);
        }
        System.out.println(cntr);
    }
}
