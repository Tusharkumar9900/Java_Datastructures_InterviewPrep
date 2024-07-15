package org.example.DesignPattern;

//information about PRODUCT
//creating abstract class

//Step 1: Define the Product Abstract Class
//The Phone class is an abstract class that defines the common properties and behaviors of all phone products.
//Each specific phone will extend this class.
abstract class Phone{
    String brand;
    String modelName;
    String bodytype;
    String phoneSize;

    //we didnot assign here, so we will assign these variable - subclasses of these.
    //like bodytype kia hoga and phone konsa hai.
    // Method to build the phone
    void BuildPhone(){
        System.out.println("Building phone of brand : "+ brand);
        System.out.println("Phone model is : "+ modelName);
        System.out.println("Size of phone is : "+ phoneSize);
        System.out.println("Body Type of Phone is : "+ bodytype);
    }

    // Method to assemble the phone
    void assemblePhone(){
        System.out.println("Assembly all the parts of phone");
    }

    // Method to pack the phone in a box
    void packPhoneInBox(){
        System.out.println("Packing of Phone");
    }
}



//Concrete classes of PRODUCT
//Step 2: Define Concrete Product Classes
//The Iphone12, Iphone13, SamsungS24, and SamsungS20 classes
//extend the Phone class and provide specific implementations for different phone models.

// Concrete class for iPhone 12
class Iphone12 extends Phone{
    Iphone12(){
        brand = "Iphone";
        modelName = "iphone 12";
        phoneSize = "5 inch";
        bodytype = "Metalic";
    }
}

// Concrete class for iPhone 13
class Iphone13 extends Phone{
    Iphone13(){
        brand = "Iphone";
        modelName = "Iphone 13";
        phoneSize = "5.4 inch";
        bodytype = "Metalic";
    }
        }

// Concrete class for Samsung S24
class Samsung extends Phone{
    Samsung(){
        brand ="Samsung";
        modelName = "Samsung s24";
        phoneSize = "5.6 inch";
        bodytype = "metalic";
    }
        }

// Concrete class for Samsung S20
class SamsungS20  extends Phone{
    SamsungS20(){
        brand = "Samsung";
        modelName = "Samsung s20";
        phoneSize = "5.5 inch";
        bodytype = "metallic";
    }
        }




//---------------------------------------------------------------------------------------------------

//Step 3: Define the Abstract Factory Class
//The Phonestore class is an abstract factory class that declares the orderPhone method.
//This method uses the createPhone method to create phone objects.
//The createPhone method is abstract and must be implemented by concrete subclasses.
abstract class Phonestore{
    public Phone orderPhone(String modelName){
        Phone phone;
        phone = createPhone(modelName);
        phone.BuildPhone();
        phone.assemblePhone();
        phone.packPhoneInBox();
        return phone;
    }


    //abstract method
    //this we will get from factory
    abstract Phone createPhone(String modelName);
}



//Step 4: Define Concrete Factory Classes
//The IphoneFactory and SamsungFactory classes extend the Phonestore class
//and provide specific implementations for creating iPhone and Samsung phones.

//subclasses of above phonestore

// Concrete factory for iPhones
class IphoneFactory extends Phonestore {

    @Override
    Phone createPhone(String modelName) {
    if(modelName.equals("iphone12"))
    {
        return new Iphone12();
    }else if(modelName.equals("iphone13")) {
        return new Iphone13();
}
return null;
}
}

// Concrete factory for Samsung phones
class SamsungFactory extends Phonestore{

    Phone createPhone(String modelName){
        if(modelName.equals("Samsung s24")){
            return new Samsung();
        }else if(modelName.equals("Samsung s20")){
            return new Samsung();
        }
        return null;
    }
}

//Step 5: Client Code
//The Abstract_Design_PatternExample class demonstrates the usage of the abstract factory pattern to create and order phones.
public class Abstract_Design_PatternExample {
    public static void main(String[] args) {
Phonestore iphone = new IphoneFactory();
iphone.orderPhone("iphone12");

System.out.println();

Phonestore samsung = new SamsungFactory();
samsung.orderPhone("Samsung s24");
    }

}
