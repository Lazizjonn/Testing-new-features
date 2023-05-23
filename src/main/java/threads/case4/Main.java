package threads.case4;

class Main {
    public static void main(String[] args) {
        A a = new A();

        // Handle update
        Thread thread1 = new Thread(() -> {
            int count = a.count;
            while (count < 10) {
                if (count != a.count) {
                    System.out.println("#1 count= " + count);
                    count = a.count;
                }
            }
        });

        //Increment
        Thread thread2 = new Thread(() -> {
            int count = a.count;
            while (count < 10) {
                ++count;
                a.count = count;
                System.out.println("#2 count= " + count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}

class A {
    volatile int count;
}