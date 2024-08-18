package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Other methods...

    // Batch processing for bulk save
    @Transactional
    default void saveAllInBatch(List<Employee> employees) {
        EntityManager entityManager = getEntityManager();
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % 20 == 0) {  // Batch size
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    @PersistenceContext
    EntityManager getEntityManager();
}