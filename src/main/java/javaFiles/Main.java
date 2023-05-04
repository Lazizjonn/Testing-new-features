package javaFiles;



public class Main {
    public static void main(String[] args) {
/*        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow", 2, 4);
        Encapsulate encapsulate = new Encapsulate();*/
    }
}

abstract class Shape  {
    String color;

    abstract double area();

    public abstract String toString();

    public Shape(String color) {
        System.out.println("Constructor Shape called");
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        System.out.println("Constructor Circle called");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.color + " area is " + this.area();
    }
}

class Rectangle extends Shape {
    double height;
    double width;

    public Rectangle(String color, double height, double width) {
        super(color);
        System.out.println("Constructor Rectangle called");
        this.height = height;
        this.width = width;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color + " area is " + this.area();
    }
}

class Encapsulate {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}