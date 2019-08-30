package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tws.entity.Employee;

import java.util.List;

@Mapper
@Service
public interface EmployeeMapper {

    List<Employee> selectAll();

    List<Employee> selectPageSize(@Param("limit")int limit, @Param("offset")int offset);

    void insert(@Param("employee") Employee employee);

    void update(@Param("id") String id, @Param("employee") Employee employee);

    List<Employee> queryEmployeeByKeyWord(@Param("keyWord") String keyWord);
}
