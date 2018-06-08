package com.example.employee.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.service.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>();

	@GetMapping
	public List<Employee> findAll() {
		return employees;
	}

	@GetMapping("/{id}")
	public Employee findById(@RequestParam("id") Long id) {
		return employees.stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	@PostMapping
	public Employee add(@RequestBody Employee p) {
		p.setId((long) (employees.size() + 1));
		employees.add(p);
		return p;
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		List<Employee> p = employees.stream().filter(it -> it.getId().equals(id)).collect(Collectors.toList());
		employees.removeAll(p);
	}

	@PutMapping
	public void update(@RequestBody Employee p) {
		Employee person = employees.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
		employees.set(employees.indexOf(person), p);
	}
}
