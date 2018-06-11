package com.example.department.controller;

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

import com.example.department.model.Department;
import com.example.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping
	public List<Department> findAll() {
		// a simple comment about what this complicated method does
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Department findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Department add(@RequestBody Department p) {
		return service.add(p);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}

	@PutMapping
	public void update(@RequestBody Department p) {
		service.update(p);

	}
}
