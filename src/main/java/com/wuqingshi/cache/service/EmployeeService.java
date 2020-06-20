package com.wuqingshi.cache.service;

import com.wuqingshi.cache.bean.Employee;
import com.wuqingshi.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//可以去掉其他的value
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的结果进行缓存，以后查询就不用连接数据库
     *
     * CacheManager管理多个Cache，真正操作是在Cache中
     *
     * cacheName/value:指定缓存组件的名字，数组可写多个
     * key:缓存数据使用的key,默认是使用方法参数的值   1-zhangsan
     */
    @Cacheable(cacheNames = {"emp"} , keyGenerator = "myKeyGenerator" /*,condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id +"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut:既调用方法，又更新缓存数据
     *
     * 先调用目标方法，再更新缓存
     */

    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * allEntries=true:清除缓存中所有的数据
     * beforeInvocation:缓存清除操作是否在方法之前执行
     */
    @CacheEvict(value = "emp",beforeInvocation = false/*,allEntries = true*/)
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmpById(id);
    }

    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
