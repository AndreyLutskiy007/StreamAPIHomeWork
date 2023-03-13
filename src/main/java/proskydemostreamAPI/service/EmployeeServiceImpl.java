package proskydemostreamAPI.service;

import org.springframework.stereotype.Service;
import proskydemostreamAPI.exception.EmployeeAlreadyAddedException;
import proskydemostreamAPI.exception.EmployeeNotFoundException;
import proskydemostreamAPI.exception.EmployeeStorageIsFullException;
import proskydemostreamAPI.person.Employee;

import java.util.ArrayList;
import java.util.List;

import static proskydemostreamAPI.person.Department.DEPARTMENT_BY_ID;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_EMPLOYEES_COUNT = 10;
    private static List<Employee> employees = new ArrayList<>();
    static {
        Employee personnel1 = new Employee("Вадим", "Олегович", 234542f,DEPARTMENT_BY_ID.get(1));
        Employee personnel2 = new Employee("Олег", "Александрович", 234768f,DEPARTMENT_BY_ID.get(1));

        Employee technologies1 = new Employee("Оксана", "Мартовна", 768756f,DEPARTMENT_BY_ID.get(2));
        Employee technologies2 = new Employee("Рамиль", "Руфатович", 465465f,DEPARTMENT_BY_ID.get(2));
        Employee technologies3 = new Employee("Андрей", "Андреевич", 100203f,DEPARTMENT_BY_ID.get(2));

        Employee mechanic1 = new Employee("Альберт", "Маркович", 234783f,DEPARTMENT_BY_ID.get(3));
        Employee mechanic2 = new Employee("Денис", "Денисович", 283464f,DEPARTMENT_BY_ID.get(3));
        Employee mechanic3 = new Employee("Артем", "Артемович", 234432f,DEPARTMENT_BY_ID.get(3));
        Employee mechanic4 = new Employee("Марат", "Маратович", 327427f,DEPARTMENT_BY_ID.get(3));

        employees.add(personnel1);
        employees.add(personnel2);
        employees.add(technologies1);
        employees.add(technologies2);
        employees.add(technologies3);
        employees.add(mechanic1);
        employees.add(mechanic2);
        employees.add(mechanic3);
        employees.add(mechanic4);

    }
    @Override

    public Employee add(String firstName, String lastName, float salary, int departmentId) {
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee employee = new Employee(firstName, lastName, salary, DEPARTMENT_BY_ID.get(departmentId));
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }
        employees.add(employee);
        return employee;
    }
    @Override

    public Employee find(String firstName, String lastName) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e != null && firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName())){
                employee = e;
            }

        }
        if (employee == null){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }
    @Override

    public Employee remove(String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        for (Employee e : employees) {
            if (e.equals(employee)) {
                employees.remove(e);
                return e;
            }
        }
        return employee;
    }
    public List<Employee> getAll() {
        return employees;
    }





}
