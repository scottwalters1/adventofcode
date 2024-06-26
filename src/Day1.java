//The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration
//value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit
//and the last digit (in that order) to form a single two-digit number.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//For example:

//        1abc2
//        pqr3stu8vwx
//        a1b2c3d4e5f
//        treb7uchet
//
//In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
//
//Consider your entire calibration document. What is the sum of all of the calibration values?

//Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two,
// three, four, five, six, seven, eight, and nine also count as valid "digits".
//
//Equipped with this new information, you now need to find the real first and last digit on each line. For example:
//
//        two1nine
//        eightwothree
//        abcone2threexyz
//        xtwone3four
//        4nineeightseven2
//        zoneight234
//        7pqrstsixteen
//
//In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
//
//What is the sum of all of the calibration values?
public class Day1 {

//    come back - make a hashmap with chars and strings, work from there

//    public int containedDigit(String str) {
//        String digits = "onetwothreefourfivesixseveneightnine";
//
//        String forwardsString = "";
//
//        for (int i = 0; i < digits.length(); i++) {
//            forwardsString += digits.charAt(i);
//            if (digits.contains(forwardsString)) {
//                return true;
//            }
//        }
//    }
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input/day1.txt");
        Scanner in = new Scanner(file);

        String[] digits = {"one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        String num1 = "";
        String num2 = "";

        int sum = 0;

        while (in.hasNext()) {
            String text = in.nextLine();

            for (int i = 0; i < text.length(); i++) {
                num1 += text.charAt(i);

                if (Arrays.asList(digits).contains(num1)) {
                    break;
                } else if (Character.isDigit(text.charAt(i))) {
                    num1 = String.valueOf(text.charAt(i));
                    break;
                }
            }

            for (int i = text.length() - 1; i >= 0; i--) {
                num2 += text.charAt(i);
                String reversed2 = new StringBuilder(num2).reverse().toString();

                if (Arrays.asList(digits).contains(reversed2)) {
                    break;
                } else if (Character.isDigit(text.charAt(i))) {
                    num2 = String.valueOf(text.charAt(i));
                    break;
                }
            }
            String num = num1 + num2;
            sum += Integer.parseInt(num);
            break;
        }
        System.out.println(sum);
    }
}