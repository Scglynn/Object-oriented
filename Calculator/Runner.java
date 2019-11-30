import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(scan.nextDouble());

        while(scan.hasNextDouble())
            stack.push(scan.nextDouble());
    }
}