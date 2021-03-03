/**
 *
 * @author user
 */
/*
ID: ngp.siy1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")))) {
            int np = Integer.parseInt(in.readLine());
            String[] names = new String[np];
            
            for ( int i = 0; i < np; i++ )
                names[i] = in.readLine();
            
            String[][] info = new String[np][];
            int[] givemoney = new int[np];
            
            for ( int i = 0; i < np; i++ )
            {
                String name = in.readLine();
                StringTokenizer st = new StringTokenizer(in.readLine());
                givemoney[i] = Integer.parseInt(st.nextToken());
                int amt = Integer.parseInt(st.nextToken());
                info[i] = new String[amt+1];
                info[i][0] = name;
                
                for ( int j = 0; j < amt; j++ )
                {
                    info[i][j+1] = in.readLine();
                }
            }
            
            int[] aftermoney = new int[np];
            String[] orderednames = new String[np];
            for ( int i = 0; i < np; i++ )
            {
                aftermoney[i] = 0;
                orderednames[i] = info[i][0];
            }
            

            for ( int i = 0; i < np; i++ )
            {
                aftermoney[i] -= givemoney[i];
                
                for ( int j = 1; j < info[i].length; j++)
                {
                    for ( int k = 0; k < np; k++ )
                    {
                        if ( info[i][j].equals(orderednames[k]) && info[i].length - 1 != 0 )
                            aftermoney[k] += givemoney[i] / (info[i].length-1);
                    }
                }
                
                if ( info[i].length - 1 != 0 )
                    aftermoney[i] += givemoney[i] % (info[i].length-1);
            }
            
            
            String output = "";
            for ( int i = 0; i < np; i++ )
            {
                for ( int j = 0; j < np; j++ )
                {
                    if ( names[i].equals(orderednames[j]) )
                    {
                        if ( i == 0 )
                            output += names[i] + " " + aftermoney[j];
                        else
                            output += "\n" + names[i] + " " + aftermoney[j];
                    }
                    
                }
            }
            
            
            out.println(output);
        }
    }
    
}
