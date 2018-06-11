package com.example.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.department.model.Department;

@Service
public class DepartmentService {

	private List<Department> department = new ArrayList<>();

	public List<Department> findAll() {
		return department;
	}

	public Department findById(@RequestParam("id") Long id) {
		return department.stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	public Department add(@RequestBody Department p) {
		p.setId((long) (department.size() + 1));
		department.add(p);

		return p;
	}

	public void delete(@RequestParam("id") Long id) {
		List<Department> p = department.stream().filter(it -> it.getId().equals(id)).collect(Collectors.toList());
		department.removeAll(p);

	}

	public void update(@RequestBody Department p) {
		Department person = department.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
		department.set(department.indexOf(person), p);
	}

}
