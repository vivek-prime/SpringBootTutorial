package com.example.SpringBootTutorial.repository;

import com.example.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * first param - Entity Class, second param - data type of Primary key
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
