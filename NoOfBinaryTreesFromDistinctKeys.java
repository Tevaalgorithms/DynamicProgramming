public class NoOfBinaryTreesFromDistinctKeys 
{
    static int TotalBinaryTrees(int n)
    {
        int[] N;
        N = new int[n +1];
        
        //Base case
        N[0] = 1; 
        N[1] = 1;
        
        for(int i=2; i <= n; i++)
        {
            N[i] = 0;
            for(int j=0; j < i; j++)
            {
                N[i] += N[j] * N[i - j - 1];
            }
        }        
        return N[n];
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int n = 6;
        System.out.println("Total no of distinct keys " + n + " Possible binary trees: " + TotalBinaryTrees(n));
    }
