package threads.case5;

@FunctionalInterface
interface RefreshTokenListener {
    void onRefresh(int code, int key, int token);
}