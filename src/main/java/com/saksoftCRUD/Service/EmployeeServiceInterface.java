package com.saksoftCRUD.Service;

import java.util.List;

import com.saksoftCRUD.Entity.Employee;

public interface EmployeeServiceInterface {
	
	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);

}
