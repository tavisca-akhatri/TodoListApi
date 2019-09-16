package com.TodoListApi.TodoList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class TodoListService {
	
	private final AtomicLong counter = new AtomicLong();
	List<TodoList> todos = new ArrayList<TodoList>(Arrays.asList(
			new TodoList(counter.incrementAndGet(),"Wake Up"),
			new TodoList(counter.incrementAndGet(),"Jogging"),
			new TodoList(counter.incrementAndGet(),"Eat")
			));

	public List<TodoList> getAllList() {
		return todos;
	}

	public TodoList getTodoItem(long id) {
	   return todos.stream().filter(t -> t.getId() == (id)).findFirst().get();
	}

	public TodoList addTodoItem(TodoList list) {
		//System.out.println(todos.size()+1);
		list.setId(todos.size()+1);
		todos.add(list);
		return list;
	}

	public TodoList updateItem(long id, TodoList list) {
		for(int i = 0 ; i < todos.size() ; i++) {
			TodoList t = todos.get(i);
			if(t.getId()==(id)) {
				todos.set(i, list);
				//return list;
			}
		}
		return list;
    }

	public void removeItem(long id) {
		 todos.removeIf(t -> t.getId()==(id));
  }
}

