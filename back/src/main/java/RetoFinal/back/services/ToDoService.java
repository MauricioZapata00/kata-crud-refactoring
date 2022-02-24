package RetoFinal.back.services;

import RetoFinal.back.models.ToDo;
import RetoFinal.back.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    public ArrayList<ToDo> findToDosById(Long id){
        return  this.toDoRepository.findAllByToDoId(id);
    }

    public ArrayList<ToDo> findAllToDos(){
        return (ArrayList<ToDo>) this.toDoRepository.findAll();
    }

    public ToDo saveToDo(ToDo toDo){
        return this.toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id){
        this.toDoRepository.deleteById(id);
    }

    public void deleteAllToDosByToDoListId(Long id){
        this.toDoRepository.deleteAllByToDoListsId(id);
    }
}
