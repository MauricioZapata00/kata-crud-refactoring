package RetoFinal.back.repositories;

import RetoFinal.back.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    public abstract ArrayList<ToDoList> findAllByToDoListId(Long id);

}
