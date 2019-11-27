import java.util.*;

public class Calculator {
    public static void main(String args []) {
        double inputA, inputB;
        String operator;
        boolean done = false;
        ArrayList<Double> stack = new ArrayList<Double>();
        Scanner input = new Scanner(System.in);

        while(!done){
            inputA = input.nextDouble();
            inputB = input.nextDouble();
            operator = input.next();

            //helps to determine the operator and what it should do
            switch (operator) {
                case "+": stack = Math.add(inputA, inputB); break;

                //case "-": stack = Math.subtract(inputA, inputB); break;

                //case "*": stack = Math.multiply(inputA, inputB); break;

                //case "/": stack = Math.divide(inputA, inputB); break;

                //case "dup": stack = Math.duplicate(inputA, inputB); break;

                //case "drop":stack = Math.drop(inputA); break;

                //case "over":stack = Math.over(inputA, inputB); break;

                //case "sqrt":stack = Math.sqrt(inputA); break;

                //case "floor": stack = Math.floor(inputA); break;

                //case "abs": stack = Math.abs(inputA); break;
            }
        }
    }
}