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

    public ArrayList<ToDoList> getAllToDoLists(){
        return (ArrayList<ToDoList>) this.toDoListRepository.findAll();
    }

    public ToDoList getToDoListById(Long id){
        return this.toDoListRepository.findByToDoListId(id);
    }

    public ToDoList saveToDoList(ToDoList toDoList){
        return this.toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Long id){
        this.toDoListRepository.deleteById(id);
    }

    public void insertToDo(Long id, String name, String completed){
        ToDoList currToDoList = this.getToDoListById(id);
        currToDoList.insertToDo(name, completed);

    }

    public void eraseToDo(Long id, String name){
        ToDoList currToDoList = this.getToDoListById(id);
        currToDoList.eraseToDo(name);
    }
}
