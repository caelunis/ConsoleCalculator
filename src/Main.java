import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String input = in.nextLine();
                String arr[] = input.split(" ");
                if(arr.length != 3){
                    throw new RuntimeException("Incorrect format");
                }

                boolean isArabic = arr[0].matches("[0-9]+") && arr[2].matches("[0-9]+");
                boolean isRoman = arr[0].matches("[IVXLCDM]+") && arr[2].matches("[IVXLCDM]+");
                if (!(isArabic || isRoman)) {
                    throw new RuntimeException("Mixed numeral types are not supported");
                }

                char operator = arr[1].charAt(0);
                int num1 = isArabic ? Integer.parseInt(arr[0]) : RomanConverter.romanToDecimal(arr[0]);
                int num2 = isArabic ? Integer.parseInt(arr[2]) : RomanConverter.romanToDecimal(arr[2]);

                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10){
                    throw new RuntimeException("The values are out of bounds");
                }

                if (operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                    throw new RuntimeException("Incorrect arithmetic operation");
                }

                switch (operator) {
                    case '+' -> System.out.println(isArabic ? num1 + num2 : RomanConverter.decimalToRoman(num1 + num2));
                    case '-' -> System.out.println(isArabic ? num1 - num2 : RomanConverter.decimalToRoman(num1 - num2));
                    case '*' -> System.out.println(isArabic ? num1 * num2 : RomanConverter.decimalToRoman(num1 * num2));
                    case '/' -> System.out.println(isArabic ? num1 / num2 : RomanConverter.decimalToRoman(num1 / num2));
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
    }
}


