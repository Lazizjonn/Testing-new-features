package threads.case5;

@FunctionalInterface
interface OnResponseListener {
    void onResponse(int code, int data);
}
