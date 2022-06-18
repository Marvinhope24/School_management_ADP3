/*  Kegomoditswe Leshope - 219189048
    CountryController.java
    16 June 2022
 */

package za.ac.cput.School_Management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Service.Employee.Interface.ICountryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CountryController {

    private final ICountryService iCountryService;

    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save (@Valid @RequestBody Country country){
        log.info("Save request: {}", country);
        Country save = iCountryService.save(country);
        return ResponseEntity.ok(save);
    }

    private Optional<Country> getById(String id){
        return this.iCountryService.read(id);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read (@PathVariable String id){
        log.info("Read request: {}",id );
        Country country = this.iCountryService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.iCountryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll(){
        List <Country> country = this.iCountryService.findAll();
        return ResponseEntity.ok(country);
    }
}
