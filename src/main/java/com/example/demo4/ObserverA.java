package com.example.demo4;

public class ObserverA implements Observer{

    @Override
    public void handleNotify(String message) {
        System.out.println("观察者A正在处理通知..");
    }
}
