package pro.sky.sky.pro.homework19.service;

import org.springframework.stereotype.Service;
import pro.sky.sky.pro.homework19.exception.EmployeeAlreadyAddedException;
import pro.sky.sky.pro.homework19.exception.EmployeeNotFoundException;
import pro.sky.sky.pro.homework19.exception.EmployeeStorageIsFullException;
import pro.sky.sky.pro.homework19.model.Employee;

import java.util.*;

@Service
public class EmployeeService{

private static final int MAX_EPLOYEE = 10;
    private final Map<String,Employee> employees = new HashMap<>();


    public Employee add(String firstName, String lastName) {
        if (employees.size() == MAX_EPLOYEE) {
            throw new EmployeeStorageIsFullException();
        }
        String kay = buildKay (firstName, lastName);
        if (employees.containsKey(kay)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(kay, new Employee(firstName, lastName));
        return null;
    }

    public Employee remove(String firstName, String lastName) {
        String kay = buildKay (firstName, lastName);
        Employee employee = employees.remove(kay);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    public Employee find(String firstName, String lastName) {
        String kay = buildKay (firstName, lastName);
        Employee employee = employees.get(kay);;
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    private String buildKay (String name, String surname) {
            return name + surname;
    }
}


