import java.util.Random;

public class FiniteAutomata {
    public static void main( String [] args){
        int N = 300;        // Long String size
        int m = 5;         // substirng size
        int r = 3;         // alphabet size and numbers

        Random rand = new Random();
//  Generate the substring and string

        int[] longstring = new int[N];
        int[] substring = new int[m];
        //for(int ro = 0; ro < 10; ro++) {
        for (int i = 0; i < N; i++) {
            longstring[i] = rand.nextInt(r);
        }

        for (int i = 0; i < m; i++) {
            substring[i] = rand.nextInt(r);
        }

      /*  // prints out substring and large string
        for(int i = 0; i < m; i++)
            System.out.print(substring[i]);
        System.out.println();
        for(int i = 0; i < N; i++)
            System.out.print(longstring[i]);
        System.out.println();
*/

    search(longstring, substring, N, m, r);
}

    //}
    public static void search (int[]longstring, int[]substring, int n, int m, int r) {
        int k;
        int[][] transitionTable = new int [m + 1][r];
        boolean substringfound = false;

        for (int q = 0; q <= m; q++) {
            for (int c = 0; c < r; c++) {
                k = Math.min(m + 1, q + 2);
                do
                    k--;
                while (!suffixProperty(substring, k, q, c));
                transitionTable[q][c] = k;
            }
        }

        long startTime = System.nanoTime();
        int state = 0;
        for (int i = 0; i < n; i++) {
            state = transitionTable[state][longstring[i]];
            if (state == m){
                substringfound = true;
                //System.out.println("String found at position: " + (i-2));
                break;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        if(substringfound)
            System.out.println(totalTime +" " + " success");
        else
            System.out.println(totalTime);

       // System.out.println("runtime: " + totalTime);
        //System.out.println(totalFound);
    }

        public static boolean suffixProperty ( int[]t, int k, int q, int c){
            if (k == 0)
                return true;
            if (t[k - 1] != c)
                return false;
            for (int i = k - 2; i >= 0; i--){
                if (t[i] != t[i + (q - k + 1)])
                return false;
            }
            return true;
    }
}
