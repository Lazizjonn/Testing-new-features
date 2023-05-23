package JavaNotesForPr.typeConversion;

import java.util.Calendar;
import java.util.Date;

public class TypeConversion {
    public static void main(String[] args) {

    }
}

class A {

    // Implicit casting
    byte byteVar1 = 42;
    short shortVar1 = byteVar1;
    int intVar1 = shortVar1;
    long longVar1 = intVar1;
    float floatVar1 = longVar1;
    double doublevar = floatVar1;

    // Explicit casting
    double doubleVar2 = 42.0d;
    float floatVar2 = (float) doubleVar2;
    long longVar2 = (long) floatVar2;
    int intVar2 = (int) longVar2;
    short shortVar2 = (short) intVar2;
    byte byteVar2 = (byte) shortVar2;
}

class B {
    public void func() {
        char char1 = 1, char2 = 2;
        short short1 = 1, short2 = 2;
        int int1 = 1, int2 = 2;
        float float1 = 1.0f, float2 = 2.0f;

        // char1 = char1 + char2; // Error: Cannot convert from int to char;
        // short1 = short1 + short2; // Error: Cannot convert from int to short;

        int1 = char1 + char2; // char is promoted to int.
        int1 = short1 + short2; // short is promoted to int.
        int1 = char1 + short2; // both char and short promoted to int.
        float1 = short1 + float2; // short is promoted to float.
        int1 = int1 + int2; // int is unchanged.
    }
}

class C {

    char char3 = (char) 66; // A
    byte byte3 = (byte) 'A'; // 65
    short short3 = (short) 'A'; // 65
    int int3 = (int) 'A'; // 65

    char char2 = (char) 8253; // ‽
//    byte byte2 = (byte) '‽'; // 61 (truncated code-point into the ASCII range)
//    short short2 = (short) '‽'; // 8253
//    int int2 = (int) '‽'; // 8253
}

class D {
    public static void main(String[] args) {
        Object obj = Calendar.getInstance();
        Date time1;
        Long time2;

        if (obj instanceof Calendar) {
            time1 = ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            time2 = ((Date) obj).getTime();
        }
    }
}

class E {

    public int a = 10;

    public E() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Lazizjon";
    }
}

class F {
    public static void main(String[] args) {
        Object obj = new Object();
        String text = obj.toString();
        System.out.println(text);
    }
}

class G {

}

class CountHolder {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int c) {
        count = c;
    }
}

