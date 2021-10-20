package com.revature.models;

import java.time.LocalDate;

public class Task {
	
	private String name;
	private LocalDate dueDate;
	
	public Task() {
		super();

	}

	public Task(String name, LocalDate dueDate) {
		super();
		this.name = name;
		this.dueDate = dueDate;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", dueDate=" + dueDate + "]";
	}
}