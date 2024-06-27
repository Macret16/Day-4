import java.util.LinkedList;
import java.util.Scanner;

class linklist {
    static LinkedList<Double> linklist = new LinkedList<Double>();

    void addhistory(double ans) {
        linklist.addFirst(ans);  
    }

    void showhistory() {
        try {
            double a = linklist.get(0);
            double b = linklist.get(1);
            double c = linklist.get(2);
            System.out.println("Last Calculations : " + a + ", " + b + ", " + c);
        } catch (Exception e) {
            System.out.println("There is no history,please perform some calculations and try again!"); 
        }
    }   
}

abstract class Calculator {
    abstract void calculate(double num1, double num2);

    abstract void displayResult(double ans);

    linklist obj = new linklist(); // to add history in operations
}

class Addition extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Addition add = new Addition();
            double re = num1 + num2;
            obj.addhistory(re);
            add.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class Subtraction extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Subtraction sub = new Subtraction();
            double re = num1 - num2;
            obj.addhistory(re);
            sub.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class Multiplication extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Multiplication mul = new Multiplication();
            double re = num1 * num2;
            obj.addhistory(re);
            mul.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class Division extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Division div = new Division();
            double re = num1 / num2;
            obj.addhistory(re);
            div.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Cannot Divide By Zero.");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class Modulus extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Modulus mod = new Modulus();
            double re = num1 % num2;
            obj.addhistory(re);
            mod.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class SquareRoot extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            SquareRoot sq = new SquareRoot();
            double re = Math.sqrt(num1);
            obj.addhistory(re);
            sq.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

class Power extends Calculator {
    public void calculate(double num1, double num2) {
        try {
            Power pow = new Power();
            double re = Math.pow(num1, num2);
            obj.addhistory(re);
            pow.displayResult(re);
        } catch (ArithmeticException e) {
            System.out.println("Invalid Operation!");
            e.printStackTrace();
        }
    }

    public void displayResult(double ans) {
        System.out.println("Result : " + ans);
    }
}

interface Operation {
    void performOperation(double num1, double num2);
}

class perform implements Operation {
    Scanner input = new Scanner(System.in);
    advcalc mainn = new advcalc();

    public void performOperation(double a, double b) {
        perform obj = new perform();
        System.out.print(
                "\n=== Calculator Menu ===\nOperations : \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\n6. Square Root\n7. Power\n\nOther Operations :\n8. View Calculation History\n9. Restart\n10. Exit Program\n\nEnter Your Choice : ");
        int ch = input.nextInt();
        switch (ch) {
            case 1:
                Addition add = new Addition();
                add.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 2:
                Subtraction sub = new Subtraction();
                sub.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 3:
                Multiplication mul = new Multiplication();
                mul.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 4:
                Division div = new Division();
                div.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 5:
                Modulus mod = new Modulus();
                mod.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 6:
                SquareRoot sq = new SquareRoot();
                sq.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 7:
                Power pow = new Power();
                pow.calculate(a, b);
                obj.performOperation(a, b);
                break;
            case 8:
                linklist link = new linklist();
                link.showhistory();
                obj.performOperation(a, b);
                break;
            case 9:
                System.out.println("Restarting...");
                mainn.main(null);
                break;
            case 10:
                advcalc ob = new advcalc();
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }
}

public class advcalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the calculator!");
        System.out.print("Enter First Number : ");
        double a = input.nextDouble();
        System.out.print("Enter Second Number : ");
        double b = input.nextDouble();
        perform obj = new perform();
        obj.performOperation(a, b);
    }
}