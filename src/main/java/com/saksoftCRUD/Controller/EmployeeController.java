package com.saksoftCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saksoftCRUD.Converter.EmployeeConverter;
import com.saksoftCRUD.Dto.EmployeeDto;
import com.saksoftCRUD.Entity.Employee;
import com.saksoftCRUD.Service.EmployeeServiceInterface;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@Autowired
	private EmployeeConverter employeeConverter;

	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {

		Employee employee = employeeConverter.dtoToEntity(employeeDto);

		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		EmployeeDto entityToDtoEmp = employeeConverter.entityToDto(employeeSaved);
		return new ResponseEntity<EmployeeDto>(entityToDtoEmp, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployees();
		List<EmployeeDto> entityToDtoList = employeeConverter.entityToDto(listOfAllEmps);
		return new ResponseEntity<List<EmployeeDto>>(entityToDtoList, HttpStatus.OK);
	}

	@GetMapping("/emp/{empid}")
	public ResponseEntity<EmployeeDto> getEmpById(@PathVariable("empid") Long empidL) {

		Employee empRetrieved = employeeServiceInterface.getEmpById(empidL);
		EmployeeDto entityToDtoEmployee = employeeConverter.entityToDto(empRetrieved);
		return new ResponseEntity<EmployeeDto>(entityToDtoEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL) {

		employeeServiceInterface.deleteEmpById(empidL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		Employee employee = employeeConverter.dtoToEntity(employeeDto);
		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		EmployeeDto entityToDtoEmployeeDto = employeeConverter.entityToDto(employeeSaved);
		
		return new ResponseEntity<EmployeeDto>(entityToDtoEmployeeDto, HttpStatus.CREATED);
	}

}
