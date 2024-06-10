package Revision;

public class GreatestCommonDivisor {
    public static int gcd(int a, int b){
        while(b%a !=0){
            int remainder = b%a;
            b=a;
            a = remainder;
        }
        return a;
    }
    public static String greatestCommondivisor(String s1, String s2){
     if((s1 + s2).equals(s2+s1)){
         int a = s1.length();
         int b = s2.length();
         int gcdresult = gcd(a,b);
         return s1.substring(0,gcdresult);
     }else
     {
         return "";
     }
    }
    public static void main(String[] args) {
        //example 1 testing
//        String s1 = "ababab";
//        String s2 = "abab";
//        System.out.println(greatestCommondivisor(s1,s2));

        //example 2 testing
        String s1 = "Leet";
        String s2 = "Code";
        System.out.println(greatestCommondivisor(s1,s2));
    }
}
