/*
ID: ngp.siy1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {

    /**
     * @param args the command line arguments
     */
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader in = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String a = in.readLine();
    String b = in.readLine();
    
    int ar = 1, br = 1;
    for( int i = 0; i < a.length(); i++ )
    {
        for( int j = 0; j < alphabet.length; j++ )
        {
           if ( alphabet[j].equals(a.substring(i, i+1)))
           {
               ar *= j+1;
           }
        }
    }
    for( int i = 0; i < b.length(); i++ )
    {
        for( int j = 0; j < alphabet.length; j++ )
        {
           if ( alphabet[j].equals(b.substring(i, i+1)))
           {
               br *= j+1;
           }
        }
    }
    
    if (ar % 47 == br % 47) 
    out.println("GO"); 
    else
    out.println("STAY");
    
    out.close();
  }
}
