
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("0 0 0 0")) {
                break;
            }
            String[] input = line.split(" ");
            double height = Double.parseDouble(input[0]);
            double up = Double.parseDouble(input[1]);
            double down = Double.parseDouble(input[2]);
            double fatigue = Double.parseDouble(input[3]);

            sb.append(result(height, up, down, fatigue) + System.lineSeparator());

        }
        sb.delete(sb.length()- System.lineSeparator().length(), sb.length()); // remove last \n
        System.out.println(sb.toString());
        System.exit(0);
    }

    private static String result(double height, double up, double down, double fatigue) {

        int day = 0;
        fatigue = fatigue / 100 * up;
        double currHeight = 0;
        while (currHeight >= 0) {
            currHeight += up;
            if(up > 0) {
                up -= fatigue;
            }
            else {
                up = 0;
            }
            if (currHeight > height) {
                day++;
                break;

            }
            currHeight -= down;
            day++;
        }

        return currHeight < 0 ? String.format("failure on day %d", day) : String.format("success on day %d", day);
    }
}
