package Extra.case3;

public class Main {
    public static void main(String[] args) {
//        char defaultValueOfChar;
//        char singleQuote = '\'';
//        char tab = '\t';
//        char backspace = '\b';
//        char newline = '\n';
//        char carriageReturn = '\r';
//        char formfeed = '\f';
//        char doubleQuote = '\"'; // escaping redundant here; '"' would be the same; however still allowed
//        char backslash = '\\';
//        char unicodeChar = '\u2645'; // XXXX represents the Unicode-value of the character you want to
//        char heart = '\u2764';

//        for (int i = 0; i <= 26; i++) {
//            char letter = (char) ('a' + i);
//            System.out.println(letter);
//        }

//        float notExact = 3.1415926f;
//        System.out.println(notExact); // 3.1415925
//
//        float f1 = 0f;
//        float f2 = -0f;
//        System.out.println(f1 == f2); // true
//        System.out.println(1f / f1); // Infinity
//        System.out.println(1f / f2); // -Infinity
//        System.out.println(Float.POSITIVE_INFINITY / Float.POSITIVE_INFINITY); // NaN

        int demo = 2147483647; //maximum positive integer
        int a = 1;
        System.out.println(Integer.MAX_VALUE + " -> " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE + " -> " + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(1 + " -> " + Integer.toBinaryString(a));
        demo = demo + 1; //leads to an integer overflow
        System.out.println("Demo" + " -> " + Integer.toBinaryString(demo));

    }
}

