package threads.case7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Parallel limit
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            show("#1");
        });

        service.execute(() -> {
            show("#2");
        });

        service.execute(() -> {
            show("#3");
        });

        service.shutdown();
    }

    static void show(String name) {
        System.out.println(name + " Starting ...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " Finished ");
    }
}

