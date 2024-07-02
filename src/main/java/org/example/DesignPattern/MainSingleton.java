package org.example.DesignPattern;

public class MainSingleton {
    public static void main(String[] args) {

        //this we are doing lazy instantiation - pattern1 and pattern01
        SingletonPattern pattern1 =  SingletonPattern.getpatterninstance();
        System.out.println(pattern1.hashCode());

        SingletonPattern pattern01 = SingletonPattern.getpatterninstance();
        System.out.println(pattern01.hashCode());

//-------------------------------------------------------------------------------------------

        System.out.println("using early instantiation");
        System.out.println(SingletonPatternEarlyInstantiation.getSingletonPatternEarlyInstantiation().hashCode());
        System.out.println(SingletonPatternEarlyInstantiation.getSingletonPatternEarlyInstantiation().hashCode());
    }

}
