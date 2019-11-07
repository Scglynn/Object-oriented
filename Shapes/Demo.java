import java.util.*;
import java.io.*;

public class Demo {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();

        list.add(new Box("blue","maroon",0,10,10,20));
        list.add(new Box(null,"fuchsia",20,3,40,30));
        list.add(new Circle("white","black",50,50,30));
        list.add(new Triangle("#00ff00",null,50,50,30,20,10,40));

        try {
            Shape.writeSVG("demo.svg",list);
            
            for (Shape s : list) 
                s.move(50,0);
        
            Shape.writeSVG("demo2.svg",list);
        } catch (Exception e) { //catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}