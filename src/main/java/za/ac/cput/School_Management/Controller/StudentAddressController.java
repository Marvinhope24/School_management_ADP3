/* StudentAddressController.java
   Controller for the Student Address
   Author: Raeesah Williams (219091498)
   Date: 12 June 2022
*/

package za.ac.cput.School_Management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.School_Management.Domain.StudentAddress;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school-management/studentAddress")
@Slf4j
public class StudentAddressController
{
    private final IStudentAddressService iStudentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService iStudentAddressService)
    {
        this.iStudentAddressService = iStudentAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress)
    {
        log.info("Save request: {}", studentAddress);
        StudentAddress save = iStudentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id)
    {
        log.info(("Read request: {}"), id);
        StudentAddress studentAddress = this.iStudentAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable StudentAddress studentAddress)
    {
        log.info("Delete request: {}", studentAddress);
        this.iStudentAddressService.delete(studentAddress);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll()
    {
        List<StudentAddress>studentAddress = this.iStudentAddressService.findAll();
        return ResponseEntity.ok(studentAddress);
    }
}


