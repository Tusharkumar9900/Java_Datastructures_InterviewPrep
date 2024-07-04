package org.example.DesignPattern;

import java.io.Serializable;

//for breaking singletonpattern we need to implement cloneable interface also
public class SingletonPattern implements Serializable, Cloneable
{
    //step 1 initializing  a variable
    private static SingletonPattern patterninstance = null;

    //step 2 creating a constructor of private type due to which object are not created
    private SingletonPattern()
    {
        //this is for preventing breaking of singleton pattern from reflection
//        if(patterninstance != null){
//            throw new RuntimeException("you can not break pattern");
//        }
    }

    //using lazy instantiation(yaani jb jarurt tb create hua) we are creating a object in method
    //in this when we call this method then object is created
    //if thread safety is concern for our object then we use synchronized here
    public static synchronized  SingletonPattern getpatterninstance()
    {
        //creating a object of this class
        if(patterninstance == null)
        {
            patterninstance = new SingletonPattern();
        }
        return patterninstance;
    }


    /*


    //using this method we prevent from breaking of singletonPattern from Deserialization.

    public Object readResolve()
    {
        return patterninstance;
     }


     */



    //for cloneable
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
