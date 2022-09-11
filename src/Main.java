import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        try {
            File stringObj = new File("./src/strings.txt");
            Scanner reader = new Scanner(stringObj);
            while (reader.hasNextLine()) {
                stringList.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }

        for (String entry : stringList) {
            if (filterString(entry) >= 10) {
                System.out.println(entry);
            }

        }
    }

    static int filterString(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((Character.isDigit(c[i])) && (Character.isDigit(c[i - 1]))) {
                String a = String.valueOf(c[i]);
                String b = String.valueOf(c[i - 1]);
                String sum = a + b;
                int isNotZero = Integer.parseInt((b));

                if (isNotZero != 0) {
                    String adjustedSum = reverseIfNumberIsTen(sum);
                    return Integer.parseInt(adjustedSum);
                }
            }
        }
        return 0;
    }

    static String reverseIfNumberIsTen(String sum) {
        if (sum.equals("01")) {
            StringBuilder sb = new StringBuilder(sum);
            sb.reverse();
            return sb.toString();
        }
        return sum;
    }
}