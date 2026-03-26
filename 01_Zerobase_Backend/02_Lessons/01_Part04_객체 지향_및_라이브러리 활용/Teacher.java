// 교직원(Teacher)
public class Teacher extends Person {
	public String schoolName;
	public long number;
	
	public Teacher(String name, long number, String schoolName, long employeeNumber) {
		super(name, number);
		this.schoolName = schoolName;
		this.number = employeeNumber;
	}

	/**
	 * Overriding의 필요조건 3가지
	 * 1. Method name
	 * 2. Return type
	 * 3. Props
	 */
	@Override // 명시해주는 것이 좋음
	public void printInfo() {
		System.out.println("Teacher Info ================");
		System.out.println("name: " + super.name);
		System.out.println("IdNumber: " + super.number);
		System.out.println("schoolName: " + this.schoolName);
		System.out.println("employeeNumber: " + this.number);
	}
}