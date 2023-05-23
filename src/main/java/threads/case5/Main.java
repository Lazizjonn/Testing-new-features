package threads.case5;

import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) {

        RequestManager manager = new RequestManager();

        manager.setAuthenticator(request -> {
            synchronized (lock) {
                if (SharedPref.token != request.token.token) {
                    return new Request(request.name + "-refresh", new Token(SharedPref.token), request.requestData, request.listener);
                }

                CompletableFuture<Request> future = new CompletableFuture<>();

                manager.updateToken(SharedPref.key, (code, key, token) -> {
                    System.out.println("updated: " + request.name + " code=" + code);
                    Request newRequest = null;
                    if (code == 200) {
                        SharedPref.token = token;
                        SharedPref.key = key;
                        newRequest = new Request(request.name + "-refresh", new Token(token), request.requestData, request.listener);
                    } else {
                        System.out.println("Logout");
                    }
                    future.complete(newRequest);
                });
                return future.join();
            }
        });

        Request request1 = new Request("#1", new Token(SharedPref.token), 0, (code, data) ->
                System.out.println("Response #1 - code=" + code + " data=" + data));

        Request request2 = new Request("#2", new Token(SharedPref.token), 0, (code, data) ->
                System.out.println("Response #2 - code=" + code + " data=" + data));

        Request request3 = new Request("#3", new Token(SharedPref.token), 0, (code, data) ->
                System.out.println("Response #3 - code=" + code + " data=" + data));

        manager.execute(request1);
        manager.execute(request2);
        manager.execute(request3);

    }
}