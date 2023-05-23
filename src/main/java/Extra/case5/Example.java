package Extra.case5;

public class Example {
    Example() {

    }
}

class Sample {
    public static void main(String[] args) {
        Message message = new Message();
        message.showMessage(Test::info);  // norm
        message.showMessage((new Test())::show);  // norm
//        message.showMessage((new Test())::info);  // xatolik

        (new Test()).info(""); // norm
    }
}

interface Call { void onCall(String name);}

class Message { void showMessage(Call call) {call.onCall("Android dev");}}

class Test implements Call {
    void show(String name) {}
    static void info(String name) {}

    @Override
    public void onCall(String name) {

    }
}