package RetoFinal.back.services;

import RetoFinal.back.models.ToDoList;
import RetoFinal.back.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    public ArrayList<ToDoList> findAllToDoLists(){
        return (ArrayList<ToDoList>) this.toDoListRepository.findAll();
    }

    public ArrayList<ToDoList> findAllToDoListsById(Long id){
        return this.toDoListRepository.findAllByToDoListId(id);
    }

    public ToDoList saveToDoList(ToDoList toDoList){
        return this.toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Long id){
        this.toDoListRepository.deleteById(id);
    }
}
