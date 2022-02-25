package RetoFinal.back.repositories;

import RetoFinal.back.models.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long>{
    public abstract ToDoList findByToDoListId(Long id);

}