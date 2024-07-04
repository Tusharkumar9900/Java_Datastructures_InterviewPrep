package org.example.DesignPattern;

//in this we working on singleton using the early instantiation
public class SingletonPatternEarlyInstantiation {

    //eager way of creating singleton object
    private static SingletonPatternEarlyInstantiation singleton = new SingletonPatternEarlyInstantiation();


    public static SingletonPatternEarlyInstantiation getSingletonPatternEarlyInstantiation(){

        return singleton;
    }
}
