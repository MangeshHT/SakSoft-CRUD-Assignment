package com.saksoftCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saksoftCRUD.Entity.Employee;

public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {

}
