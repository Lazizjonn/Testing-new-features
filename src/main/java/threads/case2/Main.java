package threads.case2;

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(() -> System.out.println("Hello 1"));
        thread1.start();

        System.out.println("End of main");
    }
}

class MyThread extends Thread {
    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Hello 2");
    }
}