package com.example.demo4;

public class ObserverB implements Observer{

    @Override
    public void handleNotify(String message) {
        System.out.println("观察者B正在处理通知。。");
    }
}
