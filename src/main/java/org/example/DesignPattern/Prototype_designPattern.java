package org.example.DesignPattern;

interface Prototype extends Cloneable{
    //clone method inside the interface
    Prototype clone() throws CloneNotSupportedException;
}
//concrete Prototype class
class Circle implements Prototype{
    private int radius;

    //making the constructor for the class
    public Circle(int radius){
        this.radius = radius;
    }

    //creating getter and setter
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    //to string method
    @Override
    public String toString() {
        return "Circle" +
                "radius = " + radius;
    }

    //if we didnot override this then our class shows error to make Circle class abstract
    @Override
    public  Circle clone() throws CloneNotSupportedException{
        //super.clone is the easiest way to do the shallow copy.
        return (Circle) super.clone(); // -> for shallow copy
    }

}



public class Prototype_designPattern {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);

        System.out.println("Original Circle :"+" "+circle1);

        try{
            // Cloning the original circle
            Circle circle2 = circle1.clone();
            System.out.println("Cloned Circle2 : " + circle2);

            // Modifying the cloned circle to show that it's a separate instance
            circle2.setRadius(10);
            System.out.println("Modified Cloned Circle: " + circle2);
            System.out.println("Original Circle after modification: " + circle1);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
