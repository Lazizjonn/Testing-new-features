package threads.case6;

public class Main {
    public static void main(String[] args) {
        DownLoadManger downLoadManger = new DownLoadManger();

        downLoadManger.resume();
        downLoadManger.download();
    }
}
