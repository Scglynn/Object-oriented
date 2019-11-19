import java.util.*;

public class Calculator {
    public static void main(String args []) {
        double stack = 0;
        double inputA, inputB;
        char operator;
        boolean done = false;
        Math math = new Math();

        Scanner input = new Scanner(System.in);
        //Stack<Double> stack = new Stack<Double>();

        while(!done){
            inputA = input.nextDouble();
            inputB = input.nextDouble();
            operator = input.next().charAt(0);

            switch (operator) {
                case "+": stack = Math.add(inputA, inputB); break;
                case "-": stack = Math.subtract(inputA, inputB); break;
                case "*": stack = Math.multiply(inputA, inputB); break;
                case "/": stack = Math.divide(inputA, inputB); break;
                case "dup": stack = Math.duplicate(inputA, inputB); break;
                case "drop":stack = Math.drop(inputA); break;
                case "over":stack = Math.over(inputA, inputB); break;
                case "sqrt":stack = Math.sqrt(inputA); break;
                case "floor": stack = Math.floor(inputA); break;
                case "abs": stack = Math.abs(inputA); break;
            }
            System.out.println(stack);
        }
        input.close();

    }
}

public class Math {
    double add(double inputA, double inputB){
        stack = inputA + inputB;
        return stack; 
    }

    double subtract(double a, double b){
        stack = a - b;
        return stack;
    }

    double multiply(double a, double b){
        stack = a * b;
        return stack;
    }

    double divide(double a, double b){
        stack = a / b;
        return stack;
    }

    double duplicate(double a){
        stack = a * a;
        return stack;
    }

    double drop() {

    }
    double over(){

    }
    double sqrt(){
        stack = Math.sqrt(a);
        return stack;

    }
    double floor(){

    }
    double abs(){

    }

}