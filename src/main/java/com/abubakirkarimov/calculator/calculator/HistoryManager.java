package com.abubakirkarimov.calculator.calculator;

import java.util.ArrayList;

public class HistoryManager{

    public ArrayList<Double> history = new ArrayList<>();

    public void addHistory(double number){
        if(history.size() >= 10){
            history.remove(0);
            history.add(number);
        }else{
            history.add(number);
        }
    }

    public void getHistory(){
        System.out.println("--- History ---");
        for(int i=0;i<history.size();i++){
            System.out.println(i+1+". Result: "+history.get(i));
        }
    }
    public void lastOperation(){
        System.out.println("Last operation: " + history.get(history.size()-1));
    }

    public void clearHistory(){
        history.clear();
        System.out.println("History has been cleared.");
    }
}


