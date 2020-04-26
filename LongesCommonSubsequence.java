package longescommonsubsequence;


public class LongesCommonSubsequence 
{
    public static void LCS(String s1, String s2)
    {
        int length1 = s1.length();
        int length2 = s2.length();
        
        int[][] M = new int[length1+1][length2+1];
        
        // Build the table using bottom up approach
        for(int i = 0; i <= length1; i++)
        {
            for(int j = 0; j <= length2; j++)
            {   
                if(i == 0 || j == 0)
                {
                    M[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    M[i][j]  =  M[i-1][j-1] + 1;
                }
                else
                {
                   M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
                }                
            }
        }
        
        //this is the lenght of max subsequence
        int index = M[length1][length2];
        
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
