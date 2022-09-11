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
            System.out.println("an error occured.");
            e.printStackTrace();
        }


        for (String irasas : stringList) {
//            System.out.println(irasas);
//            System.out.println("____");
            if (filterString(irasas) >= 10) {
                System.out.println(irasas);
            }

        }
    }

    static void isGreaterThan10(String str) {
        str = str.replaceAll("[^\\d]", " ");
        str = str.trim();
        str = str.replaceAll(" +", " ");
        ArrayList<Character> charList = new ArrayList<>();
        char number;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(i);
        }
    }

    static int filterString(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ((Character.isDigit(c[i])) && (Character.isDigit(c[i - 1]))) {
                String a = String.valueOf(c[i]);
                String b = String.valueOf(c[i - 1]);
                String sum = a + b;
                int arNeNulis = Integer.parseInt((b));

                if (arNeNulis != 0) {
                   String adjustedSum = reverseIfNumberIsTen(sum);
                    int number = Integer.parseInt(adjustedSum);
                    return number;
                }


            }

        }
        return 0;
    }

    static String reverseIfNumberIsTen(String sum) {
        if (sum.equals("01")){
            StringBuilder sb = new StringBuilder(sum);
            sb.reverse();
            return sb.toString();
        }
        return sum;
    }
}