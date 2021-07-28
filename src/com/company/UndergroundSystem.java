package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class UndergroundSystem {
    int customerId;
    String stationName;
    int t;
    Hashtable<Integer,UndergroundSystem> sys = new Hashtable<>();
    Hashtable<String,Double> average = new Hashtable<>();
    Hashtable<String,Integer> noVisits = new Hashtable<>();

    public UndergroundSystem(int customerId, String stationName,int t){
        this.customerId = customerId;
        this.stationName = stationName;
        this.t = t;
    }

    public UndergroundSystem(){

    }

    public void checkIn(int id, String stationName, int t) {
        if(sys.get(id)==null){
            sys.put(id,new UndergroundSystem(id,stationName,t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(sys.get(id)!=null){
            Double aver = average.get(sys.get(id).stationName+stationName);
            if(aver!=null){
                //System.out.println(average.get(sys.get(id).stationName + stationName));
                noVisits.put(sys.get(id).stationName + stationName,noVisits.get(sys.get(id).stationName + stationName)+1);
                //System.out.println("noVisitas no null: "+noVisits.get(sys.get(id).stationName + stationName));
                average.put(sys.get(id).stationName + stationName, (aver+(t - sys.get(id).t)));
            }else {
                noVisits.put(sys.get(id).stationName + stationName,1);
                //System.out.println("noVisitas: "+noVisits.get(sys.get(id).stationName + stationName));
                //System.out.println(average.get(sys.get(id).stationName + stationName));
                average.put(sys.get(id).stationName + stationName, (double) (t - sys.get(id).t));
            }
            sys.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {

        return average.get(startStation+endStation)/noVisits.get(startStation + endStation);
    }

    public static void main(String[] args) throws IOException {
        UndergroundSystem undergroundSystem  = new UndergroundSystem();
        /*undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));*/

        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }
}
