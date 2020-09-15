package com.ray.bootweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ray.bootweb.bean.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "maren", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "rakesh", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "maren", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
