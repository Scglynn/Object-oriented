import java.util.*;

public class Stack {
    double stack [] = new double[5];
    double top = 0;

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
    public void show() {
        for (double n : stack) {
            System.out.println(n + " ");
        }
    }
}