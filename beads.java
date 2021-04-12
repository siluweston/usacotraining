/*
ID: ngp.siy1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

class beads {
    
    public static int[] returnBeads( int index, ArrayList<Integer> intarr, ArrayList<String> strarr, int uplim, int downlim ) // index is between size and 2*size
    {      
        int size = strarr.size(), upperbound = index+1, lowerbound = index-1, total = 0;
       
        while ( upperbound < 3*size && (strarr.get(upperbound%size).equals(strarr.get(index%size)) || strarr.get(upperbound%size).equals("w")) && upperbound <= downlim )
            upperbound++;
        
        while ( lowerbound > -1 && ( strarr.get(lowerbound%size).equals(strarr.get(index%size)) || strarr.get(lowerbound%size).equals("w")) && lowerbound >= uplim )
            lowerbound--;
        
        for ( int i = lowerbound+1; i < upperbound; i++ )
            total += intarr.get(i%size);
            
        int[] result = {total, upperbound, lowerbound};
        
        return result;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));                                                
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        int N = Integer.parseInt(in.readLine());
        String beads = in.readLine();
        ArrayList<String> strarr = new ArrayList<>();
        ArrayList<Integer> intarr = new ArrayList<>();
        int i = 0, j = 0;
        strarr.add( beads.substring(0, 1) );
        
        while ( i < N )
        {
            if ( i != 0 && !beads.substring(i-1, i).equals( beads.substring(i, i+1)) )
            {
                strarr.add( beads.substring(i, i+1) );
                intarr.add( j );
                j = 1;
            }
            else
                j++;
            
            if ( i == N - 1 )
                intarr.add( j );
            i++;
        }
        
        if ( strarr.size() != 1 && strarr.get(0).equals( strarr.get(strarr.size()-1)) )
        {
            intarr.set(0, intarr.get(0)+intarr.get(intarr.size()-1));
            strarr.remove(strarr.size()-1);
            intarr.remove(strarr.size()-1);
        }

        int size = strarr.size(), max = 0;
        
        for ( int p = size; p < 2*size; p++ )
        {
            if ( returnBeads(p%size, intarr, strarr, -1, 3*size)[1] == 3*size )
            {
                for ( int q = 0; q < size; q++ )
                    max += intarr.get(q);
                
                break;
            } 
            else if ( !strarr.get(p%size).equals("w") ) 
            {
                int upperbound = returnBeads( p, intarr, strarr, -1, 3*size )[1];
                int lowerbound = returnBeads( p, intarr, strarr, -1, 3*size )[2];
                if ( max < returnBeads( p, intarr, strarr, -1, 3*size )[0] + returnBeads( returnBeads(p, intarr, strarr, -1, 3*size)[1], intarr, strarr, upperbound, lowerbound+size )[0] )
                    max = returnBeads( p, intarr, strarr, -1, 3*size )[0] + returnBeads( returnBeads(p, intarr, strarr, -1, 3*size)[1], intarr, strarr, upperbound, lowerbound+size)[0];
            }          
        }  
        out.println( max );
        out.close();
    }
    
}
