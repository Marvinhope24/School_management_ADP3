package za.ac.cput.School_Management.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import za.ac.cput.School_Management.Domain.Name;

import java.util.Optional;

public interface iNameRepo extends JpaRepository<Name, String> {
}