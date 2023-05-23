package threads.case5;

@FunctionalInterface
interface Authenticator {
    Request authenticate(Request request);
}
