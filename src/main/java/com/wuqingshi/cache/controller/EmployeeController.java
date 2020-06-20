package com.wuqingshi.cache.controller;

import com.wuqingshi.cache.bean.Employee;
import com.wuqingshi.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee Update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
}
