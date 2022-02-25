package RetoFinal.back.controllers;

import RetoFinal.back.models.ToDoList;
import RetoFinal.back.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api")
public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping(path = "/all/lists")
    public ArrayList<ToDoList> findAllToDoLists(){
        return this.toDoListService.getAllToDoLists();
    }

    @GetMapping(path = "/list/{id}")
    public ToDoList findToDoList(@PathVariable("id") Long id){
        return this.toDoListService.getToDoListById(id);
    }

    @PostMapping(path = "/save/list")
    public ToDoList createToDoList(@RequestBody ToDoList toDoList){
        return this.toDoListService.saveToDoList(toDoList);
    }

    @DeleteMapping(path = "/delete/list/{id}")
    public void deleteToDoList(@PathVariable("id") Long id){
        this.toDoListService.deleteToDoList(id);
    }

    @PostMapping(path = "/save/ToDo/{id}/{name}/{completed}")
    public void createToDo(@PathVariable("id") Long id,
                                            @PathVariable("name") String name,
                                            @PathVariable("completed") String completed){
        this.toDoListService.insertToDo(id, name, completed);
    }

    @DeleteMapping(path = "/delete/ToDo/{id}/{name}")
    public void eraseToDo(@PathVariable("id") Long id,
                                            @PathVariable("name") String name){
        this.toDoListService.eraseToDo(id, name);
    }

}
