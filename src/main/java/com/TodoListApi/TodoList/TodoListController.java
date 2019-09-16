package com.TodoListApi.TodoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController

public class TodoListController {

	@Autowired
	private TodoListService service;
	
	@RequestMapping("/todo")
	public List<TodoList> getList(){
		return service.getAllList();
	}
	
	@RequestMapping("/todo/{id}")
	public TodoList getTodo(@PathVariable long id){
		return service.getTodoItem(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/todo")
	public TodoList addTodo(@RequestBody TodoList list) {
		return service.addTodoItem(list);
    }
	
	@RequestMapping(method=RequestMethod.PUT, value="/todo/{id}")
	public TodoList updateTodo(@RequestBody TodoList list, @PathVariable long id) {
		return service.updateItem(id,list);
	}

	@RequestMapping(method=RequestMethod.DELETE , value="/todo/{id}")
	public void deleteTodo(@PathVariable long id) {
		 service.removeItem(id);
	}
}
