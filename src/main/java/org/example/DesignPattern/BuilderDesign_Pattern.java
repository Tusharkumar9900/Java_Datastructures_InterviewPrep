package org.example.DesignPattern;

class Computer{

    private String HDD;
    private String RAM;
    private String NetworkCard;

    //we are declaring Optional parameters here
    private boolean isGraphicCardEnabled;
    private boolean isBluetoothEnabled;


    //declaring getters
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public String getNetworkCard() {
        return NetworkCard;
    }

    public boolean isGraphicCardEnabled() {
        return isGraphicCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }



    //creating private constructor
    private Computer(ComputerBuilder builder){
        this.HDD= builder.HDD;
        this.RAM = builder.RAM;
        this.NetworkCard = builder.NetworkCard;
        this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;

    }


    //inner class to create object
    public static class ComputerBuilder{

        //here we are taking the same fields which we are using above
        private String HDD;
        private String RAM;
        private String NetworkCard;


        //we are declaring Optional parameters here
        private boolean isGraphicCardEnabled;
        private boolean isBluetoothEnabled;


        //we are creating constructor for inner class, which are going to take public
        public ComputerBuilder(String HDD, String RAM, String NetworkCard){
            this.HDD=HDD;
            this.RAM=RAM;
            this.NetworkCard = NetworkCard;

        }


        //declaring setters
        //here we are returning ComputerBuilder So that we can return the class object
        //here we are doing method chaining
        public ComputerBuilder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setNetworkCard(String networkCard) {
            NetworkCard = networkCard;
            return this;
        }

        public ComputerBuilder setGraphicCardEnabled(boolean graphicCardEnabled) {
            isGraphicCardEnabled = graphicCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }


        //Method to build the object
        //build() method in the builder class that will return the object needed by the client program.
        //For this, we need to have a private constructor in the main class whose object needs to be constructed with the builder class as an argument.
        public Computer build(){
            return new Computer(this);
        }
    }
}


public class BuilderDesign_Pattern {
    public static void main(String[] args) {

        //creating a Computer object using the builder
        Computer computer = new Computer.ComputerBuilder("500gb","8gb","WireLess Network")
                .setGraphicCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Print the specifications of the computer
        System.out.println("HDD: " +
                computer.getHDD()); // Output HDD: 500 GB

        System.out.println("RAM: " +
                computer.getRAM()); // Output: RAM: 8 GB

        System.out.println("Graphics Card Enabled: " +
                computer.isGraphicCardEnabled()); // Output: Graphics Card Enabled: true

        System.out.println("Bluetooth Enabled: " +
                computer.isBluetoothEnabled()); // Output Bluetooth Enabled: true
    }
}
