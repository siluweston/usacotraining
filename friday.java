/*
ID: ngp.siy1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));                                                
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        int N = Integer.parseInt(in.readLine()), year = 1900;
        int[] firstdayArr = new int[12]; // First day of each month
        int[] thirteendayArr = new int[12];
        int[] counterArr = {0, 0, 0, 0, 0, 0, 0};
        firstdayArr[0] = 1; // Jan 1, 1900
        
        while ( year < 1900 + N )
        {
            firstdayArr[1] = (firstdayArr[0] + 3) % 7; // Feb 1
            firstdayArr[2] = firstdayArr[1]; // Mar 1
            firstdayArr[3] = (firstdayArr[2] + 3) % 7; // Apr 1
            firstdayArr[4] = (firstdayArr[3] + 2) % 7; // May 1
            firstdayArr[5] = (firstdayArr[4] + 3) % 7; // Jun 1
            firstdayArr[6] = (firstdayArr[5] + 2) % 7; // Jul 1
            firstdayArr[7] = (firstdayArr[6] + 3) % 7; // Aug 1
            firstdayArr[8] = (firstdayArr[7] + 3) % 7; // Sep 1
            firstdayArr[9] = (firstdayArr[8] + 2) % 7; // Oct 1
            firstdayArr[10] = (firstdayArr[9] + 3) % 7; // Nov 1
            firstdayArr[11] = (firstdayArr[10] + 2) % 7; // Dec 1
            
            if ( year % 400 == 0 || ( year % 100 != 0 && year % 4 == 0 ) ) // Leap Years and Century Years
            {
                for ( int i = 2; i < 12; i++ )
                    firstdayArr[i]++;
            }
            
            for ( int i = 0; i < firstdayArr.length; i++ )
            {
                thirteendayArr[i] = (firstdayArr[i] + 5) % 7; // Thirteenth
                counterArr[thirteendayArr[i]]++;
            }
                    
            firstdayArr[0] = (firstdayArr[11] + 3) % 7;
            year++;
        }
        
        out.println( counterArr[6] + " " + counterArr[0] + " " + counterArr[1] + " " + counterArr[2] + " " + counterArr[3] + " " + counterArr[4] + " " + counterArr[5]);
        out.close();
    }
    
}
