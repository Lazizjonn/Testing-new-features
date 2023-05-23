package threads.case0;

public class ThreadVolatileSynchronized {
    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo firstThread = new ThreadDemo("Thread 1", printDemo);
        ThreadDemo secondThread = new ThreadDemo("Thread 2", printDemo);

        try {
            firstThread.start();
            secondThread.start();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

class PrintDemo {
    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Selected number is: " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread has been interrupted.");
        }
    }
}

class ThreadDemo implements Runnable {
    private Thread thread;
    private String threadName;
    PrintDemo printDemo;

    ThreadDemo(String threadName, PrintDemo printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    public void run() {
        synchronized (printDemo) {
            printDemo.printCount();
        }
        System.out.println("Thread " + threadName + " finishing.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class A {
}

class B extends A {

}
