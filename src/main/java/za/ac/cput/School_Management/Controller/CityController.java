/*  Kegomoditswe Leshope - 219189048
    CityController.java
    16 June 2022
 */

package za.ac.cput.School_Management.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Service.Employee.Interface.ICityService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school-management/city/")
@Slf4j
public class CityController {

    private final ICityService iCityService;

    @Autowired public CityController(ICityService iCityService) {
        this.iCityService = iCityService;
    }

    @PostMapping("save")
    public ResponseEntity<City> save (@Valid @RequestBody City city){
        log.info("Save request: {}", city);
        City save = iCityService.save(city);
        return ResponseEntity.ok(save);
    }

    private Optional<City> getById(String id){
        return this.iCityService.read(id);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read (@PathVariable String id){
        log.info ("Read request: {}", id);
        City city = getById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        log.info("Delete request: {}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>>findAll(){
        List<City> city = this.iCityService.findAll();
        return ResponseEntity.ok(city);
    }

    @GetMapping("readById")
    public ResponseEntity<Optional<City>> findById(@PathVariable String countryId){
        Optional<City> city = getById(countryId);
        return ResponseEntity.ok(city);
    }
}
