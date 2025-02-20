public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Hoang", "123 Main St");
        System.out.println(p1);

        Student s1 = new Student("Hoan", "456 College Rd", "Computer Science", 2024, 5000.0);
        System.out.println(s1);

        Staff st1 = new Staff("Hoa", "789 School Ln", "XYZ High School", 3500.0);
        System.out.println(st1);
    }
}
