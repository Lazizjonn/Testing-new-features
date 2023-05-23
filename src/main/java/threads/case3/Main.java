package threads.case3;


public class Main {
    public static void main(String[] args) {

        A a = new A();
        new Thread(() -> {
            int counter = 0;
            while (!a.isFinished) {
                if (a.count == 1000) {
                    a.isFinished = true;
                    System.out.println("Find #1");
                } else {
                    a.count++;
                    System.out.println("#1 - " + counter++ + " count = " + a.count);
                }
            }
        }).start();

        new Thread(() -> {
            int counter = 0;
            while (!a.isFinished) {
                if (a.count == 1000) {
                    a.isFinished = true;
                    System.out.println("Find #2");
                } else {
                    a.count++;
                    System.out.println("#2 - " + counter++ + " count = " + a.count);
                }
            }
        }).start();
        System.out.println("End of main");
    }
}

class A {

    int count = 0;

    volatile boolean isFinished = false;

    synchronized void inc() {
        count++;
    }
}

