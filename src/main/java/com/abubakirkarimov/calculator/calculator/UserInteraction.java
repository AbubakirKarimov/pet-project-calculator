package com.abubakirkarimov.calculator.calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInteraction {
    HistoryManager historyManager = new HistoryManager();
    Scanner scanner = new Scanner(System.in);
    private boolean keepGoing = true;

    private void menu(){
        System.out.println("--- CALCULATOR ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. See the last result");
        System.out.println("6. See the history");
        System.out.println("7. Clear history");
        System.out.println("8. Exit");
    }
    private int getChoice(){
        while(true){
            System.out.print("Enter your choice: ");
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }

    }

    private double getNumber (String message){
        while(true){
            System.out.print(message);

            try{
                double number = scanner.nextDouble();
                scanner.nextLine();
                return number;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }
    }
    private double getFirstNumber(){
        return getNumber("Enter first number: ");
    }
    private double getSecondNumber(){
        return getNumber("Enter second number: ");
    }
    private void doSwitch(){
        Calculator calculator = new Calculator();
        int choice = getChoice();
        double result;
        switch(choice){
            case 1:
                result = calculator.add(getFirstNumber(),getSecondNumber());
                System.out.println("Result: " + result);
                historyManager.addHistory(result);
                break;
            case 2:
                result = calculator.subtract(getFirstNumber(),getSecondNumber());
                System.out.println("Result: " + result);
                historyManager.addHistory(result);
                break;
            case 3:
                result = calculator.multiply(getFirstNumber(),getSecondNumber());
                System.out.println("Result: " + result);
                historyManager.addHistory(result);
                break;
            case 4:
                try{
                    result = calculator.divide(getFirstNumber(),getSecondNumber());
                    System.out.println("Result: " + result);
                    historyManager.addHistory(result);
                }catch(ArithmeticException e){
                    System.out.println("You can't divide by zero");
                }
                break;
            case 5:
                historyManager.lastOperation();
                break;
            case 6:
                historyManager.getHistory();
                break;
            case 7:
                historyManager.clearHistory();
                break;
            case 8:
                System.out.println("Exiting...");
                System.out.println("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void start(){
        while(keepGoing){
            menu();
            doSwitch();
        }
    }
}
