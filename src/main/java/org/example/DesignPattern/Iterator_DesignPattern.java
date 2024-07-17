package org.example.DesignPattern;

import java.util.Arrays;
import java.util.List;

//Iterator Interface
interface Iterator{
    boolean hasNext();
    Object next();
}

class BookIterator implements Iterator{
    private List<Book> books;

    private int index=0;

    public BookIterator(List<Book> books){
        this.books = books;
    }

    public boolean hasNext(){
        return index < books.size();
    }

    public Object next(){
        if(this.hasNext()){
            return books.get(index++);
        }
        return null;
    }
}
//creating interface - Aggregate Interface
interface Aggregate{
    //declaring abstract method inside the interface
    Iterator createIterator();
}


class Library{
    private List<Book> booksList;

    public Library(List<Book> booksList){
        this.booksList = booksList;
    }

    public Iterator createIterator(){
        return new BookIterator(booksList);
    }
}


//book class
class Book{
  private int price;
  private String bookName;

  Book(int price, String bookName){
      this.price = price;
      this.bookName = bookName;
  }


  //getter and setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}




//this we amke our client class which handle all the cases
public class Iterator_DesignPattern {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
           new Book(100,"Science"),
           new Book(200,"Maths"),
           new Book(450,"RS Aggarwal"),
           new Book(700,"History")
        );

        Library lib = new Library(bookList);
        Iterator iterator = lib.createIterator();
        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName() +" "+ book.getPrice());
        }
    }
}
