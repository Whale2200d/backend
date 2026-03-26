public class Employee extends Teacher {
    public String department;

    public Employee(String name, long number, String schoolName, long employeeNumber, String department) {
        super(name, number, schoolName, employeeNumber);
        this.department = department;
    }

    /**
     * final을 사용하여 하위 클래스에서 해당 메서드 오버라이딩을 허용하지 않음
     */
    @Override
    public final void printInfo() {
        System.out.println("Employee Info ================");
		System.out.println("name: " + super.name);
		System.out.println("IdNumber: " + super.getIdNumber());
		System.out.println("schoolName: " + super.schoolName);
		System.out.println("employeeNumber: " + super.number);
        System.out.println("department: " + this.department);
    }
}
