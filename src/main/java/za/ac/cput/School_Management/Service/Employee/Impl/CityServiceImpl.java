/*  Kegomoditswe Leshope - 219189048
    CityServiceImpl.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Repository.Interface.ICityRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {
    private final ICityRepository repository;


    @Autowired public CityServiceImpl(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }

    //Q7.
    public Optional<City> findById(String countryId){
        return this.repository.findById(countryId);
    }
}
