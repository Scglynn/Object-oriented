import java.util.*;

public class Calculator {
    public static void main(String args []) {
        double inputA, inputB;
        String operator;

        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            inputA = input.nextDouble();
            inputB = input.nextDouble();
            operator = input.next();

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
        }
    }
}
 class Stack {
    private double arr[];
    private double top;
    private double capacity;
    public Stack(double s) {
        top = -1;
        capacity = s;
        arr = new double[capacity];
    }
    public Boolean isEmpty() {
        return top == -1;
    }
    public Boolean isFull() {
        return top == capacity -1;
    }
    public double push(double x) {
        return arr[++top] = x;
    }
    public double pop() {
        return arr[top--];
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
}