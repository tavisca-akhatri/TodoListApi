package com.TodoListApi.TodoList;

public class TodoList {
	
	private long id;
	private String item;


	public TodoList() {
		
	}

	public TodoList(long id, String item) {
		super();
		this.id=id;
		this.item=item;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
