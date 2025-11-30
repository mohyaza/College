class Student {
    // Private variable
    private String name;
    private int age;

    // Setter: untuk mengubah nilai
    public void setName(String name) {
        this.name = name;
    }

    // Getter: untuk mengambil nilai
    public String getName() {
        return this.name;
    }

    // Setter untuk age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    // Getter untuk age
    public int getAge() {
        return this.age;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        
        Student s1 = new Student();

        // Mengisi data menggunakan setter
        s1.setName("Budi");
        s1.setAge(20);

        // Mengambil data menggunakan getter
        System.out.println("Nama: " + s1.getName());
        System.out.println("Usia: " + s1.getAge());
    }
}