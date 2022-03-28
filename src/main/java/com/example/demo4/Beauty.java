package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

public class Beauty implements ToBeObserve{
    List<Observer> observers;
    public  Beauty () {
        observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     *
     * @param message
     */
    @Override
    public void notifyObserver(String message) {
        for(Observer o : observers) {
            o.handleNotify(message);
        }
    }
}
