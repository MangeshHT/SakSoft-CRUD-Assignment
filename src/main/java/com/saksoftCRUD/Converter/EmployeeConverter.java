package com.saksoftCRUD.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.saksoftCRUD.Dto.EmployeeDto;
import com.saksoftCRUD.Entity.Employee;

@Component
public class EmployeeConverter {

	public EmployeeDto entityToDto(Employee employee) {
		EmployeeDto eDto = new EmployeeDto();
		eDto.setId(employee.getId());
		eDto.setFirstName(employee.getFirstName());
		eDto.setLastName(employee.getLastName());
		eDto.setEmail(employee.getEmail());
		eDto.setAge(employee.getAge());

		return eDto;

	}

	public List<EmployeeDto> entityToDto(List<Employee> employee) {
		return employee.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public Employee dtoToEntity(EmployeeDto empDto) {

		Employee employee = new Employee();
		employee.setId(empDto.getId());
		employee.setFirstName(empDto.getFirstName());
		employee.setLastName(empDto.getLastName());
		employee.setEmail(empDto.getEmail());
		employee.setAge(empDto.getAge());

		return employee;

	}

	public List<Employee> dtoToEntity(List<EmployeeDto> empDto) {

		return empDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

	}

}
