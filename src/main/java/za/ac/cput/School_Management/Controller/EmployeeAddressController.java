/*Jayden Johnson -219086796
 EmployeeAddress.java
 */

package za.ac.cput.School_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.School_Management.Domain.EmployeeAddress;
import za.ac.cput.School_Management.Service.Employee.Interface.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/employee/address")
public class EmployeeAddressController {

    private final EmployeeAddressService employeeAddressService;

    @Autowired
    public EmployeeAddressController(EmployeeAddressService employeeAddressService){
        this.employeeAddressService = employeeAddressService;
    }

    @PostMapping("save")
    public EmployeeAddress save(EmployeeAddress employeeAddress){
        return employeeAddressService.save(employeeAddress);
    }

    @GetMapping("read/{id}")
    public Optional<EmployeeAddress> read(@PathVariable String id){
        return employeeAddressService.read(id);
    }

    @DeleteMapping("delete")
    public void delete(EmployeeAddress employeeAddress){
        this.employeeAddressService.delete(employeeAddress);
    }

    @GetMapping("all")
    public List<EmployeeAddress> findAll() {
        return this.employeeAddressService.findAll();
    }

}

