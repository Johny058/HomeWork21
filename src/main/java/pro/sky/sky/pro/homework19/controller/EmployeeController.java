package pro.sky.sky.pro.homework19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.sky.pro.homework19.model.Employee;
import pro.sky.sky.pro.homework19.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam("name") String fistName,
                                     @RequestParam("surname") String lastName) {

                return employeeService.add(fistName, lastName);
    }
    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("name") String fistName,
                        @RequestParam("surname") String lastName) {

        return employeeService.remove(fistName, lastName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name") String fistName,
                        @RequestParam("surname") String lastName) {

        return employeeService.find(fistName, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }




}
