package tws.repository;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeMapper employeeMapper;

    @After
    public void dealProcess(){
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
    }

    @Test
    public void should_return(){
        jdbcTemplate.execute("insert into employee values ('001', 'wanghui', 18)");

        List<Employee> employees = employeeMapper.selectAll();

        Assert.assertEquals(1, employees.size());
    }

    @Test
    public void should_insert(){
        jdbcTemplate.execute("insert into employee values ('002', 'wanghui', 18)");

        Employee employee = new Employee("001", "wanghui", 18);
        employeeMapper.insert(employee);

        int number = JdbcTestUtils.countRowsInTable(jdbcTemplate, "employee");
        Assert.assertEquals(2, number);

    }
}
