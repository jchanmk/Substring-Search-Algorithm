import java.util.Random;

public class NaiveAlgorithm {
    public static void main ( String[] args ){
        int N = 300;        // Long String size
        int m = 5;          // substirng size
        int r = 3;         // alphabet size and numbers

        Random rand = new Random ();
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

       /* // prints out substring and longstring
        for (int i = 0; i < N; i++)
            System.out.print(longstring[i]);
        System.out.println();

        for (int i = 0; i < m; i++)
            System.out.print(substring[i]);
        System.out.println();
*/

        search(longstring, substring, N, m);

//    }

    }

    public static void search (int[]string, int[]substring1, int lstring, int sstring){
        long startTime = System.nanoTime();
        boolean substringfound = false;
        for (int i = 0; i < lstring-sstring; i++){
            if(!substringfound) {
                for (int j = 0; j < sstring; j++) {
                    if (substring1[j] != string[i + j])
                        break;
                    else if (j == sstring - 1) {
                      //  System.out.println("substring is found at position: " + i);
                        substringfound = true;
                    }
                }
            }
            else
                break;
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        if(substringfound)
            System.out.println(totalTime +" " + " success");
        else
            System.out.println(totalTime);
        //return -1;

    }
}
