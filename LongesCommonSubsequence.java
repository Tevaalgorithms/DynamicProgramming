package longescommonsubsequence;


public class LongesCommonSubsequence 
{
    public static void LCS(String s1, String s2)
    {
        int i = s1.length();
        int j = s2.length();
        
        int[][] M = new int[i+1][j+1];
        
        // Build the table using bottom up approach
        for(int k = 0; k <= i; k++)
        {
            for(int l = 0; l <= j; l++)
            {   
                if(k == 0 || l == 0)
                {
                    M[k][l] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    M[k][l]  =  M[k-1][l-1] + 1;
                }
                else
                {
                   M[k][l] = Math.max(M[k-1][l], M[k][l-1]);
                }                
            }
        }
        
        //this is the lenght of max subsequence
        int index = M[i][j];
        
        System.out.println("Lenght of LongesCommonSubsequence = " + index + "\n");
        
        // Let's print the substrings
        char[] lc = new char[index + 1];
        lc[index] = ' ';
        
        
        int p = i;
        int q = j;
       
        while(p > 0 && q > 0)
        {
            if(s1.charAt(p-1) == s2.charAt(q-1))
            {
                lc[index - 1] = s1.charAt(p-1);
                p--;
                q--;
                index--;
            }
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if(M[p-1][q] > M[p][q-1])
            {
                p--;                
            }
            else
            {
                q--;
            }
        }
        
        int t = M[i][j];
        
         // Print the lcs 
        System.out.print("LCS of "+ s1 +" and "+ s2+" is "); 
        for(int k = 0;k <= t; k++) 
            System.out.print(lc[k]); 
        System.out.print("\n"); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String X = "ABC"; 
        String Y = "AC";        
        LCS(X, Y); 
    }
    
}
