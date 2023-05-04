package reflections;

import java.lang.reflect.Field;

class ChangeNumber {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        changeNumber(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    static void changeNumber(Integer a, Integer b) {

        try {
            int temp = a.intValue();

            Field field = a.getClass().getDeclaredField("value");
            Field field2 = b.getClass().getDeclaredField("value");

            field.setAccessible(true);
            field.setInt(a, b);

            field2.setAccessible(true);
            field2.setInt(b, temp);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
