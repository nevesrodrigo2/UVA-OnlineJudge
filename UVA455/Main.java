import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tests = Integer.parseInt(sc.nextLine());
        int i = 1;
        while (i <= tests) {
            sc.nextLine();

            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            System.out.println(periodic(input));

            if (i < tests) {
                System.out.println();
            }
            i++;
        }
        sc.close();

    }

    private static int periodic(String input) {
        int per = input.length();
        for (int i = 0; i < input.length() - 1; i++) {
            String part = input.substring(0, i + 1);
            part = input.replaceAll(part, "");

            if (part.length() == 0) {
                // check if the word was formed
                // with only the same characters
                if (i == 0) { 
                    per = 1;
                }
                else {
                    per = i + 1;
                }
                break;
            }
        }
        return per;
    }
}
