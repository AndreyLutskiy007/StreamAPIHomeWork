package proskydemostreamAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proskydemostreamAPI.exception.DepartmentSearchException;
import proskydemostreamAPI.exception.EmployeeAlreadyAddedException;
import proskydemostreamAPI.person.Employee;
import proskydemostreamAPI.service.DepartmentService;
import proskydemostreamAPI.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentSearchException.class)
    public String handleException(DepartmentSearchException e) {
        return String.format("%s %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<String, List<Employee>> allByDepartmentId(@RequestParam(required = false) Integer departmentId) {
        return departmentService.getAll(departmentId);
    }
}
