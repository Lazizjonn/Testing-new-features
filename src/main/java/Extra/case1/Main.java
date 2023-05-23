package Extra.case1;

public class Main {
    public static void main(String[] args) {
//        Student student = Student
//                .getInstance("Lazizjon")
//                .setLastName("Suyunov")
//                .setFirstName("Lazizjon 2")
//                .build();
//
//        System.out.println(student.getFirstName() + "  " + student.getLastName());


    }
}

/*class Student {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    static Builder getInstance(String firstName) {
        return new Builder(firstName);
    }

    static class Builder {

        private Student student = new Student();

        public Builder(String firstName) {
            student.firstName = firstName;
        }


        Builder setLastName(String lastName) {
            student.lastName = lastName;
            return this;
        }

        Builder setFirstName(String firstName) {
            student.firstName = firstName;
            return this;
        }

        Student build() {
            return student;
        }

    }
}*/

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.print("Name : " + name + ", ");
        System.out.println(" age : " + age);
    }

    public int getAge() {
        return age;
    }
}


@FunctionalInterface
interface A {
    void show();
}

@FunctionalInterface
interface B {
    int show(int a, int b);
}

@FunctionalInterface
interface C {
    int show(int a);
}

@FunctionalInterface
interface D {
    int invoke(int a);
}

@FunctionalInterface
interface F {
    int show(int a, int b);
}

@FunctionalInterface
interface E {
    String show(int a, int b);
}

class Main2 {
    public static void main(String[] args) {
        Student student = new Student("Laziz", 26);
        A a = student::info;
        a.show();

        B b = Math::max;
        System.out.println(b.show(100, 20));
    }
}