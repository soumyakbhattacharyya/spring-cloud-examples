package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeCounterService counterService;

	private List<Employee> employees = new ArrayList<>();

	public List<Employee> findAll() {
		return employees;
	}

	public Employee findById(@RequestParam("id") Long id) {
		return employees.stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	public Employee add(@RequestBody Employee p) {
		p.setId((long) (employees.size() + 1));
		employees.add(p);
		
		// increase the count
		counterService.countNewPersons();
		
		return p;
	}

	public void delete(@RequestParam("id") Long id) {
		List<Employee> p = employees.stream().filter(it -> it.getId().equals(id)).collect(Collectors.toList());
		employees.removeAll(p);
		
		// decrease the count
		counterService.countDeletedPersons();
	}

	public void update(@RequestBody Employee p) {
		Employee person = employees.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
		employees.set(employees.indexOf(person), p);
	}

}
