package org.example.DesignPattern;

import java.util.ArrayList;
import java.util.List;

//this is for stock in amazon interface.
interface StockObservable{
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();
}

interface NotificationAlertObserver
{
    public void update();
}

class IphoneObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();

    public int stockcount =0;

    @Override
    public void add(NotificationAlertObserver observer){
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer){
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers(){
        for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockcount ==0){
            notifySubscribers();
        }
        stockcount= stockcount+newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockcount;
    }

}

class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailid;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailid, StockObservable observable){
        this.observable = observable;
        this.emailid = emailid;
    }

    public void update(){
        sendMail(emailid, "product is in stock");
    }

    private void sendMail(String emailid, String msg){
        System.out.println("mail sent to : "+ emailid);
    }
}

class MobileAlertObserverImpl implements NotificationAlertObserver{
    String userName;
    StockObservable observable;

    public MobileAlertObserverImpl(String emailid, StockObservable observable){
        this.observable = observable;
        this.userName = userName;

    }

    public void update(){
        sendmsgonmobile(userName, "Product is in stock");
    }

    private void sendmsgonmobile(String userName, String msg){
        System.out.println("msg sent to "+ userName);
    }
}
public class Observer_DesignPattern {
    public static void main(String[] args) {
    StockObservable iphoneStockObservable = new IphoneObservableImpl();

    NotificationAlertObserver observer1 = new EmailAlertObserverImpl("tusharkumar34@gmail.com",iphoneStockObservable);

    iphoneStockObservable.add(observer1);

    iphoneStockObservable.setStockCount(10);
    }
}
