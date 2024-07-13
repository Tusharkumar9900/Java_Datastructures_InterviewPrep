package org.example.DesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

//one mistake we have in this code is we didnot use singleton pattern with this and this not thread safety so tio make thread safe we have to make synchronized by using singleton design pattern
//now the correct is ....
//First Part is Our Resource
class DbConnection{
Connection mysqlConnection;

DbConnection(){
    try{
        mysqlConnection = DriverManager.getConnection("url","username","Password");
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
}

//second we create our resource Pool Manager
class DbConnectionPoolManager {
    List<DbConnection> freeConnectionInPool = new ArrayList<>();
    List<DbConnection> ConnectionCurrentlyInUSe = new ArrayList<>();

    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;
    //for making the singleton design pattern
    //step -1 initalize the variable with private static
    private static DbConnectionPoolManager dbConnectionPoolManagerInstance = null;

    //creating a constructor, and make this constructor private for singletn pattern (step -2)
    private DbConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnectionInPool.add(new DbConnection());
        }
    }
    //step -3
    //method to return instance of the class
    public static DbConnectionPoolManager getInstance(){
        if(dbConnectionPoolManagerInstance == null){
            synchronized(DbConnectionPoolManager.class){
                dbConnectionPoolManagerInstance = new DbConnectionPoolManager();
            }
        }
        return dbConnectionPoolManagerInstance;
    }

    //if any client want to call this method because we have put this method as public, make this synchronized for thread safety and singleton design pattern in use
    public  synchronized DbConnection getDbConnection() {
        if (freeConnectionInPool.isEmpty() && ConnectionCurrentlyInUSe.size() < MAX_POOL_SIZE) {
            freeConnectionInPool.add(new DbConnection());

            System.out.println("creating new connection and putting into pool, free pool size" + freeConnectionInPool.size());
        } else if (freeConnectionInPool.isEmpty() && ConnectionCurrentlyInUSe.size() >= MAX_POOL_SIZE) {
            System.out.println("can not create new Dbconnection, as max limit reached");
            return null;
        }
        DbConnection dbconnection = freeConnectionInPool.remove(freeConnectionInPool.size() - 1);
        ConnectionCurrentlyInUSe.add(dbconnection);
        System.out.println("adding db connection into use pool, size : " + ConnectionCurrentlyInUSe.size());
        return dbconnection;
    }

    public synchronized void releaseDbconnection(DbConnection dbConnection) {
        if (dbConnection != null) {
            ConnectionCurrentlyInUSe .remove(dbConnection);
            System.out.println("Removing db Connection from Use pool, size: "+ ConnectionCurrentlyInUSe.size());
            freeConnectionInPool.add(dbConnection);
            System.out.println("Adding db Connection into free pool, size : "+ freeConnectionInPool.size());

        }

    }

}
//client
public class ObjectPool_DesignPattern {
    public static void main(String[] args) {
DbConnectionPoolManager poolmanager = DbConnectionPoolManager.getInstance();
        DbConnection dbConnection1 = poolmanager.getDbConnection();
        DbConnection dbConnection2 = poolmanager.getDbConnection();
        DbConnection dbConnection3 = poolmanager.getDbConnection();
        DbConnection dbConnection4 = poolmanager.getDbConnection();
        DbConnection dbConnection5 = poolmanager.getDbConnection();
        DbConnection dbConnection6 = poolmanager.getDbConnection();
//        DbConnection dbConnection7 = poolmanager.getDbConnection();

        poolmanager.getDbConnection();
        poolmanager.releaseDbconnection(dbConnection6);


    }
}


//DbConnectionPoolManager manages the pool of database connections.
//freeConnectionInPool stores available connections.
//connectionCurrentlyInUse tracks connections currently in use.
//getDbConnection() provides a connection from the pool or creates a new one if needed and allowed.
//releaseDbConnection() returns a connection to the pool after use.



//ObjectPool_DesignPattern is the client that uses the pool manager to get and release connections.
//Demonstrates acquiring multiple connections and releasing them back to the pool.


//The Object Pool design pattern is a powerful tool for managing resource-intensive objects efficiently.
//It helps improve performance by reusing objects, reduces the overhead of object creation and destruction,
//and provides better control over resource usage.
//By implementing this pattern, you can ensure that your application manages resources in a scalable and efficient manner.
