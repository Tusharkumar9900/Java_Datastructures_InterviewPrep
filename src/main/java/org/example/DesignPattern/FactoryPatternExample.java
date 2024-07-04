package org.example.DesignPattern;

// Step-1 : ->  Product interface
interface Logger{
    void log(String message);
}

//Concrete product classes
class ConsoleLogger implements Logger{
    @Override
    public void log(String message){
        System.out.println("Console logging happen here : "+ message);
    }
}

class FileLogger implements Logger{
    @Override
    public void log(String message){
        System.out.println("File Logging happen here: "+ message);
    }
}

class DatabaseLogger implements Logger{
    @Override
    public void log(String message){
        System.out.println("Database Logging happen here: "+ message);
    }
}

// Step 3 : -> Factory class (it will return the type of the logger based on the input
class LoggerFactory{
    public static Logger getLogger(String type){
        return switch(type){
            case "console"-> new ConsoleLogger();
            case "file"-> new FileLogger();
            case "database"-> new DatabaseLogger();
            default -> throw new IllegalArgumentException("Unknown Logger");
        };
    }
}
public class FactoryPatternExample {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger("console");
        log.log("this is a console log message");

        log = LoggerFactory.getLogger("file");
        log.log("this is a file log message");

        log = LoggerFactory.getLogger("database");
        log.log("this is a database log message");
    }
}
