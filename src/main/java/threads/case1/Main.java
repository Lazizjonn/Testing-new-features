package threads.case1;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("Hello thread1"));
        MyThread thread2 = new MyThread();
        thread2.start();
        thread1.start();
        System.out.println("End of main");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello thread2");
    }
}

// Unpredicted bo'ladi qaysi biriligi
