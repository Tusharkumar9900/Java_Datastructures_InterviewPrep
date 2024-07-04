package org.example.DesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class MainSingleton {
    public static void main(String[] args) throws Exception {

        //this we are doing lazy instantiation - pattern1 and pattern01
        SingletonPattern pattern1 =  SingletonPattern.getpatterninstance();
        System.out.println(pattern1.hashCode());

        SingletonPattern pattern01 = SingletonPattern.getpatterninstance();
        System.out.println(pattern01.hashCode());

//------------------------------------------------------------------------------------------------

        //in this we are printing using eager instantiation

//        System.out.println("using eager instantiation");
//        System.out.println(SingletonPatternEarlyInstantiation.getSingletonPatternEarlyInstantiation().hashCode());


// ------------------------------------------------------------------------------------------------


 //breaking the singleton pattern using three different method->
    //1.) using reflection
    //2.) using deserialization
    //3.) using cloning


        //breaking singleton pattern using reflection
Constructor<SingletonPattern> constructor = SingletonPattern.class.getDeclaredConstructor();
constructor.setAccessible(true);
SingletonPattern singletonUsingReflection = constructor.newInstance();
System.out.println("hashcode for breaking singleton"+" "+ singletonUsingReflection.hashCode());


//----------------------------------------------------------------
        System.out.println();
        //breaking singleton using deserialization

        //point to remember for serialization we need to implement serialization over another class of singletonpattern

        //first we make serialize our object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("patternbreak.ob"));
        oos.writeObject(pattern1);
        System.out.println("object serialized");


        //now we deserialized the object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("patternbreak.ob"));
        SingletonPattern brokenUsingDeserialization = (SingletonPattern) ois.readObject();
        System.out.println(brokenUsingDeserialization.hashCode());


//----------------------------------------------------------------------------------------------
System.out.println();
System.out.print("breaking using cloneable"+" ");

//first way to clone using creating instance of singletonpattern
SingletonPattern brokenSingletonUsingCloningInstance = (SingletonPattern) pattern1.clone();
System.out.print(brokenSingletonUsingCloningInstance.hashCode());
    }

}
