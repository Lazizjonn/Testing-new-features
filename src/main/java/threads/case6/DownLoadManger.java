package threads.case6;

public class DownLoadManger {
    private int progress = 0;
    private OnProgressListener listener;
    private boolean isPause = false;

    public boolean isFinished() {
        return progress == 100;
    }

    void download() {
        new Thread(() -> {
            while (!isFinished()) {
                if (isPause) continue;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                progress++;
                System.out.println(progress);
                listener.onProgress(progress);
            }
        }).start();
    }

    public void pause () {
        isPause = false;
    }

    public void resume () {
        isPause = true;
    }

}
