package com.saksoftCRUD.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoftCRUD.Entity.Employee;
import com.saksoftCRUD.Repository.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;

	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}
