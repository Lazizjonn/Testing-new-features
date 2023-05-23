package threads.case5;

public class RequestManager {

    private int tokenLifeTime = 0;
    private int key = 1;
    private Authenticator authenticator = null;

    RequestManager() {
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                updateTokenTime();
            }
        }).start();
    }

    public void setAuthenticator(Authenticator interceptor) {
        this.authenticator = interceptor;
    }

    public void execute(Request request) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (request.token.token > tokenLifeTime) {
                request.listener.onResponse(200, 0);
            } else {
                if (authenticator != null) {
                    Request request1 = authenticator.authenticate(request);
                    if (request1 != null) {
                        execute(request1);
                        return;
                    }
                }
                request.listener.onResponse(401, -1);
            }
        }).start();
    }

    public void updateToken(int key, RefreshTokenListener listener) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.key == key) {
                this.key++;
                listener.onRefresh(200, this.key, tokenLifeTime + 15);
            } else {
                listener.onRefresh(401, key, 0);
            }
        }).start();
    }

    private void updateTokenTime() {
        tokenLifeTime++;
    }

}
