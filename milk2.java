/*
ID: ngp.siy1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class milk2 {
    
    public static void insertionSort( ArrayList<Integer> l1, ArrayList<Integer> l2 ) // l2 is automatically ordered according to l1
    {
        int i, k, posmax, temp;
        
        for ( i = l1.size() - 1; i > 0; i-- )
        {
            posmax = 0;
            
            for ( k = 1; k <= i; k++ )
            {
                if ( l1.get(k) > l1.get(posmax) )
                    posmax = k;
            }
            
            temp = l1.get(i);
            l1.set( i, l1.get(posmax) );
            l1.set( posmax, temp );
            temp = l2.get(i);
            l2.set( i, l2.get(posmax) );
            l2.set( posmax, temp );
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("milk2.in"));                                                
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> start = new ArrayList<Integer>(N), end = new ArrayList<Integer>(N);
        
        for ( int i = 0; i < N; i++ )
        {
            StringTokenizer tkn = new StringTokenizer( in.readLine() );
            start.add( Integer.parseInt( tkn.nextToken() ));
            end.add( Integer.parseInt( tkn.nextToken() ));
        }
        
        insertionSort( start, end );
        
        int i = 0;
        while ( i < start.size()-1 )
        {
            if ( end.get( i ) >= start.get( i+1 ) )
            {
                if ( end.get(i) < end.get( i+1 ) )
                    end.set( i, end.get(i+1) );
                start.remove(i+1);
                end.remove(i+1);
            }
            else
                i++;
        }
        
        int max1 = 0, max2 = 0; 
        for ( int j = 0; j < start.size(); j++ )
        {
            if ( end.get(j) - start.get(j) > max1 )
                max1 = end.get(j) - start.get(j);
        }
        for ( int j = 0; j < start.size()-1; j++) 
        {
            if ( start.get(j+1) - end.get(j) > max2 )
                max2 = start.get(j+1) - end.get(j);
        }
        
        out.println( max1 + " " + max2 );
        out.close();
    }
}