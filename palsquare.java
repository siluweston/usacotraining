/*
ID: ngp.siy1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
    
    public static String convertB(int n, int B)
    {
        String s = "", digits="0123456789ABCDEFGHIJ";
        int pow = 16;
        while ( pow >= 0 ) {
            int coeff = B-1;
            while ( coeff >= 0 ) {
                if ( n < coeff * Math.pow(B, pow) )
                    coeff--;
                else {
                        for ( int i = 0; i < 19; i++ )
                            if ( coeff == i )
                                s += digits.charAt(i);
                        n-=coeff*Math.pow(B, pow);
                        break;
                     }
                }
            pow--;
        }
        while ( s.substring(0,1).equals("0") )
            s = s.substring(1, s.length());
        return s;
    }

    public static boolean palindrome(String s)
    {
        boolean result = true;
        for ( int i = 0; i < s.length()/2; i++ ) {
            result = result && 
            (s.substring(i,i+1).equals(s.substring(s.length()-1-i, s.length()-i)));
        }
        return result;
    }
    
    public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
    int B = Integer.parseInt(f.readLine());
    
    for ( int i = 1; i < 301; i++ )
          if ( palindrome(convertB((int)(Math.pow(i,2)), B) ) )
             out.println(convertB(i, B)+" "+convertB((int)(Math.pow(i,2)), B));
    
    out.close();
  }
}