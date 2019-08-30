package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

//    @GetMapping
//    public ResponseEntity<List<Employee>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
//        if (page == null || pageSize ==null){
//            return ResponseEntity.ok(employeeMapper.selectAll());
//        }
//
//        int limit = pageSize;
//        int offset = (page -1) * pageSize;
//        return ResponseEntity.ok(employeeMapper.selectPageSize(limit, offset));
//    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeeByKeyWorld(@RequestParam String keyWord) {

        return ResponseEntity.ok(employeeMapper.queryEmployeeByKeyWord(keyWord));
    }

    @PostMapping
    public ResponseEntity<List<Employee>> postEmployess(@RequestBody Employee employee){
        String id = UUID.randomUUID().toString();

        employee.setId(id);
        employeeMapper.insert(employee);

        return ResponseEntity.created(URI.create("/employees/" + id)).build();
    }

    @PutMapping
    public ResponseEntity<String> putEmployess(@RequestParam String id, @RequestBody Employee employee){

        employeeMapper.update(id, employee);

        return ResponseEntity.ok("success");
    }


}
