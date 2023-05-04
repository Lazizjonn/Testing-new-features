package highorderfunc;

class HighOrder {
    public static void main(String[] args) {
        A a = new A();
        a.method2A((amount, name) -> 0);
    }
}


interface C {
    int method1(int amount, String name);
}

class A {
    void method2A(C c) { c.method1(2, "");}
}