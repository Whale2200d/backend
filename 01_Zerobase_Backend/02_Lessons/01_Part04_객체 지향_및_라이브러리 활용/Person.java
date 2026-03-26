// 사람
public class Person {
	public String name;
	public long number;

	public Person() {}

	public Person(String name, long number) {
		super();
		this.name = name;
		this.number = number;
	}

	public long getIdNumber() {
		return this.number;
	}

	public void printInfo() {
		System.out.println("Person Info ================");
		System.out.println("name: " + this.name);
		System.out.println("IdNumber: " + this.number);
	}
}