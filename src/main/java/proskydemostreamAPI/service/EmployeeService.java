package proskydemostreamAPI.service;

import proskydemostreamAPI.person.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee add(String firstName, String lastName, float salary, int departmentId);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    List<Employee> getAll();

}

