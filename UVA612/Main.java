import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sets = sc.nextInt();
        int set = 0;

        while (set < sets) {

            int length = sc.nextInt();
            int cases = sc.nextInt();
            String[] dnas = new String[cases];
            int[] inv = new int[cases];
            int aux = 0;

            while (aux < cases) {
                String dna = sc.next();
                dnas[aux] = dna;
                inv[aux] = inversions(dna);
                aux++;
            }
            String [] result = sortDna(dnas, inv);
            printDna(result, inv);

            if (set != sets - 1) {
                System.out.println();
            }
            set++;
        }
        sc.close();
        System.exit(0);
    }

    private static int inversions(String s) {
        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (c > s.charAt(j)) {
                    res++;
                }
            }
        }

        return res;

    }

    private static String [] sortDna(String[] s, int[] inv) {
        String [] result = new String [s.length];
        for (int i = 0; i < s.length; i++) {
            int curr = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0 ; j < s.length; j++) {
                if(curr > inv[j]) {
                    curr = inv[j];
                    index = j;
                }

            }
            inv[index] = Integer.MAX_VALUE;
            result [i] = s[index];
        }
        return result;

    }

    private static void printDna(String[] s, int [] v) {
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

}
