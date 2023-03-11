package proskydemostreamAPI.person;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final float salary;
    private final Department department;

    public Employee(String firstName, String lastName, float salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }
}
