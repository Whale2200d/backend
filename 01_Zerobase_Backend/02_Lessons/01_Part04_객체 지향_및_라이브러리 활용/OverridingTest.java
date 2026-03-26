

public class OverridingTest {
    public static void main(String[] args) {
        Person person = new Person("Aiden", 1111);
        // System.out.println("name: " + person.name + ", IdNumber: " + person.number);
        person.printInfo();

        Person person2 = new Person("Tom", 2222);
        // System.out.println("name: " + person2.name + ", IdNumber: " + person2.number);
        person2.printInfo();

        Teacher teacher = new Teacher("David", 3333, "fastCampus", 33333);
        teacher.printInfo(); // person info만 나옴

        Employee employee = new Employee("Met", 4444, "fastCampus", 44444, "business");

        System.out.println("==============================");
        Person[] personList = {person, person2, teacher, employee};
        for (int i = 0; i < personList.length; i++) {
            personList[i].printInfo();
        }
    }
}
