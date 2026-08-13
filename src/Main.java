import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = 0;
        // --- Ручные тесты ---
        System.out.println("--- Тесты ---");
        System.out.println("5 + 3 = " + calculate(5, 3, "+"));   // ожидается: 8
        System.out.println("5 / 2 = " + calculate(5, 2, "/"));   // ожидается: 2
        System.out.println("10 - 3 = " + calculate(10, 3, "-")); // ожидается: 7
        System.out.println("4 * 6 = " + calculate(4, 6, "*"));   // ожидается: 24
        System.out.println("--- Конец тестов ---\n");

        // --- Рабочий режим ---
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("--- CALCULATOR ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Invalid input!");
                scanner.nextLine();
                continue;
            }


            if(choice != 5){
                int firstNumber = 0;
                int secondNumber = 0;

                    System.out.print("Enter first number :");
                    try{
                        firstNumber = scanner.nextInt();
                        scanner.nextLine();
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                        continue;
                    }
                        System.out.print("Enter second number :");
                    try{
                        secondNumber = scanner.nextInt();
                        scanner.nextLine();
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                        continue;
                    }


                    switch (choice) {
                        case 1:
                            System.out.println("Result: " + calculate(firstNumber, secondNumber, "+"));
                            break;
                        case 2:
                            System.out.println("Result: " + calculate(firstNumber, secondNumber, "-"));
                            break;
                        case 3:
                            System.out.println("Result: " + calculate(firstNumber, secondNumber, "*"));
                            break;
                        case 4:
                            try{
                                System.out.println("Result: " + calculate(firstNumber, secondNumber, "/"));
                            }catch(ArithmeticException e){
                                System.out.println("Cannot divide by zero");
                            }
                            break;
                        default:
                            System.out.println("Wrong choice!");
                    }
            }else{
                keepGoing = false;
                System.out.println("Bye!");
            }
        }
    }

    private static int calculate(int a, int b, String operator) {
        int result;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                result = 0;
        }

        return result;

    }
}
