/*
ID: ngp.siy1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
    
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
    BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken())+1;
      
     while ( N > 0 ) {
      boolean first = false, second = false;
      for ( int i = 2; i <= 10; i++ )
      {
          if (!first)
            first = first || palindrome(convertB(S, i));
          else
            second = second || palindrome(convertB(S, i));
      }
      if ( first && second ) {
            N--;
            out.println(S);
      }
      S++;
    }
    out.close();
  }
}