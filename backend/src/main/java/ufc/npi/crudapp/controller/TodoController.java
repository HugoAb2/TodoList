package ufc.npi.crudapp.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ufc.npi.crudapp.model.Todo;
import ufc.npi.crudapp.service.TodoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    List<Todo> create(@RequestBody String todoText) {
        long timestamp = Instant.now().toEpochMilli();
        Todo newTodo = new Todo(timestamp, todoText, false);
        return todoService.create(newTodo);
    }
    //curl -X POST -H "Content-Type: application/json" -d 'Minha descricao' "http://localhost:8080/todos"

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }
    //curl -s http://localhost:8080/todos | python3 -m json.tool

    @PutMapping
    List<Todo> update(@RequestBody long id, String description, Boolean done) {
        Todo todo = new Todo(id, description, done);
        return todoService.update(todo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}