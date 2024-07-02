package org.example.DesignPattern;

public class SingletonPattern
{
    //step 1 initializing  a variable
    private static SingletonPattern patterninstance = null;

    //step 2 creating a constructor of private type due to which object are not created
    private SingletonPattern()
    {

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


}
