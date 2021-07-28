package com.company;

import java.io.IOException;

public class HandOfClock {

    static public double angleClock(int hour, int minutes) {
        float propocionalAngleHour = ((float) minutes/60) * 30;
        System.out.println("propocionalAngleHour "+propocionalAngleHour);

        double angleMinutes = 360 - ((60-minutes)*6);
        System.out.println("angleMinutes "+angleMinutes);

        if(hour==12){
            hour =0;
        }
        double angleHour = ((hour)*30) + propocionalAngleHour;
        System.out.println("angleHour "+angleHour);

        double finalAngle = Math.abs(angleMinutes-angleHour);

        if((360-finalAngle)<finalAngle)
            return 360-finalAngle;

        return finalAngle;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(angleClock(3,30));
    }
}
