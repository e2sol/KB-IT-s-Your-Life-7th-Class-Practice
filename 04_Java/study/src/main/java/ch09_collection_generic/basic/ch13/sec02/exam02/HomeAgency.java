package main.java.ch09_collection_generic.basic.ch13.sec02.exam02;

public class HomeAgency implements Rentable{
    public Home rent() {
        return new Home();
    }
}
