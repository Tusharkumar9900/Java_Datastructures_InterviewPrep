package org.example.DesignPattern;


//WeightMachine Interface :
//                          This interface defines a method getWeightInPound() that returns the weight in pounds.
//This interface acts as the Adaptee in the Adapter Design Pattern.

//adaptee
interface WeightMachine{
    //return the weight in pound
    public double getWeightInPound();
}


//also we have different type of weight machine and this also considered in adaptee.
class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound(){
        return 28;
    }
}



//WeightMachineAdapter Interface: This interface defines a method getWeightInKg() that returns the weight in kilograms.
//This interface acts as the Adapter Interface in the pattern.
//now this is Adapter Interface
interface WeightMachineAdapter{
    public double getWeightInKg();
}


//concrete Adapter
class WeightMachineAdapterImpl implements WeightMachineAdapter{

    //has-a relation with Existing Interface(Adaptee)
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg(){
        double weightInPound = weightMachine.getWeightInPound();

        //conversion in kgs
        double weightInKg = weightInPound*.45;
        return weightInKg;
    }

}


//client
public class Adapter_DesignPattern {
    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
