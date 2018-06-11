package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> findAll() {
		// a simple comment about what this complicated method does
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Employee findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Employee add(@RequestBody Employee p) {
		return service.add(p);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}

	@PutMapping
	public void update(@RequestBody Employee p) {
		service.update(p);

	}
}
