package com.abubakirkarimov.calculator.calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInteraction {
    Scanner scanner = new Scanner(System.in);
    private boolean keepGoing = true;

    private void menu(){
        System.out.println("--- CALCULATOR ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
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

    private int getNumber (String message){
        while(true){
            System.out.print(message);

            try{
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }
    }
    private int getFirstNumber(){
        return getNumber("Enter first number: ");
    }
    private int getSecondNumber(){
        return getNumber("Enter second number: ");
    }
    private void doSwitch(){
        Calculator calculator = new Calculator();
        int choice = getChoice();
        switch(choice){
            case 1:
                System.out.println("Result: " + calculator.add(getFirstNumber(),getSecondNumber()));
                break;
            case 2:
                System.out.println("Result: " + calculator.subtract(getFirstNumber(),getSecondNumber()));
                break;
            case 3:
                System.out.println("Result: " + calculator.multiply(getFirstNumber(),getSecondNumber()));
                break;
            case 4:
                try{
                    System.out.println("Result: " + calculator.divide(getFirstNumber(),getSecondNumber()));
                }catch(ArithmeticException e){
                    System.out.println("You can't divide by zero");
                }
                break;
            case 5:
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
