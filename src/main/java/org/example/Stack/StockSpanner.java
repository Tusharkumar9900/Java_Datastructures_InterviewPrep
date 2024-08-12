package org.example.Stack;

/*

Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward)
for which the stock price was less than or equal to the price of that day.

For example,
 if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2,
 then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8,
 then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.


Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6


 */


//----------------------------------------------------------------------------------------------------------------------------------------------------------


/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//brute force using arraylist
public class StockSpanner {
    List<Integer> arr;
    public StockSpanner() {
        arr  = new ArrayList<>();
    }

    public int next(int price) {
        arr.add(price);
        int count =1;

        for(int i=arr.size()-2;i>=0;i--){
            if(arr.get(i)<= price){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
StockSpanner stock = new StockSpanner();
        System.out.print(stock.next(7)+" ");
        System.out.print(stock.next(2)+" ");
        System.out.print(stock.next(1)+" ");
        System.out.print(stock.next(3)+" ");
        System.out.print(stock.next(3)+" ");
        System.out.print(stock.next(1)+" ");
        System.out.print(stock.next(8)+" ");

    }
}



 */


//--------------------------------------------------------------------------------------------------------------------------------------------------------------

//optimized approach
import java.util.Stack;
class Pair{
    int value;
    int index;
    Pair(int value,int index){
        this.value = value;
        this.index=index;
    }
}
public class StockSpanner {

        Stack<Pair> stack;
        public StockSpanner() {
            stack = new Stack<Pair>();
        }

        // price = value && span = index
        public int next(int value) {
            int index=1;
            while(!stack.isEmpty() && value>=stack.peek().value){
                index += stack.pop().index;
            }
            stack.push(new Pair(value,index));

            return stack.peek().index;
        }
    public static void main(String[] args) {
        StockSpanner stock = new StockSpanner();
        System.out.print(stock.next(7)+" ");
        System.out.print(stock.next(2)+" ");
        System.out.print(stock.next(1)+" ");
        System.out.print(stock.next(3)+" ");
        System.out.print(stock.next(3)+" ");
        System.out.print(stock.next(1)+" ");
        System.out.print(stock.next(8)+" ");
    }
}