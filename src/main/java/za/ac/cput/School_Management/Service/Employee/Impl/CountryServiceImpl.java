/*  Kegomoditswe Leshope - 219189048
    CountryServiceImpl.java
    13 June 2022
 */

package za.ac.cput.School_Management.Service.Employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.School_Management.Domain.Country;
import za.ac.cput.School_Management.Repository.Interface.ICountryRepository;
import za.ac.cput.School_Management.Service.Employee.Interface.ICountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {
    private final ICountryRepository repository;


    @Autowired public CountryServiceImpl(ICountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Country save(Country country) {
        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);

    }
}
