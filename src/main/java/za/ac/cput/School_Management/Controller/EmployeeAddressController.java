/*Jayden Johnson -219086796
 EmployeeAddressController.java
 */

package za.ac.cput.School_Management.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.School_Management.Domain.EmployeeAddress;
import za.ac.cput.School_Management.Service.Employee.Interface.EmployeeAddressService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("payroll/employee-address/")
@Slf4j
public class EmployeeAddressController {

    private final EmployeeAddressService EmployeeAddressService;

    @Autowired
    public EmployeeAddressController(EmployeeAddressService EmployeeAddressService) {
        this.EmployeeAddressService = EmployeeAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress employeeAddress) {
        log.info("Save request: {}", employeeAddress);
        EmployeeAddress save = EmployeeAddressService.save(employeeAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        EmployeeAddress employeeAddress = this.EmployeeAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> findAll() {
        List<EmployeeAddress> employeeAddresses = this.EmployeeAddressService.findAll();
        return ResponseEntity.ok(employeeAddresses);
    }
}




