package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCounterService {

	private final CounterService counterService;

	@Autowired
	public EmployeeCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	public void countNewPersons() {
		this.counterService.increment("services.employee.add");
	}

	public void countDeletedPersons() {
		this.counterService.increment("services.employee.deleted");
	}

}
