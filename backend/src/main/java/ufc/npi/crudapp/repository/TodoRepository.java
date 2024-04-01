package ufc.npi.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufc.npi.crudapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    
}