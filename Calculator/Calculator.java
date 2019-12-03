import java.util.*;

 public class Calculator {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextDouble())
            stack.push(scan.nextDouble());
            char operator = "";
    }
//             operator = input.next();

            //helps to determine the operator and what it should do
            // switch (operator) {
            //     case "+": stack = Math.add(inputA, inputB); break;

                //case "-": stack = Math.subtract(inputA, inputB); break;

                //case "*": stack = Math.multiply(inputA, inputB); break;

                //case "/": stack = Math.divide(inputA, inputB); break;

                //case "dup": stack = Math.duplicate(inputA, inputB); break;

                //case "drop":stack = Math.drop(inputA); break;

                //case "over":stack = Math.over(inputA, inputB); break;

                //case "sqrt":stack = Math.sqrt(inputA); break;

                //case "floor": stack = Math.floor(inputA); break;

                //case "abs": stack = Math.abs(inputA); break;
            //}
        //}
    //}
}
 class Stack {
    private int maxSize = 4; 
    private double stack [] = new double[maxSize];
    private int top = 0;

    public void push(double data) {
        stack[top] = data;
        top++;
    }

    public double pop() {
        double data;
        data = stack[top];
        top--;
        stack[top] = 0;

        return data;
    }

    public double peek() {
        double data = stack[top-1];
        return data;
    }
    public boolean isEmpty() {
        return (top == -1);
     }

     public boolean isFull() {

        return (top == maxSize - 1);
     }

    public void show() {
        for (double n : stack) {
            System.out.println(n + " ");
        }
    }


}

abstract class Operations {
    public abstract String getDescribe();
    
}
class Plus extends Operations {
    double inputA = 0;
    double inputB = 0;
    String operator = "";

    Plus(Double inputA, Double inputB, String operator){
        this.inputA = inputA;
        this.inputB = inputB;
        this.operator = operator;
    }
    @Override
    public String getDescribe() {
        // TODO Auto-generated method stub
        return "PLus";
    }
}

class Minus extends Operations {
    double inputA = 0;
    double inputB = 0;
    String operator = "";

    Minus(Double inputA, Double inputB, String operator){
        this.inputA = inputA;
        this.inputB = inputB;
        this.operator = operator;
    }
    @Override
    public String getDescribe() {
        // TODO Auto-generated method stub
        return "Minus";
    }
}

class Multiply extends Operations {
    double inputA = 0;
    double inputB = 0;
    String operator = "";

    Multiply(Double inputA, Double inputB, String operator){
        this.inputA = inputA;
        this.inputB = inputB;
        this.operator = operator;
    }
    @Override
    public String getDescribe() {
        // TODO Auto-generated method stub
        return "Multiply";
    }
}

class Divide extends Operations {
    double inputA = 0;
    double inputB = 0;
    String operator = "";

    Divide(Double inputA, Double inputB, String operator){
        this.inputA = inputA;
        this.inputB = inputB;
        this.operator = operator;
    }
    @Override
    public String getDescribe() {
        // TODO Auto-generated method stub
        return "Divide";
    }
}