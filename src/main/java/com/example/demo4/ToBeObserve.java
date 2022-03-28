package com.example.demo4;

public interface ToBeObserve {
    public void addObserver(Observer observer) ;
    public void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message
     */
    public void notifyObserver(String message);

}
