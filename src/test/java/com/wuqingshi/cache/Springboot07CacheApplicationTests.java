package com.wuqingshi.cache;

import com.wuqingshi.cache.bean.Employee;
import com.wuqingshi.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
