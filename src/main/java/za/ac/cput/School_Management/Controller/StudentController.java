/*
Tiffany Kiwiets - 219322732
StudentController.java
17 June 2022
*/

package za.ac.cput.School_Management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.School_Management.Domain.Student;
import za.ac.cput.School_Management.Service.Employee.Interface.IStudentService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/school-management/student")
@Slf4j
public class StudentController {
    private final IStudentService iStudentService;

    @Autowired
    public StudentController (IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        log.info("Save request: {}", student);
        System.out.println(String.format("Save request: ", student));
        Student save = iStudentService.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<Student> read(@PathVariable String studentId) {
        log.info("Read request {}", studentId);
        Student student = this.iStudentService.read(studentId).get();
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable String studentId) {
        log.info("Delete request {}", studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity <List<Student>> findAll() {
        List<Student> student = this.iStudentService.findAll();
        return ResponseEntity.ok(student);
    }



}
