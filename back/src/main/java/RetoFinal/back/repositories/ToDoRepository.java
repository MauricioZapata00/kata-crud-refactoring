package RetoFinal.back.repositories;

import RetoFinal.back.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    public abstract ArrayList<ToDo> findAllByToDoId(Long id);
    //public abstract void deleteAllByToDoListsId(Long id);
}
