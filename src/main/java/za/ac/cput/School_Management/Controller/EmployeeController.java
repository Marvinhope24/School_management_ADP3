// Marvin Hope - 219445842
// EmployeeController.java
// 17 June 2022

package za.ac.cput.School_Management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.School_Management.Domain.Employee;
import za.ac.cput.School_Management.Service.Employee.Interface.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school-management/employee")
@Slf4j
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
        log.info("Save request: {}", employee);
        System.out.println(String.format("Save request: " , employee));
        Employee save = iEmployeeService.save(employee);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        Employee employee =
                this.iEmployeeService.read(staffId).get();
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable String staffId) {
        log.info("Delete request: {}", staffId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity <List<Employee>> findAll() {
        List<Employee> employee = this.iEmployeeService.findAll();
        return ResponseEntity.ok(employee);
    }
}