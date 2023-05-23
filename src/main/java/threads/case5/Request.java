package threads.case5;

public class Request {
    final Token token;
    final OnResponseListener listener;
    final int requestData;
    final String name;

    public Request(String name, Token token, int data, OnResponseListener listener) {
        this.name = name;
        this.token = token;
        this.listener = listener;
        requestData = data;
    }
}
