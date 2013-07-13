package com.ghsoft.treetask;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Task implements Serializable {
	
	private String name, description;
	private static final int maxNameLen = 80;
	private static final int maxDescriptionLen = 500;
	private Task parent;
	
	public Task(Task parent) {
		this.parent = parent;
	}

	public abstract int completion();
	public abstract boolean hasChildren();
	
	public void setName(String name) {
		if (name.length() <= maxNameLen) {
			this.name = name;
		}
	}
	
	public void setDescription(String description) {
		if (description.length() <= maxDescriptionLen) {
			this.description = description;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Task getParent() {
		return parent;
	}
	
	public void setParent(Task p) {
		this.parent = p;
	}
	
	public boolean isHead() {
		return parent == null;
	}
	
	public String getPath() {
		if (!isHead()) {
			return parent.getPath() + " > " + this.name;  
		}
		return this.name;
		
	}
	
	
	

}
