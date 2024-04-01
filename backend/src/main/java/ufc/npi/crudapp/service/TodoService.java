package ufc.npi.crudapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import ufc.npi.crudapp.model.Todo;
import ufc.npi.crudapp.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(@NotNull Todo todo) {
        if (todo != null){
            todoRepository.save(todo);
        }
        return list();
    }

    public List<Todo> list() {
        return todoRepository.findAll();
    }

    public List<Todo> update(@NotNull Todo todo) {
        if (todo != null)
            todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(@NotNull Long id) {
        if (id != null)
            todoRepository.deleteById(id);
        return list();
    }
}