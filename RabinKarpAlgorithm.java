import java.util.Random;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        int N = 300;        // Long String size
        int m = 5;         // substirng size
        int r = 3;         // alphabet size and numbers
        double q = 8191;         // prime number

        Random rand = new Random();
//  Generate the substring and string

        int[] longstring = new int[N];
        int[] substring = new int[m];
       // for(int ro = 0; ro < 10; ro++) {
            for (int i = 0; i < N; i++) {
                longstring[i] = rand.nextInt(r);
            }

            for (int i = 0; i < m; i++) {
                substring[i] = rand.nextInt(r);
            }


         /*   // prints out substring and large string
            for (int i = 0; i < m; i++)
                System.out.print(substring[i]);
            System.out.println();
            for (int i = 0; i < N; i++)
                System.out.print(longstring[i]);
            System.out.println();
*/

            search(longstring, substring, q);
     //   }

    }
    private static void search (int[]longstring, int[]substring, double q){
        int sstring = substring.length;
        int power = sstring-1;
        int lstring = longstring.length;
        double p = 0;
        double t = 0;
        boolean substringfound = false;


        // finds hashes for substring and first group of long string
        for(int i = 0; i < sstring; i++) {
            p += (substring[i]*Math.pow(10, power))%q;
            t += (longstring[i]*Math.pow(10, power))%q;
            power--;
        }
         //System.out.println(p + " " + t);
        long startTime = System.nanoTime();

        for(int s = 0; s < lstring-sstring+1; s++){
            if(!substringfound) {
                int b = 0;
                if (p == t) {
                    for (int j = s; j < s + sstring; j++) {
                        //System.out.println(j);
                        if (substring[b] != longstring[j])
                            break;
                        else if (j == s + sstring -1) {
                            //System.out.println("substring is found at position: " + s);
                            substringfound = true;
                            break;
                        }
                        b++;
                    }
                }
                if (s < lstring - sstring) {
                   // temp = ((temp - longstring[s] * Math.pow(10, sstring - 1)) * 10 + longstring[s + sstring]);
                  //  t = temp % q;
                   // t = (((t*10)%q) - ((longstring[s]*Math.pow(10, sstring))%q)+ longstring[s+sstring])%q;
                    t = (((((t*10)%q) - (longstring[s]*Math.pow(10, sstring))+longstring[s+sstring])%q)+q)%q;

                }
                if(t < 0)
                    t = (t + q);
               // System.out.println(t);
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        if(substringfound)
            System.out.println(totalTime +" " + " success");
        else
            System.out.println(totalTime);


    }
}