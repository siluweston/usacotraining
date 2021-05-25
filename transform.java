/*
ID: ngp.siy1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

class transform {
    
    public static boolean equals( String[][] a1, String[][] a2 )
    {
        boolean b = true;
        
        for ( int i = 0; i < a1.length; i++ )
            for ( int j = 0; j < a2.length; j++ )
                b = b && a1[i][j].equals(a2[i][j]);
        
        return b;
    }
    
    public static String[][] one( String[][] a1 )
    {
        String[][] result = new String[a1.length][a1.length];
        
        for ( int i = 0; i < a1.length; i++ )
                for ( int j = 0; j < a1.length; j++ )
                    result[j][a1.length-1-i] = a1[i][j];
        
        return result;
    }
    
    public static String[][] two( String[][] a1 )
    {
        String[][] result = new String[a1.length][a1.length];
        
        for ( int i = 0; i < a1.length; i++ )
                for ( int j = 0; j < a1.length; j++ )
                    result[a1.length-1-i][a1.length-1-j] = a1[i][j];
        
        return result;
    }
    
    public static String[][] three( String[][] a1 )
    {
        String[][] result = new String[a1.length][a1.length];
        
        for ( int i = 0; i < a1.length; i++ )
                for ( int j = 0; j < a1.length; j++ )
                    result[a1.length-1-j][i] = a1[i][j];
        
        return result;
    }
    
    public static String[][] four( String[][] a1 )
    {
        String[][] result = new String[a1.length][a1.length];
        
        for ( int i = 0; i < a1.length; i++ )
                for ( int j = 0; j < a1.length; j++ )
                    result[i][a1.length-1-j] = a1[i][j];
        
        return result;
    }
    
    public static void main(String []args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));                                                
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
        int N = Integer.parseInt(in.readLine());
        String[][] originalArr = new String[N][N];
        String[][] resultArr = new String[N][N];
        
        for ( int i = 0; i < N; i++ )
        {
            String s = in.readLine();
            for ( int j = 0; j < N; j++ )
                originalArr[i][j] = s.substring(j, j+1);
        }
        for ( int i = 0; i < N; i++ )
        {
            String s = in.readLine();
                       
            for ( int j = 0; j < N; j++ )
                resultArr[i][j] = s.substring(j, j+1);
        }
        
        if ( equals( one( originalArr), resultArr ) )
            out.print(1 + "\n");
        else if ( equals( two( originalArr), resultArr ) )
            out.print(2 + "\n");
        else if ( equals( three( originalArr ), resultArr ) )
            out.print(3 + "\n");
        else if ( equals( four( originalArr ), resultArr ) )
            out.print(4 + "\n");
        else if ( equals( one(four( originalArr )), resultArr ) || equals( two(four( originalArr )), resultArr ) || equals( three(four( originalArr )), resultArr ) )
            out.print(5 + "\n");
        else if ( equals( originalArr, resultArr ) )
            out.print(6 + "\n");
        else
            out.print(7 + "\n");
            
        out.close();
    }
}