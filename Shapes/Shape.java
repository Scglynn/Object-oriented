import java.io.*;
import java.util.List;

public abstract class Shape {

    abstract double getArea();      // computes the area
    abstract double getPerimeter(); // computes the perimeter
    //public abstract String toString();     // XML description of the object
    abstract void move(int moveX, int moveY);

    
    public final String toString() {
        return getElement();
    }
    
    protected abstract String getElement();

    public static void writeSVG(String fileName, List<Shape> shapeList) { //for each syntax check

        
        try {
            File file = new File("C:/Source/OOStuctures/Shapes/Demo.svg");
            FileWriter fr = new FileWriter(file);
            fr.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            fr.write("<svg width=\"2000\" height=\"2000\" xmlns=\"http://www.w3.org/2000/svg\">");
            for (Shape s : shapeList) {
                fr.write(s.toString());
            }
            fr.write("</svg>");
            fr.close();
        }
        catch(IOException ex){
            
        }
    }
 }

 

class Box extends Shape {
    String color = "";
    String outline = "";
    int left =0;
    int top = 0;
    int width = 0;
    int height = 0;
    int right = 0;
    int bottom = 0;
    int moveX = 0;
    int moveY = 0;


    Box(String color, String outline, int left, int top, int width, int height) {
        this.color = color;
        this.outline = outline;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.right = left + width;
        this.bottom = top + height;

    }
    int getLeft(){
        return left;
    }

    int getTop(){
        return top;
    }
    int getBottom() {
        bottom = top + height;
        return bottom;
    }
    
    int getWidth(){
        return width;
    }
    int getRight() {
        right = left + width;
        return right;
    }

    int getHeight(){
        return height;
    }

    public void setLeft(int left) {
         this.left = left;
    }

    public void setRight(int right) {
        this.right = left + width;
    }

    public void setTop(int top) {
         this.top = top;
    }

    public void setBottom(int bottom) {
        this.bottom = top + height;
    }

    public void setWidth(int width) {
         this.width = width;
    }
    
    public void setHeight(int height) {
         this.height = height;
    }
    public void setOutline(String outline) {
        this.outline = outline;
    }
    public void setColor(String color) {
        this.color = color;
    }

    double getArea() {
        return width *height;
    }

    double getPerimeter() {
        return(2 * width) + (2*height);
    }
    String getOutline(){
        return outline;
    }
    String getColor() {
        return color;
    }

    public String getElement() {
        String out = "";
        out = "<rect x=\"" + left + "\" y=\"" + top + "\" width=\"" + width + "\" height=\"" + height;

        if (color != null) {
            out += "\" fill=\"" + color;   
        }

        if (outline != null) {
            out += "\" stroke=\"" + outline;
        }
        out += "\" />";

        return out;
    }
            
    public void move(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;

        this.left = this.left + moveX;
        this.top = this.top + moveY;
        this.right = this.left + this.width;
        this.bottom = this.top + this.height;
    }

}

class Circle extends Shape {
    String color = "";
    String outline = "";
    int cx = 0;
    int cy = 0;
    int moveX = 0;
    int moveY = 0;
    int radius = 0;

    Circle(String color, String outline,int cx, int cy, int radius) {
        this.color = color;
        this.outline = outline;
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    double getArea() {
        return (Math.PI)*(radius*radius);
    }

    double getPerimeter() {
        return (2*Math.PI*radius);
    }

    public void setCenterX(int cx) {
        this.cx = cx;
    }

    public void setCenterY(int cy) {
        this.cy = cy;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setOutline(String outline) {
        this.outline = outline;
    }
    public void setColor(String color) {
        this.color = color;
    }
    int getRadius() {
        return radius;
    }
    int getCenterX() {
        return cx;
    }
    int getCenterY() {
        return cy;
    }
    String getOutline(){
        return outline;
    }
    String getColor() {
        return color;
    }

    public String getElement() {
        String out = "";  //"<circle cx="30" cy="40" radius="20" fill="blue" />"
        out = "<circle cx=\"" + cx + "\" cy=\"" + cy + "\" r=\"" + radius;

        
        if (color != null) {
            out += "\" fill=\"" + color;
        }
        if (outline != null) {
            out += "\" stroke=\"" + outline;
        }
        out += "\" />";

        return out;
    }

    public void move(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;

        this.cx = cx + moveX;
        this.cy = cy + moveY;

    }

}

class Triangle extends Shape {
    String color = "";
    String outline = "";
    int cx1 = 0;
    int cy1 = 0;
    int cx2 = 0;
    int cy2 = 0;
    int cx3 = 0;
    int cy3 = 0;
    int moveX = 0;
    int moveY = 0;

    Triangle(String color, String outline, int cx1,int cy1, int cx2, int cy2, int cx3, int cy3) {
        this.color = color;
        this.outline = outline;
        this.cx1 = cx1;
        this.cy1 = cy1;
        this.cx2 = cx2;
        this.cy2 = cy2;
        this.cx3 = cx3;
        this.cy3 = cy3;
    }
    
    double getArea() {
        double side1 = 0;
        double side2 = 0;
        double side3 = 0;

        side1 = Math.sqrt(((cx1-cx2)*(cx1-cx2))+((cy1-cy2)*(cy1-cy2)));
        side2 = Math.sqrt(((cx2-cx3)*(cx2-cx3))+((cy2-cy3)*(cy2-cy3)));
        side3 = Math.sqrt(((cx3-cx1)*(cx3-cx1))+((cy3-cy1)*(cy3-cy1)));
        
        double s = ((side1+side2+side3)/2);
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));

        return area;
    }

    double getPerimeter() {
        double side1 = 0;
        double side2 = 0;
        double side3 = 0;

        side1 = Math.sqrt(((cx1-cx2)*(cx1-cx2))+((cy1-cy2)*(cy1-cy2)));
        side2 = Math.sqrt(((cx2-cx3)*(cx2-cx3))+((cy2-cy3)*(cy2-cy3)));
        side3 = Math.sqrt(((cx3-cx1)*(cx3-cx1))+((cy3-cy1)*(cy3-cy1)));
        double distance = side1+side2+side3;

        return distance;
    }

    public void setCornerX1(int cx1){
        this.cx1 = cx1;
    }

    public void setCornerX2(int cx2){
        this.cx2 = cx2;
    }
    
    public void setCornerX3(int cx3){
        this.cx3 = cx3;
    }
    
    public void setCornerY1(int cy1){
        this.cy1 = cy1;
    }
    
    public void setCornerY2(int cy2){
        this.cy2 = cy2;
    }
        
    public void setCornerY3(int cy3){
        this.cy3 = cy3;
    }
    public void setOutline(String outline) {
        this.outline = outline;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    int getCornerX1(){
        return cx1;
    }
    int getCornerX2(){
        return cx2;
    }
    int getCornerX3(){
        return cx3;
    }
    int getCornerY1(){
        return cy1;
    }
    int getCornerY2(){
        return cy2;
    }
    int getCornerY3(){
        return cy3;
    }
    String getOutline(){
        return outline;
    }
    String getColor() {
        return color;
    }
    public String getElement() {
        String out = "";     // "<polygon points="10,10 5,10 30,30" fill="white" />"
        out = "<polygon path=\"" + cx1 + "," + cy1 + " " + cx2 + "," + cy2 + " " + cx3 + "," + cy3;

        if (color != null) {
            out += "\" fill=\"" + color;
        }

        if (outline != null) {
            out += "\" stroke=\"" + outline;
        }
        out += "\" />";

        return out;
    }
    
    public void move(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;

        this.cx1 = cx1 + moveX;
        this.cy1 = cy1 + moveY;
        this.cx2 = cx2 + moveX;
        this.cy2 = cy2 + moveY;
        this.cx3 = cx3 + moveX;
        this.cy3 = cy3 + moveY;
    }

}