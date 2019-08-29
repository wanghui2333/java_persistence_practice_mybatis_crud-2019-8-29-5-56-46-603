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

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @GetMapping("/{keyWorld}")
    public ResponseEntity<List<Employee>> getEmployeeByKeyWorld(@PathVariable String keyWorld) {
        return ResponseEntity.ok(employeeMapper.queryEmployeeByKeyWorld(keyWorld));
    }

    @PostMapping
    public ResponseEntity<List<Employee>> postEmployess(@RequestBody Employee employee){
        String id = UUID.randomUUID().toString();

        employee.setId(id);
        employeeMapper.insert(employee);

        return ResponseEntity.created(URI.create("/employees/" + id)).build();
    }

    @PutMapping
    public ResponseEntity<List<Employee>> putEmployess(@RequestParam String id, @RequestBody Employee employee){

        employeeMapper.update(id, employee);

        List<Employee> employees = employeeMapper.selectAll();
        return ResponseEntity.ok(employees);
    }


}
