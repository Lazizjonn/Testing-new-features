package solid;

// Liskov Substitution principle
// This means that, given that class B is a subclass of class A, we should be able to pass
// an object of class B to any method that expects an object of class A and
// the method should not give any weird output in that case.
//
// This is the expected behavior, because when we use inheritance we assume that
// the child class inherits everything that the superclass has.
// The child class extends the behavior but never narrows it down.

public class L {
    public static void main(String[] args) {

    }
}

class Rectangle {
    protected int width, height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea () {
        return width*height;
    }
}

class Square extends Rectangle {

    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class Test {

    static void getAreaTest(Rectangle rectangle) {
        int width = rectangle.getWidth();
        rectangle.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + rectangle.getArea());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        getAreaTest(rectangle);

        Rectangle square = new Square();
        square.setWidth(5);
        getAreaTest(square);
    }
}

