package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述 : TODO
 *
 * @Author : 王辉
 * @Email : wanghui16@zybank.com.cn
 * @Date : 2019-08-30 10:54
 */
public class EmployeeService implements Serializable {
    @Autowired
    EmployeeMapper employeeMapper;


    public List<EmployeeDto> getEmployeeWithDescription(String description){

        List<Employee> employees = employeeMapper.queryEmployeeByKeyWorld(description);

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employees.forEach(employee -> {
            employeeDtos.add(new EmployeeDto(employee,"description"));
        });

        return employeeDtos;
    }
}
